package com.mars.edu.web;

import com.chris.framework.builder.model.EntityBuildParams;
import com.chris.framework.builder.model.OneKeyParams;
import com.chris.framework.builder.model.XObjBuildParams;
import com.chris.framework.builder.utils.DatabaseUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.codec.binary.StringUtils;

import java.sql.Connection;

public class CreateTest {

    private static String[][] TABLE_DICT = {
            {"user", "用户"}, {"userRole", "用户角色关联"}, {"role", "角色"}, {"roleAuth", "角色权限关联"}, {"auth", "权限"},
            {"admin", "超级管理员"}, {"schoolClass", "班级"}, {"schoolGrade", "年级"}, {"classStudent", "班级学生"}, {"student", "学生"},
            {"classSubject", "班级开课计划"}, {"imagesType", "图片类型"}, {"schoolImages", "学校图片"}, {"schoolInfo", "学校信息"}, {"schoolType", "学校类型"},
            {"staff", "教职工"}, {"subject", "学科"}, {"school", "学校"}, {"userInfo", "用户信息"}
    };

    private static final String ORM_PACKAGE = "com.mars.edu.web.model.orm";
    private static final String ORM_EXT = "Entity";

    private static final String DAO_PACKAGE = "com.mars.edu.web.dao.repository";
    private static final String DAO_EXT = "Repository";

    private static final String SERVICE_PACKAGE = "com.mars.edu.web.service.main";
    private static final String SERVICE_EXT = "Service";

    private static final String CONTROLLER_PACKAGE = "com.mars.edu.web.api";
    private static final String CONTROLLER_EXT = "Controller";

    public static void main(String[] args) {
        String dbDriver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://10.16.17.60:3307/db_mars_edu";
        String username = "root";
        String password = "root";
        Connection connection = DatabaseUtils.getConnection(dbDriver, url, username, password);
//        createXo(connection);
        createController();
    }

    /**
     * 创建实体类
     * @param connection
     */
    private static void createEntity(Connection connection) {
        EntityBuildParams buildParams = EntityBuildParams.get() //获取实例
                .setConnection(connection) //网络连接
                .setOrmPackageName(ORM_PACKAGE) //存放实体类的包名
                .setOrmExt(ORM_EXT) //给实体类设定的后缀
                .setFieldModifier("private") //字段的访问修饰符，默认为public
                .addTableNameReplaces("tb_", "") //数据表名多余字符的替换集合
                .addIptAnnoMap(Data.class) //加于类的注解
                .addIptAnnoMap(NoArgsConstructor.class)
                .addIptAnnoMap(AllArgsConstructor.class)
                .setParseTimeStamp(false); //是否把TimeStamp类型解析为Long
        DatabaseUtils.createOrms(buildParams); //生成
    }

    /**
     * 创建扩展数据类型
     * @param connection
     */
    private static void createXo(Connection connection) {
        XObjBuildParams params = XObjBuildParams.get()
                .setConnection(connection)
                .setOrmPackageName(ORM_PACKAGE)
                .setxPackageName("com.chris.school.model.lo")
                .setOrmExt(ORM_EXT) //类名后缀
                .setxClassExt("Lo") //扩展类名后缀
                .setxFieldExt("Entity")
                .addIptAnnoMap(Data.class)
                .addIptAnnoMap(NoArgsConstructor.class)
                .addIptAnnoMap(AllArgsConstructor.class)
                .setFieldModifier("private"); //字段扩展时字段类型的后缀
        DatabaseUtils.createXObjs(params);
    }

    /**
     * 生成其他具有相同内容的类
     */
    private static void createOtherSameClass() {
        OneKeyParams.get()
                .setOrmPackageName(ORM_PACKAGE)
                .setOrmExt(ORM_EXT)
                .setTempletePackage("com.mars.edu.web.converter")
                .setTempleteFileName("UserConverter.java")
                .setTargetPackage("com.mars.edu.web.converter")
                .setTargetFileExt("Converter")
                .setClassPlaceHolder("User")
                .setClassTags(TABLE_DICT)
                .setClassTagPlaceHolder("用户")
                .create();

    }

    /**
     * 生成dao
     */
    private static void createDao() {
        OneKeyParams.get()
                .setOrmPackageName(ORM_PACKAGE)
                .setOrmExt(ORM_EXT)
                .setTempletePackage(DAO_PACKAGE)
                .setTempleteFileName("UserRepository.java")
                .setTargetPackage(DAO_PACKAGE)
                .setTargetFileExt(DAO_EXT)
                .setClassPlaceHolder("User")
                .setClassTags(TABLE_DICT)
                .setClassTagPlaceHolder("用户")
                .create();

    }

    /**
     * 生成service
     */
    private static void createService() {
        OneKeyParams.get()
                .setOrmPackageName(ORM_PACKAGE)
                .setOrmExt(ORM_EXT)
                .setTempletePackage(SERVICE_PACKAGE)
                .setTempleteFileName("UserService.java")
                .setTargetPackage(SERVICE_PACKAGE)
                .setTargetFileExt(SERVICE_EXT)
                .setClassPlaceHolder("User")
                .setClassTags(TABLE_DICT)
                .setClassTagPlaceHolder("用户")
                .create();
    }

    /**
     * 生成controller
     */
    private static void createController() {
        OneKeyParams.get()
                .setOrmPackageName(ORM_PACKAGE)
                .setOrmExt(ORM_EXT)
                .setTempletePackage(CONTROLLER_PACKAGE)
                .setTempleteFileName("UserController.java")
                .setTargetPackage(CONTROLLER_PACKAGE)
                .setTargetFileExt(CONTROLLER_EXT)
                .setClassPlaceHolder("User")
                .setClassTags(TABLE_DICT)
                .setClassTagPlaceHolder("用户")
                .create();
    }
}
