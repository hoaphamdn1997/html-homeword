package model.bo;

import java.util.ArrayList;

import model.bean.BusType;
import model.dao.BusTypeDAO;

public class BusTypeBO {
	public int getFloorNumber(int maXe)
	{
		return (new BusTypeDAO()).getFloorNumber(maXe);
	}
	
	public BusType getBusTypeByBusId(int busId)
	{
		return (new BusTypeDAO()).getBusTypeByBusId(busId);
	}

	public ArrayList<BusType> getAllBusType() {
		return (new BusTypeDAO()).getAllBusType();
	}
	public BusType getBusTypeById(int id) {
		return (new BusTypeDAO().getBusTypeById(id));
	}
	
	public BusType updateBusType(int id, String tenLX, int soGhe,
			int soTang, String moTa) {
		return (new BusTypeDAO().updateBusType(id, tenLX, soGhe, soTang, moTa));
	}
	public int getRowCountBusType() {
		BusTypeDAO busTypeDAO = new BusTypeDAO();
		return busTypeDAO.getRowCountBusType();
	}
	
	public ArrayList<BusType> getPaginationBusType(int i) {
		BusTypeDAO busTypeDAO = new BusTypeDAO();
		return busTypeDAO.getPaginationBusType(i);
	}
	public void AddBusType(String tenLoaiXe, int soGhe, int soTang, String moTa) {
		BusTypeDAO busTypeDAO = new BusTypeDAO();
		busTypeDAO.AddBusType(tenLoaiXe,soGhe,soTang,moTa);
		
	}
	public boolean removeBusByBusType(int busType) {
		BusTypeDAO bustypeDAO = new BusTypeDAO();
		return bustypeDAO.removeBusByBusType(busType);

	}
}
