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


$id_detail_pemesanan = id_otomatis("data_detail_pemesanan", "id_detail_pemesanan", "10");
              $id_pemesanan=xss($_POST['id_pemesanan']);
              $id_menu_makanan=xss($_POST['id_menu_makanan']);
              $jumlah=xss($_POST['jumlah']);
              $harga=xss($_POST['harga']);


$query = mysql_query("insert into data_detail_pemesanan values (
'$id_detail_pemesanan'
 ,'$id_pemesanan'
 ,'$id_menu_makanan'
 ,'$jumlah'
 ,'$harga'

)");

if ($query) {
    ?>
    <script>location.href = "<?php index(); ?>?input=popup_tambah";</script>
    <?php
} else {
    echo "GAGAL DIPROSES";
}
?>
