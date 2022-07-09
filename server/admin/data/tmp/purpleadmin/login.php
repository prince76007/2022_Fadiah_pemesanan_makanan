		<?php
$default_url = '../data/tmp/tmp 53';
$tema = 'PurpleAdmin/';
$url = $default_url.'/'.$tema;
?>
<?php include '../include/function/login.php';?>


  <link rel="stylesheet" href="<?php echo $url;?>vendors/iconfonts/mdi/css/materialdesignicons.min.css">
  <link rel="stylesheet" href="<?php echo $url;?>vendors/css/vendor.bundle.base.css">
  <link rel="stylesheet" href="<?php echo $url;?>css/style.css">
</head>

<body>
  <div class="container-scroller">
    <div class="container-fluid page-body-wrapper full-page-wrapper">
      <div class="content-wrapper d-flex align-items-center auth">
        <div class="row w-100">
          <div class="col-lg-4 mx-auto">
            <div class="auth-form-light text-left p-5">
             
              <center><h4> FORM LOGIN</h4>
			  <br>
              <h6 class="font-weight-light"><?php echo ucwords($judul); ?></h6></center>
              <form class="pt-3" action="" method="post" >
                <div class="form-group">
                  <input  class="form-control" name="username" type="text" placeholder="Username">
                </div>
                <div class="form-group">
                   <input class="form-control" name="password" placeholder="Password" type="password">
                </div>
                <div class="mt-3">
                
				  
				  <button type="submit" type='submit' name="login" class="btn btn-block btn-gradient-primary btn-lg font-weight-medium auth-form-btn">LOGIN</button>
                </div>
				
				<div class="mt-3">
                  <a class="btn btn-block btn-gradient-primary btn-lg font-weight-medium auth-form-btn" href="../../">CANCEL</a>
                </div>
                <br>
                <br>
              <center><?php echo $copyright; ?></center>
			  <br>
                <br>
              </form>
            </div>
          </div>
        </div>
      </div>
      <!-- content-wrapper ends -->
    </div>
    <!-- page-body-wrapper ends -->
  </div>
  <!-- container-scroller -->
  <!-- plugins:js -->
  <script src="<?php echo $url;?>vendors/js/vendor.bundle.base.js"></script>
  <script src="<?php echo $url;?>vendors/js/vendor.bundle.addons.js"></script>
  <!-- endinject -->
  <!-- inject:js -->
  <script src="<?php echo $url;?>js/off-canvas.js"></script>
  <script src="<?php echo $url;?>js/misc.js"></script>
  <!-- endinject -->
</body>

</html>
