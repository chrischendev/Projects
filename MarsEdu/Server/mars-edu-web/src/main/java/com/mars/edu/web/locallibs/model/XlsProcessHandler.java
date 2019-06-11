package com.mars.edu.web.locallibs.model;

import com.mars.edu.web.locallibs.base.BaseConverter;
import com.mars.edu.web.locallibs.base.BaseService;

import java.io.Serializable;

/**
 * Create by Chris Chan
 * Create on 2019/6/11 9:42
 * Use for: xls业务处理工具持有者
 */
public class XlsProcessHandler<E, X, ID extends Serializable> {
    private BaseService<E, ID> xlsService;
    private BaseConverter<E, X> converter;
    private Class<X> dtoClass;

    public XlsProcessHandler() {
    }

    public XlsProcessHandler(BaseService<E, ID> xlsService, BaseConverter<E, X> converter, Class<X> dtoClass) {
        this.xlsService = xlsService;
        this.converter = converter;
        this.dtoClass = dtoClass;
    }

    public BaseService<E, ID> getXlsService() {
        return xlsService;
    }

    public void setXlsService(BaseService<E, ID> xlsService) {
        this.xlsService = xlsService;
    }

    public BaseConverter<E, X> getConverter() {
        return converter;
    }

    public void setConverter(BaseConverter<E, X> converter) {
        this.converter = converter;
    }

    public Class<X> getDtoClass() {
        return dtoClass;
    }

    public void setDtoClass(Class<X> dtoClass) {
        this.dtoClass = dtoClass;
    }
}
