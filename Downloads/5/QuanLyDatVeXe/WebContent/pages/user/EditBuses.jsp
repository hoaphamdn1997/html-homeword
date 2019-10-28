<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Chỉnh sửa thông tin Chuyến Xe</title>

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

<script src="${pageContext.request.contextPath}/js/jquery-1.11.2.min.js"></script>
<script src="${pageContext.request.contextPath}/js/timepicker.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/timepicker.min.css">
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
							<h3>Chỉnh sửa thông tin Chuyến Xe</h3>
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
							<div class="row">
								<div class="col-md-2"></div>
								<div class="col-md-7" style="margin-left:10px">
									<html:form styleClass="form-horizontal" action="user/editBuses"
										style="margin-top: 20px;">

										<div class="form-group">
											<label class="control-label col-md-3" for="pwd">Lộ
												trình</label>
											<div class="col-md-9">
												<select name="maChang" class=" form-control" id="selectTrip" readonly="true"
													style="width: 410px;" onchange="changeTrip(this)">
												</select>
											</div>

										</div>
										<div class="form-group">
											<label class="control-label col-md-3">Tên Xe:</label>
											<div class="col-md-9">
												<input type="text" class="form-control" name="tenXe"
													readonly id="tenXe1" />
											</div>
										</div>

										<div class="form-group">
											<label class="control-label col-md-3" for="pwd">Biển
												Số:</label>
											<div class="col-md-9">
												<input type="text" class="form-control" name="bienSo"
													readonly id="bienSo1" />
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3" for="pwd">Giờ
												xuất phát:</label>
											<div class="col-md-9">
												<input type="text" class="form-control" name="gioXuatPhat"
													id="gioXuatPhat1" required>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3" for="pwd">Ngày
												xuất phát:</label>
											<div class="col-md-9">
												<input type="date" class="form-control" name="ngayXuatPhat"
													id="ngayXuatPhat1" required>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3" for="pwd">thời
												gian di chuyển:</label>
											<div class="col-md-9">
												<input type="number" class="form-control"
													name="thoiGianDiChuyen" id="thoiGianDiChuyen1" required>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3" for="pwd">Giá
												vé:</label>
											<div class="col-md-9">
												<input type="number" class="form-control" name="giaVe"
													id="giaVe1" required>
											</div>
										</div>
										<html:hidden property="maChuyenXe" />
										<div class="form-group">
											<div class="col-md-offset-3 col-md-9">
												<button type="submit" name="submit" value="submit"
													class="btn btn-success">Sửa</button>
											</div>
										</div>
									</html:form>
								</div>
							</div>

						</div>


						<html:hidden name="busesForm" property="listBusJson"
							styleId="listBusJson" />
						<html:hidden name="busesForm" property="listTripJson"
							styleId="listTripJson" />
						<html:hidden name="busesForm" property="maChang"
							styleId="maChangHidden" />
						<html:hidden name="busesForm" property="gioXuatPhat"
							styleId="gioXuatPhatHidden" />
						<html:hidden name="busesForm" property="ngayXuatPhat"
							styleId="ngayXuatPhatHidden" />
						<html:hidden name="busesForm" property="giaVe"
							styleId="giaVeHidden" />
						<html:hidden name="busesForm" property="thoiGianDiChuyen"
							styleId="thoiGianDiChuyenHidden" />

						<script>
							var glbj;
							$(document)
									.ready(
											function() {
												var listBusJson = JSON
														.parse(document
																.getElementById("listBusJson").value);
												glbj = listBusJson;

												initSelecthuyen(document
														.getElementById("maChangHidden").value);
												document
														.getElementById("gioXuatPhat1").value = document
														.getElementById("gioXuatPhatHidden").value;
												document
														.getElementById("ngayXuatPhat1").value = document
														.getElementById("ngayXuatPhatHidden").value;
												document
														.getElementById("giaVe1").value = document
														.getElementById("giaVeHidden").value;
												document.getElementById("thoiGianDiChuyen1").value = document.getElementById("thoiGianDiChuyenHidden").value;
												var timepicker = new TimePicker(
														'gioXuatPhat1', {
															lang : 'en',
															theme : 'dark'
														});
												timepicker
														.on(
																'change',
																function(evt) {
																	console
																			.info(evt);
																	var value = (evt.hour || '00')
																			+ ':'
																			+ (evt.minute || '00');
																	evt.element.value = value;

																});
											});

							function initSelecthuyen(id) {
								var jsonTrip = JSON.parse(document
										.getElementById("listTripJson").value);
								for (var i = 0; i < jsonTrip.length; i++) {
									if (jsonTrip[i].maChang == id) {
										$("#selectTrip")
												.append(
														'<option selected value="'+jsonTrip[i].maChang+'">'
																+ jsonTrip[i].tenDiaDiemDi
																+ '&nbsp&nbsp->&nbsp&nbsp'
																+ jsonTrip[i].tenDiaDiemDen
																+ '</option>')
										document.getElementById("bienSo1").value = jsonTrip[i].bienSo;
										document.getElementById("tenXe1").value = jsonTrip[i].tenXe;
									} else {
										$("#selectTrip")
												.append(
														'<option  value="'+jsonTrip[i].maChang+'">'
																+ jsonTrip[i].tenDiaDiemDi
																+ '&nbsp&nbsp->&nbsp&nbsp'
																+ jsonTrip[i].tenDiaDiemDen
																+ '</option>')

									}
								}
							}
							function changeTrip(t) {
								var jsonTrip = JSON.parse(document
										.getElementById("listTripJson").value);
								for (var i = 0; i < jsonTrip.length; i++) {
									console.log(t.value);
									if (jsonTrip[i].maChang == t.value) {
										document.getElementById("bienSo1").value = jsonTrip[i].bienSo;
										document.getElementById("tenXe1").value = jsonTrip[i].tenXe;

									}
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