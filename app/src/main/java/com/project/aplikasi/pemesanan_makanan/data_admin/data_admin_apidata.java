package com.project.aplikasi.pemesanan_makanan.data_admin;

public class data_admin_apidata {
    private String id_admin;
      private String nama;
      private String username;
      private String password;

	
	
	public data_admin_apidata(String id_admin
	,String nama
	,String username
	,String password

	) {
        this.id_admin = id_admin;
        this.nama = nama;
        this.username = username;
        this.password = password;

    }

    public String get_id_admin() {
        return id_admin;
    }
    public void set_id_admin(String id_admin) {
        this.id_admin = id_admin;
    }

    public String get_nama() {
        return nama;
    }
    public void set_nama(String nama) {
        this.nama = nama;
    }
    public String get_username() {
        return username;
    }
    public void set_username(String username) {
        this.username = username;
    }
    public String get_password() {
        return password;
    }
    public void set_password(String password) {
        this.password = password;
    }

}
