-- Project Name : bookmanager
-- Date/Time    : 2023/05/25 19:07:18
-- Author       : nori
-- RDBMS Type   : MySQL
-- Application  : A5:SQL Mk-2

drop table user cascade;

create table user (
  user_id INT AUTO_INCREMENT not null comment '���[�UID'
  , user_name VARCHAR(256) comment '���[�U��'
  , password VARCHAR(256) comment '�p�X���[�h'
  , created_date DATETIME comment '�쐬��'
  , created_user VARCHAR(256) comment '�쐬��'
  , updated_date DATETIME comment '�X�V��'
  , updated_user VARCHAR(256) comment '�X�V��'
  , constraint user_PKC primary key (user_id)
) comment '���[�U' ;

drop table book cascade;

create table book (
  user_id INT not null comment '���[�UID'
  , book_id INT not null comment '�{ID'
  , book_name VARCHAR(512) comment '�{����'
  , created_date DATETIME comment '�쐬��'
  , created_user VARCHAR(256) comment '�쐬��'
  , updated_date DATETIME comment '�X�V��'
  , updated_user VARCHAR(256) comment '�X�V��'
  , constraint book_PKC primary key (user_id,book_id)
) comment '�{' ;

