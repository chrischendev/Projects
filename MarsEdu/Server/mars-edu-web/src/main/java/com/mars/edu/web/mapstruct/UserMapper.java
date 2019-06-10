package com.mars.edu.web.mapstruct;

import com.mars.edu.web.locallibs.base.BaseMapStruct;
import com.mars.edu.web.model.orm.SysUserEntity;
import com.mars.edu.web.model.xio.UserXio;
import org.mapstruct.Mapper;

/**
 * Create by Chris Chan
 * Create on 2019/6/10 11:09
 * Use for: user 数据转换
 * @author chris
 */
@Mapper(componentModel = "spring", uses = {})
public interface UserMapper extends BaseMapStruct<SysUserEntity, UserXio> {

}
