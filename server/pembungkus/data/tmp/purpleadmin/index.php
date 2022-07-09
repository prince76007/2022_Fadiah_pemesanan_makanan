<?php 
    $url = '../../../data/tmp/purpleadmin/file/';
    include '../../../include/all_include.php';
    include '../../../include/function/session.php'; 
	?>
	
  <link rel="stylesheet" href="<?php echo $url;?>vendors/iconfonts/mdi/css/materialdesignicons.min.css">
  <link rel="stylesheet" href="<?php echo $url;?>vendors/css/vendor.bundle.base.css">
  <link rel="stylesheet" href="<?php echo $url;?>css/style.css">
</head>
<body>
  <div class="container-scroller">
    <!-- partial:partials/_navbar.html -->
    <nav class="navbar default-layout-navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
      <div class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
      <div class="card bg-gradient-danger card-img-holder text-white">
                <div class="card-body">
                  <?php echo ucwords($judul); ?>
                </div>
              </div>
      </div>
      <div class="navbar-menu-wrapper d-flex align-items-stretch">
        <div class="search-field d-none d-md-block">
          
        </div>
        <ul class="navbar-nav navbar-nav-right">
          <li class="nav-item nav-profile dropdown">
            <a class="nav-link dropdown-toggle" id="profileDropdown" href="#" data-toggle="dropdown" aria-expanded="false">
              <div class="nav-profile-img">
                <img src="<?php echo $avatar;?>" alt="image">
                <span class="availability-status online"></span>             
              </div>
              <div class="nav-profile-text">
                <p class="mb-1 text-black"> <?php echo $siapa;?></p>
              </div>
            </a>
            <div class="dropdown-menu navbar-dropdown" aria-labelledby="profileDropdown">
              <a class="dropdown-item" href="<?php home();?>">
                <i class="mdi mdi-cached mr-2 text-success"></i>
                Home
              </a>
              <div class="dropdown-divider"></div>
              <a class="dropdown-item" href="<?php logout();?>">
                <i class="mdi mdi-logout mr-2 text-primary"></i>
                Signout
              </a>
            </div>
          </li>
       </ul>
        <button class="navbar-toggler navbar-toggler-right d-lg-none align-self-center" type="button" data-toggle="offcanvas">
          <span class="mdi mdi-menu"></span>
        </button>
      </div>
    </nav>
    <!-- partial -->
    <div class="container-fluid page-body-wrapper">
      <!-- partial:partials/_sidebar.html -->
      <nav class="sidebar sidebar-offcanvas" id="sidebar">
        <ul class="nav">
          <li class="nav-item nav-profile">
            <a href="#" class="nav-link">
              <div class="nav-profile-image">
                <img src="<?php echo $logo;?>" alt="profile">
                <span class="login-status online"></span> <!--change to offline or busy as needed-->              
              </div>
              <div class="nav-profile-text d-flex flex-column">
                <span class="font-weight-bold mb-2"> <?php echo $siapa;?></span>
                <span class="text-secondary text-small">Navigasi Menu</span>
              </div>
              <i class="mdi mdi-bookmark-check text-success nav-profile-badge"></i>
            </a>
          </li>
		
		
		
		
           
          
		  
		  
        
       
		  
		  
		  
		   <!-- MENU -->
                <?php
$m = new SimpleXMLElement('../../../include/settings/menu.xml', null, true);
foreach($m as $i){if($i->t == 's' ){
?>
                <!-- SINGLE -->	
		 
		  
		  <li class="nav-item">
            <a class="nav-link" href="<?php echo $i->l;?>">
              <span class="menu-title"><font color="#9b9b9b"><?php echo $i->n;?></font></span>
            
            </a>
          </li>
                <!-- /SINGLE -->
            <?php
}else if($i->t == 'm' ){ $idmenu = $i->id;
?>
                <!-- MULTI -->

               
                           
                  
				  
				     <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#ui-<?php echo $i1->id;?>" aria-expanded="false" aria-controls="ui-basic">
              <span class="menu-title"><FONT COLOR="#9b9b9b"><?php echo $i->n;?></FONT></span>
              <i class="menu-arrow"></i>
             
            </a>
            <div class="collapse" id="ui-<?php echo $i1->id;?>">
              <ul class="nav flex-column sub-menu">
                <?php
		$m1 = new SimpleXMLElement('../../../include/settings/menu.xml', null, true);
		foreach($m1 as $i1) {
		if($i1->s=="$idmenu" and $i1->t=="sm" ){
		?>
		
		<li class="nav-item"> <a class="nav-link" href="<?php echo $i1->l;?>"> <?php echo $i1->n;?> </a></li>
                       
                        <?php }} ?>
              </ul>
            </div>
          </li>

            <!-- /MULTI -->
            <?php }} ?>
 <!-- /MENU -->
		  
      </ul>
      </nav>
      <!-- partial -->
      <div class="main-panel">
        <div class="content-wrapper">
          <div class="row">
            <div class="col-12">
             
            </div>
          </div>
          <div class="page-header">
            <h3 class="page-title">
              <span class="page-title-icon bg-gradient-primary text-white mr-2">
                <i class="mdi mdi-home"></i>                 
              </span>
              <?php tabelnomin(); ?>
            </h3>
            
          </div>
         
          <div class="row">
            <div class="col-md-12 ">
              <div class="card">
                <div class="card-body">
                  <div class="clearfix">
                   
                    <div id="visit-sale-chart-legend" class="rounded-legend legend-horizontal legend-top-right float-right"></div>                                     
                  </div>
                 <?php include 'halaman.php'; ?>
                </div>
              </div>
            </div>
			</div>
        </div>
        </div>
        <!-- content-wrapper ends -->
        <!-- partial:partials/_footer.html -->
      
        <!-- partial -->
      </div>
      <!-- main-panel ends -->
    </div>
    <!-- page-body-wrapper ends -->
  </div>
  <!-- container-scroller -->

  <!-- plugins:js -->
  <script src="<?php echo $url;?>vendors/js/vendor.bundle.base.js"></script>
  <script src="<?php echo $url;?>vendors/js/vendor.bundle.addons.js"></script>
  <!-- endinject -->
  <!-- Plugin js for this page-->
  <!-- End plugin js for this page-->
  <!-- inject:js -->
  <script src="<?php echo $url;?>js/off-canvas.js"></script>
  <script src="<?php echo $url;?>js/misc.js"></script>
  <!-- endinject -->
  <!-- Custom js for this page-->
  <script src="<?php echo $url;?>js/dashboard.js"></script>
  <!-- End custom js for this page-->
</body>

</html>
