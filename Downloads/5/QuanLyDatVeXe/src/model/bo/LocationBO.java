package model.bo;

import java.util.ArrayList;

import model.bean.District;
import model.bean.Province;
import model.dao.LocationDAO;

public class LocationBO {

	public ArrayList<District> getDistrictByProvinceId(String provinceid) {
		
		return (new LocationDAO()).getDistrictByProvinceId(provinceid);
	}

	public ArrayList<Province> getAllProvince() {
		return (new LocationDAO()).getAllProvince();
	}
	public int addNewLocation(String maTinh,String maHuyen)
	{
		LocationDAO locationDAO = new LocationDAO();
		return locationDAO.addNewLocation(maTinh,maHuyen,locationDAO.getLocationName(maTinh, maHuyen));
	}
}
