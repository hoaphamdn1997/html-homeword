<%@page import="model.bean.UserTrangThai"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%-- <%@ page import="Model.bean.* %> --%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Sửa thông tin người dùng</title>

<!-- Bootstrap -->
<link
	href="${pageContext.request.contextPath}/public/src/vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link
	href="${pageContext.request.contextPath}/public/src/vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<!-- NProgress -->
<link
	href="${pageContext.request.contextPath}/public/src/build/css/custom.min.css"
	rel="stylesheet">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/public/css/style-customize.css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.11.2.min.js"></script>
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!--Side bar-->
			<%@ include file="/pages/partion/NewSideBar.jsp"%>
			<!-- Headers-->
			<%@ include file="/pages/partion/NewHeaderAdmin.jsp"%>
			<!-- /End Headers -->

			<!-- page content -->
			<div class="right_col" role="main">
				<div class="">
					<div class="page-title">
						<div class="title_left">
							<h3>Sửa thông tin người dùng</h3>
						</div>

						<div class="title_right">
							<div
								class="col-md-7 col-md-7 col-xs-12 form-group pull-right top_search">
								<div class="input-group">
									<input type="text" class="form-control" placeholder="Từ Khóa">
									<span class="input-group-btn">
										<button class="btn btn-default" type="button">Tìm
											Kiếm</button>
									</span>
								</div>
							</div>
						</div>
					</div>
					<div class="clearfix"></div>
					<div class="row">

						<div class="container">
							<html:form action="/admin/user/edit.do" method="post"
								styleClass="form-horizontal">
								<div class="col-md-9 col-md-offset-2">
									<h4>
										Chỉnh sửa thông tin người dùng
										<bean:write name="userForm" property="username"></bean:write>
									</h4>
									<div class="row">
										<div class="form-group">
											<label class="control-label col-md-2">Mã người dùng:</label>
											<div class="col-md-7">
												<html:text property="maNguoiDung" styleId="maNguoiDung"
													readonly="true" styleClass="form-control"></html:text>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="form-group">
											<label class="control-label col-md-2">Tên đăng nhập:</label>
											<div class="col-md-7">
												<html:text property="username" styleId="username"
													readonly="true" styleClass="form-control"></html:text>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="form-group">
											<label class="control-label col-md-2">password:</label>
											<div class="col-md-7">
												<html:text property="password" styleId="password"
													styleClass="form-control"></html:text>
											</div>
										</div>
									</div>

									<div class="row">
										<div class="form-group">
											<%-- <label class="control-label col-md-2">Phân quyền:</label>
											<div class="col-md-7">
												<html:text property="phanQuyen" styleId="phanQuyen"
													styleClass="form-control"></html:text>
											</div> --%>
											<label class="control-label col-md-2">Phân quyền:</label>
											<div class="col-md-7">
									           	<html:select property="phanQuyen" styleId="phanQuyen" styleClass="form-control">
									            <html:optionsCollection name="userForm" property="listPhanQuyen" label="tenPhanQuyen" value="maPhanQuyen"/>
									            </html:select>
									        </div>
										</div>
									</div>

									<div class="row">
										<div class="form-group">
											<label class="control-label col-md-2">Tên người
												dùng:</label>
											<div class="col-md-7">
												<html:text property="tenNguoiDung" styleId="tenNguoiDung"
													styleClass="form-control"></html:text>
											</div>
										</div>
									</div>

									<div class="row">
										<div class="form-group">
											<label class="control-label col-md-2">Số điện thoại:</label>
											<div class="col-md-7">
												<html:text property="soDienThoai" styleId="soDienThoai"
													styleClass="form-control"></html:text>
											</div>
										</div>
									</div>

									<div class="row">
										<div class="form-group">
											<label class="control-label col-md-2">Địa chỉ:</label>
											<div class="col-md-7">
												<html:text property="diaChi" styleId="diaChi"
													styleClass="form-control"></html:text>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="form-group">
											<label class="control-label col-md-2">Email:</label>
											<div class="col-md-7">
												<html:text property="email" styleId="email"
													styleClass="form-control"></html:text>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="form-group">
											<label class="control-label col-md-2">Trạng thái:</label>
											<div class="col-md-7">
												<%-- <html:select property="trangThai" styleId="trangThai" styleClass="form-control">
									            <html:optionsCollection name="userForm" property="listTrangThai" label="tenTrangThai" value="maTrangThai"/>
									            </html:select> --%>
			 		<select class="form-control" name="trangThai">
                    <%
                    	ArrayList<UserTrangThai> listTrangThai = (ArrayList<UserTrangThai>)request.getAttribute("listTrangThai");
                    	boolean trangThaiSelected = (Boolean) request.getAttribute("trangThaiSelected");
                    	for(UserTrangThai userTT:listTrangThai){
                    		if(trangThaiSelected == userTT.isTenTrangThai()){
                    		%>
                    		<option value="<%=userTT.getMaTrangThai()%>" selected="selected"><%=userTT.isTenTrangThai()%></option>
                    		<% 
                    		} else {
                    		%>
                    			<option value="<%=userTT.getMaTrangThai()%>"><%=userTT.isTenTrangThai()%></option>
                    <%
                    		}
                    	}
                    %>
               	 </select>	 
													
											</div>
										</div>
									</div>
									<div class="row">
										<div class="form-group">
											<div class="col-md-5 col-md-offset-2">
												<button class="btn btn-success" type="submit" value="UPDATE"
													name="submit">Cập nhật</button>
											</div>
										</div>
									</div>


								</div>



							</html:form>
						</div>


						<script>
							$(function() {
								$("#maNguoiDung").attr("placeholder",
										"Mã Người Dùng");
								$("#username").attr("placeholder", "User Name");
								$("#password").attr("placeholder", "Password");
								$("#phanQuyen").attr("placeholder",
										"Phân Quyền");
								$("#tenNguoiDung").attr("placeholder",
										"Tên Người Dùng");
								$("#soDienThoai").attr("placeholder", "Phone");
								$("#diaChi").attr("placeholder", "Địa Chỉ");
								$("#email").attr("placeholder", "Email");
								$("#trangThai").attr("placeholder",
										"Trạng Thái");
							});
						</script>

					</div>
				</div>
			</div>
			<!-- /page content -->

			<!-- footer content -->
			<%@ include file="/pages/partion/NewFooter.jsp"%>
			<!-- /footer content -->
		</div>
	</div>

	<!-- jQuery -->
	<script
		src="${pageContext.request.contextPath}/public/src/vendors/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script
		src="${pageContext.request.contextPath}/public/src/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- morris.js -->
	<script
		src="${pageContext.request.contextPath}/public/src/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>

	<!-- Custom Theme Scripts -->
	<script
		src="${pageContext.request.contextPath}/public/src/build/js/custom.min.js"></script>

</body>
</html>