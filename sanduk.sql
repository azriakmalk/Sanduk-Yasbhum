-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 13, 2020 at 05:22 AM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sanduk`
--

-- --------------------------------------------------------

--
-- Table structure for table `anggota`
--

CREATE TABLE `anggota` (
  `NRP` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `id_pangkat` varchar(11) NOT NULL,
  `id_kesatuan` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `anggota`
--

INSERT INTO `anggota` (`NRP`, `nama`, `id_pangkat`, `id_kesatuan`) VALUES
(1, 'budi', 'p01', 'k01'),
(2, 'lolo', 'P03', 'k02'),
(3, 'Votre', 'P01', 'k01'),
(4, 'didit', 'P01', 'k01'),
(5, 'roxanne', 'P01', 'k01'),
(6, 'sunday', 'P01', 'k01'),
(7, 'alwd', 'P01', 'k01'),
(8, 'ww', 'P01', 'k01'),
(9, 'asd', 'P01', 'k01'),
(10, 'klaje', 'P01', 'k01'),
(11, 'eqwqw', 'P02', 'k02'),
(12, 'dhimas', 'P01', 'k01');

-- --------------------------------------------------------

--
-- Table structure for table `kesatuan`
--

CREATE TABLE `kesatuan` (
  `id_kesatuan` varchar(11) NOT NULL,
  `kesatuan` varchar(30) NOT NULL,
  `jumlah_anggota` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kesatuan`
--

INSERT INTO `kesatuan` (`id_kesatuan`, `kesatuan`, `jumlah_anggota`) VALUES
('k01', 'lantamal', 10),
('k02', 'lantamal ii', 2);

-- --------------------------------------------------------

--
-- Table structure for table `pangkat`
--

CREATE TABLE `pangkat` (
  `id_pangkat` varchar(11) NOT NULL,
  `pangkat` varchar(25) NOT NULL,
  `Jumlah_santunan` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pangkat`
--

INSERT INTO `pangkat` (`id_pangkat`, `pangkat`, `Jumlah_santunan`) VALUES
('P01', 'JENDRAL', 20000000),
('P02', 'LETJEN', 17500000),
('P03', 'MAYJEN', 15000000),
('P04', 'BRIGJEN', 12500000),
('P05', 'KOLONEL', 10000000),
('P06', 'LETKOL', 8500000),
('P07', 'MAYOR', 7500000),
('P08', 'KAPTEN', 6000000),
('P09', 'LETTU', 5500000),
('P10', 'LETDA', 5000000),
('P11', 'PELTU', 4000000),
('P12', 'PELDA', 3500000),
('P13', 'SERSAN MAYOR', 3000000),
('P14', 'SERSAN KEPALA', 2750000),
('P15', 'SERTU', 2500000),
('PA01', 'ANUMERTA JENDRAL', 20000000),
('PA02', 'ANUMERTA LETJEN', 17500000);

-- --------------------------------------------------------

--
-- Table structure for table `petugas`
--

CREATE TABLE `petugas` (
  `id` varchar(11) NOT NULL,
  `Nama` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `telp` varchar(15) NOT NULL,
  `akses` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `petugas`
--

INSERT INTO `petugas` (`id`, `Nama`, `Password`, `email`, `telp`, `akses`) VALUES
('1', 'admin', 'admin', 'admin@admin.com', '02199999999', 'Admin'),
('2', 'zrai', 'zrai', 'zrai@troll.com', '08128991273', 'Admin'),
('3', 'dhim', 'dhimas', 'dhimdhimboom@gmail.com', '085882736172', 'Petugas');

-- --------------------------------------------------------

--
-- Table structure for table `santunan`
--

CREATE TABLE `santunan` (
  `id_santunan` varchar(11) NOT NULL,
  `nrp` int(13) NOT NULL,
  `tanggal_meninggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `santunan`
--

INSERT INTO `santunan` (`id_santunan`, `nrp`, `tanggal_meninggal`) VALUES
('s01', 1, '2020-03-02'),
('s02', 4, '2020-03-02');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `anggota`
--
ALTER TABLE `anggota`
  ADD PRIMARY KEY (`NRP`);

--
-- Indexes for table `kesatuan`
--
ALTER TABLE `kesatuan`
  ADD PRIMARY KEY (`id_kesatuan`);

--
-- Indexes for table `pangkat`
--
ALTER TABLE `pangkat`
  ADD PRIMARY KEY (`id_pangkat`);

--
-- Indexes for table `petugas`
--
ALTER TABLE `petugas`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `santunan`
--
ALTER TABLE `santunan`
  ADD PRIMARY KEY (`id_santunan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
