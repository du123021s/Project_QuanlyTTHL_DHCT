create database LibManager
use LibManager

-- ****** create table alls**************
-- table Employee
create table Employee(
   EmpID varchar(100) not null primary key,
   EmpName  nvarchar(200) not null,
   IsDeleted int default  0
)

-- create table Member
create table Member(
   MemID varchar(100) not null primary key,
   EmpID  varchar(100) not null,
   MemName  nvarchar(200) not null,
   DateOfBirth date not null,
   MemberGender  char(50) not null,
   MemAddress nvarchar(200) not null,
   MemPhone int not null,
   MemBarcode  varchar(100) not null,
   MemRegistrationDate date not null,
   MemSalary float    null,
   MemIdcard      varchar(100) not null,
   IsDeleted   int default 0
)
ALTER TABLE Member ADD CONSTRAINT FK01 FOREIGN KEY(EmpID) REFERENCES Employee(EmpID);

-- table Reader
create table Reader(
  ReaderID varchar(100) not null primary key,
  ReaderName nvarchar(200) not null,
  ReaderGender   char(50),
  DateOfBirth  date null,
  ReaderAddress nvarchar(300) not null,
  ReaderContact   nvarchar(3300) null,
  ReadRegistrationDate  date not null,
  ReadExpirationDate  date not null
)


-- table readerLoGin: your account login table reads
create table ReaderLogin(
   ReaderLoginID   varchar(100) not null primary key,
   ReaderID  varchar(100) not null,
   ReadPass   varchar(100) not null
)
ALTER TABLE ReaderLogin ADD CONSTRAINT FK03 FOREIGN KEY(ReaderID) REFERENCES Reader(ReaderID);

-- table manangerLogin
create table ManagerLogin(
  ManLoginID  varchar(100) not null primary key,
  MemID varchar(100) not null,
  ManLoginPass varchar(100) not null
)
-- loi xem lai
ALTER TABLE ManagerLogin ADD CONSTRAINT FK02 FOREIGN KEY(MemID) REFERENCES Member(MemID);

-- table DiscussionRoom: registration form to borrow a library room
create table DiscussionRoom(
  DisID  varchar(100) not null primary key,
  DisName  nvarchar(200) not null,
  DisLocation nvarchar(200) not null,
  DisType nvarchar(200) not null,
  DisTime   int not null,
  DisDate date not null
)


-- table Borrow/return books:
 create table BorrowBooks(
     BorrID  varchar(100) not null primary key,
     ReaderIID   varchar(100) not null,
     BookID   varchar(100) not null,
     BorrDate    date not null,
     BorrDeadline date not null,
     BorrStatus  nvarchar(100) not null
 )
 ALTER TABLE BorrowBooks ADD CONSTRAINT FK05 FOREIGN KEY(BookID) REFERENCES Books(BookID);
 ALTER TABLE BorrowBooks ADD CONSTRAINT FKA FOREIGN KEY(ReaderID) REFERENCES Reader(ReaderID);   -- loi xem lai!
 
 
 create table ReturnBooks(
     RetID   varchar(100) not null primary key,
     BorrID  varchar(100) not null,
     RetDeadline date not null,
     RetStatus  nvarchar(100) not null
 )
 
 ALTER TABLE ReturnBooks ADD CONSTRAINT FK04 FOREIGN KEY(BorrID) REFERENCES BorrowBooks(BorrID);
 
 
 -- table books: Book management for the library
 create table Books(
   BookID  varchar(100) not null primary key,
   CatalogID    varchar(100) not null,
   AuthorID   varchar(100) not null,
   PublisherID   varchar(100) not null,
   BookName   nvarchar(200) not null,
   BookPrice float  null,
   BookStatus   nvarchar(100) null,
   BookAmount  int  not null,
   IsDeleted   int default 0
 )
 
 ALTER TABLE Books ADD CONSTRAINT FK07 FOREIGN KEY(CatalogID) REFERENCES CatalogOfBooks(catalogID);
 ALTER TABLE Books ADD CONSTRAINT FK08 FOREIGN KEY(AuthorID) REFERENCES Author(AuthorID);
ALTER TABLE Books ADD CONSTRAINT FK09 FOREIGN KEY(PublisherID) REFERENCES Publisher(PublisherID); 
 -- table Author
 
 create table Author(
   AuthorID  varchar(100) not null primary key,
   AuthorName nvarchar(200),
   AuthorSubject   nvarchar(300) not null,
   AuthorQualification nvarchar(100) not null,
   IsDeleted  int default 0
 )
 
 -- table  Publisher
 create table Publisher(
   PublisherID  varchar(100) not null primary key,
   PublisherName nvarchar(100) not null,
   PublisherContact  nvarchar(300) not null,
   PublisherAddress nvarchar(300) not null,
   PublisherYear int not null,
   IsDeleted int default 0
 )
 
 -- table CatalogBooks: 
 create table CatalogOfBooks(
    CatalogID   varchar(100) not null primary key,
    BoshID varchar(100) not null,
    CatalogName  nvarchar(200) not null,
    IsDeleted    int default 0
  )
  ALTER TABLE CatalogOfBooks ADD CONSTRAINT FK10 FOREIGN KEY(BoshID) REFERENCES BookShelf(BoshID);
  
  
  -- table BookShelf
  
  create table BookShelf(
     BoshID  varchar(100) not null primary key,
     BoshName   nvarchar(200) not null,
     IsDeleted  int default 0
  )
 
 
-- insert into table
insert into ManagerLogin
value('A01','A21204','Huuphuc1995ct@') 

-- select all table
select * from ManagerLogin