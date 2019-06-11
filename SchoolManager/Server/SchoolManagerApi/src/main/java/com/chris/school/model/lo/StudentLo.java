package com.chris.school.model.lo;

import com.chris.framework.builder.annotation.ExpandField;
import lombok.Data;
import com.chris.school.model.orm.StuClassEntity;
import com.chris.school.model.orm.StudentEntity;
import com.chris.school.model.orm.UserInfoEntity;
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
@Expand(baseEntity = StudentEntity.class)
public class StudentLo {
    private Integer id;
    private String name;
    @ExpandField(baseField="stuClassId")
    private StuClassEntity stuClass;
    @ExpandField(baseField="userId")
    private UserInfoEntity user;
    private String description;
}