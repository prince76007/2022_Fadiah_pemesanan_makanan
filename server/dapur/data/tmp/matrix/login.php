<?php
 
$default_url = '../data/tmp/tmp 27';
$tema = '27-matrix-admin-package_d82853cb5dfa9baef';
$url = $default_url.'/'.$tema;
?>

<!DOCTYPE html>
<html lang="en">
<?php include '../include/function/login.php';?>    


<!DOCTYPE html>
<html lang="en">
    
<head>
        
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link rel="stylesheet" href="<?php echo $url;?>/css/bootstrap.min.css" />
		<link rel="stylesheet" href="<?php echo $url;?>/css/bootstrap-responsive.min.css" />
        <link rel="stylesheet" href="<?php echo $url;?>/css/matrix-login.css" />
        <link href="<?php echo $url;?>/font-awesome/css/font-awesome.css" rel="stylesheet" />
		<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>

    </head>
    <body>
        <div id="loginbox">            
            <form id="loginform" class="form-vertical" method="post" action="">
				 <div class="control-group normal_text"> <h3>Form Login</h3></div>
                <div class="control-group">
                    <div class="controls">
                        <div class="main_input_box">
                            <span class="add-on bg_lg"><i class="icon-user"> </i></span><input type="text" name="username" placeholder="username" />
                        </div>
                    </div>
                </div>
                <div class="control-group">
                    <div class="controls">
                        <div class="main_input_box">
                            <span class="add-on bg_ly"><i class="icon-lock"></i></span><input type="password" name="password" placeholder="password" />
                        </div>
                    </div>
                </div>
                <div class="form-actions">
                    <span class="pull-left"><a href="../../" class="flip-link btn btn-info" id="to-recover">Cancel</a></span>
                    <span class="pull-right"><button type="submit" name="login" class="btn btn-success" /> Login</button></span>
                </div>
            </form>
            
        </div>
        
        <script src="<?php echo $url;?>/js/jquery.min.js"></script>  
        <script src="<?php echo $url;?>/js/matrix.login.js"></script> 
    </body>

</html>


</html>
