<?php 
require_once('../../../include/all_include.php');

$id_pemesanan=date('Ymdhis');
$tanggal=date('Y-m-d');
$id_pelanggan=isset($_POST["id_pelanggan"]) ? $_POST["id_pelanggan"]:"";
$total_bayar=baca_database("","total_bayar","select *,sum(jumlah * harga) as total_bayar from data_detail_pemesanan where id_pemesanan='$id_pelanggan'");
$lat=isset($_POST["lat"]) ? $_POST["lat"]:"";
$lng=isset($_POST["lng"]) ? $_POST["lng"]:"";
$alamat_pengiriman=isset($_POST["alamat_pengiriman"]) ? $_POST["alamat_pengiriman"]:"";
$status=isset($_POST["status"]) ? $_POST["status"]:"";



$query=mysql_query("insert into data_pemesanan values (
'$id_pemesanan'
,'$tanggal'
,'$id_pelanggan'
,'0'
,'0'
,'0'
,'0'
,'0'
,'$alamat_pengiriman'
,'$status'

)");




$query=mysql_query("update data_detail_pemesanan  set id_pemesanan='$id_pemesanan' where id_pemesanan='$id_pelanggan'");

$total = baca_database("", "total", "select sum(jumlah * harga) as total from data_detail_pemesanan where id_pemesanan = '$id_pelanggan'");

$query=mysql_query("update data_pemesanan  set total_bayar='$total' where id_pemesanan='$id_pelanggan'");

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
