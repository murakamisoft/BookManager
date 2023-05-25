delete from user;

insert 
into bookmanager.`user`( 
    user_name
    , password
    , created_date
    , created_user
    , updated_date
    , updated_user
) 
values ( 
    'useradmin'
    , '$2a$10$SJTWvNl16fCU7DaXtWC0DeN/A8IOakpCkWWNZ/FKRV2CHvWElQwMS'
    , now()
    , 'useradmin'
    , now()
    , 'useradmin'
);

delete from bookmanager.book;

insert into bookmanager.book(user_id, book_id, book_name,created_date,created_user,updated_date,updated_user) values 
    (1, 10,'abcの本', now(), 'test', now(),'test')
  , (1, 20,'プログラミング本', now(),'test', now(),'test')
  , (1, 30,'広辞苑', now(),'test', now(),'test')
  , (1, 40,'おもしろい小説', now(),'test', now(),'test');
