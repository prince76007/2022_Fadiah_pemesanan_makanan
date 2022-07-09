<?php 
require_once('../../../include/all_include.php');
$id_detail_pemesanan=isset($_POST["id_detail_pemesanan"]) ? $_POST["id_detail_pemesanan"]:"";
$sql = "DELETE FROM data_detail_pemesanan WHERE id_detail_pemesanan=?";
$stmt = $dbh->prepare($sql);
$stmt->execute([$id_detail_pemesanan]);
$resp = [];
$resp["status"]="success";
echo (json_encode($resp)) 
?>
