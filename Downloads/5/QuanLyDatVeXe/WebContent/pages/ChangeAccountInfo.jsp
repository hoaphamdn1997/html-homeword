<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "" "">
<html>
<head lang="vi"
	prefix="og: http://ogp.me/ns# fb: http://ogp.me/ns/fb# product: http://ogp.me/ns/product#">
<meta name="viewport"
	content="width=device-width, height=device-height, initial-scale=1, maximum-scale=1, user-scalable=0">
<title>Thông tin tài khoản</title>

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
	<div class="container">
		<html:form action="account/changeInfo" method="post" styleClass="form-horizontal">
			<div class="row" style="margin-top:50px">
				<div class="col-md-7 col-md-offset-2">
					<div class="form-group">
						<div class="col-md-3">
							<label>Tên đăng nhập</label>
						</div>
						<div class="col-md-8">
						<html:text property="username" styleClass="form-control" readonly="true"></html:text>
						</div>
					</div>

					<div class="form-group">
						<div class="col-md-3">
							<label>Tên Người dùng</label>
						</div>
						<div class="col-md-8">
							<html:text property="tenNguoiDung" styleClass="form-control"></html:text>
						</div>
					</div>

					<div class="form-group">
					<div class="col-md-3">
							<label>Số điện thoại</label>
						</div>
						<div class="col-md-8">
						<html:text property="soDienThoai" styleClass="form-control"></html:text>
						</div>
					</div>

					<div class="form-group">
					<div class="col-md-3">
							<label>Địa chỉ</label>
						</div>
						<div class="col-md-8">
						<html:text property="diaChi" styleClass="form-control"></html:text>
						</div>
					</div>

					<div class="form-group">
					<div class="col-md-3">
							<label>Email</label>
						</div>
						<div class="col-md-8">
						<html:text property="email" styleClass="form-control"></html:text>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2 col-md-offset-3">
						<button class="btn btn-success" name="submit"
							value="submit">Lưu lại</button>
						</div>
						<div class="col-md-2 ">
						<a type="button" href="${pageContext.request.contextPath}/account/changePassword.do" class="btn btn-primary" >Đổi mật khẩu</a>
						</div>
					</div>
				</div>
				
				

		</html:form>
	</div>
</body>
</html>