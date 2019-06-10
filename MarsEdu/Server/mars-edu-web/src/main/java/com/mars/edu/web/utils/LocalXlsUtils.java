package com.mars.edu.web.utils;

import com.chris.poi.xls.XlsDataWorkBook;
import com.chris.servlet.poi.XlsIOUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Create by Chris Chan
 * Create on 2019/6/10 10:24
 * Use for:
 */
public class LocalXlsUtils {
    public static boolean writeToResponse(String fileName, HttpServletResponse response, XlsDataWorkBook xlsDataWorkBook) {
        try {
            return XlsIOUtils.writeToResponse(createExportFileName(fileName), response, xlsDataWorkBook);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 根据不同的模块创建导出文件名
     *
     * @param moduleStr
     * @return
     */
    public static String createExportFileName(String moduleStr) {
        String timeFmt = "yyyyMMddHHmmssSSS";
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat(timeFmt);

        sb.append("火星教育_")
                .append(moduleStr)
                .append("_")
                .append(sdf.format(new Date()))
                .append(".xls");
        return sb.toString();
    }
}
