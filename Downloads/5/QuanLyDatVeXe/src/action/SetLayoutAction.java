package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.google.gson.Gson;

import common.AutoGenChair;
import common.Convert;
import form.BusForm;
import model.bean.Bus;
import model.bean.BusType;
import model.bean.Ghe;
import model.bo.BusBO;
import model.bo.BusTypeBO;
import model.bo.ChairBO;

public class SetLayoutAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		BusForm busForm = (BusForm) form;
		
		//submit layout
		if(busForm.getSubmit()!=null && busForm.getSubmit().equals("submit"))
		{
			Gson gson = new Gson();
			String jsonInString = busForm.getChairLayoutJson();
			Bus jsonBus = gson.fromJson(jsonInString,  Bus.class);
			BusBO busBO = new BusBO();
			(new ChairBO()).deleteAllCharByBusId(busForm.getMaXeHienTai());
			busBO.addNewLayOutChair(jsonBus,busForm.getMaXeHienTai());
			
			return mapping.findForward("fail");
		}
		else
		{	
			HttpSession session = request.getSession();
			int userId = (Integer)session.getAttribute("maNguoiDung");
			ArrayList<Bus> listBus = (new BusBO()).getAllBusByUserId(userId);
			request.setAttribute("listBus", listBus);
			if(listBus==null || listBus.size()==0) 
				return mapping.findForward("fail");
			
			int busId =busForm.getMaXeHienTai();
			if(busId==0) busId = listBus.get(0).getMaXe();
			busForm.setMaXeHienTai(busId);
			
			
			BusBO busBO = new BusBO();
			BusType busType = (new BusTypeBO()).getBusTypeByBusId(busId);
			int floor = busType.getSoTang();
			 
			ArrayList<Ghe> listGhe = (new ChairBO().getChairByBusId(busId));
			Convert convert = new Convert();
			ArrayList<ArrayList<Ghe>> listGheMaxtrix=null;
			if(listGhe.size()!=0)
			{
				listGheMaxtrix= convert.convertArrToMatrix(listGhe);
			}
			else
			{
				listGheMaxtrix=(new AutoGenChair()).genChair(busType.getMaLoaiXe());
				//in(listGheMaxtrix);
			}
			request.setAttribute("listGheMatrix",listGheMaxtrix);
			
			request.setAttribute("soTang", floor);
			return mapping.findForward("render");
		}
	}
	
	void in(ArrayList<ArrayList<Ghe>> s)
	{
		for(int i=0;i<s.size();i++)
		{
			for(int j=0;j<s.get(i).size();j++)
			{
				System.out.print(s.get(i).get(j).getVtHang()+",");
			}
			System.out.println();
		}
			
		
	}
	
}
