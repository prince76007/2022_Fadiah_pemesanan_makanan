
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
            $sql = mysql_query("SELECT * FROM data_kategori where id_kategori = '$proses'");
            $data = mysql_fetch_array($sql);
            ?>
           <!--h
            <tr>
                <td class="clleft" width="25%">Id Kategori </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo $data['id_kategori']; ?></td>	
            </tr>
           h-->

            <tr>
                <td class="clleft" width="25%">Kategori </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo $data['kategori']; ?></td>
            </tr>




            </tbody>
        </table>
    </div>
</div>
