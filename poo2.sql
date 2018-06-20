-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 20-Jun-2018 às 05:01
-- Versão do servidor: 10.1.31-MariaDB
-- PHP Version: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `poo2`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `nome` varchar(30) NOT NULL,
  `cpf` varchar(20) NOT NULL,
  `telefone` varchar(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `endereco` varchar(50) NOT NULL,
  `sexo` varchar(1) NOT NULL,
  `data_nasc` varchar(12) NOT NULL,
  `id` int(11) NOT NULL,
  `user` varchar(20) NOT NULL,
  `senha` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`nome`, `cpf`, `telefone`, `email`, `endereco`, `sexo`, `data_nasc`, `id`, `user`, `senha`) VALUES
('andressa', '03857674040', '96964947', 'andressakotz@hotmail.com', 'salvador das missoes', 'f', '2000/01/01', 3, 'andressakotz', '12345'),
('a', 'a', 'a', 'a', 'a', 'a', 'a', 6, 'a', 'a'),
('denise', '71292942053', '97239712', 'denise_kotz@hotmail.com', 'vila santa catarina', 'f', '1969/01/07', 7, 'denisekotz', '12345'),
('bruna', '23432432', '2432432', 'bruna@trindade.com', 'santo angelo', 'f', '2324/54/34', 8, 'bruna', 'bruna'),
('nelmo', '55733905034', '91599455', 'nelmo@aloisio.com', 'salvador das missoes', 'm', '1966/03/16', 9, 'nelmo', '123'),
('douglas', '23232323232', '23232323', 'douglas@rech.com', 'salvador', 'm', '2343/34/23', 10, 'douglas', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
