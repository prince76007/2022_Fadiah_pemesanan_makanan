<?php
require_once('../../../include/all_include.php');

$id_detail_pemesanan = isset($_POST["id_detail_pemesanan"]) ? $_POST["id_detail_pemesanan"] : "";
$id_pemesanan = isset($_POST["id_pemesanan"]) ? $_POST["id_pemesanan"] : "";
$id_menu_makanan = isset($_POST["id_menu_makanan"]) ? $_POST["id_menu_makanan"] : "";
$jumlah = isset($_POST["jumlah"]) ? $_POST["jumlah"] : "";
$harga = isset($_POST["harga"]) ? $_POST["harga"] : "";

$catatan = isset($_POST["catatan"]) ? $_POST["catatan"] : "";


$query = mysql_query("insert into data_detail_pemesanan values (
'$id_detail_pemesanan'
,'$id_pemesanan'
,'$id_menu_makanan'
,'$jumlah'
,'$harga'
,'$catatan'

)");

$resp = [];
if ($query) {
	$resp["status"] = "success";
} else {
	$resp["status"] = "gagal";
}

echo (json_encode($resp));
