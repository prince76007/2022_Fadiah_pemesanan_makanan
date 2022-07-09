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
$jumlah_uang = xss($_POST['jumlah_uang']);
$kembalian = xss($_POST['kembalian']);


$query = mysql_query("update data_pemesanan set 
status='$status',
jumlah_uang='$jumlah_uang',
kembalian='$kembalian'

where id_pemesanan='$id_pemesanan' ") or die(mysql_error());

if ($query) {
    ?>
    <script>
        alert("Berhasil Diproses");
        location.href = "print.php?id_pemesanan=<?php echo $id_pemesanan;?>";</script>
    <?php
} else {
    echo "GAGAL DIPROSES";
}
?>
