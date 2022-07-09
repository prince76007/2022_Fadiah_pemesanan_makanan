<?php 
require_once('../../../include/all_include.php');

$id_pelanggan=isset($_POST["id_pelanggan"]) ? $_POST["id_pelanggan"]:"";
$nama=isset($_POST["nama"]) ? $_POST["nama"]:"";
$alamat=isset($_POST["alamat"]) ? $_POST["alamat"]:"";
$no_telepon=isset($_POST["no_telepon"]) ? $_POST["no_telepon"]:"";
$username=isset($_POST["username"]) ? $_POST["username"]:"";
$password=isset($_POST["password"]) ? $_POST["password"]:"";


$password = md5($password);

$sql = "UPDATE data_pelanggan SET 
nama=?,
alamat=?,
no_telepon=?,
username=?,
password=?,

WHERE id_pelanggan=?";

$stmt = $dbh->prepare($sql);
$stmt->execute([
$nama,
$alamat,
$no_telepon,
$username,
$password,

$id_pelanggan]);
$resp = [];
$resp["status"]="success";
echo (json_encode($resp)) 
?>
