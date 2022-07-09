<?php 
require_once('../../../include/all_include.php');

$id_admin=isset($_POST["id_admin"]) ? $_POST["id_admin"]:"";
$nama=isset($_POST["nama"]) ? $_POST["nama"]:"";
$username=isset($_POST["username"]) ? $_POST["username"]:"";
$password=isset($_POST["password"]) ? $_POST["password"]:"";


$query=mysql_query("insert into data_admin values (
'$id_admin'
,'$nama'
,'$username'
,'$password'

)");

$resp = [];
if($query){
	$resp["status"]="success";
}
else
{
	$resp["status"]="gagal";
}

echo (json_encode($resp)) 
?>
