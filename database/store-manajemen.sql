-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 14 Jan 2023 pada 05.42
-- Versi Server: 10.1.19-MariaDB
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `store-manajemen`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `products`
--

CREATE TABLE `products` (
  `id_product` int(10) NOT NULL,
  `nama_product` varchar(220) NOT NULL,
  `id_supplier` varchar(10) NOT NULL,
  `price` int(20) NOT NULL,
  `quantity` int(10) NOT NULL,
  `id_category` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `products`
--

INSERT INTO `products` (`id_product`, `nama_product`, `id_supplier`, `price`, `quantity`, `id_category`) VALUES
(1, 'pepsodent', '2', 5000, 20, 4),
(2, 'detol', '1', 15000, 40, 4),
(4, 'boncabe', '9', 5000, 34, 10),
(5, 'Sabun', '12', 5000, 5, 5),
(6, 'es cekek', '15', 500000, 2, 8),
(7, 'oreo', '5', 5000, 20, 9);

-- --------------------------------------------------------

--
-- Struktur dari tabel `supplier`
--

CREATE TABLE `supplier` (
  `id_supplier` int(10) NOT NULL,
  `nama_supplier` varchar(220) NOT NULL,
  `alamat_supplier` varchar(50) NOT NULL,
  `no_hp` varchar(14) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `supplier`
--

INSERT INTO `supplier` (`id_supplier`, `nama_supplier`, `alamat_supplier`, `no_hp`) VALUES
(1, 'catur', 'bekasi', '089777666555'),
(2, 'Bembi', 'Klapanunggal', '08533423342'),
(3, 'Hannisa', 'Mekarsari', '0823432456'),
(4, 'Dila', 'Metland', '08465787698'),
(5, 'Syahru', 'Bogor', '0897657654'),
(6, 'Andi', 'Jakarta', '0324454442'),
(7, 'Hetonda', 'Depok', '0098832444');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tabel_user`
--

CREATE TABLE `tabel_user` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tabel_user`
--

INSERT INTO `tabel_user` (`username`, `password`) VALUES
('admin', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id_product`),
  ADD UNIQUE KEY `id_supplier` (`id_supplier`,`id_category`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`id_supplier`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id_product` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `id_supplier` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
