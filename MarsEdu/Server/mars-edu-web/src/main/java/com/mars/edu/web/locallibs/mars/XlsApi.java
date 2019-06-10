package com.mars.edu.web.locallibs.mars;

import com.chris.poi.xls.XlsDataWorkBook;
import com.chris.poi.xls.XlsSheet;
import com.chris.poi.xls.XlsUtils;
import com.chris.servlet.poi.XlsIOUtils;
import com.mars.edu.web.locallibs.base.BaseConverter;
import com.mars.edu.web.locallibs.base.BaseRepository;
import com.mars.edu.web.locallibs.base.BaseService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * create by: Chris Chan
 * create on: 2019/6/11 5:11
 * use for: xls导入导出api
 */
public interface XlsApi<E, X, ID extends Serializable> {
    BaseService<E, ID, BaseRepository<E, ID>> getXlsService();

    BaseConverter<E, X> getConverter();

    Class<X> getDtoClass();

    //导出所有数据
    @GetMapping("/exportAll")
    @ApiOperation(value = "导出所有数据")
    default ResponseEntity<?> exportAll(HttpServletResponse response) throws IOException, IllegalAccessException {
        //获取所有数据
        List<E> entityList = getXlsService().findAll();
        List<X> xioList = getConverter().toSameDtoList(entityList);
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

    //导出导入模版
    @GetMapping("/exportTemplate")
    @ApiOperation(value = "导出导入模版")
    default ResponseEntity<?> exportTemplate(HttpServletResponse response) throws IOException, IllegalAccessException {
        //获取所有数据
        Class<X> dtoClass = getDtoClass();
        XlsSheet xlsSheetAnno = dtoClass.getAnnotation(XlsSheet.class);
        String xlsSheetName = "未知数据表";
        if (null != xlsSheetAnno) {
            xlsSheetName = xlsSheetAnno.value();
        }
        XlsDataWorkBook workBook = XlsDataWorkBook.get().addDataList(dtoClass, xlsSheetName, Collections.EMPTY_LIST);
        XlsIOUtils.writeToResponse(xlsSheetName, response, workBook);
        return ResponseEntity.ok().build();
    }

    //导入
    @GetMapping("/import")
    @ApiOperation(value = "导入")
    default ResponseEntity<?> importData(@RequestPart("file") MultipartFile xlsxFile) throws IOException, IllegalAccessException, InstantiationException {
        List<X> xioList = XlsUtils.readXlsxFromInputStream(xlsxFile.getInputStream(), getDtoClass());
        List<E> entityList = getConverter().fromSameDtoList(xioList);
        boolean addBatch = getXlsService().addBatch(entityList);
        return ResponseEntity.ok().body(addBatch ? "import success." : "import failed.");
    }

}
