package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.BusForm;
import model.bean.Bus;
import model.bo.BusBO;
import model.bo.BusTypeBO;
import model.bo.TransportServiceProviderBO;

public class EditBusAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		BusForm busForm = (BusForm)form;
		if(busForm.getSubmit()!=null && busForm.getSubmit().equals("submit"))
		{
			if((new BusBO()).EditBus(busForm))
				return mapping.findForward("success");
			else
				return mapping.findForward("fail");
		}
		else
		{
			Bus bus = (new BusBO()).getOneBusByBusId(Integer.parseInt(request.getParameter("id")));
			busForm.setMaXe(bus.getMaXe());
			busForm.setTenXe(bus.getTenXe());
			busForm.setBienSo(bus.getBienSo());
			busForm.setMaLoaiXe(bus.getMaLoaiXe());
			
			busForm.setListBusType((new BusTypeBO()).getAllBusType());
			return mapping.findForward("render");
		}
	}
	
}

