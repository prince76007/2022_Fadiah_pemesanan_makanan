<?php
include '../../../include/all_include.php';

if (!isset($_POST['id_admin'])) {
        
    ?>
    <script>
        alert("AKSES DITOLAK");
        location.href = "index.php";
    </script>
    <?php
    die();
}

$id_admin = xss($_POST['id_admin']);
$nama = xss($_POST['nama']);
$username = xss($_POST['username']);
$password = md5($_POST['password']);


$query = mysql_query("update data_admin set 
nama='$nama',
username='$username',
password='$password'

where id_admin='$id_admin' ") or die(mysql_error());

if ($query) {
    ?>
    <script>location.href = "<?php index(); ?>?input=popup_edit";</script>
    <?php
} else {
    echo "GAGAL DIPROSES";
}
?>
