-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 11-Jun-2018 às 20:07
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
-- Estrutura da tabela `imoveis`
--

CREATE TABLE `imoveis` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `endereco` varchar(255) NOT NULL,
  `usuario_id` int(11) NOT NULL,
  `tipo_id` int(11) NOT NULL,
  `descricao` mediumtext NOT NULL,
  `tamanho` int(11) NOT NULL,
  `vagas` int(11) NOT NULL,
  `preco_inicial` float NOT NULL,
  `vendido_por` float DEFAULT NULL,
  `listado_em` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `finaliza_em` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
('', '', '', '', '', '', '', 1, 'andressa', '12345'),
('', '', '', '', '', '', '', 2, 'andressa', '12345');

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
