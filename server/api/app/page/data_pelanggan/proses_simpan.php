<?php 
require_once('../../../include/all_include.php');

$id_pelanggan=isset($_POST["id_pelanggan"]) ? $_POST["id_pelanggan"]:"";
$nama=isset($_POST["nama"]) ? $_POST["nama"]:"";
$alamat=isset($_POST["alamat"]) ? $_POST["alamat"]:"";
$no_telepon=isset($_POST["no_telepon"]) ? $_POST["no_telepon"]:"";
$username=isset($_POST["username"]) ? $_POST["username"]:"";
$password=isset($_POST["password"]) ? $_POST["password"]:"";

$password=md5($password);
$query=mysql_query("insert into data_pelanggan values (
'$id_pelanggan'
,'$nama'
,'$alamat'
,'$no_telepon'
,'$username'
,'$password'

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
