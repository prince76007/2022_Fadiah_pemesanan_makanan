<?php
include '../../include/all_include.php';	

berita("4","data_lokasi_penyewaan","id_lokasi_lokasi_penyewaan","nama_lokasi","no_telepon","foto","deskripsi");
if (isset($_GET['maps']))
{
echo "<br>";
maps("data_lokasi_penyewaan","id_lokasi_lokasi_penyewaan","nama_lokasi","lat","lng","no_telepon","alamat","nama_pengelola","foto");
echo "<br>";
komentar();
}
?>
