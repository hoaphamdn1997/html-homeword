package model.bean;

public class TransportServiceProvider {
	private int maNhaXe;
	private String tenNhaXe,soDienThoai,diaChi;
	public TransportServiceProvider() {
        super();
        // TODO Auto-generated constructor stub
    }
	
    public TransportServiceProvider(int maNhaXe, String tenNhaXe, String soDienThoai, String diaChi) {
        super();
        this.maNhaXe = maNhaXe;
        this.tenNhaXe = tenNhaXe;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
    }

	public int getMaNhaXe() {
		return maNhaXe;
	}
	public void setMaNhaXe(int maNhaXe) {
		this.maNhaXe = maNhaXe;
	}
	public String getTenNhaXe() {
		return tenNhaXe;
	}
	public void setTenNhaXe(String tenNhaXe) {
		this.tenNhaXe = tenNhaXe;
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
}
