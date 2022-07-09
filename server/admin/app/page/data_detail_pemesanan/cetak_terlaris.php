<?php
if (isset($_GET['input'])) {
  echo "<h3> Cetak Laporan ";
  // tabelnomin();
  echo "Makanan Terlaris";
  echo "</h3>";
?>
  <link rel="stylesheet" type="text/css" href="../../../data/cssjs/cetak/style_new.css">
  <link rel="stylesheet" type="text/css" href="../../../data/cssjs/cetak/style_new2.css">
  <?php
  //ACTION CETAK
  function action_cetak_hanya_disini($tabel)
  {
  ?>

    <form name="formcari" id="formcari" action="cetak_terlaris.php" method="get" target="_blank">
      <fieldset>
        <table>
          <tbody>
            <tr>
              <td><b>CETAK KESELURUHAN</b></td>

              <td></td>
            </tr>


            <tr>
              <td style="width:40%"></td>

              <td>
                <?php btn_preview_laporan('Print Preview'); ?>
                <?php btn_cetak_laporan('Print'); ?>
                <?php btn_export_laporan('Export Excel'); ?>
              </td>
            </tr>
          </tbody>
        </table>
      </fieldset>
    </form>
    <br>
    <!-- <form name="formcari" id="formcari" action="cetak_terlaris.php" method="get" target="_blank">
      <fieldset>
        <table>
          <tbody>
            <tr>
              <td><b>CETAK DENGAN FILTER</b></td>

              <td>
              </td>
            </tr>

            <tr>
              <td style="width:40%">Berdasarkan :</td>

              <td>
                <select class="form-control selectpicker" data-live-search="true" name="Berdasarkan" id="Berdasarkan">
                  <?php
                  $sql = "desc $tabel";
                  $result = @mysql_query($sql);
                  while ($row = @mysql_fetch_array($result)) {
                    echo "<option name='berdasarkan' value=$row[0]>$row[0]</option>";
                  }
                  ?>
                </select>
              </td>
            </tr>

            <tr>
              <td style="width:40%">Pencarian :</td>

              <td>
                <input class="form-control" type="text" name="isi" value="">
              </td>
            </tr>

            <tr>
              <td></td>

              <td>
                <?php btn_preview_laporan('Print Preview'); ?>
                <?php btn_cetak_laporan('Print'); ?>
                <?php btn_export_laporan('Export Excel'); ?>
              </td>
            </tr>
          </tbody>
        </table>
      </fieldset>
    </form> -->

    <br>


    <?php
    $ada = 0;
    $sql = "desc $tabel";
    $result = @mysql_query($sql);
    while ($row = @mysql_fetch_array($result)) {
      $typedata = $row[1];

      $kalimat = $typedata;
      if (preg_match("/date/i", $kalimat)) {

        $ada = $ada + 1;
      } else {
      }
    }

    if ($ada > 0) {
    ?>

      <form name="formcari" id="formcari" action="cetak_terlaris.php" method="get" target="_blank">
        <fieldset>
          <table>
            <tbody>
              <tr>
                <td><b>CETAK PERPERIODE</b></td>

                <td></td>
              </tr>
              <tr>
                <td style="width:40%">Berdasarkan :</td>

                <td>
                  <select class="form-control selectpicker" data-live-search="true" name="Berdasarkan" id="Berdasarkan">
                    <?php
                    $sql = "desc $tabel";
                    $result = @mysql_query($sql);
                    while ($row = @mysql_fetch_array($result)) {
                      $typedata = $row[1];

                      $kalimat = $typedata;
                      if (preg_match("/date/i", $kalimat)) {

                        echo "<option name='berdasarkan' value=$row[0]>$row[0]</option>";
                      }
                    }
                    ?>
                  </select>
                </td>
              </tr>


              <tr>
                <td style="width:40%">Dari Tanggal :</b></td>

                <td><input type="date" name="tanggal1"></td>
              </tr>

              <tr>
                <td style="width:40%">Sampai Tanggal :</b></td>

                <td><input type="date" name="tanggal2"></td>
              </tr>


              <tr>
                <td></td>

                <td>
                  <?php btn_preview_laporan('Print Preview'); ?>
                  <?php btn_cetak_laporan('Print'); ?>
                  <?php btn_export_laporan('Export Excel'); ?>
                </td>
              </tr>
            </tbody>
          </table>
        </fieldset>
      </form>


  <?php
    }
  }
  action_cetak_hanya_disini("data_detail_pemesanan");
} else {

  function location()
  {
    return "cetak";
  }

  include '../../../include/all_include.php';
  proses_action_cetak("data_detail_pemesanan");
  ?>
  <link rel="stylesheet" type="text/css" href="../../../data/cssjs/cetak/style_new.css">
  <link rel="stylesheet" type="text/css" href="../../../data/cssjs/cetak/style_new2.css">
  <script src="https://code.highcharts.com/highcharts.js"></script>
  <script src="https://code.highcharts.com/modules/data.js"></script>
  <!-- <script src="https://code.highcharts.com/modules/drilldown.js"></script> -->
  <script src="https://code.highcharts.com/modules/exporting.js"></script>
  <script src="https://code.highcharts.com/modules/export-data.js"></script>
  <script src="https://code.highcharts.com/modules/accessibility.js"></script>


  <!-- HEADER -->
  <table border="0" style="width: 100%">
    <?php
    if (isset($_GET['export'])) {
    } else {
    ?>
      <tr>
        <td class="auto-style1" rowspan="3" width="101">
          <img alt="" height="100" src="<?php echo $logo_laporan1; ?>" width="100">
        </td>

        <td class="auto-style1">
          <center>
            <h2 class="auto-style1"><?php echo $judul; ?></h2>
          </center>
        </td>

        <td class="auto-style1" rowspan="3" width="101">
          <img alt="" height="100" src="<?php echo $logo_laporan2; ?>" width="100">
        </td>
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
            // echo $tabelnya;
            echo "MAKANAN TERLARIS"
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
  <div id="chart-ku"></div>

  <?php

  /**
   * count data_detail_pemesanan group by id_menu_makanan
   */
  function get_detail_pemesanan()
  {
    global $dbh;
    $stmt = $dbh->prepare("SELECT data_menu_makanan.nama as name, COUNT(data_menu_makanan.id_menu_makanan) AS y 
    FROM data_detail_pemesanan 
    JOIN data_menu_makanan ON data_detail_pemesanan.id_menu_makanan = data_menu_makanan.id_menu_makanan 
    GROUP BY data_detail_pemesanan.id_menu_makanan 
    ORDER BY y DESC
    ");
    $stmt->execute();
    $data = $stmt->fetchAll(PDO::FETCH_ASSOC);
    return $data;
  }

  /**
   * array to json
   */
  function array_to_json($array)
  {
    $json = json_encode($array, JSON_NUMERIC_CHECK);
    return $json;
  }

  $data = get_detail_pemesanan();

  // var_dump($data);

  ?>

  <script>
    // Create the chart
    Highcharts.chart('chart-ku', {
      chart: {
        type: 'column'
      },
      title: {
        text: 'Laporan Data Makanan Terlaris'
      },
      // subtitle: {
      //   text: 'Click the columns to view versions. Source: <a href="http://statcounter.com" target="_blank">statcounter.com</a>'
      // },
      accessibility: {
        announceNewData: {
          enabled: true
        }
      },
      xAxis: {
        type: 'category'
      },
      yAxis: {
        title: {
          text: 'Jumlah'
        }

      },
      legend: {
        enabled: false
      },
      plotOptions: {
        series: {
          borderWidth: 0,
          dataLabels: {
            enabled: true,
            format: '{point.y}'
          }
        }
      },

      tooltip: {
        headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
        pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}%</b> of total<br/>'
      },

      series: [{
        name: "Browsers",
        colorByPoint: true,
        // data: [{
        //   name: "Safari",
        //   y: 5.58,
        //   drilldown: "Safari"
        // }, ]
        data: JSON.parse('<?php echo array_to_json($data); ?>')
      }],

    });
  </script>


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