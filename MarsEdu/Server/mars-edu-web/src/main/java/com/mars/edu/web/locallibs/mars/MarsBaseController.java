package com.mars.edu.web.locallibs.mars;

import com.mars.edu.web.locallibs.base.BaseConverter;
import com.mars.edu.web.locallibs.base.BaseRepository;
import com.mars.edu.web.locallibs.base.BaseService;
import com.mars.edu.web.locallibs.base.BaseSwaggerController;
import com.mars.edu.web.locallibs.model.BusinessHandler;

import java.io.Serializable;

/**
 * create by: Chris Chan
 * create on: 2019/6/11 5:17
 * use for: mars-edu基本controller
 */
public interface MarsBaseController<E, ID extends Serializable, X> extends BaseSwaggerController<E, ID>,
        XlsApi<E, X, ID> {
    BusinessHandler<E, ID, X> getBusinessHandler();

    @Override
    default BaseService<E, ID, BaseRepository<E, ID>> getService() {
        return getBusinessHandler().getService();
    }

    @Override
    default BaseService<E, ID, BaseRepository<E, ID>> getXlsService() {
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
