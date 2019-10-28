package model.bean;

public class District {
	private String maHuyen,tenHuyen,districtId,name, provinceId;
	public District() {
        super();
        // TODO Auto-generated constructor stub
    }
    public District(String districtId, String name, String provinceId) {
        super();
        this.districtId = districtId;
        this.name = name;
        this.provinceId = provinceId;
    }
    public String getDistrictId() {
        return districtId;
    }
    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getProvinceId() {
        return provinceId;
    }
    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }
	public String getMaHuyen() {
		return maHuyen;
	}

	public void setMaHuyen(String maHuyen) {
		this.maHuyen = maHuyen;
	}

	public String getTenHuyen() {
		return tenHuyen;
	}

	public void setTenHuyen(String tenHuyen) {
		this.tenHuyen = tenHuyen;
	}
	
}
