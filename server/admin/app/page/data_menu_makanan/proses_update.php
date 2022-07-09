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

$id_menu_makanan = xss($_POST['id_menu_makanan']);
$nama = xss($_POST['nama']);
$id_kategori = xss($_POST['id_kategori']);
$jumlah = xss($_POST['jumlah']);
$harga = xss($_POST['harga']);
$foto=($_FILES['foto']['name']); if (empty($foto)){$foto = $_POST['foto1'];} else { $foto = upload('foto');};
$keterangan = xss($_POST['keterangan']);


$query = mysql_query("update data_menu_makanan set 
nama='$nama',
id_kategori='$id_kategori',
jumlah='$jumlah',
harga='$harga',
foto='$foto',
keterangan='$keterangan'

where id_menu_makanan='$id_menu_makanan' ") or die(mysql_error());

if ($query) {
    ?>
    <script>location.href = "<?php index(); ?>?input=popup_edit";</script>
    <?php
} else {
    echo "GAGAL DIPROSES";
}
?>
