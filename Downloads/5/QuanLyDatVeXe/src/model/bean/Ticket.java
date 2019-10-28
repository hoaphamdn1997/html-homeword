package model.bean;

import java.util.ArrayList;

public class Ticket {
	private ArrayList<Ghe> listGhe;
	private User user;
	private Buses buses;
	private Bus bus;
	private int MaVe;
	
	public int getMaVe() {
		return MaVe;
	}
	public void setMaVe(int maVe) {
		MaVe = maVe;
	}
	public ArrayList<Ghe> getListGhe() {
		return listGhe;
	}
	public void setListGhe(ArrayList<Ghe> listGhe) {
		this.listGhe = listGhe;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Buses getBuses() {
		return buses;
	}
	public void setBuses(Buses buses) {
		this.buses = buses;
	}
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	
	
}
