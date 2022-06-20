
CREATE DATABASE DoAnJavaTC
GO

USE DoAnJavaTC
GO



CREATE TABLE TaiKhoan
(
	tenDangNhap VARCHAR(100) PRIMARY KEY,	
	tenHienThi NVARCHAR(100) NOT NULL DEFAULT N'',
	matKhau VARCHAR(100) NOT NULL DEFAULT 0,
	loaiTaiKhoan INT NOT NULL  DEFAULT 0 -- 1: quản lý  &&  0: nhân viên
)
GO


CREATE TABLE NhanVien
(
	maNV VARCHAR(100) PRIMARY KEY,
	tenNV NVARCHAR(100) NOT NULL,
	ngaySinh DATE NOT NULL,
	gioiTinh NVARCHAR(5) NOT NULL,
	diaChi NVARCHAR(100) NOT NULL,
	sDT NVARCHAR(11) NOT NULL,
	chucVu NVARCHAR(100) NOT NULL,
	taiKhoan VARCHAR(100) NOT NULL,
	matKhau VARCHAR(100) NOT NULL,
	imageNV VARCHAR(MAX)

	
	FOREIGN KEY (taiKhoan) REFERENCES dbo.TaiKhoan(tenDangNhap)
)
GO


CREATE TABLE BanAn
(
	maBan VARCHAR(100) PRIMARY KEY,
	tenBan NVARCHAR(100) NOT NULL DEFAULT N'Chưa đặt tên bàn',
	trangThai NVARCHAR(100) NOT NULL DEFAULT N'Trống'	-- Trống || Có người
)
GO


CREATE TABLE DanhMucMon
(
	maLoai VARCHAR(100) PRIMARY KEY,
	tenLoai NVARCHAR(100) NOT NULL DEFAULT N'Chưa đặt tên danh mục',
)
GO



CREATE TABLE MonAn
(
	maMonAn VARCHAR(100) PRIMARY KEY,
	tenMonAn NVARCHAR(100) NOT NULL DEFAULT N'Chưa đặt tên món',
	maLoaiMon VARCHAR(100) NOT NULL,
	donVi NVARCHAR(50) NOT NULL,
	giaTien FLOAT NOT NULL DEFAULT 0,
	soLuong INT NOT NULL,
	imageMonAn VARCHAR(MAX)
	
	FOREIGN KEY (maLoaiMon) REFERENCES dbo.DanhMucMon(maLoai)
)
GO



CREATE TABLE HoaDon
(
	maHoaDon VARCHAR(100) PRIMARY KEY,
	ngayVao DATE NOT NULL DEFAULT GETDATE(),
	ngayRa DATE,
	maBanAn VARCHAR(100) NOT NULL,
	trangThaiBan INT NOT NULL DEFAULT 0 -- 1: đã thanh toán && 0: chưa thanh toán
	
	FOREIGN KEY (maBanAn) REFERENCES dbo.BanAn(maBan)
)
GO


CREATE TABLE ThongTinHoaDon
(
	maTTHoaDon VARCHAR(100) PRIMARY KEY,
	maHoaDonBan VARCHAR(100) NOT NULL,
	maMonAnBan VARCHAR(100) NOT NULL,
	count INT NOT NULL DEFAULT 0
	
	FOREIGN KEY (maHoaDonBan) REFERENCES dbo.HoaDon(maHoaDon),
	FOREIGN KEY (maMonAnBan) REFERENCES dbo.MonAn(maMonAn)
)
GO

CREATE TABLE DatBan
(
	maKH VARCHAR(100) PRIMARY KEY,
	tenKhachHang NVARCHAR(100) NOT NULL,
	soDT VARCHAR(11) NOT NULL,
	maSoBan VARCHAR(100) NOT NULL,
	ngayDat DATE NOT NULL,
	trangThai NVARCHAR(100) NOT NULL,
	ghiChu NVARCHAR(200) NOT NULL,
	trangThaiBanAn NVARCHAR(100) NOT NULL
	
	FOREIGN KEY (maSoBan) REFERENCES dbo.BanAn(maBan)
)
GO




SELECT * FROM TaiKhoan



INSERT INTO dbo.TaiKhoan
        ( tenDangNhap ,
          tenHienThi ,
          matKhau ,
          loaiTaiKhoan
        )
VALUES  ( 'Admin' , -- UserName - nvarchar(100)
          N'Quản Lý' , -- DisplayName - nvarchar(100)
          '123quanly' , -- PassWord - nvarchar(1000)
          1  -- Type - int --Quản lý
        )
		
INSERT INTO dbo.TaiKhoan
        ( tenDangNhap ,
          tenHienThi ,
          matKhau ,
          loaiTaiKhoan
        )
VALUES  ( 'Staff' , -- UserName - nvarchar(100)
          N'Nhân Viên' , -- DisplayName - nvarchar(100)
          '123quanly' , -- PassWord - nvarchar(1000)
          0  -- Type - int --Nhân viên
        )
GO
		
INSERT INTO dbo.NhanVien
        ( tenNV ,
          ngaySinh ,
          gioiTinh ,
          diaChi,
		  sDT,
		  chucVu,
		  taiKhoan,
		  matKhau,
		  imageNV
        )
VALUES  ( N'Staff' ,
		'2000-12-25',
		N'Nam',
		N'HUTECH',
		0865329280,
		N'Quản lý',
		N'giathanh25',
		123,
		NULL
        )
GO


--Lệnh tạo bàn tự động 
DECLARE @i INT = 0
WHILE @i <= 10			--10 bàn
BEGIN
	INSERT dbo.BanAn(tenBan)VALUES  ( N'Bàn ' + CAST(@i AS nvarchar(100))) --CAST ép kiểu cho @i về kiểu string 
	SET @i = @i + 1
END

select * from BanAn


-- Thêm  dữ liệu cho category

INSERT dbo.DanhMucMon 
		(tenLoai)
VALUES ( N'Đồ chiên' )

INSERT dbo.DanhMucMon
        ( tenLoai )
VALUES  ( N'Bánh ngọt' )

INSERT dbo.DanhMucMon
        ( tenLoai )
VALUES  ( N'Nước uống' )

INSERT dbo.DanhMucMon
        ( tenLoai )
VALUES  ( N'Món đặc biệt' )

select * from DanhMucMon

-- thêm món ăn
INSERT dbo.MonAn
        ( tenMonAn, maLoaiMon,donVi, giaTien,soLuong,imageMonAn )
VALUES  ( N'Bánh gạo lắc phô mai', -- Tên món - nvarchar(100) - NOT NULL
          1, -- Mã loại món - int - NOT NULL
		  N'Phần', -- Đơn vị tính - nvarchar(50) - NOT NULL
          30000, -- Gía Tiền - Float - NOT NULL
		  100, -- Số lượng - Int - NOT NULL
		  NULL) -- Hình ảnh món - image - NULL

INSERT dbo.MonAn
        ( tenMonAn, maLoaiMon,donVi, giaTien,soLuong,imageMonAn )
VALUES  ( N'Khoai tây chiên', 1, N'Phần', 15000, 100, NULL)

INSERT dbo.MonAn
        ( tenMonAn, maLoaiMon,donVi, giaTien,soLuong,imageMonAn )
VALUES  ( N'Bánh donut', 2, N'Cái', 10000, 50, NULL)

INSERT dbo.MonAn
        ( tenMonAn, maLoaiMon,donVi, giaTien,soLuong,imageMonAn )
VALUES  ( N'Bánh flan', 2, N'Cái', 10000, 50, NULL)

INSERT dbo.MonAn
        ( tenMonAn, maLoaiMon,donVi, giaTien,soLuong,imageMonAn )
VALUES  ( N'7Up', 3, N'Chai', 12000, 200, NULL)

INSERT dbo.MonAn
        ( tenMonAn, maLoaiMon,donVi, giaTien,soLuong,imageMonAn )
VALUES  ( N'Coca-cola', 3, N'Chai', 12000, 200, NULL)


UPDATE DanhMucMon SET tenLoai = N'Đồ ăn vặt'  Where maLoai = 1 --Đổi tên danh mục ở mã danh mục

SELECT *FROM dbo.MonAn

-- Thêm dữ liệu cho Hóa Đơn

INSERT	dbo.HoaDon
        ( ngayVao ,
          ngayRa ,
          maBanAn ,
          trangThaiBan
        )
VALUES  ( GETDATE() , -- ngayVao - date
          NULL , -- ngayRa - date
          1, -- maBanAn - int
          0  -- trangThaiBan - int
        )

INSERT	dbo.HoaDon
        ( ngayVao ,
          ngayRa ,
          maBanAn ,
          trangThaiBan
        )
VALUES  ( GETDATE() , -- DateCheckIn - date
          GETDATE() , -- DateCheckOut - date
          2 , -- idTable - int
          1  -- status - int
        )

select * from dbo.HoaDon

-- Thêm  dữ liệu cho bill info
INSERT	dbo.ThongTinHoaDon
        ( maHoaDonBan, maMonAnBan, count )
VALUES  ( 1, -- maHoaDonBan - int
          1, -- maMonAnBan - int
          2  -- count - int
          )
INSERT	dbo.ThongTinHoaDon
        ( maHoaDonBan, maMonAnBan, count )
VALUES  ( 2, -- maHoaDonBan - int
          3, -- maMonAnBan - int
          4  -- count - int
          )
GO

--Lấy tài khoản từ user name
CREATE PROC USP_LayTaiKhoanTuTenDangNhap
@tenDangNhap nvarchar(100)
AS 
BEGIN
	SELECT * FROM dbo.TaiKhoan WHERE tenDangNhap = @tenDangNhap
END
GO

EXEC dbo.USP_LayTaiKhoanTuTenDangNhap @tenDangNhap = N'Admin' -- nvarchar(100)

--Tạo đăng nhập
CREATE PROC USP_DangNhap
@tenDangNhap nvarchar(100), @matKhau nvarchar(100)
AS
BEGIN
	SELECT * FROM dbo.TaiKhoan WHERE tenDangNhap = @tenDangNhap AND matKhau = @matKhau
END
GO


--Lấy danh sách bàn
CREATE PROC USP_LayDanhSachBan
AS SELECT * FROM dbo.BanAn
GO

EXEC dbo.USP_LayDanhSachBan
GO

--Tạo hóa đơn
CREATE PROC USP_TaoHoaDon
@idTable INT
AS
BEGIN
	INSERT	dbo.HoaDon
        ( ngayVao ,
          ngayRa ,
          maBanAn ,
          trangThaiBan
        )
VALUES  ( GETDATE() , -- DateCheckIn - date
          NULL , -- DateCheckOut - date
          @idTable , -- idTable - int
          0  -- status - int
        )
END
GO


--Lấy danh sách theo điều kiện

 -- select tenKhachHang, soDT, QLBanAn.tenBan, ngayDat, QLDatBan.trangThai, ghiChu
 -- from QLDatBan, QLBanAn 
 -- where tenBan = tenBan and QLDatBan.maSoBan = QLBanAn.maBan


--CREATE PROC USP_InsertBillInfo
--@idBill INT, @idFood INT, @count INT
--AS
--BEGIN
--	INSERT	dbo.BillInfo
--        ( idBill, idFood, count )
        
--VALUES (@idBill,
--		@idFood,
--		@count)
--END
--GO

--Programmability


--Tạo thông tin hóa đơn
ALTER PROC USP_TaoThongTinHoaDon
@maHoaDon INT, @maMonAn INT, @count INT
AS
BEGIN
	DECLARE @isExitsThongTinHoaDon INT
	DECLARE @demMonAn INT = 1

	SELECT @isExitsThongTinHoaDon = maTTHoaDon, @demMonAn = b.count 
	FROM dbo.ThongTinHoaDon AS b
	WHERE maHoaDonBan = @maHoaDon AND maMonAnBan = @maMonAn

	IF(@isExitsThongTinHoaDon >0)
	BEGIN
		DECLARE @newCount INT = @demMonAn + @count
		IF(@newCount > 0 )
			UPDATE dbo.ThongTinHoaDon SET COUNT = @demMonAn + @count 
			WHERE maMonAnBan = @maMonAn
		ELSE
			DELETE dbo.ThongTinHoaDon WHERE maHoaDonBan = @maHoaDon AND maMonAnBan = @maMonAn
	END
		ELSE
		BEGIN
			INSERT dbo.ThongTinHoaDon
			(maHoaDonBan,maMonAnBan,count)
			VALUES (@maHoaDon,
					@maMonAn,
					@count)
		END
END
GO
					

--Cập nhật thông tin hóa đơn
CREATE TRIGGER UTG_CapNhatThongTinHoaDon
ON dbo.ThongTinHoaDon FOR INSERT, UPDATE
AS
BEGIN
	DECLARE @maHoaDon INT

	SELECT @maHoaDon = maHoaDonBan FROM Inserted

	DECLARE @maBan INT

	SELECT @maBan = maBanAn FROM dbo.HoaDon WHERE maHoaDon = @maHoaDon AND trangThaiBan = 0

	UPDATE dbo.BanAn SET trangThai = N'Có người' WHERE maBan = @maBan
END
GO


--Cập nhật hóa đơn
CREATE TRIGGER UTG_CapNhatHoaDon
ON dbo.HoaDon FOR UPDATE
AS
BEGIN
	DECLARE @maHoaDon INT

	SELECT @maHoaDon = maHoaDon FROM Inserted
		
	DECLARE @maBan INT 

	SELECT @maBan = maBanAn FROM dbo.HoaDon WHERE maHoaDon = @maHoaDon 
	
	DECLARE @count int = 0

	SELECT @count = COUNT (*) FROM dbo.HoaDon WHERE maBanAn = @maBan AND trangThaiBan = 0

	IF (@count = 0)
		UPDATE dbo.BanAn SET trangThai = N'Trống' WHERE maBan = @maBan
END
GO

EXEC UTG_CapNhatHoaDon @maBan =1


--Tạo lệnh dùng để chuyển bàn
CREATE PROC USP_ChuyenBanAn
@idTable1 INT, @idTable2 int
AS BEGIN

	DECLARE @idFirstBill int
	DECLARE @idSeconrdBill INT
	
	DECLARE @isFirstTablEmty INT = 1
	DECLARE @isSecondTablEmty INT = 1
	
	
	SELECT @idSeconrdBill = maHoaDon FROM dbo.HoaDon WHERE maBanAn = @idTable2 AND trangThaiBan = 0
	SELECT @idFirstBill = maHoaDon FROM dbo.HoaDon WHERE maBanAn = @idTable1 AND trangThaiBan = 0
	
	PRINT @idFirstBill
	PRINT @idSeconrdBill
	PRINT '-----------'
	
	IF (@idFirstBill IS NULL)
	BEGIN
		PRINT '0000001'
		INSERT dbo.HoaDon
		        ( ngayVao ,
		          ngayRa ,
		          maBanAn ,
		          trangThaiBan
		        )
		VALUES  ( GETDATE() , -- DateCheckIn - date
		          NULL , -- DateCheckOut - date
		          @idTable1 , -- idTable - int
		          0  -- status - int
		        )
		        
		SELECT @idFirstBill = MAX(maHoaDon) FROM dbo.HoaDon WHERE maBanAn = @idTable1 AND trangThaiBan = 0
		
	END
	
	SELECT @isFirstTablEmty = COUNT(*) FROM dbo.ThongTinHoaDon WHERE maHoaDonBan = @idFirstBill
	
	PRINT @idFirstBill
	PRINT @idSeconrdBill
	PRINT '-----------'
	
	IF (@idSeconrdBill IS NULL)
	BEGIN
		PRINT '0000002'
		INSERT dbo.HoaDon
		        ( ngayVao ,
		          ngayRa ,
		          maBanAn ,
		          trangThaiBan
		        )
		VALUES  ( GETDATE() , -- DateCheckIn - date
		          NULL , -- DateCheckOut - date
		          @idTable2 , -- idTable - int
		          0  -- status - int
		        )
		SELECT @idSeconrdBill = MAX(maHoaDon) FROM dbo.HoaDon WHERE maBanAn = @idTable2 AND trangThaiBan = 0
		
	END
	
	SELECT @isSecondTablEmty = COUNT(*) FROM dbo.ThongTinHoaDon WHERE maHoaDonBan = @idSeconrdBill
	
	PRINT @idFirstBill
	PRINT @idSeconrdBill
	PRINT '-----------'

	SELECT maTTHoaDon INTO IDBillInfoTable FROM dbo.ThongTinHoaDon WHERE maHoaDonBan = @idSeconrdBill
	
	UPDATE dbo.ThongTinHoaDon SET maHoaDonBan = @idSeconrdBill WHERE maHoaDonBan = @idFirstBill
	
	UPDATE dbo.ThongTinHoaDon SET maHoaDonBan = @idFirstBill WHERE maTTHoaDon IN (SELECT * FROM IDBillInfoTable)
	
	DROP TABLE IDBillInfoTable
	
	IF (@isFirstTablEmty = 0)
		UPDATE dbo.BanAn SET trangThai = N'Trống' WHERE maBan = @idTable2
		
	IF (@isSecondTablEmty= 0)
		UPDATE dbo.BanAn SET trangThai = N'Trống' WHERE maBan = @idTable1
END
GO



--Thêm cột vào bảng Bill
ALTER TABLE dbo.HoaDon ADD tongTien FLOAT

ALTER TABLE dbo.HoaDon ADD giamGia INT


--Lấy danh sách hóa đơn theo thời gian
CREATE PROC USP_LayDanhSachHoaDonTheoThoiGian
@checkIn date, @checkOut date
AS 
BEGIN
	SELECT t.tenBan AS [Tenban], b.tongTien AS [Tongtien], ngayVao AS [Ngayvao], ngayRa AS [Ngayra], giamGia AS [Giamgia]
	FROM dbo.HoaDon AS b,dbo.BanAn AS t
	WHERE ngayVao >= @checkIn AND ngayRa <= @checkOut AND b.trangThaiBan = 1
	AND t.maBan = b.maBanAn
END
GO

--Lấy danh sách món ăn
CREATE PROC USP_LayDanhSachMonAn
AS SELECT * FROM dbo.Food
GO

--Lấy danh sách hóa đơn từ tên bàn
CREATE PROC USP_LayDanhSachHoaDonTuBanAn
	@name nvarchar(100)
AS 
BEGIN
	SELECT f.tenMonAn, bi.count, f.giaTien, f.giaTien*bi.count AS totalPrice 
	FROM dbo.ThongTinHoaDon AS bi, dbo.HoaDon AS b, dbo.MonAn AS f, dbo.BanAn AS t
	WHERE bi.maHoaDonBan = b.maHoaDon AND bi.maMonAnBan = f.maMonAn AND b.trangThaiBan = 0 AND b.maBanAn = t.maBan AND t.tenBan = @name
END
GO

EXEC USP_LayDanhSachHoaDonTuBanAn @name = 'Bàn 1'

select *from BanAn

--Cập nhật thông tin tài khoản
CREATE PROC USP_UpdateAccount
@userName NVARCHAR(100), @displayName NVARCHAR(100), @password NVARCHAR(100), @newPassword NVARCHAR(100)
AS
BEGIN
	DECLARE @isRightPass INT = 0
	
	SELECT @isRightPass = COUNT(*) FROM dbo.Account WHERE USERName = @userName AND PassWord = @password
	
	IF (@isRightPass = 1)
	BEGIN
		IF (@newPassword = NULL OR @newPassword = '')
		BEGIN
			UPDATE dbo.Account SET DisplayName = @displayName WHERE UserName = @userName
		END		
		ELSE
			UPDATE dbo.Account SET DisplayName = @displayName, PassWord = @newPassword WHERE UserName = @userName
	end
END
GO

--Xóa thông tin hóa đơn
CREATE TRIGGER UTG_DeleteBillInfo
ON dbo.BillInfo FOR DELETE
AS 
BEGIN
	DECLARE @idBillInfo INT
	DECLARE @idBill INT
	SELECT @idBillInfo = id, @idBill = Deleted.idBill FROM Deleted
	
	DECLARE @idTable INT
	SELECT @idTable = idTable FROM dbo.Bill WHERE id = @idBill
	
	DECLARE @count INT = 0
	
	SELECT @count = COUNT(*) FROM dbo.BillInfo AS bi, dbo.Bill AS b WHERE b.id = bi.idBill AND b.id = @idBill AND b.status = 0
	
	IF (@count = 0)
		UPDATE dbo.TableFood SET status = N'Trống' WHERE id = @idTable
END
GO

DECLARE @count INT = 0
DELETE BillInfo = Bill FROM dbo.BillInfo AS bi,dbo.Bill AS b where b.idTable and bi.idBill


--Tìm kiếm món ăn theo tên
CREATE FUNCTION [dbo].[fuConvertToUnsign1] ( @strInput NVARCHAR(4000) ) RETURNS NVARCHAR(4000) 
AS 
BEGIN 
IF @strInput IS NULL 
RETURN @strInput 
IF @strInput = '' 
RETURN @strInput 
DECLARE @RT NVARCHAR(4000) 
DECLARE @SIGN_CHARS NCHAR(136) 
DECLARE @UNSIGN_CHARS NCHAR (136) 
SET @SIGN_CHARS = N'ăâđêôơưàảãạáằẳẵặắầẩẫậấèẻẽẹéềểễệế ìỉĩịíòỏõọóồổỗộốờởỡợớùủũụúừửữựứỳỷỹỵý ĂÂĐÊÔƠƯÀẢÃẠÁẰẲẴẶẮẦẨẪẬẤÈẺẼẸÉỀỂỄỆẾÌỈĨỊÍ ÒỎÕỌÓỒỔỖỘỐỜỞỠỢỚÙỦŨỤÚỪỬỮỰỨỲỶỸỴÝ' +NCHAR(272)+ NCHAR(208) 
SET @UNSIGN_CHARS = N'aadeoouaaaaaaaaaaaaaaaeeeeeeeeee iiiiiooooooooooooooouuuuuuuuuuyyyyy AADEOOUAAAAAAAAAAAAAAAEEEEEEEEEEIIIII OOOOOOOOOOOOOOOUUUUUUUUUUYYYYYDD' DECLARE @COUNTER int 
DECLARE @COUNTER1 int 
SET @COUNTER = 1 
WHILE (@COUNTER <=LEN(@strInput)) 
BEGIN 
SET @COUNTER1 = 1 WHILE (@COUNTER1 <=LEN(@SIGN_CHARS)+1) 
BEGIN 
IF UNICODE(SUBSTRING(@SIGN_CHARS, @COUNTER1,1)) = UNICODE(SUBSTRING(@strInput,@COUNTER ,1) ) 
BEGIN 
IF @COUNTER=1 SET @strInput = SUBSTRING(@UNSIGN_CHARS, @COUNTER1,1) + SUBSTRING(@strInput, @COUNTER+1,LEN(@strInput)-1) 
ELSE 
SET @strInput = SUBSTRING(@strInput, 1, @COUNTER-1) +SUBSTRING(@UNSIGN_CHARS, @COUNTER1,1) + SUBSTRING(@strInput, @COUNTER+1,LEN(@strInput)- @COUNTER) 
BREAK END 
SET @COUNTER1 = @COUNTER1 +1 
END 
SET @COUNTER = @COUNTER +1 
END 
SET @strInput = replace(@strInput,' ','-') RETURN @strInput 
END




select *from BillInfo

-------Lệnh truy vấn xem thông tin có trong bảng và các lệnh thêm, cập nhật, xóa, ...


--Cập nhật tạo cho discount là 0
UPDATE dbo.Bill SET discount = 0
GO

--Cập nhật tên danh mục ở id ...
UPDATE dbo.FoodCategory SET name = N'Món đặc biệt' WHERE id = 


--Cập nhật trạng thái đã có khách cho bàn có id là ...
UPDATE dbo.TableFood SET status = N'Đã có khách' WHERE id = 


--Linh ta linh tinh

SELECT f.name, bi.count, f.price, f.price*bi.count AS [totalPrice]  
FROM dbo.BillInfo AS bi, dbo.Bill AS b, dbo.Food AS f 
WHERE bi.idBill = b.id AND bi.idFood = f.id AND b.status = 0 AND b.idTable = 1

select * from Food where idCategory = 3

DELETE dbo.Bill WHERE id = 5

DELETE dbo.TableFood WHERE id = 

SET IDENTITY_INSERT dbo.FoodCategory OFF

select * from FoodCategory

select *from Account

select * from FoodCategory where id =1006

select * from BillInfo
select * from FoodCategory

select * from FoodCategory where id = 1

delete from dbo.FoodCategory where id = 2

select * from Bill

select * from dbo.BillInfo where idBill = 2


SELECT * FROM dbo.Food WHERE dbo.fuConvertToUnsign1 (name) LIKE N'%ham%'

select *from Food
select id[ID],name[Tên món],idCategory[ID Danh mục],price as 'Giá tiền',imageFood as 'Hình ảnh' from Food

select * from TableFood



select * from Food where idCategory =3

select *from foodcategory

delete from TableFood AND Bill where id =  2 


select *from TableFood

select *from BillInfo

DELETE dbo.BillInfo
DELETE dbo.Bill


EXEC dbo.USP_SwitchTabel @idTabe1=2,
	@idTable2 =3
GO
