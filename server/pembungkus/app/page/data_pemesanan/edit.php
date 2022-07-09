
<a href="<?php index(); ?>">
    <?php btn_kembali(' KEMBALI KE HALAMAN SEBELUMNYA'); ?>
</a>

    <div class="col-sm-12" style="margin-bottom: 20px; margin-top: 20px;">
    <div class="alert alert-warning">
        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>
        <strong>Edit Data Pemesanan </strong>
        <hr class="message-inner-separator">
            <p>Silahkan Update Data Pemesanan dibawah ini.</p>
        </div>
    </div>


<div class="content-box">
    <form id="formD" name="formD" action="proses_update.php"  enctype="multipart/form-data"  method="post">
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
                    $sql = mysql_query("SELECT * FROM data_pemesanan where id_pemesanan = '$proses'");
                    $data = mysql_fetch_array($sql);
                    ?> 
                    <!--h
                    <tr>
                        <td width="25%" class="leftrowcms">					
                            <label >Id Pemesanan  <font color="red">*</font></label>
                        </td>
                        <td width="2%">:</td>
                        <td>
                           <?php echo $data['id_pemesanan']; ?>	
                        </td>
                    </tr>
                    h-->
                    <input type="hidden" class="form-control" name="id_pemesanan" value="<?php echo $data['id_pemesanan']; ?>" readonly  id="id_pemesanan" required="required">

                          <tr>
                            <td width="25%" class="leftrowcms">
                                <label >Tanggal  <span class="highlight"></span></label>
                            </td>
                            <td width="2%">:</td>
                            <td>
                                <input  class="form-control" style="width:50%" type="date" name="tanggal" id="tanggal" placeholder="Tanggal " required="required" value="<?php echo ($data['tanggal']); ?>">
                            </td>
                        </tr>
                        <!--  <tr>-->
                        <!--    <td width="25%" class="leftrowcms">-->
                        <!--        <label >Nama  <span class="highlight"></span></label>-->
                        <!--    </td>-->
                        <!--    <td width="2%">:</td>-->
                        <!--    <td>-->
                        <!--        <select class="form-control" style="width:50%" type="text" name="id_pelanggan" id="id_pelanggan" placeholder="Id Pelanggan " required="required">-->
                        <!--        <option value="<?php echo ($data['id_pelanggan']); ?>">- <?php echo baca_database("","nama","select * from data_pelanggan where id_pelanggan='$data[id_pelanggan]'"); ?> -</option><?php combo_database_v2('data_pelanggan','id_pelanggan','nama',''); ?>-->
                        <!--        </select>-->
                        <!--    </td>-->
                        <!--</tr>-->
                    
                          <tr>
                            <td width="25%" class="leftrowcms">
                                <label >Total Bayar + PPN 10% <span class="highlight"></span></label>
                            </td>
                            <td width="2%">:</td>
                            <td>
                                <input readonly onkeyup="OnChange(this.value)" onKeyPress="" class="form-control" style="width:50%" type="int" name="total_bayar" id="total_bayar" placeholder="Total Bayar " required="required" value="<?php echo ($data['total_bayar']+($data['total_bayar']*10/100) ); ?>" >
                            </td>
                        </tr>
                        <tr>
                            <td width="25%" class="leftrowcms">
                                <label >Jumlah Bayar  <span class="highlight"></span></label>
                            </td>
                            <td width="2%">:</td>
                            <td>
                                <input onkeyup="OnChange(this.value)" onKeyPress="" class="form-control" style="width:50%" type="int" name="jumlah_uang" id="jumlah_uang" placeholder="Jumlah Uang " required="required" >
                            </td>
                        </tr>
                        
                        <tr>
                            <td width="25%" class="leftrowcms">
                                <label >Kembalian  <span class="highlight"></span></label>
                            </td>
                            <td width="2%">:</td>
                            <td>
                                <input class="form-control" style="width:50%" type="int" name="kembalian" id="kembalian" value="" readonly="readonly" method="post">
                            </td>
                        </tr>
                     
                        
 </script>
                        <!--  <tr>-->
                        <!--    <td width="25%" class="leftrowcms">-->
                        <!--        <label >Lat  <span class="highlight"></span></label>-->
                        <!--    </td>-->
                        <!--    <td width="2%">:</td>-->
                        <!--    <td>-->
                        <!--        <input  class="form-control" style="width:50%" type="varchar" name="lat" id="lat" placeholder="Lat " required="required" value="<?php echo ($data['lat']); ?>">-->
                        <!--    </td>-->
                        <!--</tr>-->
                        <!--  <tr>-->
                        <!--    <td width="25%" class="leftrowcms">-->
                        <!--        <label >Lng  <span class="highlight"></span></label>-->
                        <!--    </td>-->
                        <!--    <td width="2%">:</td>-->
                        <!--    <td>-->
                        <!--        <input  class="form-control" style="width:50%" type="varchar" name="lng" id="lng" placeholder="Lng " required="required" value="<?php echo ($data['lng']); ?>">-->
                        <!--    </td>-->
                        <!--</tr>-->
                        <!--  <tr>-->
                        <!--    <td width="25%" class="leftrowcms">-->
                        <!--        <label >Nomor Meja  <span class="highlight"></span></label>-->
                        <!--    </td>-->
                        <!--    <td width="2%">:</td>-->
                        <!--    <td>-->
                        <!--        <input  class="form-control" style="width:50%" type="varchar" name="alamat_pengiriman" id="alamat_pengiriman" placeholder="Alamat Pengiriman " required="required" value="<?php echo ($data['alamat_pengiriman']); ?>">-->
                        <!--    </td>-->
                        <!--</tr>-->
                          <tr>
                            <td width="25%" class="leftrowcms">
                                <label >Status  <span class="highlight"></span></label>
                            </td>
                            <td width="2%">:</td>
                            <td>
                                <select class="form-control" style="width:50%" type="text" name="status" id="status" placeholder="Status " required="required">
                               <option>pemesanan</option>
                               <option>selesai</option>
                               <option>lunas</option>
                                </select>
                            </td>
                        </tr>


                    </tbody>
                    
                </table>
                
                <div class="content-box-content">
                    <center>
                        <?php btn_update('PROSES & CETAK NOTA'); ?>
                    </center>
                </div>		
            </div>
        </div>
    </form>
    <script>
                //         function ppn(total_bayar){
                // 			var ppn;
                // 			ppn = 0.10 * total_bayar;
                // 			harga_ppn = total_bayar + ppn;
                // 			return harga_ppn;
                // 		}
                         total_bayar = document.formD.total_bayar.value;
                             document.formD.kembalian.value = total_bayar;
                               jumlah_uang = document.formD.jumlah_uang.value;
                               document.formD.kembalian.value = jumlah_uang;
                               function OnChange(value){
                                 total_bayar = document.formD.total_bayar.value;
                                 jumlah_uang = document.formD.jumlah_uang.value;
                                 kembalian = total_bayar - jumlah_uang  ;
                                 document.formD.kembalian.value = kembalian;
                               }
</script>