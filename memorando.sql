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
INSERT INTO `area` VALUES (3,'ComputaÃ§Ã£o','');
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
INSERT INTO `contato` VALUES (22,'damm','daniel.antonio.edu.br','UsuÃ¡rio Interno','111111','(11)11111-1111','ÿØÿà\0JFIF\0\0\0\0\0\0ÿÛ\0C\0		\n\r\Z\Z $.\' \",#(7),01444\'9=82<.342ÿÛ\0C			\r\r2!!22222222222222222222222222222222222222222222222222ÿÀ\0\0C\0Z\"\0ÿÄ\0\0\0\0\0\0\0\0\0\0\0	\nÿÄ\0µ\0\0\0}\0!1AQa\"q2‘¡#B±ÁRÑğ$3br‚	\n\Z%&\'()*456789:CDEFGHIJSTUVWXYZcdefghijstuvwxyzƒ„…†‡ˆ‰Š’“”•–—˜™š¢£¤¥¦§¨©ª²³´µ¶·¸¹ºÂÃÄÅÆÇÈÉÊÒÓÔÕÖ×ØÙÚáâãäåæçèéêñòóôõö÷øùúÿÄ\0\0\0\0\0\0\0\0	\nÿÄ\0µ\0\0w\0!1AQaq\"2B‘¡±Á	#3RğbrÑ\n$4á%ñ\Z&\'()*56789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz‚ƒ„…†‡ˆ‰Š’“”•–—˜™š¢£¤¥¦§¨©ª²³´µ¶·¸¹ºÂÃÄÅÆÇÈÉÊÒÓÔÕÖ×ØÙÚâãäåæçèéêòóôõö÷øùúÿÚ\0\0\0?\0î<,RèQÈ¸ÂŒšÙŠO´‡6ûé^_ğïûFêŞkx˜¼mÃe¶ª÷Î;ÜsÈíšõT·’(	…ÀÇóşzU-Q/rU„1ÓšÊÕd·H…¾á#pñ¯ÌFGCœ1Z~ñZ&ÈÈÚppÚ±µ+=:D‰îÖ!);‡œà±?Ï“ëïLÄ–Ï±·’9[¤L€ä÷û­\\)×n4ûkªB±œŸ™Y“Ù”Wñ¯HÖ§[Ø^ÛJ\rmÃÜôwŞƒõús^6,mîu¦¶¶R›±’~µ„Ò¹¬T­s·¿ñ-…†‡¾Éíe¿l\n»ÙG¯\0óéŸ×¡â_W×Ç#\\:8`C;d“:äW[‰v¯\Z¡6q3Çp»ª¯ˆ4’âÂL³1ùs“Ç§İ5š5åiíÇ‹¼Q{öõ9…ñÚÃÔ5½GRrn®@Np\0QŸ\\+Òô­	®tÛYy2D¯¸ŒğEy÷ŠtÕÒu¹íWr`tÈÎ*âÓv±ƒJæJ¡—Ãñ¦ ãå8úÕÍ=!YOÚ„tã`ï3ŸçHRÔ±>\\ÃÛxãôª¾¤icß¾Ê<éĞ8àf½QpAR8¯™´ÍNkÒ{9ÙÊÊ{_ƒ¼e½·¸ÄWŠ9ôoqW	t\"K©Õùf9ÇQß×ÿ\0¯Y:ÿ\0‡×Z¾‚Wœ¤H¤9\' tôÿ\0ë+]åˆ3,hÒÍĞ¬}GN§ ëœqÓ5Rí)-$F‚d(U%2m\'¹]«Ÿ¦kRNá!·šan»bÜD}ş\\ñ^a¡Ú}—[ÔãxËÌ²¸‰@€ê§òÅt¾=]WK¾†ÕÕq”˜ Ú½HäsÓõ®N¸Õµ-qnéU“—™QSÙÆ2N:}{\\­;»NqÒÇ]7Úie\'˜òğçpûÜœöû¿S¸´õ+;mGPGµiJÊÀnhÈRFæé“Ó·^†º\r-MõÈ‘âÁ‡\"a~pCzŸÊ¨ê2¦ƒl‡Ó’6“{«t\\‘×’zwëPe$ÕÎöÊÒÖ+D·\ncX‚®=OÓâÿ\0?øJdUÂ+3gô®ŞşóZğÏ†¢ÙdÒ@ÌŞ¤(Î89ô+—°ğF³¯^A¨ŞGˆ§rÓxn9ÎÒ9§áÛ­Z}LªI5drLÿ\0‰<š‡˜ª<Õ\"Á%—\'=îqš‘.m„j\ZÂ6l±î}kÖu¿\n[ÿ\0aıÚ‰\Za:`W“µ“£”1TàóM;˜½¿q\Z@æYŒ¬xØUGñ¸=+BË\\Ô4“ÜWÍå±>Né6’\0 g?á\\òŞ3ºù¥š%9òÃaqèAùV¥œö×…’yîPHOú<,à`“ÀxöëO`=\'Oøï©Z¤pŞé¶î€cÌˆ‘‘íÚºY>5èÏmÂ,ÆR0öåqƒëü×ˆÜZË)pGÚùãiÉíÏ·è*É¤İD †V9è¦«®¢ä:ïøªãÅÚ™$	aå¢GÔŒ’\'©ç¶>”ı6æÓFÍ³/îùêÛ9äçÆ8ôGÁ:+?ˆàkå<.îsoÆ½PğÔrJXÜT\"ƒÓæ§ ıpk7\'sXSº¹ËÛk×oşÎŠŞr(Ÿ18ÏcÔöïPÏ¨êrª\\İ!’ÜªÄ)R;à>µÕÛøÎé.BÉäÜoıÔ‘·LÛ·$Â¹MOÂzÅ®¤Ér±Œ,«ßŞ¢Å8ØÓÓíuËO¥,nÜ±Œœ¶=ó^ÇojZÊ’t¹-\Z“(\rÇ¦x5á–úmî‘2Ok+!Bçƒõ\rzïƒuHõkbÄ¬s±,ğ.HSÙç™éÉªQĞÎORİí´{\nœc\0®*_	E$®áF‰û‹^ÅÄ`È*3á[BIÜß™­cˆr>)’ßËÀÜœ:éQ¶P‘Œã¯9«ïÚJ÷JJ~B¬	-HÇÕ\\&(ÕÕH.Üşğç ÏAş7)¢;]JkUÚ„ÎH5uu·\'1øæ™%¹xØU¨Ï`2jœ–òÆ«7—±Şş]»Q£´vŞÖ ’ê#$FÉÏ§Jï®tÛ½Fkg†é¢\0œ²õ\0‚nµáÖÙ)ˆ²É‹ßéşÜèŸå²„Åz»„x\nW©ü+7\rt5„ÖÌï¯ô‰´	ÆVVd,d-Ÿ©$×-¤jws›I5;‰6HÌß¼lá@Ï? úšƒ\\ø¢/t×³²³•J³ÍÎë€?Æ¹;Mbæòö´HX ÚŠåQìşªj!9®‡]¬k‘Í;EmÂg\0ú×MğÛPÛÄpù„ŠÊFÙ\'úWœŞÅ*ÌÍ?¼}+Â7qØêu9|\"’»A$’1ü‰­#¢1m¶};iuÑ€¬2;UªñÛOÆ	hÃ!#rã5{şwÄÕi&K¹â><Ò,4¯]ÚY[ˆ …¡ bBîVfê{šÁµ1œv¢ŠÉîj¶,cø\r]µ³·{$–%u’æ4`{©q‘E#{/­â±Õm’Ùv+[A!\'æh•‰çÔ“Yš‚*\\0QŠ(­:‘Ğ‡±«6Î¹õş´QB:vá‹Ğ~¿j÷°!Œí6ÈäaÉÎOZ(¡¦¶°Ú¡0©RxûÄ÷÷¤$æŠ) gÿÙ',1),(23,'dani','dani','UsuÃ¡rio Interno','11','(11)11111-1111','ÿØÿà\0JFIF\0\0\0\0\0\0ÿÛ\0C\0		\n\r\Z\Z $.\' \",#(7),01444\'9=82<.342ÿÛ\0C			\r\r2!!22222222222222222222222222222222222222222222222222ÿÀ\0\0Y\0Y\"\0ÿÄ\0\0\0\0\0\0\0\0\0\0\0	\nÿÄ\0µ\0\0\0}\0!1AQa\"q2‘¡#B±ÁRÑğ$3br‚	\n\Z%&\'()*456789:CDEFGHIJSTUVWXYZcdefghijstuvwxyzƒ„…†‡ˆ‰Š’“”•–—˜™š¢£¤¥¦§¨©ª²³´µ¶·¸¹ºÂÃÄÅÆÇÈÉÊÒÓÔÕÖ×ØÙÚáâãäåæçèéêñòóôõö÷øùúÿÄ\0\0\0\0\0\0\0\0	\nÿÄ\0µ\0\0w\0!1AQaq\"2B‘¡±Á	#3RğbrÑ\n$4á%ñ\Z&\'()*56789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz‚ƒ„…†‡ˆ‰Š’“”•–—˜™š¢£¤¥¦§¨©ª²³´µ¶·¸¹ºÂÃÄÅÆÇÈÉÊÒÓÔÕÖ×ØÙÚâãäåæçèéêòóôõö÷øùúÿÚ\0\0\0?\0´Êw1\0¤ÔY2mòÓ*z³qüéË‹÷Ó8ã{œcúÂ©Ë­ÛFæ8ƒLı¶tÏ×ü+z˜¶ş·/yI™§“åŒ<aqê\nóıOÅ—×7j4 #³„ƒµ	@ŞÙãŞºmZ]WìxºŠK(äû¡¡qÙë\\f§in‘Ûˆ™\"^OlwÍrJ£“÷”´:]/ÆÍtÑÚGÚß…VÉÁAóqôï[kmªê.Ş|¾LdcËSÇäO©¯=ğıÍ†²·Ú’Í+BÂ!QŒôËdİ+~ëÇšƒ–KU‚Øg ó$¼?J†›ØW;{m\nÆÉ\Z{©¢¯Ìf`Gòüé­âİ.–ÚT/rÌ \n‚IàdäñŒ×•Şjwó¤÷4Ò·S9Ï9ètúTÖ÷×	hmÚF4ªÒÄì\r\'óâ’‚êK—c½×üM­Ø\\­† -ôC,bQe•T’\0ÈÈàğ@?LŠáî¯®î¢YîiXä#Ü\\o>œ)çÛÒ­_k7Ş¬¶1G§+ÛR-D®·rÌÄ¶H\\œóLÓ´‹Ùínî¡²º’İ·KoldEãœ·ğ€+K%±7lôÿ\0‡BïÂQ¦à|‰¤ˆávÎìãÕÔ}™}r?mM·†î’\'g»i@åADá±ĞñÓ¨®ÛmsKse±ä1é“\\æ[Û—eœ3p?Â»¿éş\ZÒl¡¿»}ô¾%Lşï*A9#Û§×Äç/0V–W¸÷²ÊdÜóÂ¨>œûsQŞjRI«ÊÖ¢HK€ëÊô ¯Ldt?ˆ®˜%}LÛĞúP»Ò|BçLd»´»G;fmím&(İTãwC‘@ÈÏÎÖÖz¥İµó:‚¶)›€í q½å]•¯¨Ïö7p^[\\ÜÄ‹YnÜ€r\nåA<ü‡ij-bc£x«_±•hÛ9tÚT#ù~`m¤2[8å«I¥`NÇ\"Ñ¼fX°T ,AÓ‘Ÿ¯JŸÊ{we”*] °ÙêUyüë¦‡MÒç±»›N¹D;hËEy(O)È&8áãå=gOŒñöv‘¼R˜|Ò\"Û¡éÀ	–qú·^+&ì#0[´IûNÌ`Î}»‘ïR,9I¼¬6Şs\Zğ?¼ÜúñŞµì´]JïÊŠ-2ãj“†u óæ¿>œc§½kÿ\0Â-¼Åõ_O´Š~M.é¨‚‚}ùÆ*n;›O™£‘U·aC)<u!¸?…kZx–âĞ5¥ïúEªÂ	æ“ÊG]¨@?ˆíŠ×x|¥NŠóßêş_Xã!£SëÆĞ3RIãQ§\\ƒ¢øNÓ„œ.+8í÷vß¹¢ácsá…åÄÑê0M•$Mäƒ‚0îƒæ<œ× ãŞ¼ÏÀŞ!¿×<qx×·±É¶ÉÀ†5Â®$L@Á1ç$×¦äV3ÜÒ;3G,h6·k6nggG\0ìÚ~SÃH\'¨^œg­eİÊÓÃor‘â[g1»ï å”cê$æº;›K{\rÒÆ÷pKÀí\ZÇ•Á}§ õÈØŞD—.%H±*ì.àá9ÆOğr¹ë¡-[!=“:Í+_¬¾É}\Z¼A‹!É\r	;wÈ\r½áŒœêø“TµÖ­mâ´Ô-g»µÉWFC,NÙ1±`œç×šâoôóå¨òÕ¶I´ŒFıÇÂ{õ.‡47EI$`8¸…eQÏ`ÀŒôæ®3º*pqv;\r}2òÃìòhÚ–¡©Æ\n½¤YıĞ^2và…ç¸$ıjéñ=Í¶™Ó4í;MY‰]Âd™Æ;•aê7Ù©õİ?LµÕíñmö«›»uPY\\±nù•ˆïƒk\n9ÒÌDÖwÃyŒVDÄl£¡E\'ç€ïÄÉª,^êº­İ‹-î­{&\'1Š-WH<ıÒ¿\\T1ÙY,­kÂÌ¨QäœÜ8àçiˆm9Èà1õ¢h.WH’ííRè\\HÂ[ı²†ÒT±ùA$õÁÎN	°Ma°	˜<ÊË\",«•ä2©$cŒÔºÜVºim¡µ2*9IXà\'¼?%=Hã“Ğ\Z¡vlfÔ‘#Š;£S„Pn‡9ùXœû?9YBÚHÄÒ??Í¸}1úóOÖ,Æ˜chMüSLË²Èäü9<{q1I-@İøi{%·ÒG•#¸‚EXİ<¿›!³°p éŠö¼{Šğ†’¡ñÆœÎawà¾òç÷RáêFsøW¿dÔTZ—œàºò‰[‹N¾k/0zrÃå\rüG“õÏ=ªéğ‡7ƒlN~T9ÏNıñÏcZÜ(–1·)rÈÊ\"ä^2¹\ns€;wÎFKwoJöñòöaƒ´üÃòãñ¼Ùìgi\Zì¶ÀAq (‰LÃ1”Éùc8$=F6ÉmöÑßé6·p²å¤\\BğY[89É\"ªK§,ÌÎ	\0`óÏ±ô¦­€Såïo,XpO­W³\\×/ÛµGª;íMñs_ØxGµš ŒÆñÕ]$6±\nÙ;±‘Óo<`Q¼C®ß±é¦º½Å¼ò·–†Ù\Z•[98ÎTqYŞ!¾“I¶Ò¬îîb³‰<¶A!”ŒôëÅ^ğ¯ŠáS-½®ûÇ^åÜ³mÎvŒçhéœuÀôéöq½“9İIn>í¤ÑÄ¶xñ)–ÎIÄ¤Œ›;g‘ÈÈÍI¥ÚL¶æH-¯ç\r®ÉNß˜mÃüÇ <àĞd]|à»’%¾·†M¤ÓáxçR}Gôæ¹ıcÆ\Z„ú«K¤êFÛO•C$&s#q\\A#ıáéšÆµMS¹P©Í¹Fk—Ò»E§LªÌNnÓõ$à“ïŠ½{ğÛY½‘&û*×gğw_Ä0lÖÏˆuÉ%-ı«xFz‹ƒèµ¨j×S#,÷3\\%ß™®{3MÏOğòh:Í•ıçˆtï´Å4Q‹K@‰¹KĞc=Oğ×¬üßŞşUò¼—r Ü›UĞ‡R£¡Šú§Ú¦i3åÆÔo$E&êe^Ë…Gä;V„±›Uk¦c´ùm+Ä“’»_ïş•ˆGù­\r>33Ì›|Ì[Èûs•ç?‡ZÕhA4·\Zt®êgRëÂü¤ôü)«sQª´GÜÄiÍ=ÍÍ´rÏ<’’Ì¿;g Oş*½ÁÚe”şµš{H¥™÷îg@s‡`8<t›FçŸ¤ñÎ¿èğ\\HsŒ,,yôéLl\\pz/øÖ×‰l¶x†ä¢\0c8àª¼~(Õ—0ñZÁßR$¬B¤pŒ±àW@è±Ş\0,Ù_o¡÷ÍB#€\n¶Hİ:~?JhŞ0Áì~ö;Vs•ÙQV&Ÿ÷/µÙ3á\0ñüª\'!óÌ¾ÀŠWÁO™F3Ş\\~´ÜBX1ä÷ó*\n(İZœ3\0İ?Š»¿øYWùõë’X<×1F‘’Ù}¥UşÁÔçÑÿ\01ş5-®£I”ÂmÎWƒ­\r*V¶ûT¤›wŒãï™ÿ\0ÇêËt_éSÿ\0Ë	İOı\Z•\n£nÄØ¨±0³Š2Pî~÷û)ßğ®Ã@ñ5¦£ÛZİG+Iì˜ÀaË³qÎzJæÏŞƒêÿ\0ÈVƒª¥2ã ÍsP—±Èƒ÷2Â˜îÓ’k2¥¸œ\".æÁcÎ0\0É<ûSjññeÿ\0\\ÿ\0F5Giÿ\0¿çÒºÓ´.dõ³Å<Ò\Z4láB–\'\0p<ğ0)E›nÜBg©îÿ\0Ö ¦ú}Mp:Ò4öbÁŒqÏÊÂ˜QÉuW‡3Èş•4ı¾”Çûëô¦ª°mÉp’ÈğùjùO\'zÔû|ó×õÿ\0ëÔšüƒ¡ÿ\0¯¶ÿ\0Ñu­Eù·4‹CÿÙ',1),(24,'111',NULL,'UsuÃ¡rio Externo','da','(11)11111-1111',NULL,1);
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
INSERT INTO `documento` VALUES (28,'2017-09-09 17:28:03','teste','joao.silva.edu.br','teste','2017-09-09 17:28:47','2017-09-09 17:36:28',2,3),(29,'2017-09-09 17:28:14','teste','joao.silva.edu.br','teste','2017-09-09 17:28:47','2017-09-09 17:28:59',2,3),(30,'2017-09-09 17:39:57','teste','daniel.antonio.edu.br','teste','2017-09-09 17:40:05','2017-09-09 17:40:15',1,3),(31,'2017-09-09 17:45:05','teste','daniel.antonio.edu.br','teste','2017-09-09 17:45:36','2017-09-09 17:45:53',1,3),(32,'2017-09-14 10:18:18','Preenchimento correto de Memorandos','daniel.antonio.edu.br','Senhor Fulano de tal,\n\n		O memorando Ã© a modalidade de comunicaÃ§Ã£o entre unidades administrativas de um mesmo Ã³rgÃ£o. Trata-se, portanto, de uma forma de comunicaÃ§Ã£o eminentemente interna.\n\n		A estrutura de um memorando deve respeitar uma sÃ©rie de caracterÃ­sticas descritas neste manual.\n\n		Devo mencionar, por fim, que a atenÃ§Ã£o a essas regras Ã© de fundamental importÃ¢ncia para o uso correto das comunicaÃ§Ãµes oficiais.\n\n\nAtenciosamente,\n\n\nNome do Remetente\nCargo que ocupa (SÃ³ as iniciais maiÃºsculas, sem negrito)',NULL,NULL,1,1);
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
INSERT INTO `setor` VALUES (1,'AssistÃªncia Estudantil',''),(2,'Engenharia',''),(3,'ComputaÃ§Ã£o',''),(4,'ADM',''),(5,'Secretaria AcadÃªmica','');
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
INSERT INTO `usuario` VALUES (1,'Daniel','Antonio','ÿØÿà\0JFIF\0\0\0\0\0\0ÿÛ\0C\0		\n\r\Z\Z $.\' \",#(7),01444\'9=82<.342ÿÛ\0C			\r\r2!!22222222222222222222222222222222222222222222222222ÿÀ\0\0Y\0Z\"\0ÿÄ\0\0\0\0\0\0\0\0\0\0\0	\nÿÄ\0µ\0\0\0}\0!1AQa\"q2‘¡#B±ÁRÑğ$3br‚	\n\Z%&\'()*456789:CDEFGHIJSTUVWXYZcdefghijstuvwxyzƒ„…†‡ˆ‰Š’“”•–—˜™š¢£¤¥¦§¨©ª²³´µ¶·¸¹ºÂÃÄÅÆÇÈÉÊÒÓÔÕÖ×ØÙÚáâãäåæçèéêñòóôõö÷øùúÿÄ\0\0\0\0\0\0\0\0	\nÿÄ\0µ\0\0w\0!1AQaq\"2B‘¡±Á	#3RğbrÑ\n$4á%ñ\Z&\'()*56789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz‚ƒ„…†‡ˆ‰Š’“”•–—˜™š¢£¤¥¦§¨©ª²³´µ¶·¸¹ºÂÃÄÅÆÇÈÉÊÒÓÔÕÖ×ØÙÚâãäåæçèéêòóôõö÷øùúÿÚ\0\0\0?\0öÓ\nÈr ö4‚Wà}ÏZz2È‚Hä‡£Ög$°úò*•ÈmØl0o¡©aµ·™	s×•$™@8 {Tkåc[ûÂ«¦„]2)4hš0Èlç\'¸ô¬»«È#åÏ¶ò£}íÀzÔwS…UdÆsZFSO]Œæ Ö›œûCQk¦ŠÊÒXÊÿ\0®j‚Â]ÊAÇ#5ªªìféµk˜¦\Zi‹Úº{m<C÷`7@qI›ä¦÷T$ôïŠ^İZíììf;VšTF£>õ°</&nPøS[v‹1íŒë“ÍZ¬¥ˆ“øMcE-Ï0¶¶×l¥ì»ØÕcl´à°9ãvç¶HÏZºÚïˆĞo–)JŒ÷õÓÎkNÓÄZ4–lVñc\'~“Ï?7Pyé£À«-­ô?è÷VŸh˜‡G†}ì[?.G©ã>•æ{i[s±Æ/¡‡wñ\rôÕİyf66²6ÑxÁ\'<sÛ¡®Ån%f·ÑÑ-PZáÀv?@FzqÏÒ³¾\'Øê§V¾/=­C‚O—€¿)<rp6’=;d\nòï>euŞ®W¦\0ãò­éÍµvÄéÄõâ®«n6BÒÎ:?ÛJÎÇû§9õàZï|1ñêw	k©Ä!™ƒ1Â1\0œğIÎ\0÷ë^š¤>bÆ!™Ü±Ü\\zğ8ÙéÆ¬ıµãÃe’3Áy9ÿ\0¾yÈíZF¤“\"tbÑõq‹¸2È¡@’ Øõæ~ñÕÔÚ)vËrñW‘Ëo\'9cz]xóL‰Â\\ÆÊOO)·ãëÓn¬³0T§¦v·š<ciíU\ZY€Û»*:YÑx«K—cÆÓ\0İ£ãZ1^[^ó±1# ƒùj¢ãêRô\"fsĞ\0}iá®0?x?:—ÉänÎ}´y1yÿ\0ïŸş½UãĞŸ{©åğêv÷ZÖm`´1\\\rËÂ$Ae\'v‘”ûÃ>µfûÄ–Z<O8´Ó&óv\0¶ÍµÜ·£®\nŒ“Œ5ÂZé–Å¼Û…­#ÚŒÊæ­ÉÈ\0g±wÓ5n;Kö±\\YEyhê)U›* Ÿ”°\\6Ùô5åû4õ;ît6ÖF¥á¸-’a¶ñBÍ½B«‚Ç{1$¿Q‘’3Šá¿²m.ác	FAÓaVÜšm³ØX\\[¢Çö´•“µX(?tœ6q×ß-|\'©[êpL—L€#2`3øÕ+%diÔÆ\ZHp¤§Şã ööúÓgÓ®\"³p-d99r@Æ{q×õ®ÇÄºv­¤jª,M»à\0Á~oQ–R?^•ĞÙÚŞİhSÁs\Z–h¿tLkoìÓ´óE\n£Z”àˆ¾ø~[8QÆev™Õ”—îzç‚ õëRE£Íqis%–“y–á•íÇıœ’¹\0~U%·ˆ4ı#F†È_´~dq°İ”Å†.®p>v8 ç‚O8_Ú±ÿ\0iZ¼:—Ú­dÿ\0UBÀãñóårO\0g¦xù[ÔÂöv:K=Fs5ŒŠ£j(,`GSï~8ü\rEêT¦â6„¤¡\n4yäçh\\¶vœ`}j©ñ	®ïVâ!‘˜HFÖPHò¡_âÆìõõÎrõ@×\\]ß«å˜®ÉtdÀË’2r3×=(I­‡£Üİ{ËÍ<îušÜe~ÍÎ®~R­Y]_Q*ö”Üùø5çóø²ÄÜ¼on¥PH’98õÁ\'§^M\r­xuİ˜ÜêhIÎÅ\\öÌâ©©h•müA$Q\\O5¼SK$ÂTˆŒ€pyÊœñ7øç#oN×,^Éîõ-2[Ë²ª¨ï4‹¸½“»¿°ÀÅyıİüªår$èLÀ_R7U3«ê6R£Å90É•ã¨éT©I ¹ê\ZíüÖW¶¶¿hİ§©ibUw!>bvä’Aã±îNcÿ\0„Ê%Õm¥HLĞ¯L‚ùÏò¯:µÕ5mjä$·*Æ%ó1¨n8\03›¦qÉ5Òh÷pÍ4OæYÇ!ùe3!½0AõàûÔÎ¬Ú›îzŞŸâoãF‰V9”œ£_cı*–­®[ÁuohrI+á#p\nè»»à9Èâ¹ˆïà¹Ö’ßI„İİù[ZPHUÎ99è\0Ğdñ\\ÎµÕµï™¨3ù²ïXİFQö¹SµºÓƒê9¬nõIÙht:åÎ§ïîcYY\\yrùÅy9%ÁP^ªzŠ©a©iÑJrKG+8NÇÍòã ÈÇMÃ‘ƒ\\Í´—R	¢˜ä8Æyè?ÏZ¢`¼UØäÕº³9“fŞ²b¶ºh‘c™‚«4¬¼8eV9í“ù{ÕXíìæuxX3a”ã ñ8÷öúU+K5ºœ‰&ò$Ú¬¤ï89?…v³ÛI$Oso/a±˜íäsÓ¯=9ïL«;\\Ô´ĞÅì<V¬¿*±RVOQÇ§\\ı}²>“NÑÉ¨ÂÖIÁy\nk\n#\"9Ü2Èf Õ­îyŞœÿ\0µNìFYrä©ã=OlTlX–C‚¤à}{ş*`¹ôÈâ’N#$TçŸoòk Ó/Ÿ~²6v0Úÿ\0Cßú×ec¡Úë€]ÂË·#{¡ÁßşµÉ,jÿ\0)İœ~ëo®}1Ïqõ§[Èa¹A$©µƒ4‘òê3Õy¯§5‡6©Ø¨ÊÇ»ØZÙxkBv´¶ÏÊ]°pÒwcÓ§,x\0H\0šóß\Zëöú•Í–Ÿe*OœŒ$¹	æb¸Œ3ä£¹W»¹¿]×—wSÌ€,k#9\'’xÆÇ_NHäòù]¤AAê0zızöê+:t9_3wbK«\"ÌK²FJ‘€OQ‘Éõÿ\0õsšÃ½Æ#uÎnÁïëÓ¥Qwà‚``c#9ÿ\09­­!¾Ñfb³s¼©<d~ şTêÅ%Ìˆ‰Gı\"¼a#Ïß?tx?çµ(²…·ÉNY¾r™úş5jæÂâå°˜—?1NØäg¦j°¹DùRFŸ6 ‚O\0}xî9íÖ°¹M	%¤A\"g]Œzä‘×#¡íÇëNV$^Ü{ÿ\0ìj&™RTv\nFYA\' gúgÿ\0×Q}¾äqÊûyÄcõª»™ƒ¸”±àj«2¾ĞJ…œt#\'óªƒ§ãVû¿û‹ü«¨¦,`´ã0q×Š“\\6ö\0)ãN?Ç§ü{·ãNì>”É,©X Éæwp€9üÿ\0J˜Ë¾5#˜TSÈ$œzrz{šdv÷ıÏı¨´ÁÛéı)’Ç\\H‹œ6WvÆ	­¡äÈLbBòm¸#Ÿ§CúW=u÷ıã]†?ä7ıwÿ\0Ùk:ºÆÃE•Šm‰.æn8ÈÇp{àã¶*B³Î#0Ãå8ƒ°À\\óqÇ\'ŒqŸzÕ—ş=_è?šÕXÿ\0ÕÅÿ\0®wI=ÆgÜi);9lG!çIFr{ÁüÇ5\Zxm¶/ïcéİÔŸıV©ûÍõşµrÓş<àÿ\0®küªÔl¬;ŸÿÙ',23648,'143.167.366-80','MG-21.041.921','1999-05-23','danielantonio23599@gmail.com','daniel.antonio.edu.br','(37)99156-0541','(37)99941-2386',1,3,4,3,1),(2,'1','1',NULL,1,'111.111.111-11','111','1111-11-11','111','joao.silva.edu.br','(11)11111-1111','(11)11111-1111',2,3,1,1,2),(3,'dani','dani','ÿØÿà\0JFIF\0\0\0\0\0\0ÿÛ\0C\0		\n\r\Z\Z $.\' \",#(7),01444\'9=82<.342ÿÛ\0C			\r\r2!!22222222222222222222222222222222222222222222222222ÿÀ\0\0Y\0Y\"\0ÿÄ\0\0\0\0\0\0\0\0\0\0\0	\nÿÄ\0µ\0\0\0}\0!1AQa\"q2‘¡#B±ÁRÑğ$3br‚	\n\Z%&\'()*456789:CDEFGHIJSTUVWXYZcdefghijstuvwxyzƒ„…†‡ˆ‰Š’“”•–—˜™š¢£¤¥¦§¨©ª²³´µ¶·¸¹ºÂÃÄÅÆÇÈÉÊÒÓÔÕÖ×ØÙÚáâãäåæçèéêñòóôõö÷øùúÿÄ\0\0\0\0\0\0\0\0	\nÿÄ\0µ\0\0w\0!1AQaq\"2B‘¡±Á	#3RğbrÑ\n$4á%ñ\Z&\'()*56789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz‚ƒ„…†‡ˆ‰Š’“”•–—˜™š¢£¤¥¦§¨©ª²³´µ¶·¸¹ºÂÃÄÅÆÇÈÉÊÒÓÔÕÖ×ØÙÚâãäåæçèéêòóôõö÷øùúÿÚ\0\0\0?\0´Êw1\0¤ÔY2mòÓ*z³qüéË‹÷Ó8ã{œcúÂ©Ë­ÛFæ8ƒLı¶tÏ×ü+z˜¶ş·/yI™§“åŒ<aqê\nóıOÅ—×7j4 #³„ƒµ	@ŞÙãŞºmZ]WìxºŠK(äû¡¡qÙë\\f§in‘Ûˆ™\"^OlwÍrJ£“÷”´:]/ÆÍtÑÚGÚß…VÉÁAóqôï[kmªê.Ş|¾LdcËSÇäO©¯=ğıÍ†²·Ú’Í+BÂ!QŒôËdİ+~ëÇšƒ–KU‚Øg ó$¼?J†›ØW;{m\nÆÉ\Z{©¢¯Ìf`Gòüé­âİ.–ÚT/rÌ \n‚IàdäñŒ×•Şjwó¤÷4Ò·S9Ï9ètúTÖ÷×	hmÚF4ªÒÄì\r\'óâ’‚êK—c½×üM­Ø\\­† -ôC,bQe•T’\0ÈÈàğ@?LŠáî¯®î¢YîiXä#Ü\\o>œ)çÛÒ­_k7Ş¬¶1G§+ÛR-D®·rÌÄ¶H\\œóLÓ´‹Ùínî¡²º’İ·KoldEãœ·ğ€+K%±7lôÿ\0‡BïÂQ¦à|‰¤ˆávÎìãÕÔ}™}r?mM·†î’\'g»i@åADá±ĞñÓ¨®ÛmsKse±ä1é“\\æ[Û—eœ3p?Â»¿éş\ZÒl¡¿»}ô¾%Lşï*A9#Û§×Äç/0V–W¸÷²ÊdÜóÂ¨>œûsQŞjRI«ÊÖ¢HK€ëÊô ¯Ldt?ˆ®˜%}LÛĞúP»Ò|BçLd»´»G;fmím&(İTãwC‘@ÈÏÎÖÖz¥İµó:‚¶)›€í q½å]•¯¨Ïö7p^[\\ÜÄ‹YnÜ€r\nåA<ü‡ij-bc£x«_±•hÛ9tÚT#ù~`m¤2[8å«I¥`NÇ\"Ñ¼fX°T ,AÓ‘Ÿ¯JŸÊ{we”*] °ÙêUyüë¦‡MÒç±»›N¹D;hËEy(O)È&8áãå=gOŒñöv‘¼R˜|Ò\"Û¡éÀ	–qú·^+&ì#0[´IûNÌ`Î}»‘ïR,9I¼¬6Şs\Zğ?¼ÜúñŞµì´]JïÊŠ-2ãj“†u óæ¿>œc§½kÿ\0Â-¼Åõ_O´Š~M.é¨‚‚}ùÆ*n;›O™£‘U·aC)<u!¸?…kZx–âĞ5¥ïúEªÂ	æ“ÊG]¨@?ˆíŠ×x|¥NŠóßêş_Xã!£SëÆĞ3RIãQ§\\ƒ¢øNÓ„œ.+8í÷vß¹¢ácsá…åÄÑê0M•$Mäƒ‚0îƒæ<œ× ãŞ¼ÏÀŞ!¿×<qx×·±É¶ÉÀ†5Â®$L@Á1ç$×¦äV3ÜÒ;3G,h6·k6nggG\0ìÚ~SÃH\'¨^œg­eİÊÓÃor‘â[g1»ï å”cê$æº;›K{\rÒÆ÷pKÀí\ZÇ•Á}§ õÈØŞD—.%H±*ì.àá9ÆOğr¹ë¡-[!=“:Í+_¬¾É}\Z¼A‹!É\r	;wÈ\r½áŒœêø“TµÖ­mâ´Ô-g»µÉWFC,NÙ1±`œç×šâoôóå¨òÕ¶I´ŒFıÇÂ{õ.‡47EI$`8¸…eQÏ`ÀŒôæ®3º*pqv;\r}2òÃìòhÚ–¡©Æ\n½¤YıĞ^2và…ç¸$ıjéñ=Í¶™Ó4í;MY‰]Âd™Æ;•aê7Ù©õİ?LµÕíñmö«›»uPY\\±nù•ˆïƒk\n9ÒÌDÖwÃyŒVDÄl£¡E\'ç€ïÄÉª,^êº­İ‹-î­{&\'1Š-WH<ıÒ¿\\T1ÙY,­kÂÌ¨QäœÜ8àçiˆm9Èà1õ¢h.WH’ííRè\\HÂ[ı²†ÒT±ùA$õÁÎN	°Ma°	˜<ÊË\",«•ä2©$cŒÔºÜVºim¡µ2*9IXà\'¼?%=Hã“Ğ\Z¡vlfÔ‘#Š;£S„Pn‡9ùXœû?9YBÚHÄÒ??Í¸}1úóOÖ,Æ˜chMüSLË²Èäü9<{q1I-@İøi{%·ÒG•#¸‚EXİ<¿›!³°p éŠö¼{Šğ†’¡ñÆœÎawà¾òç÷RáêFsøW¿dÔTZ—œàºò‰[‹N¾k/0zrÃå\rüG“õÏ=ªéğ‡7ƒlN~T9ÏNıñÏcZÜ(–1·)rÈÊ\"ä^2¹\ns€;wÎFKwoJöñòöaƒ´üÃòãñ¼Ùìgi\Zì¶ÀAq (‰LÃ1”Éùc8$=F6ÉmöÑßé6·p²å¤\\BğY[89É\"ªK§,ÌÎ	\0`óÏ±ô¦­€Såïo,XpO­W³\\×/ÛµGª;íMñs_ØxGµš ŒÆñÕ]$6±\nÙ;±‘Óo<`Q¼C®ß±é¦º½Å¼ò·–†Ù\Z•[98ÎTqYŞ!¾“I¶Ò¬îîb³‰<¶A!”ŒôëÅ^ğ¯ŠáS-½®ûÇ^åÜ³mÎvŒçhéœuÀôéöq½“9İIn>í¤ÑÄ¶xñ)–ÎIÄ¤Œ›;g‘ÈÈÍI¥ÚL¶æH-¯ç\r®ÉNß˜mÃüÇ <àĞd]|à»’%¾·†M¤ÓáxçR}Gôæ¹ıcÆ\Z„ú«K¤êFÛO•C$&s#q\\A#ıáéšÆµMS¹P©Í¹Fk—Ò»E§LªÌNnÓõ$à“ïŠ½{ğÛY½‘&û*×gğw_Ä0lÖÏˆuÉ%-ı«xFz‹ƒèµ¨j×S#,÷3\\%ß™®{3MÏOğòh:Í•ıçˆtï´Å4Q‹K@‰¹KĞc=Oğ×¬üßŞşUò¼—r Ü›UĞ‡R£¡Šú§Ú¦i3åÆÔo$E&êe^Ë…Gä;V„±›Uk¦c´ùm+Ä“’»_ïş•ˆGù­\r>33Ì›|Ì[Èûs•ç?‡ZÕhA4·\Zt®êgRëÂü¤ôü)«sQª´GÜÄiÍ=ÍÍ´rÏ<’’Ì¿;g Oş*½ÁÚe”şµš{H¥™÷îg@s‡`8<t›FçŸ¤ñÎ¿èğ\\HsŒ,,yôéLl\\pz/øÖ×‰l¶x†ä¢\0c8àª¼~(Õ—0ñZÁßR$¬B¤pŒ±àW@è±Ş\0,Ù_o¡÷ÍB#€\n¶Hİ:~?JhŞ0Áì~ö;Vs•ÙQV&Ÿ÷/µÙ3á\0ñüª\'!óÌ¾ÀŠWÁO™F3Ş\\~´ÜBX1ä÷ó*\n(İZœ3\0İ?Š»¿øYWùõë’X<×1F‘’Ù}¥UşÁÔçÑÿ\01ş5-®£I”ÂmÎWƒ­\r*V¶ûT¤›wŒãï™ÿ\0ÇêËt_éSÿ\0Ë	İOı\Z•\n£nÄØ¨±0³Š2Pî~÷û)ßğ®Ã@ñ5¦£ÛZİG+Iì˜ÀaË³qÎzJæÏŞƒêÿ\0ÈVƒª¥2ã ÍsP—±Èƒ÷2Â˜îÓ’k2¥¸œ\".æÁcÎ0\0É<ûSjññeÿ\0\\ÿ\0F5Giÿ\0¿çÒºÓ´.dõ³Å<Ò\Z4láB–\'\0p<ğ0)E›nÜBg©îÿ\0Ö ¦ú}Mp:Ò4öbÁŒqÏÊÂ˜QÉuW‡3Èş•4ı¾”Çûëô¦ª°mÉp’ÈğùjùO\'zÔû|ó×õÿ\0ëÔšüƒ¡ÿ\0¯¶ÿ\0Ñu­Eù·4‹CÿÙ',111112,'222.222.222-22','11112','1111-11-11','dani','dani','(22)22222-2222','(22)22222-2222',5,3,1,1,1);
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
