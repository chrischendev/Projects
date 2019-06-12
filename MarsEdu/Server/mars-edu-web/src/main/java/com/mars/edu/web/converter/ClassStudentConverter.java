package com.mars.edu.web.converter;

import com.mars.edu.web.locallibs.base.BaseConverter;
import com.mars.edu.web.model.orm.ClassStudentEntity;
import com.mars.edu.web.model.xio.ClassStudentXio;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 班级学生 数据转换器
 */
@Service
public class ClassStudentConverter implements BaseConverter<ClassStudentEntity, ClassStudentXio> {
    @Override
    public ClassStudentEntity createEntity() {
        return new ClassStudentEntity();
    }

    @Override
    public ClassStudentXio createDto() {
        return new ClassStudentXio();
    }

    @Override
    public ClassStudentEntity fromDto(ClassStudentXio dto) {
        if (null == dto) {
            return null;
        }
        ClassStudentEntity entity = createEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    @Override
    public ClassStudentXio toDto(ClassStudentEntity entity) {
        if (null == entity) {
            return null;
        }
        ClassStudentXio dto = createDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public List<ClassStudentEntity> fromDtoList(List<ClassStudentXio> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
            return Collections.EMPTY_LIST;
        }
        return dtoList.stream().map(dto -> fromDto(dto)).collect(Collectors.toList());
    }

    @Override
    public List<ClassStudentXio> toDtoList(List<ClassStudentEntity> entityList) {
        if (CollectionUtils.isEmpty(entityList)) {
            return Collections.EMPTY_LIST;
        }
        return entityList.stream().map(entity -> toDto(entity)).collect(Collectors.toList());
    }
}
