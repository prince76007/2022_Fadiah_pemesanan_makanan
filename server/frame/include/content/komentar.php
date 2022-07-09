<?php 
function komentar() { ?>
<style>
.media .avatar {
    width: 64px;
}
.shadow-textarea textarea.form-control::placeholder {
    font-weight: 300;
}
.shadow-textarea textarea.form-control {
    padding-left: 0.8rem;
}
</style>
<div class="card card-cascade narrower">
			<div class="view view-cascade overlay">
			</div>
			<div class="card-body card-body-cascade">
<?php 
$id_lokasi_penyewaan=decrypt($_GET['selengkapnya']);
$querytabel="SELECT * FROM data_komentar where id_lokasi_penyewaan='$id_lokasi_penyewaan'";
$proses = mysql_query($querytabel);
while ($data = mysql_fetch_array($proses))
  { ?>
				  
<div class="media">
  <img class="d-flex rounded-circle avatar z-depth-1-half mr-3" src="https://media.istockphoto.com/vectors/man-user-icon-vector-vector-id667701200?k=6&m=667701200&s=170667a&w=0&h=YGE_Zc1aAQQHsynKeH0sJWAhJZO5a8M0ZSvVeHc7g98="
    alt="Avatar">
  <div class="media-body">
    <h5 class="mt-0 font-weight-bold blue-text"><?php $id_pelanggan = $data['id_pelanggan'];
	echo baca_database("","nama","select * from data_pelanggan where id_pelanggan='$id_pelanggan'");
	?></h5>
    <?php echo $data['komentar'];?>
  </div>
</div>
<br>
 <?php }?>
				  
<div class="media">
  <img class="d-flex rounded-circle avatar z-depth-1-half mr-3" src="https://media.istockphoto.com/vectors/man-user-icon-vector-vector-id667701200?k=6&m=667701200&s=170667a&w=0&h=YGE_Zc1aAQQHsynKeH0sJWAhJZO5a8M0ZSvVeHc7g98="
    alt="Avatar">
  <div class="media-body">
  <form action="" method="get">
    <h5 class="mt-0 font-weight-bold blue-text">Masukkan Komentar </h5>
    <textarea class="form-control z-depth-1" id="komentar" name="komentar" rows="3" placeholder="Write your comment..."></textarea>
          <input type="submit" class="btn btn-default" value="kirim">
          <input type="hidden" name="selengkapnya" value="<?php echo ($_GET['selengkapnya']);?>">
          <input type="hidden" name="maps" value="">
 </form>
 <?php 
 if (isset($_GET['komentar']))
 {
	
$id_komentar=id_otomatis("data_komentar","id_komentar","10");
$id_pelanggan="1";
$id_lokasi_penyewaan=decrypt($_GET['selengkapnya']);
$komentar=$_GET['komentar'];


$query=mysql_query("insert into data_komentar values (
'$id_komentar'
 ,'$id_pelanggan'
 ,'$id_lokasi_penyewaan'
 ,'$komentar'



)");
	?>
	<script>location.href = "index.php?selengkapnya=<?php echo encrypt($id_lokasi_penyewaan);?>&maps="; </script>
	<?php
 }
 ?>
  </div>
</div>

</div>
</div>
<?php } ?>