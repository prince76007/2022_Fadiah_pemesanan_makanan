<?php
function maps($tabel,$id,$nama_lokasi,$lat,$lng,$no_telepon,$alamat,$pengelola,$foto)
{

if(isset($_GET['maps']))
{
	?>
<div class="card card-cascade narrower">
			<div class="view view-cascade overlay">
			</div>
			<div class="card-body card-body-cascade">
<?php } ?>
	<div class="mdl-grid">
	<div id="dvMap" style="width: 100%; height: 500px"></div>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAqhJ6sg9DMHKhLvWrzUs96NDMemaDXriw&callback=initMap&libraries=geometry" async defer></script>
  <script type="text/javascript">
    var markers = [
    <?php
	if (isset($_GET['selengkapnya']))
	{
		$ids = decrypt($_GET['selengkapnya']);
		$querytabel="SELECT * FROM $tabel where $id='$ids'";

	}
	else
	{
		$querytabel = "SELECT * FROM $tabel ";
	}
    $proses = mysql_query($querytabel);
    while(($data =  mysql_fetch_assoc($proses))) {
    ?>
    {
                 "nama": '<?php echo $data[$nama_lokasi]; ?>',
                 "no_telepon": '<?php echo $data[$no_telepon]; ?>',
                 "foto": '<?php echo $data[$foto]; ?>',
                 "lat": '<?php echo $data[$lat]; ?>',
                 "long": '<?php echo $data[$lng]; ?>',
                 "pengelola": '<?php echo $data[$pengelola]; ?>',
                 "alamat": '<?php //echo $data[$alamat]; ?>'
    },
    <?php
    }
    ?>
    ];
    </script>
    <script type="text/javascript">
        window.onload = function () {
            var mapOptions = {
               zoom: 0,
                mapTypeId: google.maps.MapTypeId.ROADMAP
            }; 
            var infoWindow = new google.maps.InfoWindow();

            var bounds = new google.maps.LatLngBounds();
            var map = new google.maps.Map(document.getElementById("dvMap"), mapOptions);
            for (i = 0; i < markers.length; i++) {
                var data = markers[i];
        var latnya = data.lat;
        var longnya = data.long;
        var myLatlng = new google.maps.LatLng(latnya, longnya);
        bounds.extend(myLatlng);
                
                var icon = {
                      url: '../../../admin/upload/' + data.foto, // url
                      scaledSize: new google.maps.Size(100, 50), // scaled size
                      origin: new google.maps.Point(0,0), // origin
                      anchor: new google.maps.Point(0, 0), // anchor
                      labelOrigin: new google.maps.Point(50, -15)
                };
                
                var marker = new google.maps.Marker({
                    position: myLatlng,
                    icon: icon,
                    map: map,
                    label: {text: data.nama, color: "red", padding: 50}
                });
                (function (marker, data) {
                    google.maps.event.addListener(marker, "click", function (e) {
                        infoWindow.setContent('<b>' + data.nama + '</b><br>'+
                                      '<b><?php echo ucwords($alamat);?></b> :' + data.alamat + '<br>'+
                                      '<b><?php echo ucwords($no_telepon);?></b> :' + data.no_telepon + '<br>'+
                                      '<b><?php echo ucwords($pengelola);?></b> :' + data.pengelola + '<br><br>' +
                                      ''
                                      );
                        infoWindow.open(map, marker);
                    });
                })(marker, data);
                map.fitBounds(bounds);  
            }
        }
    </script>
  </div>
  
  </div>
<?php
  if(isset($_GET['maps']))
{
	?>

			</div>

<?php } ?>
<?php
}
?>