CREATE DATABASE IF NOT EXISTS siganDatabase;

-- CREATE USER 'sigan'@'localhost' IDENTIFIED BY 'chlwogns321@';
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'chlwogns321@';

DROP TABLE IF EXISTS POSTTABLE;

USE siganDatabase;

CREATE TABLE IF NOT EXISTS POSTTABLE (
    postId INT AUTO_INCREMENT PRIMARY KEY,
    recipient VARCHAR(255) NOT NULL,
    subject VARCHAR(255) NOT NULL,
    text VARCHAR(5024) NOT NULL,
    targetTime VARCHAR(255) NOT NULL
);

use siganDatabase;

-- show tables;

-- 테스트 데이터-- 
INSERT INTO POSTTABLE (recipient, subject, text, targetTime) 
VALUES ('chlwogns0108@gmail.com', '최재훈5작성', 'Test 1', '2024-05-30 21:32:01');
INSERT INTO POSTTABLE (recipient, subject, text, targetTime) 
VALUES ('dywjdchl0108@naver.com', '최재훈6작성', 'Text 2', '2024-05-30 21:32:01');
INSERT INTO POSTTABLE (recipient, subject, text, targetTime) 
VALUES ('chlwogns0108@gmail.com', '최재훈3작성', 'Test 3', '2024-05-30 21:25:01');
INSERT INTO POSTTABLE (recipient, subject, text, targetTime) 
VALUES ('dywjdchl0108@naver.com', '최재훈4작성', 'Text 4', '2024-05-30 21:25:01');

select * from posttable;

-- -- USERTABLE 생성
-- CREATE TABLE IF NOT EXISTS USERTABLE (
--     userId INT AUTO_INCREMENT PRIMARY KEY,
--     recipient VARCHAR(255) NOT NULL UNIQUE,
--     password VARCHAR(255) NOT NULL
-- );

-- -- POSTTABLE 생성
-- CREATE TABLE IF NOT EXISTS POSTTABLE (
--     postId INT AUTO_INCREMENT PRIMARY KEY,
--     userId INT,
--     subject VARCHAR(255),
--     text VARCHAR(5024),
--     targetTime VARCHAR(255),
--     FOREIGN KEY (userId) REFERENCES USERTABLE(userId)
-- );