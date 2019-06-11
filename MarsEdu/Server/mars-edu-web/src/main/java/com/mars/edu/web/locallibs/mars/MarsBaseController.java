package com.mars.edu.web.locallibs.mars;

import com.mars.edu.web.locallibs.base.BaseConverter;
import com.mars.edu.web.locallibs.base.BaseRepository;
import com.mars.edu.web.locallibs.base.BaseService;
import com.mars.edu.web.locallibs.base.BaseSwaggerController;
import com.mars.edu.web.locallibs.model.BusinessHandler;

/**
 * create by: Chris Chan
 * create on: 2019/6/11 5:17
 * use for: mars-edu基本controller
 */
public interface MarsBaseController<E, X> extends BaseSwaggerController<E, Integer>,
        XlsApi<E, X, Integer> {
    BusinessHandler<E, Integer, X> getBusinessHandler();

    @Override
    default BaseService<E, Integer, BaseRepository<E, Integer>> getService() {
        return getBusinessHandler().getService();
    }

    @Override
    default BaseService<E, Integer, BaseRepository<E, Integer>> getXlsService() {
        return getBusinessHandler().getService();
    }

    @Override
    default BaseConverter<E, X> getConverter() {
        return getBusinessHandler().getConverter();
    }

    @Override
    default Class<X> getDtoClass() {
        return getBusinessHandler().getXlsClass();
    }

}
