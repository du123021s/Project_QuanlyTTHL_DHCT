-- tạo cơ sở dl version01
create database LibManager;
use LibManager;


-- create table data;
 create table manager(
    ManagerID varchar(100) not null primary key,
    ManagerName nvarchar(100) not null,
    ManagerUser varchar(100) not null,
    ManagerPass varchar(200) not null,
    ManagerRole nvarchar(100) not null
 );
 
  create table Library(
  LibraryID varchar(100) not null primary key,
  LibraryName nvarchar(200) not null,
  LibraryAddress nvarchar(300) not null,
  LibraryContact nvarchar(300) not null
 );
 
 
 
create table Role(
  RolID varchar(100) not null primary key,
  RolName nvarchar (200) not null,
  IsDeleted int default 0
);
 
 
 
 create table Employee(
   EmpID varchar(100) not null primary key,
   EmpName nvarchar(200) not null,
   EmpPhone int not null,
   DateOfBirth date not null,
   EmpGender varchar(100) not null,
   EmpAddress nvarchar(300) not null,
   EmpSalary float not null,
   EmpBarCode varchar(100) not null,
   IsDeleted int default 0
 );
 
 
 
 
 create table EmployeeDetails(
    RolID  varchar(100) not null,
    EmpID varchar(100) not  null,
    StartDate date not null,
    EndDate date not null,
    IsDeleted int default 0,
    primary key(RolID, EmpID)
 );

alter table EmployeeDetails add constraint FK01 foreign key(RolID) references Role(RolID);
alter table EmployeeDetails add constraint FK02 foreign key(EmpID) references Employee(EmpID);
 
 
 create table  InternalLogin(
   EmpID varchar(100) not null,
   RolID varchar(100) not null,
   InLogPass varchar(200) not null,
   IsDeleted int default 0,
   primary key(EmpID, RolID)
 );
 
 alter table InternalLogin add constraint FK03 foreign key(RolID) references Role(RolID);
 alter table InternalLogin add constraint FK04 foreign key(EmpID) references Employee(EmpID);
 
 create table Reader(
   ReaderID varchar(100) not null primary key,
   EmpID varchar(100) not null,
   ReaderName nvarchar(100) not null,
   DateOfBirth date not null,
   ReaderGender varchar(100) not null,
   ReaderAddress nvarchar(300) not null,
   ReaderPhone int not null,
   RegistrationDate date not null,
   DeadlineDate date not null,
   ReaderBarCode varchar(100) not null,
   IsDeleted int default 0
 );
 
 alter table Reader add constraint FK05 foreign key(EmpID) references Employee(EmpID);
 
 -- thêm colum image cho (Reader) để quản lý ảnh thẻ cho từng bạn đọc
 alter table Reader add ReaderImage varchar(500) not null;

 
 
 create table ReaderLogin(
   ReadLogID varchar(100) not null primary key,
   ReaderID varchar(100) not null,
   ReadLogPass varchar(200) not null
 );
 alter table ReaderLogin add constraint FK06 foreign key(ReaderID) references Reader(ReaderID);
 
 
create table  CatalogOfBooks(
   CatalogID varchar(100) not null primary key,
   CatalogTitle nvarchar(200) not null,
   BoshID varchar(100) not null,
   IsDeleted int default 0
);
-- sua dl ban dau thanh BoshID
alter table catalogOfBooks change AuthorSubject BoshID varchar(100) not null;
-- them khoa ngoai
 alter table catalogOfBooks add constraint FKCata foreign key(BoshID) references BookShelf(BoshID);



create table BookShelf(
  BoshID varchar(100) not null primary key,
  BoshTitle nvarchar(300) not null,
  IsDeleted int default 0
);

 
  create table Author(
    AuthorID varchar(100) not null primary key,
    AuthorName nvarchar(200) not null,
    AuthorSubject nvarchar(300) not null,
    AuthorQualification varchar(200) not null,
    IsDeleted int default 0
 );
 
 create table Publisher(
   PubID varchar(100) not null primary key,
   PubName nvarchar(200) not null,
   PubPhone int null,
   PubAddress nvarchar(300) not null,
   IsDeleted int default 0
 );
 
create table Books(
   BookId varchar(100) not null primary key,
   CatalogID varchar(100) not null,
   AuthorID varchar(100) not null,
   PubID varchar(100) not null,
   BookTitle nvarchar(200) not null,
   BookPrice float not null,
   BookStatus varchar(100) not null,
   BookAmount int not null,
   BookBarCode varchar(100) not null,
   IsDeleted int default 0
);
alter table Books add constraint FK07 foreign key(AuthorID) references Author(AuthorID);
alter table Books add constraint FK08 foreign key(CatalogID) references CatalogOfBooks(CatalogID);
alter table Books add constraint FK09 foreign key(PubID) references Publisher(PubID);
 
 
 

 create table BorrowBooks(
    BorrID varchar(100) not null primary key,
    BookID varchar(100) not null,
    BorrStartDate date not null,
    BorrEnddate date not null,
    Status nvarchar(200) not null,
    IsDeleted int default 0
 );
 alter table BorrowBooks add constraint FK10 foreign key(BookID) references Books(BookID);
 
 
 create table ReturnBooks(
    RetID varchar(100) not null primary key,
    BorrID varchar(100) not null,
    ReturnDate date not null,
    Status nvarchar(200) not null
 );
 alter table ReturnBooks add constraint FK11 foreign key(BorrID) references BorrowBooks(BorrID);
 
 create table BorrowReturnDetails(
    BorrID varchar(100) not null,
    RetID varchar(100) not null,
    EmpID varchar(100) not null,
    ReaderID varchar(100) not null,
    IsDeleted int default 0,
    primary key(BorrID, RetID)
 );
 
 alter table BorrowReturnDetails add constraint FK12 foreign key(BorrID) references BorrowBooks(BorrID);
 alter table BorrowReturnDetails add constraint FK13 foreign key(RetID) references ReturnBooks(RetID);
  alter table BorrowReturnDetails add constraint FK14 foreign key(EmpID) references Employee(EmpID);
   alter table BorrowReturnDetails add constraint FK15 foreign key(ReaderID) references Reader(ReaderID);
 
create table DiscussionRoom(
  DisID varchar(100) not null primary key,
  DisName nvarchar(300) not null,
  DisLocation varchar(200) not null,
  DisTimeFrom varchar(100) not null,
  DisTimeTo varchar(100) not null,
  DisDate date not null,
  IsDeleted int default 0
);
 
 
 -- insert data load for table:
 insert into Employee
 value('E002','Trần Hồng Tem',0962428155,'1999-09-12','Male','Cần Thơ',3.0,'B1002',0);
   
 insert into Role
 value('Rol01','Giám đốc điều hành',0);
 
 insert into Reader
 value('R001','E001','Giang Thu Duyên','2000-09-22','Female','Kiên Giang',0962425687,'2023-04-01','2024-04-01','B1001',0,'G:\DO_AN_PROJECT\Project_QuanlyTTHL_DHCT\Quanlythuvien_Version01\src\Icon\ReaderUser\img.png');
 insert into Reader
 value('R002','E002','Trần Hữu Phúc','2000-09-22','Male','Hà Tĩnh',0933425687,'2023-05-01','2024-05-01','B1002',0,'G:\DO_AN_PROJECT\Project_QuanlyTTHL_DHCT\Quanlythuvien_Version01\src\Icon\ReaderUser\phuc.png');
      

 
 insert into ReaderLogin
 value('RL01','R001','Duyen2000@');

insert into InternalLogin
value('E001','Rol01','Huuphuc1995ct@',0);

 
 -- câu lệnh truy vấn
 select * from Reader;