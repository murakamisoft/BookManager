delete 
from
    user; 

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
    , 'test'
    , now()
    , 'test'
) 
, 
values ( 
    'user'
    , '$2a$10$SJTWvNl16fCU7DaXtWC0DeN/A8IOakpCkWWNZ/FKRV2CHvWElQwMS'
    , now()
    , 'test'
    , now()
    , 'test'
); 

delete 
from
    bookmanager.book; 

insert 
into bookmanager.book( 
    user_id
    , book_id
    , book_name
    , created_date
    , created_user
    , updated_date
    , updated_user
) 
values (1, 1, 'abcの本', now(), 'test', now(), 'test')
, (1, 2, 'プログラミング本', now(), 'test', now(), 'test')
, (2, 1, '広辞苑', now(), 'test', now(), 'test')
, (2, 2, 'おもしろい小説', now(), 'test', now(), 'test');

