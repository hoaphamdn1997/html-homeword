package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.TransportServiceProviderForm;
import model.bo.TransportServiceProviderBO;

public class CreateTransportServiceProviderAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		TransportServiceProviderForm transportProviceFrom = (TransportServiceProviderForm)form;
		
		if("submit".equals(transportProviceFrom.getSubmit()))
		{
			HttpSession session = request.getSession();
			int  maNguoiDung = (Integer)session.getAttribute("maNguoiDung");
			
			TransportServiceProviderBO tspBO = new TransportServiceProviderBO();
			if(tspBO.createTransportServiceProvider(transportProviceFrom,maNguoiDung)!=0)
				return mapping.findForward("success");
			return mapping.findForward("fail");
		}
		else
		{
			return mapping.findForward("fail");
		}
	}
	
}
