-- MySQL dump 10.13  Distrib 5.7.30, for osx10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: databases_2022_fadiah_pemesanan_makanan
-- ------------------------------------------------------
-- Server version	5.7.30

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
-- Table structure for table `data_admin`
--

DROP TABLE IF EXISTS `data_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data_admin` (
  `id_admin` varchar(50) NOT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_admin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data_admin`
--

LOCK TABLES `data_admin` WRITE;
/*!40000 ALTER TABLE `data_admin` DISABLE KEYS */;
INSERT INTO `data_admin` VALUES ('ADM20210720060640826','admin','admin','21232f297a57a5a743894a0e4a801fc3'),('ADM20220118062439907','admin2','admin2','c84258e9c39059a89ab77d846ddab909'),('ADM20220301044859816','Pembungkus','pembungkus','0d9856a1c2c2e2007d0a8a307c8cb562');
/*!40000 ALTER TABLE `data_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `data_detail_pemesanan`
--

DROP TABLE IF EXISTS `data_detail_pemesanan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data_detail_pemesanan` (
  `id_detail_pemesanan` varchar(50) DEFAULT NULL,
  `id_pemesanan` varchar(50) DEFAULT NULL,
  `id_menu_makanan` varchar(100) DEFAULT NULL,
  `jumlah` int(11) DEFAULT NULL,
  `harga` int(11) DEFAULT NULL,
  `catatan` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data_detail_pemesanan`
--

LOCK TABLES `data_detail_pemesanan` WRITE;
/*!40000 ALTER TABLE `data_detail_pemesanan` DISABLE KEYS */;
INSERT INTO `data_detail_pemesanan` VALUES ('DETPEL2022062415165043224062022223816039','20220624033834','MEN20220118081603785',1,10000,''),('DETPEL2022062415165043224062022223819997','20220624033834','MEN20220123091621194',2,10000,''),('DETPEL2022062415165043224062022223823594','20220624033834','MEN20220123091828182',1,10000,''),('DETPEL2022062415165043224062022233008506','20220624043041','MEN20220118081603785',2,10000,''),('DETPEL2022062415165043224062022233018585','20220624043041','MEN20220123091621194',2,10000,''),('DETPEL2022062415165043224062022233022838','20220624043041','MEN20220123091828182',1,10000,''),('DETPEL2022062415165043224062022233948105','20220624043957','MEN20220118081603785',1,10000,''),('DETPEL2022062415165043224062022233951416','20220624043957','MEN20220118081603785',2,10000,'');
/*!40000 ALTER TABLE `data_detail_pemesanan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `data_kategori`
--

DROP TABLE IF EXISTS `data_kategori`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data_kategori` (
  `id_kategori` varchar(50) DEFAULT NULL,
  `kategori` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data_kategori`
--

LOCK TABLES `data_kategori` WRITE;
/*!40000 ALTER TABLE `data_kategori` DISABLE KEYS */;
INSERT INTO `data_kategori` VALUES ('KAT20220118081416557','Makanan'),('KAT20220118081429168','Minuman'),('KAT20220118083435779','Lauk-Lauk');
/*!40000 ALTER TABLE `data_kategori` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `data_menu_makanan`
--

DROP TABLE IF EXISTS `data_menu_makanan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data_menu_makanan` (
  `id_menu_makanan` varchar(50) DEFAULT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `id_kategori` varchar(50) DEFAULT NULL,
  `jumlah` int(11) DEFAULT NULL,
  `harga` int(11) DEFAULT NULL,
  `foto` varchar(100) DEFAULT NULL,
  `keterangan` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data_menu_makanan`
--

LOCK TABLES `data_menu_makanan` WRITE;
/*!40000 ALTER TABLE `data_menu_makanan` DISABLE KEYS */;
INSERT INTO `data_menu_makanan` VALUES ('MEN20220118081603785','Nasi Ayam Bakar','KAT20220118081416557',999,10000,'1642493763-78470-nasi ayam bakar.jpg','Nasi\r\n1 Potong Ayam Bakar\r\nSayur\r\nSambal'),('MEN20220123091621194','Nasi Ayam Goreng','KAT20220118081416557',999,10000,'1642929381-98054-nasi ayam goreng.jpg','Nasi \r\n1 Potong Ayam Goreng\r\nSayur\r\nSambal'),('MEN20220123091828182','Nasi Ayam Gulai','KAT20220118081416557',999,10000,'1642929508-61883-nasi ayam gulai.jpg','Nasi \r\n1 Potong Ayam Gulai\r\nSayur\r\nSambal'),('MEN20220123091946915','Nasi Rendang','KAT20220118081416557',999,12000,'1642929586-70196-nasi rendang.jpg','Nasi \r\n 1 Potong Rendang Daging\r\nSayur\r\nSambal'),('MEN20220123092348980','Nasi Dendeng','KAT20220118081416557',999,12000,'1642929828-24674-nasi dendeng.jpg','Nasi\r\n1 Potong Dendeng Daging\r\nSayur\r\nSambal'),('MEN20220123092503853','Nasi Nila Goreng','KAT20220118081416557',999,10000,'1642929903-51045-nasi nila goreng.jpg','Nasi\r\n1 Potong Ikan Nila Goreng \r\nSayur\r\nSambal'),('MEN20220123092706419','Nasi Nila Bakar','KAT20220118081416557',999,12000,'1642930026-77491-nasi nila bakar.jpg','Nasi \r\n1Potong Nila Bakar \r\nSayur\r\nSambal'),('MEN20220123092749752','Es Jeruk','KAT20220118081429168',999,7000,'1642930069-95588-es jeruk.jpg','Es Jeruk Peras '),('MEN20220123092851190','Es Teh Manis','KAT20220118081429168',999,7000,'1642930131-21783-es teh manis.jpg','Es teh Manis'),('MEN20220123092942375','Es Campur','KAT20220118081429168',999,10000,'1642930182-67054-es campur.jpg','Es Campur ,buah,cendol dll'),('MEN20220123093318906','Nasi Tambo','KAT20220118083435779',999,5000,'1642930398-59431-nasi tambo.jpeg','1 Porsi Nasi Putih'),('MEN20220123093413566','Gulai Tunjang','KAT20220118083435779',999,7000,'1642930453-81963-tunjang.jpg','1 Porsi Gulai Tunjang'),('MEN20220123093816247','Gulai Cincang','KAT20220118083435779',999,7000,'1642930696-16075-gulai cincang.jpg','1 Porsi Gulai Cincang'),('MEN20220123094043368','Gulai Jengkol','KAT20220118083435779',999,7000,'1642930843-88982-gulai jengkol.jpg','1 Porsi Gulai Jengkol');
/*!40000 ALTER TABLE `data_menu_makanan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `data_pelanggan`
--

DROP TABLE IF EXISTS `data_pelanggan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data_pelanggan` (
  `id_pelanggan` varchar(50) DEFAULT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `alamat` tinytext,
  `no_telepon` varchar(50) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data_pelanggan`
--

LOCK TABLES `data_pelanggan` WRITE;
/*!40000 ALTER TABLE `data_pelanggan` DISABLE KEYS */;
INSERT INTO `data_pelanggan` VALUES ('PEL20220118080627200','kurniawan','jambi','085278888','kurniawan','16ca55b4f29157780eabc6244f49d442'),('PEL20220118092228243','Wahyu','Jambi','08973882691','wahyu','32c9e71e866ecdbc93e497482aa6779f'),('PEL20220624151650432','pelayan','pelayan','pelayan','pelayan','511cc40443f2a1ab03ab373b77d28091');
/*!40000 ALTER TABLE `data_pelanggan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `data_pemesanan`
--

DROP TABLE IF EXISTS `data_pemesanan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data_pemesanan` (
  `id_pemesanan` varchar(50) DEFAULT NULL,
  `tanggal` date DEFAULT NULL,
  `id_pelanggan` varchar(50) DEFAULT NULL,
  `total_bayar` int(11) DEFAULT NULL,
  `jumlah_uang` int(11) DEFAULT NULL,
  `kembalian` int(11) DEFAULT NULL,
  `lat` varchar(50) DEFAULT NULL,
  `lng` varchar(50) DEFAULT NULL,
  `alamat_pengiriman` varchar(100) DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data_pemesanan`
--

LOCK TABLES `data_pemesanan` WRITE;
/*!40000 ALTER TABLE `data_pemesanan` DISABLE KEYS */;
INSERT INTO `data_pemesanan` VALUES ('20220624033834','2022-06-24','PEL20220624151650432',40000,5000,39000,'0','0','1','lunas'),('20220624043041','2022-06-24','PEL20220624151650432',50000,0,0,'0','0','3','pengiriman'),('20220624043957','2022-06-24','PEL20220624151650432',30000,0,0,'0','0','','pengiriman');
/*!40000 ALTER TABLE `data_pemesanan` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-27 16:51:18
