<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="vi"
	prefix="og: http://ogp.me/ns# fb: http://ogp.me/ns/fb# product: http://ogp.me/ns/product#">
<meta name="viewport"
	content="width=device-width, height=device-height, initial-scale=1, maximum-scale=1, user-scalable=0">
<title>Đổi mật khẩu</title>

<meta charset="utf-8">

<link
	href="${pageContext.request.contextPath}/public/chooseSeat/Content/vxr/images/vexere-ico.ico@v=00340"
	rel="shortcut icon" type="image/x-icon">
<link
	href="${pageContext.request.contextPath}/public/chooseSeat/bundles/route-styles.css@v=00340.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style-customize.css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.11.2.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
	
<body>

  <%@ include file="/pages/partion/HeaderCustomer.jsp"%>
<div class="container" style="margin-top:50px;">
  <FORM action="${pageContext.request.contextPath}/account/changePassword.do" method="post" class="form-horizontal">
    <div class="col-md-7 col-md-offset-2">
      <h4>Đổi mật khẩu
      </h4>
      <div class="form-group">
      	<div class="col-md-4">
      		<label> Mật khẩu cũ <span style="display:inline; color:red" >(*)</span>:</label>
      	</div>
      	<div class="col-md-8">
      	<input type="password" placeholder="nhập mật khẩu của bạn" name="oldPassword" class="form-control" required/>
      	</div>
      	
      </div>
      
      <div class="form-group">
      <div class="col-md-4">
      		<label> Mật khẩu mới <span style="display:inline; color:red" >(*)</span>:</label>
      	</div>
      	<div class="col-md-8">
       	<input type="password" placeholder="mật khẩu mới" name="newPassword" class="form-control" required/> 
       	</div>
      </div>
      
      <div class="form-group">
      <div class="col-md-4">
      		<label>nhập lại mật khẩu mới <span style="display:inline; color:red" >(*)</span>:</label>
      	</div>
      	<div class="col-md-8">
        <input type="password" placeholder="nhập lại mật khẩu mới" name="confirmNewPW" class="form-control" required/>
        </div>
      </div>
      <div class="form-group">
      <div class="col-md-4">
      	</div>
      	<div class="col-md-8">
          <button name="submit" value="Trở về" class="btn btn-primary" style="margin-right: 3rem" onclick="history.go(-1);">Trở về</button>
          <button id="btn-validate" name="submit" value="Save" class="btn btn-success">Đổi mật khẩu</button>
        </div>
      </div>
    </div>


  </FORM>
</div>


</body>
</html>