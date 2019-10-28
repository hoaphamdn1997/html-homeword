<%@page import="common.StringProcess"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<meta charset="UTF-8">
<title>Đăng Ký tài khoản</title>

 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">

</head>
<body>
	<div class="container">
		<html:form action="/register" method="post">
			<div class="row">
				<h4>Đăng kí tài khoản</h4>
				<div class="input-group input-group-icon">
					<input type="text" placeholder="Tên Đăng Nhập" name="username" required/>
					<div class="input-icon">
						<i class="fa fa-user"></i>
					</div>
					<html:errors property="usernameError"/>
				</div>
				<div class="input-group input-group-icon">
					<input type="password" placeholder="Mât Khẩu" name="password" required/>
					<div class="input-icon">
						<i class="fa fa-envelope"></i>
					</div>
					<html:errors property="passwordError"/>
				</div>
				<div class="input-group input-group-icon">
					<input type="password" placeholder="Nhập lại mật khẩu"
						name="rePassword" required/>
					<div class="input-icon">
						<i class="fa fa-envelope"></i>
					</div>
					<html:errors property="passwordError"/>
				</div>
				<div class="input-group input-group-icon">
					<input type="text" placeholder="Họ Tên" name="tenNguoiDung" required/>
					<div class="input-icon">
						<i class="fa fa-key"></i>
					</div>
				</div>
				<div class="input-group input-group-icon">
					<input type="text" placeholder="Địa chỉ" name="diaChi" />
					<div class="input-icon">
						<i class="fa fa-key"></i>
					</div>
				</div>
				<div class="input-group input-group-icon">
					<input type="text" placeholder="SĐT" name="soDienThoai" />
					<div class="input-icon">
						<i class="fa fa-phone"></i>
					</div>
				</div>
				<div class="input-group input-group-icon">
					<input type="email" placeholder="Email" name="email" />
					<div class="input-icon">
						<i class="fa fa-key"></i>
					</div>
				</div>
				<div class="nut">
					<html:submit styleClass="btn btn-primary">Đăng Ký</html:submit>
					<input type="reset" value="Hủy" onclick="window.location.replace('${pageContext.request.contextPath}')">
				</div>

			</div>
		</html:form>
	</div>
	
	
	
	<!-- <script
		src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script> -->
</body>
</html>