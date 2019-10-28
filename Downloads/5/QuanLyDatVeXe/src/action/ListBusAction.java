package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ListBusForm;
import model.bo.BusBO;

public class ListBusAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		ListBusForm listBusForm = (ListBusForm)form;
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
		
		BusBO busBO = new BusBO();
		int userId=(Integer)session.getAttribute("maNguoiDung");
		int totalRow = busBO.getRowCountBusByUserId(userId);
		listBusForm.setListBus(busBO.getPaginationBus(iPageIndex*5,userId));
		listBusForm.setCurrentPageIndex(iPageIndex+1);
		listBusForm.setPaginationNumber((int)Math.ceil((double)totalRow/5));
		return mapping.findForward("success");
	}
	
}
