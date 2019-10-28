<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Quản Lý người dùng</title>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/public/src/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="${pageContext.request.contextPath}/public/src/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="${pageContext.request.contextPath}/public/src/build/css/custom.min.css" rel="stylesheet">

<link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/style-customize.css" />
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
                <h3>Danh Sách Người Dùng</h3>
              </div>

              <div class="title_right">
                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                  <div class="input-group">
                    <input type="text" class="form-control" placeholder="Từ Khóa">
                    <span class="input-group-btn">
                      <button class="btn btn-default" type="button">Tìm Kiếm</button>
                    </span>
                  </div>
                </div>
              </div>
            </div>
             <div class="clearfix"></div>
              <div class="row">
              
              <div class="container">
		<div class="col-md-12 " >
				<table id="table">
					<tr>
						<th>Tên Đăng Nhập</th>
						<th>Tên Người Dùng</th>
						<th>Phân Quyền</th>
						<th>SDT</th>
						<th>Địa Chỉ</th>
						<th>Email</th>
						<th>Tùy Chọn</th>
					</tr>
					<logic:iterate name="listUserForm" property="listUser"
					id="user">
					<tr>
						<td scope="row"><bean:write name="user" property="username" /></td>
						<td><bean:write name="user" property="tenNguoiDung"/></td>
						
						<bean:define id="phanQuyen" name="user" property="phanQuyen"></bean:define>
						<logic:equal value="0" name = "phanQuyen">
							<td class="td-admin">Admin</td>
						</logic:equal>
						<logic:equal value="1" name = "phanQuyen">
							<td>Nha Xe</td>
						</logic:equal>
						<logic:equal value="2" name = "phanQuyen">
							<td>Người dùng</td>
						</logic:equal>
						
						<td style="text-align:right"><bean:write name="user" property="soDienThoai"/></td>
						<td><bean:write name="user" property="diaChi"/></td>
						<td><bean:write name="user" property="email"/></td>
						
						<bean:define id="MaNguoiDung" name="user" property="maNguoiDung"></bean:define>
						<td>
							<html:link action="/admin/user/edit.do?id=${MaNguoiDung}">
								<span class="glyphicon glyphicon-edit"></span>
							</html:link> 
						
						<a  href="#" onclick="return deleteUser(${MaNguoiDung})" style="margin-left: 30px;">
								<span class="glyphicon glyphicon-trash"></span>
							</a>
						</td>
					</tr>
					</logic:iterate>
				</table>
				<br>
				<div align="center">
				<ul class="pagination" id="pagniationUL">
				
			  	</ul>
		</div>
		</div>
	</div>
	<html:hidden property="paginationNumber" name="listUserForm" styleId="paginationNumber"/>
	<html:hidden property="currentPageIndex" name="listUserForm" styleId="currentPageIndex"/>
	<script>
		$(document).ready(function(){
			var pagniationNum = $("#paginationNumber").val();
			var currentPageIndex = $("#currentPageIndex").val();
			for(var i=1;i<=pagniationNum;i++){
				if(currentPageIndex==i){
					$("#pagniationUL").append('<li class="active"><a href="${pageContext.request.contextPath}/admin/listUser.do?page='+i+'">'+i+'</a></li>');
				}else{ 
					$("#pagniationUL").append('<li><a href="${pageContext.request.contextPath}/admin/listUser.do?page='+i+'">'+i+'</a></li>');
				}
			}
		});
		function deleteUser(id) {
			if(confirm("Bạn có muốn xóa người dùng này không ?"))
			{
				window.location.replace("${pageContext.request.contextPath}/admin/user/delete.do?id="+id);
			}
		}
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
    <script src="${pageContext.request.contextPath}/public/src/vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="${pageContext.request.contextPath}/public/src/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- morris.js -->
    <script src="${pageContext.request.contextPath}/public/src/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
    
    <!-- Custom Theme Scripts -->
    <script src="${pageContext.request.contextPath}/public/src/build/js/custom.min.js"></script>

  </body>
</html>