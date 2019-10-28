package model.bean;

public class BusType {
	private int maLoaiXe,soGhe,soTang;
	private String tenLoaiXe,moTa;
	public BusType(int maLoaiXe, int soGhe, int soTang, String tenLoaiXe, String moTa) {
		super();
		this.maLoaiXe = maLoaiXe;
		this.soGhe = soGhe;
		this.soTang = soTang;
		this.tenLoaiXe = tenLoaiXe;
		this.moTa = moTa;
	}
	public BusType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getMaLoaiXe() {
		return maLoaiXe;
	}
	public void setMaLoaiXe(int maLoaiXe) {
		this.maLoaiXe = maLoaiXe;
	}
	public int getSoGhe() {
		return soGhe;
	}
	public void setSoGhe(int soGhe) {
		this.soGhe = soGhe;
	}
	public String getTenLoaiXe() {
		return tenLoaiXe;
	}
	public void setTenLoaiXe(String tenLoaiXe) {
		this.tenLoaiXe = tenLoaiXe;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public int getSoTang() {
		return soTang;
	}
	public void setSoTang(int soTang) {
		this.soTang = soTang;
	}
	
}
