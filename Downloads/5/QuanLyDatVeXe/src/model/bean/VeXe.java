/**
 * Chuyen.java
 *
 * Version 1.0
 *
 * Date 19/02/2019
 *
 * Copyright
 *
 * DATE             ProjectName      Author
 * ----------------------------------------
 * 19/02/2019     QuanLyDatVeXe       CHAUNT4
 */ 


package model.bean;

import java.sql.Date;
import java.sql.Time;

public class VeXe {
    private int maVe, maChuyenXe, maGhe, maNguoiDung, soGheDaDat;
    private float giaVe, tongTien;
    private String maSoGhe;
    public VeXe() {
        super();
        // TODO Auto-generated constructor stub
    }
    public VeXe(int maVe, int maChuyenXe, int maGhe, int maNguoiDung, float giaVe) {
        super();
        this.maVe = maVe;
        this.maChuyenXe = maChuyenXe;
        this.maGhe = maGhe;
        this.maNguoiDung = maNguoiDung;
        this.giaVe = giaVe;
    }
    
    public VeXe(int maVe, int maChuyenXe, int maGhe, int maNguoiDung, int soGheDaDat, float giaVe, float tongTien) {
        super();
        this.maVe = maVe;
        this.maChuyenXe = maChuyenXe;
        this.maGhe = maGhe;
        this.maNguoiDung = maNguoiDung;
        this.soGheDaDat = soGheDaDat;
        this.giaVe = giaVe;
        this.tongTien = tongTien;
    }
    
    
    public VeXe(int maVe, String maSoGhe) {
        super();
        this.maVe = maVe;
        this.maSoGhe = maSoGhe;
    }
    public int getMaVe() {
        return maVe;
    }
    public void setMaVe(int maVe) {
        this.maVe = maVe;
    }
    public int getMaChuyenXe() {
        return maChuyenXe;
    }
    public void setMaChuyenXe(int maChuyenXe) {
        this.maChuyenXe = maChuyenXe;
    }
    public int getMaGhe() {
        return maGhe;
    }
    public void setMaGhe(int maGhe) {
        this.maGhe = maGhe;
    }
    public int getMaNguoiDung() {
        return maNguoiDung;
    }
    public void setMaNguoiDung(int maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }
    public float getGiaVe() {
        return giaVe;
    }
    public void setGiaVe(float giaVe) {
        this.giaVe = giaVe;
    }
    public int getSoGheDaDat() {
        return soGheDaDat;
    }
    public void setSoGheDaDat(int soGheDaDat) {
        this.soGheDaDat = soGheDaDat;
    }
    public float getTongTien() {
        return tongTien;
    }
    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }
    public String getMaSoGhe() {
        return maSoGhe;
    }
    public void setMaSoGhe(String maSoGhe) {
        this.maSoGhe = maSoGhe;
    }
    
}
 