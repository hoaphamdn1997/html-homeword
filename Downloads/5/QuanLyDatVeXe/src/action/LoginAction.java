package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.PasswordEncrypt;
import form.UserForm;
import model.bo.UserBO;

public class LoginAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		UserForm userForm = (UserForm)form;
		PasswordEncrypt peEncrypt = new PasswordEncrypt();
		UserBO userBO = new UserBO();
		if(userForm.getUsername()==null)
		{
			return mapping.findForward("render");
		}
		else {
			model.bean.User user = userBO.checkLogin(userForm.getUsername(),peEncrypt.md5(userForm.getPassword()));
			if(user!=null&&user.getPhanQuyen()==0)
			{
				HttpSession session = request.getSession();
				session.setAttribute("username", userForm.getUsername());
				session.setAttribute("maNguoiDung", user.getMaNguoiDung());
				session.setAttribute("role", user.getPhanQuyen());
				session.setAttribute("tenNguoiDung", user.getTenNguoiDung());
				return mapping.findForward("success-admin");
			}
			else if(user!=null && user.getPhanQuyen()==1)
			{
				HttpSession session = request.getSession();
				session.setAttribute("username", userForm.getUsername());
				session.setAttribute("maNguoiDung", user.getMaNguoiDung());
				session.setAttribute("role", user.getPhanQuyen());
				session.setAttribute("tenNguoiDung", user.getTenNguoiDung());
				model.bean.User user1 =  userBO.checkIfTransporterExist(userForm.getUsername());
				if(user1!=null && user1.getPhanQuyen()==1)
					return mapping.findForward("success-user");
				else
				{
					return mapping.findForward("success-create-nx");
				}
			}
			else if(user!=null && user.getPhanQuyen()==2)
			{
				HttpSession session = request.getSession();
				session.setAttribute("username", userForm.getUsername());
				session.setAttribute("maNguoiDung", user.getMaNguoiDung());
				session.setAttribute("role", user.getPhanQuyen());
				session.setAttribute("tenNguoiDung", user.getTenNguoiDung());
				//userForm.setNotice("//");
				return mapping.findForward("success-customer");
			}
			else
			{
				userForm.setNotice("Sai tên đăng nhập hoặc mật khẩu, xin vui lòng kiểm tra lại !");
				return mapping.findForward("fail");
			}
		}

	}

}
