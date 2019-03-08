-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 15, 2019 at 11:22 AM
-- Server version: 10.1.10-MariaDB
-- PHP Version: 7.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cv`
--

-- --------------------------------------------------------

--
-- Table structure for table `achievement`
--

CREATE TABLE `achievement` (
  `ID` varchar(10) NOT NULL,
  `NAME` varchar(50) NOT NULL,
  `DESCRIPTION` varchar(200) NOT NULL,
  `EMPLOYEE` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `achievement`
--

INSERT INTO `achievement` (`ID`, `NAME`, `DESCRIPTION`, `EMPLOYEE`) VALUES
('1', 'Juara 2 PIMNASS', 'Juara Pekan Ilmiah Mahasiswa Nasional', '30004'),
('2', 'Juara 1 Futsal Jakarta Timur', 'Juara Futsal Tingkat SMA', '30004'),
('3', 'Juara 3 Futsal SD Bekasi Timur', 'Juara Futsal tingkat SD', '20001'),
('4', 'Juara Menggambar Tingkat Perguruan Tinggi', 'Juara Menggambar Jawa Timur', '20004'),
('5', 'Juara 1 Badminton Tingkat Perguruan Tinggi', 'Juara Badminton Purwokerto', '30001'),
('6', 'Juara 1 PIMNAS', 'Juara Pekan Ilmiah Mahasiswa Nasional', '20003');

-- --------------------------------------------------------

--
-- Table structure for table `certification`
--

CREATE TABLE `certification` (
  `ID` varchar(10) NOT NULL,
  `NAME` varchar(50) NOT NULL,
  `EXPIRED_DATE` datetime DEFAULT NULL,
  `DESCRIPTION` varchar(100) NOT NULL,
  `EMPLOYEE` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `certification`
--

INSERT INTO `certification` (`ID`, `NAME`, `EXPIRED_DATE`, `DESCRIPTION`, `EMPLOYEE`) VALUES
('1', 'Microsoft Office Dekstop Application', NULL, 'Grade: Excellent', '20003'),
('10', 'IBM', NULL, 'IBM partner', '30002'),
('2', 'CISCO', '2019-02-02 00:00:00', 'CISCO Certification', '20001'),
('3', 'IBM Partner', NULL, 'IBM Trainer Partner', '20001'),
('4', 'CISCO Hardware', '2025-12-12 00:00:00', 'CISCO Hardware Support', '30002'),
('5', 'IBM', NULL, 'IBM', '30001'),
('7', 'CISCO', NULL, 'CISCO Certification', '30004');

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `ID` varchar(10) NOT NULL,
  `ADDRESS` varchar(50) NOT NULL,
  `BUSINESS` varchar(20) NOT NULL,
  `IS_DELETE` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`ID`, `ADDRESS`, `BUSINESS`, `IS_DELETE`) VALUES
('40001', 'APL Tower', 'IT', 'NO'),
('40002', 'APL Tower 38', 'IT', 'NO');

-- --------------------------------------------------------

--
-- Table structure for table `education`
--

CREATE TABLE `education` (
  `ID` varchar(10) NOT NULL,
  `START_DATE` datetime NOT NULL,
  `END_DATE` datetime NOT NULL,
  `IP` varchar(10) NOT NULL,
  `MAJOR_UNIVERSITY` varchar(10) NOT NULL,
  `EMPLOYEE` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `education`
--

INSERT INTO `education` (`ID`, `START_DATE`, `END_DATE`, `IP`, `MAJOR_UNIVERSITY`, `EMPLOYEE`) VALUES
('1', '2014-09-01 00:00:00', '2018-01-01 00:00:00', '3.40', '6', '30001'),
('10', '2014-12-12 00:00:00', '2018-12-12 00:00:00', '3.40', '6', '30002'),
('2', '2013-07-07 00:00:00', '2017-08-08 00:00:00', '3.66', '6', '20003'),
('3', '2011-08-08 00:00:00', '2015-08-08 00:00:00', '3.34', '6', '20004'),
('4', '2010-08-08 00:00:00', '2014-08-08 00:00:00', '3.80', '6', '1'),
('5', '2013-09-09 00:00:00', '2017-08-08 00:00:00', '3.82', '6', '1'),
('6', '2015-12-12 00:00:00', '2018-12-12 00:00:00', '3.99', '6', '20001');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `ID` varchar(10) NOT NULL,
  `RELIGION` varchar(10) DEFAULT NULL,
  `PHONE` varchar(13) NOT NULL,
  `MARITAL_STATUS` varchar(10) NOT NULL,
  `NATIONALITY` varchar(20) NOT NULL,
  `BIRTH_DATE` datetime NOT NULL,
  `START_DATE` datetime NOT NULL,
  `END_DATE` datetime DEFAULT NULL,
  `IS_DELETE` varchar(10) NOT NULL,
  `PHOTO` longblob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`ID`, `RELIGION`, `PHONE`, `MARITAL_STATUS`, `NATIONALITY`, `BIRTH_DATE`, `START_DATE`, `END_DATE`, `IS_DELETE`, `PHOTO`) VALUES
('1', 'moslem', '031', 'single', 'Indonesia', '1996-12-12 00:00:00', '2009-09-09 00:00:00', NULL, 'NO', NULL),
('20001', 'christian', '98765432100', 'single', 'Indonesia', '1996-11-11 00:00:00', '2019-01-01 00:00:00', '2021-12-12 00:00:00', 'NO', NULL),
('20003', 'christian', '09876', 'married', 'Zimbabwe', '1996-09-09 00:00:00', '2014-04-04 00:00:00', '2021-05-05 00:00:00', 'NO', NULL),
('20004', 'moslem', '0101020102', 'married', 'Indonesia', '1996-04-04 00:00:00', '2018-03-03 00:00:00', '2020-03-03 00:00:00', 'NO', NULL),
('30001', 'moslem', '1111111111111', 'married', 'America', '1996-02-06 00:00:00', '2018-01-01 00:00:00', NULL, 'YES', NULL),
('30002', 'Moslem', '088811111', 'Single', 'Indonesia', '1996-01-02 00:00:00', '2019-02-02 00:00:00', NULL, 'NO', NULL),
('30004', 'moslem', '123456789991', 'Single', 'china', '1996-04-01 00:00:00', '2018-12-12 00:00:00', NULL, 'NO', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `experience`
--

CREATE TABLE `experience` (
  `ID` varchar(10) NOT NULL,
  `NAME` varchar(50) NOT NULL,
  `DESCRIPTION` varchar(100) NOT NULL,
  `EMPLOYEE` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `experience`
--

INSERT INTO `experience` (`ID`, `NAME`, `DESCRIPTION`, `EMPLOYEE`) VALUES
('1', 'Pembicara', 'Seminar Nasional', '30001'),
('2', 'Moderator', 'Debat', '30002'),
('3', 'Pemateri', 'Pemateri CISCO', '20001'),
('4', 'Microsoft Talker', 'Pemateri Microsoft', '20003'),
('5', 'IBM Talker', 'Pemateri IBM', '20003'),
('6', 'Pembicara', 'Pembicara Nasional Seminar', '30002');

-- --------------------------------------------------------

--
-- Table structure for table `language`
--

CREATE TABLE `language` (
  `ID` varchar(10) NOT NULL,
  `NAME` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `language`
--

INSERT INTO `language` (`ID`, `NAME`) VALUES
('1', 'Indonesian'),
('2', 'English'),
('3', 'Chinese'),
('4', 'Indian'),
('5', 'Arabic'),
('6', 'British');

-- --------------------------------------------------------

--
-- Table structure for table `language_employee`
--

CREATE TABLE `language_employee` (
  `ID` varchar(10) NOT NULL,
  `LANGUAGE` varchar(10) NOT NULL,
  `EMPLOYEE` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `language_employee`
--

INSERT INTO `language_employee` (`ID`, `LANGUAGE`, `EMPLOYEE`) VALUES
('1', '5', '30002'),
('2', '6', '20001'),
('3', '5', '20003'),
('4', '4', '20004'),
('5', '4', '30001');

-- --------------------------------------------------------

--
-- Table structure for table `major`
--

CREATE TABLE `major` (
  `ID` varchar(10) NOT NULL,
  `NAME` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `major`
--

INSERT INTO `major` (`ID`, `NAME`) VALUES
('1', 'Teknik Informatika'),
('2', 'Sistem Informasi'),
('3', 'Teknik Komputer'),
('4', 'Sistem Komputer'),
('5', 'Managemen Informatika'),
('6', 'Teknologi Informasi');

-- --------------------------------------------------------

--
-- Table structure for table `major_university`
--

CREATE TABLE `major_university` (
  `ID` varchar(10) NOT NULL,
  `DEGREE` varchar(20) NOT NULL,
  `DEGREE_LEVEL` varchar(20) NOT NULL,
  `MAJOR` varchar(10) NOT NULL,
  `UNIVERSITY` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `major_university`
--

INSERT INTO `major_university` (`ID`, `DEGREE`, `DEGREE_LEVEL`, `MAJOR`, `UNIVERSITY`) VALUES
('1', 'S.Kom', 'S1', '1', '1'),
('2', 'S.Kom', 'S1', '3', '4'),
('3', 'S.Ikom', 'S1', '5', '6'),
('4', 'S.T', 'S1', '6', '6'),
('5', 'S.Kom', 'S1/D4', '1', '2'),
('6', 'S.kom', 'S1/D4', '2', '3');

-- --------------------------------------------------------

--
-- Table structure for table `mii_info`
--

CREATE TABLE `mii_info` (
  `ID` varchar(10) NOT NULL,
  `ADDRESS` varchar(200) NOT NULL,
  `PHONE` varchar(13) NOT NULL,
  `EMAIL` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `mii_info`
--

INSERT INTO `mii_info` (`ID`, `ADDRESS`, `PHONE`, `EMAIL`) VALUES
('1', 'PT Mitra Integrasi Informatika \r\nAPL Tower 37th floor, Suite 1-8 \r\nJl. LetJen S. Parman Kav 28, Tanjung Duren Selatan \r\nGrogol Petamburan, Jakarta Barat, 11470', '02129345777', 'recruitment@mii.co.id'),
('2', 'APL Tower', '08112233445', 'Recruitment@metro.co.id');

-- --------------------------------------------------------

--
-- Table structure for table `organization`
--

CREATE TABLE `organization` (
  `ID` varchar(10) NOT NULL,
  `NAME` varchar(30) NOT NULL,
  `POSITION` varchar(20) NOT NULL,
  `START_DATE` datetime NOT NULL,
  `END_DATE` datetime NOT NULL,
  `EMPLOYEE` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `organization`
--

INSERT INTO `organization` (`ID`, `NAME`, `POSITION`, `START_DATE`, `END_DATE`, `EMPLOYEE`) VALUES
('1', 'Badan Eksekutif Mahasiswa', 'Presiden', '2015-05-05 00:00:00', '2016-06-06 00:00:00', '30002'),
('2', 'GMNI', 'anggota', '2017-07-07 00:00:00', '2018-08-08 00:00:00', '30001'),
('3', 'FILKOM JABODETABEK', 'anggota', '2015-01-04 00:00:00', '2018-12-01 00:00:00', '20001'),
('4', 'BEM', 'Sekretaris', '2014-12-12 00:00:00', '2016-12-12 00:00:00', '20004'),
('5', 'EM', 'Wakil Presiden', '2014-12-12 00:00:00', '2015-12-12 00:00:00', '20003');

-- --------------------------------------------------------

--
-- Table structure for table `project`
--

CREATE TABLE `project` (
  `ID` varchar(10) NOT NULL,
  `NAME` varchar(30) NOT NULL,
  `START_DATE` datetime NOT NULL,
  `END_DATE` datetime NOT NULL,
  `ASSESSMENT` varchar(100) DEFAULT NULL,
  `PROJECT_SPECIFICATION` varchar(30) NOT NULL,
  `PROJECT_STATUS` varchar(10) NOT NULL,
  `CLIENT` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `project`
--

INSERT INTO `project` (`ID`, `NAME`, `START_DATE`, `END_DATE`, `ASSESSMENT`, `PROJECT_SPECIFICATION`, `PROJECT_STATUS`, `CLIENT`) VALUES
('1', 'QR', '2019-02-01 00:00:00', '2019-12-12 00:00:00', 'Baik Sekali', 'MyQR', 'do', '40002'),
('10', 'Project', '2018-02-01 00:00:00', '2019-02-01 00:00:00', 'Baik', 'AAA', 'DO', '40001'),
('2', 'Locate Me', '2019-01-01 00:00:00', '2019-03-03 00:00:00', 'Baik', 'Navigation for locate me', 'do', '40002'),
('3', 'Web Perusahaan', '2015-12-12 00:00:00', '2016-12-12 00:00:00', 'Baik', 'Web Development', 'done', '40001'),
('4', 'Web Kantor', '2018-11-10 00:00:00', '2019-01-01 00:00:00', 'Sedang dikerjakan', 'Web Development', 'do', '40002'),
('5', 'Web Client', '2018-11-10 00:00:00', '2019-01-01 00:00:00', 'Baik', 'Web Development', 'done', '40001'),
('6', 'project coba', '2017-02-04 00:00:00', '2021-02-06 00:00:00', NULL, 'spesific', 'DO', '40001');

-- --------------------------------------------------------

--
-- Table structure for table `project_employee`
--

CREATE TABLE `project_employee` (
  `ID` varchar(10) NOT NULL,
  `START_DATE` datetime NOT NULL,
  `END_DATE` datetime NOT NULL,
  `JOB_DESCRIPTION` varchar(100) NOT NULL,
  `PROJECT_EMPLOYEE_STATUS` varchar(10) NOT NULL,
  `EMPLOYEE` varchar(10) NOT NULL,
  `PROJECT` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `project_employee`
--

INSERT INTO `project_employee` (`ID`, `START_DATE`, `END_DATE`, `JOB_DESCRIPTION`, `PROJECT_EMPLOYEE_STATUS`, `EMPLOYEE`, `PROJECT`) VALUES
('1', '2019-02-01 00:00:00', '2019-12-12 00:00:00', 'penanggungjawab', 'do', '30001', '3'),
('10', '2018-02-01 00:00:00', '2019-02-01 00:00:00', 'aaaaaaa', 'DO', '30002', '2'),
('11', '2018-01-01 00:00:00', '2020-01-04 00:00:00', 'aaaa', 'DO', '20001', '1'),
('2', '2019-02-01 00:00:00', '2019-02-02 00:00:00', 'back end', 'do', '20004', '3'),
('3', '2018-12-12 00:00:00', '2019-12-12 00:00:00', 'ABC', 'do', '1', '5'),
('4', '2012-12-12 00:00:00', '2015-12-12 00:00:00', 'QR', 'done', '1', '5'),
('5', '2018-02-02 00:00:00', '2019-02-08 00:00:00', 'job', 'DO', '20003', '2'),
('6', '2019-02-01 00:00:00', '2019-02-28 00:00:00', 'jd', 'DO', '30001', '1'),
('7', '2019-02-02 00:00:00', '2019-02-21 00:00:00', 'desc', 'DO', '1', '5');

-- --------------------------------------------------------

--
-- Table structure for table `qualification`
--

CREATE TABLE `qualification` (
  `ID` varchar(10) NOT NULL,
  `NAME` varchar(30) NOT NULL,
  `SPECIALIZATION` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `qualification`
--

INSERT INTO `qualification` (`ID`, `NAME`, `SPECIALIZATION`) VALUES
('1', 'Java', 'programming language'),
('2', '.NET', 'programming language'),
('3', 'MySQL', 'database'),
('4', 'Python', 'programming language'),
('5', 'Oracle', 'database'),
('6', 'Java', 'Programming');

-- --------------------------------------------------------

--
-- Table structure for table `qualification_employee`
--

CREATE TABLE `qualification_employee` (
  `ID` varchar(10) NOT NULL,
  `QUALIFICATION` varchar(10) NOT NULL,
  `EMPLOYEE` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `qualification_employee`
--

INSERT INTO `qualification_employee` (`ID`, `QUALIFICATION`, `EMPLOYEE`) VALUES
('1', '3', '30001'),
('2', '3', '30002'),
('3', '3', '30002'),
('4', '3', '20001'),
('5', '3', '20003'),
('6', '3', '30001'),
('7', '3', '20004');

-- --------------------------------------------------------

--
-- Table structure for table `role_mii`
--

CREATE TABLE `role_mii` (
  `ID` varchar(10) NOT NULL,
  `NAME` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `role_mii`
--

INSERT INTO `role_mii` (`ID`, `NAME`) VALUES
('1', 'admin'),
('2', 'employee'),
('3', 'RM'),
('4', 'Client'),
('idrole01', 'admin'),
('idrole02', 'employee'),
('idrole03', 'client');

-- --------------------------------------------------------

--
-- Table structure for table `test`
--

CREATE TABLE `test` (
  `ID` varchar(10) NOT NULL,
  `NAME` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `test_trigger`
--

CREATE TABLE `test_trigger` (
  `ID` varchar(10) NOT NULL,
  `NAME` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `training`
--

CREATE TABLE `training` (
  `ID` varchar(10) NOT NULL,
  `NAME` varchar(50) NOT NULL,
  `DESCRIPTION` varchar(100) NOT NULL,
  `CERTIFICATE` varchar(10) NOT NULL,
  `EMPLOYEE` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `training`
--

INSERT INTO `training` (`ID`, `NAME`, `DESCRIPTION`, `CERTIFICATE`, `EMPLOYEE`) VALUES
('1', 'TOEFL Preparation', 'LBPP', 'yes', '30001'),
('2', 'IBM', 'IBM Training', 'yes', '30002'),
('3', 'CISCO', 'CISCO Training', 'no', '20001'),
('4', 'Microsoft', 'Microsoft Training', 'yes', '20001'),
('5', 'Oracle', 'Oracle training', 'no', '30001'),
('6', 'Microsoft Mentor', 'Microsoft Mentoring', 'yes', '20004');

-- --------------------------------------------------------

--
-- Table structure for table `university`
--

CREATE TABLE `university` (
  `ID` varchar(10) NOT NULL,
  `NAME` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `university`
--

INSERT INTO `university` (`ID`, `NAME`) VALUES
('1', 'Universitas Brawijaya'),
('2', 'Universitas Indonesia'),
('3', 'Universitas Bina Nusantara'),
('4', 'Universitas Trisakti'),
('5', 'Universitas Tarumanegara'),
('6', 'Universitas Negeri Malang');

-- --------------------------------------------------------

--
-- Table structure for table `user_mii`
--

CREATE TABLE `user_mii` (
  `ID` varchar(10) NOT NULL,
  `PASSWORD` varchar(100) NOT NULL,
  `NAME` varchar(50) NOT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `ROLE` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_mii`
--

INSERT INTO `user_mii` (`ID`, `PASSWORD`, `NAME`, `EMAIL`, `ROLE`) VALUES
('1', '111', 'Ninda', 'ninda@gmail.com', '4'),
('10002', 'admin2', 'admin2', 'admin@gmail.com', '1'),
('20001', 'rayhan', 'Rayhan', 'rayhan@gmail.com', '2'),
('20002', 'putra', 'Putra', 'putra@gmail.com', '2'),
('20003', 'bintang', 'Bintang', 'bintang@langit.com', '2'),
('20004', 'kresna', 'Kresna', 'kres@na.com', '2'),
('20005', 'danastri', 'Danastri', 'danas@gmail.com', '2'),
('20006', 'mehaninda', 'Mehaninda', 'meha@gmail.com', '2'),
('30001', 'aditya', 'Aditya', 'aditya@gmail.com', '3'),
('30002', 'ninda', 'Ninda', 'ninda@gmail.com', '3'),
('30003', 'ramya', 'Ramya', 'ramya@gmail.com', '3'),
('30004', 'tsani', 'Tsani', 'tsani@gmail.com', '3'),
('40001', 'mii', 'MII', 'mii@@mii.co.id', '4'),
('40002', 'metro', 'Metro', 'metro@metro.com', '4'),
('40003', 'pertamini', 'Pertamini', 'pertamini@mini.co.id', '4');

-- --------------------------------------------------------

--
-- Table structure for table `work_assignment`
--

CREATE TABLE `work_assignment` (
  `ID` varchar(10) NOT NULL,
  `START_DATE` datetime NOT NULL,
  `END_DATE` datetime NOT NULL,
  `POSITION` varchar(20) NOT NULL,
  `COMPANY` varchar(30) NOT NULL,
  `JOB_DESCRIPTION` varchar(100) NOT NULL,
  `EMPLOYEE` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `work_assignment`
--

INSERT INTO `work_assignment` (`ID`, `START_DATE`, `END_DATE`, `POSITION`, `COMPANY`, `JOB_DESCRIPTION`, `EMPLOYEE`) VALUES
('1', '2011-01-01 00:00:00', '2013-03-03 00:00:00', 'Manager', 'PT. lalala', 'management', '30001'),
('10', '2018-02-01 00:00:00', '2018-02-28 00:00:00', 'Sales', 'PT. PT', 'AAAAAAAAA', '20001'),
('2', '2012-12-12 00:00:00', '2015-12-12 00:00:00', 'Web Developer', 'PT. Tralala', 'Web Development', '30002'),
('3', '2017-11-10 00:00:00', '2018-11-10 00:00:00', 'Mobile Developer', 'PT. PTIK', 'Mobile Development', '20003'),
('4', '2012-12-12 00:00:00', '2014-12-12 00:00:00', 'Manager', 'PT. PITIK', 'Manajemen', '20004'),
('5', '2017-12-12 00:00:00', '2018-12-12 00:00:00', 'Project Manager', 'PT. PTPTS', 'Project manajemen', '30002');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `achievement`
--
ALTER TABLE `achievement`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ACHIEVEMENT_PK` (`ID`),
  ADD KEY `ACHIEVEMENT_FK` (`EMPLOYEE`);

--
-- Indexes for table `certification`
--
ALTER TABLE `certification`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `CERTIFICATION_PK` (`ID`),
  ADD KEY `CERTIFICATION_FK` (`EMPLOYEE`);

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `CLIENT_PK` (`ID`);

--
-- Indexes for table `education`
--
ALTER TABLE `education`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `EDUCATION_PK` (`ID`),
  ADD KEY `EDUCATION_FK` (`MAJOR_UNIVERSITY`),
  ADD KEY `EDUCATION_FK2` (`EMPLOYEE`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `EMPLOYEE_PK` (`ID`);

--
-- Indexes for table `experience`
--
ALTER TABLE `experience`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `EXPERIENCE_PK` (`ID`),
  ADD KEY `EXPERIENCE_FK` (`EMPLOYEE`);

--
-- Indexes for table `language`
--
ALTER TABLE `language`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `LANGUAGE_PK` (`ID`);

--
-- Indexes for table `language_employee`
--
ALTER TABLE `language_employee`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `LANGUAGE_EMPLOYEE_PK` (`ID`),
  ADD KEY `LANGUAGE_EMPLOYEE_FK` (`LANGUAGE`),
  ADD KEY `LANGUAGE_EMPLOYEE_FK2` (`EMPLOYEE`);

--
-- Indexes for table `major`
--
ALTER TABLE `major`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `MAJOR_PK` (`ID`);

--
-- Indexes for table `major_university`
--
ALTER TABLE `major_university`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `MAJOR_UNIVERSITY_PK` (`ID`),
  ADD KEY `MAJOR_UNIVERSITY_FK` (`MAJOR`),
  ADD KEY `MAJOR_UNIVERSITY_FK2` (`UNIVERSITY`);

--
-- Indexes for table `mii_info`
--
ALTER TABLE `mii_info`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `MII_INFO_PK` (`ID`);

--
-- Indexes for table `organization`
--
ALTER TABLE `organization`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ORGANIZATION_PK` (`ID`),
  ADD KEY `ORGANIZATION_FK` (`EMPLOYEE`);

--
-- Indexes for table `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `PROJECT_PK` (`ID`),
  ADD KEY `PROJECT_FK` (`CLIENT`);

--
-- Indexes for table `project_employee`
--
ALTER TABLE `project_employee`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `PROJECT_EMPLOYEE_PK` (`ID`),
  ADD KEY `PROJECT_EMPLOYEE_FK` (`EMPLOYEE`),
  ADD KEY `PROJECT_EMPLOYEE_FK2` (`PROJECT`);

--
-- Indexes for table `qualification`
--
ALTER TABLE `qualification`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `QUALIFICATION_PK` (`ID`);

--
-- Indexes for table `qualification_employee`
--
ALTER TABLE `qualification_employee`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `QUALIFICATION_EMPLOYEE_PK` (`ID`),
  ADD KEY `QUALIFICATION_EMPLOYEE_FK` (`QUALIFICATION`),
  ADD KEY `QUALIFICATION_EMPLOYEE_FK2` (`EMPLOYEE`);

--
-- Indexes for table `role_mii`
--
ALTER TABLE `role_mii`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ROLE_MII_PK` (`ID`);

--
-- Indexes for table `test`
--
ALTER TABLE `test`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `TEST_PK` (`ID`);

--
-- Indexes for table `test_trigger`
--
ALTER TABLE `test_trigger`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `TEST_TRIGGER_PK` (`ID`);

--
-- Indexes for table `training`
--
ALTER TABLE `training`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `TRAINING_PK` (`ID`),
  ADD KEY `TRAINING_FK` (`EMPLOYEE`);

--
-- Indexes for table `university`
--
ALTER TABLE `university`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `UNIVERSITY_PK` (`ID`);

--
-- Indexes for table `user_mii`
--
ALTER TABLE `user_mii`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `USER_MII_PK` (`ID`),
  ADD KEY `USER_MII_FK` (`ROLE`);

--
-- Indexes for table `work_assignment`
--
ALTER TABLE `work_assignment`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `WORK_ASSIGNMENT_PK` (`ID`),
  ADD KEY `WORK_ASSIGNMENT_FK` (`EMPLOYEE`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `achievement`
--
ALTER TABLE `achievement`
  ADD CONSTRAINT `ACHIEVEMENT_FK` FOREIGN KEY (`EMPLOYEE`) REFERENCES `employee` (`ID`) ON DELETE CASCADE;

--
-- Constraints for table `certification`
--
ALTER TABLE `certification`
  ADD CONSTRAINT `CERTIFICATION_FK` FOREIGN KEY (`EMPLOYEE`) REFERENCES `employee` (`ID`) ON DELETE CASCADE;

--
-- Constraints for table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `CLIENT_CON` FOREIGN KEY (`ID`) REFERENCES `user_mii` (`ID`);

--
-- Constraints for table `education`
--
ALTER TABLE `education`
  ADD CONSTRAINT `EDUCATION_FK` FOREIGN KEY (`MAJOR_UNIVERSITY`) REFERENCES `major_university` (`ID`) ON DELETE CASCADE,
  ADD CONSTRAINT `EDUCATION_FK2` FOREIGN KEY (`EMPLOYEE`) REFERENCES `employee` (`ID`) ON DELETE CASCADE;

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `EMPLOYEE_FK` FOREIGN KEY (`ID`) REFERENCES `user_mii` (`ID`);

--
-- Constraints for table `experience`
--
ALTER TABLE `experience`
  ADD CONSTRAINT `EXPERIENCE_FK` FOREIGN KEY (`EMPLOYEE`) REFERENCES `employee` (`ID`) ON DELETE CASCADE;

--
-- Constraints for table `language_employee`
--
ALTER TABLE `language_employee`
  ADD CONSTRAINT `LANGUAGE_EMPLOYEE_FK` FOREIGN KEY (`LANGUAGE`) REFERENCES `language` (`ID`) ON DELETE CASCADE,
  ADD CONSTRAINT `LANGUAGE_EMPLOYEE_FK2` FOREIGN KEY (`EMPLOYEE`) REFERENCES `employee` (`ID`) ON DELETE CASCADE;

--
-- Constraints for table `major_university`
--
ALTER TABLE `major_university`
  ADD CONSTRAINT `MAJOR_UNIVERSITY_FK` FOREIGN KEY (`MAJOR`) REFERENCES `major` (`ID`) ON DELETE CASCADE,
  ADD CONSTRAINT `MAJOR_UNIVERSITY_FK2` FOREIGN KEY (`UNIVERSITY`) REFERENCES `university` (`ID`) ON DELETE CASCADE;

--
-- Constraints for table `organization`
--
ALTER TABLE `organization`
  ADD CONSTRAINT `ORGANIZATION_FK` FOREIGN KEY (`EMPLOYEE`) REFERENCES `employee` (`ID`) ON DELETE CASCADE;

--
-- Constraints for table `project`
--
ALTER TABLE `project`
  ADD CONSTRAINT `PROJECT_FK` FOREIGN KEY (`CLIENT`) REFERENCES `client` (`ID`) ON DELETE CASCADE;

--
-- Constraints for table `project_employee`
--
ALTER TABLE `project_employee`
  ADD CONSTRAINT `PROJECT_EMPLOYEE_FK` FOREIGN KEY (`EMPLOYEE`) REFERENCES `employee` (`ID`) ON DELETE CASCADE,
  ADD CONSTRAINT `PROJECT_EMPLOYEE_FK2` FOREIGN KEY (`PROJECT`) REFERENCES `project` (`ID`) ON DELETE CASCADE;

--
-- Constraints for table `qualification_employee`
--
ALTER TABLE `qualification_employee`
  ADD CONSTRAINT `QUALIFICATION_EMPLOYEE_FK` FOREIGN KEY (`QUALIFICATION`) REFERENCES `qualification` (`ID`),
  ADD CONSTRAINT `QUALIFICATION_EMPLOYEE_FK2` FOREIGN KEY (`EMPLOYEE`) REFERENCES `employee` (`ID`) ON DELETE CASCADE;

--
-- Constraints for table `training`
--
ALTER TABLE `training`
  ADD CONSTRAINT `TRAINING_FK` FOREIGN KEY (`EMPLOYEE`) REFERENCES `employee` (`ID`);

--
-- Constraints for table `user_mii`
--
ALTER TABLE `user_mii`
  ADD CONSTRAINT `USER_MII_FK` FOREIGN KEY (`ROLE`) REFERENCES `role_mii` (`ID`) ON DELETE CASCADE;

--
-- Constraints for table `work_assignment`
--
ALTER TABLE `work_assignment`
  ADD CONSTRAINT `WORK_ASSIGNMENT_FK` FOREIGN KEY (`EMPLOYEE`) REFERENCES `employee` (`ID`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
