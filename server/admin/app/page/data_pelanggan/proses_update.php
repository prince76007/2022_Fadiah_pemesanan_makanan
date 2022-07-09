<?php
include '../../../include/all_include.php';

if (!isset($_POST['id_pelanggan'])) {
        
    ?>
    <script>
        alert("AKSES DITOLAK");
        location.href = "index.php";
    </script>
    <?php
    die();
}

$id_pelanggan = xss($_POST['id_pelanggan']);
$nama = xss($_POST['nama']);
$alamat = xss($_POST['alamat']);
$no_telepon = xss($_POST['no_telepon']);
$username = xss($_POST['username']);
$password = md5($_POST['password']);


$query = mysql_query("update data_pelanggan set 
nama='$nama',
alamat='$alamat',
no_telepon='$no_telepon',
username='$username',
password='$password'

where id_pelanggan='$id_pelanggan' ") or die(mysql_error());

if ($query) {
    ?>
    <script>location.href = "<?php index(); ?>?input=popup_edit";</script>
    <?php
} else {
    echo "GAGAL DIPROSES";
}
?>
