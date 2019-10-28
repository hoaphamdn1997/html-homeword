package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ListBusTypeForm;
import model.bo.BusTypeBO;

public class ListBusTypeAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		ListBusTypeForm listBusTypeForm = (ListBusTypeForm)form;
		String pageIndex = request.getParameter("page");
		
		int iPageIndex=0;
		try {
			iPageIndex = Integer.parseInt(pageIndex)-1;
		}
		catch(Exception ex)
		{
			iPageIndex=0;
		}
		
		BusTypeBO busTypeBO = new BusTypeBO();
		int totalRow = busTypeBO.getRowCountBusType();
		
		listBusTypeForm.setListBusType(busTypeBO.getPaginationBusType(iPageIndex*5));
		listBusTypeForm.setCurrentPageIndex(iPageIndex+1);
		listBusTypeForm.setPaginationNumber((int)Math.ceil((double)totalRow/5));
		return mapping.findForward("success");
	}
}
