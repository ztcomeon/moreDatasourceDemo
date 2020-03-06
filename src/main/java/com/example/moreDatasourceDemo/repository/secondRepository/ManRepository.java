/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ManRepository
 * Author:   Administrator
 * Date:     2020-03-05 12:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.moreDatasourceDemo.repository.secondRepository;

import com.example.moreDatasourceDemo.entity.second.ManSecond;
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
@Repository("ManRepository")
public interface ManRepository extends JpaRepository<ManSecond, String>,
        JpaSpecificationExecutor<ManSecond> {

}