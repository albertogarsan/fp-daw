-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-05-2022 a las 10:24:59
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdlibros`
--

CREATE DATABASE `bdlibros`;
USE `bdlibros`;

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `libros`
--

CREATE TABLE `libros` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `autor` bigint(20) NOT NULL REFERENCES autores(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 
-- Estructura de tabla para la tabla `autores`
--
CREATE TABLE `autores`(
	id bigint(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nom varchar(255) NOT NULL
);


--
-- Volcado de datos para la tabla `libros`
--

INSERT INTO `libros` (`id`, `nombre`, `precio`, autor) VALUES
(1, 'Manual de Microservicios', 50, 1),
(2, 'Java 18', 20, 1),
(3, 'Programa en Android', 15, 2),
(4, 'Curso de Acceso a Datos', 8, 1),
(5, 'Programación Web', 10, 1),
(6, 'Node.js', 50, 1);

--
-- Volcado de datos para la tabla `autors`
--
INSERT INTO autores (id, nom) VALUES
(1, 'Alberto Garcia'),
(2, 'Blasco Ibáñez');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `libros`
--
ALTER TABLE `libros`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `libros`
--
ALTER TABLE `libros`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
