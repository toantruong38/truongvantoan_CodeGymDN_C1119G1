insert into customer_type (name)
values ('Vip');
insert into customer_type (name)
values ('Diamond');
insert into customer_type (name)
values ('Silver');
insert into customer_type (name)
values ('Gold');
insert into customer_type (name)
values ('Normal');

insert into rent_type (name, price)
values ('Hour',300000);
insert into rent_type (name, price)
values ('Day',900000);
insert into rent_type (name, price)
values ('Week',1300000);
insert into rent_type (name, price)
values ('Month',50000000);
insert into rent_type (name, price)
values ('6 month',200000000);
insert into rent_type (name, price)
values ('1 Year',500000000);

insert into service_type (name)
values ('Villa');
insert into service_type (name)
values ('House');
insert into service_type (name)
values ('Room');

insert into accompany_service (currency, name, price)
values ('VND','Beer',50000);
insert into accompany_service (currency, name, price)
values ('VND','Rau muống xào tỏi',200000);
insert into accompany_service (currency, name, price)
values ('VND','Đậu hũ chiên',150000);
insert into accompany_service (currency, name, price)
values ('VND','Cá viên chiên',79000);
insert into accompany_service (currency, name, price)
values ('VND','Mỳ tôm Hảo Hảo',45000);
insert into accompany_service (currency, name, price)
values ('VND','Rượu nếp',230000);
insert into accompany_service (currency, name, price)
values ('VND','Thịt cầy',20000);
insert into accompany_service (currency, name, price)
values ('VND','Trẻ em nhúng ớt',500000);

insert into position (name)
values ('Lễ tân');
insert into position (name)
values ('Phục vụ');
insert into position (name)
values ('Chuyên viên');
insert into position (name)
values ('Giám sát');
insert into position (name)
values ('Quản lý');
insert into position (name)
values ('Giám đốc');

insert into part (name)
values ('Sale-Marketing');
insert into part (name)
values ('Hành chính');
insert into part (name)
values ('Phục vụ');
insert into part (name)
values ('Quản lý');

insert into degree (name)
values ('Vô học');
insert into degree (name)
values ('Giang hồ');
insert into degree (name)
values ('Trung cấp');
insert into degree (name)
values ('Cao đẳng');
insert into degree (name)
values ('Đại học');
insert into degree (name)
values ('Sau đại học');
insert into degree (name)
values ('Con cán bộ - Không cần học');

insert into service (area, floor_amount, free_accompany_service, maximum_people, other_convenience_description,
                     rent_fee, room_standard, status, rent_type_id, service_type_id)
values (10000,12,'Vợ',15,'Lắp thêm điều hòa',500000,'Vip','Available',1,1);
insert into service (area, floor_amount, free_accompany_service, maximum_people, other_convenience_description,
                     rent_fee, room_standard, status, rent_type_id, service_type_id)
values (10000,12,'Vợ',15,'Lắp thêm điều hòa',700000,'Vip','Available',2,1);
insert into service (area, floor_amount, free_accompany_service, maximum_people, other_convenience_description,
                     rent_fee, room_standard, status, rent_type_id, service_type_id)
values (10000,12,'Vợ',15,'Lắp thêm điều hòa',900000,'Vip','Available',3,1);
insert into service (area, floor_amount, free_accompany_service, maximum_people, other_convenience_description,
                     rent_fee, room_standard, status, rent_type_id, service_type_id)
values (7000,9,'Gái massage',10,'Thêm lò sưởi,gái dưới 20',500000,'Gold','Available',2,2);
insert into service (area, floor_amount, free_accompany_service, maximum_people, other_convenience_description,
                     rent_fee, room_standard, status, rent_type_id, service_type_id)
values (7000,9,'Gái massage',10,'Thêm lò sưởi,gái dưới 20',500000,'Gold','Available',3,2);
insert into service (area, floor_amount, free_accompany_service, maximum_people, other_convenience_description,
                     rent_fee, room_standard, status, rent_type_id, service_type_id)
values (7000,9,'Gái massage',10,'Thêm lò sưởi,gái dưới 20',500000,'Gold','Available',4,2);
insert into service (area, floor_amount, free_accompany_service, maximum_people, other_convenience_description,
                     rent_fee, room_standard, status, rent_type_id, service_type_id)
values (500,4,'10 thùng Tiger',5,'Cần có lò nướng,gia vị đầy đủ',350000,'Silver','Available',1,3);
insert into service (area, floor_amount, free_accompany_service, maximum_people, other_convenience_description,
                     rent_fee, room_standard, status, rent_type_id, service_type_id)
values (500,4,'10 thùng Tiger',5,'Cần có lò nướng,gia vị đầy đủ',350000,'Silver','Available',2,3);
insert into service (area, floor_amount, free_accompany_service, maximum_people, other_convenience_description,
                     rent_fee, room_standard, status, rent_type_id, service_type_id)
values (500,4,'10 thùng Tiger',5,'Cần có lò nướng,gia vị đầy đủ',350000,'Silver','Available',3,3);
insert into service (area, floor_amount, free_accompany_service, maximum_people, other_convenience_description,
                     rent_fee, room_standard, status, rent_type_id, service_type_id)
values (500,4,'10 thùng Tiger',5,'Cần có lò nướng,gia vị đầy đủ',350000,'Silver','Available',4,3);
insert into service (area, floor_amount, free_accompany_service, maximum_people, other_convenience_description,
                     rent_fee, room_standard, status, rent_type_id, service_type_id)
values (500,4,'10 thùng Tiger',5,'Cần có lò nướng,gia vị đầy đủ',350000,'Silver','Available',5,3);

insert into customer (address, birth, email, full_name, gender, id_number, phone_number, customer_type_id)
values ('23/7 Hùynh Tấn Phát, Q7','1975-03-13','hoanha@nidec-tosok.com.vn','Nguyễn Hoàn Hà','Nam','907997949','0907997949',1);
insert into customer (address, birth, email, full_name, gender, id_number, phone_number, customer_type_id)
values ('26C2 Hà Huy Giáp, P.Thạnh Lộc, Q.12','1976-08-16','nguyenngoctruc@yahoo.com','Nguyễn Ngọc Trúc','Nữ','903998755','0903998755',2);
insert into customer (address, birth, email, full_name, gender, id_number, phone_number, customer_type_id)
values ('2081/28 Phạm Thế Hiển, F6, Q8','1973-03-03','phamvannang@gmail.com','Phạm Văn Năng','Nam','903322554','0903322554',3);
insert into customer (address, birth, email, full_name, gender, id_number, phone_number, customer_type_id)
values ('362 CMT8 , F5, QT.Bình','1968-11-22','dtphuctri@yahoo.com','Đặng Thị Phúc','Nữ','903743914','0903743914',4);
insert into customer (address, birth, email, full_name, gender, id_number, phone_number, customer_type_id)
values ('L8, Diamond Plaza, 34 Lê Duẩn, Q1','1968-08-27','huyhoang92@hcm.vm.vn','Nguyễn Văn Thân','Nam','903703413','0903703413',5);
insert into customer (address, birth, email, full_name, gender, id_number, phone_number, customer_type_id)
values ('591 Xô Viết Nghệ Tĩnh, P.26, Q. Bình Thạnh','1962-03-22','nguyopat@hcm.vnn.vn','Nguyễn Thị Hồng','Nữ','903810003','0903810003',1);
insert into customer (address, birth, email, full_name, gender, id_number, phone_number, customer_type_id)
values ('138A Nguyễn văn Trỗi, Q.Phú Nhuận','1974-04-24','2628@hcm.vnn.vn','Huỳnh Ứng Liêm','Nam','903755118','0903755118',2);
insert into customer (address, birth, email, full_name, gender, id_number, phone_number, customer_type_id)
values ('33 Nguyễn Bỉnh Khiêm, Q.1','1972-09-25','bhoaviet@gmail.com','Bông Hoa Việt','Nam','913749817','0913749817',3);
insert into customer (address, birth, email, full_name, gender, id_number, phone_number, customer_type_id)
values ('11A Đường 83, P.Tân Qui, Q7_Tp.HCM','1971-03-24','hoang.huy@hcm.fpt.vn','Hoàng Việt Quang Huy','Nam','903758575','0903758575',4);
insert into customer (address, birth, email, full_name, gender, id_number, phone_number, customer_type_id)
values ('166A/25 Thích Quảng Đức, P4, Q.Phú Nhuận','1970-04-28','tqhuy288@yahoo.com','Trần Quang Huy','Nam','913909009','0913909009',5);
insert into customer (address, birth, email, full_name, gender, id_number, phone_number, customer_type_id)
values ('207 Lô A, C/c 675 Nguyễn Kiệm, P.9, Q.PN','1975-11-23','mylog75@yahoo.com','Trương Tiến Dũng','Nam','903774381','0903774381',1);
insert into customer (address, birth, email, full_name, gender, id_number, phone_number, customer_type_id)
values ('47 Cửu Long, P.2, Q. Tân Bình','1974-12-12','khanglt@yahoo.com','Lê Trọng Khang','Nam','908589596','0908589596',2);
insert into customer (address, birth, email, full_name, gender, id_number, phone_number, customer_type_id)
values ('254 Nguyễn Trãi, Q1','1975-05-23','levietthangvn@yahoo.com','Lê Việt Thắng','Nam','903666717','0903666717',3);
insert into customer (address, birth, email, full_name, gender, id_number, phone_number, customer_type_id)
values ('176 Hai Bà Trưng, Q.1','1967-10-10','bnqvn@yahoo.com','Bùi Ngọc Quang','Nam','903946484','0903946484',4);
insert into customer (address, birth, email, full_name, gender, id_number, phone_number, customer_type_id)
values ('107Liên Tỉnh 5, P5, Q8','1966-02-03','Havu90@yahooo.com','Vũ Thị Tuyết Hà','Nữ','918549645','0918549645',5);

insert into employee (address, birth, email, full_name, id_number, phone_number, salary, degree_id, part_id,
                      position_id)
values ('1/147A Nguyễn Văn Quá, P.Đông Hưng Thuận, Q.12','1953-01-02','newtedco@hcm.vnn.vn','Lê Văn Bình','913928085','0913928085',10000000,1,1,1);
insert into employee (address, birth, email, full_name, id_number, phone_number, salary, degree_id, part_id,
                      position_id)
values ('37 Trần Hưng Đạo, P. Tân Thành, Q. TP','1976-11-11','danhnd2007@yahoo.com','Đoàn Ngọc Danh','909223316','0909223316',12000000,2,2,2);
insert into employee (address, birth, email, full_name, id_number, phone_number, salary, degree_id, part_id,
                      position_id)
values ('68A Trần Quốc Toản, F8, Q3','1973-10-03','tqnhat@yahoo.com','Trương Quang Nhật','913731693','0913731693',12400000,3,3,3);
insert into employee (address, birth, email, full_name, id_number, phone_number, salary, degree_id, part_id,
                      position_id)
values ('304/54 Tân Kỳ,Tân Qúy,Sơn Kỳ,T.Phú','1971-03-22','haint71@gmail.com','Nguyễn Thanh Hải','903804735','0903804735',15000000,4,4,4);

