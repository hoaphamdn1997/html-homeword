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

public class RegisterAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		UserForm userForm = (UserForm)form;
		PasswordEncrypt pEncrypt = new PasswordEncrypt();
		UserBO userBO = new UserBO();
		if(userForm.getUsername()==null)
		{
			return mapping.findForward("render");
		}
		else {
			if(pEncrypt.md5(userForm.getPassword()).equals(pEncrypt.md5(userForm.getPassword())))
			{
				userForm.setPassword(pEncrypt.md5(userForm.getPassword()));
				if(!userBO.checkExisted(userForm.getUsername()))
				{
					if(userBO.register(userForm))
					{
						HttpSession session = request.getSession();
						session.setAttribute("noticea","Đăng ký thành công");
						return mapping.findForward("success");
					}
					else
					{
						userForm.setNotice("Có lỗi xảy ra xin vui lòng kiểm tra lại!");
						return mapping.findForward("fail");
					}
				}
				else
				{
					userForm.setNotice("Username đã tồn tại!");
					return mapping.findForward("fail");
				}
				
				
			}
			userForm.setNotice("Tên đăng nhập hoặc mật khẩu không đúng định dạng!");
			return mapping.findForward("fail");
		}

	}
	

}
