package com.mars.edu.web.converter;

import com.mars.edu.web.locallibs.base.BaseConverter;
import com.mars.edu.web.model.orm.StudentEntity;
import com.mars.edu.web.model.xio.StudentXio;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create by Chris Chan
 * Create on 2019/6/12 9:18
 * Use for: 学生 数据转换器
 */
@Service
public class StudentConverter implements BaseConverter<StudentEntity, StudentXio> {
    @Override
    public StudentEntity createEntity() {
        return new StudentEntity();
    }

    @Override
    public StudentXio createDto() {
        return new StudentXio();
    }

    @Override
    public StudentEntity fromDto(StudentXio dto) {
        if (null == dto) {
            return null;
        }
        StudentEntity entity = createEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    @Override
    public StudentXio toDto(StudentEntity entity) {
        if (null == entity) {
            return null;
        }
        StudentXio dto = createDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public List<StudentEntity> fromDtoList(List<StudentXio> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
            return Collections.EMPTY_LIST;
        }
        return dtoList.stream().map(dto -> fromDto(dto)).collect(Collectors.toList());
    }

    @Override
    public List<StudentXio> toDtoList(List<StudentEntity> entityList) {
        if (CollectionUtils.isEmpty(entityList)) {
            return Collections.EMPTY_LIST;
        }
        return entityList.stream().map(entity -> toDto(entity)).collect(Collectors.toList());
    }
}
