package com.mars.edu.web.config.enhance;

import java.lang.annotation.*;

/**
 * @author chrischan
 * create on 2019/7/12 14:01
 * use for:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface IncludeHeader {
}
