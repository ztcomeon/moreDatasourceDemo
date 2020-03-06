/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: PersonRepository
 * Author:   Administrator
 * Date:     2020-03-05 12:02
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.moreDatasourceDemo.repository.firstRepository;


import com.example.moreDatasourceDemo.entity.first.PersonFirst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020-03-05
 * @since 1.0.0
 */
@Repository("PersonRepository")
public interface PersonRepository extends JpaRepository<PersonFirst, String>,
        JpaSpecificationExecutor<PersonFirst> {

}