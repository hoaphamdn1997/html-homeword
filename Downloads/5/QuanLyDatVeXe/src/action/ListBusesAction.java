package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ListBusesForm;
import model.bo.BusesBO;

public class ListBusesAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		ListBusesForm listBusesForm = (ListBusesForm)form;
		String pageIndex = request.getParameter("page");
		
		int iPageIndex=0;
		try {
			iPageIndex = Integer.parseInt(pageIndex)-1;
		}
		catch(Exception ex)
		{
			iPageIndex=0;
		}
		HttpSession session = request.getSession();
		
		BusesBO busesBO = new BusesBO();
		int userId=(Integer)session.getAttribute("maNguoiDung");
		int totalRow = busesBO.getRowCountBusesByUserId(userId);
		listBusesForm.setListBuses(busesBO.getPaginationBuses(iPageIndex*5,userId));
		listBusesForm.setCurrentPageIndex(iPageIndex+1);
		listBusesForm.setPaginationNumber((int)Math.ceil((double)totalRow/5));
		return mapping.findForward("success");
	}
}
