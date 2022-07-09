<?php 
require_once('../../../include/all_include.php');

$id_pemesanan=isset($_POST["id_pemesanan"]) ? $_POST["id_pemesanan"]:"";
$status=isset($_POST["status"]) ? $_POST["status"]:"";


$sql = "UPDATE data_pemesanan SET 
status=?

WHERE id_pemesanan=?";

$stmt = $dbh->prepare($sql);
$stmt->execute([
$status,

$id_pemesanan]);
$resp = [];
$resp["status"]="success";
echo (json_encode($resp)) 
?>
