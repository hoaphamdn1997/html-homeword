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

public class RegisterToBeTransporterAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
		UserForm userForm = (UserForm)form;
		UserBO userBO = new UserBO(); 
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("maNguoiDung");
		//System.out.println(userId);
		if(userForm.getSubmit()!=null)
		{
			String username = userForm.getUsername();
			String tenNguoiDung = userForm.getTenNguoiDung();
			String soDienThoai = userForm.getSoDienThoai();
			String tenNhaXe = userForm.getTenNhaXe();
			String diaChi = userForm.getDiaChi();
			String email = userForm.getEmail();
			String noiDungPheDuyet = userForm.getNoiDungPheDuyet();
			//System.out.println(noiDungPheDuyet);
			String tongThe = tenNhaXe +"--"+ diaChi+"--"+soDienThoai+"----"+noiDungPheDuyet;
			
			System.out.println(tongThe);
			userBO.RegisterTransport(userId,tongThe);
			return mapping.findForward("success");
		}else{	
			User user = userBO.getInfUser(userId);
			userForm.setUsername(user.getUsername());
			userForm.setTenNguoiDung(user.getTenNguoiDung());
			userForm.setSoDienThoai(user.getSoDienThoai());
			userForm.setDiaChi(user.getDiaChi());
			userForm.setEmail(user.getEmail());
			return mapping.findForward("render");
		}
		}
		catch(Exception ex)
		{
			return mapping.findForward("fail");
		}
		
	}
	
}
