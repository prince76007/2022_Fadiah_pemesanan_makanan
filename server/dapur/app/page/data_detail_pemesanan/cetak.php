<?php
if (isset($_GET['input'])) {
    echo "<h3> Cetak Laporan ";
    tabelnomin();
    echo "</h3>";
    ?>
    <link rel="stylesheet" type="text/css" href="../../../data/cssjs/cetak/style_new.css">
    <link rel="stylesheet" type="text/css" href="../../../data/cssjs/cetak/style_new2.css">
    <?php
    action_cetak("data_detail_pemesanan");
} else {

    function location() {
        return "cetak";
    }

    include '../../../include/all_include.php';
    proses_action_cetak("data_detail_pemesanan");
    ?>
    <link rel="stylesheet" type="text/css" href="../../../data/cssjs/cetak/style_new.css">
    <link rel="stylesheet" type="text/css" href="../../../data/cssjs/cetak/style_new2.css">


    <!-- HEADER -->
    <table border="0" style="width: 100%">
        <?php
        if (isset($_GET['export'])) {
            
        } else {
            ?>
            <tr>
                <td class="auto-style1" rowspan="3" width="101">
                    <img alt="" height="100" src="<?php echo $logo_laporan1; ?>" width="100"></td>

                <td class="auto-style1">
            <center>
                <h2 class="auto-style1"><?php echo $judul; ?></h2>
            </center>
        </td>

        <td class="auto-style1" rowspan="3" width="101">
            <img alt="" height="100" src="<?php echo $logo_laporan2; ?>" width="100"></td>
        </tr>
    <?php } ?>

    <tr>
        <td class="auto-style2">
    <center>
        <strong>LAPORAN

            <?php
            $tabelnya = "data_detail_pemesanan";
            $tabelnya = str_replace("_", " ", $tabelnya);
            $tabelnya = str_replace("data", "", $tabelnya);
            $tabelnya = strtoupper($tabelnya);
            echo $tabelnya;
            ?>

        </strong>
    </center>
    </td>
    </tr>

    <tr>
        <td class="auto-style2"><?php echo $alamat; ?></td>
    </tr>
    </table>
    <!-- HEADER -->

    <!-- BODY -->
    <table width="100%"  class="tblcms2">
        <tr>
            <th class="th_border cell">No</th>
           <!--h <th class="th_border cell">Id Detail Pemesanan </th> h-->
                <th align="center" class="th_border cell"  >Tanggal </th>
                <th align="center" class="th_border cell"  >Nama </th>
                <th align="center" class="th_border cell"  >Jumlah </th>
                <th align="center" class="th_border cell"  >Harga </th>


        </tr>

        <tbody>
            <?php
            $no = 0;
            if (isset($_GET['isi']) && !empty($_GET['isi'])) {
                //BERDASARKAN
                $Berdasarkan = mysql_real_escape_string($_GET['Berdasarkan']);
                $isi = mysql_real_escape_string($_GET['isi']);
                echo '<center> Cetak berdasarkan <b>' . $Berdasarkan . '</b> : <b>' . $isi . '</b></center>';
                $querytabel = "SELECT * FROM data_detail_pemesanan where $Berdasarkan like '%$isi%'";
            } else if (isset($_GET['tanggal1']) && !empty($_GET['tanggal1'])) {
                //PERIODE
                $Berdasarkan = mysql_real_escape_string($_GET['Berdasarkan']);
                $tanggal1 = mysql_real_escape_string($_GET['tanggal1']);
                $tanggal2 = mysql_real_escape_string($_GET['tanggal2']);
                $tanggal1_indo = format_indo($tanggal1);
                $tanggal2_indo = format_indo($tanggal2);
                echo '<center> Cetak Berdasarkan <b>' . $Berdasarkan . '</b> Dari Tanggal <b>' . $tanggal1_indo . '</b> s/d <b>' . $tanggal2_indo . '</b></center>';
                $querytabel = "SELECT * FROM data_detail_pemesanan where ($Berdasarkan BETWEEN '$tanggal1' AND '$tanggal2')";
            } else {
                //SEMUA
                $querytabel = "SELECT * FROM data_detail_pemesanan";
            }
            $proses = mysql_query($querytabel);
            while ($data = mysql_fetch_array($proses)) {
                ?>
                <tr class="event2">
                    <td align="center" width="50"><?php $no = $no + 1; echo $no; ?></td>
                    <!--h <td align="center"><?php echo $data['id_detail_pemesanan']; ?></td> h-->
                        <td align="center"><?php echo baca_database("","tanggal","select * from data_pemesanan where id_pemesanan='$data[id_pemesanan]'")  ?></td>
                        <td align="center"><?php echo baca_database("","nama","select * from data_menu_makanan where id_menu_makanan='$data[id_menu_makanan]'")  ?></td>
                        <td align="center"><?php echo $data['jumlah']; ?></td>
                        <td align="center"><?php echo $data['harga']; ?></td>



                </tr>
    <?php } ?>
        </tbody>
    </table>
    <!-- BODY -->

    <!-- FOOTER -->
    <p class="auto-style3"><?php echo $formatwaktu; ?>
    </p>
    <p class="auto-style3"><?php echo $ttd; ?></p>
    <p class="auto-style3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    </p>
    <p class="auto-style3"><?php echo $siapa; ?>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;</p>
    <p class="auto-style3"></p>

<?php } ?>
