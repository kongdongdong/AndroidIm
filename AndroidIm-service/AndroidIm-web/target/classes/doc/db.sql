
/*
  用户表
*/
DROP TABLE IF EXISTS `im_users`;
CREATE TABLE `im_users` (
  `id`            int(15) NOT NULL AUTO_INCREMENT COMMENT 'id主键 不为空',
  `username`      varchar(32) NOT NULL UNIQUE COMMENT '用户名登录名 不为空 值唯一',
  `password`      varchar(32) NOT NULL UNIQUE COMMENT '密码 不为空 值唯一',
  `salt`          varchar(10) NOT NULL COMMENT '密码加盐md5加密 不为空',
  `nickname`      varchar(32) COMMENT '昵称 可为空',
  `sex`           varchar(10) COMMENT '性别 男m女w',
  `portrait`      text COMMENT '头像 可为空',
  `email`         text COMMENT '邮箱 可为空',
  `phone`         varchar(32) COMMENT '电话 可为空',
  `birthday`      datetime COMMENT '生日 可为空',
  `province`      varchar(32) COMMENT '省份id 与省份表关联 可为空',
  `city`          varchar(32) COMMENT '城市id 与城市表关联 可为空',
  `district`      varchar(32) COMMENT '城市id 与城市表关联 可为空',
  `address`       text COMMENT '地址 可为空',
  PRIMARY KEY (`id`)
) ENGINE=MYISAM DEFAULT CHARSET=utf8;
alter table im_users comment '用户表';

/*
  系统菜单表
*/
create table im_menu
(
   id                   int not null AUTO_INCREMENT comment '主键',
   menu_no              smallint UNIQUE comment '菜单编码 值唯一',
   menu_parent_no       smallint comment '父菜单编码',
   menu_order           smallint comment '菜单顺序',
   menu_name            varchar(32) comment '菜单名称',
   menu_url             text comment '菜单url',
   menu_type			      smallint default 1 comment '类型   1菜单  2 按钮或链接',
   menu_icon            text comment '菜单icon',
   is_visible           boolean comment '是否可用 1可用 0不可用',
   is_leaf              boolean comment '是否为子菜单',
   primary key (id)
)ENGINE= MYISAM CHARACTER SET utf8;
alter table im_menu comment '系统菜单表';

/*
  用户权限表
*/
create table im_privilege
(
   id                   int not null AUTO_INCREMENT comment '主键',
   user_id              varchar(32) NOT NULL COMMENT '用户名id与用户表的username关联 不为空 值唯一',
   menu_id              varchar(32) NOT NULL UNIQUE comment '菜单id与系统菜单表的menu_no关联 不为空 值唯一',
   primary key (id)
)ENGINE= MYISAM CHARACTER SET utf8;
alter table im_privilege comment '用户权限表';