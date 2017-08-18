CREATE DATABASE  IF NOT EXISTS `odontosys` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `odontosys`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: odontosys
-- ------------------------------------------------------
-- Server version	5.4.3-beta-community

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `agenda`
--

DROP TABLE IF EXISTS `agenda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agenda` (
  `idAgenda` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `fk_paciente` int(11) NOT NULL,
  `fk_doctor` int(11) NOT NULL,
  `hora` varchar(5) NOT NULL,
  `motivo` int(11) NOT NULL,
  `estado` varchar(20) NOT NULL DEFAULT 'Pendiente',
  `fk_orden` int(11) DEFAULT NULL,
  PRIMARY KEY (`idAgenda`),
  KEY `fk_paciente_idx` (`fk_paciente`),
  KEY `fk_doctor_idx` (`fk_doctor`),
  KEY `fk_servicioagenda_idx` (`motivo`),
  KEY `fk_ordenagenda_idx` (`fk_orden`),
  CONSTRAINT `fk_doctor` FOREIGN KEY (`fk_doctor`) REFERENCES `doctor` (`idDoctor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ordenagenda` FOREIGN KEY (`fk_orden`) REFERENCES `orden_servicio` (`idorden_servicio`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_paciente` FOREIGN KEY (`fk_paciente`) REFERENCES `paciente` (`idPaciente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_servicioagenda` FOREIGN KEY (`motivo`) REFERENCES `servicio` (`idservicio`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `caja`
--

DROP TABLE IF EXISTS `caja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `caja` (
  `idcaja` int(11) NOT NULL AUTO_INCREMENT,
  `fk_mov_empresa` int(11) DEFAULT NULL,
  `fk_mov_paciente` int(11) DEFAULT NULL,
  `descripcion` varchar(300) NOT NULL,
  `entrada` int(11) DEFAULT NULL,
  `salida` int(11) DEFAULT NULL,
  `tipo` varchar(100) NOT NULL,
  PRIMARY KEY (`idcaja`),
  KEY `fk_caja_movempresa_idx` (`fk_mov_empresa`),
  KEY `fk_caja_movpaciente_idx` (`fk_mov_paciente`),
  CONSTRAINT `fk_caja_movempresa` FOREIGN KEY (`fk_mov_empresa`) REFERENCES `movimiento_empresa` (`idmovimiento_empresa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_caja_movpaciente` FOREIGN KEY (`fk_mov_paciente`) REFERENCES `movimiento` (`idmovimiento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `convenio`
--

DROP TABLE IF EXISTS `convenio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `convenio` (
  `idconvenio` int(11) NOT NULL AUTO_INCREMENT,
  `fk_empresa` int(11) NOT NULL,
  `fk_paciente` int(11) NOT NULL,
  `fk_servicio` int(11) NOT NULL,
  `porcentaje` int(11) NOT NULL DEFAULT '0',
  `observacion` varchar(200) DEFAULT NULL,
  `estado` varchar(8) NOT NULL DEFAULT 'Activo',
  PRIMARY KEY (`idconvenio`),
  KEY `fk_empconvenio_idx` (`fk_empresa`),
  KEY `fk_paconvenio_idx` (`fk_paciente`),
  KEY `fk_servconvenio_idx` (`fk_servicio`),
  CONSTRAINT `fk_empconvenio` FOREIGN KEY (`fk_empresa`) REFERENCES `empresa` (`idempresa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_paconvenio` FOREIGN KEY (`fk_paciente`) REFERENCES `paciente` (`idPaciente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_servconvenio` FOREIGN KEY (`fk_servicio`) REFERENCES `servicio` (`idservicio`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `detalle_hallazgo`
--

DROP TABLE IF EXISTS `detalle_hallazgo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_hallazgo` (
  `iddetalle_hallazgo` int(11) NOT NULL AUTO_INCREMENT,
  `fk_odontograma` int(11) NOT NULL,
  `fk_hallazgo` int(11) NOT NULL,
  `fk_diente` int(11) NOT NULL,
  `sigla` varchar(4) NOT NULL,
  `ubicacion` varchar(50) NOT NULL,
  `especificacion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`iddetalle_hallazgo`),
  KEY `fk_odontdiente_idx` (`fk_odontograma`),
  KEY `fk_dhallazgo_idx` (`fk_hallazgo`),
  KEY `fk_dhaldient_idx` (`fk_diente`),
  CONSTRAINT `fk_dhaldient` FOREIGN KEY (`fk_diente`) REFERENCES `diente` (`iddiente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_dhallazgo` FOREIGN KEY (`fk_hallazgo`) REFERENCES `hallazgo` (`idhallazgo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_dhalodont` FOREIGN KEY (`fk_odontograma`) REFERENCES `odontograma` (`idodontograma`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `detalle_nota`
--

DROP TABLE IF EXISTS `detalle_nota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_nota` (
  `iddetalle_nota` int(11) NOT NULL AUTO_INCREMENT,
  `fk_notac` int(11) NOT NULL,
  `descripcion` varchar(70) NOT NULL,
  `monto` int(11) NOT NULL,
  PRIMARY KEY (`iddetalle_nota`),
  KEY `fk_notacredito_idx` (`fk_notac`),
  CONSTRAINT `fk_notacredito` FOREIGN KEY (`fk_notac`) REFERENCES `nota_credito` (`idnota_credito`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `detalle_nota_emp`
--

DROP TABLE IF EXISTS `detalle_nota_emp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_nota_emp` (
  `iddetalle_nota_emp` int(11) NOT NULL AUTO_INCREMENT,
  `fk_notacredemp` int(11) NOT NULL,
  `descripcion` varchar(70) NOT NULL,
  `monto` int(11) NOT NULL,
  PRIMARY KEY (`iddetalle_nota_emp`),
  KEY `fk_notacredempresa_idx` (`fk_notacredemp`),
  CONSTRAINT `fk_notacredempresa` FOREIGN KEY (`fk_notacredemp`) REFERENCES `nota_credito_empresa` (`idnota_credito_empresa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `detalle_orden`
--

DROP TABLE IF EXISTS `detalle_orden`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_orden` (
  `iddetalle_orden` int(11) NOT NULL AUTO_INCREMENT,
  `fk_orden_servicio` int(11) NOT NULL,
  `fk_servicio` int(11) NOT NULL,
  `precio` int(11) NOT NULL,
  PRIMARY KEY (`iddetalle_orden`),
  KEY `fk_detorden_idx` (`fk_orden_servicio`),
  KEY `fk_detorservic_idx` (`fk_servicio`),
  CONSTRAINT `fk_detorden` FOREIGN KEY (`fk_orden_servicio`) REFERENCES `orden_servicio` (`idorden_servicio`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detorservic` FOREIGN KEY (`fk_servicio`) REFERENCES `servicio` (`idservicio`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `detalle_recibo`
--

DROP TABLE IF EXISTS `detalle_recibo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_recibo` (
  `iddetalle_recibo` int(11) NOT NULL AUTO_INCREMENT,
  `fk_recibo` int(11) NOT NULL,
  `forma_pago` varchar(45) NOT NULL,
  `monto` int(11) NOT NULL,
  PRIMARY KEY (`iddetalle_recibo`),
  KEY `fk_drecibo_idx` (`fk_recibo`),
  CONSTRAINT `fk_drecibo` FOREIGN KEY (`fk_recibo`) REFERENCES `recibo` (`idrecibo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `detalle_reciboemp`
--

DROP TABLE IF EXISTS `detalle_reciboemp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_reciboemp` (
  `iddetalle_reciboEmp` int(11) NOT NULL AUTO_INCREMENT,
  `fk_recibo_empresa` int(11) NOT NULL,
  `forma_pago` varchar(45) NOT NULL,
  `monto` int(11) NOT NULL,
  PRIMARY KEY (`iddetalle_reciboEmp`),
  KEY `fk_recempdetalle_idx` (`fk_recibo_empresa`),
  CONSTRAINT `fk_recempdetalle` FOREIGN KEY (`fk_recibo_empresa`) REFERENCES `recibo_empresa` (`idrecibo_empresa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `diagnostico`
--

DROP TABLE IF EXISTS `diagnostico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diagnostico` (
  `idDiagnostico` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `fk_paciente` int(11) NOT NULL,
  `resumen_hallazgos` varchar(1500) NOT NULL,
  `plan_tratamiento` varchar(1500) NOT NULL,
  `fk_doctor` int(11) NOT NULL,
  `tipo` varchar(45) NOT NULL DEFAULT 'Interno',
  `fk_odontog_examen` int(11) NOT NULL,
  `empresa` varchar(50) DEFAULT NULL,
  `observaciones` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`idDiagnostico`),
  UNIQUE KEY `idDiagnostico_UNIQUE` (`idDiagnostico`),
  KEY `fk_paciente_idx` (`fk_paciente`),
  KEY `fk_doctor_idx` (`fk_doctor`),
  KEY `fk_odontograma_idx` (`fk_odontog_examen`),
  KEY `fk_diagpaciente_idx` (`fk_paciente`),
  KEY `fk_diagdoctor_idx` (`fk_doctor`),
  KEY `fk_diagodontog_examen_idx` (`fk_odontog_examen`),
  CONSTRAINT `fk_diagdoctor` FOREIGN KEY (`fk_doctor`) REFERENCES `doctor` (`idDoctor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_diagodontog_examen` FOREIGN KEY (`fk_odontog_examen`) REFERENCES `odontograma` (`idodontograma`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_diagpaciente` FOREIGN KEY (`fk_paciente`) REFERENCES `paciente` (`idPaciente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `diente`
--

DROP TABLE IF EXISTS `diente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diente` (
  `iddiente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `nomenclatura` int(11) NOT NULL,
  PRIMARY KEY (`iddiente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doctor` (
  `idDoctor` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(255) NOT NULL,
  `Apellido` varchar(255) NOT NULL,
  `Nro_CI` int(11) NOT NULL,
  `Fecha_Nac` date NOT NULL,
  `Sexo` varchar(1) NOT NULL,
  `Te_LB` varchar(20) DEFAULT NULL,
  `Tel_Cel` varchar(10) DEFAULT NULL,
  `Direccion` varchar(500) NOT NULL,
  `Ciudad` varchar(50) NOT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Reg_Prof` varchar(50) NOT NULL,
  `estado` varchar(8) DEFAULT 'Activo',
  PRIMARY KEY (`idDoctor`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empresa` (
  `idempresa` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `ruc` int(11) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `nombre_contacto` varchar(100) DEFAULT NULL,
  `tel_contacto` varchar(20) DEFAULT NULL,
  `observaciones` varchar(300) DEFAULT NULL,
  `estado` varchar(8) NOT NULL DEFAULT 'Activo',
  PRIMARY KEY (`idempresa`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `factura` (
  `idfactura` int(11) NOT NULL AUTO_INCREMENT,
  `fk_paciente` int(11) NOT NULL,
  `fk_orden` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `tipo_factura` varchar(20) NOT NULL DEFAULT 'Contado',
  `timbrado` int(11) NOT NULL,
  `nro_factura` varchar(15) NOT NULL,
  `descuento` int(11) NOT NULL DEFAULT '0',
  `estado` varchar(20) NOT NULL DEFAULT 'Cancelado',
  `monto_total` int(11) NOT NULL,
  `saldo` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idfactura`),
  KEY `fk_factpaciente_idx` (`fk_paciente`),
  KEY `fk_factorden_idx` (`fk_orden`),
  CONSTRAINT `fk_factorden` FOREIGN KEY (`fk_orden`) REFERENCES `orden_servicio` (`idorden_servicio`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_factpaciente` FOREIGN KEY (`fk_paciente`) REFERENCES `paciente` (`idPaciente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `factura_convenio`
--

DROP TABLE IF EXISTS `factura_convenio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `factura_convenio` (
  `idfactura_convenio` int(11) NOT NULL AUTO_INCREMENT,
  `fk_empresa` int(11) NOT NULL,
  `fk_factura` int(11) NOT NULL,
  `estado` varchar(10) NOT NULL DEFAULT 'Pendiente',
  `monto` int(11) NOT NULL,
  `fk_facturaemp` int(11) DEFAULT NULL,
  PRIMARY KEY (`idfactura_convenio`),
  KEY `fk_pacfacturaconvenio_idx` (`fk_empresa`),
  KEY `fk_facconvenio_idx` (`fk_factura`),
  KEY `fk_factempresa_idx` (`fk_facturaemp`),
  CONSTRAINT `fk_empfacconvenio` FOREIGN KEY (`fk_empresa`) REFERENCES `empresa` (`idempresa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_facconvenio` FOREIGN KEY (`fk_factura`) REFERENCES `factura` (`idfactura`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_factempresa` FOREIGN KEY (`fk_facturaemp`) REFERENCES `factura_empresa` (`idfactura_empresa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `factura_empresa`
--

DROP TABLE IF EXISTS `factura_empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `factura_empresa` (
  `idfactura_empresa` int(11) NOT NULL AUTO_INCREMENT,
  `fk_empresa` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `tipo` varchar(45) NOT NULL DEFAULT 'Contado',
  `timbrado` varchar(45) NOT NULL,
  `nroFactura` varchar(45) NOT NULL,
  `descuento` int(11) DEFAULT NULL,
  `estado` varchar(45) NOT NULL DEFAULT 'Cancelado',
  `saldo` int(11) DEFAULT '0',
  `montoTotal` int(11) NOT NULL,
  PRIMARY KEY (`idfactura_empresa`),
  KEY `fk_empfactura_idx` (`fk_empresa`),
  CONSTRAINT `fk_empfactura` FOREIGN KEY (`fk_empresa`) REFERENCES `empresa` (`idempresa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `hallazgo`
--

DROP TABLE IF EXISTS `hallazgo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hallazgo` (
  `idhallazgo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `simbolol` varchar(50) DEFAULT ' ',
  PRIMARY KEY (`idhallazgo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `movimiento`
--

DROP TABLE IF EXISTS `movimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movimiento` (
  `idmovimiento` int(11) NOT NULL AUTO_INCREMENT,
  `fk_paciente` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `movimiento` varchar(100) NOT NULL,
  `debe` int(11) NOT NULL,
  `haber` int(11) NOT NULL,
  PRIMARY KEY (`idmovimiento`),
  KEY `fk_movpaciente_idx` (`fk_paciente`),
  CONSTRAINT `fk_movpaciente` FOREIGN KEY (`fk_paciente`) REFERENCES `paciente` (`idPaciente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `movimiento_empresa`
--

DROP TABLE IF EXISTS `movimiento_empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movimiento_empresa` (
  `idmovimiento_empresa` int(11) NOT NULL AUTO_INCREMENT,
  `fk_empresa` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `movimiento` varchar(100) NOT NULL,
  `debe` int(11) NOT NULL,
  `haber` int(11) NOT NULL,
  `fk_factura` int(11) DEFAULT NULL,
  `fk_recibo` int(11) DEFAULT NULL,
  `fk_nota` int(11) DEFAULT NULL,
  PRIMARY KEY (`idmovimiento_empresa`),
  KEY `fk_movimempresa_idx` (`fk_empresa`),
  KEY `fk_movempfactura_idx` (`fk_factura`),
  KEY `fk_movemprecibo_idx` (`fk_recibo`),
  KEY `fk_movempnota_idx` (`fk_nota`),
  CONSTRAINT `fk_movempfactura` FOREIGN KEY (`fk_factura`) REFERENCES `factura_empresa` (`idfactura_empresa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_movempnota` FOREIGN KEY (`fk_nota`) REFERENCES `nota_credito_empresa` (`idnota_credito_empresa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_movemprecibo` FOREIGN KEY (`fk_recibo`) REFERENCES `recibo_empresa` (`idrecibo_empresa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_movimempresa` FOREIGN KEY (`fk_empresa`) REFERENCES `empresa` (`idempresa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `nota_credito`
--

DROP TABLE IF EXISTS `nota_credito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nota_credito` (
  `idnota_credito` int(11) NOT NULL AUTO_INCREMENT,
  `fk_paciente` int(11) NOT NULL,
  `fk_factura` int(11) NOT NULL,
  `fk_usuario` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `total` int(11) NOT NULL,
  PRIMARY KEY (`idnota_credito`),
  KEY `fk_pacnotac_idx` (`fk_paciente`),
  KEY `fk_facnotac_idx` (`fk_factura`),
  KEY `fk_usnotac_idx` (`fk_usuario`),
  CONSTRAINT `fk_facnotac` FOREIGN KEY (`fk_factura`) REFERENCES `factura` (`idfactura`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pacnotac` FOREIGN KEY (`fk_paciente`) REFERENCES `paciente` (`idPaciente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usnotac` FOREIGN KEY (`fk_usuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `nota_credito_empresa`
--

DROP TABLE IF EXISTS `nota_credito_empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nota_credito_empresa` (
  `idnota_credito_empresa` int(11) NOT NULL AUTO_INCREMENT,
  `fk_empresa` int(11) NOT NULL,
  `fk_facturaemp` int(11) NOT NULL,
  `fk_usuario` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `total` int(11) NOT NULL,
  PRIMARY KEY (`idnota_credito_empresa`),
  KEY `fk_empnotac_idx` (`fk_empresa`),
  KEY `fk_facempnotac_idx` (`fk_facturaemp`),
  KEY `fk_usempnotac_idx` (`fk_usuario`),
  CONSTRAINT `fk_empnotac` FOREIGN KEY (`fk_empresa`) REFERENCES `empresa` (`idempresa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_facempnotac` FOREIGN KEY (`fk_facturaemp`) REFERENCES `factura_empresa` (`idfactura_empresa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usempnotac` FOREIGN KEY (`fk_usuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `odontograma`
--

DROP TABLE IF EXISTS `odontograma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `odontograma` (
  `idodontograma` int(11) NOT NULL AUTO_INCREMENT,
  `fk_paciente` int(11) NOT NULL,
  `fk_doctor` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `tipo` varchar(20) NOT NULL,
  PRIMARY KEY (`idodontograma`),
  KEY `fk_docOdont_idx` (`fk_doctor`),
  KEY `fk_pacOdont_idx` (`fk_paciente`),
  CONSTRAINT `fk_docOdont` FOREIGN KEY (`fk_doctor`) REFERENCES `doctor` (`idDoctor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pacOdont` FOREIGN KEY (`fk_paciente`) REFERENCES `paciente` (`idPaciente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `orden_servicio`
--

DROP TABLE IF EXISTS `orden_servicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orden_servicio` (
  `idorden_servicio` int(11) NOT NULL AUTO_INCREMENT,
  `fk_paciente` int(11) NOT NULL,
  `fk_odontograma` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `estado` varchar(20) NOT NULL DEFAULT 'Sin Facturar',
  PRIMARY KEY (`idorden_servicio`),
  KEY `fk_ordspac_idx` (`fk_paciente`),
  KEY `fk_ordsodont_idx` (`fk_odontograma`),
  CONSTRAINT `fk_ordsodont` FOREIGN KEY (`fk_odontograma`) REFERENCES `odontograma` (`idodontograma`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ordspac` FOREIGN KEY (`fk_paciente`) REFERENCES `paciente` (`idPaciente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `paciente`
--

DROP TABLE IF EXISTS `paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paciente` (
  `idPaciente` int(11) NOT NULL AUTO_INCREMENT,
  `Nombres` varchar(255) NOT NULL,
  `Apellidos` varchar(255) NOT NULL,
  `Nro_CI` int(11) NOT NULL,
  `Fecha_Nac` date NOT NULL,
  `Sexo` varchar(1) NOT NULL,
  `Tel_LB` varchar(20) DEFAULT NULL,
  `Tel_Cel` varchar(10) DEFAULT NULL,
  `Direccion` varchar(500) NOT NULL,
  `Ciudad` varchar(100) NOT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Peso` int(11) NOT NULL,
  `Enfermedades` varchar(500) NOT NULL DEFAULT 'Ninguno',
  `Medicamentos` varchar(500) NOT NULL DEFAULT 'Ninguno',
  `Alergias` varchar(500) NOT NULL DEFAULT 'Ninguno',
  `Cirugias` varchar(500) NOT NULL DEFAULT 'Ninguno',
  `Observaciones` varchar(1000) NOT NULL DEFAULT 'Ninguno',
  `estado` varchar(8) NOT NULL DEFAULT 'Activo',
  PRIMARY KEY (`idPaciente`),
  UNIQUE KEY `idPaciente_UNIQUE` (`idPaciente`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `recibo`
--

DROP TABLE IF EXISTS `recibo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recibo` (
  `idrecibo` int(11) NOT NULL AUTO_INCREMENT,
  `fk_factura` int(11) NOT NULL,
  `fk_paciente` int(11) NOT NULL,
  `fk_usuario` int(11) NOT NULL,
  `monto` int(11) NOT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`idrecibo`),
  KEY `fk_recfactura_idx` (`fk_factura`),
  KEY `fk_recpaciente_idx` (`fk_paciente`),
  KEY `fk_recusuario_idx` (`fk_usuario`),
  CONSTRAINT `fk_recfactura` FOREIGN KEY (`fk_factura`) REFERENCES `factura` (`idfactura`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_recpaciente` FOREIGN KEY (`fk_paciente`) REFERENCES `paciente` (`idPaciente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_recusuario` FOREIGN KEY (`fk_usuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `recibo_empresa`
--

DROP TABLE IF EXISTS `recibo_empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recibo_empresa` (
  `idrecibo_empresa` int(11) NOT NULL AUTO_INCREMENT,
  `fk_facturaemp` int(11) NOT NULL,
  `fk_empresa` int(11) NOT NULL,
  `fk_usuario` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `monto` int(11) NOT NULL,
  PRIMARY KEY (`idrecibo_empresa`),
  KEY `fk_recempfactura_idx` (`fk_facturaemp`),
  KEY `fk_recempresa_idx` (`fk_empresa`),
  KEY `fk_recempusuario_idx` (`fk_usuario`),
  CONSTRAINT `fk_recempfactura` FOREIGN KEY (`fk_facturaemp`) REFERENCES `factura_empresa` (`idfactura_empresa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_recempresa` FOREIGN KEY (`fk_empresa`) REFERENCES `empresa` (`idempresa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_recempusuario` FOREIGN KEY (`fk_usuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `servicio`
--

DROP TABLE IF EXISTS `servicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servicio` (
  `idservicio` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) NOT NULL,
  `precio` int(11) NOT NULL,
  `estado` varchar(20) NOT NULL DEFAULT 'Activo',
  PRIMARY KEY (`idservicio`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tratamiento`
--

DROP TABLE IF EXISTS `tratamiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tratamiento` (
  `idtratamiento` int(11) NOT NULL AUTO_INCREMENT,
  `fk_odontograma` int(11) NOT NULL,
  `fk_servicio` int(11) NOT NULL,
  `fk_diente` int(11) NOT NULL,
  `estado` varchar(20) NOT NULL DEFAULT 'Pendiente',
  `especificacion` varchar(255) NOT NULL,
  PRIMARY KEY (`idtratamiento`),
  KEY `fk_tratodont_idx` (`fk_odontograma`),
  KEY `fk_tratservic_idx` (`fk_servicio`),
  KEY `fk_tratdiente_idx` (`fk_diente`),
  CONSTRAINT `fk_tratdiente` FOREIGN KEY (`fk_diente`) REFERENCES `diente` (`iddiente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tratodont` FOREIGN KEY (`fk_odontograma`) REFERENCES `odontograma` (`idodontograma`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tratservic` FOREIGN KEY (`fk_servicio`) REFERENCES `servicio` (`idservicio`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `passw` varchar(50) NOT NULL,
  `rol` varchar(45) NOT NULL,
  `id_asoc` int(11) DEFAULT NULL,
  `estado` varchar(45) NOT NULL DEFAULT 'Activo',
  `observacion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idusuario`),
  KEY `fk_usisasoc_idx` (`id_asoc`),
  CONSTRAINT `fk_usisasoc` FOREIGN KEY (`id_asoc`) REFERENCES `doctor` (`idDoctor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping events for database 'odontosys'
--

--
-- Dumping routines for database 'odontosys'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-18 12:54:52
