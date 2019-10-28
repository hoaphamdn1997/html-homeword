/**
 * DiaDiem.java
 *
 * Version 1.0
 *
 * Date 15/02/2019
 *
 * Copyright
 *
 * DATE             ProjectName      Author
 * ----------------------------------------
 * 15/02/2019     QuanLyDatVeXe       CHAUNT4
 */ 


package model.bean;

public class DiaDiem {
    private int maDiaDiem;
    private String districtId,provinceId,tenDiaDiem;
    public DiaDiem() {
        super();
        // TODO Auto-generated constructor stub
    }
    public DiaDiem(int maDiaDiem, String districtId, String provinceId, String tenDiaDiem) {
        super();
        this.maDiaDiem = maDiaDiem;
        this.districtId = districtId;
        this.provinceId = provinceId;
        this.tenDiaDiem = tenDiaDiem;
    }
    public int getMaDiaDiem() {
        return maDiaDiem;
    }
    public void setMaDiaDiem(int maDiaDiem) {
        this.maDiaDiem = maDiaDiem;
    }
    public String getDistrictId() {
        return districtId;
    }
    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }
    public String getProvinceId() {
        return provinceId;
    }
    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }
    public String getTenDiaDiem() {
        return tenDiaDiem;
    }
    public void setTenDiaDiem(String tenDiaDiem) {
        this.tenDiaDiem = tenDiaDiem;
    }
    
}
 