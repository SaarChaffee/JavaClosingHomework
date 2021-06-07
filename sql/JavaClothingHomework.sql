create database mooer

Go
Use mooer

create table AccountData
(
    UserUid int primary key,
    Account varchar(50) not null,
    PassWord varchar(50) not null,
    PhoneNumber int unique
)
Go

insert into AccountData values(0,1,1,0);
create table UserData
(
    UserUid int primary key foreign key references AccountData (UserUid),
    Account varchar(50) not null,
    UserLevel int,
    UserWin int,
    UserLost int,
    Reported int,
    UserCardQuantity int,
    UserBalance int,
    UserSignature varchar(100)
)
Go

create table Friend
(
    UserUid int foreign key references AccountData (UserUid),
    FriendUid int foreign key references AccountData (UserUid),
)
Go

create table Redemption
(
    RedemptionCode varchar(50) primary key ,
    RedemptionCodeValue int,
    RedemptionUsed int default '0'foreign key references AccountData (UserUid)

)
Go

create table CardColle
(
    UserUid int primary key foreign key references AccountData (UserUid),
    Water1 bit default 'false',
    Water2 bit default 'false',
    Water3 bit default 'false',
    Water4 bit default 'false',
    Water5 bit default 'false',
    Water6 bit default 'false',
    Water7 bit default 'false',
    Water8 bit default 'false',
    Water9 bit default 'false',
    Water10 bit default 'false',
    Water11 bit default 'false',
    Water12 bit default 'false',
    Water13 bit default 'false',
    Water14 bit default 'false',
    Water15 bit default 'false',
    Water16 bit default 'false',
    Water17 bit default 'false',
    Water18 bit default 'false',
    Water19 bit default 'false',
    Water20 bit default 'false',
    Wood1 bit default 'false',
    Wood2 bit default 'false',
    Wood3 bit default 'false',
    Wood4 bit default 'false',
    Wood5 bit default 'false',
    Wood6 bit default 'false',
    Wood7 bit default 'false',
    Wood8 bit default 'false',
    Wood9 bit default 'false',
    Wood10 bit default 'false',
    Wood11 bit default 'false',
    Wood12 bit default 'false',
    Wood13 bit default 'false',
    Wood14 bit default 'false',
    Wood15 bit default 'false',
    Wood16 bit default 'false',
    Wood17 bit default 'false',
    Wood18 bit default 'false',
    Wood19 bit default 'false',
    Wood20 bit default 'false',
    Fire1 bit default 'false',
    Fire2 bit default 'false',
    Fire3 bit default 'false',
    Fire4 bit default 'false',
    Fire5 bit default 'false',
    Fire6 bit default 'false',
    Fire7 bit default 'false',
    Fire8 bit default 'false',
    Fire9 bit default 'false',
    Fire10 bit default 'false',
    Fire11 bit default 'false',
    Fire12 bit default 'false',
    Fire13 bit default 'false',
    Fire14 bit default 'false',
    Fire15 bit default 'false',
    Fire16 bit default 'false',
    Fire17 bit default 'false',
    Fire18 bit default 'false',
    Fire19 bit default 'false',
    Fire20 bit default 'false'
    
)
Go

drop login Java
create login Java with password='111' 
create user Java for login Java
exec sp_addrolemember 'db_owner', 'Java'