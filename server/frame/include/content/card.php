<?php function cardimage($judul,$tombol,$gambar,$warna_background,$tombol_css,$link)
{ ?>
<div class="card card-image" style="background-image: url(<?php echo $gambar;?>);">
  <div class="text-white text-center d-flex align-items-center rgba-<?php echo $warna_background;?>-strong py-5 px-4">
    <div>
      <h3 class="card-title pt-2"><strong><?php echo $judul;?></strong></h3>
      <a href="<?php echo $link;?>" class="<?php echo $tombol_css;?>"><i class="fas fa-clone left"></i><?php echo $tombol;?></a>
    </div>
  </div>
</div>
<?php } ?>


<?php function cardgradient($judul,$deskripsi,$gambar,$warna_background,$link)
{ ?>
<div class="col-md-6 mb-4" onclick="window.location.href = '<?php echo $link;?>';">
    <div class="card gradient-card">
        <div class="card-image" style="background-image: url(<?php echo $gambar;?>);">
          <a href="#!">
            <div class="text-white d-flex h-100 mask <?php echo $warna_background;?>-gradient-rgba">
              <div class="first-content align-self-center p-3">
                <h3 class="card-title"><?php echo $judul;?></h3>
                <p class="lead mb-0"><?php echo $deskripsi;?></p>
              </div>
            </div>
          </a>
        </div>
    </div>
  </div>
<?php } ?>


<?php function cardblockquote($judul,$deskripsi,$link)
{ ?>
<div class="card p-3 mb-3" onclick="window.location.href = '<?php echo $link;?>';">
    <blockquote class="blockquote mb-0 card-body">
      <p><?php echo $judul;?></p>
      <footer class="blockquote-footer">
        <small class="text-muted">
         Memiliki <cite title="Source Title"><?php echo $deskripsi;?></cite>
        </small>
      </footer>
    </blockquote>
  </div>
<?php } ?>