
<?php
$default_url = '../../../data/tmp/tmp 4';
$tema = '4-ace-master';
$url = $default_url.'/'.$tema;

?>
<?php include '../../../include/all_include.php';        include '../../../include/function/session.php';  ?>

		<link rel="stylesheet" href="<?php echo $url; ?>/assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="<?php echo $url; ?>/assets/font-awesome/4.5.0/css/font-awesome.min.css" />
		<link rel="stylesheet" href="<?php echo $url; ?>/assets/css/jquery-ui.custom.min.css" />
		<link rel="stylesheet" href="<?php echo $url; ?>/assets/css/chosen.min.css" />
		<link rel="stylesheet" href="<?php echo $url; ?>/assets/css/bootstrap-datepicker3.min.css" />
		<link rel="stylesheet" href="<?php echo $url; ?>/assets/css/bootstrap-timepicker.min.css" />
		<link rel="stylesheet" href="<?php echo $url; ?>/assets/css/daterangepicker.min.css" />
		<link rel="stylesheet" href="<?php echo $url; ?>/assets/css/bootstrap-datetimepicker.min.css" />
		<link rel="stylesheet" href="<?php echo $url; ?>/assets/css/bootstrap-colorpicker.min.css" />
		<link rel="stylesheet" href="<?php echo $url; ?>/assets/css/fonts.googleapis.com.css" />
		<link rel="stylesheet" href="<?php echo $url; ?>/assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />
		<link rel="stylesheet" href="<?php echo $url; ?>/assets/css/ace-skins.min.css" />
		<link rel="stylesheet" href="<?php echo $url; ?>/assets/css/ace-rtl.min.css" />
		<script src="<?php echo $url; ?>/assets/js/ace-extra.min.js"></script>
	</head>

	<body class="skin-3 no-skin">
	
		<div id="navbar" class="navbar navbar-default ace-save-state">
			<div class="navbar-container ace-save-state" id="navbar-container">
				<button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
					<span class="sr-only">
					
					<?php echo $judul; ?></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>

				<div class="navbar-header pull-left">
					<a href="index.html" class="navbar-brand">
						<small>
							<i class="fa fa-leaf"></i>
							<?php echo strtolower($judul); ?>
						</small>
					</a>
				</div>

				<div class="navbar-buttons navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">
					<!--
						<li class="grey dropdown-modal">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="ace-icon fa fa-tasks"></i>
								<span class="badge badge-grey"></span>
							</a>
						</li>

						<li class="purple dropdown-modal">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="ace-icon fa fa-bell icon-animated-bell"></i>
								<span class="badge badge-important"></span>
							</a>
						</li>

						<li class="green dropdown-modal">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="ace-icon fa fa-envelope icon-animated-vertical"></i>
								<span class="badge badge-success"></span>
							</a>
						</li>
						-->

					<li class="light-blue dropdown-modal">
						<a
							data-toggle="dropdown"
							href="#"
							class="dropdown-toggle"
							style="
						background-color: #c6487e;
					">
								<img class="nav-user-photo" src="<?php echo $avatar; ?>" alt="Jason's Photo" />
								<span class="user-info">
									<small>Welcome,</small>
									Administrator
								</span>

								<i class="ace-icon fa fa-caret-down"></i>
							</a>

							<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a href="<?php home();?>">
										<i class="ace-icon fa fa-cog"></i>
										Home
									</a>
								</li>


								<li class="divider"></li>

								<li>
									<a href="<?php logout();?>">
										<i class="ace-icon fa fa-power-off"></i>
										Logout
									</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</div>

		<div class="main-container ace-save-state" id="main-container">
			<script type="text/javascript">
				try{ace.settings.loadState('main-container')}catch(e){}
			</script>

			<div id="sidebar" class="sidebar                  responsive                    ace-save-state">
				<script type="text/javascript">
					try{ace.settings.loadState('sidebar')}catch(e){}
				</script>
<!--
				<div class="sidebar-shortcuts" id="sidebar-shortcuts">
					<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
						<button class="btn btn-success">
							<i class="ace-icon fa fa-signal"></i>
						</button>

						<button class="btn btn-info">
							<i class="ace-icon fa fa-pencil"></i>
						</button>

						<button class="btn btn-warning">
							<i class="ace-icon fa fa-users"></i>
						</button>

						<button class="btn btn-danger">
							<i class="ace-icon fa fa-cogs"></i>
						</button>
					</div>

					<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
						<span class="btn btn-success"></span>

						<span class="btn btn-info"></span>

						<span class="btn btn-warning"></span>

						<span class="btn btn-danger"></span>
					</div>
				</div>
-->
				<ul class="nav nav-list">
				
					<li class="active">
						<a href="#">
							
							<span class="menu-text"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Menu Administrator </span>
						</a>

						<b class="arrow"></b>
					</li>
				
					
<!-- MENU -->
<?php
$m = new SimpleXMLElement('../../../include/settings/menu.xml', null, true);
foreach($m as $i){if($i->t == 's' ){
?>
<!-- SINGLE -->
					<li class="">
						<a href="<?php echo $i->l;?>">
							<i class="menu-icon <?php echo $i->i;?>"></i>
							<span class="menu-text"> <?php echo $i->n;?> </span>
						</a>

						<b class="arrow"></b>
					</li>
<!-- /SINGLE -->
<?php
}else if($i->t == 'm' ){ $idmenu = $i->id;
?>
<!-- MULTI -->
		
<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon <?php echo $i->i;?>"></i>
							<span class="menu-text">
								<?php echo $i->n;?>
							</span>

							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>

						<ul class="submenu">

							<li class="">
							<b class="arrow"></b>
								<?php
		$m1 = new SimpleXMLElement('../../../include/settings/menu.xml', null, true);
		foreach($m1 as $i1) {
		if($i1->s=="$idmenu" and $i1->t=="sm" ){
		?>
            <li>
				<a class="item" onclick="window.location = '<?php echo $i1->l;?>'">
				<i class="<?php echo $i1->i;?>"></i> <?php echo $i1->n;?></a>
				</li>
		<?php }} ?>
							<b class="arrow"></b>
							</li>

						</ul>	
					</li>

<!-- /MULTI -->
		<?php }} ?>
<!-- /MENU -->


					
					</ul>
					

				<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
					<i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
				</div>
			</div>

			<div class="main-content">
				<div class="main-content-inner">
					<div class="breadcrumbs ace-save-state" id="breadcrumbs">
						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="#">Menu</a>
							</li>

							<li>
								<a href="#">Table</a>
							</li>
							<li class="active"><?php tabelnomin();?></li>
						</ul>
					</div>

					<div class="page-content">
						<div class="ace-settings-container" id="ace-settings-container">
							<div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
								<i class="ace-icon fa fa-cog bigger-130"></i>
							</div>

							<div class="ace-settings-box clearfix" id="ace-settings-box">
								<div class="pull-left width-50">
									<div class="ace-settings-item">
										<div class="pull-left">
											<select id="skin-colorpicker" class="hide">
												<option data-skin="no-skin" value="#438EB9">#438EB9</option>
												<option data-skin="skin-1" value="#222A2D">#222A2D</option>
												<option data-skin="skin-2" value="#C6487E">#C6487E</option>
												<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
											</select>
										</div>
										<span>&nbsp; Choose Skin</span>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2 ace-save-state" id="ace-settings-navbar" autocomplete="off" />
										<label class="lbl" for="ace-settings-navbar"> Fixed Navbar</label>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2 ace-save-state" id="ace-settings-sidebar" autocomplete="off" />
										<label class="lbl" for="ace-settings-sidebar"> Fixed Sidebar</label>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2 ace-save-state" id="ace-settings-breadcrumbs" autocomplete="off" />
										<label class="lbl" for="ace-settings-breadcrumbs"> Fixed Breadcrumbs</label>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl" autocomplete="off" />
										<label class="lbl" for="ace-settings-rtl"> Right To Left (rtl)</label>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2 ace-save-state" id="ace-settings-add-container" autocomplete="off" />
										<label class="lbl" for="ace-settings-add-container">
											Inside
											<b>.container</b>
										</label>
									</div>
								</div><!-- /.pull-left -->

								<div class="pull-left width-50">
									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-hover" autocomplete="off" />
										<label class="lbl" for="ace-settings-hover"> Submenu on Hover</label>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-compact" autocomplete="off" />
										<label class="lbl" for="ace-settings-compact"> Compact Sidebar</label>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-highlight" autocomplete="off" />
										<label class="lbl" for="ace-settings-highlight"> Alt. Active Item</label>
									</div>
								</div><!-- /.pull-left -->
							</div><!-- /.ace-settings-box -->
						</div>

						
<div class="col-xs-12 col-sm-12 widget-container-col ui-sortable" id="widget-container-col-1">
											
										<div class="widget-box ui-sortable-handle" id="widget-box-1">
												<div class="widget-header">
													<h5 class="widget-title"><?php tabelnomin();?></h5>

													<div class="widget-toolbar">

														<a href="#" data-action="fullscreen" class="orange2">
															<i class="ace-icon fa fa-expand"></i>
														</a>

														<a href="#" data-action="reload">
															<i class="ace-icon fa fa-refresh"></i>
														</a>

														<a href="#" data-action="collapse">
															<i class="ace-icon fa fa-chevron-up"></i>
														</a>

														<a href="#" data-action="close">
															<i class="ace-icon fa fa-times"></i>
														</a>
													</div>
												</div>

												<div class="widget-body" style="display: block;">
													<div class="widget-main ace-scroll scroll-disabled" style="position: relative;"><div class="scroll-track" style="display: none;"><div class="scroll-bar" style="top: 0px;"></div></div><div class="scroll-content" style="">
															<?php include 'halaman.php'; ?>
													</div></div>
												</div>
											</div></div>
						
						
					
															
														
								
								
										
						
						</div>
					</div>
				</div>
			</div>

			<div class="footer">
				<div class="footer-inner">
					<div class="">
						<span class="bigger-120">
							<?php echo $copyright; ?>
						</span>

						
					</div>
				</div>
			</div>

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		</div>
		<script src="<?php echo $url; ?>/assets/js/jquery-2.1.4.min.js"></script>
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="<?php echo $url; ?>/assets/js/bootstrap.min.js"></script>
		<script src="<?php echo $url; ?>/assets/js/jquery-ui.custom.min.js"></script>
		<script src="<?php echo $url; ?>/assets/js/jquery.ui.touch-punch.min.js"></script>
		<script src="<?php echo $url; ?>/assets/js/chosen.jquery.min.js"></script>
		<script src="<?php echo $url; ?>/assets/js/spinbox.min.js"></script>
		<script src="<?php echo $url; ?>/assets/js/bootstrap-datepicker.min.js"></script>
		<script src="<?php echo $url; ?>/assets/js/bootstrap-timepicker.min.js"></script>
		<script src="<?php echo $url; ?>/assets/js/moment.min.js"></script>
		<script src="<?php echo $url; ?>/assets/js/daterangepicker.min.js"></script>
		<script src="<?php echo $url; ?>/assets/js/bootstrap-datetimepicker.min.js"></script>
		<script src="<?php echo $url; ?>/assets/js/bootstrap-colorpicker.min.js"></script>
		<script src="<?php echo $url; ?>/assets/js/jquery.knob.min.js"></script>
		<script src="<?php echo $url; ?>/assets/js/autosize.min.js"></script>
		<script src="<?php echo $url; ?>/assets/js/jquery.inputlimiter.min.js"></script>
		<script src="<?php echo $url; ?>/assets/js/jquery.maskedinput.min.js"></script>
		<script src="<?php echo $url; ?>/assets/js/bootstrap-tag.min.js"></script>
		<script src="<?php echo $url; ?>/assets/js/ace-elements.min.js"></script>
		<script src="<?php echo $url; ?>/assets/js/ace.min.js"></script>

		