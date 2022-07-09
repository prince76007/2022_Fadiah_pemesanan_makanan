<?php
include '../include/function/login.php';
$default_url = '../data/tmp/tmp 4';
$tema = '4-ace-master';
$url = $default_url.'/'.$tema;
?>


<!DOCTYPE html>
<html lang="en" style="
    background-color: #87b87f;
">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<meta name="description" content="User login page" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		<link rel="stylesheet" href="<?php echo $url; ?>/assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="<?php echo $url; ?>/assets/font-awesome/4.5.0/css/font-awesome.min.css" />
		<link rel="stylesheet" href="<?php echo $url; ?>/assets/css/fonts.googleapis.com.css" />
		<link rel="stylesheet" href="<?php echo $url; ?>/assets/css/ace.min.css" />
		<link rel="stylesheet" href="<?php echo $url; ?>/assets/css/ace-part2.min.css" />
		<link rel="stylesheet" href="<?php echo $url; ?>/assets/css/ace-ie.min.css" />
		<script src="<?php echo $url; ?>/assets/js/html5shiv.min.js"></script>
		<script src="<?php echo $url; ?>/assets/js/respond.min.js"></script>

		<style>
		.main-container:before {
    display: block;
    content: "";
    position: absolute;
    z-index: -2;
    width: 100%;
    max-width: inherit;
    bottom: 0;
    top: 0;
    background-color: #87b87f;
}
		</style>

	</head>

	<body   style="
    background-color: #87b87f;
">
		<div class="main-container" style="
    background-color: #87b87f;
">
			<div class="main-content" style="
    background-color: #87b87f;
">
				<div class="row" style="
    background-color: #87b87f;
">
					<div class="col-sm-10 col-sm-offset-1">
						<div class="login-container">
							<div class="center">
								<br>
								<br>
								<br>
								<h4  style="text-shadow: 4px 4px 6px rgba(15,6,4,0.64);
				color: #FAFAFA;" id="id-company-text"><?php echo $judul;?></h4>
							</div>

							<div class="space-6"></div>

							<div class="position-relative">
								<div id="login-box" style="-webkit-box-shadow: 2px 11px 32px -1px rgba(0,0,0,0.75);
-moz-box-shadow: 2px 11px 32px -1px rgba(0,0,0,0.75);
box-shadow: 2px 11px 32px -1px rgba(0,0,0,0.75);" class="login-box visible no-border">
									<div class="widget-body">
										<div class="widget-main">
										
											<div class="space-6"></div>

											<form class="form-login" action="" method="post">
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" class="form-control" name="username" placeholder="Username" />
															<i class="ace-icon fa fa-user"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" name="password" class="form-control" placeholder="Password" />
															<i class="ace-icon fa fa-lock"></i>
														</span>
													</label>

													<div class="space"></div>

													<div class="clearfix">
														

													
														
														<input type="submit" name="login" value="login" class="width-35 pull-right btn btn-sm btn-success" />
														
														
													</div>

													<div class="space-4"></div>
												</fieldset>
											</form>

											

											<div class="space-6"></div>

											
										</div><!-- /.widget-main -->

									
									</div><!-- /.widget-body -->
								</div><!-- /.login-box -->
</div><!-- /.position-relative -->

							<!-- <div class="navbar-fixed-top align-right">
								<br />
								&nbsp;
								<a id="btn-login-dark" href="#">Dark</a>
								&nbsp;
								<span class="blue">/</span>
								&nbsp;
								<a id="btn-login-blur" href="#">Blur</a>
								&nbsp;
								<span class="blue">/</span>
								&nbsp;
								<a id="btn-login-light" href="#">Light</a>
								&nbsp; &nbsp; &nbsp;
							</div> -->
						</div>
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div><!-- /.main-content -->
		</div><!-- /.main-container -->

		<!-- basic scripts -->

		<!--[if !IE]> -->
		<script src="<?php echo $url; ?>/assets/js/jquery-2.1.4.min.js"></script>

		<!-- <![endif]-->

		<!--[if IE]>
<script src="assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>

		<!-- inline scripts related to this page -->
		<script type="text/javascript">
			jQuery(function($) {
			 $(document).on('click', '.toolbar a[data-target]', function(e) {
				e.preventDefault();
				var target = $(this).data('target');
				$('.widget-box.visible').removeClass('visible');//hide others
				$(target).addClass('visible');//show target
			 });
			});
			
			
			
			//you don't need this, just used for changing background
			jQuery(function($) {
			 $('#btn-login-dark').on('click', function(e) {
				$('body').attr('class', 'login-layout');
				$('#id-text2').attr('class', 'white');
				$('#id-company-text').attr('class', 'blue');
				
				e.preventDefault();
			 });
			 $('#btn-login-light').on('click', function(e) {
				$('body').attr('class', 'login-layout light-login');
				$('#id-text2').attr('class', 'grey');
				$('#id-company-text').attr('class', 'blue');
				
				e.preventDefault();
			 });
			 $('#btn-login-blur').on('click', function(e) {
				$('body').attr('class', 'login-layout blur-login');
				$('#id-text2').attr('class', 'white');
				$('#id-company-text').attr('class', 'light-blue');
				
				e.preventDefault();
			 });
			 
			});
		</script>
	</body>
</html>
