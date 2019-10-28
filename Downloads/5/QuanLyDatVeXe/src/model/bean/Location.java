package model.bean;

import java.util.ArrayList;

public class Location {
	private ArrayList<District> listDistrict;
	private String diemDi,diemDen;
	
	public String getDiemDi() {
		return diemDi;
	}

	public void setDiemDi(String diemDi) {
		this.diemDi = diemDi;
	}

	public String getDiemDen() {
		return diemDen;
	}

	public void setDiemDen(String diemDen) {
		this.diemDen = diemDen;
	}

	public ArrayList<District> getListDistrict() {
		return listDistrict;
	}

	public void setListDistrict(ArrayList<District> listDistrict) {
		this.listDistrict = listDistrict;
	}
	
	
}
