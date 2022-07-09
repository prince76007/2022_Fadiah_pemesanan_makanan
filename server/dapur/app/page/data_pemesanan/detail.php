
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
            $sql = mysql_query("SELECT * FROM data_pemesanan where id_pemesanan = '$proses'");
            $data = mysql_fetch_array($sql);
            ?>
           <!--h
            <tr>
                <td class="clleft" width="25%">Id Pemesanan </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo $data['id_pemesanan']; ?></td>	
            </tr>
           h-->

            <tr>
                <td class="clleft" width="25%">Tanggal </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo format_indo($data['tanggal']); ?></td>
            </tr>
            <tr>
                <td class="clleft" width="25%">Nama </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo baca_database("","nama","select * from data_pelanggan where id_pelanggan='$data[id_pelanggan]'")  ?></td>
            </tr>
            <tr>
                <td class="clleft" width="25%">Total Bayar </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo $data['total_bayar']; ?></td>
            </tr>
            <tr>
                <td class="clleft" width="25%">Lat </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo $data['lat']; ?></td>
            </tr>
            <tr>
                <td class="clleft" width="25%">Lng </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo $data['lng']; ?></td>
            </tr>
            <tr>
                <td class="clleft" width="25%">Alamat Pengiriman </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo $data['alamat_pengiriman']; ?></td>
            </tr>
            <tr>
                <td class="clleft" width="25%">Status </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo $data['status']; ?></td>
            </tr>




            </tbody>
        </table>
    </div>
</div>
