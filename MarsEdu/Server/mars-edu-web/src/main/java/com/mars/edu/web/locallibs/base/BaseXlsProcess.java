package com.mars.edu.web.locallibs.base;

import com.chris.poi.enums.XlsType;
import com.chris.poi.xls.XlsDataWorkBook;
import com.chris.poi.xls.XlsSheet;
import com.chris.poi.xls.XlsUtils;
import com.chris.servlet.poi.XlsIOUtils;
import com.mars.edu.web.locallibs.model.XlsProcessHandler;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * create by: Chris Chan
 * create on: 2019/6/11 5:11
 * use for: xls导入导出处理
 */
@Transactional
public interface BaseXlsProcess<E, X, ID extends Serializable> {
    XlsProcessHandler<E, X, ID> getXlsProcessHandler();

    /**
     * 导出所有数据
     *
     * @param response
     * @throws IOException
     * @throws IllegalAccessException
     */
    default void exportAll(HttpServletResponse response) throws IOException, IllegalAccessException {
        //获取所有数据
        List<E> entityList = getXlsProcessHandler().getXlsService().findAll();
        List<X> xioList = getXlsProcessHandler().getConverter().toSameDtoList(entityList);
        Class<X> dtoClass = getXlsProcessHandler().getDtoClass();
        XlsDataWorkBook workBook = XlsDataWorkBook.get().addDataList(dtoClass, getSheetName(dtoClass), xioList);
        XlsIOUtils.writeToResponse(getSheetName(dtoClass), response, workBook);
    }

    /**
     * 导出导入模版
     *
     * @param response
     * @throws IOException
     * @throws IllegalAccessException
     */
    default void exportTemplate(HttpServletResponse response) throws IOException, IllegalAccessException {
        //获取所有数据
        Class<X> dtoClass = getXlsProcessHandler().getDtoClass();
        XlsDataWorkBook workBook = XlsDataWorkBook.get().addDataList(dtoClass, getSheetName(dtoClass), Collections.EMPTY_LIST);
        XlsIOUtils.writeToResponse(getSheetName(dtoClass), XlsType.XLSX, response, workBook);
    }

    /**
     * 导入
     *
     * @param xlsxFile
     * @return
     * @throws IOException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    default Boolean importData(MultipartFile xlsxFile) throws IOException, IllegalAccessException, InstantiationException, InvalidFormatException {
        List<X> xioList = XlsUtils.readXlsxFromInputStream(xlsxFile.getInputStream(), getXlsProcessHandler().getDtoClass());
        List<E> entityList = getXlsProcessHandler().getConverter().fromSameDtoList(xioList);
        return getXlsProcessHandler().getXlsService().addBatch(entityList);
    }

    /**
     * 获取xls表名称
     *
     * @return
     */
    default String getSheetName(Class<X> dtoClass) {
        XlsSheet xlsSheetAnno = dtoClass.getAnnotation(XlsSheet.class);
        String xlsSheetName = "未知数据表";
        if (null != xlsSheetAnno) {
            xlsSheetName = xlsSheetAnno.value();
        }
        return xlsSheetName;
    }

}
