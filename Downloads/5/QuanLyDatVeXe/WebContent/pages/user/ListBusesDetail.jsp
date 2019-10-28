<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@page import="java.text.DecimalFormat"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Quản lý chuyến xe</title>

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
	href="${pageContext.request.contextPath}/css/style-customize.css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.11.2.min.js"></script>

</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!--Side bar-->
			<%@ include file="/pages/partion/NewSideBarUser.jsp"%>
			<!-- Headers-->
			<%@ include file="/pages/partion/NewHeaderAdmin.jsp"%>
			<!-- /End Headers -->

			<!-- page content -->
			<div class="right_col" role="main">
				<div class="">
					<div class="page-title">
						<div class="title_left">
							<h3>Danh Sách chuyến xe</h3>
						</div>

						<div class="title_right">
							<div
								class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
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
	<div class="container" >
		<div align="right" class="col-md-2 col-md-offset-10"
			style="margin-bottom: 10px;">
			<a class="btn btn-success"
				href="${pageContext.request.contextPath}/user/addNewBuses.do">Tạo
				Mới Chuyến Xe</a>
		</div>
		<br />
		<table class="table" id="table">
			<thead>
				<tr>
					<th>Mã Xe</th>
					<th>Điểm Xuất phát</th>
					<th>Điểm đến</th>
					<th>Giờ xuất phát</th>
					<th>Giờ tới nơi</th>
					<th>Ngày xuất phát</th>
					<th>Giá vé</th>
					<th>Tùy Chọn</th>

				</tr>
			</thead>
			<tbody>

				<logic:iterate name="listBusesForm" property="listBuses" id="buses">
					<tr>
						<bean:define id="maXe" name="buses" property="maXe"></bean:define>
						<td style="text-align:right">${maXe}</td>
						<td><bean:write name="buses" property="diemDi" /></td>
						<td><bean:write name="buses" property="diemDen" /></td>
						<td style="text-align:right"><bean:write name="buses" property="gioXuatPhat" /></td>
						<td style="text-align:right"><bean:write name="buses" property="gioToiNoi" /></td>
						<td style="text-align:right"><bean:write name="buses" property="ngayXuatPhat" /></td>
						<bean:define id="giaVe" name="buses" property="giaVe"></bean:define>
						<%
												DecimalFormat df = new DecimalFormat("#");
										    	df.setMaximumFractionDigits(2);
										    	String gia1 = df.format(giaVe);
										    	String gia="";
										    	int dem=1;
										    	for(int i=gia1.length()-1;i>=0;i--)
										    	{
										    		gia=gia1.charAt(i)+gia;
										    		if(dem%3==0&&dem!=gia1.length())gia=","+gia;
										    		dem++;
										    	}
										    	
											%>
						<td style="text-align:right"><%=gia %></td>
						<bean:define id="maChuyenXe" name="buses" property="maChuyenXe"></bean:define>
						<td><html:link action="/user/editBusesDetail?id=${maChuyenXe}">
								<span class="glyphicon glyphicon-edit"></span>
							</html:link> <a onclick="return delele(${maChuyenXe})" href="#"
							style="margin-left: 30px;"> <span
								class="glyphicon glyphicon-trash"></span>
						</a></td>
					</tr>
				</logic:iterate>

			</tbody>
		</table>
		<div align="center">
				<ul class="pagination" id="pagniationUL">
				
			  	</ul>
			</div>
	</div>
	<html:hidden property="paginationNumber" name="listBusesForm"
		styleId="paginationNumber" />
	<html:hidden property="currentPageIndex" name="listBusesForm"
		styleId="currentPageIndex" />
	<script>
           $(document).ready(function(){
   			var pagniationNum = $("#paginationNumber").val();
   			var currentPageIndex = $("#currentPageIndex").val();
   			for(var i=1;i<=pagniationNum;i++){
   				if(currentPageIndex==i){
   					$("#pagniationUL").append('<li class="active"><a href="${pageContext.request.contextPath}/user/listBusesDetail.do?page='+i+'&maXe='+<%=(String)request.getAttribute("mx")%>+'&maChang='+<%=(String)request.getAttribute("mc")%>+'">'+i+'</a></li>');
   				}else{ 
   					$("#pagniationUL").append('<li><a href="${pageContext.request.contextPath}/user/listBusesDetail.do?page='+i+'&maXe='+<%=(String)request.getAttribute("mx")%>+'&maChang='+<%=(String)request.getAttribute("mc")%>+'">'+i+'</a></li>');
   				}
   			}
   		});
   		function delele(id) {
   			if(confirm("Bạn có muốn xóa Chuyen Xe này không ?"))
   			{
   				window.location.replace("${pageContext.request.contextPath}/user/deleteBusesDetail.do?id="+id);
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