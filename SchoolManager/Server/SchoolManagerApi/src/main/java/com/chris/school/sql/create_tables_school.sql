# 学生成绩管理
use db_chris_school;
SET FOREIGN_KEY_CHECKS = 0; # 这一句可以忽略外键约束删除父表

# 管理员表
drop table if exists tb_admin;
create table if not exists tb_admin (
  id          int         not null primary key auto_increment,
  name        varchar(20) not null,
  cell        varchar(11),
  password    varchar(20),
  role        int, # 暂时只有一个角色
  description varchar(1024)

);
create index idx_admin_login
  on tb_admin (name, password); # 创建登录用的索引

# 系统参数表
drop table if exists tb_sys_params;
create table if not exists tb_sys_params (
  id          int         not null primary key auto_increment,
  name        varchar(32) not null, # 参数名
  value       varchar(256), # 参数值 限定512字节 太长的参数不在这里存放
  level       int, # 参数级别 如果有同名参数，用这个字段参考选择
  description varchar(1024) # 参数说明
);

# 资源类型表
drop table if exists tb_res_type;
create table if not exists tb_res_type (
  id          int    not null primary key auto_increment,
  res_type_no int(3) not null unique, # 资源类型编号
  name        varchar(64), # 资源名称
  description varchar(1024)
);

# 资源表 图片、音视频、文件链接管理
drop table if exists tb_res;
create table if not exists tb_res (
  id          int not null primary key auto_increment,
  res_no      int not null unique, # 资源编号 不能重复
  links       varchar(512), # 资源链接
  res_type_id int not null, # 资源类型id
  description varchar(1024) # 资源说明
);

# 用户 信息表
drop table if exists tb_user_info;
create table if not exists tb_user_info (
  id            int not null primary key auto_increment,
  last_name     varchar(20),
  first_name    varchar(20),
  nick_name     varchar(20), # 昵称
  gender        tinyint(1),
  address       varchar(256),
  email         varchar(128),
  qq_number     varchar(20),
  wechat_number varchar(20),
  description   varchar(2048)

);

# 用户 登录权限表
drop table if exists tb_user_auth;
create table if not exists tb_user_auth (
  id          int         not null primary key auto_increment,
  user_name   varchar(20),
  cell        varchar(11) not null,
  password    varchar(20) not null,
  user_id     int         not null, # 用户id
  role_id     int         not null, # 用户角色 影响使用权限
  reg_time    datetime    not null,
  description varchar(256)
);

# 用户角色表
drop table if exists tb_user_role;
create table if not exists tb_user_role (
  id          int not null primary key auto_increment,
  role_no     int not null unique, # 用户角色编号
  name        varchar(32), # 角色名称
  description varchar(128)
);

# 学校表
drop table if exists tb_school;
create table if not exists tb_school (
  id            int         not null primary key auto_increment,
  name          varchar(32) not null,
  address       varchar(256),
  headmaster_id int, # 校长 教师id
  description   varchar(2048) #可以考虑给学校添加一张信息表，存放丰富的学校信息
);

# 年级表
drop table if exists tb_grade;
create table if not exists tb_grade (
  id          int         not null primary key auto_increment,
  name        varchar(32) not null,
  school_id   int, # 学校id
  description varchar(1024)
);

# 班级表
drop table if exists tb_stu_class;
create table if not exists tb_stu_class (
  id            int         not null primary key auto_increment,
  name          varchar(32) not null,
  grade_id      int, # 年级id
  headmaster_id int, # 班主任的id
  description   varchar(1024)

);

# 教师表
drop table if exists tb_teacher;
create table if not exists tb_teacher (
  id          int         not null primary key auto_increment,
  name        varchar(20) not null,
  cell        varchar(11),
  gender      tinyint(1),
  user_id     int, # 用户id
  description varchar(1024)
);

# 教师任课表
drop table if exists tb_teacher_teach;
create table if not exists tb_teacher_teach (
  id          int not null primary key auto_increment,
  stu_class_id    int, # 班级id
  subject_id  int, # 科目id
  teacher_id  int, # 教师id
  description varchar(1024)
);

# 学生表
drop table if exists tb_student;
create table if not exists tb_student (
  id          int         not null primary key auto_increment,
  name        varchar(20) not null,
  stu_class_id    int, # 班级id
  user_id     int, # 用户id
  description varchar(1024)

);

# 科目表
drop table if exists tb_subject;
create table if not exists tb_subject (
  id          int not null primary key auto_increment,
  name        varchar(32),
  description varchar(256)
);

# 成绩表
drop table if exists tb_score;
create table if not exists tb_score (
  id         int not null primary key auto_increment,
  student_id int not null, # 学生id
  subject_id int not null, # 科目id
  score      int(3)
);

# 文章表
drop table if exists tb_article;
create table if not exists tb_article (
  id           int         not null primary key auto_increment,
  title        varchar(64) not null, # 文章标题
  author_id    int, # 作者 用户id
  author_name  varchar(64), # 作者 来源
  publish_time datetime, # 发布时间
  content      varchar(20480), # 文章内容 rich text 目前最大长度为21845
  link         varchar(128)# 相关链接
);

# 文章评论
drop table if exists tb_article_comment;
create table if not exists tb_article_comment (
  id         int not null primary key auto_increment,
  user_id    int, # 用户id
  user_name  varchar(64), # 如果用户不是登录用户，可填写姓名或者网名，不验证
  contact    varchar(64), # 评论者联系方式
  article_id int, # 文章 id
  content    varchar(512), # 512个字节的评论 rich text
  time       datetime, # 评论时间
  comment_id int, # 回复的评论id
  sort       int # 楼层顺序 可能无此必要
);

# 聊天群类型表
drop table if exists tb_chat_group_type;
create table if not exists tb_chat_group_type (
  id          int not null primary key auto_increment,
  type_no     int not null unique, # 类型编号
  name        varchar(32), # 类型名称
  description varchar(128)
);

# 聊天群级别表
drop table if exists tb_chat_group_level;
create table if not exists tb_chat_group_level (
  id          int not null primary key auto_increment,
  level_no    int not null unique,
  name        varchar(32),
  capacity    int not null, # 群容量 有新成员加入时要做验证
  description varchar(256)
);

# 聊天群表
drop table if exists tb_chat_group;
create table if not exists tb_chat_group (
  id          int not null primary key auto_increment,
  group_no    int not null unique, # 群号
  name        varchar(64), # 群名称
  owner_id    int, # 群主 用户id
  type_id     int, # 群类型
  level_id    int, # 群的级别
  time        datetime, # 群创建时间
  description varchar(1024) # 群简介
);

# 聊天群成员表
drop table if exists tb_chat_group_member;
create table if not exists tb_chat_group_member (
  id        int not null primary key auto_increment,
  user_id   int, # 用户id
  group_id  int, # 群id
  nick_name varchar(20), # 在群内的昵称
  level     int, # 在群里面的级别 暂时不关联外键
  time      timestamp # 加入时间
);

# 聊天记录表
drop table if exists tb_chat_history;
create table if not exists tb_chat_history (
  id          int not null primary key auto_increment,
  from_id     int not null, # 消息发送者 用户id
  to_id       int, # 私聊消息接收者 用户id
  to_group_id int, # 群消息接收者 群id
  type        int, # 聊天类型 私聊或者群聊 暂不关联外键
  content     varchar(1024) # 消息内容 rich text
);

# 操作日志表(...)

SET FOREIGN_KEY_CHECKS = 1; # 此时表已完全建立 不需要再作表删除操作，外键检查要恢复

################################### 创建外键约束 ######################################

# 资源表
alter table tb_res
  add
  constraint fk_res_type foreign key (res_type_id) references tb_res_type (id)
    on delete restrict
    on update cascade;

# 登录表
alter table tb_user_auth
  add
  constraint fk_auth_user foreign key (user_id) references tb_user_info (id)
    on delete restrict
    on update cascade,
  add
  constraint fk_auth_role foreign key (role_id) references tb_user_role (id)
    on delete restrict
    on update cascade;

# 学校表
alter table tb_school
  add
  constraint fk_school_headmaster foreign key (headmaster_id) references tb_teacher (id)
    on delete restrict
    on update cascade;

# 年级表
alter table tb_grade
  add
  constraint fk_grade_school foreign key (school_id) references tb_school (id)
    on delete restrict
    on update cascade;

# 班级表
alter table tb_stu_class
  add
  constraint fk_stu_class_headmaster foreign key (headmaster_id) references tb_teacher (id)
    on delete restrict # 删除策略 如果子表有引用，则不允许删除
    on update cascade, # 更新策略 如果子表有引用，则随之一同更新
  add
  constraint fk_stu_class_grade foreign key (grade_id) references tb_grade (id)
    on delete restrict
    on update cascade;

# 教师表
alter table tb_teacher
  add
  constraint fk_teacher_user foreign key (user_id) references tb_teacher (id)
    on delete restrict
    on update cascade;

# 教师任课表
alter table tb_teacher_teach
  add
  constraint fk_teach_class foreign key (stu_class_id) references tb_stu_class (id)
    on delete restrict
    on update cascade,
  add
  constraint fk_teach_subject foreign key (subject_id) references tb_subject (id)
    on delete restrict
    on update cascade,
  add
  constraint fk_teach_teacher foreign key (teacher_id) references tb_teacher (id)
    on delete restrict
    on update cascade;

# 学生表
alter table tb_student
  add
  constraint fk_stu_class foreign key (stu_class_id) references tb_stu_class (id)
    on delete restrict
    on update cascade,
  add
  constraint fk_stu_user foreign key (user_id) references tb_user_info (id)
    on delete restrict
    on update cascade;

# 成绩表
alter table tb_score
  add
  constraint fk_score_student foreign key (student_id) references tb_student (id)
    on delete restrict
    on update cascade,
  add
  constraint fk_score_subject foreign key (subject_id) references tb_subject (id)
    on delete restrict
    on update cascade;

# 文章表
alter table tb_article
  add
  constraint fk_art_user foreign key (author_id) references tb_user_info (id)
    on DELETE restrict
    on UPDATE cascade;

# 文章评论表
alter table tb_article_comment
  add
  constraint fk_comment_user foreign key (user_id) references tb_user_info (id)
    on DELETE restrict
    on UPDATE cascade,
  add
  constraint fk_comment_article foreign key (article_id) references tb_article (id)
    on DELETE restrict
    on UPDATE cascade,
  add
  constraint fk_comment_article_comment foreign key (comment_id) references tb_article_comment (id)
    on DELETE restrict
    on UPDATE cascade;

# 聊天群表
alter table tb_chat_group
  add
  constraint fk_chat_group_owner foreign key (owner_id) references tb_user_info (id)
    on DELETE restrict
    on UPDATE cascade,
  add
  constraint fk_chat_group_type foreign key (type_id) references tb_chat_group_type (id)
    on DELETE restrict
    on UPDATE cascade,
add
  constraint fk_chat_group_level foreign key (level_id) references tb_chat_group_level (id)
    on DELETE restrict
    on UPDATE cascade;

# 聊天群成员表
alter table tb_chat_group_member
  add
  constraint fk_chat_chat_group_member_user foreign key (user_id) references tb_user_info (id)
    on DELETE restrict
    on UPDATE cascade,
  add
  constraint fk_member_chat_group foreign key (group_id) references tb_chat_group (id)
    on DELETE restrict
    on UPDATE cascade;

# 聊天记录表
alter table tb_chat_history
  add
  constraint fk_chat_his_user_from foreign key (from_id) references tb_user_info (id)
    on DELETE restrict
    on UPDATE cascade,
  add
  constraint fk_chat_his_to_user foreign key (to_id) references tb_user_info (id)
    on DELETE restrict
    on UPDATE cascade,
  add
  constraint fk_chat_his_to_group foreign key (to_group_id) references tb_chat_group (id)
    on DELETE restrict
    on UPDATE cascade;