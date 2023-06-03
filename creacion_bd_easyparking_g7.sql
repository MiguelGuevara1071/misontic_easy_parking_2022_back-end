-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-09-2022 a las 23:20:38
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `easyparkingg7`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_plaza_factura`
--

CREATE TABLE `detalle_plaza_factura` (
  `id_detalle` int(11) NOT NULL,
  `id_plaza` int(11) NOT NULL,
  `id_factura` int(11) NOT NULL,
  `valor_pago` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura_vehiculo`
--

CREATE TABLE `factura_vehiculo` (
  `id_factura` int(11) NOT NULL,
  `fecha_ingreso` varchar(15) NOT NULL,
  `hora_entrada` varchar(15) NOT NULL,
  `hora_salida` varchar(15) DEFAULT NULL,
  `tipo_vehiculo` varchar(15) NOT NULL,
  `placa_vehiculo` varchar(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `plazas`
--

CREATE TABLE `plazas` (
  `id_plaza` int(11) NOT NULL,
  `codigo_plaza` varchar(10) NOT NULL,
  `estado` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `detalle_plaza_factura`
--
ALTER TABLE `detalle_plaza_factura`
  ADD PRIMARY KEY (`id_detalle`),
  ADD KEY `fk_id_factura` (`id_factura`),
  ADD KEY `fk_id_plaza` (`id_plaza`);

--
-- Indices de la tabla `factura_vehiculo`
--
ALTER TABLE `factura_vehiculo`
  ADD PRIMARY KEY (`id_factura`);

--
-- Indices de la tabla `plazas`
--
ALTER TABLE `plazas`
  ADD PRIMARY KEY (`id_plaza`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `detalle_plaza_factura`
--
ALTER TABLE `detalle_plaza_factura`
  MODIFY `id_detalle` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `factura_vehiculo`
--
ALTER TABLE `factura_vehiculo`
  MODIFY `id_factura` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `plazas`
--
ALTER TABLE `plazas`
  MODIFY `id_plaza` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalle_plaza_factura`
--
ALTER TABLE `detalle_plaza_factura`
  ADD CONSTRAINT `fk_id_factura` FOREIGN KEY (`id_factura`) REFERENCES `factura_vehiculo` (`id_factura`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_id_plaza` FOREIGN KEY (`id_plaza`) REFERENCES `plazas` (`id_plaza`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
