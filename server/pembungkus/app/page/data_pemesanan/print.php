<?php

include '../../../include/all_include.php';
?>
<table border="2" width="500px">
    <tr>
        <td>
            <centeR>
       <h2>
           <img src="../../../data/image/logo/logo.png" width="50px">
           <br>
           NOTA PEMBAYARAN
       </h2>
       <?php echo $judul;?>
       <br>
        <?php echo $alamat;?>
       </centeR>
       <hr>
<div class="content-box">
    <div class="content-box-content">
        <table width="100%">		
            <tbody>
               
                <?php
                
            $proses = (mysql_real_escape_string($_GET['id_pemesanan']));
            $sql = mysql_query("SELECT * FROM data_pemesanan where id_pemesanan = '$proses'");
            $data = mysql_fetch_array($sql);
            ?>
           <!--h
            <tr>
                <td class="clleft" width="25%">Id Pemesanan </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo $id_pemesanan = $data['id_pemesanan']; ?></td>	
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
                <td colspan="3">
                    <table <?php tabel(100, '%', 1, 'left'); ?> >
            <tr style="background:orange">								  
               
                <th>No</th>
                
                <th align="center" class="th_border cell"  >Menu </th>
                <th align="center" class="th_border cell"  >Jumlah </th>
                <th align="center" class="th_border cell"  >Harga </th>
<th align="center" class="th_border cell"  >Subtotal </th>
            </tr>

            <tbody>
                <?php
                $no = 0;
                $startRow = ($page - 1) * $dataPerPage;
                $no = $startRow;

                
                    $querytabel = "SELECT * FROM data_detail_pemesanan  where id_pemesanan='$id_pemesanan'";
                  
                $proses = mysql_query($querytabel);
                while ($data2 = mysql_fetch_array($proses)) {
                    ?>
                    <tr class="event2">	
                        
                      
                        
                        <td align="center" width="50"><?php $no = (($no + 1) ); echo $no; ?></td>
                       
                        <td align="center"><?php echo baca_database("","nama","select * from data_menu_makanan where id_menu_makanan='$data2[id_menu_makanan]'")  ?></td>
                        <td align="center"><?php echo $data2['jumlah']; ?></td>
                        <td align="center"><?php echo rupiah($data2['harga']); ?></td>
 <td align="center"><?php echo rupiah($data2['harga'] * $data2['jumlah']); ?></td>
                    
                    </tr>
            <?php } ?>
            </tbody>
        </table>
                    
                </td>
            </tr>
            
            
            
            <tr>
                <td class="clleft" width="25%">Total Bayar + PPN 10% </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo rupiah($data['total_bayar']+($data['total_bayar']*10/100)); ?></td>
            </tr>
           
           
           
            <tr>
                <td class="clleft" width="25%">Jumlah Uang </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo rupiah($data['jumlah_uang']); ?></td>
            </tr>
            
            <tr>
                <td class="clleft" width="25%">Kembalian </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo rupiah($data['kembalian']); ?></td>
            </tr>

            <tr>
                <td class="clleft" width="25%">Status </td>
                <td class="clleft" width="2%">:</td>
                <td class="clleft"><?php echo ($data['status']); ?></td>
            </tr>


            </tbody>
        </table>
    </div>
</div>
 </td>
    </tr>
</table>
<script>
    window.print();
</script>
<style>
    @media print {
  #printPageButton {
    display: none;
  }
}

</style>
<a id="printPageButton"  href="index.php">Selesai</a>
