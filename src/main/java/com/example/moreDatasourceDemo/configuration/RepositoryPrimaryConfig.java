package com.example.moreDatasourceDemo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryPrimary",//指定实体工厂
        transactionManagerRef = "transactionManagerPrimary",//指定事务工厂
        basePackages = {"com.example.moreDatasourceDemo.repository.firstRepository"}) //设置Repository所在位置
public class RepositoryPrimaryConfig {
    @Autowired
    @Qualifier("primaryDataSource")//按照类型注入，有多个DataSource，注解Qualifier指定使用名字为primaryDataSource的DataSource
    private DataSource primaryDataSource;
    @Autowired
    private JpaProperties jpaProperties;
    @Autowired
    private HibernateProperties hibernateProperties;

    //初始化实体工厂
    @Primary
    @Bean(name = "entityManagerFactoryPrimary")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary(
            EntityManagerFactoryBuilder builder) {
        //网上文章大多数都是jpaProperties.getHibernateProperties(dataSource);就直接得到了hibernate的配置map，
        //但这个方法在springboot2.0+好像就舍弃了，所以这里改成这样。
        Map<String, Object> properties = hibernateProperties.determineHibernateProperties(
                jpaProperties.getProperties(), new HibernateSettings());
        return builder.dataSource(primaryDataSource).properties(properties)
                .packages("com.example.moreDatasourceDemo.entity.first").build();//实体包路径
    }

    //初始化事务工厂
    @Primary
    @Bean(name = "transactionManagerPrimary")
    public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryPrimary(builder).getObject());
    }
}