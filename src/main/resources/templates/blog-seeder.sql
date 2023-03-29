use Blogger;
INSERT INTO blogs(title, body,user_id) VALUES("this is my first title", "this is my first body",1),
                                     ("this is my second title", "this is my second body",1);

INSERT INTO users(email, password, username) VALUES("horacesmith26@gmail.com","lucky","lucky");

select * from blogs;
select * from users;

DELETE from users;



