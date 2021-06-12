Use master
drop database mooer

create database mooer

Go
Use mooer

create table AccountData
(
    UserUid     int primary key,
    Account     varchar(50) not null,
    PassWord    varchar(50) not null,
    PhoneNumber varchar(11) not null unique
)
Go

insert into AccountData
values (0, 1, 1, 0);
create table UserData
(
    UserUid          int primary key foreign key references AccountData (UserUid),
    Account          varchar(50) not null,
    UserLevel        int,
    UserWin          int,
    UserLost         int,
    Reported         int,
    UserCardQuantity int,
    UserBalance      int,
    UserSignature    varchar(100)
)
Go

create table Friend
(
    UserUid   int foreign key references AccountData (UserUid),
    FriendUid int foreign key references AccountData (UserUid),
)
Go

create table Redemption
(
    RedemptionCode      varchar(50) primary key,
    RedemptionCodeValue int,
    RedemptionUsed      int default '0' foreign key references AccountData (UserUid)

)
Go

create table CardColle
(
    UserUid int primary key foreign key references AccountData (UserUid),
    水1      bit default 'false',
    水2      bit default 'false',
    水3      bit default 'false',
    水4      bit default 'false',
    水5      bit default 'false',
    水6      bit default 'false',
    水7      bit default 'false',
    水8      bit default 'false',
    水9      bit default 'false',
    水10     bit default 'false',
    水11     bit default 'false',
    水12     bit default 'false',
    水13     bit default 'false',
    水14     bit default 'false',
    水15     bit default 'false',
    水16     bit default 'false',
    水17     bit default 'false',
    水18     bit default 'false',
    水19     bit default 'false',
    水20     bit default 'false',
    木1      bit default 'false',
    木2      bit default 'false',
    木3      bit default 'false',
    木4      bit default 'false',
    木5      bit default 'false',
    木6      bit default 'false',
    木7      bit default 'false',
    木8      bit default 'false',
    木9      bit default 'false',
    木10     bit default 'false',
    木11     bit default 'false',
    木12     bit default 'false',
    木13     bit default 'false',
    木14     bit default 'false',
    木15     bit default 'false',
    木16     bit default 'false',
    木17     bit default 'false',
    木18     bit default 'false',
    木19     bit default 'false',
    木20     bit default 'false',
    火1      bit default 'false',
    火2      bit default 'false',
    火3      bit default 'false',
    火4      bit default 'false',
    火5      bit default 'false',
    火6      bit default 'false',
    火7      bit default 'false',
    火8      bit default 'false',
    火9      bit default 'false',
    火10     bit default 'false',
    火11     bit default 'false',
    火12     bit default 'false',
    火13     bit default 'false',
    火14     bit default 'false',
    火15     bit default 'false',
    火16     bit default 'false',
    火17     bit default 'false',
    火18     bit default 'false',
    火19     bit default 'false',
    火20     bit default 'false'

)
Go

drop login Java
create login Java with password ='111'
create user Java for login Java
exec sp_addrolemember 'db_owner', 'Java'