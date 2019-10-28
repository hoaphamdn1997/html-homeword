package model.bean;

public class User {
	private String username,password,tenNguoiDung,soDienThoai,diaChi,email,tenNhaXe;
	private boolean trangThai;
	private int phanQuyen,maNguoiDung;
	
	   
	public User(int maNguoiDung, String username, String password, String tenNguoiDung, String soDienThoai,
			String diaChi, String email, boolean trangThai, int phanQuyen) {
		super();
		this.maNguoiDung = maNguoiDung;
		this.username = username;
		this.password = password;
		this.tenNguoiDung = tenNguoiDung;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.email = email;
		this.trangThai = trangThai;
		this.phanQuyen = phanQuyen;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getTenNhaXe() {
		return tenNhaXe;
	}
	public void setTenNhaXe(String tenNhaXe) {
		this.tenNhaXe = tenNhaXe;
	}
	public int getMaNguoiDung() {
		return maNguoiDung;
	}
	public void setMaNguoiDung(int maNguoiDung) {
		this.maNguoiDung = maNguoiDung;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTenNguoiDung() {
		return tenNguoiDung;
	}
	public void setTenNguoiDung(String tenNguoiDung) {
		this.tenNguoiDung = tenNguoiDung;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isTrangThai() {
		return trangThai;
	}
	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
	public int getPhanQuyen() {
		return phanQuyen;
	}
	public void setPhanQuyen(int phanQuyen) {
		this.phanQuyen = phanQuyen;
	}
	
	
}
