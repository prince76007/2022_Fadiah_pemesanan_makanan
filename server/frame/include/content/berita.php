<?php
function berita($tema,$tabel,$id_berita,$judul,$tanggal,$foto,$detail)
{
	?>
<link rel="stylesheet" type="text/css" href="../../data/cssjs/rating/css/star-rating.css">
<script type="text/javascript" src="../../data/cssjs/rating/js/jquery.min.js"></script>
<script type="text/javascript" src="../../data/cssjs/rating/js/star-rating.js"></script>
<!--
<link rel="stylesheet" type="text/css" href="../../data/cssjs/rating/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="../../data/cssjs/rating/css/bootstrap.css">
<script type="text/javascript" src="../../data/cssjs/rating/js/bootstrap.js"></script>
-->
	<?php
	if (!(isset($_GET['selengkapnya'])))
	{
			//List Berita
			if (isset($_GET['Berdasarkan']) && !empty($_GET['Berdasarkan']) && isset($_GET['isi']) && !empty($_GET['isi']))
			{
			$berdasarkan =  mysql_real_escape_string($_GET['Berdasarkan']);
			$isi =  mysql_real_escape_string($_GET['isi']);
			$querytabel="SELECT * FROM $tabel where $berdasarkan like '%$isi%'";
			$querypagination="SELECT COUNT(*) AS total FROM $tabel where $berdasarkan like '%$isi%'";
			}
			else if (isset($_GET['sort'])) 
			{
			$sort =  mysql_real_escape_string($_GET['sort']);
			if ($sort=="a")
			{
				$querytabel="SELECT * FROM $tabel order by $judul asc";
			}
			else
			{
				$querytabel="SELECT * FROM $tabel order by $judul desc";
			}
			
			$querypagination="SELECT COUNT(*) AS total FROM $tabel";
			}
			else
			{
			$querytabel="SELECT * FROM $tabel ";
			$querypagination="SELECT COUNT(*) AS total FROM $tabel";
			}
			$proses = mysql_query($querytabel);
			while ($data = mysql_fetch_array($proses))
			{ 
		
		
			if ($tema == "1")
			{
			?>
			<div class="card card-cascade narrower">
			<div class="view view-cascade overlay">
				<img  class="card-img-top" src="../../../admin/upload/<?php echo $data[$foto]; ?>" alt="Card image cap">
				<a>
				<div class="mask rgba-white-slight"></div>
				</a>
			</div>
			<div class="card-body card-body-cascade">
				<h5 class="pink-text pb-2 pt-1"><i class="fas fa-calendar"></i> <?php echo (format_indo($data[$tanggal])); ?></h5>
				<h4 class="font-weight-bold card-title"><?php echo (ucwords($data[$judul])); ?></h4>
				
				<a onclick="window.location.href = '?selengkapnya=<?= encrypt($data[$id_berita]);?>'" class="btn btn-primary">Selengkapnya</a>
			</div>
			</div>
			
			<br>
			<?php 
			}
			else if ($tema == "2")
			{
			?>
				<div class="card">
				<div class="view overlay">
					<img class="card-img-top" src="../../../admin/upload/<?php echo $data[$foto]; ?>" alt="Card image cap">
					<a>
					<div class="mask rgba-white-slight"></div>
					</a>
				</div>
				<div class="card-body">
					<h4 class="card-title"><?php echo (ucwords($data[$judul])); ?></h4>
					<hr>
					<p class="card-text"><?php echo (substr($data[$detail],0,100)); ?></p>
				<a href="?selengkapnya=<?= encrypt($data[$id_berita]);?>" class="black-text d-flex justify-content-end"><h5>Read more <i class="fas fa-angle-double-right"></i></h5></a>
				</div>
				<div class="rounded-bottom mdb-color lighten-3 text-center pt-3">
					<ul class="list-unstyled list-inline font-small">
					<li class="list-inline-item pr-2 white-text"><i class="far fa-clock pr-1"></i>Diposting Tanggal : <?php echo (format_indo($data[$tanggal])); ?></li>
					<li class="list-inline-item pr-2"><a href="#" class="white-text"></a></li>
					<li class="list-inline-item pr-2"><a href="#" class="white-text"></a></li>
					<li class="list-inline-item"><a href="#" class="white-text"></a></li>
					</ul>
				</div>
				</div>
				<br>
			<?php 
			}
			else if ($tema == "3")
			{
			?>
			<div class="card">
			<div class="view overlay">
				<img class="card-img-top" src="../../../admin/upload/<?php echo $data[$foto]; ?>" alt="Card image cap">
				<a>
				<div class="mask rgba-white-slight"></div>
				</a>
			</div>
			<div class="card-body elegant-color white-text rounded-bottom">
				<a class="activator waves-effect mr-4"><i class="fas fa-calendar white-text"></i> <?php echo (format_indo($data[$tanggal])); ?></a>
				<h4 class="card-title"><?php echo (ucwords($data[$judul])); ?></h4>
				<hr class="hr-light">
				<p class="card-text white-text mb-4"><?php echo (substr($data[$detail],0,100)); ?></p>
				<a href="?selengkapnya=<?= encrypt($data[$id_berita]);?>" class="white-text d-flex justify-content-end"><h5>Read more <i class="fas fa-angle-double-right"></i></h5></a>
			</div>
			</div>
			
			<?php 
			}
			else if ($tema == "4")
			{
			?>
			<div class="card card-body mb-3"  onclick="window.location.href = '?selengkapnya=<?= encrypt($data[$id_berita]);?>&maps=';">
			<div class="media">
			<img class="d-flex align-self-start mr-3" width="100" height="80" src="../../../admin/upload/<?php echo $data[$foto]; ?>" alt="Generic placeholder image">
			<div class="media-body">
			<h5 class="mt-0 font-weight-bold"><?php echo (ucwords($data[$judul])); ?></h5>
			<p><i class="fas fa-maps"></i> <?php echo (($data['alamat'])); ?></p>
			 
			 
			



			
			</div>
			</div>
			<br>
			
			<input id="<?php echo $ids= $data[$id_berita]; ?>" value="<?php 

$r=0;
$j=0;
 $query1    = "SELECT * FROM data_rating where id_lokasi_penyewaan='$ids' ";
$proses1   = mysql_query($query1); 

    while ($data1 = mysql_fetch_array($proses1)) {
        $j = $j +1;
       $r = $r + $data1['rating'];
    }
    echo $r/$j;
	//echo "5";

?>" type="text" readonly title="" width="0;" style="width:0;"/>

   
<script type="text/javascript">
	$(document).ready(function(){
		 <?php 
  $query2    = "SELECT * FROM data_lokasi_penyewaan";
$proses2   = mysql_query($query2); 

    while ($data2 = mysql_fetch_array($proses2)) {
      
   ?>
		var $inp = $('#<?php echo $data2[$id_berita]; ?>');
		$inp.rating({
                min: 0,
                max: 5,
                step: 1,
                size: 'xs',
                showClear: false
            });
		$inp.on('rating.change', function () {
			var $val = $('#<?php echo $data2[$id_berita]; ?>').val();
			location.href = "simpan_rating.php?id=<?php echo $data2['id_lokasi_penyewaan']; ?>&idp=1&rating=" + $val ;
		});
	<?php } ?>
	});
</script>
			</div>
			<?php 
			}
			else if ($tema == "5")
			{
			?>
			
			<div class="card promoting-card">
			<div class="card-body d-flex flex-row">
				<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcT2IDyebsD4BGI-_kga7bpJ8kW29sOEex40q6v3qeDrBdfEgECb" class="rounded-circle mr-3" height="50px" width="50px" alt="avatar">
				<div>
				<h4 class="card-title font-weight-bold mb-2"><?php echo (ucwords($data[$judul])); ?></h4>
				<p class="card-text"><i class="far fa-clock pr-2"></i><?php echo (format_indo($data[$tanggal])); ?></p>
				</div>
			</div>
			<div class="view overlay">
				<img class="card-img-top rounded-0" src="../../../admin/upload/<?php echo $data[$foto]; ?>" alt="Card image cap">
				<a href="#!">
				<div class="mask rgba-white-slight"></div>
				</a>
			</div>
			<div class="card-body">
				<div class="collapse-content">
				<?php echo (substr($data[$detail],0,100)); ?>
				</div>
				<button type="button" class="btn btn-outline-primary waves-effect">Baca Selengkapnya</button>
			</div>
			</div>
			<br>
			<?php
			}
			else
			{
				echo "Tema Tidak Ada";
			}
			
			} 
	}
	else
	{
		//Selengkapnya
		$id = decrypt($_GET['selengkapnya']);
		$querytabel="SELECT * FROM $tabel where $id_berita='$id'";
		$proses = mysql_query($querytabel);
		$data = mysql_fetch_array($proses)
		?>
		<div class="card card-cascade narrower">
			<div class="view view-cascade overlay">
				<img  class="card-img-top" src="../../../admin/upload/<?php echo $data[$foto]; ?>" alt="Card image cap">
				<a>
				<div class="mask rgba-white-slight"></div>
				</a>
			</div>
			<div class="card-body card-body-cascade">
				
				<h4 class="font-weight-bold card-title"><?php echo (ucwords($data[$judul])); ?></h4>
				<h5 class="pink-text pb-2 pt-1">
				
				
<?php
if(isset($_GET['maps']))
{

if(isset($_GET['rating']))
{}
else
{
	?>


			
			<input id="<?php echo $ids= $data[$id_berita]; ?>" value="<?php 

$r=0;
$j=0;
 $query1    = "SELECT * FROM data_rating where id_lokasi_penyewaan='$ids' ";
$proses1   = mysql_query($query1); 

    while ($data1 = mysql_fetch_array($proses1)) {
        $j = $j +1;
       $r = $r + $data1['rating'];
    }
    echo $r/$j;
	//echo "5";

?>" type="text" style="color:white;" title=""/>
<br>
   
<script type="text/javascript">
	$(document).ready(function(){
		 <?php 
  $query2    = "SELECT * FROM data_lokasi_penyewaan";
$proses2   = mysql_query($query2); 

    while ($data2 = mysql_fetch_array($proses2)) {
      
   ?>
		var $inp = $('#<?php echo $data2[$id_berita]; ?>');
		$inp.rating({
                min: 0,
                max: 5,
                step: 1,
                size: 'xs',
                showClear: false
            });
		$inp.on('rating.change', function () {
			var $val = $('#<?php echo $data2[$id_berita]; ?>').val();
			location.href = "index.php?selengkapnya=<?php echo $_GET['selengkapnya'];?>&maps=&rating=" + $val ;
		});
	<?php } ?>
	});
</script>

<?php 
}
if (isset($_GET['rating']))
{
	$id_rating = rand(0,10000000000);
	$id_lokasi_penyewaan = decrypt($_GET['selengkapnya']);
	$id_pelanggan="1";
	$rating=$_GET['rating'];
	

	$query=mysql_query("insert into data_rating values (
'$id_rating'
 ,'$id_lokasi_penyewaan'
 ,'$id_pelanggan'
 ,'$rating'

)");


if($query){
?>
<script>
location.href = "index.php?selengkapnya=<?php echo $_GET['selengkapnya'];?>&maps=";
</script>
<?php
}
else
{
	echo "GAGAL DIPROSES";
}


}
?>

<i class="fas fa-phone"></i>  Telepon : <?php  echo (format_indo($data[$tanggal])); ?></h5>
				<p><b>Pengelola : </b><?php echo (ucwords($data['nama_pengelola'])); ?></p>
				<p><b>Alamat : </b><?php echo (ucwords($data['alamat'])); ?></p>
				<p><b>Deskripsi : </b>
<?php } else { ?>
<i class="fas fa-calendar"></i>  <?php  echo (format_indo($data[$tanggal])); ?></h5>
<?php } ?>
				<?php echo ($data[$detail]); ?>

				</p>
			</div>
			</div>
		<?php


	}
}
?>