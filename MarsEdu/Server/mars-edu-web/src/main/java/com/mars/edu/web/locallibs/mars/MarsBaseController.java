package com.mars.edu.web.locallibs.mars;

import com.mars.edu.web.locallibs.base.BaseService;
import com.mars.edu.web.locallibs.base.BaseSwaggerController;
import com.mars.edu.web.locallibs.base.BaseXlsProcess;
import com.mars.edu.web.locallibs.model.BusinessHandler;

/**
 * create by: Chris Chan
 * create on: 2019/6/11 5:17
 * use for: mars-edu基本controller
 */
public interface MarsBaseController<E, X> extends BaseSwaggerController<E, Integer>, MarsBaseXlsApi<E, X> {
    BusinessHandler<E, Integer, X> getBusinessHandler();

    @Override
    default BaseService<E, Integer> getService() {
        return getBusinessHandler().getService();
    }

    @Override
    default BaseXlsProcess<E, X, Integer> getXlsService() {
        return getBusinessHandler().getXlsService();
    }
}
