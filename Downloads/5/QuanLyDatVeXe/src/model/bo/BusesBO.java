package model.bo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import form.BusesForm;
import model.bean.Buses;
import model.dao.BusesDAO;
import model.dao.TicketDAO;

public class BusesBO {

	public ArrayList<Integer> getOneBusesByBusId(int busId) {
		return (new BusesDAO()).getOneBusesByBusId(busId);
	}

	public int getRowCountBusesByUserId(int userId) {
		return (new BusesDAO()).getRowCountBusesByUserId(userId);
	}

	public ArrayList<Buses> getPaginationBuses(int i, int userId) {
		return (new BusesDAO()).getPaginationBuses( i,  userId);
	}

	public boolean AddNewBuses(BusesForm busesForm,Map<String, String> repeatMap) {
		TripBO tripBO = new TripBO();
		int travelTime= tripBO.getTravelingTimeByTipId(busesForm.getMaChang());
		busesForm.setThoiGianDiChuyen(travelTime);
		
		Set set =repeatMap.keySet();
		boolean[] repeatArr = new boolean[7];
		for (Iterator<String> it = set.iterator(); it.hasNext(); ) {
	        String f = it.next();
	        repeatArr[Integer.parseInt(f)] = Boolean.parseBoolean(repeatMap.get(f));
		}
		
		return (new BusesDAO()).AddNewBuses( busesForm,repeatArr);
	}

	public boolean AddNewBusesAndTrip(BusesForm busesForm, Map<String, String> repeatMap) {
		LocationBO locationBO = new LocationBO();
		int maDDXP = locationBO.addNewLocation(busesForm.getMaTinhXuatPhat(), busesForm.getMaHuyenXuatPhat());
		int maDDDen = locationBO.addNewLocation(busesForm.getMaTinhDen(), busesForm.getMaHuyenDen());
		TripBO tripBO = new TripBO();
		int maChang= tripBO.addNewTrip(busesForm.getMaXe(),busesForm.getThoiGianDiChuyen(),maDDXP,maDDDen);
		
		Set set =repeatMap.keySet();
		boolean[] repeatArr = new boolean[7];
		for (Iterator<String> it = set.iterator(); it.hasNext(); ) {
	        String f = it.next();
	        repeatArr[Integer.parseInt(f)] = Boolean.parseBoolean(repeatMap.get(f));
		}
		
		return (new BusesDAO()).AddNewBusesAndTrip( busesForm,maChang,repeatArr);
	}

	public Buses getOneBusesByBusesId(int busesid) {
		return (new BusesDAO()).getOneBusesByBusesId(busesid);
	}

	public boolean EditBuses(BusesForm busesForm) {
		return (new BusesDAO()).EditBuses(busesForm);
	}

	public boolean removeBusesByBusesId(int busesId) {
		(new TicketDAO()).removeTicketByBusesId( busesId);
		return (new BusesDAO()).removeBusesByBusesId(busesId);
		
	}

	public int getRowCountDetailBusesByUserId(int userId,int maXe, int maChang) {
		return (new BusesDAO()).getRowCountDetailBusesByUserId(userId, maXe,maChang);
	}

	public ArrayList<Buses> getPaginationBusesDetail(int i, int userId,int maXe,int maChang) {
		return (new BusesDAO()).getPaginationBusesDetail(i,userId,maXe,maChang);
	}
	public Buses getOneBuses(int busesId) {
		return (new BusesDAO()).getOneBuses(busesId);
	}

	public boolean removeBusesByTripId(int tripId) {
		return (new BusesDAO()).removeBusesByTripId(tripId);
		
	}

	public boolean EditAllBusesByTripID(BusesForm busesForm) {
		return (new BusesDAO()).EditBusesAll(busesForm);
	}
	public ArrayList<Buses> getBuseseByBusId(int busid)
	{
		return (new BusesDAO()).getBuseseByBusId(busid);
	}
	

}
