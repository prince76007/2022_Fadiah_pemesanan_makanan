<?php
include '../../../include/all_include.php';

if (!isset($_POST['id_kategori'])) {
        
    ?>
    <script>
        alert("AKSES DITOLAK");
        location.href = "index.php";
    </script>
    <?php
    die();
}

$id_kategori = xss($_POST['id_kategori']);
$kategori = xss($_POST['kategori']);


$query = mysql_query("update data_kategori set 
kategori='$kategori'

where id_kategori='$id_kategori' ") or die(mysql_error());

if ($query) {
    ?>
    <script>location.href = "<?php index(); ?>?input=popup_edit";</script>
    <?php
} else {
    echo "GAGAL DIPROSES";
}
?>
