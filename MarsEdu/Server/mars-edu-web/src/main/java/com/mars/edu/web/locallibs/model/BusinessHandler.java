package com.mars.edu.web.locallibs.model;

import com.mars.edu.web.locallibs.base.BaseService;
import com.mars.edu.web.locallibs.base.BaseXlsProcess;

import java.io.Serializable;

/**
 * create by: Chris Chan
 * create on: 2019/6/11 5:06
 * use for: 业务持有者
 */
public class BusinessHandler<E, ID extends Serializable, X> {
    private BaseService<E, ID> service;
    private BaseXlsProcess<E, X, ID> xlsService;

    public BusinessHandler() {
    }

    public BusinessHandler(BaseService<E, ID> service, BaseXlsProcess<E, X, ID> xlsService) {
        this.service = service;
        this.xlsService = xlsService;
    }

    public BaseService<E, ID> getService() {
        return service;
    }

    public void setService(BaseService<E, ID> service) {
        this.service = service;
    }

    public BaseXlsProcess<E, X, ID> getXlsService() {
        return xlsService;
    }

    public void setXlsService(BaseXlsProcess<E, X, ID> xlsService) {
        this.xlsService = xlsService;
    }
}
