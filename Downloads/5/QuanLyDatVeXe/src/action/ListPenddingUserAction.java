package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ListUserForm;
import model.bo.UserBO;

public class ListPenddingUserAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		ListUserForm listUserForm = (ListUserForm)form;
		String pageIndex = request.getParameter("page");
		
		int iPageIndex=0;
		try {
			iPageIndex = Integer.parseInt(pageIndex)-1;
		}
		catch(Exception ex)
		{
			iPageIndex=0;
		}
		
		UserBO userBO = new UserBO();
		int totalRow = userBO.getRowCountPenddingUser();
		
		listUserForm.setListUser(userBO.getPeddingPaginationConfirmUsers(iPageIndex*5));
		listUserForm.setCurrentPageIndex(iPageIndex+1);
		listUserForm.setPaginationNumber((int)Math.ceil((double)totalRow/5));
		return mapping.findForward("render");
	}
	
}
