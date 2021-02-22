create table UserInfo (
	UserID varchar2(30) primary key,
	Password varchar2(20) not null,
	Name varchar2(20) not null,
	phoneNumber varchar2(20) not null
);
create table Menu (
	MenuName varchar2(20) primary key,
	price number(10) not null,
	type varchar2(5) not null
);
create table Sales (
SalesNumber number(5) not null,	
MenuName varchar2(20) not null,
UserID varchar2(20)  not null,
tableNumber varchar2(2) primary key,
account number(5) not null,
constraint Sales_UserID_fk foreign key (UserID) references UserInfo(UserID),
constraint Sales_MenuName_fk foreign key (MenuName) references Menu(MenuName)
);

create sequence SalesNumber_SEQ
  start with 1
  increment BY 1
  maxvalue 10000;

INSERT INTO Sales VALUES(SalesNumber_SEQ.NEXTVAL);