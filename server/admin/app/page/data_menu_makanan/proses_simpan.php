<?php
include '../../../include/all_include.php';

if (!isset($_POST['id_menu_makanan'])) {
        
    ?>
    <script>
        alert("AKSES DITOLAK");
        location.href = "index.php";
    </script>
    <?php
    die();
}


$id_menu_makanan = id_otomatis("data_menu_makanan", "id_menu_makanan", "10");
              $nama=xss($_POST['nama']);
              $id_kategori=xss($_POST['id_kategori']);
              $jumlah=xss($_POST['jumlah']);
              $harga=xss($_POST['harga']);
              $foto=upload('foto');
              $keterangan=xss($_POST['keterangan']);


$query = mysql_query("insert into data_menu_makanan values (
'$id_menu_makanan'
 ,'$nama'
 ,'$id_kategori'
 ,'$jumlah'
 ,'$harga'
 ,'$foto'
 ,'$keterangan'

)");

if ($query) {
    ?>
    <script>location.href = "<?php index(); ?>?input=popup_tambah";</script>
    <?php
} else {
    echo "GAGAL DIPROSES";
}
?>
