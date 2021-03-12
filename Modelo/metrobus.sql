-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: metrobus
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `ct_alcaldias`
--

DROP TABLE IF EXISTS `ct_alcaldias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ct_alcaldias` (
  `id_alcaldia` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_alcaldia`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ct_alcaldias`
--

LOCK TABLES `ct_alcaldias` WRITE;
/*!40000 ALTER TABLE `ct_alcaldias` DISABLE KEYS */;
INSERT INTO `ct_alcaldias` VALUES (1,'Alvaro Obregon'),(2,'Azcapotzalco'),(3,'Benito Juarez'),(4,'Coyoacan'),(5,'Cuajimalpa de Morelos'),(6,'Cuauhtemoc'),(7,'Gustavo A. Madero'),(8,'Iztacalco'),(9,'Iztapalapa'),(10,'Magdalena Contreras'),(11,'Miguel Hidalgo'),(12,'Milpa Alta'),(13,'Tlahuac'),(14,'Tlalpan'),(15,'Venustiano Carranza'),(16,'Xochimilco');
/*!40000 ALTER TABLE `ct_alcaldias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ct_cp`
--

DROP TABLE IF EXISTS `ct_cp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ct_cp` (
  `id_codigo_postal` int NOT NULL AUTO_INCREMENT,
  `rango_final` varchar(255) DEFAULT NULL,
  `rango_inicial` varchar(255) DEFAULT NULL,
  `id_alcaldia` int DEFAULT NULL,
  PRIMARY KEY (`id_codigo_postal`),
  KEY `FK99t1irpxp9q2ns2gmvhkx38ye` (`id_alcaldia`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ct_cp`
--

LOCK TABLES `ct_cp` WRITE;
/*!40000 ALTER TABLE `ct_cp` DISABLE KEYS */;
INSERT INTO `ct_cp` VALUES (1,'1999','01000',1),(2,'2999','02000',2),(3,'3999','03000',3),(4,'4999','04000',4),(5,'5999','05000',5),(6,'6999','06000',6),(7,'7999','07000',7),(8,'8999','08000',8),(9,'9999','09000',9),(10,'10999','10000',10),(11,'11999','11000',11),(12,'12999','12000',12),(13,'13999','13000',13),(14,'14999','14000',14),(15,'15999','15000',15),(16,'16999','16000',16);
/*!40000 ALTER TABLE `ct_cp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_ubicaciones`
--

DROP TABLE IF EXISTS `tb_ubicaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_ubicaciones` (
  `id` int NOT NULL,
  `date_updated` varchar(255) DEFAULT NULL,
  `geographic_point` varchar(255) DEFAULT NULL,
  `position_latitude` double DEFAULT NULL,
  `position_longitude` double DEFAULT NULL,
  `position_odometer` int DEFAULT NULL,
  `position_speed` int DEFAULT NULL,
  `vehicle_current_status` int DEFAULT NULL,
  `vehicle_id` int DEFAULT NULL,
  `vehicle_label` int DEFAULT NULL,
  `id_alcaldia` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9iyl3rdgd19m6kh7l8rbl9o9i` (`id_alcaldia`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_ubicaciones`
--

LOCK TABLES `tb_ubicaciones` WRITE;
/*!40000 ALTER TABLE `tb_ubicaciones` DISABLE KEYS */;
INSERT INTO `tb_ubicaciones` VALUES (0,'2021-01-27 06:00:02 p. m.','19.3174991608,-99.1877975464',19.3174991607666,-99.1877975463867,231,16,2,170,112,4),(1,'2021-01-27 06:00:02 p. m.','19.2926006317,-99.1774978638',19.2926006317138,-99.1774978637695,0,13,1,177,119,NULL),(2,'2021-01-27 06:00:02 p. m.','19.4500999451,-99.1100997925',19.4500999450683,-99.1100997924804,0,5,2,1286,219,NULL),(3,'2021-01-27 06:00:02 p. m.','19.3892002106,-99.0597991943',19.3892002105712,-99.0597991943359,0,4,1,1302,235,NULL),(4,'2021-01-27 06:00:02 p. m.','19.3826007843,-99.0613021851',19.3826007843017,-99.0613021850585,454,0,2,361,303,NULL),(5,'2021-01-27 06:00:02 p. m.','19.3899002075,-99.0588989258',19.3899002075195,-99.0588989257812,1790,0,2,370,312,NULL),(6,'2021-01-27 06:00:02 p. m.','19.4792003632,-99.0639038086',19.4792003631591,-99.0639038085937,1635,0,1,371,313,NULL),(7,'2021-01-27 06:00:02 p. m.','19.4039001465,-99.1724014282',19.4039001464843,-99.1724014282226,131,12,2,409,351,6),(8,'2021-01-27 06:00:02 p. m.','19.4034996033,-99.1704025269',19.4034996032714,-99.1704025268554,0,5,1,449,391,6),(9,'2021-01-27 06:00:02 p. m.','19.4270000458,-99.1490020752',19.4270000457763,-99.1490020751953,668,3,2,1,401,6),(10,'2021-01-27 06:00:02 p. m.','19.4916000366,-99.1527023315',19.491600036621,-99.1527023315429,213,0,2,33,433,NULL),(11,'2021-01-27 06:00:02 p. m.','19.4200000763,-99.1541976929',19.4200000762939,-99.154197692871,0,2,2,38,438,6),(12,'2021-01-27 06:00:02 p. m.','19.3971004486,-99.1558990479',19.3971004486083,-99.1558990478515,288,0,2,39,439,3),(13,'2021-01-27 06:00:02 p. m.','19.4043006897,-99.1554031372',19.4043006896972,-99.155403137207,308,10,2,40,440,6),(14,'2021-01-27 06:00:02 p. m.','19.5119991302,-99.1604995728',19.511999130249,-99.1604995727539,369,13,2,53,453,NULL),(15,'2021-01-27 06:00:02 p. m.','19.5172996521,-99.1626968384',19.5172996520996,-99.1626968383789,295,13,2,1148,462,NULL),(16,'2021-01-27 06:00:02 p. m.','19.5062999725,-99.1584014893',19.5062999725341,-99.1584014892578,253,13,2,1149,463,NULL),(17,'2021-01-27 06:00:02 p. m.','19.4377002716,-99.1479034424',19.4377002716064,-99.1479034423828,244,5,2,981,467,6),(18,'2021-01-27 06:00:02 p. m.','19.5261001587,-99.1680984497',19.5261001586914,-99.168098449707,441,2,2,982,468,NULL),(19,'2021-01-27 06:00:02 p. m.','19.4428005219,-99.1480026245',19.4428005218505,-99.1480026245117,350,11,2,984,470,6),(20,'2021-01-27 06:00:02 p. m.','19.4839992523,-99.1498031616',19.4839992523193,-99.149803161621,0,5,1,985,471,NULL),(21,'2021-01-27 06:00:02 p. m.','19.4372997284,-99.1458969116',19.4372997283935,-99.145896911621,0,3,1,467,509,6),(22,'2021-01-27 06:00:02 p. m.','19.4361000061,-99.1213989258',19.4361000061035,-99.1213989257812,0,0,1,483,525,15),(23,'2021-01-27 06:00:02 p. m.','19.4290008545,-99.1321029663',19.4290008544921,-99.1321029663085,0,6,1,486,528,6),(24,'2021-01-27 06:00:02 p. m.','19.4356002808,-99.1164016724',19.4356002807617,-99.1164016723632,214,3,2,490,532,15),(25,'2021-01-27 06:00:02 p. m.','19.4449996948,-99.1522979736',19.4449996948242,-99.1522979736328,0,0,1,491,533,6),(26,'2021-01-27 06:00:02 p. m.','19.4356002808,-99.1546020508',19.4356002807617,-99.1546020507812,385,0,2,492,534,6),(27,'2021-01-27 06:00:02 p. m.','19.4409008026,-99.1526031494',19.4409008026123,-99.152603149414,203,4,2,496,538,6),(28,'2021-01-27 06:00:02 p. m.','19.4307003021,-99.1155014038',19.430700302124,-99.1155014038085,0,0,1,512,554,NULL),(29,'2021-01-27 06:00:02 p. m.','19.4291000366,-99.1143035889',19.429100036621,-99.1143035888672,1015,11,2,557,614,15),(30,'2021-01-27 06:00:02 p. m.','19.4974002838,-99.0896987915',19.4974002838134,-99.0896987915039,499,0,2,562,619,NULL),(31,'2021-01-27 06:00:02 p. m.','19.432100296,-99.1150970459',19.4321002960205,-99.1150970458984,85,7,2,10000,620,15),(32,'2021-01-27 06:00:02 p. m.','19.495300293,-99.154800415',19.4953002929687,-99.154800415039,169,11,2,1085,712,NULL),(33,'2021-01-27 06:00:02 p. m.','19.4757995605,-99.0898971558',19.4757995605468,-99.0898971557617,324,10,2,1115,762,NULL),(34,'2021-01-27 06:00:02 p. m.','19.4906997681,-99.133102417',19.4906997680664,-99.1331024169922,0,1,2,1120,767,NULL),(35,'2021-01-27 06:00:02 p. m.','19.4734992981,-99.0702972412',19.4734992980957,-99.0702972412109,263,10,2,1132,784,NULL),(36,'2021-01-27 06:00:02 p. m.','19.483499527,-99.113899231',19.4834995269775,-99.113899230957,0,5,1,702,802,NULL),(37,'2021-01-27 06:00:02 p. m.','19.4874992371,-99.1138000488',19.4874992370605,-99.1138000488281,547,0,2,705,805,NULL),(38,'2021-01-27 06:00:02 p. m.','19.4545993805,-99.1302032471',19.4545993804931,-99.1302032470703,223,8,2,713,813,6),(39,'2021-01-27 06:00:02 p. m.','19.4258003235,-99.1930999756',19.4258003234863,-99.1930999755859,643,3,2,716,816,NULL),(40,'2021-01-27 06:00:02 p. m.','19.4533996582,-99.1307983398',19.4533996582031,-99.1307983398437,0,5,2,753,905,6),(41,'2021-01-27 06:00:02 p. m.','19.4592990875,-99.12840271',19.4592990875244,-99.1284027099609,181,0,2,757,909,6),(42,'2021-01-27 06:00:02 p. m.','19.4267997742,-99.1994018555',19.4267997741699,-99.1994018554687,0,0,2,760,912,NULL),(43,'2021-01-27 06:00:02 p. m.','19.4298000336,-99.1614990234',19.4298000335693,-99.1614990234375,147,5,2,766,918,6),(44,'2021-01-27 06:00:02 p. m.','19.4873008728,-99.1137008667',19.4873008728027,-99.1137008666992,531,0,2,787,939,NULL),(45,'2021-01-27 06:00:02 p. m.','19.4437999725,-99.1390991211',19.4437999725341,-99.1390991210937,0,0,1,789,941,6),(46,'2021-01-27 06:00:02 p. m.','19.3959007263,-99.1566009521',19.3959007263183,-99.1566009521484,759,1,2,1253,1000,3),(47,'2021-01-27 06:00:02 p. m.','19.2793998718,-99.1689987183',19.2793998718261,-99.1689987182617,0,3,1,531,1057,NULL),(48,'2021-01-27 06:00:02 p. m.','19.4193992615,-99.1642990112',19.4193992614746,-99.1642990112304,310,2,2,1174,1093,6),(49,'2021-01-27 06:00:02 p. m.','19.4988994598,-99.1194000244',19.4988994598388,-99.119400024414,96,0,1,1160,1101,NULL),(50,'2021-01-27 06:00:02 p. m.','19.4199008942,-99.164100647',19.419900894165,-99.1641006469726,0,3,1,1165,1106,6),(51,'2021-01-27 06:00:02 p. m.','19.3981990814,-99.1710968018',19.3981990814208,-99.1710968017578,0,0,1,988,1111,3),(52,'2021-01-27 06:00:02 p. m.','19.301700592,-99.1858978271',19.301700592041,-99.1858978271484,243,14,2,990,1113,NULL),(53,'2021-01-27 06:00:02 p. m.','19.4412002563,-99.1548995972',19.4412002563476,-99.1548995971679,0,4,2,1220,1115,6),(54,'2021-01-27 06:00:02 p. m.','19.4972991943,-99.1196975708',19.4972991943359,-99.1196975708007,0,5,2,1067,1304,NULL),(55,'2021-01-27 06:00:02 p. m.','19.4976005554,-99.1194000244',19.4976005554199,-99.119400024414,0,0,1,1069,1306,NULL),(56,'2021-01-27 06:00:02 p. m.','19.4055995941,-99.1855010986',19.4055995941162,-99.1855010986328,437,11,2,1188,2306,NULL),(57,'2021-01-27 06:00:02 p. m.','19.4822006226,-99.1055984497',19.4822006225585,-99.105598449707,0,0,1,1190,2308,NULL),(58,'2021-01-27 06:00:02 p. m.','19.4801006317,-99.1008987427',19.4801006317138,-99.1008987426757,0,8,2,1191,2309,NULL),(59,'2021-01-27 06:00:02 p. m.','19.4041996002,-99.1733016968',19.4041996002197,-99.1733016967773,0,10,2,1236,2312,6),(60,'2021-01-27 06:00:02 p. m.','19.404499054,-99.1742019653',19.404499053955,-99.174201965332,0,8,2,1214,2313,6),(61,'2021-01-27 06:00:02 p. m.','19.3843002319,-99.0759963989',19.3843002319335,-99.0759963989257,478,6,2,1217,2316,NULL),(62,'2021-01-27 06:00:02 p. m.','19.3864994049,-99.079498291',19.3864994049072,-99.0794982910156,0,6,2,10007,2338,NULL),(63,'2021-01-27 06:00:02 p. m.','19.3960990906,-99.1591033936',19.3960990905761,-99.1591033935546,415,11,2,1237,2346,3),(64,'2021-01-27 06:00:02 p. m.','19.3864002228,-99.0718994141',19.3864002227783,-99.0718994140625,564,13,2,1025,2352,NULL),(65,'2021-01-27 06:00:02 p. m.','19.3978004456,-99.1293029785',19.3978004455566,-99.1293029785156,0,0,2,1230,2361,NULL),(66,'2021-01-27 06:00:02 p. m.','19.3938999176,-99.0904998779',19.3938999176025,-99.0904998779296,0,6,1,1233,2364,NULL),(67,'2021-01-27 06:00:02 p. m.','19.3957996368,-99.1549987793',19.3957996368408,-99.1549987792968,0,3,1,1241,2376,3),(68,'2021-01-27 06:00:02 p. m.','19.3733997345,-99.1791000366',19.373399734497,-99.179100036621,510,0,2,178,120,3),(69,'2021-01-27 06:00:02 p. m.','19.4510993958,-99.109703064',19.4510993957519,-99.1097030639648,306,10,2,1287,220,15),(70,'2021-01-27 06:00:02 p. m.','19.3908004761,-99.0473022461',19.3908004760742,-99.0473022460937,46,0,2,1288,221,NULL),(71,'2021-01-27 06:00:02 p. m.','19.3964996338,-99.0561981201',19.396499633789,-99.0561981201172,0,9,2,366,308,NULL),(72,'2021-01-27 06:00:02 p. m.','19.4078006744,-99.189201355',19.4078006744384,-99.1892013549804,0,4,1,416,358,NULL),(73,'2021-01-27 06:00:02 p. m.','19.4046001434,-99.1742019653',19.4046001434326,-99.174201965332,0,6,2,422,364,6),(74,'2021-01-27 06:00:02 p. m.','19.4020004272,-99.1871032715',19.402000427246,-99.1871032714843,0,0,1,432,374,NULL),(75,'2021-01-27 06:00:02 p. m.','19.3945007324,-99.1408996582',19.3945007324218,-99.1408996582031,0,6,2,450,392,3),(76,'2021-01-27 06:00:02 p. m.','19.3910007477,-99.0476989746',19.3910007476806,-99.0476989746093,0,0,2,452,394,NULL),(77,'2021-01-27 06:00:02 p. m.','19.3971004486,-99.102897644',19.3971004486083,-99.1028976440429,648,9,2,1021,398,NULL),(78,'2021-01-27 06:00:02 p. m.','19.5205001831,-99.164100647',19.5205001831054,-99.1641006469726,566,6,2,24,424,NULL),(79,'2021-01-27 06:00:02 p. m.','19.4606990814,-99.1438980103',19.4606990814208,-99.1438980102539,332,8,2,26,426,6),(80,'2021-01-27 06:00:02 p. m.','19.4794006348,-99.1482009888',19.4794006347656,-99.1482009887695,0,1,2,35,435,NULL),(81,'2021-01-27 06:00:02 p. m.','19.3971004486,-99.1558990479',19.3971004486083,-99.1558990478515,294,0,2,51,451,3),(82,'2021-01-27 06:00:02 p. m.','19.4736003876,-99.1460037231',19.4736003875732,-99.1460037231445,710,0,2,56,456,NULL),(83,'2021-01-27 06:00:02 p. m.','19.4461994171,-99.147102356',19.4461994171142,-99.147102355957,0,1,1,986,472,6),(84,'2021-01-27 06:00:02 p. m.','19.442199707,-99.1524963379',19.4421997070312,-99.1524963378906,0,0,1,472,514,6),(85,'2021-01-27 06:00:02 p. m.','19.4251995087,-99.1197967529',19.4251995086669,-99.1197967529296,0,5,1,474,516,15),(86,'2021-01-27 06:00:02 p. m.','19.4379005432,-99.1486968994',19.4379005432128,-99.148696899414,285,2,2,476,518,6),(87,'2021-01-27 06:00:02 p. m.','19.4304008484,-99.1417999268',19.4304008483886,-99.1417999267578,0,5,1,482,524,6),(88,'2021-01-27 06:00:02 p. m.','19.4305000305,-99.1150970459',19.4305000305175,-99.1150970458984,0,0,1,499,541,NULL),(89,'2021-01-27 06:00:02 p. m.','19.4272003174,-99.1162033081',19.4272003173828,-99.1162033081054,558,0,2,500,542,15),(90,'2021-01-27 06:00:02 p. m.','19.4309997559,-99.1154022217',19.4309997558593,-99.1154022216796,556,0,2,501,543,NULL),(91,'2021-01-27 06:00:02 p. m.','19.4388008118,-99.1531982422',19.4388008117675,-99.1531982421875,0,4,2,502,544,6),(92,'2021-01-27 06:00:02 p. m.','19.4260997772,-99.1299972534',19.4260997772216,-99.1299972534179,0,6,1,505,547,6),(93,'2021-01-27 06:00:02 p. m.','19.4253005981,-99.1201019287',19.4253005981445,-99.1201019287109,59,1,2,508,550,15),(94,'2021-01-27 06:00:02 p. m.','19.4297008514,-99.1363983154',19.4297008514404,-99.1363983154296,0,5,1,511,553,6),(95,'2021-01-27 06:00:02 p. m.','19.4904994965,-99.0932006836',19.4904994964599,-99.0932006835937,328,11,2,558,615,NULL),(96,'2021-01-27 06:00:02 p. m.','19.5069007874,-99.0857009888',19.5069007873535,-99.0857009887695,762,0,2,561,618,NULL),(97,'2021-01-27 06:00:02 p. m.','19.4598999023,-99.105796814',19.4598999023437,-99.1057968139648,465,4,2,1179,623,NULL),(98,'2021-01-27 06:00:02 p. m.','19.511800766,-99.1960983276',19.5118007659912,-99.1960983276367,122,0,1,1075,702,NULL),(99,'2021-01-27 06:00:02 p. m.','19.4769001007,-99.0725021362',19.476900100708,-99.0725021362304,0,7,1,1079,706,NULL),(100,'2021-01-27 06:00:02 p. m.','19.4974994659,-99.1645965576',19.4974994659423,-99.1645965576172,487,0,2,1089,716,NULL),(101,'2021-01-27 06:00:02 p. m.','19.4918994904,-99.1386032104',19.4918994903564,-99.1386032104492,0,8,2,1091,718,NULL),(102,'2021-01-27 06:00:02 p. m.','19.4878997803,-99.1146011353',19.4878997802734,-99.1146011352539,0,6,1,1180,731,NULL),(103,'2021-01-27 06:00:02 p. m.','19.4888000488,-99.1283035278',19.4888000488281,-99.128303527832,0,5,2,1181,732,NULL),(104,'2021-01-27 06:00:02 p. m.','19.5069999695,-99.1995010376',19.5069999694824,-99.1995010375976,161,0,2,1185,736,NULL),(105,'2021-01-27 06:00:02 p. m.','19.4948997498,-99.1533966064',19.4948997497558,-99.1533966064453,563,8,2,1117,764,NULL),(106,'2021-01-27 06:00:02 p. m.','19.4691009521,-99.0641021729',19.4691009521484,-99.0641021728515,308,8,2,1122,769,NULL),(107,'2021-01-27 06:00:02 p. m.','0.0,-103.488998413',0,-103.488998413085,0,0,2,1135,787,NULL),(108,'2021-01-27 06:00:02 p. m.','19.511100769,-99.1984024048',19.5111007690429,-99.1984024047851,137,6,2,1141,793,NULL),(109,'2021-01-27 06:00:02 p. m.','19.469499588,-99.0646972656',19.4694995880126,-99.064697265625,0,4,2,1144,796,NULL),(110,'2021-01-27 06:00:02 p. m.','19.4838008881,-99.1177978516',19.4838008880615,-99.1177978515625,318,11,2,1146,798,NULL),(111,'2021-01-27 06:00:02 p. m.','19.4871997833,-99.113899231',19.4871997833251,-99.113899230957,157,0,2,711,811,NULL),(112,'2021-01-27 06:00:02 p. m.','19.4281005859,-99.1650009155',19.4281005859375,-99.1650009155273,0,1,1,714,814,6),(113,'2021-01-27 06:00:02 p. m.','19.424200058,-99.1738967896',19.4242000579833,-99.1738967895507,0,10,1,719,819,6),(114,'2021-01-27 06:00:02 p. m.','19.4314002991,-99.1584014893',19.4314002990722,-99.1584014892578,0,7,1,730,830,6),(115,'2021-01-27 06:00:02 p. m.','19.4927997589,-99.1205978394',19.4927997589111,-99.1205978393554,1500,0,2,745,845,NULL),(116,'2021-01-27 06:00:02 p. m.','19.4361000061,-99.1489028931',19.4361000061035,-99.1489028930664,0,5,1,749,901,6),(117,'2021-01-27 06:00:02 p. m.','19.4267997742,-99.1996994019',19.4267997741699,-99.1996994018554,377,0,2,770,922,NULL),(118,'2021-01-27 06:00:02 p. m.','19.4785003662,-99.1212005615',19.4785003662109,-99.1212005615234,0,0,1,771,923,NULL),(119,'2021-01-27 06:00:02 p. m.','19.4916000366,-99.1201019287',19.491600036621,-99.1201019287109,73,0,1,774,926,NULL),(120,'2021-01-27 06:00:02 p. m.','0.0,-103.488998413',0,-103.488998413085,6,0,1,781,933,NULL),(121,'2021-01-27 06:00:02 p. m.','19.4932994843,-99.1210021973',19.4932994842529,-99.1210021972656,0,0,1,788,940,NULL),(122,'2021-01-27 06:00:02 p. m.','19.4267997742,-99.1994018555',19.4267997741699,-99.1994018554687,401,0,2,790,942,NULL),(123,'2021-01-27 06:00:02 p. m.','19.3827991486,-99.1760025024',19.3827991485595,-99.1760025024414,0,7,2,992,1019,3),(124,'2021-01-27 06:00:02 p. m.','19.4127998352,-99.1662979126',19.412799835205,-99.1662979125976,0,7,2,997,1024,6),(125,'2021-01-27 06:00:02 p. m.','19.301399231,-99.185798645',19.301399230957,-99.1857986450195,233,12,2,10016,1036,NULL),(126,'2021-01-27 06:00:02 p. m.','19.4195995331,-99.1641998291',19.419599533081,-99.1641998291015,0,3,2,10019,1039,6),(127,'2021-01-27 06:00:02 p. m.','19.4162998199,-99.1651992798',19.4162998199462,-99.1651992797851,0,1,2,10023,1043,6),(128,'2021-01-27 06:00:02 p. m.','19.489900589,-99.1216964722',19.4899005889892,-99.1216964721679,1176,16,2,1159,1050,NULL),(129,'2021-01-27 06:00:02 p. m.','19.3526000977,-99.185798645',19.3526000976562,-99.1857986450195,192,0,2,1255,1066,1),(130,'2021-01-27 06:00:02 p. m.','19.283000946,-99.1751022339',19.2830009460449,-99.1751022338867,0,10,1,1257,1068,NULL),(131,'2021-01-27 06:00:02 p. m.','19.4990997314,-99.1195983887',19.4990997314453,-99.1195983886718,0,0,2,1259,1070,NULL),(132,'2021-01-27 06:00:02 p. m.','19.2987003326,-99.1855010986',19.2987003326416,-99.1855010986328,0,7,2,1177,1096,NULL),(133,'2021-01-27 06:00:02 p. m.','19.4160995483,-99.1652984619',19.4160995483398,-99.165298461914,0,5,2,1164,1105,6),(134,'2021-01-27 06:00:02 p. m.','19.4708003998,-99.1374969482',19.4708003997802,-99.1374969482422,839,16,2,1167,1108,NULL),(135,'2021-01-27 06:00:02 p. m.','19.3756999969,-99.1783981323',19.3756999969482,-99.1783981323242,414,8,2,1070,1307,3),(136,'2021-01-27 06:00:02 p. m.','19.389799118,-99.0587005615',19.3897991180419,-99.0587005615234,1790,0,2,1062,2302,NULL),(137,'2021-01-27 06:00:02 p. m.','19.3952999115,-99.1480026245',19.395299911499,-99.1480026245117,510,0,2,10015,2303,3),(138,'2021-01-27 06:00:02 p. m.','19.3910999298,-99.0475997925',19.3910999298095,-99.0475997924804,0,0,2,1186,2304,NULL),(139,'2021-01-27 06:00:02 p. m.','19.389799118,-99.0588989258',19.3897991180419,-99.0588989257812,1790,0,2,1192,2310,NULL),(140,'2021-01-27 06:00:02 p. m.','19.3871994019,-99.0803985596',19.3871994018554,-99.0803985595703,0,6,2,930,2340,NULL),(141,'2021-01-27 06:00:02 p. m.','19.389799118,-99.0595016479',19.3897991180419,-99.0595016479492,997,0,2,1234,2365,NULL),(142,'2021-01-27 06:00:02 p. m.','19.3910007477,-99.0476989746',19.3910007476806,-99.0476989746093,94,0,2,1289,222,NULL),(143,'2021-01-27 06:00:02 p. m.','19.3827991486,-99.0615997314',19.3827991485595,-99.0615997314453,114,8,2,367,309,NULL),(144,'2021-01-27 06:00:02 p. m.','19.4648990631,-99.0595016479',19.4648990631103,-99.0595016479492,0,0,1,375,317,NULL),(145,'2021-01-27 06:00:02 p. m.','19.3978004456,-99.1295013428',19.3978004455566,-99.1295013427734,492,9,2,1018,339,NULL),(146,'2021-01-27 06:00:02 p. m.','19.4022006989,-99.1867980957',19.4022006988525,-99.1867980957031,735,0,2,398,340,NULL),(147,'2021-01-27 06:00:02 p. m.','19.4127998352,-99.1547012329',19.412799835205,-99.1547012329101,171,0,2,3,403,6),(148,'2021-01-27 06:00:02 p. m.','19.4256000519,-99.1492996216',19.4256000518798,-99.149299621582,512,4,2,20,420,6),(149,'2021-01-27 06:00:02 p. m.','19.4195995331,-99.1540985107',19.419599533081,-99.1540985107422,560,1,2,22,422,6),(150,'2021-01-27 06:00:02 p. m.','19.4792003632,-99.1480026245',19.4792003631591,-99.1480026245117,561,5,2,23,423,NULL),(151,'2021-01-27 06:00:02 p. m.','19.496099472,-99.1545028687',19.4960994720458,-99.1545028686523,0,7,1,28,428,NULL),(152,'2021-01-27 06:00:02 p. m.','19.5270996094,-99.1690979004',19.527099609375,-99.1690979003906,166,3,2,37,437,NULL),(153,'2021-01-27 06:00:02 p. m.','19.4405994415,-99.1485977173',19.4405994415283,-99.1485977172851,0,7,1,1147,461,6),(154,'2021-01-27 06:00:02 p. m.','19.4657993317,-99.1429977417',19.465799331665,-99.1429977416992,300,10,2,1151,465,NULL),(155,'2021-01-27 06:00:02 p. m.','19.4311008453,-99.1481018066',19.4311008453369,-99.1481018066406,0,6,2,1152,466,6),(156,'2021-01-27 06:00:02 p. m.','19.4316005707,-99.1502990723',19.4316005706787,-99.1502990722656,0,6,1,473,515,6),(157,'2021-01-27 06:00:02 p. m.','19.4304008484,-99.1418991089',19.4304008483886,-99.1418991088867,0,8,1,475,517,6),(158,'2021-01-27 06:00:02 p. m.','19.4381008148,-99.1369018555',19.4381008148193,-99.1369018554687,237,10,2,484,526,6),(159,'2021-01-27 06:00:02 p. m.','19.4309005737,-99.1453018188',19.4309005737304,-99.1453018188476,182,0,2,494,536,6),(160,'2021-01-27 06:00:02 p. m.','19.4232997894,-99.1242980957',19.4232997894287,-99.1242980957031,0,6,1,497,539,15),(161,'2021-01-27 06:00:02 p. m.','19.4442005157,-99.1523971558',19.444200515747,-99.1523971557617,70,4,2,504,546,6),(162,'2021-01-27 06:00:02 p. m.','19.4368000031,-99.1268997192',19.4368000030517,-99.1268997192382,0,4,1,506,548,6),(163,'2021-01-27 06:00:02 p. m.','19.4449996948,-99.1522979736',19.4449996948242,-99.1522979736328,0,0,1,509,551,6),(164,'2021-01-27 06:00:02 p. m.','19.4447002411,-99.112197876',19.4447002410888,-99.1121978759765,0,5,1,544,601,NULL),(165,'2021-01-27 06:00:02 p. m.','19.4771003723,-99.0988998413',19.4771003723144,-99.0988998413085,339,16,2,545,602,NULL),(166,'2021-01-27 06:00:02 p. m.','19.5072002411,-99.0859985352',19.5072002410888,-99.0859985351562,0,0,1,559,616,NULL),(167,'2021-01-27 06:00:02 p. m.','19.4932994843,-99.0914993286',19.4932994842529,-99.0914993286132,0,0,2,560,617,NULL),(168,'2021-01-27 06:00:02 p. m.','19.4652004242,-99.0597991943',19.4652004241943,-99.0597991943359,0,0,1,1074,701,NULL),(169,'2021-01-27 06:00:02 p. m.','19.4747009277,-99.0885009766',19.4747009277343,-99.0885009765625,430,0,2,1078,705,NULL),(170,'2021-01-27 06:00:02 p. m.','19.4981002808,-99.1678009033',19.4981002807617,-99.1678009033203,217,13,2,1084,711,NULL),(171,'2021-01-27 06:00:02 p. m.','19.5023002625,-99.1785964966',19.5023002624511,-99.178596496582,0,8,2,1100,727,NULL),(172,'2021-01-27 06:00:02 p. m.','19.5104007721,-99.198600769',19.5104007720947,-99.1986007690429,0,13,2,1101,728,NULL),(173,'2021-01-27 06:00:02 p. m.','19.4692993164,-99.0852966309',19.4692993164062,-99.0852966308593,503,12,2,1184,735,NULL),(174,'2021-01-27 06:00:02 p. m.','19.5114994049,-99.1976013184',19.5114994049072,-99.1976013183593,0,6,1,1110,757,NULL),(175,'2021-01-27 06:00:02 p. m.','19.4962005615,-99.1594009399',19.4962005615234,-99.1594009399414,0,1,2,1112,759,NULL),(176,'2021-01-27 06:00:02 p. m.','19.4838008881,-99.1119003296',19.4838008880615,-99.1119003295898,0,6,2,1126,773,NULL),(177,'2021-01-27 06:00:02 p. m.','19.467300415,-99.0807037354',19.467300415039,-99.0807037353515,0,6,2,1130,782,NULL),(178,'2021-01-27 06:00:02 p. m.','19.4724998474,-99.1233978271',19.4724998474121,-99.1233978271484,0,8,1,701,801,NULL),(179,'2021-01-27 06:00:02 p. m.','19.4880008698,-99.114402771',19.4880008697509,-99.114402770996,621,5,2,717,817,NULL),(180,'2021-01-27 06:00:02 p. m.','19.4647006989,-99.1262969971',19.4647006988525,-99.1262969970703,0,3,2,720,820,NULL),(181,'2021-01-27 06:00:02 p. m.','19.4351997375,-99.1501998901',19.4351997375488,-99.1501998901367,0,0,1,721,821,6),(182,'2021-01-27 06:00:02 p. m.','19.425699234,-99.170501709',19.4256992340087,-99.1705017089843,0,11,1,728,828,6),(183,'2021-01-27 06:00:02 p. m.','19.4867992401,-99.1179962158',19.4867992401123,-99.1179962158203,0,6,1,737,837,NULL),(184,'2021-01-27 06:00:02 p. m.','19.4239997864,-99.179901123',19.4239997863769,-99.1799011230468,0,7,1,746,846,NULL),(185,'2021-01-27 06:00:02 p. m.','19.4871997833,-99.1138000488',19.4871997833251,-99.1138000488281,534,0,2,754,906,NULL),(186,'2021-01-27 06:00:02 p. m.','19.4930992126,-99.1209030151',19.4930992126464,-99.1209030151367,1549,0,2,758,910,NULL),(187,'2021-01-27 06:00:02 p. m.','19.4269008636,-99.199798584',19.4269008636474,-99.1997985839843,364,0,2,764,916,NULL),(188,'2021-01-27 06:00:02 p. m.','19.4920005798,-99.120300293',19.4920005798339,-99.1203002929687,1412,0,2,777,929,NULL),(189,'2021-01-27 06:00:02 p. m.','19.4272994995,-99.1613998413',19.4272994995117,-99.1613998413085,0,2,2,523,1011,6),(190,'2021-01-27 06:00:02 p. m.','19.2964992523,-99.1852035522',19.2964992523193,-99.185203552246,511,12,2,533,1059,NULL),(191,'2021-01-27 06:00:02 p. m.','19.2791004181,-99.1691970825',19.2791004180908,-99.1691970825195,428,0,2,1254,1065,NULL),(192,'2021-01-27 06:00:02 p. m.','19.4990005493,-99.1195983887',19.4990005493164,-99.1195983886718,0,0,2,1256,1067,NULL),(193,'2021-01-27 06:00:02 p. m.','19.3645992279,-99.1819992065',19.3645992279052,-99.1819992065429,483,0,2,1044,1084,3),(194,'2021-01-27 06:00:02 p. m.','19.4470996857,-99.1530990601',19.4470996856689,-99.1530990600585,0,0,1,1248,1121,6),(195,'2021-01-27 06:00:02 p. m.','19.4412994385,-99.1548995972',19.4412994384765,-99.1548995971679,257,2,2,1284,1256,6),(196,'2021-01-27 06:00:02 p. m.','19.4976005554,-99.1194000244',19.4976005554199,-99.119400024414,0,0,1,1072,1309,NULL),(197,'2021-01-27 06:00:02 p. m.','19.3890991211,-99.0494995117',19.3890991210937,-99.0494995117187,183,9,2,1216,2315,NULL),(198,'2021-01-27 06:00:02 p. m.','19.3936004639,-99.1320037842',19.3936004638671,-99.1320037841796,507,9,2,1218,2317,3),(199,'2021-01-27 06:00:02 p. m.','19.3976993561,-99.1088027954',19.3976993560791,-99.1088027954101,0,6,2,1225,2341,NULL),(200,'2021-01-27 06:00:02 p. m.','19.3892993927,-99.0591964722',19.3892993927001,-99.0591964721679,1845,0,2,1226,2342,NULL),(201,'2021-01-27 06:00:02 p. m.','19.3957996368,-99.0932006836',19.3957996368408,-99.0932006835937,331,13,2,1227,2343,NULL),(202,'2021-01-27 06:00:02 p. m.','19.4034996033,-99.1698989868',19.4034996032714,-99.1698989868164,0,7,2,1238,2347,6),(203,'2021-01-27 06:00:02 p. m.','19.3908996582,-99.0473022461',19.3908996582031,-99.0473022460937,0,0,2,1024,2351,NULL),(204,'2021-01-27 06:00:02 p. m.','19.3973007202,-99.104598999',19.3973007202148,-99.1045989990234,0,7,2,10002,2358,NULL),(205,'2021-01-27 06:00:02 p. m.','19.3938999176,-99.1374969482',19.3938999176025,-99.1374969482422,0,14,2,1232,2363,3),(206,'2021-01-27 06:00:02 p. m.','19.3950996399,-99.1457977295',19.3950996398925,-99.1457977294922,276,0,2,1235,2366,3);
/*!40000 ALTER TABLE `tb_ubicaciones` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-12  0:43:49
