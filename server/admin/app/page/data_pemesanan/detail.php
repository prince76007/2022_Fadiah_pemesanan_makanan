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
          <td class="clleft"><?php echo baca_database("", "nama", "select * from data_pelanggan where id_pelanggan='$data[id_pelanggan]'")  ?></td>
        </tr>


        <tr>
          <td colspan="3">
            <table <?php tabel(100, '%', 1, 'left'); ?>>
              <tr style="background:orange">

                <th>No</th>

                <th align="center" class="th_border cell">Menu </th>
                <th align="center" class="th_border cell">Jumlah </th>
                <th align="center" class="th_border cell">Catatan </th>
                <th align="center" class="th_border cell">Harga </th>
                <th align="center" class="th_border cell">Subtotal </th>
              </tr>

              <tbody>
                <?php
                $no = 0;
                $startRow = ($page - 1) * $dataPerPage;
                $no = $startRow;


                $querytabel = "SELECT * FROM data_detail_pemesanan  where id_pemesanan='$proses'";

                $proses = mysql_query($querytabel);
                while ($data2 = mysql_fetch_array($proses)) {
                ?>
                  <tr class="event2">



                    <td align="center" width="50"><?php $no = (($no + 1));
                                                  echo $no; ?></td>

                    <td align="center"><?php echo baca_database("", "nama", "select * from data_menu_makanan where id_menu_makanan='$data2[id_menu_makanan]'")  ?></td>
                    <td align="center"><?php echo   $data2['jumlah'];  ?> </td>
                    <td align="center"><?php echo   $data2['catatan'];  ?> </td>
                    <td align="center"><?php echo rupiah($data2['harga']); ?></td>
                    <td align="center"><?php echo rupiah($data2['harga'] * $data2['jumlah']); ?></td>

                  </tr>
                <?php } ?>
              </tbody>
            </table>

          </td>
        </tr>


        <tr>
          <td class="clleft" width="25%">Total Bayar + PPN 10%</td>
          <td class="clleft" width="2%">:</td>
          <td class="clleft"><?php echo rupiah($data['total_bayar'] + ($data['total_bayar'] * 10 / 100)); ?></td>
        </tr>




      </tbody>
    </table>
  </div>
</div>