
use `case_study_db_truongVanToan`;

-- task2;
SELECT 
    *
FROM
    `nhan_vien` nv
WHERE
    (nv.hoten LIKE 'H%' OR nv.hoten LIKE 'K%'
        OR nv.hoten LIKE 'T%')
        AND LENGTH(nv.hoten) <= 15;
        
-- task 3;
SELECT 
    *
FROM
    `khach_hang` kh
WHERE
    ((YEAR(NOW()) - YEAR(kh.ngaysinh)) BETWEEN 18 AND 50)
        AND (kh.diachi IN ('Da Nang' , 'Quang Tri'));
    
-- task 4;
SELECT 
    kh.hoten, COUNT(hd.id_hopdong) AS 'So lan dat phong'
FROM
    `khach_hang` kh
        INNER JOIN
    `hop_dong` hd USING (id_khachhang)
        INNER JOIN
    `loai_khach` lk USING (id_loaikhach)
WHERE
    lk.tenloaikhach = 'Vip'
GROUP BY kh.hoten
ORDER BY 'So lan dat phong';

-- task 5;
SELECT 
    kh.id_khachhang,
    kh.hoten,
    lk.tenloaikhach,
    hd.id_hopdong,
    dv.tendichvu,
    hd.ngaylamhopdong,
    hd.ngayketthuc,
    dv.chiphithue + hdct.soluong * dvdk.gia AS 'Tong tien'
FROM
    `khach_hang` kh
        LEFT JOIN
    `hop_dong` hd USING (id_khachhang)
        LEFT JOIN
    `loai_khach` lk USING (id_loaikhach)
        LEFT JOIN
    `dich_vu` dv USING (id_dichvu)
        LEFT JOIN
    `hop_dong_chi_tiet` hdct USING (id_hopdong)
        LEFT JOIN
    `dich_vu_di_kem` dvdk USING (id_dichvudikem);
    
-- task 6;
SELECT 
    dv.id_dichvu,
    dv.tendichvu,
    dv.dientich,
    dv.chiphithue,
    ldv.tenloaidichvu,
    hd.id_khachhang,
    hd.ngaylamhopdong
FROM
    `dich_vu` dv
        INNER JOIN
    `hop_dong` hd USING (id_dichvu)
        INNER JOIN
    `khach_hang` kh USING (id_khachhang)
        INNER JOIN
    `loai_dich_vu` ldv USING (id_loaidichvu)
WHERE
    !( MONTH(hd.ngaylamhopdong) IN ('1' , '2', '3')
        AND YEAR(hd.ngaylamhopdong) = '2019');

SELECT 
    dv.id_dichvu,
    dv.tendichvu,
    dv.dientich,
    dv.chiphithue,
    ldv.tenloaidichvu
FROM
    `dich_vu` dv
        INNER JOIN
    `loai_dich_vu` ldv USING (id_loaidichvu)
WHERE
    NOT EXISTS( SELECT 
            hd.id_hopdong
        FROM
            `hop_dong` hd
        WHERE
            (hd.ngaylamhopdong BETWEEN '2019-01-01' AND '2019-03-31')
                AND hd.id_dichvu = dv.id_dichvu);
                
                
-- task 7; >?<
SELECT 
    dv.id_dichvu,
    dv.tendichvu,
    dv.dientich,
    dv.songuoitoida,
    dv.chiphithue,
    ldv.tenloaidichvu,
    hd.ngaylamhopdong
FROM
    `dich_vu` dv
        INNER JOIN
    `loai_dich_vu` ldv USING (id_loaidichvu)
        INNER JOIN
    `hop_dong` hd USING (id_dichvu)
WHERE
    EXISTS( SELECT 
            dv.id_dichvu
        FROM
            `dich_vu` dv
                INNER JOIN
            `hop_dong` hd USING (id_dichvu)
        WHERE
            YEAR(hd.ngaylamhopdong) = '2018')
        AND NOT EXISTS( SELECT 
            dv.id_dichvu
        FROM
            `dich_vu` dv
                INNER JOIN
            `hop_dong` hd USING (id_dichvu)
        WHERE
            YEAR(hd.ngaylamhopdong) = '2019');
        
-- task 8
SELECT DISTINCT
    kh.hoten
FROM
    `khach_hang` kh;

SELECT 
    kh.hoten
FROM
    `khach_hang` kh
GROUP BY kh.hoten;

SELECT 
    kh.hoten
FROM
    `khach_hang` kh 
UNION SELECT 
    kh.hoten
FROM
    `khach_hang` kh;
    
    
-- task 9; //Khong hieu chi het ??
SELECT 
    temp.month,
    COUNT(MONTH(hd.ngaylamhopdong)) AS 'So khach hang dang ki',
    SUM(hd.tongtien) AS 'Tong tien'
FROM
    (SELECT 1 AS month UNION SELECT 2 AS month UNION SELECT 3 AS month UNION SELECT 4 AS month UNION SELECT 5 AS month UNION SELECT 6 AS month UNION SELECT 7 AS month UNION SELECT 8 AS month UNION SELECT 9 AS month UNION SELECT 10 AS month UNION SELECT 11 AS month UNION SELECT 12 AS month) AS temp
        LEFT JOIN
    `hop_dong` hd ON MONTH(hd.ngaylamhopdong) = temp.month
        LEFT JOIN
    `khach_hang` kh USING (id_khachhang)
WHERE
    YEAR(hd.ngaylamhopdong) = '2019'
        OR YEAR(hd.ngaylamhopdong) IS NULL
        OR MONTH(hd.ngaylamhopdong) IS NULL
GROUP BY temp.month
ORDER BY temp.month;

-- task 10
SELECT 
    hd.id_hopdong,
    hd.ngaylamhopdong,
    hd.ngayketthuc,
    hd.tiendatcoc,
    COUNT(hdct.id_hopdongchitiet) AS 'So luong dich vu di kem'
FROM
    `hop_dong` hd
        INNER JOIN
    `hop_dong_chi_tiet` hdct USING (id_hopdong);
    
-- task 11
SELECT 
    dvdk.*
FROM
    `dich_vu_di_kem` dvdk
        INNER JOIN
    `hop_dong_chi_tiet` hdct USING (id_dichvudikem)
        INNER JOIN
    `hop_dong` hd USING (id_hopdong)
        INNER JOIN
    `khach_hang` kh USING (id_khachhang)
        INNER JOIN
    `loai_khach` lk USING (id_loaikhach)
WHERE
    lk.tenloaikhach = 'Vip'
        AND (kh.diachi = 'Vinh'
        OR kh.diachi = 'Quang Ngai');
    
-- task 12
SELECT 
    hd.id_hopdong,
    nv.hoten AS 'Ho ten nhan vien',
    kh.hoten AS 'Ho ten khach hang',
    kh.sdt,
    dv.tendichvu,
    COUNT(hdct.id_hopdongchitiet) AS 'So luong dich vu di kem',
    hd.tiendatcoc
FROM
    `hop_dong_chi_tiet` hdct
        INNER JOIN
    `hop_dong` hd USING (id_hopdong)
        INNER JOIN
    `dich_vu` dv USING (id_dichvu)
        INNER JOIN
    `khach_hang` kh USING (id_khachhang)
        INNER JOIN
    `nhan_vien` nv USING (id_nhanvien)
WHERE
    EXISTS( SELECT 
            hd.ngaylamhopdong AS 'me'
        FROM
            `hop_dong` hd
        WHERE
            'me' BETWEEN '2019-10-01' AND '2019-12-31')
        AND NOT EXISTS( SELECT 
            hd.ngaylamhopdong AS 'me'
        FROM
            `hop_dong` hd
        WHERE
            'me' NOT BETWEEN '2019-10-01' AND '2019-12-31');

-- task 13
SELECT 
    dvdk.*, COUNT(hdct.id_dichvudikem) AS 'So lan su dung'
FROM
    `dich_vu_di_kem` dvdk
        INNER JOIN
    `hop_dong_chi_tiet` hdct USING (id_dichvudikem)
        INNER JOIN
    `hop_dong` hd USING (id_hopdong)
        INNER JOIN
    `khach_hang` kh USING (id_khachhang)
GROUP BY hdct.id_dichvudikem
ORDER BY 'So lan su dung' DESC
LIMIT 0 , 1;

-- task 14
SELECT 
    hd.id_hopdong,
    ldv.tenloaidichvu,
    dvdk.tendichvudikem,
    COUNT(hdct.id_dichvudikem) AS `So lan su dung`
FROM
    `hop_dong` hd
        INNER JOIN
    `dich_vu` dv USING (id_dichvu)
        INNER JOIN
    `loai_dich_vu` ldv USING (id_loaidichvu)
        INNER JOIN
    `hop_dong_chi_tiet` hdct USING (id_hopdong)
        INNER JOIN
    `dich_vu_di_kem` dvdk USING (id_dichvudikem)
GROUP BY hdct.id_dichvudikem
HAVING `So lan su dung` = 1;

-- task 15
SELECT 
    nv.id_nhanvien,
    nv.hoten,
    td.trinhdo,
    bp.tenbophan,
    nv.sdt,
    nv.diachi,
    hd.ngaylamhopdong,
    COUNT(hd.id_nhanvien) AS `So lan`
FROM
    `nhan_vien` nv
        INNER JOIN
    `bo_phan` bp USING (id_bophan)
        INNER JOIN
    `trinh_do` td USING (id_trinhdo)
        INNER JOIN
    `hop_dong` hd USING (id_nhanvien)
WHERE
    YEAR(hd.ngaylamhopdong) IN ('2018' , '2019')
GROUP BY hd.id_nhanvien
HAVING `So lan` <= 3;

-- task 16
delete
from `nhan_vien` nv
where not exists(
select nv.id_nhanvien
from `nhan_vien` nv
inner join `hop_dong` hd using(id_nhanvien)
where year(hd.ngaylamhopdong) in ('2017','2018','2019'));

-- task 17
UPDATE `loai_khach` lk 
SET 
    lk.tenloaikhach = 'Vip1'
WHERE
    EXISTS( SELECT 
            kh.id_khachhang, SUM(hd.tongtien) AS `tt`
        FROM
            `khach_hang` kh
                INNER JOIN
            `hop_dong` hd
        WHERE
            YEAR(hd.ngaylamhopdong) = '2019'
        GROUP BY kh.id_khachhang
        HAVING `tt` > 10000000);

-- task 18
delete 
from `khach_hang` kh
where exists(
select kh.id_khachhang
from `khach_hang` kh
inner join `hop_dong` hd using(id_khachhang)
where year(hd.ngaylamhopdong) <2016);


-- task 19
UPDATE `dich_vu_di_kem` dvdk 
SET 
    dvdk.gia = dvdk.gia * 2
WHERE
    EXISTS( SELECT 
            COUNT(hdct.id_dichvudikem) AS `cc`, hd.ngaylamhopdong
        FROM
            `dich_vu_di_kem` dvdk
                INNER JOIN
            `hop_dong_chi_tiet` hdct USING (id_dichvudikem)
                INNER JOIN
            `hop_dong` hd USING (id_hopdong)
                INNER JOIN
            `khach_hang` kh USING (id_khachhang)
        WHERE
            YEAR(hd.ngaylamhopdong) = '2019'
        GROUP BY dvdk.id_dichvudikem
        HAVING `cc` > 10);


-- task 20
SELECT 
    'Nhan vien' AS `Prefix`,
    nv.id_nhanvien,
    nv.hoten,
    nv.email,
    nv.sdt,
    nv.ngaysinh,
    nv.diachi
FROM
    `nhan_vien` nv 
UNION SELECT 
    'Khach hang' AS `Prefix`,
    kh.id_khachhang,
    kh.hoten,
    kh.email,
    kh.sdt,
    kh.ngaysinh,
    kh.diachi
FROM
    `khach_hang` kh



