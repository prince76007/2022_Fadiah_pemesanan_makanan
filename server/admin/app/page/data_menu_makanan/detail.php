
<a href="<?php index(); ?>">
    <?php btn_kembali(' KEMBALI'); ?>
</a>

<br><br>

<div class="content-box">
    <div class="content-box-content">
        <table <?php tabel_in(100, '%', 0, 'center'); ?>>		
            <tbody>
               
                <?php
                if (!isset($_GET['proses'])) {
                        
                    ?>
                <script>
                    alert("AKSES DITOLAK");
                    location.href = "index.php";
                </script>
                <?php
                die();
            }
            $proses = decrypt(mysql_real_escape_string($_GET['proses']));
            $sql = mysql_query("SELECT * FROM data_menu_makanan where id_menu_makanan = '$proses'");
            $data = mysql_fetch_array($sql);
            ?>
           <!--h
            <tr>
                <td class="clleft" width="25%">Id Menu Makanan </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo $data['id_menu_makanan']; ?></td>	
            </tr>
           h-->

            <tr>
                <td class="clleft" width="25%">Nama </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo $data['nama']; ?></td>
            </tr>
            <tr>
                <td class="clleft" width="25%">Kategori </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo baca_database("","kategori","select * from data_kategori where id_kategori='$data[id_kategori]'")  ?></td>
            </tr>
            <tr>
                <td class="clleft" width="25%">Jumlah </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo $data['jumlah']; ?></td>
            </tr>
            <tr>
                <td class="clleft" width="25%">Harga </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo $data['harga']; ?></td>
            </tr>
            <tr>
                <td class="clleft" width="25%">Foto </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft">
                  <a href="../../../../admin/upload/<?php echo $data['foto']; ?>"><img onerror="this.src='../../../data/image/error/file.png'" width="100"  src="../../../../admin/upload/<?php echo $data['foto']; ?>"></a>
                    <br>
                  <?php echo $data['foto']; ?></td>
            </tr>
            <tr>
                <td class="clleft" width="25%">Keterangan </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo $data['keterangan']; ?></td>
            </tr>




            </tbody>
        </table>
    </div>
</div>
