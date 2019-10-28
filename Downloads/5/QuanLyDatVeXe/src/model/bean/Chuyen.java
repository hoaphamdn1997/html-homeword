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

public class Chuyen {
    private int maChuyenXe, maChang;
    private Time gioXuatPhat, gioToiNoi;
    private Date ngayXuatPhat;
    private float giaVe;
    public Chuyen() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Chuyen(int maChuyenXe, int maChang, Time gioXuatPhat, Time gioToiNoi, Date ngayXuatPhat, float giaVe) {
        super();
        this.maChuyenXe = maChuyenXe;
        this.maChang = maChang;
        this.gioXuatPhat = gioXuatPhat;
        this.gioToiNoi = gioToiNoi;
        this.ngayXuatPhat = ngayXuatPhat;
        this.giaVe = giaVe;
    }
    public int getMaChuyenXe() {
        return maChuyenXe;
    }
    public void setMaChuyenXe(int maChuyenXe) {
        this.maChuyenXe = maChuyenXe;
    }
    public int getMaChang() {
        return maChang;
    }
    public void setMaChang(int maChang) {
        this.maChang = maChang;
    }
    public Time getGioXuatPhat() {
        return gioXuatPhat;
    }
    public void setGioXuatPhat(Time gioXuatPhat) {
        this.gioXuatPhat = gioXuatPhat;
    }
    public Time getGioToiNoi() {
        return gioToiNoi;
    }
    public void setGioToiNoi(Time gioToiNoi) {
        this.gioToiNoi = gioToiNoi;
    }
    public Date getNgayXuatPhat() {
        return ngayXuatPhat;
    }
    public void setNgayXuatPhat(Date ngayXuatPhat) {
        this.ngayXuatPhat = ngayXuatPhat;
    }
    public float getGiaVe() {
        return giaVe;
    }
    public void setGiaVe(float giaVe) {
        this.giaVe = giaVe;
    }
    
}
 