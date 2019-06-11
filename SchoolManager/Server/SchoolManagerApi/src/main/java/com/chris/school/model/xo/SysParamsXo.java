package com.chris.school.model.xo;

import com.chris.school.model.orm.SysParamsEntity;
import lombok.Data;
import lombok.AllArgsConstructor;
import com.chris.framework.builder.annotation.Expand;
import lombok.NoArgsConstructor;

/**
 * App: ChrisApplication
 * Pkg: com.chris.school.model.xo
 * Author: Chris Chen
 * Time: 2018/07/03
 * Explain: 
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@Expand(baseEntity = SysParamsEntity.class)
public class SysParamsXo {
    private Integer id;
    private String name;
    private String value;
    private Integer level;
    private String description;
}