package action;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.UserForm;
import model.dao.UserDAO;

public class SendEmailUserAction extends Action{
	public static final String HOST_NAME = "smtp.gmail.com";

	public static final int SSL_PORT = 465; // Port for SSL

	public static final int TSL_PORT = 587; // Port for TLS/STARTTLS

	public static final String APP_EMAIL = "phanvanduan96@gmail.com"; // email cá»§a mÃ¬nh

	public static final String APP_PASSWORD = "01071996"; // Máº­t kháº©u mail
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		UserForm userForm = (UserForm)form;

		if ("submit".equals(userForm.getSubmit())) {
			try {
				String email=userForm.getEmail();
				String username=userForm.getUsername();
				Properties props = new Properties();
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.host", HOST_NAME);
				props.put("mail.smtp.socketFactory.port", SSL_PORT);
				props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				props.put("mail.smtp.port", SSL_PORT);
				// get Session
				Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(APP_EMAIL,APP_PASSWORD);
					}
				});

				UserDAO userDAO=new UserDAO();
				String pass= userDAO.getSendEmailPasswordUser1(username,email)+".";
				System.out.println( pass);
				System.out.println(pass+" "+username);
				String tenNguoiDung= userDAO.getSendEmailPasswordUser2(username,email);
				if(pass.trim().equals(".")){
					System.out.println("vao tran dia");
					request.setAttribute("msg", "Tên Tài khoản hoặc Email không đúng,hãy thử lại!");
					return mapping.findForward("thanhCong");
				}

				else if ( email!= null && username!=null && pass!=null) {
						
						try {
							String  thongbao = "Tên Người Dùng : " +tenNguoiDung+"\n"+ "Tên tài khoản của bạn : " +username + ", Mật khẩu của bạn: " +pass+".";
							MimeMessage message = new MimeMessage(session);
							message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userForm.getEmail()));
							message.setSubject("Thông Báo Nhận Lại Mật khẩu Của Bạn !!!","UTF-8");
				            message.setText(thongbao, "UTF-8");
							System.out.println("Sent success to :" + userForm.getEmail());
							Transport.send(message);
							request.setAttribute("msg", "Gửi thành công !");
							return mapping.findForward("thanhCong");
						} catch (MessagingException e) {
							throw new RuntimeException(e);
						}
					}
				
			} catch (Exception e) {
				
				request.setAttribute("msg", "Có lỗi trong quá trình xử lý!");
				return mapping.findForward("thanhCong");
			}
		}
			
		
		return mapping.findForward("email");
		
	
		
		
	}
}
