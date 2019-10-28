package model.bo;

import java.util.ArrayList;

import model.bean.Ghe;
import model.dao.ChairDAO;

public class ChairBO {
	public ArrayList<Ghe> getChairByBusId(int busId)
	{
		return (new ChairDAO()).getChairByBusId(busId);
	}
	public int deleteAllCharByBusId(int busId)
	{
		return (new ChairDAO()).deleteAllCharByBusId(busId);
	}
	public ArrayList<Ghe> getChairForSellByBusId(int i) {
		return (new ChairDAO()).getChairForSellByBusId(i);
	}
	public int getSoGheTrong(int maChuyenXe) {
		return (new ChairDAO().getSoGheTrong(maChuyenXe));
	}
}
