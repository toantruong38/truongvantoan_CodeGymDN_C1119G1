drop database if exists `case_study_db_truongVanToan`;
create database `case_study_db_truongVanToan`;

use `case_study_db_truongVanToan`;

CREATE TABLE IF NOT EXISTS `loai_dich_vu` (
    `id_loaidichvu` INT NOT NULL UNIQUE,
    `tenloaidichvu` NVARCHAR(45) NOT NULL,
    PRIMARY KEY (id_loaidichvu)
);
insert into `loai_dich_vu` values(1,'Dich vu vip');
insert into `loai_dich_vu` values(2,'Dich vu thuong');
insert into `loai_dich_vu` values(3,'Dich vu kem');

CREATE TABLE IF NOT EXISTS `dich_vu_di_kem` (
    `id_dichvudikem` INT NOT NULL UNIQUE,
    `tendichvudikem` NVARCHAR(45) NOT NULL,
    `gia` LONG NOT NULL,
    `donvi` NVARCHAR(30) NOT NULL,
    `trangthaikhadung` NVARCHAR(45) NOT NULL,
    PRIMARY KEY (`id_dichvudikem`)
);
insert into `dich_vu_di_kem` values(1,'May Giat',50000,'vnd','co');
insert into `dich_vu_di_kem` values(2,'Food',100000,'vnd','co');
insert into `dich_vu_di_kem` values(3,'Beer',50000,'vnd','co');

CREATE TABLE IF NOT EXISTS `vi_tri` (
    `id_vitri` INT NOT NULL UNIQUE,
    `tenvitri` NVARCHAR(45) NOT NULL,
    PRIMARY KEY (`id_vitri`)
);
insert into `vi_tri` values(1,'Giam doc');
insert into `vi_tri` values(2,'Pho giam doc');
insert into `vi_tri` values(3,'Truong phong');
insert into `vi_tri` values(4,'Quan ly');

CREATE TABLE IF NOT EXISTS `trinh_do` (
    `id_trinhdo` INT NOT NULL UNIQUE,
    `trinhdo` NVARCHAR(45) NOT NULL,
    PRIMARY KEY (`id_trinhdo`)
);
insert into `trinh_do` values(1,'Dai hoc');
insert into `trinh_do` values(2,'Cao dang');
insert into `trinh_do` values(3,'Cap 3');

CREATE TABLE IF NOT EXISTS `bo_phan` (
    `id_bophan` INT NOT NULL UNIQUE,
    `tenbophan` NVARCHAR(45) NOT NULL,
    PRIMARY KEY (`id_bophan`)
);
insert into `bo_phan` values(1,'quan ly');
insert into `bo_phan` values(2,'giam doc');
insert into `bo_phan` values(3,'nhan vien');

CREATE TABLE IF NOT EXISTS `loai_khach` (
    `id_loaikhach` INT NOT NULL UNIQUE,
    `tenloaikhach` NVARCHAR(45) NOT NULL,
    PRIMARY KEY (`id_loaikhach`)
);
insert into `loai_khach` values(1,'Vip');
insert into `loai_khach` values(2,'Diamond');
insert into `loai_khach` values(3,'Normal');

CREATE TABLE IF NOT EXISTS `kieu_thue` (
    `id_kieuthue` INT NOT NULL UNIQUE,
    `tenkieuthue` NVARCHAR(45) NOT NULL,
    `gia` LONG NOT NULL
);
insert into `kieu_thue` values(1,'Day',130000);
insert into `kieu_thue` values(2,'Month',150000000);
insert into `kieu_thue` values(3,'Year',2000000000);

CREATE TABLE IF NOT EXISTS `nhan_vien` (
    `id_nhanvien` INT NOT NULL UNIQUE,
    `hoten` NVARCHAR(50) NOT NULL,
    `id_vitri` INT NOT NULL,
    `id_trinhdo` INT NOT NULL,
    `id_bophan` INT NOT NULL,
    `ngaysinh` DATE NOT NULL,
    `so_cmtnd` VARCHAR(45) NOT NULL UNIQUE,
    `luong` LONG NOT NULL,
    `sdt` VARCHAR(45) NOT NULL UNIQUE,
    `email` VARCHAR(45) NOT NULL UNIQUE,
    `diachi` NVARCHAR(45) NOT NULL,
    FOREIGN KEY (`id_vitri`)
        REFERENCES `vi_tri` (`id_vitri`),
    FOREIGN KEY (`id_trinhdo`)
        REFERENCES `trinh_do` (`id_trinhdo`),
    FOREIGN KEY (`id_bophan`)
        REFERENCES `bo_phan` (`id_bophan`),
    PRIMARY KEY (`id_nhanvien`)
);
insert into `nhan_vien` values(1,'Chu Van Quyenh',1,1,1,'1978-12-03','123123123',12000000,'0912312312','quyenh_DVN@email.com','Ha Noi');
insert into `nhan_vien` values(2,'Trinh Ba Ham',2,2,2,'1950-03-02','321312312',24000000,'0812343321','baHam@mail.com','Ha Noi');
insert into `nhan_vien` values(3,'Hoang',3,2,3,'1999-02-01','456789123',9000000,'05123123123','aTun@email.com','Da Nang');
insert into `nhan_vien` values(4,'Tun',2,1,2,'1989-05-01','456786453',9000000,'05123123343','Tun@email.com','Da Nang');
insert into `nhan_vien` values(5,'Kinh',1,2,1,'1979-06-01','456787893',9000000,'05123127623','duongtang@email.com','Da Nang');

CREATE TABLE IF NOT EXISTS `khach_hang` (
    `id_khachhang` INT NOT NULL UNIQUE,
    `id_loaikhach` INT NOT NULL,
    `hoten` NVARCHAR(45) NOT NULL,
    `ngaysinh` DATE NOT NULL,
    `so_cmtnd` VARCHAR(45) NOT NULL UNIQUE,
    `sdt` VARCHAR(45) NOT NULL UNIQUE,
    `email` VARCHAR(45) NOT NULL UNIQUE,
    `diachi` NVARCHAR(45) NOT NULL,
    FOREIGN KEY (`id_loaikhach`)
        REFERENCES `loai_khach` (`id_loaikhach`),
    PRIMARY KEY (`id_khachhang`)
);
insert into `khach_hang` values(1,1,'Trinh Ba Thu','1989-05-31','456423098','051134141','bathu@mail.com','Lang Son');
insert into `khach_hang` values(2,1,'Ton That Dam','2018-02-27','432123756','09123123','thatDam@email.com','Da Nang');
insert into `khach_hang` values(3,1,'My Tam','1975-05-06','987987123','0909123145','myvl@mail.com','Quang Tri');
insert into `khach_hang` values(4,1,'Phan Dinh Phung','1985-05-06','987987124','090912311','phungc@mail.com','Quang Tri');
insert into `khach_hang` values(5,1,'Cuong Nguyen','1995-05-06','987987125','090912312','cugng@mail.com','Da Nang');

CREATE TABLE IF NOT EXISTS `dich_vu` (
    `id_dichvu` INT NOT NULL UNIQUE,
    `tendichvu` NVARCHAR(45) NOT NULL,
    `dientich` DOUBLE NOT NULL,
    `sotang` INT NOT NULL,
    `songuoitoida` INT NOT NULL,
    `chiphithue` LONG NOT NULL,
    `id_kieuthue` INT NOT NULL,
    `id_loaidichvu` INT NOT NULL,
    `trangthai` NVARCHAR(45),
    FOREIGN KEY (`id_kieuthue`)
        REFERENCES `kieu_thue` (`id_kieuthue`),
    FOREIGN KEY (`id_loaidichvu`)
        REFERENCES `loai_dich_vu` (`id_loaidichvu`),
    PRIMARY KEY (`id_dichvu`)
);
insert into `dich_vu` values(1,'Massage',13000,5,2,13000000,1,1,'unknown');
insert into `dich_vu` values(2,'ONS',14000,3,2,15000000,2,2,'unknown');
insert into `dich_vu` values(3,'Karaoke',13000,4,6,18000000,3,3,'unknown');

CREATE TABLE IF NOT EXISTS `hop_dong` (
    `id_hopdong` INT NOT NULL UNIQUE,
    `id_nhanvien` INT NOT NULL,
    `id_khachhang` INT NOT NULL,
    `id_dichvu` INT NOT NULL,
    `ngaylamhopdong` DATE NOT NULL,
    `ngayketthuc` DATE NOT NULL,
    `tiendatcoc` LONG NOT NULL,
    `tongtien` LONG NOT NULL,
    FOREIGN KEY (`id_nhanvien`)
        REFERENCES `nhan_vien` (`id_nhanvien`),
    FOREIGN KEY (`id_khachhang`)
        REFERENCES `khach_hang` (`id_khachhang`),
    FOREIGN KEY (`id_dichvu`)
        REFERENCES `dich_vu` (`id_dichvu`),
    PRIMARY KEY (`id_hopdong`)
);
insert into `hop_dong` values(1,1,1,1,'2020-01-16','2021-02-16',15000000,20000000);
insert into `hop_dong` values(2,2,2,2,'2020-02-17','2021-03-17',18000000,27000000);
insert into `hop_dong` values(3,3,3,3,'2020-03-18','2021-04-19',18000000,27000000);
insert into `hop_dong` values(4,4,3,3,'2020-03-18','2021-04-19',18000000,27000000);
insert into `hop_dong` values(5,5,4,3,'2020-03-18','2021-04-19',18000000,27000000);
insert into `hop_dong` values(6,5,4,3,'2020-03-18','2021-04-19',18000000,27000000);
insert into `hop_dong` values(7,5,4,3,'2018-03-18','2021-04-19',18000000,27000000);
insert into `hop_dong` values(8,5,4,3,'2020-03-18','2021-04-19',18000000,27000000);

CREATE TABLE IF NOT EXISTS `hop_dong_chi_tiet` (
    `id_hopdongchitiet` INT NOT NULL UNIQUE,
    `id_hopdong` INT NOT NULL,
    `id_dichvudikem` INT NOT NULL,
    `soluong` INT NOT NULL,
    FOREIGN KEY (`id_hopdong`)
        REFERENCES `hop_dong` (`id_hopdong`),
    FOREIGN KEY (`id_dichvudikem`)
        REFERENCES `dich_vu_di_kem` (`id_dichvudikem`),
    PRIMARY KEY (`id_hopdongchitiet`)
);
insert into `hop_dong_chi_tiet` values(1,1,1,6);
insert into `hop_dong_chi_tiet` values(2,2,2,7);
insert into `hop_dong_chi_tiet` values(3,3,3,8);
