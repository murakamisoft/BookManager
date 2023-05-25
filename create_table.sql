-- Project Name : bookmanager
-- Date/Time    : 2023/05/25 19:07:18
-- Author       : nori
-- RDBMS Type   : MySQL
-- Application  : A5:SQL Mk-2

drop table user cascade;

create table user (
  user_id INT AUTO_INCREMENT not null comment 'ユーザID'
  , user_name VARCHAR(256) comment 'ユーザ名'
  , password VARCHAR(256) comment 'パスワード'
  , created_date DATETIME comment '作成日'
  , created_user VARCHAR(256) comment '作成者'
  , updated_date DATETIME comment '更新日'
  , updated_user VARCHAR(256) comment '更新者'
  , constraint user_PKC primary key (user_id)
) comment 'ユーザ' ;

drop table book cascade;

create table book (
  user_id INT not null comment 'ユーザID'
  , book_id INT not null comment '本ID'
  , book_name VARCHAR(512) comment '本名称'
  , created_date DATETIME comment '作成日'
  , created_user VARCHAR(256) comment '作成者'
  , updated_date DATETIME comment '更新日'
  , updated_user VARCHAR(256) comment '更新者'
  , constraint book_PKC primary key (user_id,book_id)
) comment '本' ;

