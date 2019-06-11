package com.chris.school.settings.swagger;

import com.chris.framework.builder.utils.MsgUtils;
import com.chris.school.settings.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * YuedaoApi
 * com.yuedao.config
 * Created by Chris Chen
 * 2017/9/21
 * Explain:Swagger2配置
 */
@Configuration
@EnableSwagger2
public class Swagger2Config extends WebMvcConfigurerAdapter {
    private static final String SWAGGER2_TITLE = "Chris学校管理系统示例数据接口系统";//标题
    private static final String SWAGGER2_SERVICE_URL = "https://www.baidu.com/";//网址
    private static final String SWAGGER2_AUTHOR = "Chris Chen";//作者
    private static final String SWAGGER2_CONTACT_URL = "http://blog.csdn.net/xxkalychen";//联系人url
    private static final String SWAGGER2_CONTACT_EMAIL = "chrischen2018@163.com";//联系人电子邮箱

//    @Autowired
//    MyProps myProps;
    @Autowired
    LoginInterceptor loginInterceptor;//拦截器，与swagger2无关，暂用

    private static final String SWAGGER2_DESCRIPTION = "● 为了便于前端调用做统一封装，所有的接口请求和返回均采用统一的自定义协议进行打包。<br>"
            + "● 本系统全部采用RequestBody模式，使用POST方式提交。<br>";

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.ydx.consumer.api"))
                .apis(RequestHandlerSelectors.basePackage("com.chris.school.api"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(SWAGGER2_TITLE)
                .description(SWAGGER2_DESCRIPTION)
                .termsOfServiceUrl(SWAGGER2_SERVICE_URL)
                .contact(new Contact(SWAGGER2_AUTHOR, SWAGGER2_CONTACT_URL, SWAGGER2_CONTACT_EMAIL))
//                .version(myProps.getVersion())
                .version("1.0")
                .build();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/swagger-*");
        super.addInterceptors(registry);
    }
}
