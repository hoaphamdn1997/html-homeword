package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.BusTypeForm;
import model.bo.BusTypeBO;

public class AddBusTypeAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		BusTypeForm busForm =  (BusTypeForm)form;
		BusTypeBO busType = new BusTypeBO();
		if(busForm.getSubmit()!=null){
			String tenLoaiXe = busForm.getTenLoaiXe();
			int soGhe = busForm.getSoGhe();
			int soTang = busForm.getSoTang();
			String moTa =busForm.getMoTa();
			busType.AddBusType(tenLoaiXe,soGhe,soTang,moTa);
			return mapping.findForward("success");
		}
	
		return mapping.findForward("render");
	}

}
