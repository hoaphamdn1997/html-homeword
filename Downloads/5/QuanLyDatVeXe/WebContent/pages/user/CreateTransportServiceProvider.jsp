<%@page import="common.StringProcess"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tạo Mới Nhà Xe</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style-customize.css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.11.2.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<body>
	
	<div class="container" style="margin:20% auto">
		<div class="row" >
			<h3 style="color:black">Tạo mới Nhà Xe</h3>
			<br>
			<html:form styleClass="form-horizontal" action="/user/createTransportServiceProvider" method="POST">
				<div class="form-group">
					<label class="control-label col-md-3" style="color:black">Tên Nhà Xe:</label>
					<div class="col-md-9">
						<input type="text" class="form-control" name="tenNhaXe"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3" style="color:black">Địa Chỉ:</label>
					<div class="col-md-9">
						<input type="text" class="form-control" name="diaChi"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3" style="color:black">Số Điện Thoại:</label>
					<div class="col-md-9">
						<input type="number" class="form-control" name="soDienThoai"/>
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-offset-3 col-md-9">
						<button type="submit" name="submit" class="btn btn-success" value="submit">Tạo mới</button>
					</div>
				</div>
			</html:form>
		</div>
	</div>
</body>
</html>