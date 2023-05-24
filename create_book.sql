-- Project Name : bookmanager
-- Date/Time    : 2023/05/24 12:40:46
-- Author       : nori
-- RDBMS Type   : MySQL
-- Application  : A5:SQL Mk-2

/*
  << ���ӁI�I >>
  BackupToTempTable, RestoreFromTempTable�^�����߂��t������Ă��܂��B
  ����ɂ��Adrop table, create table ����f�[�^���c��܂��B
  ���̋@�\�͈ꎞ�I�� $$TableName �̂悤�Ȉꎞ�e�[�u�����쐬���܂��B
  ���̋@�\�� A5:SQL Mk-2�ł̂ݗL���ł��邱�Ƃɒ��ӂ��Ă��������B
*/

-- �{
--* BackupToTempTable
drop table book cascade;

--* RestoreFromTempTable
create table book (
  book_id INT AUTO_INCREMENT not null comment '�{ID'
  , book_name VARCHAR(512) comment '�{����'
  , created_date DATETIME comment '�쐬��'
  , created_user VARCHAR(256) comment '�쐬��'
  , updated_date DATETIME comment '�X�V��'
  , updated_user VARCHAR(256) comment '�X�V��'
  , constraint book_PKC primary key (book_id)
) comment '�{' ;

