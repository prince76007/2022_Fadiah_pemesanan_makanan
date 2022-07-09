<?php
include '../../../include/all_include.php';

if (!isset($_POST['id_detail_pemesanan'])) {
        
    ?>
    <script>
        alert("AKSES DITOLAK");
        location.href = "index.php";
    </script>
    <?php
    die();
}

$id_detail_pemesanan = xss($_POST['id_detail_pemesanan']);
$id_pemesanan = xss($_POST['id_pemesanan']);
$id_menu_makanan = xss($_POST['id_menu_makanan']);
$jumlah = xss($_POST['jumlah']);
$harga = xss($_POST['harga']);


$query = mysql_query("update data_detail_pemesanan set 
id_pemesanan='$id_pemesanan',
id_menu_makanan='$id_menu_makanan',
jumlah='$jumlah',
harga='$harga'

where id_detail_pemesanan='$id_detail_pemesanan' ") or die(mysql_error());

if ($query) {
    ?>
    <script>location.href = "<?php index(); ?>?input=popup_edit";</script>
    <?php
} else {
    echo "GAGAL DIPROSES";
}
?>
