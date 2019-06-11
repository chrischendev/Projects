package com.mars.edu.web.locallibs.mars;

import com.mars.edu.web.locallibs.model.DataSourceHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * create by: Chris Chan
 * create on: 2019/6/11 7:19
 * use for:
 */
public class DataSourceManager {
    private static Map<Class<?>, DataSourceHandler> map = new HashMap<>();
    private static DataSourceHandler[] dataSourceHandlers={
    };
}
