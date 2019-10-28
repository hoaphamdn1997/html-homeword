package model.bo;

import java.util.ArrayList;

import model.bean.Trip;
import model.dao.TripDAO;

public class TripBO {

	public ArrayList<Trip> getAllTripByUserId(int userId) {
		return (new TripDAO()).getAllTripByUserId(userId);
	}

	public int addNewTrip(int maXe, int thoiGianDiChuyen, int maDDXP, int maDDDen) {
		return (new TripDAO()).addNewTrip( maXe,  thoiGianDiChuyen,  maDDXP,  maDDDen);
		
	}

	public int getTravelingTimeByTipId(int maChang) {
		return (new TripDAO()).getTravelingTimeByTipId(maChang);
	}

	public ArrayList<Integer> getTripByBusId(int busId) {
		return (new TripDAO()).getTripByBusId(busId);
	}
	
	public int getMaXeByMaChang(int maChang) {
        return (new TripDAO()).getMaXeByMaChang(maChang);
    }
	public int updateTravelingTimeByTripId(int maChang,int time) {
		return (new TripDAO()).updateTravelingTimeByTripId(maChang,time);
	}

}
