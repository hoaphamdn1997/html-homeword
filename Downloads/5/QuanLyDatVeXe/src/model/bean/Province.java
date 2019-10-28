package model.bean;

public class Province {
	private String maTinh,tenTinh;
	 private String provinceId, name;

	    public Province() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

	    public Province(String provinceId, String name) {
	        super();
	        this.provinceId = provinceId;
	        this.name = name;
	    }

	    public String getProvinceId() {
	        return provinceId;
	    }

	    public void setProvinceId(String provinceId) {
	        this.provinceId = provinceId;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }
	public String getMaTinh() {
		return maTinh;
	}

	public void setMaTinh(String maTinh) {
		this.maTinh = maTinh;
	}

	public String getTenTinh() {
		return tenTinh;
	}

	public void setTenTinh(String tenTinh) {
		this.tenTinh = tenTinh;
	}
	
}
