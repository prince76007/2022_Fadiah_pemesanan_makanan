<?php 

$default_url = '../../../data/tmp/matrix';
$url = $default_url.'/file';
include '../../../include/all_include.php';
include '../../../include/function/session.php'; 
?>

<link rel="stylesheet" href="<?php echo $url;?>/css/bootstrap.min.css"/>
<link
    rel="stylesheet"
    href="<?php echo $url;?>/css/bootstrap-responsive.min.css"/>
<link rel="stylesheet" href="<?php echo $url;?>/css/uniform.css"/>
<link rel="stylesheet" href="<?php echo $url;?>/css/select2.css"/>
<link rel="stylesheet" href="<?php echo $url;?>/css/matrix-style.css"/>
<link rel="stylesheet" href="<?php echo $url;?>/css/matrix-media.css"/>
<link
    href="<?php echo $url;?>/font-awesome/css/font-awesome.css"
    rel="stylesheet"/>
<link
    href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800'
    rel='stylesheet'
    type='text/css'>
</head>
<body>

<div id="header" style="
    background: #12c2e9;  /* fallback for old browsers */
    background: -webkit-linear-gradient(to right, #f64f59, #c471ed, #12c2e9);  /* Chrome 10-25, Safari 5.1-6 */
    background: linear-gradient(to right, #f64f59, #c471ed, #12c2e9); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
    padding: 2px;
">
  <h2>
      <font color='white'>
    <?= ucwords($judul);?>
    </font>
</h2>
</div>

<div id="search">
    <a class="btn btn-danger" href="<?php home();?>"></i>
    Home</span></a>
<a class="btn btn-danger" href="<?php logout();?>"></i>
Logout</span></a>
</div>

<div id="sidebar">
<a href="#" class="visible-phone">
<i class="icon icon-th"></i>Tables</a>
<ul >

<!-- MENU -->
<?php
$m = new SimpleXMLElement('../../../include/settings/menu.xml', null, true);
foreach($m as $i){if($i->t == 's' ){
?>
<!-- SINGLE -->
<li>
<a href="<?php echo $i->l;?>">
<i class="<?php echo $i->i;?>"></i>
<span><?php echo $i->n;?></span></a>
</li>
<!-- /SINGLE -->
<?php
}else if($i->t == 'm' ){ $idmenu = $i->id;
?>
<!-- MULTI -->
<li class="submenu">
<a href="#">
<i class="<?php echo $i->i;?>"></i>
<span><?php echo $i->n;?></span>
<span class="label label-important"></span></a>
<ul>
<?php
		$m1 = new SimpleXMLElement('../../../include/settings/menu.xml', null, true);
		foreach($m1 as $i1) {
		if($i1->s=="$idmenu" and $i1->t=="sm" ){
		?>
<li>
    <a class="item" href="<?php echo $i1->l;?>">
        <i class="<?php echo $i1->i;?>"></i>
        <?php echo $i1->n;?></a>
</li>
<?php }} ?>
</ul>
</li>

<!-- /MULTI -->
<?php }} ?>
<!-- /MENU -->

</ul>
</div>

<div id="content">
    <br><br><br><br>
<div id="content-header">

<div class="container-fluid">
<hr>
<div class="row-fluid">
<div class="span12">
    <div class="widget-box">
        <div class="widget-title">
            <span class="icon">
                <i class="icon-table"></i>
            </span>
            <h5><?php tabelnomin();?></h5>
        </div>
        <div class="widget-content">
            <?php include 'halaman.php'; ?>
        </div>
    </div>
</div>
</div>
</div>

</div>
<!--Footer-part-->
<div class="row-fluid">
<div id="footer" class="span12">
<?php echo $copyright;?>
</div>
</div>
<!--end-Footer-part-->
<script src="<?php echo $url;?>/js/jquery.min.js"></script>
<script src="<?php echo $url;?>/js/jquery.ui.custom.js"></script>
<script src="<?php echo $url;?>/js/bootstrap.min.js"></script>
<script src="<?php echo $url;?>/js/jquery.uniform.js"></script>
<script src="<?php echo $url;?>/js/select2.min.js"></script>
<script src="<?php echo $url;?>/js/jquery.dataTables.min.js"></script>
<script src="<?php echo $url;?>/js/matrix.js"></script>
<script src="<?php echo $url;?>/js/matrix.tables.js"></script>
</body>
</html>