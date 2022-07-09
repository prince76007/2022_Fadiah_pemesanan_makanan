<?php
require_once('../../../include/all_include.php');
$resp = [];
$resp["status"] = "success";
$resp["result"] = array();

if (isset($_POST['berdasarkan']) && !empty($_POST['berdasarkan']) && isset($_POST['isi']) && !empty($_POST['isi'])) {
	$berdasarkan =  mysql_real_escape_string($_POST['berdasarkan']);
	$isi =  mysql_real_escape_string($_POST['isi']);
	$limit =  mysql_real_escape_string($_POST['limit']);
	$hal =  mysql_real_escape_string($_POST['hal']);
	if (isset($_POST['dari']) && !empty($_POST['dari']) && isset($_POST['sampai']) && !empty($_POST['sampai'])) {
		$dari =  mysql_real_escape_string($_POST['dari']);
		$sampai =  mysql_real_escape_string($_POST['sampai']);
		$query = "SELECT * FROM data_pemesanan where $berdasarkan like '%$isi%' ORDER BY tanggal DESC";
	} else {
		if ($limit == "admin") {
			$query = "SELECT * FROM data_pemesanan where $berdasarkan like '%$isi%' ORDER BY tanggal DESC";
		} else {
			if ($isi == "selesai") {
				$query = "SELECT * FROM data_pemesanan where status <> 'pengiriman' and id_pelanggan='$limit' ORDER BY tanggal DESC";
			} else {
				$query = "SELECT * FROM data_pemesanan where $berdasarkan like '%$isi%' and id_pelanggan='$limit' ORDER BY tanggal DESC";
			}
		}
	}
} else {
	$query = "SELECT * from data_pemesanan ORDER BY tanggal DESC";
}

function get_data_pemesanan($tanggal)
{
	global $dbh;
	$stmt = $dbh->prepare("SELECT * FROM data_pemesanan where tanggal='$tanggal'");
	$stmt->execute();
	$result = $stmt->fetchAll(PDO::FETCH_ASSOC);
	return $result;
}


function get_nomor_antrian($tanggal, $id_pemesanan)
{
	$data_pemesanan = get_data_pemesanan($tanggal);
	foreach ($data_pemesanan as $nomor_antrian => $data) {
		if ($data['id_pemesanan'] == $id_pemesanan) {
			return $nomor_antrian + 1;
		}
	}
	return "-";
}
$id_pemesanan="";
$total = "";
$proses = mysql_query($query);
while ($data = mysql_fetch_array($proses)) {

	$id_pemesanan = $data["id_pemesanan"];
	$hasil['id_pemesanan'] = $id_pemesanan;
	$hasil['tanggal'] = "<b>" . format_indo($data["tanggal"]) . "</b>";
	$id_pelanggan = $data["id_pelanggan"];
	$hasil['id_pelanggan'] = baca_database("", "nama", "select * from data_pelanggan where id_pelanggan='$id_pelanggan'");
	$total = baca_database("", "total", "select sum(jumlah * harga) as total from data_detail_pemesanan where id_pemesanan = '$id_pemesanan'");

	$hasil['total_bayar'] = "<b>Rp." . number_format($total) . "</b><br>----------------------------------------";
	$hasil['nomor_antrian'] = get_nomor_antrian($data["tanggal"], $id_pemesanan);


	if ($limit == "admin") {
		$hasil['lat'] = $data["lng"] . "," . $data["lat"];
		$hasil['lng'] = baca_database("", "no_telepon", "select * from data_pelanggan where id_pelanggan='$id_pelanggan'");
	} else {
		$hasil['lat'] = $data["lng"] . "," . $data["lat"];
		$hasil['lng'] = baca_database("", "no_telepon", "select * from data_pelanggan where id_pelanggan='$id_pelanggan'");
	}
	$st = $data["status"];
	if ($st == "pengiriman") {
		$st = "Pemesanan";
	}
	$hasil['alamat_pengiriman'] = $data["alamat_pengiriman"];
	$hasil['status'] = "<b>" . $st . "</b><br>----------------------------------------";

	array_push($resp["result"], $hasil);
}

mysql_query("update data_pemesanan set total_bayar='$total' where id_pemesanan='$id_pemesanan'");

json_print($resp);
