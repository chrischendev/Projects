package com.mars.edu.web.locallibs.mars;

import com.mars.edu.web.locallibs.model.DataSourceHandler;
import com.mars.edu.web.locallibs.model.XlsProcessHandler;

/**
 * Create by Chris Chan
 * Create on 2019/6/11 10:32
 * Use for:
 */
public class DataSourceHandlerBox<E, X> {
    private DataSourceHandler<E, Integer> dataSourceHandler;
    private XlsProcessHandler<E, X, Integer> xlsProcessHandler;

    public DataSourceHandlerBox() {
    }

    public DataSourceHandlerBox(DataSourceHandler<E, Integer> dataSourceHandler, XlsProcessHandler<E, X, Integer> xlsProcessHandler) {
        this.dataSourceHandler = dataSourceHandler;
        this.xlsProcessHandler = xlsProcessHandler;
    }

    public DataSourceHandler<E, Integer> getDataSourceHandler() {
        return dataSourceHandler;
    }

    public void setDataSourceHandler(DataSourceHandler<E, Integer> dataSourceHandler) {
        this.dataSourceHandler = dataSourceHandler;
    }

    public XlsProcessHandler<E, X, Integer> getXlsProcessHandler() {
        return xlsProcessHandler;
    }

    public void setXlsProcessHandler(XlsProcessHandler<E, X, Integer> xlsProcessHandler) {
        this.xlsProcessHandler = xlsProcessHandler;
    }
}
