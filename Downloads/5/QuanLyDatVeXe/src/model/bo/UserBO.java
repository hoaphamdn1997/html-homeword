package model.bo;

import java.util.ArrayList;

import form.UserForm;
import model.bean.User;
import model.dao.UserDAO;

public class UserBO {
	UserDAO userDAO = new UserDAO();

	public User checkLogin(String username, String password) {

		return userDAO.checkLogin(username, password);
	}
	
	public int getRowCountUser() {
		return userDAO.getRowCountUser();
	}

	public ArrayList<User> getPaginationUsers(int i) {
		return userDAO.getPaginationUsers(i);
	}

	public ArrayList<User> getPeddingPaginationUsers(int i) {
		return userDAO.getPeddingPaginationUsers(i);
	}

	public boolean register(UserForm userForm) {
		return userDAO.register(userForm);
	}
	public int an_register(String username,String fullname,String phone,String address) {
		return userDAO.an_register( username, fullname, phone, address);
	}

	public User getOneUser(String username) {
		return userDAO.getOneUser(username);
	}

	public User checkIfTransporterExist(String username) {
		return userDAO.checkIfTransporterExist(username);
	}

	public User changePassword(int uID, String newPassword) {
		return userDAO.changePassword(uID, newPassword);
	}

	public User getPassword(int uid) {
		return userDAO.getPassword(uid);
	}

	public boolean removeUser(int id) {
		return userDAO.removeUser(id);
	}

	public User getUserById(int id) {
		return userDAO.getUserById(id);
	}

	public User updateUserInformation(int maNguoiDung, String userName, String password, int phanQuyen,
			String tenNguoiDung, String phone, String diaChi, String email, boolean trangThai) {
		return userDAO.updateUserInformation(maNguoiDung, userName, password, phanQuyen, tenNguoiDung, phone, diaChi,
				email, trangThai);
	}

	public void ChangeInfo(int userId, String username, String tenNguoiDung, String soDienThoai, String diaChi,
			String email) {
		userDAO.ChangeInfo(userId, username, tenNguoiDung, soDienThoai, diaChi, email);
	}

	public ArrayList<User> getConfirmUser() {

		return userDAO.getConfirmUser();
	}

	public void confirm(int maNguoiDung) {
		userDAO.confirm(maNguoiDung);
	}

	public User getInfUser(int id) {
		return userDAO.getInforUser(id);
	}

	public ArrayList<User> getPeddingPaginationConfirmUsers(int i) {
		return userDAO.getPeddingPaginationConfirmUsers(i);
	}

	public int getRowCountPenddingUser() {
		return userDAO.getRowCountPenddingUser();
	}

	public void RegisterTransport(int userId, String noiDungPheDuyet) {
		userDAO.RegisterTransport(userId, noiDungPheDuyet);

	}

	public boolean checkExisted(String username) {
		return userDAO.checkExisted(username);
	}

}
