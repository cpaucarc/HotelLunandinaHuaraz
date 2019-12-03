-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: hotel_lunandina
-- ------------------------------------------------------
-- Server version	5.6.26-log

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
-- Table structure for table `boletas`
--

DROP TABLE IF EXISTS `boletas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `boletas` (
  `numBoleta` int(11) NOT NULL AUTO_INCREMENT,
  `idcomprobante` int(11) NOT NULL,
  `idclientePersona` int(11) NOT NULL,
  PRIMARY KEY (`numBoleta`),
  KEY `fk_boletas_detalleComprobante1_idx` (`idcomprobante`),
  KEY `fk_boletas_clientePersona1_idx` (`idclientePersona`),
  CONSTRAINT `fk_boletas_clientePersona1` FOREIGN KEY (`idclientePersona`) REFERENCES `clientepersona` (`idclientePersona`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_boletas_detalleComprobante1` FOREIGN KEY (`idcomprobante`) REFERENCES `detallecomprobante` (`idcomprobante`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boletas`
--

LOCK TABLES `boletas` WRITE;
/*!40000 ALTER TABLE `boletas` DISABLE KEYS */;
/*!40000 ALTER TABLE `boletas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cargos`
--

DROP TABLE IF EXISTS `cargos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cargos` (
  `idcargo` int(11) NOT NULL AUTO_INCREMENT,
  `cargo` varchar(45) NOT NULL,
  PRIMARY KEY (`idcargo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargos`
--

LOCK TABLES `cargos` WRITE;
/*!40000 ALTER TABLE `cargos` DISABLE KEYS */;
INSERT INTO `cargos` VALUES (1,'Administrador'),(2,'Recepcionista');
/*!40000 ALTER TABLE `cargos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clienteempresa`
--

DROP TABLE IF EXISTS `clienteempresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clienteempresa` (
  `RUC` varchar(45) NOT NULL,
  `nombreEmpresa` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `idprocedencia` int(11) NOT NULL,
  PRIMARY KEY (`RUC`),
  KEY `fk_clienteEmpresa_procedencias1_idx` (`idprocedencia`),
  CONSTRAINT `fk_clienteEmpresa_procedencias1` FOREIGN KEY (`idprocedencia`) REFERENCES `lugaresprocedencia` (`idprocedencia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clienteempresa`
--

LOCK TABLES `clienteempresa` WRITE;
/*!40000 ALTER TABLE `clienteempresa` DISABLE KEYS */;
INSERT INTO `clienteempresa` VALUES ('89415165154','DORITOS SAD','FBFNFNFN',4);
/*!40000 ALTER TABLE `clienteempresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientepersona`
--

DROP TABLE IF EXISTS `clientepersona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientepersona` (
  `idclientePersona` int(11) NOT NULL AUTO_INCREMENT,
  `DNI` varchar(8) NOT NULL,
  `idprocedencia` int(11) NOT NULL,
  PRIMARY KEY (`idclientePersona`),
  KEY `fk_clientePersona_personas1_idx` (`DNI`),
  KEY `fk_clientePersona_procedencias1_idx` (`idprocedencia`),
  CONSTRAINT `fk_clientePersona_personas1` FOREIGN KEY (`DNI`) REFERENCES `personas` (`DNI`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_clientePersona_procedencias1` FOREIGN KEY (`idprocedencia`) REFERENCES `lugaresprocedencia` (`idprocedencia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientepersona`
--

LOCK TABLES `clientepersona` WRITE;
/*!40000 ALTER TABLE `clientepersona` DISABLE KEYS */;
INSERT INTO `clientepersona` VALUES (1,'57676767',1),(2,'21322323',1),(3,'78565666',2),(4,'54565656',3),(5,'74125856',4),(6,'43666666',7),(7,'89748611',8),(8,'67686756',9);
/*!40000 ALTER TABLE `clientepersona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detallealojamiento`
--

DROP TABLE IF EXISTS `detallealojamiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detallealojamiento` (
  `idDetAloj` int(11) NOT NULL AUTO_INCREMENT,
  `fechaReserva` date DEFAULT NULL,
  `fechaEntrada` date NOT NULL,
  `fechaSalida` date NOT NULL,
  `idestadoAloj` int(11) NOT NULL,
  `idhabitacion` int(11) NOT NULL,
  `idusuario` int(11) NOT NULL,
  `idclientePersona` int(11) DEFAULT NULL,
  `RUC` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idDetAloj`),
  KEY `fk_detalleAlojamiento_habitaciones1_idx` (`idhabitacion`),
  KEY `fk_detalleAlojamiento_usuarios1_idx` (`idusuario`),
  KEY `fk_detalleAlojamiento_clientePersona1_idx` (`idclientePersona`),
  KEY `fk_detalleAlojamiento_clienteEmpresa1_idx` (`RUC`),
  KEY `fk_detalleAlojamiento_estadoAlojamiento1_idx` (`idestadoAloj`),
  CONSTRAINT `fk_detalleAlojamiento_clienteEmpresa1` FOREIGN KEY (`RUC`) REFERENCES `clienteempresa` (`RUC`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalleAlojamiento_clientePersona1` FOREIGN KEY (`idclientePersona`) REFERENCES `clientepersona` (`idclientePersona`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalleAlojamiento_estadoAlojamiento1` FOREIGN KEY (`idestadoAloj`) REFERENCES `estadoalojamiento` (`idestadoAloj`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalleAlojamiento_habitaciones1` FOREIGN KEY (`idhabitacion`) REFERENCES `habitaciones` (`idhabitacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalleAlojamiento_usuarios1` FOREIGN KEY (`idusuario`) REFERENCES `usuarios` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detallealojamiento`
--

LOCK TABLES `detallealojamiento` WRITE;
/*!40000 ALTER TABLE `detallealojamiento` DISABLE KEYS */;
INSERT INTO `detallealojamiento` VALUES (1,'2019-12-02','2019-12-02','2019-12-03',2,8,1,2,NULL),(2,'2019-12-02','2019-12-02','2019-12-03',2,12,1,3,NULL),(3,'2019-12-02','2019-12-02','2019-12-06',2,3,1,4,NULL),(4,'2019-12-03','2019-12-03','2019-12-10',2,4,1,1,NULL),(5,'2019-12-03','2019-12-04','2019-12-05',2,2,1,1,NULL),(6,'2019-12-03','2019-12-04','2019-12-11',2,15,1,1,NULL),(7,'2019-12-03','2019-12-04','2019-12-05',1,13,1,5,NULL),(8,'2019-12-03','2019-12-10','2019-12-12',1,13,1,NULL,'89415165154'),(9,'2019-12-03','2019-12-11','2019-12-13',2,10,1,NULL,'89415165154'),(10,'2019-12-03','2019-12-11','2019-12-12',1,6,1,6,NULL),(11,'2019-12-03','2019-12-18','2019-12-21',1,1,2,7,NULL),(12,'2019-12-03','2019-12-18','2019-12-25',2,9,1,6,NULL),(13,'2019-12-03','2019-12-05','2019-12-19',2,7,1,6,NULL),(14,'2019-12-03','2019-12-04','2019-12-08',1,14,2,6,NULL),(15,'2019-12-03','2019-12-03','2019-12-04',1,5,1,8,NULL);
/*!40000 ALTER TABLE `detallealojamiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detallecomprobante`
--

DROP TABLE IF EXISTS `detallecomprobante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detallecomprobante` (
  `idcomprobante` int(11) NOT NULL AUTO_INCREMENT,
  `fechaEmision` date NOT NULL,
  `subtotal` decimal(9,2) DEFAULT NULL,
  `IGV` decimal(9,2) DEFAULT NULL,
  `total` decimal(9,2) NOT NULL,
  `idDetServ` int(11) DEFAULT NULL,
  `idDetAloj` int(11) DEFAULT NULL,
  PRIMARY KEY (`idcomprobante`),
  KEY `fk_detalleComprobante_detalleServicio1_idx` (`idDetServ`),
  KEY `fk_detalleComprobante_detalleAlojamiento1_idx` (`idDetAloj`),
  CONSTRAINT `fk_detalleComprobante_detalleAlojamiento1` FOREIGN KEY (`idDetAloj`) REFERENCES `detallealojamiento` (`idDetAloj`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalleComprobante_detalleServicio1` FOREIGN KEY (`idDetServ`) REFERENCES `detalleservicio` (`idDetServ`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detallecomprobante`
--

LOCK TABLES `detallecomprobante` WRITE;
/*!40000 ALTER TABLE `detallecomprobante` DISABLE KEYS */;
/*!40000 ALTER TABLE `detallecomprobante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalleservicio`
--

DROP TABLE IF EXISTS `detalleservicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalleservicio` (
  `idDetServ` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad` int(11) NOT NULL,
  `idtipoServ` int(11) NOT NULL,
  `idDetAloj` int(11) NOT NULL,
  `fechaServicio` date NOT NULL,
  PRIMARY KEY (`idDetServ`),
  KEY `fk_servicios_tipoServicio1_idx` (`idtipoServ`),
  KEY `fk_detalleServicio_detalleAlojamiento1_idx` (`idDetAloj`),
  CONSTRAINT `fk_detalleServicio_detalleAlojamiento1` FOREIGN KEY (`idDetAloj`) REFERENCES `detallealojamiento` (`idDetAloj`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_servicios_tipoServicio1` FOREIGN KEY (`idtipoServ`) REFERENCES `tiposervicio` (`idtipoServ`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalleservicio`
--

LOCK TABLES `detalleservicio` WRITE;
/*!40000 ALTER TABLE `detalleservicio` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalleservicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleados` (
  `idempleado` int(11) NOT NULL AUTO_INCREMENT,
  `idcargo` int(11) NOT NULL,
  `idEstEmp` int(11) NOT NULL,
  `DNI` varchar(8) NOT NULL,
  PRIMARY KEY (`idempleado`),
  KEY `fk_empleados_cargos1_idx` (`idcargo`),
  KEY `fk_empleados_estadoEmpleado1_idx` (`idEstEmp`),
  KEY `fk_empleados_personas1_idx` (`DNI`),
  CONSTRAINT `fk_empleados_cargos1` FOREIGN KEY (`idcargo`) REFERENCES `cargos` (`idcargo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_empleados_estadoEmpleado1` FOREIGN KEY (`idEstEmp`) REFERENCES `estadoempleado` (`idEstEmp`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_empleados_personas1` FOREIGN KEY (`DNI`) REFERENCES `personas` (`DNI`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (1,1,1,'12345678'),(2,2,2,'14725836');
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadoalojamiento`
--

DROP TABLE IF EXISTS `estadoalojamiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estadoalojamiento` (
  `idestadoAloj` int(11) NOT NULL AUTO_INCREMENT,
  `estadoAloj` varchar(45) NOT NULL,
  PRIMARY KEY (`idestadoAloj`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadoalojamiento`
--

LOCK TABLES `estadoalojamiento` WRITE;
/*!40000 ALTER TABLE `estadoalojamiento` DISABLE KEYS */;
INSERT INTO `estadoalojamiento` VALUES (1,'Pendiente'),(2,'Alojado'),(3,'Pendiente'),(4,'Alojado');
/*!40000 ALTER TABLE `estadoalojamiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadoempleado`
--

DROP TABLE IF EXISTS `estadoempleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estadoempleado` (
  `idEstEmp` int(11) NOT NULL AUTO_INCREMENT,
  `estado` varchar(45) NOT NULL,
  PRIMARY KEY (`idEstEmp`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadoempleado`
--

LOCK TABLES `estadoempleado` WRITE;
/*!40000 ALTER TABLE `estadoempleado` DISABLE KEYS */;
INSERT INTO `estadoempleado` VALUES (1,'Activo'),(2,'Despedido');
/*!40000 ALTER TABLE `estadoempleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadohabitacion`
--

DROP TABLE IF EXISTS `estadohabitacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estadohabitacion` (
  `idestadoHab` int(11) NOT NULL AUTO_INCREMENT,
  `estadoHab` varchar(45) NOT NULL,
  PRIMARY KEY (`idestadoHab`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadohabitacion`
--

LOCK TABLES `estadohabitacion` WRITE;
/*!40000 ALTER TABLE `estadohabitacion` DISABLE KEYS */;
INSERT INTO `estadohabitacion` VALUES (1,'Disponible'),(2,'Reservado'),(3,'Ocupado'),(4,'Mantenimiento');
/*!40000 ALTER TABLE `estadohabitacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facturas`
--

DROP TABLE IF EXISTS `facturas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `facturas` (
  `numFactura` int(11) NOT NULL AUTO_INCREMENT,
  `idcomprobante` int(11) NOT NULL,
  `RUC` varchar(45) NOT NULL,
  PRIMARY KEY (`numFactura`),
  KEY `fk_facturas_detalleComprobante1_idx` (`idcomprobante`),
  KEY `fk_facturas_clienteEmpresa1_idx` (`RUC`),
  CONSTRAINT `fk_facturas_clienteEmpresa1` FOREIGN KEY (`RUC`) REFERENCES `clienteempresa` (`RUC`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_facturas_detalleComprobante1` FOREIGN KEY (`idcomprobante`) REFERENCES `detallecomprobante` (`idcomprobante`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facturas`
--

LOCK TABLES `facturas` WRITE;
/*!40000 ALTER TABLE `facturas` DISABLE KEYS */;
/*!40000 ALTER TABLE `facturas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `habitaciones`
--

DROP TABLE IF EXISTS `habitaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `habitaciones` (
  `idhabitacion` int(11) NOT NULL AUTO_INCREMENT,
  `numHab` varchar(45) NOT NULL,
  `idtipoHab` int(11) NOT NULL,
  `idestadoHab` int(11) NOT NULL,
  PRIMARY KEY (`idhabitacion`),
  KEY `fk_habitaciones_tipoHabitacion1_idx` (`idtipoHab`),
  KEY `fk_habitaciones_estadoHabitacion1_idx` (`idestadoHab`),
  CONSTRAINT `fk_habitaciones_estadoHabitacion1` FOREIGN KEY (`idestadoHab`) REFERENCES `estadohabitacion` (`idestadoHab`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_habitaciones_tipoHabitacion1` FOREIGN KEY (`idtipoHab`) REFERENCES `tipohabitacion` (`idtipoHab`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `habitaciones`
--

LOCK TABLES `habitaciones` WRITE;
/*!40000 ALTER TABLE `habitaciones` DISABLE KEYS */;
INSERT INTO `habitaciones` VALUES (1,'201',1,2),(2,'202',2,2),(3,'203',3,3),(4,'204',4,2),(5,'205',5,2),(6,'206',6,2),(7,'207',1,2),(8,'208',4,2),(9,'301',6,2),(10,'302',5,2),(11,'303',4,2),(12,'304',3,3),(13,'305',2,2),(14,'306',3,2),(15,'307',2,2),(16,'308',5,1);
/*!40000 ALTER TABLE `habitaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lugaresprocedencia`
--

DROP TABLE IF EXISTS `lugaresprocedencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lugaresprocedencia` (
  `idprocedencia` int(11) NOT NULL AUTO_INCREMENT,
  `lugar` varchar(45) NOT NULL,
  PRIMARY KEY (`idprocedencia`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lugaresprocedencia`
--

LOCK TABLES `lugaresprocedencia` WRITE;
/*!40000 ALTER TABLE `lugaresprocedencia` DISABLE KEYS */;
INSERT INTO `lugaresprocedencia` VALUES (1,'Rosario - Argentina'),(2,'bgbgbgbg'),(3,'Madeira - Portugal'),(4,'PIURA'),(5,'CARAZ'),(6,'HUARMEY'),(7,'NAZARET'),(8,'LNDFBJB'),(9,'TRUJILLO');
/*!40000 ALTER TABLE `lugaresprocedencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personas`
--

DROP TABLE IF EXISTS `personas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personas` (
  `DNI` varchar(8) NOT NULL,
  `apPat` varchar(45) NOT NULL,
  `apMat` varchar(45) NOT NULL,
  `nomb` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personas`
--

LOCK TABLES `personas` WRITE;
/*!40000 ALTER TABLE `personas` DISABLE KEYS */;
INSERT INTO `personas` VALUES ('12345678','Silio','Dextre','Consuelo','consuelo@hotmail.com'),('14725836','Brito','Delgado','Alan','alan@brito.com'),('21322323','Messi','Cuccittini','Lionel Andres','cristianoacmp1pt@mskbvf.com'),('43666666','OCAÑA','VELASQUEZ','JESUCRISTO','qwwwwwwwwwww'),('54565656','Crsiete','Bicho','Crsitiano Ronaldo','siuuuuu@gmail.com'),('57676767','Messi','Cuccittini','Lionel Andres','cristianoacmp1pt@gmail.com'),('67686756','ACUÑA','ACUÑA','CESAR','platacomocancha@gmail.com'),('74125856','SILVA','ZAPATA','MIGUEL ANGEL','silvatumadre@gmail.com'),('78565666','Bgb','Gbbgb','Bgbgbgb','bgbgbbgb'),('89748611','MDFNJKFF','KNFBJFBNF','QNFBFJBNFNB','fknbjnfbfdkjbnjkfnbjk');
/*!40000 ALTER TABLE `personas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipohabitacion`
--

DROP TABLE IF EXISTS `tipohabitacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipohabitacion` (
  `idtipoHab` int(11) NOT NULL AUTO_INCREMENT,
  `nombreTH` varchar(45) NOT NULL,
  `precioTH` decimal(9,2) NOT NULL,
  PRIMARY KEY (`idtipoHab`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipohabitacion`
--

LOCK TABLES `tipohabitacion` WRITE;
/*!40000 ALTER TABLE `tipohabitacion` DISABLE KEYS */;
INSERT INTO `tipohabitacion` VALUES (1,'Individual',95.00),(2,'Doble',155.00),(3,'Triple',265.00),(4,'Matrimonial',145.00),(5,'Matrimonial Lunandina',155.00),(6,'Familiar',265.00);
/*!40000 ALTER TABLE `tipohabitacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tiposervicio`
--

DROP TABLE IF EXISTS `tiposervicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tiposervicio` (
  `idtipoServ` int(11) NOT NULL AUTO_INCREMENT,
  `nombreServ` varchar(45) NOT NULL,
  `precioServ` decimal(9,2) NOT NULL,
  PRIMARY KEY (`idtipoServ`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tiposervicio`
--

LOCK TABLES `tiposervicio` WRITE;
/*!40000 ALTER TABLE `tiposervicio` DISABLE KEYS */;
/*!40000 ALTER TABLE `tiposervicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) NOT NULL,
  `psw` varchar(40) NOT NULL,
  `idempleado` int(11) NOT NULL,
  PRIMARY KEY (`idusuario`),
  KEY `fk_usuarios_empleados1_idx` (`idempleado`),
  CONSTRAINT `fk_usuarios_empleados1` FOREIGN KEY (`idempleado`) REFERENCES `empleados` (`idempleado`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'consuelo','63a9f0ea7bb98050796b649e85481845',1),(2,'antauro','202cb962ac59075b964b07152d234b70',2);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `v_principal`
--

DROP TABLE IF EXISTS `v_principal`;
/*!50001 DROP VIEW IF EXISTS `v_principal`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `v_principal` AS SELECT 
 1 AS `ID`,
 1 AS `Fecha`,
 1 AS `Empresa_Cliente`,
 1 AS `N°_Hab`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_reservaclient`
--

DROP TABLE IF EXISTS `v_reservaclient`;
/*!50001 DROP VIEW IF EXISTS `v_reservaclient`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `v_reservaclient` AS SELECT 
 1 AS `ID`,
 1 AS `Fecha_Resv`,
 1 AS `Fecha_Ent`,
 1 AS `Fecha_Sal`,
 1 AS `N°Hab`,
 1 AS `Tipo`,
 1 AS `DNI`,
 1 AS `Cliente`,
 1 AS `Procedencia`,
 1 AS `usuario`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_reservaemp`
--

DROP TABLE IF EXISTS `v_reservaemp`;
/*!50001 DROP VIEW IF EXISTS `v_reservaemp`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `v_reservaemp` AS SELECT 
 1 AS `ID`,
 1 AS `Fecha_Resv`,
 1 AS `Fecha_Ent`,
 1 AS `Fecha_Sal`,
 1 AS `N°Hab`,
 1 AS `Tipo`,
 1 AS `RUC`,
 1 AS `Empresa`,
 1 AS `Procedencia`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vis_alojamiento_empresa`
--

DROP TABLE IF EXISTS `vis_alojamiento_empresa`;
/*!50001 DROP VIEW IF EXISTS `vis_alojamiento_empresa`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `vis_alojamiento_empresa` AS SELECT 
 1 AS `idDetAloj`,
 1 AS `fechaEntrada`,
 1 AS `fechaSalida`,
 1 AS `numHab`,
 1 AS `nombreTH`,
 1 AS `RUC`,
 1 AS `nombreEmpresa`,
 1 AS `lugar`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vis_alojamiento_persona`
--

DROP TABLE IF EXISTS `vis_alojamiento_persona`;
/*!50001 DROP VIEW IF EXISTS `vis_alojamiento_persona`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `vis_alojamiento_persona` AS SELECT 
 1 AS `idDetAloj`,
 1 AS `fechaEntrada`,
 1 AS `fechaSalida`,
 1 AS `numHab`,
 1 AS `nombreTH`,
 1 AS `DNI`,
 1 AS `Cliente`,
 1 AS `lugar`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_clienteempresa`
--

DROP TABLE IF EXISTS `vw_clienteempresa`;
/*!50001 DROP VIEW IF EXISTS `vw_clienteempresa`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `vw_clienteempresa` AS SELECT 
 1 AS `ruc`,
 1 AS `nombre`,
 1 AS `email`,
 1 AS `lugar`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_clientepersona`
--

DROP TABLE IF EXISTS `vw_clientepersona`;
/*!50001 DROP VIEW IF EXISTS `vw_clientepersona`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `vw_clientepersona` AS SELECT 
 1 AS `dni`,
 1 AS `apPat`,
 1 AS `apMat`,
 1 AS `nombre`,
 1 AS `email`,
 1 AS `lugar`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_empleados`
--

DROP TABLE IF EXISTS `vw_empleados`;
/*!50001 DROP VIEW IF EXISTS `vw_empleados`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `vw_empleados` AS SELECT 
 1 AS `dni`,
 1 AS `apellidos`,
 1 AS `nombres`,
 1 AS `mail`,
 1 AS `cargo`,
 1 AS `estado`,
 1 AS `username`,
 1 AS `psw`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_habitacion`
--

DROP TABLE IF EXISTS `vw_habitacion`;
/*!50001 DROP VIEW IF EXISTS `vw_habitacion`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `vw_habitacion` AS SELECT 
 1 AS `id`,
 1 AS `numero`,
 1 AS `tipo`,
 1 AS `precio`,
 1 AS `estado`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping routines for database 'hotel_lunandina'
--
/*!50003 DROP FUNCTION IF EXISTS `f_validarespnom` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `f_validarespnom`(nom varchar(45),n int) RETURNS tinyint(1)
BEGIN
    declare l int ;
    declare i int default 1;
    declare c varchar(1);
    declare cont int default 0;
    set l=length(nom);
    while i<=l do
       set c=substring(nom,i,1);
         if(strcmp(c,' ')=0) then
          set cont=cont+1;
         end if;
      set i=i+1;
    end while;
    if(cont<=n) then
      return true;
    else
      return false;
    end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `f_validarLetra` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `f_validarLetra`(p varchar(2)) RETURNS tinyint(1)
BEGIN
    if(strcmp(p,' ')=0 or strcmp(p,'a')=0 or strcmp(p,'b')=0 or strcmp(p,'c')=0 or strcmp(p,'d')=0 or strcmp(p,'e')=0 or strcmp(p,'f')=0 or
       strcmp(p,'g')=0 or strcmp(p,'h')=0 or strcmp(p,'i')=0 or strcmp(p,'j')=0 or strcmp(p,'k')=0 or strcmp(p,'l')=0 or
       strcmp(p,'m')=0 or strcmp(p,'n')=0 or strcmp(p,'ñ')=0 or strcmp(p,'o')=0 or strcmp(p,'p')=0 or strcmp(p,'q')=0 or
       strcmp(p,'r')=0 or strcmp(p,'s')=0 or strcmp(p,'t')=0 or strcmp(p,'u')=0 or strcmp(p,'v')=0 or strcmp(p,'w')=0 or
       strcmp(p,'x')=0 or strcmp(p,'y')=0 or strcmp(p,'z')=0 ) then
        return true;
      else
        return false;
      end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `f_validarnumero` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `f_validarnumero`(c varchar(2)) RETURNS tinyint(1)
BEGIN
      if(c='1' or c='2'  or c='3' or c='4' or c='5' or c='6' or c='7' or c='8' or c='9' or c='0' ) then
        return true;
      else
        return false;
      end if;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `f_validarpalabra` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `f_validarpalabra`(apel varchar(45)) RETURNS tinyint(1)
BEGIN
    declare l int ;
    declare i int default 1;
    declare c varchar(1);
    declare cont int default 0;
    set l=length(apel);
     while i<=l do
      set c=substring(apel,i,1);
      if(f_validarletra(c)) then
        set cont=cont+1;
      end if;
      set i=i+1;
    end while;

    if(cont=l) then
     return true;
    else
      return false;
    end if;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `f_validarPuroNum` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `f_validarPuroNum`(dni varchar(20)) RETURNS tinyint(1)
BEGIN
    declare l int ;
    declare i int default 1;
    declare c varchar(1);
    declare cont int default 0;
    set l=length(dni);

    while i<=l do
      set c=substring(dni,i,1);
      if(f_validarnumero(c)) then
        set cont=cont+1;
      end if;
      set i=i+1;
    end while;

    if(cont=l) then
     return true;
    else
      return false;
    end if;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `f_validartamanio` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `f_validartamanio`(var varchar(100),n int) RETURNS tinyint(1)
BEGIN
   declare l int ;
   set l=length(var);
   if(l=n) then
    return true;
   else
    return false;
   end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `proc_alojamiento_empresa` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_alojamiento_empresa`(rucemp varchar(40),
nom varchar(45),proc varchar(100),correo varchar(60),fecentrada date,fecsalida date,tiphabi varchar(30),numhabi int,
usuario varchar(55))
BEGIN

if(datediff(fecentrada,curdate())=0)then
  if(datediff(fecsalida,curdate())>=0)then
    if(datediff(fecsalida,fecentrada)>0)then
      if(f_validarPuroNum(rucemp)) then
        if(f_validartamanio(rucemp,11)) then
          if(select count(*) from clienteempresa where RUC=rucemp)=0 then
            if(select count(*)from lugaresprocedencia where lugar=proc)=0 then
              insert into lugaresprocedencia(lugar) values (proc);
              set @procemp=(select idprocedencia from lugaresprocedencia where lugar=proc order by idprocedencia desc limit 1);
            else
              set @procemp=(select idprocedencia from lugaresprocedencia where lugar=proc order by idprocedencia desc limit 1);
            end if;
            insert into clienteempresa(RUC,nombreEmpresa,idprocedencia,email) values (rucemp,nom,@procemp,correo);
            set @rucemp=(select RUC from clienteempresa where RUC=rucemp order by RUC desc limit 1);
            set @idtiphab=(select idtipoHab from tipohabitacion where nombreTH=tiphabi order by idtipoHab desc limit 1);
            update habitaciones set idestadoHab=2 where numHab=numhabi and idtipoHab=@idtiphab;
            set @habit=(select idhabitacion from habitaciones where numHab=numhabi and idtipoHab=@idtiphab);
            set @idusu=(select idusuario from usuarios where login=usuario order by idusuario desc limit 1);
            insert into detallealojamiento(fechaReserva,fechaEntrada,fechaSalida,idestadoAloj,idhabitacion,idusuario,RUC)
            values (curdate(),fecentrada,fecsalida,2,@habit,@idusu,@rucemp);

            select concat('Se registró correctamente la empresa ',nom,' con RUC: ',rucemp);
          else
            if(select count(*)from lugaresprocedencia where lugar=proc)=0 then
              insert into lugaresprocedencia(lugar) values (proc);
              set @procemp=(select idprocedencia from lugaresprocedencia where lugar=proc order by idprocedencia desc limit 1);
            else
              set @procemp=(select idprocedencia from lugaresprocedencia where lugar=proc order by idprocedencia desc limit 1);
            end if;
            set @rucemp=(select RUC from clienteempresa where RUC=rucemp order by RUC desc limit 1);
            set @idtiphab=(select idtipoHab from tipohabitacion where nombreTH=tiphabi order by idtipoHab desc limit 1);
            update habitaciones set idestadoHab=2 where numHab=numhabi and idtipoHab=@idtiphab;
            set @habit=(select idhabitacion from habitaciones where numHab=numhabi and idtipoHab=@idtiphab);
            set @idusu=(select idusuario from usuarios where login=usuario order by idusuario desc limit 1);
            insert into detallealojamiento(fechaReserva,fechaEntrada,fechaSalida,idestadoAloj,idhabitacion,idusuario,RUC)
            values (curdate(),fecentrada,fecsalida,2,@habit,@idusu,@rucemp);
            select concat('Se registró correctamente la empresa ',nom,' con RUC: ',rucemp);
          end if;
        else
          select concat('El RUC debe contar con solo 11 digitos');
        end if;
      else
        select concat('El RUC no puede tener carcateres');
      end if;
    else
      select concat('La fecha de salida debe ser mayor a la fecha de entrada');
    end if;
  else
    select concat('La fecha de salida debe ser mayor a la fecha actual');
  end if;
else
  select concat('La fecha de ingreso debe ser la fecha actual\n¡Puede hacer reservas!');
end if;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `proc_alojamiento_empresa_editar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_alojamiento_empresa_editar`(id int,rucemp varchar(45),proc varchar(100),nom varchar(70),
correo varchar(50),fecsalida date)
BEGIN
set @fecentrada=(select fechaEntrada from detallealojamiento where idDetAloj=id order by idDetAloj desc limit 1);

      if(datediff(fecsalida,curdate())>=0)then
        if(datediff(fecsalida,@fecentrada)>0)then

 if(select count(*) from clienteempresa where RUC=rucemp)!=0 then
       update lugaresprocedencia set lugar=proc where idprocedencia=(select idprocedencia from clienteempresa where RUC=rucemp);
       set @procemp=(select idprocedencia from lugaresprocedencia where lugar=proc order by idprocedencia desc limit 1);
       update clienteempresa set nombreEmpresa=nom,idprocedencia=@procemp,email=correo where RUC=rucemp;
       update detallealojamiento set fechaSalida=fecsalida where idDetAloj=id;
       select concat('Se editó correctamente la empresa ',nom,' con RUC: ',rucemp);
      end if;

      else
          select concat('La fecha de salida debe ser mayor a la fecha de entrada');
        end if;
      else
        select concat('La fecha de salida debe ser mayor a la fecha actual');
      end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `proc_alojamiento_persona` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_alojamiento_persona`(doc varchar(20),apater varchar(45),amater varchar(45),
nom varchar(45),proc varchar(100),correo varchar(60),fecentrada date,fecsalida date,tiphabi varchar(30),numhabi int,
usuario varchar(55))
BEGIN

if(datediff(fecentrada,curdate())=0)then
  if(datediff(fecsalida,curdate())>=0)then
    if(datediff(fecsalida,fecentrada)>0)then
      if(f_validarPuroNum(doc)) then
        if(f_validartamanio(doc,8)) then
          if(f_validarpalabra(apater)) then
            if(f_validarpalabra(amater)) then
              if(f_validarpalabra(nom)) then
                if(f_validarespnom(nom,1)) then
                  if(select count(*) from personas where dni=doc)=0 then
                    insert into personas(DNI,apPat,apMat,nomb,email) values (doc,apater,amater,nom,correo);
                    set @dniper=(select DNI from personas where DNI=doc order by DNI desc limit 1);
                    if(select count(*)from lugaresprocedencia where lugar=proc)=0 then
                      insert into lugaresprocedencia(lugar) values (proc);
                      set @procper=(select idprocedencia from lugaresprocedencia where lugar=proc order by idprocedencia desc limit 1);
                    else
                      set @procper=(select idprocedencia from lugaresprocedencia where lugar=proc order by idprocedencia desc limit 1);
                    end if;
                    if(select count(*) from clientepersona where DNI=doc and idprocedencia=@procper)=0 then
                      insert into clientepersona(DNI,idprocedencia) values(@dniper,@procper);
                      set @idcliper=(select idclientePersona from clientepersona where DNI=@dniper and idprocedencia=@procper
                      order by idclientepersona desc limit 1);
                    else
                      set @idcliper=(select idclientePersona from clientepersona where DNI=@dniper and idprocedencia=@procper
                      order by idclientepersona desc limit 1);
                    end if;
                    set @idtiphab=(select idtipoHab from tipohabitacion where nombreTH=tiphabi order by idtipoHab desc limit 1);
                    update habitaciones set idestadoHab=3 where numHab=numhabi and idtipoHab=@idtiphab;
                    set @habit=(select idhabitacion from habitaciones where numHab=numhabi and idtipoHab=@idtiphab);
                    set @idusu=(select idusuario from usuarios where login=usuario order by idusuario desc limit 1);
                    insert into detallealojamiento(fechaReserva,fechaEntrada,fechaSalida,idestadoAloj,idhabitacion,idusuario,idclientePersona)
                    values (curdate(),fecentrada,fecsalida,2,@habit,@idusu,@idcliper);

                    select concat('Se registró correctamente al cliente ',nom,' con DNI: ',doc);
                 else
                   set @dniper=(select DNI from personas where DNI=doc order by DNI desc limit 1);
                   if(select count(*)from lugaresprocedencia where lugar=proc)=0 then
                     insert into lugaresprocedencia(lugar) values (proc);
                     set @procper=(select idprocedencia from lugaresprocedencia where lugar=proc order by idprocedencia desc limit 1);
                   else
                     set @procper=(select idprocedencia from lugaresprocedencia where lugar=proc order by idprocedencia desc limit 1);
                   end if;
                   if(select count(*) from clientepersona where DNI=doc and idprocedencia=@procper)=0 then
                     insert into clientepersona(DNI,idprocedencia) values(@dniper,@procper);
                     set @idcliper=(select idclientePersona from clientepersona where DNI=@dniper and idprocedencia=@procper
                     order by idclientepersona desc limit 1);
                   else
                     set @idcliper=(select idclientePersona from clientepersona where DNI=@dniper and idprocedencia=@procper
                     order by idclientepersona desc limit 1);
                   end if;
                   set @idtiphab=(select idtipoHab from tipohabitacion where nombreTH=tiphabi order by idtipoHab desc limit 1);
                   update habitaciones set idestadoHab=3 where numHab=numhabi and idtipoHab=@idtiphab;
                   set @habit=(select idhabitacion from habitaciones where numHab=numhabi and idtipoHab=@idtiphab);
                   set @idusu=(select idusuario from usuarios where login=usuario order by idusuario desc limit 1);
                   insert into detallealojamiento(fechaReserva,fechaEntrada,fechaSalida,idestadoAloj,idhabitacion,idusuario,idclientePersona)
                   values (curdate(),fecentrada,fecsalida,2,@habit,@idusu,@idcliper);

                   select concat('Se registró correctamente al cliente ',nom,' con DNI: ',doc);
                 end if;
               else
                 select concat('Los espacios en el nombre no es correcto');
               end if;
             else
               select concat('El nombre solo debe tener caracteres');
             end if;
           else
             select concat('El apellido materno solo debe tener caracteres');
           end if;
         else
           select concat('El apellido paterno solo debe tener caracteres');
         end if;
       else
         select concat('El DNI debe contar con solo 8 digitos');
       end if;
     else
       select concat('El DNI no puede tener carcateres');
     end if;
   else
     select concat('La fecha de salida debe ser mayor a la fecha de entrada');
   end if;
 else
   select concat('La fecha de salida debe ser mayor a la fecha actual');
 end if;
else
 select concat('La fecha de ingreso debe ser la fecha actual\n¡Puede hacer reservas!');
end if;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `proc_alojamiento_persona_editar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_alojamiento_persona_editar`(id int,doc varchar(20),apater varchar(45),amater varchar(45),
nom varchar(45),proc varchar(100),correo varchar(60),fecsalida date)
BEGIN
set @fecentrada=(select fechaEntrada from detallealojamiento where idDetAloj=id order by idDetAloj desc limit 1);

      if(datediff(fecsalida,curdate())>=0)then
        if(datediff(fecsalida,@fecentrada)>0)then

 if(select count(*) from personas where dni=doc)!=0 then
        update personas set apPat=apater,apMat=amater,nomb=nom,email=correo where DNI=doc;
        set @dniper=(select DNI from personas where DNI=doc order by DNI desc limit 1);

        update lugaresprocedencia set lugar=proc where idprocedencia=(select idprocedencia from clientepersona where DNI=doc);
        set @procper=(select idprocedencia from lugaresprocedencia where lugar=proc order by idprocedencia desc limit 1);

        update clientepersona set DNI=@dniper,idprocedencia=@procper where DNI=doc;

        update detallealojamiento set fechaSalida=fecsalida where idDetAloj=id;
       select concat('Se editó correctamente al cliente ',nom,' con DNI: ',doc);
 end if;

       else
          select concat('La fecha de salida debe ser mayor a la fecha de entrada');
        end if;
      else
        select concat('La fecha de salida debe ser mayor a la fecha actual');
      end if;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `proc_empleado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_empleado`(in evt int, dn varchar(8), appat varchar(50), apmat varchar(50), nombres varchar(50), 
						mail varchar(50), carg varchar(50), estad varchar(50))
BEGIN
	declare contador int;
    set contador = (select count(*) from personas where DNI = dn);
	case evt
    when 1 then 
		if (contador = 0) then
			insert into personas(DNI, apPat, apMat, nomb, email) values (dn, appat, apmat, nombres, mail);
			insert into empleados(idcargo, idEstEmp, DNI) values ((select idcargo from cargos where cargo = carg),
				(select idEstEmp from estadoempleado where estado = estad),dn);
			if STRCMP(carg, 'Administrador') = 0 then 
				insert into usuarios(login, psw, idempleado) values (dn, md5(dn), (select idempleado from empleados where DNI = dn));
			elseif STRCMP(carg, 'Recepcionista') = 0 then
				insert into usuarios(login, psw, idempleado) values (dn, md5(dn), (select idempleado from empleados where DNI = dn));
			end if;
            select concat('El empleado con numero de DNI ', dn, ' se registró satisfactoriamente');
		else
			select concat('El empleado con numero de DNI ', dn, '  ya está registrado');
		end if;
	when 2 then 
		update personas set apPat = appat, apMat = apmat, nomb = nombres, email = mail where DNI = dn;
        update empleados set idcargo = (select idcargo from cargos where cargo = carg), 
			idEstEmp = (select idEstEmp from estadoempleado where estado = estad) where DNI = dn;
		select concat('se modifico satisfactoriamente al empleado con numero de DNI ', dn);
	end case;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `proc_habitacion_libre` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_habitacion_libre`(IN hab VARCHAR(45), ent DATE, sal DATE)
BEGIN
	SELECT concat('hola', hab, ' con fecha de entrda ', ent, ' y fecha de salida ', sal);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Proc_ReservaClient` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Proc_ReservaClient`(evt int,ID int,lug varchar(45),dn varchar(8),apellP varchar(45),
     apellM varchar(45),nom varchar(45),corrcli varchar(45),fechent date,fechsal date,idhab int,valhab int,idus int)
begin
case evt
when 1 then
IF(DATEDIFF(fechsal,fechent))>0 and (DATEDIFF(fechent,curdate()-1))>0 THEN
 if (select count(DNI) from clientepersona where DNI = dn ) > 0 then
    insert into   detallealojamiento(fechaReserva,fechaEntrada,fechaSalida,idestadoAloj,idhabitacion,idusuario,idclientePersona,RUC)
    values (curdate(),fechent,fechsal,1,idhab,idus,(select idclientePersona from clientepersona where DNI = dn),null);
   Update habitaciones set idestadoHab=2 where idhabitacion=idhab;
    select concat('La reserva de "',dn,'" se registro satisfactoriamente');

 else
  if (select count(lugar) from lugaresprocedencia where lugar = lug ) = 0 then
   insert into lugaresprocedencia(lugar) values (lug);
  end if;
  insert into personas(DNI,apPat,apMat,nomb,email) values (dn,apellP,apellM,nom,corrcli);
  insert into clientepersona(DNI,idprocedencia) values (dn,(select idprocedencia from lugaresprocedencia where lugar = lug));
  insert into detallealojamiento(fechaReserva,fechaEntrada,fechaSalida,idestadoAloj,idhabitacion,idusuario,idclientePersona,RUC)
  values (curdate(),fechent,fechsal,1,idhab,idus,(select idclientePersona from clientepersona where DNI = dn),null);
 Update habitaciones set idestadoHab=2 where idhabitacion=idhab;
  select concat('La reserva de "',dn,'" se registro satisfactoriamente');
 end if;

ELSE
 select ('Ingrese una fecha valida');
END IF;
when 2 then
IF(DATEDIFF(fechsal,fechent))>0 and (DATEDIFF(fechent,curdate()-1))>0 THEN
		update personas set apPat = apellP, apMat = apellM, nomb = nom, email = corrcli where DNI = dn;

    if (select count(lugar) from lugaresprocedencia where lugar = lug ) = 0 then
      insert into lugaresprocedencia(lugar) values (lug);
    end if;
    update clientepersona set idprocedencia=(select idprocedencia from lugaresprocedencia where lugar = lug) where DNI = dn;
    update detallealojamiento set fechaEntrada=fechent,fechaSalida=fechsal,idhabitacion=idhab where idDetAloj=ID;

    if(select numHab from habitaciones where idhabitacion=idhab)=valhab then
      Update habitaciones set idestadoHab=2 where idhabitacion=idhab;
    else
      Update habitaciones set idestadoHab=1 where numHab=valhab;
      Update habitaciones set idestadoHab=2 where idhabitacion=idhab;
    end if;
    select concat('La reserva de "',dn,'" se edito satisfactoriamente');
ELSE
 select ('Ingrese una fecha valida');
END IF;
	end case;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Proc_ReservaEmp` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Proc_ReservaEmp`(evt int,ID int,lug varchar(45),RC varchar(45),nomemp varchar(45),coremp varchar(45),fechent date,fechsal date,idhab int,valhab int,idus int)
begin
 case evt
 when 1 then
IF(DATEDIFF(fechsal,fechent))>0 and (DATEDIFF(fechent,curdate()-1))>0 THEN
  if (select count(RUC) from clienteempresa where RUC = RC ) = 0 then
  if (select count(lugar) from lugaresprocedencia where lugar = lug ) = 0 then
   insert into lugaresprocedencia(idprocedencia,lugar) values (default,lug);
  end if;
  insert into clienteempresa(RUC, nombreEmpresa,idprocedencia,email) values (RC,nomemp,(select idprocedencia from lugaresprocedencia where lugar = lug),coremp);
  insert into   detallealojamiento(fechaReserva,fechaEntrada,fechaSalida,idestadoAloj,idhabitacion,idusuario,idclientePersona,RUC)
  values (curdate(),fechent,fechsal,1,idhab,idus,null,RC);
 Update habitaciones set idestadoHab=2 where idhabitacion=idhab;
  select concat('La reserva de "',RC,'" se registro satisfactoriamente');

 else
  insert into   detallealojamiento(fechaReserva,fechaEntrada,fechaSalida,idestadoAloj,idhabitacion,idusuario,idclientePersona,RUC)
  values (curdate(),fechent,fechsal,1,idhab,idus,null,RC);
 Update habitaciones set idestadoHab=2 where idhabitacion=idhab;
  select concat('La reserva de "',RC,'" se registro satisfactoriamente');
 end if;

ELSE
 select ('Ingrese una fecha valida');
END IF;

 when 2 then
IF(DATEDIFF(fechsal,fechent))>0 and (DATEDIFF(fechent,curdate()-1))>0 THEN
  if (select count(lugar) from lugaresprocedencia where lugar = lug ) = 0 then
      insert into lugaresprocedencia(lugar) values (lug);
    end if;
  update clienteempresa set nombreEmpresa=nomemp,
  idprocedencia=(select idprocedencia from lugaresprocedencia where lugar = lug), email=coremp where RUC = RC;
  update detallealojamiento set fechaEntrada=fechent,fechaSalida=fechsal,idhabitacion=idhab where idDetAloj=ID;

   if(select numHab from habitaciones where idhabitacion=idhab)=valhab then
      Update habitaciones set idestadoHab=2 where idhabitacion=idhab;
    else
      Update habitaciones set idestadoHab=1 where numHab=valhab;
      Update habitaciones set idestadoHab=2 where idhabitacion=idhab;
    end if;
  select concat('La reserva de "',RC,'" se edito satisfactoriamente');

ELSE
 select ('Ingrese una fecha valida');
END IF;

end case;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `proc_validar_reserva` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_validar_reserva`(id int, numhb varchar(5))
BEGIN
if(select count(*) from detallealojamiento where idDetAloj=id)!=0 then
  if(select count(*) from habitaciones where numHab=numhb)!=0 then
    if(select idestadoAloj from habitaciones )=1 then
      update habitaciones set idestadoHab=2 where numHab=numhb;
      update detallealojamiento set idestadoAloj=2 where idDetAloj=id;
    else
      select concat('La habitacion no esta disponible');
    end if;
  else
    select concat('No existe la habitacion');
  end if;
else
 select concat('La reserva no existe');
end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `v_principal`
--

/*!50001 DROP VIEW IF EXISTS `v_principal`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_principal` AS select `da`.`idDetAloj` AS `ID`,`da`.`fechaReserva` AS `Fecha`,`ce`.`nombreEmpresa` AS `Empresa_Cliente`,`h`.`numHab` AS `N°_Hab` from ((`detallealojamiento` `da` join `clienteempresa` `ce`) join `habitaciones` `h`) where ((`ce`.`RUC` = `da`.`RUC`) and (`h`.`idhabitacion` = `da`.`idhabitacion`) and (`da`.`idestadoAloj` = 1) and (`da`.`fechaEntrada` = curdate())) union select `da`.`idDetAloj` AS `ID`,`da`.`fechaReserva` AS `Fecha`,concat(`p`.`nomb`,' ',`p`.`apPat`,' ',`p`.`apMat`) AS `Cliente`,`h`.`numHab` AS `N°_Hab` from (((`detallealojamiento` `da` join `personas` `p`) join `habitaciones` `h`) join `clientepersona` `cp`) where ((`cp`.`idclientePersona` = `da`.`idclientePersona`) and (`h`.`idhabitacion` = `da`.`idhabitacion`) and (`p`.`DNI` = `cp`.`DNI`) and (`da`.`idestadoAloj` = 1) and (`da`.`fechaEntrada` = curdate())) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_reservaclient`
--

/*!50001 DROP VIEW IF EXISTS `v_reservaclient`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_reservaclient` AS select `da`.`idDetAloj` AS `ID`,`da`.`fechaReserva` AS `Fecha_Resv`,`da`.`fechaEntrada` AS `Fecha_Ent`,`da`.`fechaSalida` AS `Fecha_Sal`,`h`.`numHab` AS `N°Hab`,`th`.`nombreTH` AS `Tipo`,`cp`.`DNI` AS `DNI`,concat(`p`.`nomb`,_utf8' ',`p`.`apPat`,_utf8' ',`p`.`apMat`) AS `Cliente`,`pr`.`lugar` AS `Procedencia`,`u`.`login` AS `usuario` from ((((((`detallealojamiento` `da` join `habitaciones` `h`) join `tipohabitacion` `th`) join `clientepersona` `cp`) join `personas` `p`) join `lugaresprocedencia` `pr`) join `usuarios` `u` on((`da`.`idusuario` = `u`.`idusuario`))) where ((`th`.`idtipoHab` = `h`.`idtipoHab`) and (`pr`.`idprocedencia` = `cp`.`idprocedencia`) and (`cp`.`idclientePersona` = `da`.`idclientePersona`) and (`h`.`idhabitacion` = `da`.`idhabitacion`) and (`p`.`DNI` = `cp`.`DNI`) and (`da`.`idestadoAloj` = 1)) order by `da`.`fechaEntrada` desc */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_reservaemp`
--

/*!50001 DROP VIEW IF EXISTS `v_reservaemp`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_reservaemp` AS select `da`.`idDetAloj` AS `ID`,`da`.`fechaReserva` AS `Fecha_Resv`,`da`.`fechaEntrada` AS `Fecha_Ent`,`da`.`fechaSalida` AS `Fecha_Sal`,`h`.`numHab` AS `N°Hab`,`th`.`nombreTH` AS `Tipo`,`ce`.`RUC` AS `RUC`,`ce`.`nombreEmpresa` AS `Empresa`,`pr`.`lugar` AS `Procedencia` from ((((`detallealojamiento` `da` join `habitaciones` `h`) join `tipohabitacion` `th`) join `clienteempresa` `ce`) join `lugaresprocedencia` `pr`) where ((`th`.`idtipoHab` = `h`.`idtipoHab`) and (`pr`.`idprocedencia` = `ce`.`idprocedencia`) and (`ce`.`RUC` = `da`.`RUC`) and (`h`.`idhabitacion` = `da`.`idhabitacion`) and (`da`.`idestadoAloj` = 1)) order by `da`.`fechaEntrada` desc */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vis_alojamiento_empresa`
--

/*!50001 DROP VIEW IF EXISTS `vis_alojamiento_empresa`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vis_alojamiento_empresa` AS select `da`.`idDetAloj` AS `idDetAloj`,`da`.`fechaEntrada` AS `fechaEntrada`,`da`.`fechaSalida` AS `fechaSalida`,`h`.`numHab` AS `numHab`,`th`.`nombreTH` AS `nombreTH`,`ce`.`RUC` AS `RUC`,`ce`.`nombreEmpresa` AS `nombreEmpresa`,`l`.`lugar` AS `lugar` from ((((`lugaresprocedencia` `l` join `clienteempresa` `ce` on((`l`.`idprocedencia` = `ce`.`idprocedencia`))) join `detallealojamiento` `da` on((`ce`.`RUC` = `da`.`RUC`))) join `habitaciones` `h` on((`h`.`idhabitacion` = `da`.`idhabitacion`))) join `tipohabitacion` `th` on((`th`.`idtipoHab` = `h`.`idtipoHab`))) where (`da`.`idestadoAloj` = 2) order by `da`.`fechaEntrada` desc */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vis_alojamiento_persona`
--

/*!50001 DROP VIEW IF EXISTS `vis_alojamiento_persona`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vis_alojamiento_persona` AS select `da`.`idDetAloj` AS `idDetAloj`,`da`.`fechaEntrada` AS `fechaEntrada`,`da`.`fechaSalida` AS `fechaSalida`,`h`.`numHab` AS `numHab`,`th`.`nombreTH` AS `nombreTH`,`p`.`DNI` AS `DNI`,concat(`p`.`apPat`,' ',`p`.`apMat`,' ',`p`.`nomb`) AS `Cliente`,`lp`.`lugar` AS `lugar` from (((((`personas` `p` join `clientepersona` `cp` on((`p`.`DNI` = `cp`.`DNI`))) join `lugaresprocedencia` `lp` on((`cp`.`idprocedencia` = `lp`.`idprocedencia`))) join `detallealojamiento` `da` on((`da`.`idclientePersona` = `cp`.`idclientePersona`))) join `habitaciones` `h` on((`h`.`idhabitacion` = `da`.`idhabitacion`))) join `tipohabitacion` `th` on((`th`.`idtipoHab` = `h`.`idtipoHab`))) where (`da`.`idestadoAloj` = 2) order by `da`.`fechaEntrada` desc */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_clienteempresa`
--

/*!50001 DROP VIEW IF EXISTS `vw_clienteempresa`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_clienteempresa` AS select `ce`.`RUC` AS `ruc`,`ce`.`nombreEmpresa` AS `nombre`,`ce`.`email` AS `email`,`l`.`lugar` AS `lugar` from (`clienteempresa` `ce` join `lugaresprocedencia` `l` on((`l`.`idprocedencia` = `ce`.`idprocedencia`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_clientepersona`
--

/*!50001 DROP VIEW IF EXISTS `vw_clientepersona`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_clientepersona` AS select `p`.`DNI` AS `dni`,`p`.`apPat` AS `apPat`,`p`.`apMat` AS `apMat`,`p`.`nomb` AS `nombre`,`p`.`email` AS `email`,`l`.`lugar` AS `lugar` from ((`clientepersona` `cp` join `personas` `p` on((`cp`.`DNI` = `p`.`DNI`))) join `lugaresprocedencia` `l` on((`l`.`idprocedencia` = `cp`.`idprocedencia`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_empleados`
--

/*!50001 DROP VIEW IF EXISTS `vw_empleados`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_empleados` AS select `p`.`DNI` AS `dni`,concat(`p`.`apPat`,' ',`p`.`apMat`) AS `apellidos`,`p`.`nomb` AS `nombres`,`p`.`email` AS `mail`,`c`.`cargo` AS `cargo`,`est`.`estado` AS `estado`,`u`.`login` AS `username`,`u`.`psw` AS `psw` from ((((`empleados` `e` join `personas` `p` on((`p`.`DNI` = `e`.`DNI`))) join `cargos` `c` on((`c`.`idcargo` = `e`.`idcargo`))) join `estadoempleado` `est` on((`est`.`idEstEmp` = `e`.`idEstEmp`))) join `usuarios` `u` on((`u`.`idempleado` = `e`.`idempleado`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_habitacion`
--

/*!50001 DROP VIEW IF EXISTS `vw_habitacion`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_habitacion` AS select `h`.`idhabitacion` AS `id`,`h`.`numHab` AS `numero`,`t`.`nombreTH` AS `tipo`,`t`.`precioTH` AS `precio`,`e`.`estadoHab` AS `estado` from ((`habitaciones` `h` join `tipohabitacion` `t` on((`t`.`idtipoHab` = `h`.`idtipoHab`))) join `estadohabitacion` `e` on((`e`.`idestadoHab` = `h`.`idestadoHab`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-03 17:19:06
