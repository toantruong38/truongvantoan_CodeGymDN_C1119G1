-- task 2
use `case_study_db`;

select *
from `nhan_vien`
where (hoten like 'H%'
	or hoten like 'K%'
    or hoten like 'T%') and length(hoten)<=15;

-- task3
select *
from `khach_hang`
where ((year(now())-year(ngaysinh)) between 18 and 50)
    and
    diachi in ('Da Nang','Quang Tri');

-- task4
SELECT  *,
	count(hd.id_hopdong) as 'so_lan'
FROM `khach_hang` kh
left join `hop_dong` hd
on kh.id_khachhang=hd.id_khachhang
where kh.id_loaikhach=1
group by kh.id_khachhang
order by so_lan asc;

-- task5
select kh.id_khachhang,
    kh.hoten,
    lk.tenloaikhach,
    hd.id_hopdong,
    dv.tendichvu,
    hd.ngaylamhopdong,
    hd.ngayketthuc,
    dv.chiphithue+hdct.soluong*dvdk.gia as 'Tong tien'
from `khach_hang` kh
join `loai_khach` lk on kh.id_loaikhach=lk.id_loaikhach
join `hop_dong` hd on kh.id_khachhang=hd.id_khachhang
join `dich_vu` dv on dv.id_dichvu=hd.id_dichvu
join `hop_dong_chi_tiet` hdct on hdct.id_hopdong=hd.id_hopdong
join `dich_vu_di_kem` dvdk on dvdk.id_dichvudikem=hdct.id_dichvudikem
;

-- task6
select 
	dv.id_dichvu,
    dv.tendichvu,
    dv.dientich,
    dv.chiphithue,
    ldv.tenloaidichvu
from `khach_hang` kh
join `hop_dong` hd on hd.id_khachhang=kh.id_khachhang
join `dich_vu` dv on dv.id_dichvu=hd.id_dichvu
join `loai_dich_vu` ldv on ldv.id_loaidichvu=dv.id_loaidichvu
where hd.ngaylamhopdong between '2018-12-31' and '2019-03-31';

-- task7
select dv.id_dichvu,
	dv.tendichvu,
    dv.dientich,
    dv.songuoitoida,
    dv.chiphithue,
    ldv.tenloaidichvu
from `dich_vu` dv
join `loai_dich_vu` ldv on dv.id_loaidichvu=ldv.id_loaidichvu
join `hop_dong` hd on hd.id_dichvu=dv.id_dichvu
where year(hd.ngaylamhopdong)='2018' and year(hd.ngaylamhopdong)!='2019';

-- task8
select kh.hoten
from `khach_hang` kh
group by kh.hoten;

select kh.hoten
from `khach_hang` kh
left join `khach_hang` kh2 on kh.hoten=kh2.hoten;

select kh.hoten
from `khach_hang` kh
right join `khach_hang` kh2 on kh.hoten=kh2.hoten;

-- task 9
select kh.hoten,
	count(kh.id_khachhang) as 'so luong'
from `khach_hang` kh
join `hop_dong` hd on hd.id_khachhang=kh.id_khachhang
group by kh.id_khachhang;

-- task 10
select hd.id_hopdong,
	hd.ngaylamhopdong,
	hd.ngayketthuc,
    hd.tiendatcoc,
    count(dvdk.id_dichvudikem) as 'So luong dich vu di kem'
from `hop_dong` hd
join `hop_dong_chi_tiet` hdct on hdct.id_hopdong=hd.id_hopdong
join `dich_vu_di_kem` dvdk on dvdk.id_dichvudikem=hdct.id_dichvudikem;

-- task 11
select *
from `khach_hang` kh
join `loai_khach` lk on lk.id_loaikhach=kh.id_loaikhach
where lk.tenloaikhach='Vip' and (kh.diachi='Vinh' or kh.diachi='Quang Ngai');

-- task 12
select hd.id_hopdong,
	nv.hoten,
    kh.hoten,
    kh.sdt,
    dv.tendichvu,
    count(hdct.id_hopdongchitiet) as 'So luong dich vu di kem',
    hd.tiendatcoc
from `hop_dong` hd
join `nhan_vien` nv using (id_nhanvien)
join `khach_hang` kh using (id_khachhang)
join `dich_vu` dv using (id_dichvu)
join `hop_dong_chi_tiet` hdct using(id_hopdong)
where year(hd.ngaylamhopdong)='2019' 
    and month(hd.ngaylamhopdong) in ('10','11','12')
    and month(hd.ngaylamhopdong) not in ('1','2','3','4','5','6');

-- task 13
select dvdk.id_dichvudikem,
        dvdk.tendichvudikem,
        dvdk.gia,
        dvdk.donvi,
        dvdk.trangthaikhadung,
        max(hd.id_khachhang) as 'So lan su dung'
from `dich_vu_di_kem` dvdk
join `hop_dong_chi_tiet` hdct using(id_dichvudikem)
join `hop_dong` hd using(id_hopdong)
join `khach_hang` kh using(id_khachhang);

-- task 14
select hdct.id_hopdong,
        ldv.tenloaidichvu,
        dvdk.tendichvudikem,
        count(hd.id_khachhang) as 'So lan'
from `dich_vu_di_kem` dvdk
join `hop_dong_chi_tiet` hdct using(id_dichvudikem)
join `hop_dong` hd using(id_hopdong)
join `dich_vu` dv using(id_dichvu)
join `loai_dich_vu` ldv using(id_loaidichvu)
where 'So lan'=1;

-- task 15
select nv.id_nhanvien,
        nv.hoten,
        td.trinhdo,
        bp.tenbophan,
        nv.sdt,
        nv.diachi,
        count(hd.id_nhanvien) as 'times'
from `nhan_vien` nv
join `trinh_do` td using (id_trinhdo)
join `bo_phan` bp using(id_bophan)
join `hop_dong` hd using (id_nhanvien)
where 'times' <=3 and year(hd.ngaylamhopdong) in ('2018','2019');

-- task 16
delete
from `hop_dong` hd
where count(hd.id_nhanvien)=0;










