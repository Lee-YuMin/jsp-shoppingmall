모델 사이트 : http://www.jinvas.com/shop/main/index.php
참조 사이트 : 
http://all-record.tistory.com/120

DB정보 - root / 0000
admin / amdin
DB명 - shopping

Products
Sequnece - seq INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
product_name - ��ǰ ��,
asg_group - kid, adult, all
type - clock, lighting, flowerpot, storage, toy, etc
price - Num
discount - Num
hot - Boolean
created_date - Date

Users
Sequence
id
password
name
age
gender
phone
introduction

// USER TABEL CREATE QUERY
CREATE TABLE users (
sequence INT PRIMARY KEY AUTO_INCREMENT,
id VARCHAR(20) NOT NULL,
password VARCHAR(20) NOT NULL,
name VARCHAR(20) NOT NULL,
age INT NOT NULL,
gender VARCHAR(10) DEFAULT 'M',
phone VARCHAR(13),
introduction VARCHAR(1000)
) ENGINE=INNODB;