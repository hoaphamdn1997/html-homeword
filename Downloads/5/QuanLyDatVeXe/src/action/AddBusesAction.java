package action;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import form.BusesForm;
import model.bean.Buses;
import model.bo.BusBO;
import model.bo.BusesBO;
import model.bo.LocationBO;
import model.bo.TripBO;

public class AddBusesAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("maNguoiDung");
		BusesForm busesForm = (BusesForm)form;
		
		if(busesForm.getSubmit()!=null )
		{
			System.out.println(busesForm.getListRepeatJson());
			Gson gson = new Gson();
			Type type = new TypeToken<Map<String, String>>(){}.getType();
			Map<String, String> repeatMap = gson.fromJson(busesForm.getListRepeatJson(), type);
			
			
			
			
			if(busesForm.getSubmit().equals("submit1"))
			{
				Boolean check = true;
				System.out.println("run1");
				ArrayList<Buses> lBuses = (new BusesBO().getBuseseByBusId(busesForm.getMaXe()));
				for (Buses buses : lBuses) {
					String d = ((busesForm.getGioXuatPhat().length()== 4)?"0"+busesForm.getGioXuatPhat():busesForm.getGioXuatPhat())+":00";
					System.out.println(buses.getGioXuatPhat()+"|"+d+"|"+buses.getNgayXuatPhat()+","+busesForm.getNgayXuatPhat());
					System.out.println(((buses.getGioXuatPhat().equals(d)) == true) && ((buses.getNgayXuatPhat()).equals(busesForm.getNgayXuatPhat())) == true);
					if(((buses.getGioXuatPhat().equals(d)) == true) && ((buses.getNgayXuatPhat()).equals(busesForm.getNgayXuatPhat())) == true)
					{
						System.out.println("equals");
						check = false;
					}
				}
				if(!check)
				{
					System.out.println("=========================================");
					session.setAttribute("errorAddBuses", "err");
					return mapping.findForward("fail");
				}
				else {
					System.out.println("OK!");
					if((new BusesBO()).AddNewBusesAndTrip(busesForm,repeatMap))
						return mapping.findForward("success");
					else
						return mapping.findForward("fail");
				}
				
			}
			else
			{
				System.out.println("run 2");
				if((new BusesBO()).AddNewBuses(busesForm,repeatMap))
					return mapping.findForward("success");
				else
					return mapping.findForward("fail");
			}
			
		}
		else
		{
			Gson gson = new Gson();
	        busesForm.setListBusJson( gson.toJson((new BusBO()).getAllBusByUserId(userId)));
	        busesForm.setListProvince((new LocationBO()).getAllProvince());
	        busesForm.setListTripJson( gson.toJson((new TripBO()).getAllTripByUserId(userId)));
			return mapping.findForward("render");
		}
	}
	public static void main(String[] args) {
		System.out.println("q".equals("q"));
	}

}
