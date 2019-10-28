/**
 * ResultChuyenSearch.java
 *
 * Version 1.0
 *
 * Date 20/02/2019
 *
 * Copyright
 *
 * DATE             ProjectName      Author
 * ----------------------------------------
 * 20/02/2019     QuanLyDatVeXe       CHAUNT4
 */ 


package model.bean;

import java.sql.Time;
import java.util.ArrayList;

public class ResultChuyenSearch {
    private String tenNhaXe, diaDiemDi, diaDiemDen,ngayXuatPhat;
    private float giaVe, tongTien;
    private Time gioXP, gioTN;
    private int soGhe, soGheTrong, maChuyen, soGheDaDat, tgdc;
    ArrayList<VeXe> listVe;
    Bus xe;
    
    public String getNgayXuatPhat() {
		return ngayXuatPhat;
	}

	public void setNgayXuatPhat(String ngayXuatPhat) {
		this.ngayXuatPhat = ngayXuatPhat;
	}

	public ResultChuyenSearch() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public ResultChuyenSearch(String tenNhaXe, String diaDiemDi, String diaDiemDen, float giaVe, Time gioXP, Time gioTN,
			int soGhe, int soGheTrong) {
		super();
		this.tenNhaXe = tenNhaXe;
		this.diaDiemDi = diaDiemDi;
		this.diaDiemDen = diaDiemDen;
		this.giaVe = giaVe;
		this.gioXP = gioXP;
		this.gioTN = gioTN;
		this.soGhe = soGhe;
		this.soGheTrong = soGheTrong;
	}

	public ResultChuyenSearch(String tenNhaXe, String diaDiemDi, String diaDiemDen, float giaVe, float tongTien,
            Time gioXP, Time gioTN, int soGhe, int soGheTrong, int maChuyen, int soGheDaDat, int tgdc,
            ArrayList<VeXe> listVe) {
        super();
        this.tenNhaXe = tenNhaXe;
        this.diaDiemDi = diaDiemDi;
        this.diaDiemDen = diaDiemDen;
        this.giaVe = giaVe;
        this.tongTien = tongTien;
        this.gioXP = gioXP;
        this.gioTN = gioTN;
        this.soGhe = soGhe;
        this.soGheTrong = soGheTrong;
        this.maChuyen = maChuyen;
        this.soGheDaDat = soGheDaDat;
        this.tgdc = tgdc;
        this.listVe = listVe;
    }

    public ResultChuyenSearch(String tenNhaXe, String diaDiemDi, String diaDiemDen, float giaVe, Time gioXP, Time gioTN,
			int soGhe, int soGheTrong, int maChuyen, int tgdc, Bus xe) {
		super();
		this.tenNhaXe = tenNhaXe;
		this.diaDiemDi = diaDiemDi;
		this.diaDiemDen = diaDiemDen;
		this.giaVe = giaVe;
		this.gioXP = gioXP;
		this.gioTN = gioTN;
		this.soGhe = soGhe;
		this.soGheTrong = soGheTrong;
		this.maChuyen = maChuyen;
        this.tgdc = tgdc;
        this.xe = xe;
	}

    public ResultChuyenSearch(String tenNhaXe, String diaDiemDi, String diaDiemDen, float tongTien, Time gioXP,
            Time gioTN, int soGhe, int soGheTrong, int maChuyen, int soGheDaDat, int tgdc, ArrayList<VeXe> listVe, Bus xe) {
        super();
        this.tenNhaXe = tenNhaXe;
        this.diaDiemDi = diaDiemDi;
        this.diaDiemDen = diaDiemDen;
        this.tongTien = tongTien;
        this.gioXP = gioXP;
        this.gioTN = gioTN;
        this.soGhe = soGhe;
        this.soGheTrong = soGheTrong;
        this.maChuyen = maChuyen;
        this.soGheDaDat = soGheDaDat;
        this.tgdc = tgdc;
        this.listVe = listVe;
        this.xe = xe;
    }

    public String getTenNhaXe() {
        return tenNhaXe;
    }
    public void setTenNhaXe(String tenNhaXe) {
        this.tenNhaXe = tenNhaXe;
    }
    public String getDiaDiemDi() {
        return diaDiemDi;
    }
    public void setDiaDiemDi(String diaDiemDi) {
        this.diaDiemDi = diaDiemDi;
    }
    public String getDiaDiemDen() {
        return diaDiemDen;
    }
    public void setDiaDiemDen(String diaDiemDen) {
        this.diaDiemDen = diaDiemDen;
    }
    public float getGiaVe() {
        return giaVe;
    }
    public void setGiaVe(float giaVe) {
        this.giaVe = giaVe;
    }
    public Time getGioXP() {
        return gioXP;
    }
    public void setGioXP(Time gioXP) {
        this.gioXP = gioXP;
    }
    public Time getGioTN() {
        return gioTN;
    }
    public void setGioTN(Time gioTN) {
        this.gioTN = gioTN;
    }
    public int getSoGhe() {
        return soGhe;
    }
    public void setSoGhe(int soGhe) {
        this.soGhe = soGhe;
    }

	public int getSoGheTrong() {
		return soGheTrong;
	}

	public void setSoGheTrong(int soGheTrong) {
		this.soGheTrong = soGheTrong;
	}

	public int getMaChuyen() {
		return maChuyen;
	}

	public void setMaChuyen(int maChuyen) {
		this.maChuyen = maChuyen;
	}

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public int getSoGheDaDat() {
        return soGheDaDat;
    }

    public void setSoGheDaDat(int soGheDaDat) {
        this.soGheDaDat = soGheDaDat;
    }

    public int getTgdc() {
        return tgdc;
    }

    public void setTgdc(int tgdc) {
        this.tgdc = tgdc;
    }

    public ArrayList<VeXe> getListVe() {
        return listVe;
    }

    public void setListVe(ArrayList<VeXe> listVe) {
        this.listVe = listVe;
    }

    public Bus getXe() {
        return xe;
    }

    public void setXe(Bus xe) {
        this.xe = xe;
    }
    
}
 