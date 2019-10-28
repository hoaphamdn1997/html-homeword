package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.PhanQuyen;
import model.bean.UserTrangThai;

public class UserForm extends ActionForm{
	private String username, password,notice,submit,rePassword,tenNguoiDung,soDienThoai,
	diaChi,email,maNhaXe,maNguoiDung;
	private String oldPassword, newPassword, confirmNewPW;
	private String phanQuyen,trangThai,noiDungPheDuyet,tenNhaXe;
	private String send;
	
	private int maPhanQuyen, maTrangThai;
	private ArrayList<PhanQuyen> listPhanQuyen;
	private ArrayList<UserTrangThai> listTrangThai;
	
	public String getTenNhaXe() {
		return tenNhaXe;
	}

	public void setTenNhaXe(String tenNhaXe) {
		this.tenNhaXe = tenNhaXe;
	}

	public String getNoiDungPheDuyet() {
		return noiDungPheDuyet;
	}

	public void setNoiDungPheDuyet(String noiDungPheDuyet) {
		this.noiDungPheDuyet = noiDungPheDuyet;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getPhanQuyen() {
		return phanQuyen;
	}

	public void setPhanQuyen(String phanQuyen) {
		this.phanQuyen = phanQuyen;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmNewPW() {
		return confirmNewPW;
	}

	public void setConfirmNewPW(String confirmNewPW) {
		this.confirmNewPW = confirmNewPW;
	}

	public String getMaNguoiDung() {
		return maNguoiDung;
	}

	public void setMaNguoiDung(String maNguoiDung) {
		this.maNguoiDung = maNguoiDung;
	}

	public String getTenNguoiDung() {
		return tenNguoiDung;
	}

	public void setTenNguoiDung(String tenNguoiDung) {
		this.tenNguoiDung = tenNguoiDung;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMaNhaXe() {
		return maNhaXe;
	}

	public void setMaNhaXe(String maNhaXe) {
		this.maNhaXe = maNhaXe;
	}

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	public int getMaPhanQuyen() {
		return maPhanQuyen;
	}

	public void setMaPhanQuyen(int maPhanQuyen) {
		this.maPhanQuyen = maPhanQuyen;
	}

	public int getMaTrangThai() {
		return maTrangThai;
	}

	public void setMaTrangThai(int maTrangThai) {
		this.maTrangThai = maTrangThai;
	}

	public ArrayList<PhanQuyen> getListPhanQuyen() {
		return listPhanQuyen;
	}

	public void setListPhanQuyen(ArrayList<PhanQuyen> listPhanQuyen) {
		this.listPhanQuyen = listPhanQuyen;
	}

	public ArrayList<UserTrangThai> getListTrangThai() {
		return listTrangThai;
	}

	public void setListTrangThai(ArrayList<UserTrangThai> listTrangThai) {
		this.listTrangThai = listTrangThai;
	}
	

	public String getSend() {
		return send;
	}

	public void setSend(String send) {
		this.send = send;
	}

	@Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.getMessage();
        }
        super.reset(mapping, request);
    }
}
