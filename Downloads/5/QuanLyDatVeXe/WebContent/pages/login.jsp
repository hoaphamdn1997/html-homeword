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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng Nhập</title>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/css/register.css">
	<script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<body>
	<div class="container" id="main">
		<html:form action="/login" method="post">
			<div class="row">
				<h4 style="text-align: center">Đăng Nhập</h4>
				<p style="color:red"><bean:write name="userForm" property="notice"/></p>
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
        <p style="color:red" class="msg-error error"></p>
        <div class="input-group input-group-icon" style="padding-left: 80px">
          <div id="recaptcha" class="g-recaptcha" data-sitekey="6Le2RYkUAAAAAEg_bda4WAqRY3gui3KHLiHbCXFk"></div>
          <div class="text-center p-t-12">
						<span class="txt1">
						<html:link action="/quen-mat-khau.do"> Quên Mật khẩu </html:link>
						
                   <%--  <a class="txt2" href="${pageContext.request.contextPath}/Quan_Ly_Dat_Ve_Xe/pages/fogotpassword.jsp">
                        Quên mật khẩu
                    </a>  --%>
                        </span>
                </div>
        </div>
				<div class="nut">
          <input type="submit" class="btn" id="btn-validate" value="Đăng nhập">
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