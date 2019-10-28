package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.google.gson.Gson;

import form.BusesForm;
import model.bean.Buses;
import model.bo.BusBO;
import model.bo.BusesBO;
import model.bo.TripBO;
import model.dao.TripDAO;

public class EditBusesAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("maNguoiDung");
		BusesForm busesForm = (BusesForm)form;
		int busesid = 0;
				
		try{
			busesid=Integer.parseInt(request.getParameter("id"));
		}
		catch(Exception ex)
		{}
		
		if(busesForm.getSubmit()!=null &&busesForm.getSubmit().equals("submit"))
		{
			if((new BusesBO()).EditAllBusesByTripID(busesForm))
			{
				(new TripDAO()).updateTravelingTimeByTripId(busesForm.getMaChang(), busesForm.getThoiGianDiChuyen());
				return mapping.findForward("success");
			}else
				return mapping.findForward("fail");
		
		}
		else
		{
			Buses buses = (new BusesBO()).getOneBusesByBusesId(busesid);
			busesForm.setMaChang(buses.getMaChang());
			busesForm.setMaChuyenXe(buses.getMaChuyenXe());
			busesForm.setGioXuatPhat(buses.getGioXuatPhat());
			busesForm.setGioToiNoi(buses.getGioToiNoi());
			busesForm.setNgayXuatPhat(buses.getNgayXuatPhat());
			busesForm.setGiaVe(buses.getGiaVe());
			busesForm.setThoiGianDiChuyen((new TripDAO()).getTravelingTimeByTipId(buses.getMaChang()));
			Gson gson = new Gson();
	        busesForm.setListBusJson( gson.toJson((new BusBO()).getAllBusByUserId(userId)));
	        //busesForm.setListProvince((new LocationBO()).getAllProvince());
	        
	        busesForm.setListTripJson( gson.toJson((new TripBO()).getAllTripByUserId(userId)));
			return mapping.findForward("render");
		}
	}
}
