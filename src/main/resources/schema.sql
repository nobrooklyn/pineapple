create table if not exists person (
  id varchar primary key,
  given_name varchar,
  family_name varchar,
  birthday date,
  sex tinyint,
  blood_type varchar 
);
