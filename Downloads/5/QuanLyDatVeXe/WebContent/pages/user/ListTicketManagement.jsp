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

<title>Danh Sách Vé Xe</title>

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
			<%@ include file="/pages/partion/NewSideBarUser.jsp"%>
			<!-- Headers-->
			<%@ include file="/pages/partion/NewHeaderAdmin.jsp"%>
			<!-- /End Headers -->

			<!-- page content -->
			<div class="right_col" role="main">
				<div class="">
					<div class="page-title">
						<div class="title_left">
							<h3>Danh Sách Vé Xe</h3>
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
						<div class="container">
							<div>

								<input type="hidden" class="form-control" name="maXe" readonly
									id="maXe" />
								<html:form action="user/filterTicket" method="POST">
									<div class="form-group">
										<label class="control-label col-md-3">Tên Xe:</label>
										<div class="col-md-9">
											<!--  <select class="form-control" id="selectTenXe" name = "tenXe"
															onchange="changeBus(this)">

														</select>-->
											<input type="text" class="form-control" name="tenXe"
												style="width: 50%" required />
										</div>
										<div class="form-group">
											<label class="control-label col-md-3" for="pwd">Ngày
												đi <span style="display: inline; color: red"></span>:
											</label>
											<div class="col-md-9" style="padding-top: 5px">
												<input type="date" class="form-control" name="ngatXuatPhat"
													id="ngayXuatPhat" style="width: 50%;" required>
											</div>
										</div>
									</div>
									<div class="col-md-8"
										style="margin-top: 10px; margin-left: 280px;">
										<input type="submit" name="submit" value="submit"
											class="btn btn-primary" type="button" />
									</div>
								</html:form>
								<br />
								<table class="table" id="table">
									<thead>
										<tr>
											<th>Tên KH</th>
											<th>SDT</th>
											<th>Email</th>
											<th>Điểm đi</th>
											<th>Điểm đến</th>
											<th>Xe</th>
											<th>Giá Vé</th>
											<th>Ngày đi</th>
											<th>Giờ đi</th>
											<th>Xóa</th>
										</tr>
									</thead>
									<tbody>

										<logic:iterate name="listTicketForm" property="listTicket"
											id="ticket">
											<bean:define id="user" name="ticket" property="user"></bean:define>
											<bean:define id="buses" name="ticket" property="buses"></bean:define>
											<bean:define id="bus" name="ticket" property="bus"></bean:define>
											<bean:define id="maVe" name="ticket" property="maVe"></bean:define>
											<tr>
												<td><bean:write name="user" property="tenNguoiDung" /></td>
												<td style="text-align: right"><bean:write name="user"
														property="soDienThoai" /></td>
												<td><bean:write name="user" property="email" /></td>
												<td><bean:write name="buses" property="diemDi" /></td>
												<td><bean:write name="buses" property="diemDen" /></td>
												<td><bean:write name="bus" property="tenXe" /></td>
												<bean:define id="giaVe" name="buses" property="giaVe"></bean:define>
												<%
													DecimalFormat df = new DecimalFormat("#");
														df.setMaximumFractionDigits(2);
														String gia1 = df.format(giaVe);
														String gia = "";
														int dem = 1;
														for (int i = gia1.length() - 1; i >= 0; i--) {
															gia = gia1.charAt(i) + gia;
															if (dem % 3 == 0 && dem != gia1.length())
																gia = "," + gia;
															dem++;
														}
												%>
												<td style="text-align: right"><%=gia%></td>
												<bean:define id="nxp" name="ticket" property="buses"></bean:define>
												<td style="text-align: right"><bean:write name="nxp"
														property="ngayXuatPhat" /></td>
												<td style="text-align: right"><bean:write name="buses"
														property="gioXuatPhat" /></td>
												<td><a onclick="return delele(${maVe})" href="#"
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

							<html:hidden property="paginationNumber" name="listTicketForm"
								styleId="paginationNumber" />
							<html:hidden property="currentPageIndex" name="listTicketForm"
								styleId="currentPageIndex" />

							<script>
          
           $(document).ready(function(){        
   			var pagniationNum = $("#paginationNumber").val();
   			var currentPageIndex = $("#currentPageIndex").val();
   			for(var i=1;i<=pagniationNum;i++){
   				if(currentPageIndex==i){
   					$("#pagniationUL").append('<li class="active"><a href="${pageContext.request.contextPath}/user/listTicket.do?page='+i+'">'+i+'</a></li>');
   				}else{ 
   					$("#pagniationUL").append('<li><a href="${pageContext.request.contextPath}/user/listTicket.do?page='+i+'">'+i+'</a></li>');
   				}
   			}
   		});
   		function delele(id) {
   			if(confirm("Bạn có muốn xóa Xe này không ?"))
   			{
   				window.location.replace("${pageContext.request.contextPath}/user/ticket/delete.do?id="+id);
   			}
   		}
		function initSelect(listBusJson)
		{
			
			for(var i=0;i<glbj.length;i++){
				
				$("#selectTenXe").append('<option  value="'+glbj[i].maXe+'">'+glbj[i].tenXe+'</option>');
				if(i==0){
					document.getElementById("bienSo").value = glbj[i].bienSo;
					document.getElementById("maXe").value = glbj[i].maXe;
				}
			}
		}
		function changeBus(t)
		{
			glbj.forEach(e=>{
			
				if(e.maXe==t.value)
				{
					document.getElementById("bienSo").value = e.bienSo;
					document.getElementById("maXe").value = e.maXe;
				}
			});
			
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