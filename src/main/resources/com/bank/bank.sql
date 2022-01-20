-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 20, 2022 at 08:05 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bank`
--
CREATE DATABASE IF NOT EXISTS `bank` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `bank`;

-- --------------------------------------------------------

--
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
CREATE TABLE `clients` (
  `id_clt` bigint(30) NOT NULL,
  `nomPrenom` varchar(30) NOT NULL,
  `date_n` date DEFAULT NULL,
  `tel` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `adr` longtext DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `clients`
--

INSERT INTO `clients` (`id_clt`, `nomPrenom`, `date_n`, `tel`, `email`, `adr`) VALUES(1, 'Oumayma Redissi', '2001-12-11', '90909090', 'oumayma@oumayma.com', 'azertyuiopqsdfghjklmcvbn, fgbnyt,u');
INSERT INTO `clients` (`id_clt`, `nomPrenom`, `date_n`, `tel`, `email`, `adr`) VALUES(2, 'Chaima Mezgar', '2001-12-20', 'aaaa', 'chaima@chaima.com', 'esxrdtfyguhjikosezrdctvygbhunji,ksedrctfgyhbnjisetdrcfgybhujidxcfgvhbj');
INSERT INTO `clients` (`id_clt`, `nomPrenom`, `date_n`, `tel`, `email`, `adr`) VALUES(22, 'LINA REDISSI', '2006-12-16', '22334455', 'LINA@LINA.COM', 'AZERTY');
INSERT INTO `clients` (`id_clt`, `nomPrenom`, `date_n`, `tel`, `email`, `adr`) VALUES(36, 'Mahmoud Mzoughi', '2021-12-15', '1919199191', 'gfchgvjhkj@lkjhgfc', 'plmkoijuhgfghjkl');
INSERT INTO `clients` (`id_clt`, `nomPrenom`, `date_n`, `tel`, `email`, `adr`) VALUES(98765432, 'KIJHUFYD6E5SYDTFYGH', '2021-12-17', '23456789', 'ZERTYUGHJ', 'JNBGSZDFGBHJK. ');

-- --------------------------------------------------------

--
-- Table structure for table `comptes`
--

DROP TABLE IF EXISTS `comptes`;
CREATE TABLE `comptes` (
  `num_c` bigint(30) NOT NULL,
  `type_c` varchar(30) NOT NULL,
  `solde_c` double NOT NULL,
  `id_c` bigint(30) NOT NULL,
  `etat` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `comptes`
--

INSERT INTO `comptes` (`num_c`, `type_c`, `solde_c`, `id_c`, `etat`) VALUES(2, 'COURANT', 11888, 1, 1);
INSERT INTO `comptes` (`num_c`, `type_c`, `solde_c`, `id_c`, `etat`) VALUES(3, 'COURANT', 100, 1, 1);
INSERT INTO `comptes` (`num_c`, `type_c`, `solde_c`, `id_c`, `etat`) VALUES(4, 'EPARGNE', 0, 1, 1);
INSERT INTO `comptes` (`num_c`, `type_c`, `solde_c`, `id_c`, `etat`) VALUES(5, 'COURANT', 0, 2, 1);
INSERT INTO `comptes` (`num_c`, `type_c`, `solde_c`, `id_c`, `etat`) VALUES(6, 'COURANT', 1300, 2, 1);
INSERT INTO `comptes` (`num_c`, `type_c`, `solde_c`, `id_c`, `etat`) VALUES(7, 'EPARGNE', 300, 2, 1);
INSERT INTO `comptes` (`num_c`, `type_c`, `solde_c`, `id_c`, `etat`) VALUES(8, 'EPARGNE', 0, 1, 1);
INSERT INTO `comptes` (`num_c`, `type_c`, `solde_c`, `id_c`, `etat`) VALUES(9, 'EPARGNE', -20, 36, 1);
INSERT INTO `comptes` (`num_c`, `type_c`, `solde_c`, `id_c`, `etat`) VALUES(10, 'EPARGNE', 0, 2, 1);
INSERT INTO `comptes` (`num_c`, `type_c`, `solde_c`, `id_c`, `etat`) VALUES(11, 'COURANT', 0, 2, 1);
INSERT INTO `comptes` (`num_c`, `type_c`, `solde_c`, `id_c`, `etat`) VALUES(12, 'COURANT', 400, 36, 1);
INSERT INTO `comptes` (`num_c`, `type_c`, `solde_c`, `id_c`, `etat`) VALUES(13, 'EPARGNE', 859999890833408, 22, 1);

-- --------------------------------------------------------

--
-- Table structure for table `operations`
--

DROP TABLE IF EXISTS `operations`;
CREATE TABLE `operations` (
  `id_op` int(11) NOT NULL,
  `nom_op` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `operations`
--

INSERT INTO `operations` (`id_op`, `nom_op`) VALUES(1, 'Depot');
INSERT INTO `operations` (`id_op`, `nom_op`) VALUES(2, 'Retrait');
INSERT INTO `operations` (`id_op`, `nom_op`) VALUES(3, 'Virement');

-- --------------------------------------------------------

--
-- Table structure for table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
CREATE TABLE `transactions` (
  `num_op` bigint(20) NOT NULL,
  `type_op` int(11) NOT NULL,
  `date_op` datetime NOT NULL,
  `mnt_op` float NOT NULL,
  `num_c_em` bigint(20) NOT NULL,
  `num_c_ben` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transactions`
--

INSERT INTO `transactions` (`num_op`, `type_op`, `date_op`, `mnt_op`, `num_c_em`, `num_c_ben`) VALUES(9090990, 1, '2021-12-13 21:07:06', 90000, 2, NULL);
INSERT INTO `transactions` (`num_op`, `type_op`, `date_op`, `mnt_op`, `num_c_em`, `num_c_ben`) VALUES(9090991, 2, '2021-12-13 21:17:27', 90000, 8, NULL);
INSERT INTO `transactions` (`num_op`, `type_op`, `date_op`, `mnt_op`, `num_c_em`, `num_c_ben`) VALUES(9090992, 3, '2021-12-13 21:31:48', 90001, 7, 4);
INSERT INTO `transactions` (`num_op`, `type_op`, `date_op`, `mnt_op`, `num_c_em`, `num_c_ben`) VALUES(9090993, 1, '2021-12-13 23:57:44', 1234, 2, NULL);
INSERT INTO `transactions` (`num_op`, `type_op`, `date_op`, `mnt_op`, `num_c_em`, `num_c_ben`) VALUES(9090995, 1, '2021-12-14 00:29:50', 1234, 2, NULL);
INSERT INTO `transactions` (`num_op`, `type_op`, `date_op`, `mnt_op`, `num_c_em`, `num_c_ben`) VALUES(9090996, 1, '2021-12-14 00:00:00', 900, 2, NULL);
INSERT INTO `transactions` (`num_op`, `type_op`, `date_op`, `mnt_op`, `num_c_em`, `num_c_ben`) VALUES(9090997, 1, '2021-12-14 00:00:00', 400, 4, NULL);
INSERT INTO `transactions` (`num_op`, `type_op`, `date_op`, `mnt_op`, `num_c_em`, `num_c_ben`) VALUES(9090998, 1, '2021-12-14 00:00:00', 400, 4, NULL);
INSERT INTO `transactions` (`num_op`, `type_op`, `date_op`, `mnt_op`, `num_c_em`, `num_c_ben`) VALUES(9090999, 1, '2021-12-14 00:00:00', 5000, 2, NULL);
INSERT INTO `transactions` (`num_op`, `type_op`, `date_op`, `mnt_op`, `num_c_em`, `num_c_ben`) VALUES(9091000, 1, '2021-12-14 00:00:00', 5000, 2, NULL);
INSERT INTO `transactions` (`num_op`, `type_op`, `date_op`, `mnt_op`, `num_c_em`, `num_c_ben`) VALUES(9091001, 3, '2021-12-14 00:00:00', 300, 4, 6);
INSERT INTO `transactions` (`num_op`, `type_op`, `date_op`, `mnt_op`, `num_c_em`, `num_c_ben`) VALUES(9091002, 3, '2021-12-14 00:00:00', 300, 4, 6);
INSERT INTO `transactions` (`num_op`, `type_op`, `date_op`, `mnt_op`, `num_c_em`, `num_c_ben`) VALUES(9091003, 3, '2021-12-14 00:00:00', 400, 4, 7);
INSERT INTO `transactions` (`num_op`, `type_op`, `date_op`, `mnt_op`, `num_c_em`, `num_c_ben`) VALUES(9091004, 2, '2021-12-14 00:00:00', 700, 2, NULL);
INSERT INTO `transactions` (`num_op`, `type_op`, `date_op`, `mnt_op`, `num_c_em`, `num_c_ben`) VALUES(9091005, 2, '2021-12-14 00:00:00', 700, 2, NULL);
INSERT INTO `transactions` (`num_op`, `type_op`, `date_op`, `mnt_op`, `num_c_em`, `num_c_ben`) VALUES(9091006, 2, '2021-12-14 00:00:00', 1000, 2, NULL);
INSERT INTO `transactions` (`num_op`, `type_op`, `date_op`, `mnt_op`, `num_c_em`, `num_c_ben`) VALUES(9091007, 1, '2021-12-14 00:00:00', 980, 9, NULL);
INSERT INTO `transactions` (`num_op`, `type_op`, `date_op`, `mnt_op`, `num_c_em`, `num_c_ben`) VALUES(9091008, 2, '2021-12-14 00:00:00', 100, 9, NULL);
INSERT INTO `transactions` (`num_op`, `type_op`, `date_op`, `mnt_op`, `num_c_em`, `num_c_ben`) VALUES(9091009, 2, '2021-12-14 00:00:00', 1000, 9, NULL);
INSERT INTO `transactions` (`num_op`, `type_op`, `date_op`, `mnt_op`, `num_c_em`, `num_c_ben`) VALUES(9091010, 3, '2021-12-14 00:00:00', 100, 9, 2);
INSERT INTO `transactions` (`num_op`, `type_op`, `date_op`, `mnt_op`, `num_c_em`, `num_c_ben`) VALUES(9091011, 1, '2021-12-14 00:00:00', 400, 12, NULL);
INSERT INTO `transactions` (`num_op`, `type_op`, `date_op`, `mnt_op`, `num_c_em`, `num_c_ben`) VALUES(9091012, 3, '2021-12-14 00:00:00', 12, 2, 3);
INSERT INTO `transactions` (`num_op`, `type_op`, `date_op`, `mnt_op`, `num_c_em`, `num_c_ben`) VALUES(9091013, 1, '2021-12-14 00:00:00', 1e15, 13, NULL);
INSERT INTO `transactions` (`num_op`, `type_op`, `date_op`, `mnt_op`, `num_c_em`, `num_c_ben`) VALUES(9091014, 2, '2021-12-14 00:00:00', 100000000000000, 13, NULL);
INSERT INTO `transactions` (`num_op`, `type_op`, `date_op`, `mnt_op`, `num_c_em`, `num_c_ben`) VALUES(9091015, 2, '2021-12-14 00:00:00', 10000000000000, 13, NULL);
INSERT INTO `transactions` (`num_op`, `type_op`, `date_op`, `mnt_op`, `num_c_em`, `num_c_ben`) VALUES(9091016, 2, '2021-12-14 00:00:00', 10000000000000, 13, NULL);
INSERT INTO `transactions` (`num_op`, `type_op`, `date_op`, `mnt_op`, `num_c_em`, `num_c_ben`) VALUES(9091017, 2, '2021-12-14 00:00:00', 10000000000000, 13, NULL);
INSERT INTO `transactions` (`num_op`, `type_op`, `date_op`, `mnt_op`, `num_c_em`, `num_c_ben`) VALUES(9091018, 2, '2021-12-14 00:00:00', 10000000000000, 13, NULL);
INSERT INTO `transactions` (`num_op`, `type_op`, `date_op`, `mnt_op`, `num_c_em`, `num_c_ben`) VALUES(9091019, 2, '2021-12-14 00:00:00', 1, 3, NULL);
INSERT INTO `transactions` (`num_op`, `type_op`, `date_op`, `mnt_op`, `num_c_em`, `num_c_ben`) VALUES(9091020, 2, '2021-12-14 00:00:00', 11, 3, NULL);
INSERT INTO `transactions` (`num_op`, `type_op`, `date_op`, `mnt_op`, `num_c_em`, `num_c_ben`) VALUES(9091021, 3, '2021-12-14 00:00:00', 100, 7, 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`id_clt`);

--
-- Indexes for table `comptes`
--
ALTER TABLE `comptes`
  ADD PRIMARY KEY (`num_c`),
  ADD KEY `id_c` (`id_c`);

--
-- Indexes for table `operations`
--
ALTER TABLE `operations`
  ADD PRIMARY KEY (`id_op`);

--
-- Indexes for table `transactions`
--
ALTER TABLE `transactions`
  ADD PRIMARY KEY (`num_op`),
  ADD KEY `num_c_ben` (`num_c_ben`),
  ADD KEY `num_c_em` (`num_c_em`),
  ADD KEY `type_op` (`type_op`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `comptes`
--
ALTER TABLE `comptes`
  MODIFY `num_c` bigint(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `transactions`
--
ALTER TABLE `transactions`
  MODIFY `num_op` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9091022;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `transactions`
--
ALTER TABLE `transactions`
  ADD CONSTRAINT `transactions_ibfk_1` FOREIGN KEY (`num_c_ben`) REFERENCES `comptes` (`num_c`),
  ADD CONSTRAINT `transactions_ibfk_2` FOREIGN KEY (`num_c_em`) REFERENCES `comptes` (`num_c`),
  ADD CONSTRAINT `transactions_ibfk_3` FOREIGN KEY (`type_op`) REFERENCES `operations` (`id_op`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
