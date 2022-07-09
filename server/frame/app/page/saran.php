<?php 
include '../../include/all_include.php';	
if (!(isset($_GET['a'])))
{
?>
<div>
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header text-center">
        <h4 class="modal-title w-100 font-weight-bold">Saran Lokasi</h4>
        
      </div>
      <div class="modal-body mx-3">
        <div class="md-form mb-5">
          <i class="far fa-map prefix grey-text"></i>
          <input type="TEXT" id="defaultForm-email" class="form-control validate">
          <label data-error="wrong" data-success="right" for="defaultForm-email">Nama Tempat</label>
        </div>
		
		<div class="md-form mb-5">
          <i class="fas fa-atlas prefix grey-text"></i>
          <input type="TEXT" id="defaultForm-email" class="form-control validate">
          <label data-error="wrong" data-success="right" for="defaultForm-email">Alamat</label>
        </div>
		
		<div class="md-form mb-5">
          <i class="fas fa-mobile prefix grey-text"></i>
          <input type="TEXT" id="defaultForm-email" class="form-control validate">
          <label data-error="wrong" data-success="right" for="defaultForm-email">No Telepon</label>
        </div>

		<div class="md-form mb-5">
          <i class="fas fa-user prefix grey-text"></i>
          <input type="TEXT" id="defaultForm-email" class="form-control validate">
          <label data-error="wrong" data-success="right" for="defaultForm-email">Nama Pengelola</label>
        </div>
		
		<div class="md-form mb-5">
          <i class="fas fa-info-circle prefix grey-text"></i>
          <input type="TEXT" id="defaultForm-email" class="form-control validate">
          <label data-error="wrong" data-success="right" for="defaultForm-email">Deskripsi</label>
        </div>
		
		<div class="md-form mb-5">
          
          <div class="input-group">
  
  <div class="custom-file">
    <input type="file" class="custom-file-input" id="inputGroupFile01"
      aria-describedby="inputGroupFileAddon01">
    <label class="custom-file-label" for="inputGroupFile01">Upload Foto</label>
  </div>
</div>
         
        </div>
		
		
      </div>
      <div class="modal-footer d-flex justify-content-center">
        <button class="btn btn-default">kirim Saran</button>
      </div>
    </div>
  </div>
</div>
<?php } else {?>

<div >
  <div class="modal-dialog modal-notify modal-primary" role="document">
    <!--Content-->
    <div class="modal-content">
      <!--Header-->
      <div class="modal-header text-center">
        <h4 class="modal-title white-text w-100 font-weight-bold py-2">Pendaftaran</h4>
        
      </div>

      <!--Body-->
      <div class="modal-body">
        <div class="md-form mb-5">
          <i class="fas fa-user prefix grey-text"></i>
          <input type="text" id="form3" class="form-control validate">
          <label data-error="wrong" data-success="right" for="form3">Nama</label>
        </div>

        <div class="md-form">
          <i class="fas fa-envelope prefix grey-text"></i>
          <input type="email" id="form2" class="form-control validate">
          <label data-error="wrong" data-success="right" for="form2">Alamat</label>
        </div>
		
		<div class="md-form">
          <i class="fas fa-phone prefix grey-text"></i>
          <input type="email" id="form2" class="form-control validate">
          <label data-error="wrong" data-success="right" for="form2">No Telepon</label>
        </div>
		
		<div class="md-form">
          <i class="fas fa-users prefix grey-text"></i>
          <input type="email" id="form2" class="form-control validate">
          <label data-error="wrong" data-success="right" for="form2">Jenis Jelamin</label>
        </div>
		
		<div class="md-form">
          <i class="fas fa-at prefix grey-text"></i>
          <input type="email" id="form2" class="form-control validate">
          <label data-error="wrong" data-success="right" for="form2">Email</label>
        </div>
		
		<div class="md-form">
          <i class="far fa-user-circle prefix grey-text"></i>
          <input type="email" id="form2" class="form-control validate">
          <label data-error="wrong" data-success="right" for="form2">Username</label>
        </div>
		
		<div class="md-form">
          <i class="fas fa-unlock prefix grey-text"></i>
          <input type="email" id="form2" class="form-control validate">
          <label data-error="wrong" data-success="right" for="form2">Password</label>
        </div>
      </div>

      <!--Footer-->
      <div class="modal-footer justify-content-center">
        <a type="button" class="btn btn-primary">Send <i class="fas fa-paper-plane-o ml-1"></i></a>
      </div>
    </div>
    <!--/.Content-->
  </div>
</div>

<?php } ?>
