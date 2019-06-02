# 创建学校管理school数据表
# 应该用ID关联还是应该用code关联，需要思考片刻
use db_mars_edu;

# 教职工
drop table if exists sch_staff;
create table if not exists sch_staff
(
  id                 int(10)     not null primary key auto_increment comment 'ID',
  school_id          int(10)     not null comment '学校ID 外键',
  first_name         varchar(4)  not null comment '姓',
  last_name          varchar(10) not null comment '名',
  level              tinyint(3) default 0 comment '级别 便于排序',
  identity_card_code varchar(18) comment '身份证号码',
  cell               varchar(11) comment '手机号码',
  email              varchar(128) comment '邮箱',
  qq_code            varchar(13) not null comment 'QQ',
  wechat_code        varchar(32) not null comment '微信',
  site_url           varchar(128) comment '个人主页',
  status             tinyint(1)  not null comment '逻辑删除标记'
);

# 年级
drop table if exists sch_grade;
create table if not exists sch_grade
(
  id          int(10)     not null primary key auto_increment comment 'ID',
  school_id   int(10)     not null comment '学校ID 外键',
  code        varchar(20) not null comment '年级编码',
  name        varchar(20) not null comment '年级名称',
  level       tinyint(3)  not null default 0 comment '级别 便于排序',
  manager_id  int(10) comment '管理员 外键',
  leader_id   int(10) comment '年级组长 外键',
  description varchar(20) comment '描述',
  status      tinyint(1)  not null default 0 comment '逻辑删除标记'
);

# 班级
drop table if exists sch_class;
create table if not exists sch_class
(
  id          int(10)     not null primary key auto_increment comment 'ID',
  grade_id    int(10)     not null comment '年级ID 外键',
  code        varchar(20) not null comment '班级编码',
  name        varchar(20) not null comment '班级名称',
  level       tinyint(3)  not null default 0 comment '级别 便于排序',
  manager_id  int(10) comment '班主任 外键',
  description varchar(20) comment '描述',
  status      tinyint(1)  not null default 0 comment '逻辑删除标记'
);

# 学生
drop table if exists sch_student;
create table if not exists sch_student
(
  id              int(10)     not null primary key auto_increment comment 'ID',
  code            varchar(20) comment '学生编码',
  first_name      varchar(4)  not null comment '姓',
  last_name       varchar(10) not null comment '名',
  age             tinyint(3) comment '年龄',
  address         varchar(128) comment '地址',
  custodian_name  varchar(20) comment '监护人姓名',
  custodian_phone varchar(20) comment '监护人电话',
  description     varchar(20) comment '描述',
  status          tinyint(1)  not null default 0 comment '逻辑删除标记'
);

# 班级学生 关联表
drop table if exists sch_class_student;
create table if not exists sch_class_student
(
  id         int(10)    not null primary key auto_increment comment 'ID',
  class_id   int(10)    not null comment '班级ID 外键',
  student_id int(10)    not null comment '学生ID 外键',
  status     tinyint(1) not null default 0 comment '逻辑删除标记'
);

# 学科 sass 每个学校有自己的学科计划
drop table if exists sch_subject;
create table if not exists sch_subject
(
  id        int(10)     not null primary key auto_increment comment 'ID',
  school_id int(10)     not null comment '学校ID 外键',
  code      varchar(20) not null comment '学科编码',
  name      varchar(20) not null comment '学科名称',
  level     tinyint(2)  not null default 0 comment '级别 用于排序',
  status    tinyint(1)  not null default 0 comment '逻辑删除标记'
);

# 班级开课计划
drop table if exists sch_class_subject;
create table if not exists sch_class_subject
(
  id         int(10)    not null primary key auto_increment comment 'ID',
  class_id   int(10)    not null comment '班级（或年级）ID 外键',
  subject_id int(10)    not null comment '学科ID(或编码) 外键',
  teacher_id int(10)    not null comment '任课教师ID 外键',
  status     tinyint(1) not null default 0 comment '逻辑删除标记'
);