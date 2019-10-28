package action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import model.bo.UserBO;

public class DeleteUserAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*PrintWriter out = response.getWriter();
		out.println("dasadasdsad");*/
		String id = request.getParameter("id");
		try {
			int iid = Integer.parseInt(id);
			UserBO userBO = new UserBO();
			if(userBO.removeUser(iid))
			{
				return mapping.findForward("success");
			}
			else
			{
				return mapping.findForward("fail");
			}
		}
		catch(Exception ex)
		{
			return mapping.findForward("fail");
		}
	}
	
}
