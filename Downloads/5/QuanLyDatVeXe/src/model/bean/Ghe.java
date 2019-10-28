package model.bean;

public class Ghe {
	private int vtHang,vtCot,trangThai,tang,maXe,maGhe,trangThaiDatVe,giaGhe;
	private String day, maSoGhe;
	

	
	public Ghe(String maSoGhe) {
        super();
        this.maSoGhe = maSoGhe;
    }

    public String getMaSoGhe() {
        return maSoGhe;
    }

    public void setMaSoGhe(String maSoGhe) {
        this.maSoGhe = maSoGhe;
    }

    public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getGiaGhe() {
		return giaGhe;
	}

	public void setGiaGhe(int giaGhe) {
		this.giaGhe = giaGhe;
	}

	/**
	 * 
	 */
	
	public Ghe() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param vtHang
	 * @param vtCot
	 * @param trangThai
	 */
	public Ghe(int vtHang, int vtCot, int trangThai) {
		super();
		this.vtHang = vtHang;
		this.vtCot = vtCot;
		this.trangThai = trangThai;
	}

	/**
	 * @param vtHang
	 * @param vtCot
	 * @param trangThai
	 * @param tang
	 */
	public Ghe(int vtHang, int vtCot, int trangThai, int tang) {
		super();
		this.vtHang = vtHang;
		this.vtCot = vtCot;
		this.trangThai = trangThai;
		this.tang = tang;
	}
	public Ghe(int vtHang, int vtCot, int trangThai, int tang,String day) {
		super();
		this.vtHang = vtHang;
		this.vtCot = vtCot;
		this.trangThai = trangThai;
		this.tang = tang;
		this.day=day;
	}
	
	/**
	 * @param vtHang
	 * @param vtCot
	 * @param trangThai
	 * @param tang
	 * @param maXe
	 * @param maGhe
	 */
	public Ghe( int maGhe,int vtHang, int vtCot, int trangThai, int tang, int maXe) {
		super();
		this.vtHang = vtHang;
		this.vtCot = vtCot;
		this.trangThai = trangThai;
		this.tang = tang;
		this.maXe = maXe;
		this.maGhe = maGhe;
	}
	
	/**
	 * @param vtHang
	 * @param vtCot
	 * @param trangThai
	 * @param tang
	 * @param maXe
	 * @param maGhe
	 * @param trangThaiDatVe
	 */
	public Ghe(int vtHang, int vtCot, int trangThai, int tang, int maXe, int maGhe, int trangThaiDatVe) {
		super();
		this.vtHang = vtHang;
		this.vtCot = vtCot;
		this.trangThai = trangThai;
		this.tang = tang;
		this.maXe = maXe;
		this.maGhe = maGhe;
		this.trangThaiDatVe = trangThaiDatVe;
	}

	public int getTrangThaiDatVe() {
		return trangThaiDatVe;
	}

	public void setTrangThaiDatVe(int trangThaiDatVe) {
		this.trangThaiDatVe = trangThaiDatVe;
	}

	public int getMaGhe() {
		return maGhe;
	}

	public void setMaGhe(int maGhe) {
		this.maGhe = maGhe;
	}

	public int getMaXe() {
		return maXe;
	}

	public void setMaXe(int maXe) {
		this.maXe = maXe;
	}

	public int getVtHang() {
		return vtHang;
	}

	public void setVtHang(int vtHang) {
		this.vtHang = vtHang;
	}

	public int getVtCot() {
		return vtCot;
	}

	public void setVtCot(int vtCot) {
		this.vtCot = vtCot;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public int getTang() {
		return tang;
	}

	public void setTang(int tang) {
		this.tang = tang;
	}
	
	
}
