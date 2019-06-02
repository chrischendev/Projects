# 创建系统数据表
use db_mars_edu;

# 超级管理员
drop table if exists sys_admin;
create table if not exists sys_admin
(
  id       int(10)      not null primary key auto_increment comment 'ID',
  name     varchar(20)  not null comment '用户名 可登录',
  cell     varchar(20)  not null comment '手机号 可登录',
  email    varchar(128) not null comment '邮箱 可登录',
  password varchar(20)  not null comment '密码 加密',
  status   tinyint(1)   not null default 0 comment '逻辑删除标记'
);

# 学校类型
drop table if exists sys_school_type;
create table if not exists sys_school_type
(
  id          int(10)     not null primary key auto_increment comment 'ID',
  code        tinyint(3)  not null comment '类型编码',
  name        varchar(32) not null comment '类型名称',
  level       tinyint(2)  not null default 0 comment '级别 便于排序',
  description varchar(128) comment '描述',
  status      tinyint(1)  not null default 0 comment '逻辑删除标记'
);

# 学校 不可以注册 由超级管理员添加
drop table if exists sys_school;
create table if not exists sys_school
(
  id           int(10)      not null primary key auto_increment comment 'ID',
  code         varchar(64)  not null comment '学校编码',
  name         varchar(128) not null comment '学校名称',
  school_type  int(10)      not null comment '学校类型 由专表维护 外键',
  email        varchar(128) comment '学校管理邮箱',
  address      varchar(128) comment '学校地址',
  reg_time     datetime              default current_timestamp comment '注册时间',
  active_time  datetime comment '激活时间',
  invalid_time datetime comment '服务到期时间',
  description  varchar(20) comment '描述',
  status       tinyint(1)   not null default 0 comment '逻辑删除标记'
);
# 学校详情 不可以注册 由超级管理员添加
drop table if exists sys_school_info;
create table if not exists sys_school_info
(
  id               int(10)    not null primary key auto_increment comment 'ID',
  school_id        int(10)    not null comment '学校ID 外键',
  area_code        varchar(6) comment '一级区域编码',
  area_name        varchar(6) comment '一级区域名称',
  second_area_code varchar(6) comment '二级区域编码',
  second_area_name varchar(6) comment '二级区域名称',
  third_area_code  varchar(6) comment '三级区域编码',
  third_area_name  varchar(6) comment '三级区域名称',
  description      varchar(20) comment '描述',
  status           tinyint(1) not null default 0 comment '逻辑删除标记'
);
# 图片类型
drop table if exists sys_images_type;
create table if not exists sys_images_type
(
  id     int(10)     not null primary key auto_increment comment 'ID',
  code   tinyint(3)  not null comment '编码',
  name   varchar(32) not null comment '名称',
  status tinyint(1)  not null default 0 comment '逻辑删除标记'
);

# 学校图片
drop table if exists sys_school_images;
create table if not exists sys_school_images
(
  id        int(10)      not null primary key auto_increment comment 'ID',
  school_id int(10)      not null comment '学校ID 外键',
  url       tinyint(512) not null comment '图片Url',
  type      tinyint(1) comment '图片类型 主图 轮播图 缩略图',
  status    tinyint(1)   not null default 0 comment '逻辑删除标记'
);

# 学校 授权码 超级管理员添加学校之后 可以获取学校的授权码将其发送给学校 学校可以凭借该授权码注册其他用户
drop table if exists sys_school;
create table if not exists sys_school
(
  id        int(10)      not null primary key auto_increment comment 'ID',
  school_id int(10)      not null comment '学校ID 外键',
  auth_code varchar(128) not null comment '授权码 拥有授权码的学校才被激活',
  status    tinyint(1)   not null default 0 comment '逻辑删除标记'
);

# 用户 用户在学校之下 可以注册和登录
drop table if exists sys_user;
create table if not exists sys_user
(
  id        int(10)      not null primary key auto_increment comment 'ID',
  name      varchar(20)  not null comment '用户名 可登录',
  cell      varchar(20)  not null comment '手机号 可登录',
  email     varchar(128) not null comment '邮箱 可登录',
  password  varchar(20)  not null comment '密码 加密',
  school_id varchar(20)  not null comment '学校ID 外键',
  status    tinyint(1)   not null default 0 comment '逻辑删除标记'
);

# 用户详情
drop table if exists sys_user_info;
create table if not exists sys_user_info
(
  id                 int(10)      not null primary key auto_increment comment 'ID',
  user_id            int(10)      not null comment '用户ID 外键',
  nick_name          varchar(20)  not null comment '用户名 可登录',
  photo_url          varchar(512) not null comment '头像',
  gender             tinyint(1)   not null comment '性别',
  identity_card_code varchar(18)  not null comment '身份证号码',
  qq_code            varchar(13)  not null comment 'QQ',
  site_url           varchar(128) comment '个人主页',
  description        varchar(20) comment '描述',
  status             tinyint(1)   not null default 0 comment '逻辑删除标记'
);
