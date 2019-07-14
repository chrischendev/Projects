package com.mars.edu.web.locallibs.base;

import io.swagger.annotations.ApiOperation;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * create by: Chris Chan
 * create on: 2019/6/11 5:11
 * use for: xls导入导出api
 */
public interface BaseXlsApi<E, X, ID extends Serializable> {
    BaseXlsProcess<E, X, ID> getXlsService();

    /**
     * 导出所有数据
     * @param response
     * @return
     * @throws IOException
     * @throws IllegalAccessException
     */
    @GetMapping("/exportAll")
    @ApiOperation(value = "导出所有数据")
    default ResponseEntity<?> exportAll(HttpServletResponse response) throws IOException, IllegalAccessException {
        getXlsService().exportAll(response);
        return ResponseEntity.ok().build();
    }

    /**
     * 导出导入模版
     * @param response
     * @return
     * @throws IOException
     * @throws IllegalAccessException
     */
    @GetMapping("/exportTemplate")
    @ApiOperation(value = "导出导入模版")
    default ResponseEntity<?> exportTemplate(HttpServletResponse response) throws IOException, IllegalAccessException {
        getXlsService().exportTemplate(response);
        return ResponseEntity.ok().build();
    }

    /**
     * 导入
     * @param xlsxFile
     * @return
     * @throws IOException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    @PostMapping("/import")
    @ApiOperation(value = "导入")
    default ResponseEntity<?> importData(@RequestPart("file") MultipartFile xlsxFile) throws IOException, IllegalAccessException, InstantiationException, InvalidFormatException {
        return ResponseEntity.ok().body(getXlsService().importData(xlsxFile));
    }

}
