package model.bean;

public class PhanQuyen {

	private int maPhanQuyen;
	private String tenPhanQuyen;
	
	
	
	public PhanQuyen(int maPhanQuyen, String tenPhanQuyen) {
		super();
		this.maPhanQuyen = maPhanQuyen;
		this.tenPhanQuyen = tenPhanQuyen;
	}
	public int getMaPhanQuyen() {
		return maPhanQuyen;
	}
	public void setMaPhanQuyen(int maPhanQuyen) {
		this.maPhanQuyen = maPhanQuyen;
	}
	public String getTenPhanQuyen() {
		return tenPhanQuyen;
	}
	public void setTenPhanQuyen(String tenPhanQuyen) {
		this.tenPhanQuyen = tenPhanQuyen;
	}
}
