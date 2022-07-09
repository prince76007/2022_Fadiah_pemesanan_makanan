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


$id_kategori = id_otomatis("data_kategori", "id_kategori", "10");
              $kategori=xss($_POST['kategori']);


$query = mysql_query("insert into data_kategori values (
'$id_kategori'
 ,'$kategori'

)");

if ($query) {
    ?>
    <script>location.href = "<?php index(); ?>?input=popup_tambah";</script>
    <?php
} else {
    echo "GAGAL DIPROSES";
}
?>
