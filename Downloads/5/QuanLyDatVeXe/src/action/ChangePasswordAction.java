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
import model.bean.User;
import model.bo.BusBO;
import model.bo.TransportServiceProviderBO;
import model.bo.UserBO;

public class ChangePasswordAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int uID = 0;
		request.setCharacterEncoding("UTF-8");
		UserForm userForm = (UserForm) form;
		UserBO userBO = new UserBO();
		
		PasswordEncrypt peEncrypt = new PasswordEncrypt();
		HttpSession session = request.getSession();
		if (session.getAttribute("maNguoiDung") != null) {
			 uID = (Integer) session.getAttribute("maNguoiDung");
		}
		if ("Save".equals(userForm.getSubmit())) {
			String oldPW = peEncrypt.md5(userForm.getOldPassword());
			String newPW = peEncrypt.md5(userForm.getNewPassword());
			String confirmNewPW = peEncrypt.md5(userForm.getConfirmNewPW());

			if (oldPW.equals(userBO.getPassword(uID).getPassword())) {
				if (newPW.equals(confirmNewPW)) {
					userBO.changePassword(uID, newPW);
					return mapping.findForward("success");
				}
			}
		}else {
			//userForm.setUsername(userBO.getPassword(uID).getUsername());
			//System.out.println(userBO.getPassword(uID).getUsername());
			return mapping.findForward("render");
		}
		return mapping.findForward("render");
	}

}
