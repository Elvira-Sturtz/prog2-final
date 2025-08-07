-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: apuestas
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `apuesta`
--

DROP TABLE IF EXISTS `apuesta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `apuesta` (
  `id_apuesta` int NOT NULL AUTO_INCREMENT,
  `monto` decimal(10,2) NOT NULL,
  `por_quien` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `fk_id_resultado` int DEFAULT NULL,
  `fk_id_usuario` int DEFAULT NULL,
  `fk_id_partido` int DEFAULT NULL,
  `estado` varchar(20) COLLATE utf8mb4_general_ci DEFAULT 'N',
  PRIMARY KEY (`id_apuesta`),
  KEY `fk_id_resultado` (`fk_id_resultado`),
  KEY `fk_id_usuario` (`fk_id_usuario`),
  KEY `fk_id_partido` (`fk_id_partido`),
  CONSTRAINT `apuesta_ibfk_3` FOREIGN KEY (`fk_id_resultado`) REFERENCES `resultado` (`id_resultado`),
  CONSTRAINT `apuesta_ibfk_4` FOREIGN KEY (`fk_id_usuario`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `apuesta_ibfk_5` FOREIGN KEY (`fk_id_partido`) REFERENCES `partido` (`id_partido`),
  CONSTRAINT `fk_apuesta_resultado` FOREIGN KEY (`fk_id_resultado`) REFERENCES `resultado` (`id_resultado`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apuesta`
--

LOCK TABLES `apuesta` WRITE;
/*!40000 ALTER TABLE `apuesta` DISABLE KEYS */;
INSERT INTO `apuesta` VALUES (61,1.00,'local',1,22,1,'N'),(62,1.00,'local',1,22,1,'N'),(63,50.00,'local',1,22,1,'G'),(64,50.00,'local',1,22,1,'G'),(65,100.00,'local',1,22,1,'G'),(66,50.00,'local',1,22,1,'G'),(67,100.00,'local',1,22,1,'G'),(68,100.00,'local',1,22,1,'G'),(69,100.00,'local',1,22,1,'G'),(70,50.00,'local',1,22,1,'G'),(71,100.00,'local',1,22,1,'N'),(72,100.00,'local',1,22,1,'N'),(73,100.00,'local',1,22,1,'N'),(74,100.00,'local',1,22,1,'N'),(75,400.00,'local',1,22,1,'N'),(76,200.00,'local',1,22,1,'N'),(77,150.00,'local',1,22,1,'N'),(78,1000.00,'local',1,22,1,'N'),(79,1000.00,'local',1,22,1,'N'),(80,1000.00,'visitante',1,22,1,'N'),(81,25.00,'local',2,1,2,'N'),(82,23.00,'local',2,24,2,'N'),(83,3.00,'local',5,24,5,'\0'),(84,76.00,'local',8,24,8,'\0');
/*!40000 ALTER TABLE `apuesta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partido`
--

DROP TABLE IF EXISTS `partido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `partido` (
  `id_partido` int NOT NULL AUTO_INCREMENT,
  `local` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `visitante` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `fecha` date DEFAULT NULL,
  PRIMARY KEY (`id_partido`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partido`
--

LOCK TABLES `partido` WRITE;
/*!40000 ALTER TABLE `partido` DISABLE KEYS */;
INSERT INTO `partido` VALUES (1,'Real Madrid','FC Barcelona','2023-11-01'),(2,'Manchester City','Liverpool FC','2023-11-02'),(3,'Bayern Munich','Borussia Dortmund','2023-11-03'),(4,'Paris Saint-Germain','AC Milan','2023-11-04'),(5,'Juventus','Inter Milan','2023-11-05'),(6,'Chelsea FC','Arsenal FC','2023-11-06'),(7,'Atletico Madrid','Sevilla FC','2023-11-07'),(8,'Borussia Monchengladbach','Hertha Berlin','2023-11-08'),(9,'Ajax Amsterdam','PSV Eindhoven','2023-11-09'),(10,'AS Roma','SS Lazio','2023-11-10'),(11,'FC Porto','SL Benfica','2023-11-11'),(12,'Tottenham Hotspur','Manchester United','2023-11-12'),(13,'ACF Fiorentina','Napoli','2023-11-13'),(14,'Everton FC','Leeds United','2023-11-14'),(15,'Ajax Cape Town','Kaizer Chiefs','2023-11-15'),(16,'Madrid','Barcelona','2025-01-10'),(17,'Manchester City','Liverpool ','2025-02-20'),(18,'Manchester City','Barcelona','2025-05-25'),(19,'Lo','Vi','2025-09-30'),(20,'eqL','eqV','2025-08-30'),(22,'Local1','Visitante1','2026-02-03'),(23,'Barcelona','Madrid','2026-07-23'),(24,'Boca','River','2027-08-30'),(26,'Barcelona','Visitante1','2026-07-27'),(27,'Madrid','Boca','2026-04-28'),(29,'Barcelona','Racing','2026-03-23'),(30,'boca','racing','2026-03-26'),(31,'Barcelona','Independiente','2025-07-06'),(32,'huracan','racing','2025-09-28'),(33,'Huracan','Racing','2025-09-28'),(34,'Independiente','Huracan','2025-08-04'),(35,'Independiente','Huracan','2025-08-04'),(36,'Huracan','Madrid','2025-09-06'),(37,'Barcelona','Huracan','2025-09-02'),(38,'Estudiantes','Huracan','2025-08-29'),(39,'Madrid','Estudiantes','2025-08-29'),(40,'Barcelona','Huracan','2025-10-07'),(41,'Mandillu','racing','2025-11-12');
/*!40000 ALTER TABLE `partido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persona` (
  `id_persona` int NOT NULL AUTO_INCREMENT,
  `dni` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `nombre` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `apellido` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `edad` int DEFAULT NULL,
  `fk_id_usuario` int DEFAULT NULL,
  PRIMARY KEY (`id_persona`),
  KEY `fk_id_usuario` (`fk_id_usuario`),
  CONSTRAINT `persona_ibfk_1` FOREIGN KEY (`fk_id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'42382349','Nombre1','Apellido1',NULL,NULL),(2,'25560981','Nombre2','Apellido2',NULL,NULL),(3,'19632400','Nombre3','Apellido3',NULL,NULL),(4,'33254417','Nombre4','Apellido4',NULL,NULL),(5,'28385463','Nombre5','Apellido5',NULL,NULL),(6,'37334279','Nombre6','Apellido6',NULL,NULL),(7,'32529631','Nombre7','Apellido7',NULL,NULL),(8,'35995411','Nombre8','Apellido8',NULL,NULL),(9,'37579419','Nombre9','Apellido9',NULL,NULL),(10,'25469541','Nombre10','Apellido10',NULL,NULL),(11,'31799881','Nombre11','Apellido11',NULL,NULL),(12,'41034616','Nombre12','Apellido12',NULL,NULL),(13,'40482394','Nombre13','Apellido13',NULL,NULL),(14,'35720751','Nombre14','Apellido14',NULL,NULL),(15,'26382240','Nombre15','Apellido15',NULL,NULL),(16,'2344','ian','tepper',35,21),(17,'43314','qwe','qwe',34,22),(18,'12345678','a','a',20,24),(19,'87654321','s','s',22,25),(20,'87654321','s','s',22,26);
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resultado`
--

DROP TABLE IF EXISTS `resultado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resultado` (
  `id_resultado` int NOT NULL AUTO_INCREMENT,
  `ganador` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `fk_id_partido` int DEFAULT NULL,
  PRIMARY KEY (`id_resultado`),
  KEY `fk_id_partido` (`fk_id_partido`),
  CONSTRAINT `resultado_ibfk_1` FOREIGN KEY (`fk_id_partido`) REFERENCES `partido` (`id_partido`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resultado`
--

LOCK TABLES `resultado` WRITE;
/*!40000 ALTER TABLE `resultado` DISABLE KEYS */;
INSERT INTO `resultado` VALUES (1,'local',1),(2,'local',2),(3,'local',3),(4,'local',4),(5,'local',5),(6,'local',6),(7,'local',7),(8,'local',8),(9,'local',9),(10,'local',10),(11,'local',11),(12,'local',12),(13,'local',13),(14,'local',14),(15,'local',15);
/*!40000 ALTER TABLE `resultado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `usuario` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `contrasenia` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `dinero` decimal(10,2) DEFAULT '0.00',
  `rol` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Usuario1','Contraseña1',350.00,'std'),(2,'Usuario2','Contraseña2',0.00,'std'),(3,'Usuario3','Contraseña3',0.00,'std'),(4,'Usuario4','Contraseña4',0.00,'std'),(5,'Usuario5','Contraseña5',0.00,'std'),(6,'Usuario6','Contraseña6',0.00,'std'),(7,'Usuario7','Contraseña7',0.00,'std'),(8,'Usuario8','Contraseña8',0.00,'std'),(9,'Usuario9','Contraseña9',0.00,'std'),(10,'Usuario10','Contraseña10',0.00,'std'),(11,'Usuario11','Contraseña11',0.00,'std'),(12,'Usuario12','Contraseña12',0.00,'std'),(13,'Usuario13','Contraseña13',0.00,'std'),(14,'Usuario14','Contraseña14',0.00,'std'),(15,'Usuario15','Contraseña15',0.00,'std'),(21,'ianalan','contraseña',0.00,'std'),(22,'1','1',3000.00,'std'),(23,'admin','1234',325.00,'admin'),(24,'prueba','90',452.00,'user'),(25,'st','30',0.00,'std'),(26,'st','30',0.00,'final');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-06 17:34:37
