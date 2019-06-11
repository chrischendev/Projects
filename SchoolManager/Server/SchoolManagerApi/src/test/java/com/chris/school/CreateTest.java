package com.chris.school;

import com.chris.framework.builder.model.EntityBuildParams;
import com.chris.framework.builder.model.OneKeyParams;
import com.chris.framework.builder.model.XObjBuildParams;
import com.chris.framework.builder.utils.DatabaseUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.util.Map;

public class CreateTest {

    private static String[][] TABLE_DICT={
            {"admin","管理员"},{"articlecomment","文章评论"},{"article","文章"},{"chatgroupmember","聊天群成员"},{"chatgroup","聊天群"},
            {"chathistory","聊天记录"},{"chatgrouplevel","聊天室级别"},{"chatgrouptype","聊天室类型"},{"grade","年级"},{"res","资源"},
            {"restype","资源类型"},{"school","学校"},{"score","成绩"},{"stuclass","班级"},{"subject","学科"},
            {"student","学生"},{"sysparams","系统参数"},{"teacher","教师"},{"teacherteach","授课教师"},{"userauth","登录用户"},
            {"userinfo","用户信息"},{"userrole","用户角色"}
    };

    public static void main(String[] args) {
        String dbDriver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://10.16.17.60:3307/db_chris_school";
        String username = "root";
        String password = "root";
        Connection connection = DatabaseUtils.getConnection(dbDriver, url, username, password);
//        createXo(connection);
        createController();
    }

    //创建实体类
    private static void createEntity(Connection connection) {
        EntityBuildParams buildParams = EntityBuildParams.get() //获取实例
                .setConnection(connection) //网络连接
                .setOrmPackageName("com.chris.school.model.orm") //存放实体类的包名
                .setOrmExt("Entity") //给实体类设定的后缀
                .setFieldModifier("private") //字段的访问修饰符，默认为public
                .addTableNameReplaces("tb_", "") //数据表名多余字符的替换集合
                .addIptAnnoMap(Data.class) //加于类的注解
                .addIptAnnoMap(NoArgsConstructor.class)
                .addIptAnnoMap(AllArgsConstructor.class)
                .setParseTimeStamp(false); //是否把TimeStamp类型解析为Long
        DatabaseUtils.createOrms(buildParams); //生成
    }

    private static void createXo(Connection connection) {
        XObjBuildParams params = XObjBuildParams.get()
                .setConnection(connection)
                .setOrmPackageName("com.chris.school.model.orm")
                .setxPackageName("com.chris.school.model.lo")
                .setOrmExt("Entity") //类名后缀
                .setxClassExt("Lo") //扩展类名后缀
                .setxFieldExt("Entity")
                .addIptAnnoMap(Data.class)
                .addIptAnnoMap(NoArgsConstructor.class)
                .addIptAnnoMap(AllArgsConstructor.class)
                .setFieldModifier("private"); //字段扩展时字段类型的后缀
        DatabaseUtils.createXObjs(params);
    }

    private static void createDao() {
        OneKeyParams.get()
                .setOrmPackageName("com.chris.school.model.orm")
                .setOrmExt("Entity")
                .setTempletePackage("com.chris.school.dao")
                .setTempleteFileName("AdminRepository.java")
                .setTargetPackage("com.chris.school.dao")
                .setTargetFileExt("Repository")
                .setClassPlaceHolder("Admin")
                .setClassTags(TABLE_DICT)
                .setClassTagPlaceHolder("管理员")
                .create();

    }

    private static void createService() {
        OneKeyParams.get()
                .setOrmPackageName("com.chris.school.model.orm")
                .setOrmExt("Entity")
                .setTempletePackage("com.chris.school.biz")
                .setTempleteFileName("AdminService.java")
                .setTargetPackage("com.chris.school.biz")
                .setTargetFileExt("Service")
                .setClassPlaceHolder("Admin")
                .setClassTags(TABLE_DICT)
                .setClassTagPlaceHolder("管理员")
                .create();
    }

    private static void createController() {
        OneKeyParams.get()
                .setOrmPackageName("com.chris.school.model.orm")
                .setOrmExt("Entity")
                .setTempletePackage("com.chris.school.api")
                .setTempleteFileName("AdminController.java")
                .setTargetPackage("com.chris.school.api")
                .setTargetFileExt("Controller")
                .setClassPlaceHolder("Admin")
                .setClassTags(TABLE_DICT)
                .setClassTagPlaceHolder("管理员")
                .create();
    }
}
