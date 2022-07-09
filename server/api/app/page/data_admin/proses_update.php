<?php 
require_once('../../../include/all_include.php');

$id_admin=isset($_POST["id_admin"]) ? $_POST["id_admin"]:"";
$nama=isset($_POST["nama"]) ? $_POST["nama"]:"";
$username=isset($_POST["username"]) ? $_POST["username"]:"";
$password=isset($_POST["password"]) ? $_POST["password"]:"";


$sql = "UPDATE data_admin SET 
nama=?,
username=?,
password=?,

WHERE id_admin=?";

$stmt = $dbh->prepare($sql);
$stmt->execute([
$nama,
$username,
$password,

$id_admin]);
$resp = [];
$resp["status"]="success";
echo (json_encode($resp)) 
?>
