create table `contacts`
(
    contact_id int(11) not null auto_increment,
    last_name varchar(30) not null,
    first_name varchar(25),
    birthday date,
    constraint contacts_pk primary key(contact_id)
);

create table `suppliers`
(
    supplier_id int(11) not null auto_increment,
    supplier_name varchar(50) not null,
    account_rep varchar(30) not null default 'TBD',
    constraint suppliers_pk primary key(supplier_id)
);

drop table `customers`;

drop table `suppliers`;

alter table contacts
    add last_name varchar(40) not null
        after contact_id;

alter table contacts
    add last_name varchar(40) not null
        after contact_id,
    add first_name varchar(35) null
        after last_name;

alter table contacts
    modify last_name varchar(50) null;

alter table contacts
    drop column contact_type;

alter table contacts
    change column contact_type ctype
        varchar(20) not null;

alter table contacts
    rename to people;











