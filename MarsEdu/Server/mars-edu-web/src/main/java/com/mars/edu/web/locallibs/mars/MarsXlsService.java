package com.mars.edu.web.locallibs.mars;

import com.mars.edu.web.locallibs.base.BaseXlsProcess;
import com.mars.edu.web.locallibs.model.DataSourceHandler;
import com.mars.edu.web.locallibs.model.XlsProcessHandler;
import org.springframework.transaction.annotation.Transactional;


/**
 * Create by Chris Chan
 * Create on 2019/6/11 9:37
 * Use for:
 */
@Transactional
public interface MarsXlsService<E, X> extends MarsBaseService<E>, BaseXlsProcess<E, X, Integer> {
    DataSourceHandlerBox<E, X> getDataSourceHandlerBox();

    @Override
    default DataSourceHandler<E, Integer> getDataSourceHandler() {
        return getDataSourceHandlerBox().getDataSourceHandler();
    }

    @Override
    default XlsProcessHandler<E, X, Integer> getXlsProcessHandler() {
        return getDataSourceHandlerBox().getXlsProcessHandler();
    }
}
