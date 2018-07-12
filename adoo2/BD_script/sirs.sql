-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: sirs
-- ------------------------------------------------------
-- Server version	5.6.17

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
-- Table structure for table `chofer`
--

DROP TABLE IF EXISTS `chofer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chofer` (
  `id_chofer` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido_paterno` varchar(45) NOT NULL,
  `apellido_materno` varchar(45) NOT NULL,
  `curp` char(18) NOT NULL,
  `licencia_manejo` varchar(45) NOT NULL,
  `correo_chofer` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_chofer`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chofer`
--

LOCK TABLES `chofer` WRITE;
/*!40000 ALTER TABLE `chofer` DISABLE KEYS */;
/*!40000 ALTER TABLE `chofer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `colonia`
--

DROP TABLE IF EXISTS `colonia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `colonia` (
  `Nombre_colonia` varchar(50) NOT NULL,
  `delegacion_colonia` varchar(45) NOT NULL,
  `codigo_postal_colonia` varchar(45) NOT NULL,
  `numero_habitantes_colonia` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Nombre_colonia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colonia`
--

LOCK TABLES `colonia` WRITE;
/*!40000 ALTER TABLE `colonia` DISABLE KEYS */;
/*!40000 ALTER TABLE `colonia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `destino`
--

DROP TABLE IF EXISTS `destino`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `destino` (
  `nombre_destino` varchar(45) NOT NULL,
  `calle_destino` varchar(45) NOT NULL,
  `numero_destino` varchar(45) NOT NULL,
  `delegacion_destino` varchar(45) NOT NULL,
  `codigo_postal_destino` varchar(45) NOT NULL,
  `id_destino_clave` varchar(45) NOT NULL,
  `capacidad_de_operacion` int(11) NOT NULL,
  `colonia_destino` varchar(45) NOT NULL,
  PRIMARY KEY (`nombre_destino`),
  KEY `id_destino_clave_idx` (`id_destino_clave`),
  CONSTRAINT `id_destino_clave` FOREIGN KEY (`id_destino_clave`) REFERENCES `destino_clave` (`clave_destino`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `destino`
--

LOCK TABLES `destino` WRITE;
/*!40000 ALTER TABLE `destino` DISABLE KEYS */;
/*!40000 ALTER TABLE `destino` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `destino_clave`
--

DROP TABLE IF EXISTS `destino_clave`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `destino_clave` (
  `clave_destino` varchar(35) NOT NULL,
  `nombre_destino` varchar(45) NOT NULL,
  `descripcion_destino` text,
  PRIMARY KEY (`clave_destino`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `destino_clave`
--

LOCK TABLES `destino_clave` WRITE;
/*!40000 ALTER TABLE `destino_clave` DISABLE KEYS */;
INSERT INTO `destino_clave` VALUES ('1','a',NULL);
/*!40000 ALTER TABLE `destino_clave` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `giro_empresa`
--

DROP TABLE IF EXISTS `giro_empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `giro_empresa` (
  `id_sitio_especifico` int(11) NOT NULL,
  `giro_emprea` varchar(45) NOT NULL,
  PRIMARY KEY (`id_sitio_especifico`,`giro_emprea`),
  CONSTRAINT `id_sitio_especifico_empresa` FOREIGN KEY (`id_sitio_especifico`) REFERENCES `sitio_especifico` (`id_sitio_especifico`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `giro_empresa`
--

LOCK TABLES `giro_empresa` WRITE;
/*!40000 ALTER TABLE `giro_empresa` DISABLE KEYS */;
/*!40000 ALTER TABLE `giro_empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `infraestructura`
--

DROP TABLE IF EXISTS `infraestructura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `infraestructura` (
  `id_destino` varchar(45) NOT NULL,
  `superficie` int(11) DEFAULT NULL,
  `maquinaria` text,
  `forma_de_operacion` text,
  `numero_trabajadores` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_destino`),
  CONSTRAINT `id_destino_infra` FOREIGN KEY (`id_destino`) REFERENCES `destino` (`nombre_destino`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `infraestructura`
--

LOCK TABLES `infraestructura` WRITE;
/*!40000 ALTER TABLE `infraestructura` DISABLE KEYS */;
/*!40000 ALTER TABLE `infraestructura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plan_de_manejo`
--

DROP TABLE IF EXISTS `plan_de_manejo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `plan_de_manejo` (
  `clave_plan_de_manejo` varchar(40) NOT NULL,
  `nom_respon_plan_de_manejo` varchar(45) NOT NULL,
  `appat_respon_plan_de_manejocol` varchar(45) NOT NULL,
  `apmat_respon_plan_de_manejo` varchar(45) NOT NULL,
  `meta` text,
  `justificacion_plan_de_manejo` text,
  `proced_recolec_plan_de_manejo` text NOT NULL,
  `proced_recep_plan_de_manejo` text NOT NULL,
  `id_sitio_especifico` int(11) DEFAULT NULL,
  PRIMARY KEY (`clave_plan_de_manejo`),
  KEY `id_sitio_especifico_plan_idx` (`id_sitio_especifico`),
  CONSTRAINT `id_sitio_especifico_plan` FOREIGN KEY (`id_sitio_especifico`) REFERENCES `sitio_especifico` (`id_sitio_especifico`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plan_de_manejo`
--

LOCK TABLES `plan_de_manejo` WRITE;
/*!40000 ALTER TABLE `plan_de_manejo` DISABLE KEYS */;
/*!40000 ALTER TABLE `plan_de_manejo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plan_residuo`
--

DROP TABLE IF EXISTS `plan_residuo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `plan_residuo` (
  `id_plan` varchar(40) NOT NULL,
  `id_residuo` varchar(35) NOT NULL,
  `toneladas_plan_residuo` int(11) NOT NULL,
  `almacenamiento_plan_residuo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_plan`,`id_residuo`),
  KEY `id_residuo_idx` (`id_residuo`),
  CONSTRAINT `id_planmanejo` FOREIGN KEY (`id_plan`) REFERENCES `plan_de_manejo` (`clave_plan_de_manejo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_residuo` FOREIGN KEY (`id_residuo`) REFERENCES `residuo` (`clave_residuo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plan_residuo`
--

LOCK TABLES `plan_residuo` WRITE;
/*!40000 ALTER TABLE `plan_residuo` DISABLE KEYS */;
/*!40000 ALTER TABLE `plan_residuo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recepcion_destino_residuo`
--

DROP TABLE IF EXISTS `recepcion_destino_residuo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recepcion_destino_residuo` (
  `id_destino_nombre_recepcio` varchar(45) NOT NULL,
  `id_residuo_recepcion` varchar(35) NOT NULL,
  `hr_fecha_recepcion` datetime NOT NULL,
  `toneladas` int(11) NOT NULL,
  `origen` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_residuo_recepcion`,`hr_fecha_recepcion`,`id_destino_nombre_recepcio`),
  KEY `id_residuo_recpecion_idx` (`id_residuo_recepcion`),
  KEY `id_origen_idx` (`origen`),
  KEY `id_destino_nombre_idx` (`id_destino_nombre_recepcio`),
  CONSTRAINT `id_destino_nombre` FOREIGN KEY (`id_destino_nombre_recepcio`) REFERENCES `destino` (`nombre_destino`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_origen` FOREIGN KEY (`origen`) REFERENCES `destino` (`nombre_destino`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_residuo_recpecion` FOREIGN KEY (`id_residuo_recepcion`) REFERENCES `residuo` (`clave_residuo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recepcion_destino_residuo`
--

LOCK TABLES `recepcion_destino_residuo` WRITE;
/*!40000 ALTER TABLE `recepcion_destino_residuo` DISABLE KEYS */;
/*!40000 ALTER TABLE `recepcion_destino_residuo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `residuo`
--

DROP TABLE IF EXISTS `residuo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `residuo` (
  `clave_residuo` varchar(35) NOT NULL,
  `tipo_residuo` varchar(45) NOT NULL,
  `caract_fisicas_residuo` text NOT NULL,
  `caract_quimicas_residuo` text NOT NULL,
  `fuente` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`clave_residuo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `residuo`
--

LOCK TABLES `residuo` WRITE;
/*!40000 ALTER TABLE `residuo` DISABLE KEYS */;
/*!40000 ALTER TABLE `residuo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ruta`
--

DROP TABLE IF EXISTS `ruta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ruta` (
  `id_ruta` varchar(50) NOT NULL,
  `nombre_ruta` varchar(45) NOT NULL,
  PRIMARY KEY (`id_ruta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ruta`
--

LOCK TABLES `ruta` WRITE;
/*!40000 ALTER TABLE `ruta` DISABLE KEYS */;
/*!40000 ALTER TABLE `ruta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ruta_colonia_sitioesp`
--

DROP TABLE IF EXISTS `ruta_colonia_sitioesp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ruta_colonia_sitioesp` (
  `id_ruta` varchar(50) NOT NULL,
  `id_colonia_fk` varchar(50) DEFAULT NULL,
  `id_sitio_especifico_fk` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_ruta`),
  KEY `id_ruta_colonia_sitioesp2_idx` (`id_colonia_fk`),
  KEY `id_ruta_colonia_sitioesp2_idx1` (`id_sitio_especifico_fk`),
  CONSTRAINT `id_ruta_colonia_sitioesp` FOREIGN KEY (`id_colonia_fk`) REFERENCES `colonia` (`Nombre_colonia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_ruta_colonia_sitioesp1` FOREIGN KEY (`id_ruta`) REFERENCES `ruta` (`id_ruta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_ruta_colonia_sitioesp2` FOREIGN KEY (`id_sitio_especifico_fk`) REFERENCES `sitio_especifico` (`id_sitio_especifico`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ruta_colonia_sitioesp`
--

LOCK TABLES `ruta_colonia_sitioesp` WRITE;
/*!40000 ALTER TABLE `ruta_colonia_sitioesp` DISABLE KEYS */;
/*!40000 ALTER TABLE `ruta_colonia_sitioesp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sitio_especifico`
--

DROP TABLE IF EXISTS `sitio_especifico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sitio_especifico` (
  `id_sitio_especifico` int(11) NOT NULL,
  `Nombre_sitio_especifico` varchar(100) NOT NULL,
  `calle_sitio_especifico` varchar(45) NOT NULL,
  `numero_sitio_especifico` varchar(45) DEFAULT NULL,
  `delegacion_sitio_especifico` varchar(45) NOT NULL,
  `codigo_postal_sitio_especifico` varchar(45) NOT NULL,
  `correo_sitio_especifico` varchar(45) DEFAULT NULL,
  `telefono_sitio_especifico` varchar(45) DEFAULT NULL,
  `colonia_sitio_especifico` varchar(45) NOT NULL,
  `id_tipo_sitio_especificocol` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_sitio_especifico`),
  KEY `id_tipo_sitio_especifico_idx` (`id_tipo_sitio_especificocol`),
  CONSTRAINT `id_tipo_sitio_especifico` FOREIGN KEY (`id_tipo_sitio_especificocol`) REFERENCES `tipo_sitio_especifico` (`id_tipo_sitio_especifico`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sitio_especifico`
--

LOCK TABLES `sitio_especifico` WRITE;
/*!40000 ALTER TABLE `sitio_especifico` DISABLE KEYS */;
/*!40000 ALTER TABLE `sitio_especifico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telefono_chofer`
--

DROP TABLE IF EXISTS `telefono_chofer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `telefono_chofer` (
  `id_chofer` int(11) NOT NULL,
  `telefono` varchar(30) NOT NULL,
  PRIMARY KEY (`telefono`,`id_chofer`),
  KEY `id_telefono_chofer_idx` (`id_chofer`),
  CONSTRAINT `id_telefono_chofer` FOREIGN KEY (`id_chofer`) REFERENCES `chofer` (`id_chofer`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefono_chofer`
--

LOCK TABLES `telefono_chofer` WRITE;
/*!40000 ALTER TABLE `telefono_chofer` DISABLE KEYS */;
/*!40000 ALTER TABLE `telefono_chofer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_sitio_especifico`
--

DROP TABLE IF EXISTS `tipo_sitio_especifico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_sitio_especifico` (
  `id_tipo_sitio_especifico` int(11) NOT NULL,
  `tipo_sitio_especifico` varchar(45) NOT NULL,
  `Descripcio_tipo_sitio` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_tipo_sitio_especifico`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_sitio_especifico`
--

LOCK TABLES `tipo_sitio_especifico` WRITE;
/*!40000 ALTER TABLE `tipo_sitio_especifico` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_sitio_especifico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_vehiculo_recolector`
--

DROP TABLE IF EXISTS `tipo_vehiculo_recolector`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_vehiculo_recolector` (
  `id_tipo_vehiculo` int(11) NOT NULL,
  `tipo_vehiculo` varchar(45) NOT NULL,
  `capacidad` decimal(10,0) NOT NULL,
  `peso` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id_tipo_vehiculo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_vehiculo_recolector`
--

LOCK TABLES `tipo_vehiculo_recolector` WRITE;
/*!40000 ALTER TABLE `tipo_vehiculo_recolector` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_vehiculo_recolector` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehiculo_recolector`
--

DROP TABLE IF EXISTS `vehiculo_recolector`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehiculo_recolector` (
  `matricula` varchar(15) NOT NULL,
  `modelo` varchar(25) DEFAULT NULL,
  `año` int(11) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `id_tipo_vehiculo` int(11) NOT NULL,
  `id_chofer` int(11) DEFAULT NULL,
  PRIMARY KEY (`matricula`),
  KEY `id_tipo_vehiculo_idx` (`id_tipo_vehiculo`),
  KEY `id_vehiculo_chofer_idx` (`id_chofer`),
  CONSTRAINT `id_tipo_vehiculo` FOREIGN KEY (`id_tipo_vehiculo`) REFERENCES `tipo_vehiculo_recolector` (`id_tipo_vehiculo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_vehiculo_chofer` FOREIGN KEY (`id_chofer`) REFERENCES `chofer` (`id_chofer`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculo_recolector`
--

LOCK TABLES `vehiculo_recolector` WRITE;
/*!40000 ALTER TABLE `vehiculo_recolector` DISABLE KEYS */;
/*!40000 ALTER TABLE `vehiculo_recolector` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `viaje_por_dia`
--

DROP TABLE IF EXISTS `viaje_por_dia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `viaje_por_dia` (
  `id_vehiculo_recolector` varchar(15) NOT NULL,
  `id_ruta` varchar(50) NOT NULL,
  `id_destino_nombre` varchar(45) NOT NULL,
  `inicio_viaje` datetime NOT NULL,
  `fin_viaje` datetime DEFAULT NULL,
  PRIMARY KEY (`id_vehiculo_recolector`,`id_ruta`,`id_destino_nombre`,`inicio_viaje`),
  KEY `id_ruta_viaje_idx` (`id_ruta`),
  KEY `id_destino_nombre_viaje_idx` (`id_destino_nombre`),
  CONSTRAINT `id_destino_nombre_viaje` FOREIGN KEY (`id_destino_nombre`) REFERENCES `destino` (`nombre_destino`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_ruta_viaje` FOREIGN KEY (`id_ruta`) REFERENCES `ruta` (`id_ruta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_vechiculo_viaje` FOREIGN KEY (`id_vehiculo_recolector`) REFERENCES `vehiculo_recolector` (`matricula`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `viaje_por_dia`
--

LOCK TABLES `viaje_por_dia` WRITE;
/*!40000 ALTER TABLE `viaje_por_dia` DISABLE KEYS */;
/*!40000 ALTER TABLE `viaje_por_dia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'sirs'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-17 21:17:33
