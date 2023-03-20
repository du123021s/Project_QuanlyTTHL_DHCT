create database LibManager;
use LibManager;

-- ****** create table alls**************

-- table Manager
create table Manager(
	ManagerID varchar(10) not null primary key ,
    ManagerName varchar(100) not null,
    ManagerRole varchar(50) not null
);

-- table Library is general information of library
-- note: From September 15, 2018, 
--       Vietnamese subscribers have been converted to 10 numbers
create table Library(
	LibraryID varchar(10) primary key not null,
    LibraryName varchar(250) not null,
    LibraryAddress varchar(250) not null,
    LibraryPhone int not null
);

-- table Employee
create table Employee(
   EmpID varchar(10) primary key not null ,
   EmpName varchar(100) not null,
   IsDeleted int default  0
);

-- create table Member
create table Member(
   MemID varchar(10) not null primary key,
   EmpID  varchar(10) not null,
   MemName  varchar(100) not null,
   DateOfBirth date not null,
   MemberGender  char(6) not null,
   MemAddress varchar(250) not null,
   MemPhone int not null,
   MemRegistrationDate date not null,
   MemSalary float null,
   MemBarcode  varchar(128) not null,  -- code 128 (ASCII)
   IsDeleted int default 0
);
ALTER TABLE Member ADD CONSTRAINT FK01 FOREIGN KEY(EmpID) REFERENCES Employee(EmpID);

-- Table InternalLogin for member login
create table InternalLogin(
	InLogID varchar(10) primary key not null,
    MemID varchar(10) not null,
    InLogPass varchar(20) not null,
    IsDeleted int default 0
);
ALTER TABLE InternalLogin ADD CONSTRAINT FK00 FOREIGN KEY(MemID) REFERENCES Member(MemID);

-- table Reader
create table Reader(
  ReaderID varchar(10) not null primary key,
  ReaderName varchar(100) not null,
  ReaderGender   char(6),
  DateOfBirth  date not null,
  ReaderAddress varchar(250) not null,
  ReaderPhone   int not null,
  ReadRegistrationDate  date not null,
  ReadExpirationDate  date not null,
  ReaderBarCode varchar(128) not null, -- code 128
  IsDeleted int default 0
);

-- table readerLoGin: your account login table reads
create table ReaderLogin(
   ReaderLoginID varchar(100) not null primary key,
   ReaderID varchar(10) not null,
   ReadPass varchar(20) not null,
   IsDeleted int default 0
);
ALTER TABLE ReaderLogin ADD CONSTRAINT FK02 FOREIGN KEY(ReaderID) REFERENCES Reader(ReaderID);

-- table DiscussionRoom: registration form to borrow a library room
create table DiscussionRoom(
  DisID  varchar(10) not null primary key,
  DisName  varchar(100) not null,
  DisLocation varchar(200) not null,
  DisTimeFrom time not null,
  DisTimeTo time not null,
  DisDate date not null,
  DisStatus varchar(20)
);

 -- table Author
 create table Author(
   AuthorID  varchar(10) not null primary key,
   AuthorName varchar(100) not null,
   AuthorSubject  varchar(250) not null,
   AuthorQualification varchar(250) not null,
   IsDeleted  int default 0
 );
 
 -- table  Publisher
 create table Publisher(
   PublisherID  varchar(10) not null primary key,
   PublisherName varchar(100) not null,
   PublisherPhone varchar(11) not null, -- Landline phone with 11 numbers
   PublisherAddress varchar(250) not null,
   PublisherYear int not null,
   IsDeleted int default 0
 );
 
-- table BookShelf
create table BookShelf(
     BoshID varchar(10) not null primary key,
     BoshName varchar (100) not null,
     IsDeleted  int default 0
);

 -- table CatalogBooks: 
create table CatalogOfBooks(
    CatalogID varchar(10) not null primary key,
    BoshID varchar(10) not null,
    CatalogName varchar(100) not null,
    IsDeleted int default 0
);
ALTER TABLE CatalogOfBooks ADD CONSTRAINT FK03 FOREIGN KEY(BoshID) REFERENCES BookShelf(BoshID);

-- table books: Book management for the library
 create table Books(
   BookID  varchar(10) not null primary key,
   BookName   varchar(100) not null,
   BookPrice float not null,
   BookAmount int not null,
   BookStatus varchar(20) not null,
   CatalogID varchar(10) not null,
   AuthorID varchar(10) not null,
   PublisherID varchar(10) not null,
   BookBarCode varchar(16) not null, -- Codabar
   IsDeleted int default 0
 );
ALTER TABLE Books ADD CONSTRAINT FK04 FOREIGN KEY(CatalogID) REFERENCES CatalogOfBooks(catalogID);
ALTER TABLE Books ADD CONSTRAINT FK05 FOREIGN KEY(AuthorID) REFERENCES Author(AuthorID);
ALTER TABLE Books ADD CONSTRAINT FK06 FOREIGN KEY(PublisherID) REFERENCES Publisher(PublisherID); 

-- table Borrow/return books:
 create table BorrowBooks(
     BorrID varchar(10) not null primary key,
     ReaderID varchar(10) not null,
     BookID varchar(10) not null,
     BorrDate date not null,
     BorrTime time not null,
     BorrDeadline date not null,
     BorrStatus varchar(20) not null
 );
 ALTER TABLE BorrowBooks ADD CONSTRAINT FK07 FOREIGN KEY(BookID) REFERENCES Books(BookID);
 ALTER TABLE BorrowBooks ADD CONSTRAINT FK08 FOREIGN KEY(ReaderID) REFERENCES Reader(ReaderID); 
 
 create table ReturnBooks(
     RetID   varchar(10) not null primary key,
     BorrID  varchar(10) not null,
     RetDeadline date not null,
     RetStatus  varchar(10) not null
 );
 ALTER TABLE ReturnBooks ADD CONSTRAINT FK09 FOREIGN KEY(BorrID) REFERENCES BorrowBooks(BorrID);
 
 
 
 -- insert database
 
 insert into Employee 
 value('EM01','Admin',0)
 
delete from Employee where EmpID ='A0000'
 
 insert into Member
 value('A21204','EM01','Trần Hữu Phúc','1995-09-22','Male','Cần Thơ',0962428167,'2023-09-22',4.0,'BC01',0)
 
 insert into InternalLogin
 value('IL01','A21204','Huuphuc1995ct@',0)
 
 
 insert into Reader
 value('R1001','Giang Thu Duyên','Female','2000-12-10','Kiên giang',02365984,'2023-09-22','2024-09-22','BC02',0)

 
 insert into ReaderLogin
 value('RL01','R1001','Duyen2000@',0)
 
 
 