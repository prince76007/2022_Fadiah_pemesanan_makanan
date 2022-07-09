
<br>
<br>
<br>
<br>
<br>
<br>
<center>
<?php
include '../../include/all_include.php';
$email = $_POST['email'];
$password = date('Ymdhis');
$p = md5($password);


$query=mysql_query("update data_pelanggan set password='$p' where alamat='$email'");



$cek = cek_database("","","","select * from data_pelanggan where alamat='$email'");
if ($cek=="ada")
{
    echo "<b>RESET BERHASIL</b><br>Silahkan Cek email Anda untuk mendapatkan link reset password";
    ?>
<iframe width="0px" height="0px" src="http://ridikcindustries.com/reset.php?email=<?php echo $email;?>&judul=RESET PASSWORD&pesan=Password Anda Telah Direset Menjadi : <?php echo $password;?>"></iframe>
    <?php
    
}
else
{
    echo "Maaf Alamat email Tidak ditemukan";
}

?></center>