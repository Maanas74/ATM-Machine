-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 02, 2020 at 04:37 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `atm`
--

-- --------------------------------------------------------

--
-- Table structure for table `details`
--

CREATE TABLE `details` (
  `S.No` int(1) NOT NULL,
  `Username` varchar(255) NOT NULL,
  `PIN` int(4) NOT NULL,
  `Phone_No` bigint(10) NOT NULL,
  `Account_no.` bigint(9) NOT NULL,
  `IFSC_code` varchar(255) NOT NULL,
  `Bank_Name` varchar(255) NOT NULL,
  `Amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `details`
--

INSERT INTO `details` (`S.No`, `Username`, `PIN`, `Phone_No`, `Account_no.`, `IFSC_code`, `Bank_Name`, `Amount`) VALUES
(1, 'Ram', 1001, 9235672324, 100000001, 'SBI1001B', 'SBI', 109000),
(2, 'Raj', 1002, 9235465762, 100000002, 'SBI1002B', 'SBI', 50000),
(3, 'Raju', 1003, 9543267854, 100000003, 'PNB1001P', 'PNB', 200000),
(4, 'Ramu', 1004, 9543263214, 100000004, 'SBI1003B', 'SBI', 20000),
(5, 'Kishan', 1005, 9543267834, 100000005, 'PNB1002P', 'PNB', 600000),
(6, 'Kish', 1006, 1543267814, 100000006, 'PNB1003P', 'PNB', 100000),
(7, 'Aak', 1007, 1543268914, 100000007, 'PNB1004P', 'PNB', 50000),
(8, 'Luv', 1008, 2147483647, 100000008, 'PNB1005P', 'PNB', 60000),
(9, 'lovera', 1029, 9999112387, 100000009, 'PNB1006P', 'PNB', 31700),
(10, 'Dulha', 1010, 1547987854, 100000010, 'SBI1004B', 'SBI', 20000),
(11, 'Dhruv', 1011, 1547237854, 100000011, 'SBI1005B', 'SBI', 200500),
(12, 'Abhinav', 1012, 1547887854, 100000012, 'SBI1006B', 'SBI', 100000),
(13, 'Aviney', 1013, 1547997854, 100000013, 'SBI1007B', 'SBI', 30000),
(14, 'Abhishek', 1014, 1543276554, 100000014, 'PNB1007P', 'PNB', 80000),
(15, 'Amal', 1015, 1543225454, 100000015, 'PNB1008P', 'PNB', 90000),
(16, 'Anmol', 1016, 1543122354, 100000016, 'PNB1009P', 'PNB', 100000),
(17, 'Harsh', 1017, 1543211254, 100000017, 'PNB1010P', 'PNB', 150000),
(18, 'Harshdeep', 1018, 1543522854, 100000018, 'SBI1008B', 'SBI', 15000),
(19, 'Arsh', 1019, 1543262434, 100000019, 'SBI1009B', 'SBI', 20000),
(20, 'Arshdeep', 1020, 1543268874, 100000020, 'SBI1010B', 'SBI', 350000),
(21, 'Manu', 1021, 1543267890, 100000021, 'SBI1011B', 'SBI', 250000),
(22, 'Pinku', 1022, 1543267112, 100000022, 'SBI1012B', 'SBI', 35000),
(23, 'Lalpal', 1023, 1543267344, 100000023, 'PNB1011P', 'PNB', 150000),
(24, 'Preetpal', 1024, 1543267000, 100000024, 'PNB1012P', 'PNB', 25000),
(25, 'Zender', 1025, 1543267098, 100000025, 'SBI1013B', 'SBI', 35000),
(26, 'diyan', 1026, 9876455561, 100000026, 'PNB10013P', 'PNB', 3500);

-- --------------------------------------------------------

--
-- Table structure for table `statement`
--

CREATE TABLE `statement` (
  `S_No` int(1) NOT NULL,
  `Username` varchar(255) NOT NULL,
  `PIN` int(4) NOT NULL,
  `Deb_Cre` varchar(255) NOT NULL,
  `Amount` int(15) NOT NULL,
  `Date` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `statement`
--

INSERT INTO `statement` (`S_No`, `Username`, `PIN`, `Deb_Cre`, `Amount`, `Date`) VALUES
(1, 'lovera', 1009, 'CR', 5000, '2020-11-18'),
(2, 'lovera', 1009, 'DR', 2000, '2020-11-18'),
(3, 'lovera', 1009, 'DR', 500, '2020-11-18'),
(4, 'lovera', 1009, 'DR', 1000, '2020-11-18'),
(5, 'lovera', 1009, 'CR', 1000, '2020-11-18'),
(6, 'lovera', 1009, 'CR', 2000, '2020-11-18'),
(7, 'lovera', 1009, 'DR', 2000, '2020-11-20'),
(8, 'lovera', 1009, 'DR', 4000, '2020-11-20'),
(9, 'lovera', 1009, 'CR', 1000, '2020-11-20'),
(10, 'lovera', 1009, 'DR', 2000, '2020-11-20'),
(11, 'lovera', 1009, 'DR', 2000, '2020-11-20'),
(12, 'lovera', 1009, 'DR', 1000, '2020-11-20'),
(13, 'lovera', 1009, 'DR', 2000, '2020-11-20'),
(14, 'lovera', 1009, 'DR', 2000, '2020-11-20'),
(15, 'Ram', 1001, 'DR', 2500, '2020-11-20'),
(16, 'lovera', 1009, 'CR', 200, '2020-11-22'),
(17, 'lovera', 1009, 'DR', 4000, '2020-11-25'),
(18, 'lovera', 1009, 'DR', 4000, '2020-11-29'),
(19, 'lovera', 1009, 'CR', 2000, '2020-12-01'),
(20, 'lovera', 1009, 'DR', 1000, '2020-12-01'),
(21, 'lovera', 1009, 'DR', 500, '2020-12-01'),
(22, 'lovera', 1009, 'DR', 3000, '2020-12-01');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `details`
--
ALTER TABLE `details`
  ADD PRIMARY KEY (`S.No`);

--
-- Indexes for table `statement`
--
ALTER TABLE `statement`
  ADD PRIMARY KEY (`S_No`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `details`
--
ALTER TABLE `details`
  MODIFY `S.No` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `statement`
--
ALTER TABLE `statement`
  MODIFY `S_No` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
