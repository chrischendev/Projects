package com.chris.school.model.xo;

import com.chris.framework.builder.annotation.ExpandField;
import lombok.Data;
import com.chris.school.model.orm.ResTypeEntity;
import lombok.AllArgsConstructor;
import com.chris.school.model.orm.ResEntity;
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
@Expand(baseEntity = ResEntity.class)
public class ResXo {
    private Integer id;
    private Integer resNo;
    private String links;
    @ExpandField(baseField="resTypeId")
    private ResTypeXo resType;
    private String description;
}