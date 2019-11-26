package com.chris.sl.api;

import com.chris.sl.manager.DataManager;
import com.chris.sl.model.LoginUser;
import com.chris.sl.model.ScanCode;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.util.UUID;

/**
 * create by: Chris Chan
 * create on: 2019/10/2 11:11
 * use for: 接口
 */
@RestController
@RequestMapping("/api/user")
public class UserApi {
    /**
     * 登录 App调用
     * App扫描二维码之后，获得登录识别码，然后携带自己的帐号密码一起调用登录
     * 服务器在后台对三个信息进行验证，验证成功后把帐号放进登录呼叫池，等待前端下一次轮询
     *
     * @param username
     * @param password
     * @param code
     * @return
     */
    @GetMapping("/login")
    public Boolean login(String username, String password, String code) {
        //验证
        if (DataManager.verification(username, password, code)) {
            //占用
            DataManager.occLoginInfo(code, username);
            return true;
        }
        System.out.println("验证失败");
        return false;
    }

    /**
     * 获取扫描识别码 Web前端调用
     * 用于实现一个二维码
     * 同时服务器将这个二维码保存在数据库，同时设置好过期时间
     *
     * @return
     */
    @GetMapping("/getScanCode")
    public ScanCode getScanCode() {
        String code = UUID.randomUUID().toString();
        //添加到数据库
        DataManager.addLoginInfo(code);
        return new ScanCode(code);
    }

    /**
     * 询问登录 Web前端轮询
     * 1秒一次，后端根据code查看数据库，是否由用户绑定此code且通过了验证，等待登录
     * 如果成功，将用户名返回给前端
     *
     * @param code
     * @return
     */
    @GetMapping("/askLogin")
    public LoginUser askLogin(String code) {
        System.out.println(code);
        if (DataManager.checkOcc(code)) {
            return DataManager.getUserByCode(code);
        }
        return null;
    }

    /**
     * 获取扫描识别码流 Web前端调用
     * 后端生成图片，然后以流的形式传输给web前端
     *
     * @return
     */
    @GetMapping("/getScanCodeStream")
    public ResponseEntity getScanCodeStream(HttpServletResponse response) {
        //ScanCode scanCode = getScanCode();
        //String code = scanCode.getCode();

        response.setContentType("image/jpeg");

        File file = new File("D:\\temp\\file\\1.jpg");

        //复制流
        try {
            FileInputStream fis = new FileInputStream(file);
            ServletOutputStream os = response.getOutputStream();
            IOUtils.copy(fis, os);
            os.flush();
            os.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().build();
    }
}
