package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ListTicketForm;
import model.bo.TicKetBO;

public class ListTicketManageAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		ListTicketForm listTicketForm = (ListTicketForm)form;
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
		
		TicKetBO ticketBO = new TicKetBO();
		int userId=(Integer)session.getAttribute("maNguoiDung");
		int totalRow = ticketBO.getRowCountTicketByUserId(userId);
		listTicketForm.setListTicket(ticketBO.getPaginationTicket(iPageIndex*5,userId));
		listTicketForm.setCurrentPageIndex(iPageIndex+1);
		listTicketForm.setPaginationNumber((int)Math.ceil((double)totalRow/5));
		return mapping.findForward("render");
	}
	
}
