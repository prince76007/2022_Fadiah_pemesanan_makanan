
<a href="<?php index(); ?>">
    <?php btn_kembali(' KEMBALI KE HALAMAN SEBELUMNYA'); ?>
</a>

    <div class="col-sm-12" style="margin-bottom: 20px; margin-top: 20px;">
    <div class="alert alert-warning">
        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>
        <strong>Edit Data Detail Pemesanan </strong>
        <hr class="message-inner-separator">
            <p>Silahkan Update Data Detail Pemesanan  dibawah ini.</p>
        </div>
    </div>


<div class="content-box">
    <form action="proses_update.php"  enctype="multipart/form-data"  method="post">
        <div class="content-box-content">
            <div id="postcustom">	
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
                        <td width="25%" class="leftrowcms">					
                            <label >Id Detail Pemesanan  <font color="red">*</font></label>
                        </td>
                        <td width="2%">:</td>
                        <td>
                           <?php echo $data['id_detail_pemesanan']; ?>	
                        </td>
                    </tr>
                    h-->
                    <input type="hidden" class="form-control" name="id_detail_pemesanan" value="<?php echo $data['id_detail_pemesanan']; ?>" readonly  id="id_detail_pemesanan" required="required">

                          <tr>
                            <td width="25%" class="leftrowcms">
                                <label >Tanggal  <span class="highlight"></span></label>
                            </td>
                            <td width="2%">:</td>
                            <td>
                                <select class="form-control" style="width:50%" type="text" name="id_pemesanan" id="id_pemesanan" placeholder="Id Pemesanan " required="required">
                                <option value="<?php echo ($data['id_pemesanan']); ?>">- <?php echo baca_database("","tanggal","select * from data_pemesanan where id_pemesanan='$data[id_pemesanan]'"); ?> -</option><?php combo_database_v2('data_pemesanan','id_pemesanan','tanggal',''); ?>
                                </select>
                            </td>
                        </tr>
                          <tr>
                            <td width="25%" class="leftrowcms">
                                <label >Nama  <span class="highlight"></span></label>
                            </td>
                            <td width="2%">:</td>
                            <td>
                                <select class="form-control" style="width:50%" type="text" name="id_menu_makanan" id="id_menu_makanan" placeholder="Id Menu Makanan " required="required">
                                <option value="<?php echo ($data['id_menu_makanan']); ?>">- <?php echo baca_database("","nama","select * from data_menu_makanan where id_menu_makanan='$data[id_menu_makanan]'"); ?> -</option><?php combo_database_v2('data_menu_makanan','id_menu_makanan','nama',''); ?>
                                </select>
                            </td>
                        </tr>
                          <tr>
                            <td width="25%" class="leftrowcms">
                                <label >Jumlah  <span class="highlight"></span></label>
                            </td>
                            <td width="2%">:</td>
                            <td>
                                <input onkeypress='return a(event)' class="form-control" style="width:50%" type="int" name="jumlah" id="jumlah" placeholder="Jumlah " required="required" value="<?php echo ($data['jumlah']); ?>">
                            </td>
                        </tr>
                          <tr>
                            <td width="25%" class="leftrowcms">
                                <label >Harga  <span class="highlight"></span></label>
                            </td>
                            <td width="2%">:</td>
                            <td>
                                <input onkeypress='return a(event)' class="form-control" style="width:50%" type="int" name="harga" id="harga" placeholder="Harga " required="required" value="<?php echo ($data['harga']); ?>">
                            </td>
                        </tr>


                    </tbody>
                </table>
                <div class="content-box-content">
                    <center>
                        <?php btn_update(' PROSES UPDATE DATA'); ?>
                    </center>
                </div>		
            </div>
        </div>
    </form>
