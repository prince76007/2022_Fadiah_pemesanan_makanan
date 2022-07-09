<?php 
require_once('../../../include/all_include.php');

$id_kategori=isset($_POST["id_kategori"]) ? $_POST["id_kategori"]:"";
$kategori=isset($_POST["kategori"]) ? $_POST["kategori"]:"";


$sql = "UPDATE data_kategori SET 
kategori=?,

WHERE id_kategori=?";

$stmt = $dbh->prepare($sql);
$stmt->execute([
$kategori,

$id_kategori]);
$resp = [];
$resp["status"]="success";
echo (json_encode($resp)) 
?>
