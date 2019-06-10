package com.mars.edu.web.locallibs.model;

import com.mars.edu.web.locallibs.base.BaseConverter;
import com.mars.edu.web.locallibs.base.BaseRepository;
import com.mars.edu.web.locallibs.base.BaseService;

import java.io.Serializable;

/**
 * create by: Chris Chan
 * create on: 2019/6/11 5:06
 * use for: 业务持有者
 */
public class BusinessHandler<E, ID extends Serializable, X> {
    private BaseService<E, ID, BaseRepository<E, ID>> service;
    private Class<X> xlsClass;
    private BaseConverter<E, X> converter;

    public BusinessHandler() {
    }

    public BusinessHandler(BaseService<E, ID, BaseRepository<E, ID>> service, Class<X> xlsClass, BaseConverter<E, X> converter) {
        this.service = service;
        this.xlsClass = xlsClass;
        this.converter = converter;
    }

    public BaseService<E, ID, BaseRepository<E, ID>> getService() {
        return service;
    }

    public void setService(BaseService<E, ID, BaseRepository<E, ID>> service) {
        this.service = service;
    }

    public Class<X> getXlsClass() {
        return xlsClass;
    }

    public void setXlsClass(Class<X> xlsClass) {
        this.xlsClass = xlsClass;
    }

    public BaseConverter<E, X> getConverter() {
        return converter;
    }

    public void setConverter(BaseConverter<E, X> converter) {
        this.converter = converter;
    }
}
