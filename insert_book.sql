delete from bookmanager.book;

insert into bookmanager.book(book_name,created_date,created_user,updated_date,updated_user) values 
    ('abcの本', now(), 'test', now(),'test')
  , ('プログラミング本', now(),'test', now(),'test')
  , ('広辞苑', now(),'test', now(),'test')
  , ('おもしろい小説', now(),'test', now(),'test');
