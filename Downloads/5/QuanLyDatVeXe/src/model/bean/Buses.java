package model.bean;

public class Buses {
	private int maChuyenXe,maXe,maChang;
	private int giaVe;
	private String diemDi,diemDen,gioXuatPhat,gioToiNoi,NgayXuatPhat,nxp;
	
	public String getNxp() {
		return nxp;
	}
	public void setNxp(String nxp) {
		this.nxp = nxp;
	}
	public int getMaChang() {
		return maChang;
	}
	public void setMaChang(int maChang) {
		this.maChang = maChang;
	}
	public String getNgayXuatPhat() {
		return NgayXuatPhat;
	}
	public void setNgayXuatPhat(String ngayXuatPhat) {
		NgayXuatPhat = ngayXuatPhat;
	}
	public int getMaChuyenXe() {
		return maChuyenXe;
	}
	public void setMaChuyenXe(int maChuyenXe) {
		this.maChuyenXe = maChuyenXe;
	}
	public int getMaXe() {
		return maXe;
	}
	public void setMaXe(int maXe) {
		this.maXe = maXe;
	}
	public int getGiaVe() {
		return giaVe;
	}
	public void setGiaVe(int giaVe) {
		this.giaVe = giaVe;
	}
	public String getDiemDi() {
		return diemDi;
	}
	public void setDiemDi(String diemDi) {
		this.diemDi = diemDi;
	}
	public String getDiemDen() {
		return diemDen;
	}
	public void setDiemDen(String diemDen) {
		this.diemDen = diemDen;
	}
	public String getGioXuatPhat() {
		return gioXuatPhat;
	}
	public void setGioXuatPhat(String gioXuatPhat) {
		gioXuatPhat = gioXuatPhat.substring(0, gioXuatPhat.indexOf('.'));
		this.gioXuatPhat = gioXuatPhat;
	}
	public String getGioToiNoi() {
		return gioToiNoi;
	}
	public void setGioToiNoi(String gioToiNoi) {
		gioToiNoi = gioToiNoi.substring(0, gioToiNoi.indexOf('.'));
		this.gioToiNoi = gioToiNoi;
	}
	
}
