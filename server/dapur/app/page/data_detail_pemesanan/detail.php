
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
            $sql = mysql_query("SELECT * FROM data_detail_pemesanan where id_detail_pemesanan = '$proses'");
            $data = mysql_fetch_array($sql);
            ?>
           <!--h
            <tr>
                <td class="clleft" width="25%">Id Detail Pemesanan </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo $data['id_detail_pemesanan']; ?></td>	
            </tr>
           h-->

            <tr>
                <td class="clleft" width="25%">Tanggal </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo baca_database("","tanggal","select * from data_pemesanan where id_pemesanan='$data[id_pemesanan]'")  ?></td>
            </tr>
            <tr>
                <td class="clleft" width="25%">Nama </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo baca_database("","nama","select * from data_menu_makanan where id_menu_makanan='$data[id_menu_makanan]'")  ?></td>
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




            </tbody>
        </table>
    </div>
</div>
