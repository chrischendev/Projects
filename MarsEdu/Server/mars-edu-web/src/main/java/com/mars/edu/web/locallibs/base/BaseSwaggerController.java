package com.mars.edu.web.locallibs.base;

import com.chris.poi.xls.XlsDataWorkBook;
import com.chris.poi.xls.XlsSheet;
import com.chris.servlet.poi.XlsIOUtils;
import com.google.gson.Gson;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 * create by: Chris Chan
 * create on: 2019/6/9 23:10
 * use for:
 * E ORM类
 * ID orm类的主键
 * X xls导入导出类型(这个实在没必要)
 * S service
 * C converter 数据转换器
 */
public interface BaseSwaggerController<E, ID extends Serializable, X, S extends BaseService, C extends BaseConverter<E, X>> {
    S getService();//业务层

    C getConverter();//转换器 这里特指orm和xio的转换器

    Class<X> getDtoClass();//dto类 这里特指xio类

    //增加
    @PostMapping("/add")
    @ApiOperation(value = "增加")
    default boolean add(@RequestBody E entity) {
        return getService().add(entity);
    }

    //删除
    @GetMapping("/deleteById")
    @ApiOperation(value = "获取所有数据")
    default boolean deleteById(ID id) {
        return getService().delete(id);
    }

    //修改
    @PostMapping("/update")
    @ApiOperation(value = "修改")
    default boolean update(@RequestBody E entity) {
        return getService().update(entity);
    }

    //根据Id获取数据
    @GetMapping("/findById")
    @ApiOperation(value = "根据Id获取数据")
    default E findById(ID id) {
        return (E) getService().findById(id);
    }

    //获取所有数据
    @GetMapping("/findAll")
    @ApiOperation(value = "获取所有数据")
    default List<E> findAll() {
        return getService().findAll();
    }

    //导出所有数据
    @GetMapping("/exportAll")
    @ApiOperation(value = "导出所有数据")
    default ResponseEntity<?> exportAll(HttpServletResponse response) throws IOException, IllegalAccessException {
        //获取所有数据
        List<E> entityList = getService().findAll();
        List<X> xioList = getConverter().toSameDtoList(entityList);
        System.out.println(new Gson().toJson(entityList));
        System.out.println(new Gson().toJson(xioList));
        Class<X> dtoClass = getDtoClass();
        XlsSheet xlsSheetAnno = dtoClass.getAnnotation(XlsSheet.class);
        String xlsSheetName = "未知数据表";
        if (null != xlsSheetAnno) {
            xlsSheetName = xlsSheetAnno.value();
        }
        XlsDataWorkBook workBook = XlsDataWorkBook.get().addDataList(dtoClass, xlsSheetName, xioList);
        XlsIOUtils.writeToResponse(xlsSheetName, response, workBook);
        return ResponseEntity.ok().build();
    }
}
