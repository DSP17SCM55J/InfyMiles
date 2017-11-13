create database InfyMiles;

use InfyMiles;

create table Register (
emailId varchar(50) Primary key,
name varchar(30),
password varchar(20),
userType varchar(20)
);

create table Cars(carId int Primary key,
 carName varchar(20),
 carCategory varchar(20),
 carBrandName varchar(20),
 carMileage varchar(20),
 carModel varchar(20),
 carProductionYear varchar(20),
 carColor varchar(20),
 carImagePath varchar(200),
 carPrice varchar(20),
 carReservationStatus int
);

create table Orders(
orderId int  Primary key,
carId int,
emailId varchar(30),
orderDate varchar(20),
startDate varchar(20),
endDate varchar(20),
amount varchar(20),
cardNumber varchar(20),
address varchar(200),
status varchar(20),
licenseId varchar(20),
paymentMethod varchar(20)
);