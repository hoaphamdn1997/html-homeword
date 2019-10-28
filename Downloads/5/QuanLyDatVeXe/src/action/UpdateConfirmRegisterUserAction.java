package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.UserForm;

import model.bean.User;
import model.bo.UserBO;

public class UpdateConfirmRegisterUserAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		UserForm userForm =(UserForm) form;
		UserBO userBO =new UserBO ();
		
		//System.out.println(maNguoiDung);
		if(userForm.getSubmit()!=null)
		{
			String username = userForm.getUsername();
			System.out.println(userForm.getMaNguoiDung());
			//System.out.println(userForm.getMaNguoiDung());
			int maUser =Integer.parseInt(userForm.getMaNguoiDung());
			//System.out.println(maUser);
			userBO.confirm(maUser);
			return mapping.findForward("success");
		}else{	
			int maNguoiDung = Integer.parseInt(request.getParameter("id"));
			User user = userBO.getInfUser(maNguoiDung);
			userForm.setUsername(user.getUsername());
			userForm.setTenNguoiDung(user.getTenNguoiDung());
			userForm.setSoDienThoai(user.getSoDienThoai());
			userForm.setDiaChi(user.getDiaChi());
			userForm.setEmail(user.getEmail());
			userForm.setMaNguoiDung(request.getParameter("id"));
			return mapping.findForward("load");
		}
		
			
			
				
		
	}
	
	
}
