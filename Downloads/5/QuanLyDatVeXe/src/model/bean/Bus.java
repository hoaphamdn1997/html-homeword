package model.bean;

import java.util.ArrayList;

public class Bus {
	private int maXe,maNhaXe,maLoaiXe;
	private String tenXe,bienSo,tenNhaXe,tenLoaiXe;
	private ArrayList<Ghe> listGhe;
	
	public String getTenNhaXe() {
		return tenNhaXe;
	}
	public void setTenNhaXe(String tenNhaXe) {
		this.tenNhaXe = tenNhaXe;
	}
	public String getTenLoaiXe() {
		return tenLoaiXe;
	}
	public void setTenLoaiXe(String tenLoaiXe) {
		this.tenLoaiXe = tenLoaiXe;
	}
	public ArrayList<Ghe> getListGhe() {
		return listGhe;
	}
	public void setListGhe(ArrayList<Ghe> listGhe) {
		this.listGhe = listGhe;
	}
	public int getMaXe() {
		return maXe;
	}
	public void setMaXe(int maXe) {
		this.maXe = maXe;
	}
	public int getMaNhaXe() {
		return maNhaXe;
	}
	public void setMaNhaXe(int maNhaXe) {
		this.maNhaXe = maNhaXe;
	}
	public int getMaLoaiXe() {
		return maLoaiXe;
	}
	public void setMaLoaiXe(int maLoaiXe) {
		this.maLoaiXe = maLoaiXe;
	}
	public String getTenXe() {
		return tenXe;
	}
	public void setTenXe(String tenXe) {
		this.tenXe = tenXe;
	}
	public String getBienSo() {
		return bienSo;
	}
	public void setBienSo(String bienSo) {
		this.bienSo = bienSo;
	}
	
}
