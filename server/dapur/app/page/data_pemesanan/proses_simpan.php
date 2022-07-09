<?php
include '../../../include/all_include.php';

if (!isset($_POST['id_pemesanan'])) {
        
    ?>
    <script>
        alert("AKSES DITOLAK");
        location.href = "index.php";
    </script>
    <?php
    die();
}


$id_pemesanan = id_otomatis("data_pemesanan", "id_pemesanan", "10");
              $tanggal=xss($_POST['tanggal']);
              $id_pelanggan=xss($_POST['id_pelanggan']);
              $total_bayar=xss($_POST['total_bayar']);
              $lat=xss($_POST['lat']);
              $lng=xss($_POST['lng']);
              $alamat_pengiriman=xss($_POST['alamat_pengiriman']);
              $status=xss($_POST['status']);


$query = mysql_query("insert into data_pemesanan values (
'$id_pemesanan'
 ,'$tanggal'
 ,'$id_pelanggan'
 ,'$total_bayar'
 ,'$lat'
 ,'$lng'
 ,'$alamat_pengiriman'
 ,'$status'

)");

if ($query) {
    ?>
    <script>location.href = "<?php index(); ?>?input=popup_tambah";</script>
    <?php
} else {
    echo "GAGAL DIPROSES";
}
?>
