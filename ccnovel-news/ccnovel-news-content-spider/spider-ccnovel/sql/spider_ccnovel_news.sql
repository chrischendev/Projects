# 创建数据库
create database if not exists spider_ccnovel_news;

# 选择数据库
use spider_ccnovel_news;

# 创建数据表

# 新闻类型
drop table if exists tb_news_type;
create table if not exists tb_news_type
(
  id          int primary key not null auto_increment comment 'ID',
  code        varchar(36)     not null comment '编码',
  name        varchar(128)    not null comment '标题',
  url         varchar(128)    not null comment '类型首页链接',
  description varchar(1024) comment '摘要',
  unique (code, name, url)
);

# 新闻
drop table if exists tb_news;
create table if not exists tb_news
(
  id               int primary key not null auto_increment comment 'ID',
  code             varchar(36)     not null comment '唯一编码',
  title            varchar(128)    not null comment '标题',
  url              varchar(128)    not null comment '链接',
  type             varchar(36)     not null comment '新闻类型 关联新闻类型中的code',
  image_main       varchar(128)    not null comment '主图',
  image_urls       varchar(1024)   not null comment '图片 用逗号分隔 西诺网新闻没有更多图片 把主图放进去',
  author           varchar(64)     not null comment '作者',
  source           varchar(64)     not null comment '来源',
  description      varchar(1024) comment '摘要',
  tags             varchar(1024) comment '标签 用逗号分隔',
  publish_time_str varchar(32) comment '发布时间 从西诺网取得的时间为倒推字符串',
  publish_time     datetime        not null default current_timestamp comment '发布时间 取爬取内容的时间',
  unique (url)
);

# 修改表 创建索引
alter table tb_news
  add index idx_url (url);

# 插入新闻类型数据 固定数据
insert tb_news_type(code, name, url, description)
VALUES ('HOME', '首页', 'http://www.ccnovel.com/', '发现首页有在其他类型中看不到的新闻'),
       ('TIE-IND', '网帖翻译-印度', 'http://www.ccnovel.com/tie/india/', '网帖翻译-印度'),
       ('TIE-AU', '网帖翻译-澳大利亚', 'http://www.ccnovel.com/tie/au/', '网帖翻译-澳大利亚'),
       ('TIE-VIE', '网帖翻译-越南', 'http://www.ccnovel.com/tie/vietnam/', '网帖翻译-越南'),
       ('TIE-FRA', '网帖翻译-法国', 'http://www.ccnovel.com/tie/france/', '网帖翻译-法国'),
       ('TIE-GER', '网帖翻译-德国', 'http://www.ccnovel.com/tie/germany/', '网帖翻译-德国'),
       ('TIE-PAK', '网帖翻译-巴基斯坦', 'http://www.ccnovel.com/tie/pakistan/', '网帖翻译-巴基斯坦'),
       ('TIE-RUS', '网帖翻译-俄罗斯', 'http://www.ccnovel.com/tie/russia/', '网帖翻译-俄罗斯'),
       ('TIE-JAP', '网帖翻译-日本', 'http://www.ccnovel.com/tie/japan/', '网帖翻译-日本'),
       ('TIE-SKO', '网帖翻译-韩国', 'http://www.ccnovel.com/tie/skorea/', '网帖翻译-韩国'),
       ('TIE-US', '网帖翻译-美国', 'http://www.ccnovel.com/tie/us/', '网帖翻译-美国'),
       ('TIE-UK', '网帖翻译-英国', 'http://www.ccnovel.com/tie/uk/', '网帖翻译-英国'),
       ('TIE-CAN', '网帖翻译-加拿大', 'http://www.ccnovel.com/tie/canada/', '网帖翻译-加拿大'),
       ('TIE-OTHERS', '网帖翻译-其他', 'http://www.ccnovel.com/tie/others/', '网帖翻译-其他'),
       ('OVERSEA', '海外看中国', 'http://www.ccnovel.com/oversea/', '海外看中国'),
       ('SOCIETY', '社会', 'http://www.ccnovel.com/society/', '社会'),
       ('BOLAN', '博览', 'http://www.ccnovel.com/bolan/', '博览'),
       ('JUNSHI', '军事', 'http://www.ccnovel.com/junshi/', '军事'),
       ('GUOJI', '国际', 'http://www.ccnovel.com/guoji/', '国际'),
       ('KEJI', '科技', 'http://www.ccnovel.com/keji/', '科技'),
       ('PROJECT', '工程', 'http://www.ccnovel.com/project/', '工程'),
       ('NETIZEN', '网友评论', 'http://www.ccnovel.com/netizen/', '网友评论'),
       ('LAOWAI', '老外在中国', 'http://www.ccnovel.com/laowai/', '老外在中国'),
       ('YANGXIFU', '洋媳妇', 'http://www.ccnovel.com/yangxifu/', '洋媳妇'),
       ('NAVNEET', 'navneet', 'http://www.ccnovel.com/navneet/', 'navneet');