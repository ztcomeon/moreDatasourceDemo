/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ManSecond
 * Author:   Administrator
 * Date:     2020-03-05 11:57
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.moreDatasourceDemo.entity.second;

import com.example.moreDatasourceDemo.entity.UuidEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020-03-05
 * @since 1.0.0
 */
@Entity
@Table(name = "man")
public class ManSecond extends UuidEntity {

    @Column(name = "name_")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}