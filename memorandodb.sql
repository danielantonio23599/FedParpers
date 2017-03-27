-- MySQL dump 10.16  Distrib 10.1.13-MariaDB, for Win32 (AMD64)
--
-- Host: localhost    Database: memorandobd
-- ------------------------------------------------------
-- Server version	10.1.13-MariaDB

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
-- Table structure for table `anexo`
--

DROP TABLE IF EXISTS `anexo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `anexo` (
  `aneCodigo` int(11) NOT NULL AUTO_INCREMENT,
  `aneURL` text,
  `ane_docCodigo` int(11) DEFAULT NULL,
  PRIMARY KEY (`aneCodigo`),
  KEY `fk_anexo_documento1_idx` (`ane_docCodigo`),
  CONSTRAINT `fk_anexo_documento1` FOREIGN KEY (`ane_docCodigo`) REFERENCES `documento` (`docCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `anexo`
--

LOCK TABLES `anexo` WRITE;
/*!40000 ALTER TABLE `anexo` DISABLE KEYS */;
/*!40000 ALTER TABLE `anexo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `area`
--

DROP TABLE IF EXISTS `area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `area` (
  `areCodigo` int(11) NOT NULL AUTO_INCREMENT,
  `areNome` varchar(45) NOT NULL,
  `areDescricao` text,
  PRIMARY KEY (`areCodigo`),
  UNIQUE KEY `areNome_UNIQUE` (`areNome`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area`
--

LOCK TABLES `area` WRITE;
/*!40000 ALTER TABLE `area` DISABLE KEYS */;
INSERT INTO `area` VALUES (1,'Administração',NULL),(2,'Computação',NULL),(3,'Engenharioa',NULL),(4,'Matemática',NULL);
/*!40000 ALTER TABLE `area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cargo`
--

DROP TABLE IF EXISTS `cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cargo` (
  `carCodigo` int(11) NOT NULL AUTO_INCREMENT,
  `carNome` varchar(45) NOT NULL,
  `carDescricao` text,
  PRIMARY KEY (`carCodigo`),
  UNIQUE KEY `carNome_UNIQUE` (`carNome`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargo`
--

LOCK TABLES `cargo` WRITE;
/*!40000 ALTER TABLE `cargo` DISABLE KEYS */;
INSERT INTO `cargo` VALUES (1,'Adiministrador',''),(2,'Professor','');
/*!40000 ALTER TABLE `cargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contato`
--

DROP TABLE IF EXISTS `contato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contato` (
  `conCodigo` int(11) NOT NULL AUTO_INCREMENT,
  `conNome` varchar(45) NOT NULL,
  `conEnderecoEletronico` varchar(50) NOT NULL,
  `conTipoUser` varchar(45) NOT NULL,
  `con_usuCodigo` int(11) NOT NULL,
  PRIMARY KEY (`conCodigo`),
  UNIQUE KEY `conEnderecoEletronico_UNIQUE` (`conEnderecoEletronico`),
  KEY `fk_contato_usuario1_idx` (`con_usuCodigo`),
  CONSTRAINT `fk_contato_usuario1` FOREIGN KEY (`con_usuCodigo`) REFERENCES `usuario` (`usuCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contato`
--

LOCK TABLES `contato` WRITE;
/*!40000 ALTER TABLE `contato` DISABLE KEYS */;
INSERT INTO `contato` VALUES (9,'mat','mat.godo','Usuário Esterno',1);
/*!40000 ALTER TABLE `contato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `destiex_doc`
--

DROP TABLE IF EXISTS `destiex_doc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `destiex_doc` (
  `ded_deeCodigo` int(11) NOT NULL,
  `ded_docCodigo` int(11) NOT NULL,
  PRIMARY KEY (`ded_deeCodigo`,`ded_docCodigo`),
  KEY `fk_destinatarioExterno_has_documento_documento1_idx` (`ded_docCodigo`),
  KEY `fk_destinatarioExterno_has_documento_destinatarioExterno1_idx` (`ded_deeCodigo`),
  CONSTRAINT `fk_destinatarioExterno_has_documento_destinatarioExterno1` FOREIGN KEY (`ded_deeCodigo`) REFERENCES `destinatarioexterno` (`deeCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_destinatarioExterno_has_documento_documento1` FOREIGN KEY (`ded_docCodigo`) REFERENCES `documento` (`docCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `destiex_doc`
--

LOCK TABLES `destiex_doc` WRITE;
/*!40000 ALTER TABLE `destiex_doc` DISABLE KEYS */;
/*!40000 ALTER TABLE `destiex_doc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `destinatarioexterno`
--

DROP TABLE IF EXISTS `destinatarioexterno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `destinatarioexterno` (
  `deeCodigo` int(11) NOT NULL AUTO_INCREMENT,
  `deeNome` varchar(45) NOT NULL,
  `deeEmail` varchar(100) NOT NULL,
  `deeEndereco` varchar(200) NOT NULL,
  PRIMARY KEY (`deeCodigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `destinatarioexterno`
--

LOCK TABLES `destinatarioexterno` WRITE;
/*!40000 ALTER TABLE `destinatarioexterno` DISABLE KEYS */;
/*!40000 ALTER TABLE `destinatarioexterno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `destinatariointerno`
--

DROP TABLE IF EXISTS `destinatariointerno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `destinatariointerno` (
  `deiCodigo` int(11) NOT NULL AUTO_INCREMENT,
  `dei_docCodigo` int(11) NOT NULL,
  `dei_usuCodigo` int(11) NOT NULL,
  PRIMARY KEY (`deiCodigo`),
  KEY `fk_destinatarioInterno_documento1_idx` (`dei_docCodigo`),
  KEY `fk_destinatarioInterno_usuario1_idx` (`dei_usuCodigo`),
  CONSTRAINT `fk_destinatarioInterno_documento1` FOREIGN KEY (`dei_docCodigo`) REFERENCES `documento` (`docCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_destinatarioInterno_usuario1` FOREIGN KEY (`dei_usuCodigo`) REFERENCES `usuario` (`usuCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `destinatariointerno`
--

LOCK TABLES `destinatariointerno` WRITE;
/*!40000 ALTER TABLE `destinatariointerno` DISABLE KEYS */;
/*!40000 ALTER TABLE `destinatariointerno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `documento`
--

DROP TABLE IF EXISTS `documento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `documento` (
  `docCodigo` int(11) NOT NULL AUTO_INCREMENT,
  `docData` datetime NOT NULL,
  `docAssunto` text NOT NULL,
  `docRemetente` varchar(45) NOT NULL,
  `docCorpoTexto` text NOT NULL,
  `doc_usuCodigo` int(11) NOT NULL,
  PRIMARY KEY (`docCodigo`),
  KEY `fk_documento_usuario1_idx` (`doc_usuCodigo`),
  CONSTRAINT `fk_documento_usuario1` FOREIGN KEY (`doc_usuCodigo`) REFERENCES `usuario` (`usuCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `documento`
--

LOCK TABLES `documento` WRITE;
/*!40000 ALTER TABLE `documento` DISABLE KEYS */;
/*!40000 ALTER TABLE `documento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `documento_status`
--

DROP TABLE IF EXISTS `documento_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `documento_status` (
  `dcs_docCodigo` int(11) NOT NULL,
  `dcs_tisCodigo` int(11) NOT NULL,
  `dcsData` datetime NOT NULL,
  `dcsObservacao` varchar(100) NOT NULL,
  PRIMARY KEY (`dcs_docCodigo`,`dcs_tisCodigo`),
  KEY `fk_documento_has_tipoStatus_tipoStatus1_idx` (`dcs_tisCodigo`),
  KEY `fk_documento_has_tipoStatus_documento1_idx` (`dcs_docCodigo`),
  CONSTRAINT `fk_documento_has_tipoStatus_documento1` FOREIGN KEY (`dcs_docCodigo`) REFERENCES `documento` (`docCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_documento_has_tipoStatus_tipoStatus1` FOREIGN KEY (`dcs_tisCodigo`) REFERENCES `status` (`staCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `documento_status`
--

LOCK TABLES `documento_status` WRITE;
/*!40000 ALTER TABLE `documento_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `documento_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `logCodigo` int(11) NOT NULL AUTO_INCREMENT,
  `logLogin` varchar(50) NOT NULL,
  `logSenha` text NOT NULL,
  PRIMARY KEY (`logCodigo`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (28,'daniel','aa47f8215c6f30a0dcdb2a36a9f4168e'),(33,'111111','1bbd886460827015e5d605ed44252251'),(35,'test','098f6bcd4621d373cade4e832627b4f6'),(36,'teste','698dc19d489c4e4db73e28a713eab07b'),(37,'test','698dc19d489c4e4db73e28a713eab07b');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `setor`
--

DROP TABLE IF EXISTS `setor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `setor` (
  `setCodigo` int(11) NOT NULL AUTO_INCREMENT,
  `setNome` varchar(45) NOT NULL,
  `setDescricao` text,
  PRIMARY KEY (`setCodigo`),
  UNIQUE KEY `setNome_UNIQUE` (`setNome`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `setor`
--

LOCK TABLES `setor` WRITE;
/*!40000 ALTER TABLE `setor` DISABLE KEYS */;
INSERT INTO `setor` VALUES (1,'Secretaria Academica',NULL),(3,'Assistencia Estudantil','');
/*!40000 ALTER TABLE `setor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `status` (
  `staCodigo` int(11) NOT NULL AUTO_INCREMENT,
  `staNome` varchar(100) NOT NULL,
  PRIMARY KEY (`staCodigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_usuario`
--

DROP TABLE IF EXISTS `tipo_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_usuario` (
  `tipCodigo` int(11) NOT NULL AUTO_INCREMENT,
  `tipNome` varchar(45) NOT NULL,
  PRIMARY KEY (`tipCodigo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_usuario`
--

LOCK TABLES `tipo_usuario` WRITE;
/*!40000 ALTER TABLE `tipo_usuario` DISABLE KEYS */;
INSERT INTO `tipo_usuario` VALUES (1,'ADM'),(2,'Servidor');
/*!40000 ALTER TABLE `tipo_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `usuCodigo` int(11) NOT NULL AUTO_INCREMENT,
  `usoNome` varchar(45) NOT NULL,
  `usuSobrenome` varchar(100) NOT NULL,
  `usuFoto` blob,
  `usuSiape` int(11) NOT NULL,
  `usuCPF` varchar(14) NOT NULL,
  `usuRG` varchar(13) NOT NULL,
  `usuDataNascimento` date NOT NULL,
  `usuEmail` varchar(100) NOT NULL,
  `usuAssinaturaDigital` blob,
  `usuEnderecoEletronico` varchar(50) NOT NULL,
  `usuTelefoneCelular` varchar(14) NOT NULL,
  `usuTelefoneFixo` varchar(14) NOT NULL,
  `usu_tipCodigo` int(11) NOT NULL,
  `usu_carCodigo` int(11) NOT NULL,
  `usu_setCodigo` int(11) NOT NULL,
  `usu_logCodigo` int(11) NOT NULL,
  `usu_areCodigo` int(11) NOT NULL,
  PRIMARY KEY (`usuCodigo`),
  UNIQUE KEY `usuEmail_UNIQUE` (`usuEmail`),
  UNIQUE KEY `usuCPF_UNIQUE` (`usuCPF`),
  UNIQUE KEY `usuSiape_UNIQUE` (`usuSiape`),
  UNIQUE KEY `usuEnderecoEletronico_UNIQUE` (`usuEnderecoEletronico`),
  KEY `fk_usuario_tipo_usuario1_idx` (`usu_tipCodigo`),
  KEY `fk_usuario_cargo1_idx` (`usu_carCodigo`),
  KEY `fk_usuario_setor1_idx` (`usu_setCodigo`),
  KEY `fk_usuario_acesso1_idx` (`usu_logCodigo`),
  KEY `fk_usuario_area1_idx` (`usu_areCodigo`),
  CONSTRAINT `fk_usuario_acesso1` FOREIGN KEY (`usu_logCodigo`) REFERENCES `login` (`logCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_area1` FOREIGN KEY (`usu_areCodigo`) REFERENCES `area` (`areCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_cargo1` FOREIGN KEY (`usu_carCodigo`) REFERENCES `cargo` (`carCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_setor1` FOREIGN KEY (`usu_setCodigo`) REFERENCES `setor` (`setCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_tipo_usuario1` FOREIGN KEY (`usu_tipCodigo`) REFERENCES `tipo_usuario` (`tipCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Daniel ','Antonio',NULL,23648,'143.167.366-80','0000000000','1999-05-23','danielantonio23599@gmai.com',NULL,'danie.antonio.edu.br','(37)99941-2386','(37)99941-2386',1,1,1,28,2),(3,'teste','11',NULL,1,'111.111.111-11','1','1111-11-11','1',NULL,'joao.silva.edu.br1','(11)11111-1111','(11)11111-1111',2,2,1,36,1);
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

-- Dump completed on 2016-12-03 12:27:06
