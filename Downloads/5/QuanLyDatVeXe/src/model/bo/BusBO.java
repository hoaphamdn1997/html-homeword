package model.bo;

import java.util.ArrayList;

import form.BusForm;
import model.bean.Bus;
import model.dao.BusDAO;

public class BusBO {

	public int addNewLayOutChair(Bus bus,int maXe) {
		BusDAO busDAO = new BusDAO();
		return busDAO.addNewLayOutChair(bus,maXe);
	}

	public ArrayList<Bus> getAllBusByUserId(int userId) {
		BusDAO busDAO = new BusDAO();
		return busDAO.getAllBusByUserId(userId);
	}

	public int getRowCountBusByUserId(int attribute) {
		BusDAO busDAO = new BusDAO();
		return busDAO.getRowCountBusByUserId(attribute);
	}

	public ArrayList<Bus> getPaginationBus(int i,int userId) {
		BusDAO busDAO = new BusDAO();
		return busDAO.getPaginationBus(i,userId);
	}

	public int AddNewBus(BusForm busForm, int tspId) {
		BusDAO busDAO = new BusDAO();
		return busDAO.AddNewBus(busForm,tspId);
	}

	public Bus getOneBusByBusId(int parameter) {
		BusDAO busDAO = new BusDAO();
		return busDAO.getOneBusByBusId(parameter);
	}

	public boolean EditBus(BusForm busForm) {
		BusDAO busDAO = new BusDAO();
		return busDAO.EditBus(busForm);
	}

	public boolean removeBusByBusId(int busId) {
		BusDAO busDAO = new BusDAO();
		return busDAO.removeBusByBusId(busId);
		
	}

	public int getBusIdByBusesId(int busId) {
		BusDAO busDAO = new BusDAO();
		return busDAO.getBusIdByBusesId(busId);
	}
	public ArrayList<Bus> getAllBusByBusTypeId(int bustypeId) {
		BusDAO busDAO = new BusDAO();
		return busDAO.getAllBusByBusTypeId(bustypeId);
	}

	

}
