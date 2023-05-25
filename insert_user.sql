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

