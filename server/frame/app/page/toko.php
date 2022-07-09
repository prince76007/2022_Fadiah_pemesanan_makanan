<?php

include '../../include/all_include.php';	
if (!(isset($_GET['maps'])))
{
	?>
<a href="index.php?sort=a" class="btn btn-primary"><i class="fas fa-magic mr-1"></i>A-z</a>
<a href="index.php?sort=b" class="btn btn-primary">z-a <i class="fas fa-magic ml-1"></i></a>
<br>
<br>
	<?php
}
berita("4","data_lokasi_penyewaan","id_lokasi_lokasi_penyewaan","nama_lokasi","no_telepon","foto","deskripsi");

if (isset($_GET['maps']))
{
echo "<br>";
maps("data_lokasi_penyewaan","id_lokasi_lokasi_penyewaan","nama_lokasi","lat","lng","no_telepon","alamat","nama_pengelola","foto");
echo "<br>";
komentar();
}
?>
