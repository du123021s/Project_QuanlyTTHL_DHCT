-- xây dựng cơ sở dử liệu cho ứng dụng tiềm kiếm và quản lý thư viện
create database LibManager
use LibManager

-- tạo bảng cơ sở dữ liệu

create table AdminUser(
  adminID varchar(50) not null primary key,
  passWord varchar(100) not null,
  gmail varchar(100) not null,
  sex char(50) null,
  cardMakingDtae  date null

)

create table LabrarianUser(
  labrarianID varchar(50) not null primary key,
  passWord varchar(100) not null,
  gmail varchar(100) not null,
  sex char(50) null,
  cardMakingDtae  date null
)


create table  ReaderUser(
  readerID varchar(50) not null primary key,
  passWord varchar(100) not null,
  gmail varchar(100) not null,
  sex char(50) null,
  cardMakingDtae  date null
)


create table Bookstore(
  bookID varchar(100) not null primary key,
  typeID varchar(100) not null,
  bookSheltID varchar(50) not null,
  bookName nvarchar(200) not null,
  auThor nvarchar(200) not null,
  pubYear date null,
  numberOf int not null,
  price float not null,
  status nvarchar(200) not null
)


create table Bookshelf(
  bookShelfID varchar(100) not null primary key,
  bookShelfName nvarchar(100) not null,
  loacation nvarchar(100) not null,
  record nvarchar(300) not null 
)

create table Typecode(
  typeID varchar(50) not null primary key,
  typename nvarchar(300) not null
)


create table Borrow_Books(
  bookID varchar(100) not null,
  readerID varchar(50) not null,
  numberOf int not null,
  borrowedDate date not null,
  payDay date not null,
  lendername nvarchar(100) null,
  status nvarchar(50) not null
  
)





-- chèn khóa ngoại
-- thêm dữ liệu cho bảng
insert into  Bookstore
value('MS01','ML01','A233','Lập trình Java','Growling','1996-02-23',46,256.5,'con nguyen'),
      ('MS02','ML01','A233','Lập trình C#','Jame','1997-02-23',46,256.5,'con nguyen'),
      ('MS03','ML02','B111','Lập trình Python','YuangZhi','1996-02-02',46,356.2,'con nguyen')

-- thực hiện Update table
-- thực hiện xóa table

-- lệnh truy vấn tiềm kiếm
 select * from Bookstore
 select * from Typecode
 
 
-- join bảng tabble tạo bảng ảo view
