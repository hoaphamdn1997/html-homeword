package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class LogoutAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			HttpSession session = request.getSession();
			if(session.getAttribute("username")!=null)
			{
				session.removeAttribute("username");
			}
			if(session.getAttribute("maNguoiDung")!=null)
			{
				session.removeAttribute("maNguoiDung");
			}
			return mapping.findForward("success");
		}
		catch(Exception ex)
		{
			return mapping.findForward("fail");
		}
	}
	
}
