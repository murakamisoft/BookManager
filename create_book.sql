
drop table book cascade;

create table book (
  book_id INT AUTO_INCREMENT not null comment '�{ID'
  , book_name VARCHAR(512) comment '�{����'
  , created_date DATETIME comment '�쐬��'
  , created_user VARCHAR(256) comment '�쐬��'
  , updated_date DATETIME comment '�X�V��'
  , updated_user VARCHAR(256) comment '�X�V��'
  , constraint book_PKC primary key (book_id)
) comment '�{' ;

