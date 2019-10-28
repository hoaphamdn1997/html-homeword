package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.UserForm;
import model.bean.User;
import model.bo.UserBO;

public class InitUserAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		UserForm userForm = (UserForm)form;
		
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		
		User user = (new UserBO()).checkIfTransporterExist(username);
		
		if(user!=null && user.getPhanQuyen()==1)
		{
			return mapping.findForward("render");
		}
		return mapping.findForward("render");
	}
	
}
