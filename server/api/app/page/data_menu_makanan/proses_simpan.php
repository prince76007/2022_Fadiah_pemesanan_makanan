<?php 
require_once('../../../include/all_include.php');

$id_menu_makanan=isset($_POST["id_menu_makanan"]) ? $_POST["id_menu_makanan"]:"";
$nama=isset($_POST["nama"]) ? $_POST["nama"]:"";
$id_kategori=isset($_POST["id_kategori"]) ? $_POST["id_kategori"]:"";
$jumlah=isset($_POST["jumlah"]) ? $_POST["jumlah"]:"";
$harga=isset($_POST["harga"]) ? $_POST["harga"]:"";
$foto=isset($_POST["foto"]) ? $_POST["foto"]:"";
$keterangan=isset($_POST["keterangan"]) ? $_POST["keterangan"]:"";


$query=mysql_query("insert into data_menu_makanan values (
'$id_menu_makanan'
,'$nama'
,'$id_kategori'
,'$jumlah'
,'$harga'
,'$foto'
,'$keterangan'

)");

$resp = [];
if($query){
	$resp["status"]="success";
}
else
{
	$resp["status"]="gagal";
}

echo (json_encode($resp)) 
?>
