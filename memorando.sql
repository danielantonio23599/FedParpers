-- MySQL dump 10.16  Distrib 10.1.13-MariaDB, for Win32 (AMD64)
--
-- Host: localhost    Database: memorando
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
  `aneCodigo` int(11) NOT NULL,
  `aneURL` text,
  `aneAnexo` longblob,
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
  PRIMARY KEY (`areCodigo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area`
--

LOCK TABLES `area` WRITE;
/*!40000 ALTER TABLE `area` DISABLE KEYS */;
INSERT INTO `area` VALUES (3,'Computação','');
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
  PRIMARY KEY (`carCodigo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargo`
--

LOCK TABLES `cargo` WRITE;
/*!40000 ALTER TABLE `cargo` DISABLE KEYS */;
INSERT INTO `cargo` VALUES (1,'Professor',''),(2,'Diretor',''),(3,'Pedadogo(a)',''),(4,'tecnico','');
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
  `conEnderecoEletronico` varchar(50) DEFAULT NULL,
  `conTipoUser` varchar(45) NOT NULL,
  `conEmail` varchar(100) NOT NULL,
  `conCelular` varchar(14) NOT NULL,
  `conFoto` blob,
  `con_usuCodigo` int(11) NOT NULL,
  PRIMARY KEY (`conCodigo`),
  KEY `fk_contato_usuario1_idx` (`con_usuCodigo`),
  CONSTRAINT `fk_contato_usuario1` FOREIGN KEY (`con_usuCodigo`) REFERENCES `usuario` (`usuCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contato`
--

LOCK TABLES `contato` WRITE;
/*!40000 ALTER TABLE `contato` DISABLE KEYS */;
INSERT INTO `contato` VALUES (22,'damm','daniel.antonio.edu.br','Usuário Interno','111111','(11)11111-1111','����\0JFIF\0\0\0\0\0\0��\0C\0		\n\r\Z\Z $.\' \",#(7),01444\'9=82<.342��\0C			\r\r2!!22222222222222222222222222222222222222222222222222��\0\0C\0Z\"\0��\0\0\0\0\0\0\0\0\0\0\0	\n��\0�\0\0\0}\0!1AQa\"q2���#B��R��$3br�	\n\Z%&\'()*456789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz���������������������������������������������������������������������������\0\0\0\0\0\0\0\0	\n��\0�\0\0w\0!1AQaq\"2�B����	#3R�br�\n$4�%�\Z&\'()*56789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz��������������������������������������������������������������������������\0\0\0?\0�<,R�Qȸ�يO���6��^_���F��kx��m�e����;��s���T��(	�����zU-Q/rU�1�Ӛ��d�H���#p��FGC��1Z�~�Z&���ppڱ�+=:D���!);���?ϓ��LĖϱ��9[�L������\\)�n4��k�B����Y�ٔW�H֧[�^�J\rm���wރ��s^6,m�u���R���~��ҹ�T�s���-������e�l\n��G�\0��ס�_W��#\\:8`C;d��:�W[�v�\Z�6q3�p����4���L�1�s�ǧ�5�5�i�ǋ�Q{��9�����5�GRrn��@Np\0Q�\\+���	�t�Yy2D����Ey��t��u��Wr`t��*��v��J�J����񦝠��8���=!YO��t�`�3��HRԱ>\\��x�����ic߾�<��8�f�QpAR8����Nk�{9����{_��e����W�9�oqW	t\"K���f9�Q���\0�Y:�\0��Z��W��H�9\' t��\0�+]�3,h��Ь}GN���q�5R�)-$F�d(U%2m\'�]���kRN�!��an�b�D}�\\�^a��}�[��x�̲��@����t�=]WK����q���ڽH�s���N�յ-qn�U���QS���2N:}{\\�;��Nq��]7�ie\'����p�ܜ����S����+;mGPG�iJ��nh�RF��ӷ^��\r-M�ȑ���\"a~pCz���ʨ�2��l�Ӓ6�{�t\\�גzw�P�e$������+D�\ncX��=O���\0?�JdU�+3g�����Z�φ��d�@��ޤ(�89�+���F��^A��G��r�xn9��9��ۭZ}L�I5drL�\0�<����<Ս\"�%�\'=�q��.m�j\Z�6l��}k�u�\n[�\0a����\Za:`W�����1�T��M;���q\Z@�Y��x�UG��=+B�\\�4��W��>N�6�\0 g?�\\��3����%9��aq�A�V���ׅ�y�PHO�<,�`���x��O`=\'O��Z�p���c̈���ںY>5��m�,�R0��q���׈�Z�)pG����i��Ϸ�*ɤ�D��V9覫����:�����ڏ�$	a�GԌ�\'��>��6��Fͳ/����9���8�G�:+?��k�<.�s�oƽP��rJX�T\"������pk7\'sXS����k�o�Ί�r(�18�c���P���r�\\�!�ܪ�)R;�>������.B���o�ԑ�L۷$�¹MO�zŮ��r��,��ޢ�8����u�O�,nܱ���=�^�ojZ��t�-\Z�(\rǦx5��m�2Ok+!B��\rz�uH�kbĬs�,�.HS�����ɪQ��OR��{\n�c\0�*_	E$��F���^���`�*3�[BI�ߙ�c�r>)������:�Q�P���9����J�JJ~B�	-�H��\\&(��H.�����A�7)�;]JkUڄ�H5uu�\'1��%�x�U���`2j���ƫ7����]�Q��v�� ��#�$F�ϧJ�t۽Fkg��\0���\0�n����)��ɞ������岄�z��x\nW��+7\rt5�����	�VVd,d-��$�-�jws�I5;�6H�߼l�@�?����\\��/t׳���J����?ƹ;Mb����HX ڊ�Q���j!9��]�k��;Em�g\0��M��P���p����F�\'�W���*�͎?�}+�7q��u9|\"��A$�1���#�1m�};iuр�2;U���O�	h�!#r�5{�w��i&K��><�,4�]�Y[�����bB�Vf�{����1�v����j�,c��\r]����{$�%u��4`{�q�E#{/���m��v+[A!\'�h���ԓY��*\\0Q�(�:�Ї��6ι���QB:v���~��j��!��6��a��OZ(�����ڡ0�Rx�����$�)�g��',1),(23,'dani','dani','Usuário Interno','11','(11)11111-1111','����\0JFIF\0\0\0\0\0\0��\0C\0		\n\r\Z\Z $.\' \",#(7),01444\'9=82<.342��\0C			\r\r2!!22222222222222222222222222222222222222222222222222��\0\0Y\0Y\"\0��\0\0\0\0\0\0\0\0\0\0\0	\n��\0�\0\0\0}\0!1AQa\"q2���#B��R��$3br�	\n\Z%&\'()*456789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz���������������������������������������������������������������������������\0\0\0\0\0\0\0\0	\n��\0�\0\0w\0!1AQaq\"2�B����	#3R�br�\n$4�%�\Z&\'()*56789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz��������������������������������������������������������������������������\0\0\0?\0��w1\0��Y2m��*z�q���ˋ��8�{�c�©˭�F�8�L��t���+z�����/yI����<aq�\n��Oŗ�7j4�#����	@���޺mZ]W�x��K(�����q���\\f�in�ۈ�\"^Olw�rJ������:]/��t��G�߅V��A�q��[km��.�|�Ldc�S��O��=��͍���ڒ�+B�!Q���d��+~�ǚ��KU��g �$��?J���W;{m\n��\Z{����f`G�����.��T/r� �\n�I�d���ו�jw��4ҷS9�9�t�T���	hm�F4����\r�\'�⒂�K�c���M��\\���-�C,bQ�e�T�\0����@?L���Y�iX�#�\\o>�)��ҭ_k7ެ�1G�+�R-D���r�ĶH\\��LӴ���n����KoldE㜷��+K%�7l��\0�B��Q��|����v������}�}r?mM����\'g�i�@�AD���Ө��msKse��1�\\�[ۗe�3p?»���\Z�l���}�%L��*A9#ۧ���/0V�W����d��¨>��sQ�jRI��֢HK���� �Ldt?���%}L���P��|B�L�d���G;fm�m&(�T�wC��@�����z�ݵ�:��)��퍠q����]������7p^[\\�ċYn܀r\n�A<��ij-bc�x�_��h�9t�T#�~`m�2[8�I�`N�\"ѼfX��T�,A����J��{we�*]��ف�Uy�릇M�类�N�D�;h�Ey(O)�&8���=gO���v��R�|�\"ۡ��	�q��^+&�#0[�I�N�`�}���R,9I��6�s\Z�?����޵�]J�ʊ-2�j���u ��>�c��k�\0�-����_O��~M.����}��*n;�O���U�aC)<u!�?�kZx���5���E���	��G]�@?���x|�N�����_X�!�S���3RI�Q�\\���Nӄ�.+8��v�߹��cs�����0M��$M���0��<�נ�޼���!��<qx׷�ɶ���5®$L@�1�$צ�V3��;3G,h6�k6nggG�\0��~S�H\'�^�g�e����or��[g1�� �c�$�;�K{�\r���pK��\Z���}�������D�.%H�*�.��9�O�r��-[!=�:�+_����}\Z�A�!�\r	;w�\r��ጜ���T�֭m��-g���ɎWFC,N�1�`��ך�o�����նI��F���{�.�47EI$`8��eQ�`����3�*pqv;\r}2����hږ���\n��Y��^2v���$�j��=Ͷ��4�;MY�]�d��;�a�7�٩��?L����m����u�PY\\�n���k\n9��D�w�y�VD�l��E\'������,^꺭݋-�{&\'1�-�WH<�ҿ\\T1�Y,�k�̨Q��8��i�m9���1��h.WH���R�\\H�[�����T��A$���N	�Ma�	�<��\",���2�$c����V�im��2*9IX�\'��?%�=H��\Z�vlfԑ#�;�S�Pn��9�X��?9YB�H��??͸�}1��O�,ƘchM�SL�˲���9<{q�1I-@��i{%���G�#��EX�<��!��p����{������Ɯ�aw����R��Fs�W�d�TZ�����[�N�k/�0zr��\r�G���=����7�lN~T9�N����cZ��(�1�)r��\"�^2�\ns�;w�FKwoJ����a��������ٝ�gi\Z��Aq (�L�1���c8$=�F6�m����6�p��\\�B�Y[�89�\"�K�,��	\0`�ϱ����S��o,�XpO�W�\\�/۵G�;�M�s_�x�G�������]$6�\n�;���o<`Q�C����馺�ż���\Z��[98�TqY�!��I�Ҭ��b��<�A!�����^��S-����^�ܳm�v��h�u����q��9�In>��Ķx�)��IĤ���;g����I��L��H-��\r��Nߘm��Ǡ<��d]|໒%���M�Ӎ�x�R}G���c�\Z���K��F�O�C$&s#q\\�A#���ƵMS�P�͹Fk�һE�L��Nn��$��{��Y��&��*�g�w_�0l�ψu�%-��xFz��赝�j�S#,�3\\�%����{3M�O��h:͕��t��4Q�K@��K��c=O�׬����U�r�ܛUЇR�����ڦi�3���o$E&�e^��G�;V���Uk�c��m+ē���_����G��\r>33̛|�[��s���?�Z�hA4�\Zt��gR������)�sQ��G��i�=�ʹr�<��̿;g�O�*���e����{H����g@s�`8<t���F矤�ο��\\Hs�,,y��Ll�\\pz/��׉l�x��\0c8����~(՗0�Z��R$�B��p���W@��\0,�_o���B#�\n�Hݞ:~?Jh�0��~�;Vs��QV&��/��3��\0���\'!�̾��W�O�F3�\\~��BX1���*\n(�Z�3\0�?����YW����X<�1F���}�U������\01�5-��I��m�W���\r*V��T��w���\0���t_�S�\0�	�O�\Z�\n�n�ب�0��2P�~��)���@�5����Z�G+I��a˳q�zJ��ރ��\0�V���2��sP��ȃ�2���Ӓk2���\".��c�0\0�<�Sj��e�\0\\�\0F5Gi�\0��ҺӴ.d����<�\Z4l�B�\'\0p<�0)E�n�Bg���\0֏���}Mp:�4�b���q��Q�uW�3���4����������m�p����j�O\'�z��|����\0�Ԛ����\0���\0�u�E��4��C��',1),(24,'111',NULL,'Usuário Externo','da','(11)11111-1111',NULL,1);
/*!40000 ALTER TABLE `contato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `destex_doc`
--

DROP TABLE IF EXISTS `destex_doc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `destex_doc` (
  `ded_docCodigo` int(11) NOT NULL,
  `ded_deeCodigo` int(11) NOT NULL,
  PRIMARY KEY (`ded_docCodigo`,`ded_deeCodigo`),
  KEY `fk_documento_has_destinatarioExterno_destinatarioExterno1_idx` (`ded_deeCodigo`),
  KEY `fk_documento_has_destinatarioExterno_documento1_idx` (`ded_docCodigo`),
  CONSTRAINT `fk_documento_has_destinatarioExterno_destinatarioExterno1` FOREIGN KEY (`ded_deeCodigo`) REFERENCES `destinatarioexterno` (`deeCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_documento_has_destinatarioExterno_documento1` FOREIGN KEY (`ded_docCodigo`) REFERENCES `documento` (`docCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `destex_doc`
--

LOCK TABLES `destex_doc` WRITE;
/*!40000 ALTER TABLE `destex_doc` DISABLE KEYS */;
/*!40000 ALTER TABLE `destex_doc` ENABLE KEYS */;
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
  `deeCelular` varchar(14) NOT NULL,
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
  `dei_docCodigo` int(11) NOT NULL,
  `dei_usuCodigo` int(11) NOT NULL,
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
INSERT INTO `destinatariointerno` VALUES (28,1),(29,1),(30,1),(31,2),(32,2);
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
  `docDataRecebido` datetime DEFAULT NULL,
  `docDataLido` datetime DEFAULT NULL,
  `doc_usuCodigo` int(11) NOT NULL,
  `doc_staCodigo` int(11) NOT NULL,
  PRIMARY KEY (`docCodigo`),
  KEY `fk_documento_usuario1_idx` (`doc_usuCodigo`),
  KEY `fk_documento_status1_idx` (`doc_staCodigo`),
  CONSTRAINT `fk_documento_status1` FOREIGN KEY (`doc_staCodigo`) REFERENCES `status` (`staCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_documento_usuario1` FOREIGN KEY (`doc_usuCodigo`) REFERENCES `usuario` (`usuCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `documento`
--

LOCK TABLES `documento` WRITE;
/*!40000 ALTER TABLE `documento` DISABLE KEYS */;
INSERT INTO `documento` VALUES (28,'2017-09-09 17:28:03','teste','joao.silva.edu.br','teste','2017-09-09 17:28:47','2017-09-09 17:36:28',2,3),(29,'2017-09-09 17:28:14','teste','joao.silva.edu.br','teste','2017-09-09 17:28:47','2017-09-09 17:28:59',2,3),(30,'2017-09-09 17:39:57','teste','daniel.antonio.edu.br','teste','2017-09-09 17:40:05','2017-09-09 17:40:15',1,3),(31,'2017-09-09 17:45:05','teste','daniel.antonio.edu.br','teste','2017-09-09 17:45:36','2017-09-09 17:45:53',1,3),(32,'2017-09-14 10:18:18','Preenchimento correto de Memorandos','daniel.antonio.edu.br','Senhor Fulano de tal,\n\n		O memorando é a modalidade de comunicação entre unidades administrativas de um mesmo órgão. Trata-se, portanto, de uma forma de comunicação eminentemente interna.\n\n		A estrutura de um memorando deve respeitar uma série de características descritas neste manual.\n\n		Devo mencionar, por fim, que a atenção a essas regras é de fundamental importância para o uso correto das comunicações oficiais.\n\n\nAtenciosamente,\n\n\nNome do Remetente\nCargo que ocupa (Só as iniciais maiúsculas, sem negrito)',NULL,NULL,1,1);
/*!40000 ALTER TABLE `documento` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'daniel','aa47f8215c6f30a0dcdb2a36a9f4168e'),(2,'111','698d51a19d8a121ce581499d7b701668'),(3,'dani','55b7e8b895d047537e672250dd781555'),(4,'dan','9180b4da3f0c7e80975fad685f7f134e'),(5,'dam','76ca1ef9eac7ebceeb9267daffd7fe48');
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
  PRIMARY KEY (`setCodigo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `setor`
--

LOCK TABLES `setor` WRITE;
/*!40000 ALTER TABLE `setor` DISABLE KEYS */;
INSERT INTO `setor` VALUES (1,'Assistência Estudantil',''),(2,'Engenharia',''),(3,'Computação',''),(4,'ADM',''),(5,'Secretaria Acadêmica','');
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES (1,'ENVIADO'),(2,'ARQUIVADO'),(3,'LIDO'),(4,'CRIADO');
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
  `usuNome` varchar(45) NOT NULL,
  `usuSobrenome` varchar(100) NOT NULL,
  `usuFoto` blob,
  `usuSiape` int(11) NOT NULL,
  `usuCPF` varchar(14) NOT NULL,
  `usuRG` varchar(13) NOT NULL,
  `usuDataNascimento` date NOT NULL,
  `usuEmail` varchar(100) NOT NULL,
  `usuEnderecoEletronico` varchar(50) NOT NULL,
  `usuTelefoneCelular` varchar(14) NOT NULL,
  `usuTelefoneFixo` varchar(14) NOT NULL,
  `usu_logCodigo` int(11) NOT NULL,
  `usu_areCodigo` int(11) NOT NULL,
  `usu_carCodigo` int(11) NOT NULL,
  `usu_setCodigo` int(11) NOT NULL,
  `usu_tipCodigo` int(11) NOT NULL,
  PRIMARY KEY (`usuCodigo`),
  KEY `fk_usuario_login1_idx` (`usu_logCodigo`),
  KEY `fk_usuario_area1_idx` (`usu_areCodigo`),
  KEY `fk_usuario_cargo1_idx` (`usu_carCodigo`),
  KEY `fk_usuario_setor1_idx` (`usu_setCodigo`),
  KEY `fk_usuario_tipo_usuario1_idx` (`usu_tipCodigo`),
  CONSTRAINT `fk_usuario_area1` FOREIGN KEY (`usu_areCodigo`) REFERENCES `area` (`areCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_cargo1` FOREIGN KEY (`usu_carCodigo`) REFERENCES `cargo` (`carCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_login1` FOREIGN KEY (`usu_logCodigo`) REFERENCES `login` (`logCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_setor1` FOREIGN KEY (`usu_setCodigo`) REFERENCES `setor` (`setCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_tipo_usuario1` FOREIGN KEY (`usu_tipCodigo`) REFERENCES `tipo_usuario` (`tipCodigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Daniel','Antonio','����\0JFIF\0\0\0\0\0\0��\0C\0		\n\r\Z\Z $.\' \",#(7),01444\'9=82<.342��\0C			\r\r2!!22222222222222222222222222222222222222222222222222��\0\0Y\0Z\"\0��\0\0\0\0\0\0\0\0\0\0\0	\n��\0�\0\0\0}\0!1AQa\"q2���#B��R��$3br�	\n\Z%&\'()*456789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz���������������������������������������������������������������������������\0\0\0\0\0\0\0\0	\n��\0�\0\0w\0!1AQaq\"2�B����	#3R�br�\n$4�%�\Z&\'()*56789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz��������������������������������������������������������������������������\0\0\0?\0��\n�r��4�W�}�Zz2ȂH���֞g$���*��m�l0o��a���	�sמ�$��@8 {Tk�c[�«��]2)4h�0�l�\'�������#����}��z�wS�Ud�sZFSO]��֛��CQk����X��\0�j�]�A�#5����f�k��\Zi�ں{�m<C�`7@qI���T$��^�Z���f;V�T�F�>��</&nP�S[v�1팁��Z�����McE-�0���l����cl��9�v�H�Z����o�)J�����Ӂ�kN��Z4�lV�c\'~��?7Py鞣���-��?��V�h��G�}�[?.G��>��{i[s��/��w�\r���yf66�6ўx�\'<sۡ��n%f���-PZ��v?@Fzq�ҳ�\'��V��/=�C�O���)<rp6�=;d\n��>euޮW�\0���͵v����⮫n6B��:?�J����9��Z�|1��w	k��!��1�1\0��I�\0��^��>b�!�ܱ�\\z�8��Ƭ����e�3�y9�\0�y��ZF��\"tb��q��2ȡ@� ���~����)v�r�W��o\'9c�z�]x�L��\\��OO)����n��0T���v��<ci�U\ZY�ۻ*:Y�x�K�c��\0���Z1^[^��1# ��j���R�\"fs�\0}i�0?x?:���n�}�y1y�\0���U�П{����v�Z�m`�1\\\r��$Ae\'v����>�f�ĖZ<O8��&�v\0�͵ܷ��\n���5�Z�żۅ��#ڌ�����\0g�w�5n;K���\\YEyh�)U�*����\\6���5��4�;�t6�F��-�a��BͽB���{1$��Q��3�ῲm.�c	FA�aVܚm��X\\[�������X(?t�6q���-|\'�[�pL�L��#2`3��+%di��\Z�Hp��������gӮ\"�p-d99r@�{q����ĺv��j�,M��\0�~oQ�R?^������hS�s\Z�h�tLko�Ӵ�E\n�Z�����~[�8Q�ev�Ք��z����RE��qis%��y���������\0~U%��4�#F��_�~dq���ņ.�p>v8 ��O8_ڱ�\0iZ�:��ڭd�\0UB�����rO\0g�x�[���v:K=Fs5���j(,`GS�~8�\rE�T��6���\n4y��h\\�v�`}j���	��V�!��HF�PH�_������r�@�\\]߫嘮�td���2r3�=(I�����{��<�u��e~���~R�Y]_Q*��܏��5��������on�PH�98��\'�^M\r�xuݘ��hI��\\��⩩h�m�A$Q\\O5�SK$�T���pyʜ�7��#oN�,^���-2[˲���4����������y�����r$�L�_�R7U3��6R��90ɕ��T�I���\Z���W���hݧ�ibUw!>bv䁒A��Nc�\0��%�m�HLЯL����:��5mj�$�*�%�1�n8\03���q�5�h�p�4O�Y�!�e3!��0A������ڛ�zޟ�o�F�V9���_c�*���[�uohrI+�#p\n軻��9�⹈��֒�I����[ZPHU�99�\0�d�\\εյ3���X�FQ��S��Ӄ�9�n�I�ht:�Ν���c�YY\\yr��y9%�P^�z��a�i�JrKG+8N������MÑ�\\�ʹ�R	����8�y�?�Z�`�U��պ�9�f޲b��h�c���4��8eV9��{�X���uxX3a�� �8���U+K5���&�$ڬ��89?�v��I$Oso/a����sӯ=9�L�;\\Դ��쎍<V��*�RVOQǧ\\�}�>�N�ɨ��I�y\nk\n#\"9�2�f խ�yޜ�\0�N�FYr��=OlTlX�C���}{��*`����N#$T�o�k��/�~�6v0��\0C���ec���]�˷#{������,j�\0)�ݜ~�o�}1�q��[�a��A$���4���3�y���5�6�ب�ǻ�Z�xkBv����]�p�wcӧ,x\0H\0���\Z����͖�e*O��$��	�b��3�䞣�W���]חwS̀,k#9\'�x��_NH���]��AA�0z�z��+:t9_3wb�K�\"�K��FJ��OQ����\0�s��ý�#u�n���ӥQw��``c#9�\09��!��fb�s��<d~��T��%̈�G�\"�a#��?tx?�(���ɎNY�r���5j������?1N��g�j��D�RF�6 �O\0}x�9�ְ�M	%�A\"g]�z��#����NV$^�{�\0�j&�RTv\nFYA\' g�g�\0�Q}��q��y�c���������j��2��J��t#\'󪃧�V��������,`��0q׊�\\6�\0)�N?���{��N�>��,�X ��wp�9��\0J�˾5#�TS�$�zrz{�dv����������)��\\H��6Wv�	����LbB�m�#��C�W=u���]�?�7�w�\0�k:���E��m�.�n8��p{��*B��#0��8���\\�q�\'�q�z՗�=_�?��X�\0���\0�wI=�g�i);9lG!�IFr{����5\Zxm�/�c��ԟ�V������r��<��\0�k���l�;���',23648,'143.167.366-80','MG-21.041.921','1999-05-23','danielantonio23599@gmail.com','daniel.antonio.edu.br','(37)99156-0541','(37)99941-2386',1,3,4,3,1),(2,'1','1',NULL,1,'111.111.111-11','111','1111-11-11','111','joao.silva.edu.br','(11)11111-1111','(11)11111-1111',2,3,1,1,2),(3,'dani','dani','����\0JFIF\0\0\0\0\0\0��\0C\0		\n\r\Z\Z $.\' \",#(7),01444\'9=82<.342��\0C			\r\r2!!22222222222222222222222222222222222222222222222222��\0\0Y\0Y\"\0��\0\0\0\0\0\0\0\0\0\0\0	\n��\0�\0\0\0}\0!1AQa\"q2���#B��R��$3br�	\n\Z%&\'()*456789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz���������������������������������������������������������������������������\0\0\0\0\0\0\0\0	\n��\0�\0\0w\0!1AQaq\"2�B����	#3R�br�\n$4�%�\Z&\'()*56789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz��������������������������������������������������������������������������\0\0\0?\0��w1\0��Y2m��*z�q���ˋ��8�{�c�©˭�F�8�L��t���+z�����/yI����<aq�\n��Oŗ�7j4�#����	@���޺mZ]W�x��K(�����q���\\f�in�ۈ�\"^Olw�rJ������:]/��t��G�߅V��A�q��[km��.�|�Ldc�S��O��=��͍���ڒ�+B�!Q���d��+~�ǚ��KU��g �$��?J���W;{m\n��\Z{����f`G�����.��T/r� �\n�I�d���ו�jw��4ҷS9�9�t�T���	hm�F4����\r�\'�⒂�K�c���M��\\���-�C,bQ�e�T�\0����@?L���Y�iX�#�\\o>�)��ҭ_k7ެ�1G�+�R-D���r�ĶH\\��LӴ���n����KoldE㜷��+K%�7l��\0�B��Q��|����v������}�}r?mM����\'g�i�@�AD���Ө��msKse��1�\\�[ۗe�3p?»���\Z�l���}�%L��*A9#ۧ���/0V�W����d��¨>��sQ�jRI��֢HK���� �Ldt?���%}L���P��|B�L�d���G;fm�m&(�T�wC��@�����z�ݵ�:��)��퍠q����]������7p^[\\�ċYn܀r\n�A<��ij-bc�x�_��h�9t�T#�~`m�2[8�I�`N�\"ѼfX��T�,A����J��{we�*]��ف�Uy�릇M�类�N�D�;h�Ey(O)�&8���=gO���v��R�|�\"ۡ��	�q��^+&�#0[�I�N�`�}���R,9I��6�s\Z�?����޵�]J�ʊ-2�j���u ��>�c��k�\0�-����_O��~M.����}��*n;�O���U�aC)<u!�?�kZx���5���E���	��G]�@?���x|�N�����_X�!�S���3RI�Q�\\���Nӄ�.+8��v�߹��cs�����0M��$M���0��<�נ�޼���!��<qx׷�ɶ���5®$L@�1�$צ�V3��;3G,h6�k6nggG�\0��~S�H\'�^�g�e����or��[g1�� �c�$�;�K{�\r���pK��\Z���}�������D�.%H�*�.��9�O�r��-[!=�:�+_����}\Z�A�!�\r	;w�\r��ጜ���T�֭m��-g���ɎWFC,N�1�`��ך�o�����նI��F���{�.�47EI$`8��eQ�`����3�*pqv;\r}2����hږ���\n��Y��^2v���$�j��=Ͷ��4�;MY�]�d��;�a�7�٩��?L����m����u�PY\\�n���k\n9��D�w�y�VD�l��E\'������,^꺭݋-�{&\'1�-�WH<�ҿ\\T1�Y,�k�̨Q��8��i�m9���1��h.WH���R�\\H�[�����T��A$���N	�Ma�	�<��\",���2�$c����V�im��2*9IX�\'��?%�=H��\Z�vlfԑ#�;�S�Pn��9�X��?9YB�H��??͸�}1��O�,ƘchM�SL�˲���9<{q�1I-@��i{%���G�#��EX�<��!��p����{������Ɯ�aw����R��Fs�W�d�TZ�����[�N�k/�0zr��\r�G���=����7�lN~T9�N����cZ��(�1�)r��\"�^2�\ns�;w�FKwoJ����a��������ٝ�gi\Z��Aq (�L�1���c8$=�F6�m����6�p��\\�B�Y[�89�\"�K�,��	\0`�ϱ����S��o,�XpO�W�\\�/۵G�;�M�s_�x�G�������]$6�\n�;���o<`Q�C����馺�ż���\Z��[98�TqY�!��I�Ҭ��b��<�A!�����^��S-����^�ܳm�v��h�u����q��9�In>��Ķx�)��IĤ���;g����I��L��H-��\r��Nߘm��Ǡ<��d]|໒%���M�Ӎ�x�R}G���c�\Z���K��F�O�C$&s#q\\�A#���ƵMS�P�͹Fk�һE�L��Nn��$��{��Y��&��*�g�w_�0l�ψu�%-��xFz��赝�j�S#,�3\\�%����{3M�O��h:͕��t��4Q�K@��K��c=O�׬����U�r�ܛUЇR�����ڦi�3���o$E&�e^��G�;V���Uk�c��m+ē���_����G��\r>33̛|�[��s���?�Z�hA4�\Zt��gR������)�sQ��G��i�=�ʹr�<��̿;g�O�*���e����{H����g@s�`8<t���F矤�ο��\\Hs�,,y��Ll�\\pz/��׉l�x��\0c8����~(՗0�Z��R$�B��p���W@��\0,�_o���B#�\n�Hݞ:~?Jh�0��~�;Vs��QV&��/��3��\0���\'!�̾��W�O�F3�\\~��BX1���*\n(�Z�3\0�?����YW����X<�1F���}�U������\01�5-��I��m�W���\r*V��T��w���\0���t_�S�\0�	�O�\Z�\n�n�ب�0��2P�~��)���@�5����Z�G+I��a˳q�zJ��ރ��\0�V���2��sP��ȃ�2���Ӓk2���\".��c�0\0�<�Sj��e�\0\\�\0F5Gi�\0��ҺӴ.d����<�\Z4l�B�\'\0p<�0)E�n�Bg���\0֏���}Mp:�4�b���q��Q�uW�3���4����������m�p����j�O\'�z��|����\0�Ԛ����\0���\0�u�E��4��C��',111112,'222.222.222-22','11112','1111-11-11','dani','dani','(22)22222-2222','(22)22222-2222',5,3,1,1,1);
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

-- Dump completed on 2017-09-19  7:47:56
