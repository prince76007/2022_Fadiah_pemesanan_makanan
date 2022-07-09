<?php 
require_once('../../../include/all_include.php');

$id_menu_makanan=isset($_POST["id_menu_makanan"]) ? $_POST["id_menu_makanan"]:"";
$nama=isset($_POST["nama"]) ? $_POST["nama"]:"";
$id_kategori=isset($_POST["id_kategori"]) ? $_POST["id_kategori"]:"";
$jumlah=isset($_POST["jumlah"]) ? $_POST["jumlah"]:"";
$harga=isset($_POST["harga"]) ? $_POST["harga"]:"";
$foto=isset($_POST["foto"]) ? $_POST["foto"]:"";
$keterangan=isset($_POST["keterangan"]) ? $_POST["keterangan"]:"";


$sql = "UPDATE data_menu_makanan SET 
nama=?,
id_kategori=?,
jumlah=?,
harga=?,
foto=?,
keterangan=?,

WHERE id_menu_makanan=?";

$stmt = $dbh->prepare($sql);
$stmt->execute([
$nama,
$id_kategori,
$jumlah,
$harga,
$foto,
$keterangan,

$id_menu_makanan]);
$resp = [];
$resp["status"]="success";
echo (json_encode($resp)) 
?>
