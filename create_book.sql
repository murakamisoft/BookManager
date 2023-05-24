-- Project Name : bookmanager
-- Date/Time    : 2023/05/24 12:40:46
-- Author       : nori
-- RDBMS Type   : MySQL
-- Application  : A5:SQL Mk-2

/*
  << 注意！！ >>
  BackupToTempTable, RestoreFromTempTable疑似命令が付加されています。
  これにより、drop table, create table 後もデータが残ります。
  この機能は一時的に $$TableName のような一時テーブルを作成します。
  この機能は A5:SQL Mk-2でのみ有効であることに注意してください。
*/

-- 本
--* BackupToTempTable
drop table book cascade;

--* RestoreFromTempTable
create table book (
  book_id INT AUTO_INCREMENT not null comment '本ID'
  , book_name VARCHAR(512) comment '本名称'
  , created_date DATETIME comment '作成日'
  , created_user VARCHAR(256) comment '作成者'
  , updated_date DATETIME comment '更新日'
  , updated_user VARCHAR(256) comment '更新者'
  , constraint book_PKC primary key (book_id)
) comment '本' ;

