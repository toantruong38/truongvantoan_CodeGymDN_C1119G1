drop database if exists `case_study_db`;
create database `case_study_db`;

use `case_study_db`;

create table if not exists `loai_dich_vu`
(
    `id_loaidichvu` int not null unique,
    `tenloaidichvu` nvarchar(45) not null,

    primary key(id_loaidichvu)
);
insert into `loai_dich_vu` values(1,'Dich vu vip');
insert into `loai_dich_vu` values(2,'Dich vu thuong');
insert into `loai_dich_vu` values(3,'Dich vu kem');

create table if not exists `dich_vu_di_kem`
(
    `id_dichvudikem` int not null unique,
    `tendichvudikem` nvarchar(45) not null,
    `gia` long not null,
    `donvi` nvarchar(30) not null,
    `trangthaikhadung` nvarchar(45) not null,

    primary key(`id_dichvudikem`)
);
insert into `dich_vu_di_kem` values(1,'May Giat',50000,'vnd','co');
insert into `dich_vu_di_kem` values(2,'Food',100000,'vnd','co');
insert into `dich_vu_di_kem` values(3,'Beer',50000,'vnd','co');

create table if not exists `vi_tri`
(
    `id_vitri` int not null unique,
    `tenvitri` nvarchar(45) not null,

    primary key(`id_vitri`)
);
insert into `vi_tri` values(1,'Giam doc');
insert into `vi_tri` values(2,'Pho giam doc');
insert into `vi_tri` values(3,'Truong phong');
insert into `vi_tri` values(4,'Quan ly');

create table if not exists `trinh_do`
(

    `id_trinhdo` int not null unique,
    `trinhdo` nvarchar(45) not null,

    primary key(`id_trinhdo`)
);
insert into `trinh_do` values(1,'Dai hoc');
insert into `trinh_do` values(2,'Cao dang');
insert into `trinh_do` values(3,'Cap 3');

create table if not exists `bo_phan`
(
    `id_bophan` int not null unique,
    `tenbophan` nvarchar(45) not null,

    primary key(`id_bophan`)
);
insert into `bo_phan` values(1,'quan ly');
insert into `bo_phan` values(2,'giam doc');
insert into `bo_phan` values(3,'nhan vien');

create table if not exists `loai_khach`
(
    `id_loaikhach` int not null unique,
    `tenloaikhach` nvarchar(45) not null,

    primary key(`id_loaikhach`)
);
insert into `loai_khach` values(1,'Vip');
insert into `loai_khach` values(2,'Diamond');
insert into `loai_khach` values(3,'Normal');

create table if not exists `kieu_thue`
(
    `id_kieuthue` int not null unique,
    `tenkieuthue` nvarchar(45) not null,
    `gia` long not null
);
insert into `kieu_thue` values(1,'Day',130000);
insert into `kieu_thue` values(2,'Month',150000000);
insert into `kieu_thue` values(3,'Year',2000000000);

create table if not exists `nhan_vien`
(
	`id_nhanvien` int not null unique,
    `hoten` nvarchar(50) not null,
    `id_vitri` int not null,
    `id_trinhdo` int not null,
    `id_bophan` int not null,
    `ngaysinh` date not null,
    `so_cmtnd` varchar(45) not null unique,
    `luong` long not null,
    `sdt` varchar(45) not null unique,
    `email` varchar(45) not null unique,
    `diachi` nvarchar(45) not null,
    
    foreign key(`id_vitri`) references `vi_tri`(`id_vitri`),
    foreign key(`id_trinhdo`) references `trinh_do`(`id_trinhdo`),
    foreign key(`id_bophan`) references `bo_phan`(`id_bophan`),
    primary key(`id_nhanvien`)
);
insert into `nhan_vien` values(1,'Chu Van Quyenh',1,1,1,'1978-12-03','123123123',12000000,'0912312312','quyenh_DVN@email.com','Ha Noi');
insert into `nhan_vien` values(2,'Trinh Ba Ham',2,2,2,'1950-03-02','321312312',24000000,'0812343321','baHam@mail.com','Ha Noi');
insert into `nhan_vien` values(3,'Hoang',3,2,3,'1999-02-01','456789123',9000000,'05123123123','aTun@email.com','Da Nang');
insert into `nhan_vien` values(4,'Tun',2,1,2,'1989-05-01','456786453',9000000,'05123123343','Tun@email.com','Da Nang');
insert into `nhan_vien` values(5,'Kinh',1,2,1,'1979-06-01','456787893',9000000,'05123127623','duongtang@email.com','Da Nang');

create table if not exists `khach_hang`
(
	`id_khachhang` int not null unique,
    `id_loaikhach` int not null,
    `hoten` nvarchar(45) not null,
    `ngaysinh` date not null,
    `so_cmtnd` varchar(45) not null unique,
    `sdt` varchar(45) not null unique,
    `email` varchar(45) not null unique,
    `diachi` nvarchar(45) not null,

    foreign key(`id_loaikhach`) references `loai_khach`(`id_loaikhach`),
    primary key(`id_khachhang`)
);
insert into `khach_hang` values(1,1,'Trinh Ba Thu','1989-05-31','456423098','051134141','bathu@mail.com','Lang Son');
insert into `khach_hang` values(2,1,'Ton That Dam','2018-02-27','432123756','09123123','thatDam@email.com','Da Nang');
insert into `khach_hang` values(3,1,'My Tam','1975-05-06','987987123','0909123145','myvl@mail.com','Quang Tri');
insert into `khach_hang` values(4,1,'Phan Dinh Phung','1985-05-06','987987124','090912311','phungc@mail.com','Quang Tri');
insert into `khach_hang` values(5,1,'Cuong Nguyen','1995-05-06','987987125','090912312','cugng@mail.com','Da Nang');

create table if not exists `dich_vu`
(
	`id_dichvu` int not null unique,
    `tendichvu` nvarchar(45) not null,
    `dientich` double not null,
    `sotang` int not null,
    `songuoitoida` int not null,
    `chiphithue` long not null,
    `id_kieuthue` int not null,
    `id_loaidichvu` int not null,
    `trangthai` nvarchar(45),
    
    foreign key(`id_kieuthue`) references `kieu_thue`(`id_kieuthue`),
    foreign key(`id_loaidichvu`) references `loai_dich_vu`(`id_loaidichvu`),
    primary key(`id_dichvu`)
);
insert into `dich_vu` values(1,'Massage',13000,5,2,13000000,1,1,'unknown');
insert into `dich_vu` values(2,'ONS',14000,3,2,15000000,2,2,'unknown');
insert into `dich_vu` values(3,'Karaoke',13000,4,6,18000000,3,3,'unknown');

create table if not exists `hop_dong`
(
	`id_hopdong` int not null unique,
    `id_nhanvien` int not null,
    `id_khachhang` int not null,
    `id_dichvu` int not null,
    `ngaylamhopdong` date not null,
    `ngayketthuc` date not null,
    `tiendatcoc` long not null,
    `tongtien` long not null,
    
    foreign key(`id_nhanvien`) references `nhan_vien`(`id_nhanvien`),
    foreign key(`id_khachhang`) references `khach_hang`(`id_khachhang`),
    foreign key(`id_dichvu`) references `dich_vu`(`id_dichvu`),
    primary key(`id_hopdong`)
);
insert into `hop_dong` values(1,1,1,1,'2020-01-16','2021-02-16',15000000,20000000);
insert into `hop_dong` values(2,2,2,2,'2020-02-17','2021-03-17',18000000,27000000);
insert into `hop_dong` values(3,3,3,3,'2020-03-18','2021-04-19',18000000,27000000);
insert into `hop_dong` values(4,4,3,3,'2020-03-18','2021-04-19',18000000,27000000);
insert into `hop_dong` values(5,5,4,3,'2020-03-18','2021-04-19',18000000,27000000);
insert into `hop_dong` values(6,5,4,3,'2020-03-18','2021-04-19',18000000,27000000);
insert into `hop_dong` values(7,5,4,3,'2018-03-18','2021-04-19',18000000,27000000);
insert into `hop_dong` values(8,5,4,3,'2020-03-18','2021-04-19',18000000,27000000);

create table if not exists `hop_dong_chi_tiet`
(
	`id_hopdongchitiet` int not null unique,
    `id_hopdong` int not null,
    `id_dichvudikem` int not null,
    `soluong` int not null,

    foreign key(`id_hopdong`) references `hop_dong`(`id_hopdong`),
    foreign key(`id_dichvudikem`) references `dich_vu_di_kem`(`id_dichvudikem`),
    primary key(`id_hopdongchitiet`)
);
insert into `hop_dong_chi_tiet` values(1,1,1,6);
insert into `hop_dong_chi_tiet` values(2,2,2,7);
insert into `hop_dong_chi_tiet` values(3,3,3,8);
