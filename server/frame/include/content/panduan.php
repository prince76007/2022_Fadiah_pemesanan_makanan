<?php
function panduan()
{
	if (!(isset($_GET['selengkapnya'])))
	{
	?>
	<div class="card">
  <div class="view overlay">
  </div>
  <div class="card-body">
    <h4 class="card-title">Panduan Pengoperasian Aplikasi</h4>
    <hr>
    <p class="card-text">Berikut ini merupakan panduan bagaimana mengoperasikan aplikasi pada aplikasi ini.</p>

  </div>
  <div class="rounded-bottom mdb-color lighten-3 text-center pt-3">
    <ul class="list-unstyled list-inline font-small">
      <li class="list-inline-item pr-2 white-text"><i class="far fa-clock pr-1"></i>Tanggal Posting : <?php echo format_indo(date('Y-m-d'));?></li>
      <li class="list-inline-item pr-2"></li>
      <li class="list-inline-item pr-2"></li>
      <li class="list-inline-item pr-2"></li>
    </ul>
  </div>
</div>
	<?php
	} 
	
	else
	{
		
	}
}
?>