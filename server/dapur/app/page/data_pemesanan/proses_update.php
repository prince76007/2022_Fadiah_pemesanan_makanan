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

$id_pemesanan = xss($_POST['id_pemesanan']);

$alamat_pengiriman = xss($_POST['alamat_pengiriman']);
$status = xss($_POST['status']);


$query = mysql_query("update data_pemesanan set 
status='$status'

where id_pemesanan='$id_pemesanan' ") or die(mysql_error());

if ($query) {
    ?>
    <script>location.href = "<?php index(); ?>?input=popup_edit";</script>
    <?php
} else {
    echo "GAGAL DIPROSES";
}
?>
