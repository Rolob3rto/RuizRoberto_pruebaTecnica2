-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-01-2024 a las 23:07:34
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `pruebatecnica2`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudadano`
--

CREATE TABLE `ciudadano` (
  `ID` int(11) NOT NULL,
  `APELLIDO` varchar(255) DEFAULT NULL,
  `DNI` varchar(255) DEFAULT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ciudadano`
--

INSERT INTO `ciudadano` (`ID`, `APELLIDO`, `DNI`, `NOMBRE`) VALUES
(1, 'Ruiz', '46521345P', 'Roberto'),
(2, 'Garcia', '34651245L', 'Jeremy'),
(3, 'Juanes', '54152415T', 'Marta'),
(4, 'Gómez', '87654321B', 'Ana'),
(5, 'Fernández', '98765432C', 'Carlos'),
(6, 'López', '23456789D', 'Elena');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `turno`
--

CREATE TABLE `turno` (
  `ID` int(11) NOT NULL,
  `DESCRIPCION` varchar(255) DEFAULT NULL,
  `ESTADO` tinyint(1) DEFAULT 0,
  `FECHA` datetime DEFAULT NULL,
  `NUMERO` int(11) DEFAULT NULL,
  `ciudadano_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `turno`
--

INSERT INTO `turno` (`ID`, `DESCRIPCION`, `ESTADO`, `FECHA`, `NUMERO`, `ciudadano_id`) VALUES
(1, 'descripcion', 1, '2024-01-17 00:00:00', 12345, 1),
(2, 'descripcion 2', 0, '2024-01-17 00:00:00', 12345, 2),
(3, 'Trámite A', 1, '2024-01-17 00:00:00', 1, 1),
(4, 'Trámite B', 0, '2024-01-02 00:00:00', 2, 2),
(5, 'Trámite C', 1, '2024-01-03 00:00:00', 3, 3),
(6, 'Trámite D', 0, '2024-01-04 00:00:00', 4, 4),
(7, 'Trámite E', 1, '2024-01-17 00:00:00', 5, 5),
(8, 'Trámite F', 0, '2024-01-17 00:00:00', 6, 6),
(9, 'Trámite G', 1, '2024-01-01 00:00:00', 7, 1),
(10, 'Trámite H', 0, '2024-01-02 00:00:00', 8, 2),
(11, 'Trámite I', 1, '2024-01-03 00:00:00', 9, 3),
(12, 'Trámite J', 0, '2024-01-04 00:00:00', 10, 4);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ciudadano`
--
ALTER TABLE `ciudadano`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `turno`
--
ALTER TABLE `turno`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_TURNO_ciudadano_id` (`ciudadano_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ciudadano`
--
ALTER TABLE `ciudadano`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `turno`
--
ALTER TABLE `turno`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `turno`
--
ALTER TABLE `turno`
  ADD CONSTRAINT `FK_TURNO_ciudadano_id` FOREIGN KEY (`ciudadano_id`) REFERENCES `ciudadano` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
