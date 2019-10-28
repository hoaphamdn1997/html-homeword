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

public class FilterTicketAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		ListTicketForm listTicketForm = (ListTicketForm)form;
		System.out.println(listTicketForm.getSubmit());
		if(listTicketForm.getSubmit().equals("submit"))
		{
			System.out.println("success");
			int iPageIndex=0;
			
			HttpSession session = request.getSession();
			
			TicKetBO ticketBO = new TicKetBO();
			int userId=(Integer)session.getAttribute("maNguoiDung");
			int totalRow = ticketBO.getRowCountTicketByUserId(userId,listTicketForm.getTenXe(),listTicketForm.getNgatXuatPhat());
			System.out.println(totalRow);
			listTicketForm.setListTicket(ticketBO.getPaginationFilterTicket(iPageIndex*5,userId,listTicketForm.getTenXe(),listTicketForm.getNgatXuatPhat()));
			listTicketForm.setCurrentPageIndex(iPageIndex+1);
			listTicketForm.setPaginationNumber((int)Math.ceil((double)totalRow/5));
			return mapping.findForward("render");
		}
		System.out.println("fail");
		return mapping.findForward("fail");
	}
	
}
