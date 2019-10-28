package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.AutoGenChair;
import common.Convert;
import form.BusForm;
import model.bean.Bus;
import model.bean.Ghe;
import model.bo.BusBO;
import model.bo.BusTypeBO;
import model.bo.TransportServiceProviderBO;

public class AddBusAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		BusForm busForm = (BusForm)form;
		if(busForm.getSubmit()!=null && busForm.getSubmit().equals("submit"))
		{
			HttpSession session = request.getSession();
			int userId = (Integer)session.getAttribute("maNguoiDung");
			int tspId = (new TransportServiceProviderBO()).getTransportServiceProviderIdByUserId(userId);
			if(tspId == 0) return mapping.findForward("fail");
			System.out.println(tspId);
			int maXe = (new BusBO()).AddNewBus(busForm,tspId);
			if(maXe>0)
			{
				ArrayList<ArrayList<Ghe>> listGheMaxtrix=null;
				listGheMaxtrix=(new AutoGenChair()).genChair(busForm.getMaLoaiXe());
				ArrayList<Ghe>listGhe = (new Convert()).convertMatrixToChairArr(listGheMaxtrix);
				Bus bus = new Bus();
				 bus.setListGhe(listGhe);
				(new BusBO()).addNewLayOutChair(bus,maXe);
				return mapping.findForward("success");
			}
			else
				return mapping.findForward("fail");
		}
		else
		{
			busForm.setListBusType((new BusTypeBO()).getAllBusType());
			return mapping.findForward("render");
		}
	}
	
}
