package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.UserForm;
import model.bean.PhanQuyen;
import model.bean.User;
import model.bean.UserTrangThai;
import model.bo.UserBO;

public class EditUserAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		UserForm userForm = (UserForm) form;
		UserBO userBO = new UserBO();
		int maNguoiDung = 0;

		ArrayList<PhanQuyen> listPhanQuyen = new ArrayList();
		listPhanQuyen.add(new PhanQuyen(0, "Admin"));
		listPhanQuyen.add(new PhanQuyen(1, "Nhà Xe"));
		listPhanQuyen.add(new PhanQuyen(2, "Người Dùng"));

		ArrayList<UserTrangThai> listTrangThai = new ArrayList();
		listTrangThai.add(new UserTrangThai(0, false));
		listTrangThai.add(new UserTrangThai(1, true));

		request.setAttribute("listTrangThai", listTrangThai);

		userForm.setListPhanQuyen(listPhanQuyen);
		userForm.setListTrangThai(listTrangThai);

		if ("UPDATE".equals(userForm.getSubmit())) {
			String tenNguoiDung = userForm.getTenNguoiDung();
			String userName = userForm.getUsername();
			String password = userForm.getPassword();
			String diaChi = userForm.getDiaChi();
			String email = userForm.getEmail();
			int phanQuyen = Integer.parseInt(userForm.getPhanQuyen());
			String sdt = userForm.getSoDienThoai();
			boolean trangThai = Boolean.parseBoolean(userForm.getTrangThai());
			userBO.updateUserInformation(Integer.parseInt(userForm.getMaNguoiDung()), userName, password, phanQuyen,
					tenNguoiDung, sdt, diaChi, email, trangThai);
			return mapping.findForward("success");
		} else {
			maNguoiDung = Integer.parseInt(request.getParameter("id"));

			User user = userBO.getUserById(maNguoiDung);
			userForm.setMaNguoiDung(String.valueOf(user.getMaNguoiDung()));
			userForm.setTenNguoiDung(user.getTenNguoiDung());
			userForm.setUsername(user.getUsername());
			userForm.setPassword(user.getPassword());
			userForm.setDiaChi(user.getDiaChi());
			userForm.setEmail(user.getEmail());
			userForm.setPhanQuyen(String.valueOf(user.getPhanQuyen()));
			userForm.setMaPhanQuyen(userForm.getMaPhanQuyen());
			userForm.setSoDienThoai(user.getSoDienThoai());
			boolean trangThaiSelected = user.isTrangThai();
			request.setAttribute("trangThaiSelected", trangThaiSelected);
			userForm.setTrangThai(String.valueOf(trangThaiSelected));
			

		}

		return mapping.findForward("render");

	}

}
