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
              
              
	<div class="container" >
		<div class="col-md-12 ">
			<div align="right" class="col-md-2 col-md-offset-10"
				style="margin-bottom: 20px;">

				<a class="btn btn-success"
					href="${pageContext.request.contextPath}/admin/addNewBusType.do">Tạo
					Mới Loại Xe</a>
			</div>
			<br />
			<table id="table">
				<tr>
					<th>Mã Loại Xe</th>
					<th>Tên Loại Xe</th>
					<th>Số tầng</th>
					<th>Số ghế</th>
					<th>Mô Tả</th>
					<th>Tùy Chọn</th>
				</tr>


				<logic:iterate name="listBusTypeForm" property="listBusType"
					id="bustype">
					<tr>
						<bean:define id="maLoaiXe" name="bustype" property="maLoaiXe"></bean:define>
						<td scope="row" style="text-align:right">${maLoaiXe}</td>
						<td><bean:write name="bustype" property="tenLoaiXe" /></td>
						<bean:define id="soTang" name="bustype" property="soTang"></bean:define>
						<td style="text-align:right">${soTang}</td>
						<bean:define id="soGhe" name="bustype" property="soGhe"></bean:define>
						<td style="text-align:right">${soGhe}</td>
						<td><bean:write name="bustype" property="moTa" /></td>
						<td><html:link action="/admin/editBusType?id=${maLoaiXe}">
								<span class="glyphicon glyphicon-edit"></span>
							</html:link> 
							<html:link action="/admin/deleteBusType?id=${maLoaiXe}"
								style="margin-left: 30px;">
								<span class="glyphicon glyphicon-trash"></span>
							</html:link>
							<%-- <a  href="#" onclick="return deleteComputer(${maLoaiXe})" style="margin-left: 30px;">
								<span class="glyphicon glyphicon-trash"></span>
							</a> --%>
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
	<html:hidden property="paginationNumber" name="listBusTypeForm" styleId="paginationNumber"/>
	<html:hidden property="currentPageIndex" name="listBusTypeForm" styleId="currentPageIndex"/>
	<script>
		$(document).ready(function(){
			var pagniationNum = $("#paginationNumber").val();
			var currentPageIndex = $("#currentPageIndex").val();
			for(var i=1;i<=pagniationNum;i++){
				if(currentPageIndex==i){
					$("#pagniationUL").append('<li class="active"><a href="${pageContext.request.contextPath}/admin/listBusType.do?page='+i+'">'+i+'</a></li>');
				}else{ 
					$("#pagniationUL").append('<li><a href="${pageContext.request.contextPath}/admin/listBusType.do?page='+i+'">'+i+'</a></li>');
				}
			}
		});
		function deleteComputer(id) {
			if(confirm("Bạn có muốn xóa loại xe này không ?"))
			{
				window.location.replace("${pageContext.request.contextPath}/admin/user/delete-computer?id="+id);
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