	package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.BusTypeForm;
import model.bean.BusType;
import model.bo.BusTypeBO;

public class EditBusTypeAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			request.setCharacterEncoding("UTF-8");
			BusTypeForm busTypeForm = (BusTypeForm) form;
			int maLoaiXe=0;
			BusTypeBO busTypeBO = new BusTypeBO();
			if(request.getParameter("id")!=null)
				maLoaiXe= Integer.parseInt(request.getParameter("id"));
			if("UPDATE".equals(busTypeForm.getSubmit())) {
				String tenLoaiXe = busTypeForm.getTenLoaiXe();
				int soGhe = busTypeForm.getSoGhe();
				int soTang = busTypeForm.getSoTang();
				String moTa = busTypeForm.getMoTa();

				busTypeBO.updateBusType(busTypeForm.getMaLoaiXe(), tenLoaiXe, soGhe, soTang, moTa);

				return mapping.findForward("success");
			} 
			else {
				BusType busType = busTypeBO.getBusTypeById(maLoaiXe);
				busTypeForm.setMaLoaiXe(busType.getMaLoaiXe());
				busTypeForm.setTenLoaiXe(busType.getTenLoaiXe());
				busTypeForm.setSoGhe(busType.getSoGhe());
				busTypeForm.setSoTang(busType.getSoTang());
				busTypeForm.setMoTa(busType.getMoTa());
				return mapping.findForward("render");
			}
		}
		catch(Exception ex)
		{
			response.sendRedirect(request.getContextPath()+"/404.do");
			return mapping.findForward("fail");
		}
		
	}
}
