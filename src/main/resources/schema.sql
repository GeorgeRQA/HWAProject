drop table if exists supermarket CASCADE 
create table supermarket (id bigint auto_increment, name varchar(255), price double not null, quantity integer not null, primary key (id))