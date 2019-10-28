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

  <link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/register.css">

</head>
<body>
	<div class="container">
		<html:form action="/register" method="post">
			<div class="row">
				<h4>Đăng kí tài khoản</h4>
				<p style="color:red"><bean:write name = "userForm" property="notice"/></p>
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
						<i class="fa fa-key"></i>
					</div>
					<html:errors property="passwordError"/>
				</div>
				<div class="input-group input-group-icon">
					<input type="password" placeholder="Nhập lại mật khẩu"
						name="rePassword" required/>
					<div class="input-icon">
						<i class="fa fa-key"></i>
					</div>
					<html:errors property="passwordError"/>
				</div>
				<div class="input-group input-group-icon">
					<input type="text" placeholder="Họ Tên" name="tenNguoiDung" required/>
					<div class="input-icon">
						<i class="fa fa-users"></i>
					</div>
				</div>
				<div class="input-group input-group-icon">
					<input type="text" placeholder="Địa chỉ" name="diaChi" />
					<div class="input-icon">
						<i class="fa fa-location-arrow"></i>
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
						<i class="fa fa-envelope"></i>
					</div>
        </div>
        <p style="color:red" class="msg-error error"></p>
        <div class="input-group input-group-icon" style="padding-left: 80px">
          <div id="recaptcha" class="g-recaptcha" data-sitekey="6Le2RYkUAAAAAEg_bda4WAqRY3gui3KHLiHbCXFk"></div>
        </div>
				<div class="nut">
					<html:submit styleClass="btn btn-primary">Đăng Ký</html:submit>
					<input type="reset" value="Trở về" onclick="window.location.replace('${pageContext.request.contextPath}')">
				</div>

			</div>
		</html:form>
	</div>
</body>
<!--js-->
<script src='https://www.google.com/recaptcha/api.js'></script>
<script>
$( '#btn-validate' ).click(function(){
  var $captcha = $( '#recaptcha' ),
      response = grecaptcha.getResponse();
  
  if (response.length === 0) {
    $( '.msg-error').text( "Vui lòng xác nhận Captcha" );
    if( !$captcha.hasClass( "error" ) ){
      $captcha.addClass( "error" );
    }
  }
})
</script>
</html>