package model.bean;

public class UserTrangThai {

	private int maTrangThai;
	private boolean tenTrangThai;
	
	
	
	public UserTrangThai(int maTrangThai, boolean trangThai) {
		super();
		this.maTrangThai = maTrangThai;
		this.tenTrangThai = trangThai;
	}

	
	public int getMaTrangThai() {
		return maTrangThai;
	}
	
	public void setMaTrangThai(int maTrangThai) {
		this.maTrangThai = maTrangThai;
	}


	public boolean isTenTrangThai() {
		return tenTrangThai;
	}


	public void setTenTrangThai(boolean tenTrangThai) {
		this.tenTrangThai = tenTrangThai;
	}
	
}
