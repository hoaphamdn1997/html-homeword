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
<title>Quên mật khẩu</title>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/css/register.css">
	<script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<body>
	<div class="container" id="main">
		<html:form action="/quen-mat-khau" method="post">
			<div class="row">
				<h4 style="text-align: center">Quên mật khẩu</h4>
				<p style="color:red"><bean:write name="userForm" property="notice"/></p>
				<div class=" ">
                 <label>Tên Cho Người Dùng(<p style="color: red; display: inline;">*</p>):</label><br><br>
                 <html:text property="username" styleClass="form-control" ></html:text>
                                           
					<html:errors property="usernameError"/>
				</div><br>
				<div class=" ">
				<label>Email(<p style="color: red; display: inline;">*</p>):</label><br><br>
                 <html:text  property="email" styleClass="form-control" ></html:text>
					
					
        </div>
         <div class="form-group" >
                                    	<logic:notEmpty name="msg">
											<p style="color: green; font-weight: bold;">
												<bean:write name="msg"/>
											</p>
										</logic:notEmpty>
                                    </div>
        
        <p style="color:red" class="msg-error error"></p>
        <div class="input-group input-group-icon" style="padding-left: 80px">
          
        </div>
				<div class="nut">
          <!-- <input type="submit" class="btn" id="btn-validate" value="send"/> -->
           <html:submit  styleClass="btn btn-primary" property="submit" value="submit">gửi</html:submit>
					<input type="reset" value="back" onclick="window.location.replace('${pageContext.request.contextPath}')">
				</div>
			</div>
		</html:form>
	</div>
</body>

</html>