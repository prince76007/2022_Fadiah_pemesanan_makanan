<?php
require_once('../../../include/all_include.php');
$resp = [];
$resp["status"] = "success";
$resp["result"] = array();
$limit = "";
if (isset($_POST['berdasarkan']) && !empty($_POST['berdasarkan']) && isset($_POST['isi']) && !empty($_POST['isi'])) {
	$berdasarkan =  mysql_real_escape_string($_POST['berdasarkan']);
	$isi =  mysql_real_escape_string($_POST['isi']);
	$limit =  mysql_real_escape_string($_POST['limit']);
	$hal =  mysql_real_escape_string($_POST['hal']);
	if (isset($_POST['dari']) && !empty($_POST['dari']) && isset($_POST['sampai']) && !empty($_POST['sampai'])) {
		$dari =  mysql_real_escape_string($_POST['dari']);
		$sampai =  mysql_real_escape_string($_POST['sampai']);
		$query = "SELECT * FROM data_detail_pemesanan where $berdasarkan like '%$isi%'";
	} else {
		$query = "SELECT * FROM data_detail_pemesanan where $berdasarkan like '%$isi%'";
	}
} else {
	$query = "select * from data_detail_pemesanan";
}

$jumlah = 0;
$total = 0;
$proses = mysql_query($query);
while ($data = mysql_fetch_array($proses)) {

	$id_menu_makanan = $data["id_menu_makanan"];
	if ($limit ==  $data["id_pemesanan"]) {
		$id_detail_pemesanan = baca_database("", "foto", "select * from data_menu_makanan where id_menu_makanan='$id_menu_makanan'");
		$hasil['id_pemesanan'] = $data["id_pemesanan"];
	} else {
		$id_detail_pemesanan = "detail";
		$hasil['id_pemesanan'] = baca_database("", "foto", "select * from data_menu_makanan where id_menu_makanan='$id_menu_makanan'");
	}


	$hasil['id_detail_pemesanan'] = $id_detail_pemesanan;


	$hasil['id_menu_makanan'] = baca_database("", "nama", "select * from data_menu_makanan where id_menu_makanan='$id_menu_makanan'");
	$hasil['jumlah'] = "Jumlah : " . $data["jumlah"];
	$hasil['harga'] = "Harga : Rp." . number_format($data["harga"]);
	$hasil['catatan'] = "Catatan : " . $data["catatan"];

	$jumlah = $jumlah + $data["jumlah"];
	$total = $total + ($data["harga"] * $data["jumlah"]);
	array_push($resp["result"], $hasil);
}


$id_detail_pemesanan = "total";
$hasil['id_detail_pemesanan'] = $id_detail_pemesanan;
$hasil['id_pemesanan'] = "";
$id_menu_makanan = "";
$hasil['id_menu_makanan'] = "-----------------------<br>Detail Informasi Pembayaran : ";
$hasil['jumlah'] = "Jumlah : " . $jumlah . " Porsi";
$hasil['harga'] = "Total Harga : Rp." . number_format($total) . "<br><b>-----------------------</b><br><br>";
$hasil['catatan'] = "";

array_push($resp["result"], $hasil);



json_print($resp);
