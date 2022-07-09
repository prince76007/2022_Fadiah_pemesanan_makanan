<?php 
require_once('../../../include/all_include.php');

$id_kategori=isset($_POST["id_kategori"]) ? $_POST["id_kategori"]:"";
$kategori=isset($_POST["kategori"]) ? $_POST["kategori"]:"";


$query=mysql_query("insert into data_kategori values (
'$id_kategori'
,'$kategori'

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
