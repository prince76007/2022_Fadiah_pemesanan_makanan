<?php 
require_once('../../../include/all_include.php');

$id_detail_pemesanan=isset($_POST["id_detail_pemesanan"]) ? $_POST["id_detail_pemesanan"]:"";
$id_pemesanan=isset($_POST["id_pemesanan"]) ? $_POST["id_pemesanan"]:"";
$id_menu_makanan=isset($_POST["id_menu_makanan"]) ? $_POST["id_menu_makanan"]:"";
$jumlah=isset($_POST["jumlah"]) ? $_POST["jumlah"]:"";
$harga=isset($_POST["harga"]) ? $_POST["harga"]:"";


$sql = "UPDATE data_detail_pemesanan SET 
id_pemesanan=?,
id_menu_makanan=?,
jumlah=?,
harga=?,

WHERE id_detail_pemesanan=?";

$stmt = $dbh->prepare($sql);
$stmt->execute([
$id_pemesanan,
$id_menu_makanan,
$jumlah,
$harga,

$id_detail_pemesanan]);
$resp = [];
$resp["status"]="success";
echo (json_encode($resp)) 
?>
