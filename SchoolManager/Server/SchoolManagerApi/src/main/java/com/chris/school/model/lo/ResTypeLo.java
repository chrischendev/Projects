package com.chris.school.model.lo;

import lombok.Data;
import com.chris.school.model.orm.ResTypeEntity;
import lombok.AllArgsConstructor;
import com.chris.framework.builder.annotation.Expand;
import lombok.NoArgsConstructor;

/**
 * App: ChrisApplication
 * Pkg: com.chris.school.model.lo
 * Author: Chris Chen
 * Time: 2018/07/03
 * Explain: 
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@Expand(baseEntity = ResTypeEntity.class)
public class ResTypeLo {
    private Integer id;
    private Integer resTypeNo;
    private String name;
    private String description;
}