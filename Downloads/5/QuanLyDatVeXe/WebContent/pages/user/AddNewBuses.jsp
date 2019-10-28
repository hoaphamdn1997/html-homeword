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

<title>Thêm mới chuyến xe</title>

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
	href="${pageContext.request.contextPath}/public/css/timepicker.min.css">
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
							<h3>Thêm mới chuyến xe</h3>
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
								<div class="col-md-8" style="margin-left: -40px;">
									<h4>Thêm Mới Chuyến Xe</h4>
									<div role="tabpanel" data-example-id="togglable-tabs">
										<ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist">
											<li role="presentation" class="active"><a
												href="#tab_content1" id="home-tab" role="tab"
												data-toggle="tab" aria-expanded="true">Thêm mới Chuyến</a></li>
											<li role="presentation" class=""><a href="#tab_content2"
												role="tab" id="profile-tab" data-toggle="tab"
												aria-expanded="false">Tạo chuyến từ lộ trình có sẵn</a></li>
										</ul>
									</div>

									<div class="tab-content" id="myTabContent">
										<div role="tabpanel" class="tab-pane fade active in"
											id="tab_content1" aria-labelledby="home-tab">
											<html:form styleClass="form-horizontal"
												action="user/addNewBuses" onsubmit="processRepeatData()"
												style="margin-top: 20px;" styleId="formAdd">
												<div class="form-group">
													<label class="control-label col-md-3" for="pwd">Điểm
														đi: </label>
													<div class="col-md-3">
														<select name="maTinhXuatPhat" class=" form-control"
															style="width: 180px;"
															onchange="changeValueSelectHuyen('selectHuyenDi',this)">
															<logic:iterate name="busesForm" property="listProvince"
																id="province">
																<bean:define id="maTinh" name="province"
																	property="maTinh"></bean:define>
																<option value="${maTinh}"><bean:write
																		name="province" property="tenTinh" /></option>
															</logic:iterate>
														</select>
													</div>
													<label class="control-label col-md-1" for="pwd"></label>
													<div class="col-md-3 ">
														<select class="form-control select" name="maHuyenXuatPhat"
															id="selectHuyenDi" style="width: 180px;">

														</select>
													</div>

												</div>
												<div class="form-group">
													<label class="control-label col-md-3" for="pwd">Điểm
														đến: </label>
													<div class="col-md-3">
														<select name="maTinhDen" class=" form-control"
															style="width: 180px;"
															onchange="changeValueSelectHuyen('selectHuyenDen',this)">
															<logic:iterate name="busesForm" property="listProvince"
																id="province">
																<bean:define id="maTinh" name="province"
																	property="maTinh"></bean:define>
																<option value="${maTinh}"><bean:write
																		name="province" property="tenTinh" /></option>
															</logic:iterate>
														</select>
													</div>
													<label class="control-label col-md-1" for="pwd"></label>
													<div class="col-md-3">
														<select class="form-control" name="maHuyenDen"
															id="selectHuyenDen" style="width: 180px;">

														</select>
													</div>
												</div>
												<input type="hidden" class="form-control" name="maXe"
													readonly id="maXe" />
												<div class="form-group">
													<label class="control-label col-md-3">Tên Xe:</label>
													<div class="col-md-9">
														<select class="form-control" id="selectTenXe"
															onchange="changeBus(this)">

														</select>
													</div>
												</div>

												<div class="form-group">
													<label class="control-label col-md-3" for="pwd">Biển
														Số:</label>
													<div class="col-md-9">
														<input type="text" class="form-control" name="bienSo"
															readonly id="bienSo" />
													</div>
												</div>
												<div class="form-group">
													<label class="control-label col-md-3" for="pwd">Giờ
														xuất phát <span style="display: inline; color: red">(*)</span>:
													</label>
													<div class="col-md-9">
														<input type="text" class="form-control" name="gioXuatPhat"
															id="gioXuatPhat" required>
													</div>
												</div>

												<div class="form-group">
													<label class="control-label col-md-3" for="pwd">thời
														gian di chuyển <span style="display: inline; color: red">(*)</span>:
													</label>
													<div class="col-md-9">
														<input type="number" class="form-control"
															name="thoiGianDiChuyen" id="thoiGianDiChuyen" required>
													</div>
												</div>
												<div class="form-group">
													<label class="control-label col-md-3" for="pwd">Giá
														vé <span style="display: inline; color: red">(*)</span>:
													</label>
													<div class="col-md-9">
														<input type="number" class="form-control" name="giaVe"
															id="giaVe" required>
													</div>
												</div>
												<div class="form-group">
													<label class="control-label col-md-3" for="pwd">Ngày
														bắt đầu <span style="display: inline; color: red">(*)</span>:
													</label>
													<div class="col-md-9">
														<input type="date" class="form-control"
															name="ngayXuatPhat" id="ngayXuatPhat" required>
													</div>
												</div>
												<div class="form-group">
													<label class="control-label col-md-3" for="pwd">Ngày
														kết thúc <span style="display: inline; color: red">(*)</span>:
													</label>
													<div class="col-md-9">
														<input type="date" class="form-control" name="ngayKetThuc"
															id="ngayKetThuc" required>
													</div>
												</div>
												<div class="form-group">
													<label class="control-label col-md-3" for="pwd">Lặp
														lại:</label>
													<div class="col-md-9">
														<label class="checkbox-inline"><input
															type="checkbox" name="lapLai" value="1">Thứ 2</label> <label
															class="checkbox-inline"><input type="checkbox"
															name="lapLai" value="2">Thứ 3</label> <label
															class="checkbox-inline"><input type="checkbox"
															name="lapLai" value="3">Thứ 4</label> <label
															class="checkbox-inline"><input type="checkbox"
															name="lapLai" value="4">Thứ 5</label> <label
															class="checkbox-inline"><input type="checkbox"
															name="lapLai" value="5">Thứ 6</label> <label
															class="checkbox-inline"><input type="checkbox"
															name="lapLai" value="6">Thứ 7</label> <label
															class="checkbox-inline"><input type="checkbox"
															name="lapLai" value="0">CN</label>
													</div>
												</div>
												<html:hidden property="listRepeatJson"
													styleId="listRepeatJson" />
												<div class="form-group">
													<div class="col-md-offset-3 col-md-9">
														<button type="submit" name="submit" value="submit1"
															class="btn btn-success">Thêm Mới</button>

													</div>
												</div>
											</html:form>
										</div>
										<div role="tabpanel" class="tab-pane fade" id="tab_content2"
											aria-labelledby="profile-tab">
											<html:form styleClass="form-horizontal"
												action="user/addNewBuses" style="margin-top: 20px;"
												onsubmit="processRepeatData1()">

												<div class="form-group">
													<label class="control-label col-md-3" for="pwd">Lộ
														trình</label>
													<div class="col-md-9">
														<select name="maChang" class=" form-control"
															id="selectTrip" style="width: 410px;"
															onchange="changeTrip(this)">
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
														xuất phát <span style="display: inline; color: red">(*)</span>:
													</label>
													<div class="col-md-9">
														<input type="text" class="form-control" name="gioXuatPhat"
															id="gioXuatPhat1" required>
													</div>
												</div>
												<div class="form-group">
													<label class="control-label col-md-3" for="pwd">Giá
														vé <span style="display: inline; color: red">(*)</span>:
													</label>
													<div class="col-md-9">
														<input type="number" class="form-control" name="giaVe"
															id="giaVe1" required>
													</div>
												</div>
												<div class="form-group">
													<label class="control-label col-md-3" for="pwd">Ngày
														bắt đầu <span style="display: inline; color: red">(*)</span>:
													</label>
													<div class="col-md-9">
														<input type="date" class="form-control"
															name="ngayXuatPhat" id="ngayXuatPhat" required>
													</div>
												</div>
												<div class="form-group">
													<label class="control-label col-md-3" for="pwd">Ngày
														kết thúc <span style="display: inline; color: red">(*)</span>:
													</label>
													<div class="col-md-9">
														<input type="date" class="form-control" name="ngayKetThuc"
															id="ngayKetThuc" required>
													</div>
												</div>
												<div class="form-group">
													<label class="control-label col-md-3" for="pwd">Lặp
														lại:</label>
													<div class="col-md-9">
														<label class="checkbox-inline"><input
															type="checkbox" name="lapLai1" value="1">Thứ 2</label> <label
															class="checkbox-inline"><input type="checkbox"
															name="lapLai1" value="2">Thứ 3</label> <label
															class="checkbox-inline"><input type="checkbox"
															name="lapLai1
										value="3">Thứ 4</label> <label
															class="checkbox-inline"><input type="checkbox"
															name="lapLai1" value="4">Thứ 5</label> <label
															class="checkbox-inline"><input type="checkbox"
															name="lapLai1" value="5">Thứ 6</label> <label
															class="checkbox-inline"><input type="checkbox"
															name="lapLai1" value="6">Thứ 7</label> <label
															class="checkbox-inline"><input type="checkbox"
															name="lapLai1" value="0">CN</label>
													</div>
												</div>
												<html:hidden property="listRepeatJson"
													styleId="listRepeatJson1" />
												<div class="form-group">
													<div class="col-md-offset-3 col-md-9">
														<button type="submit" name="submit" value="submit2"
															class="btn btn-success">Thêm Mới</button>
													</div>
												</div>
											</html:form>
										</div>
									</div>

								</div>

							</div>
						</div>
						<html:hidden name="busesForm" property="listBusJson"
							styleId="listBusJson" />
						<html:hidden name="busesForm" property="listTripJson"
							styleId="listTripJson" />
						<script>
		var glbj;
		$(document).ready(function(){
			var listBusJson = JSON.parse(document.getElementById("listBusJson").value);
			glbj = listBusJson;
			initSelect(listBusJson);
			initSelecthuyen('01TTT');
			
				var timepicker = new TimePicker('gioXuatPhat', {
					  lang: 'en',
					  theme: 'dark'
				});
				timepicker.on('change', function(evt) {
					console.info(evt);
					var value = (evt.hour || '00') + ':' + (evt.minute || '00');
					evt.element.value = value;
		
				});
			
				var timepicker1 = new TimePicker('gioXuatPhat1', {
					lang: 'en',
					theme: 'dark'
				});
				timepicker1.on('change', function(evt1) {
					console.info(evt1);
					var value1 = (evt1.hour || '00') + ':' + (evt1.minute || '00');
					evt1.element.value = value;
			
				});
				
		});
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
		function initSelecthuyen(id)
		{
			$.get("${pageContext.request.contextPath}/api/getDistrictByProvince.do?id="+id, function(data, status){
			   data.forEach(e=>{
				   $("#selectHuyenDi").append('<option value="'+e.maHuyen+'">'+e.tenHuyen+'</option>');
				   $("#selectHuyenDen").append('<option value="'+e.maHuyen+'">'+e.tenHuyen+'</option>');
			   });
		    });
			var jsonTrip = JSON.parse(document.getElementById("listTripJson").value);
			for(var i=0;i<jsonTrip.length;i++){
				$("#selectTrip").append('<option value="'+jsonTrip[i].maChang+'">'+jsonTrip[i].tenDiaDiemDi+'&nbsp&nbsp->&nbsp&nbsp'+jsonTrip[i].tenDiaDiemDen+'</option>')
				if(i==0){
					document.getElementById("bienSo1").value=jsonTrip[i].bienSo;
					document.getElementById("tenXe1").value=jsonTrip[i].tenXe;
				}
			}
		}
		function changeValueSelectHuyen(type,id)
		{
			$("#"+type).empty();
			$.get("${pageContext.request.contextPath}/api/getDistrictByProvince.do?id="+id.value, function(data, status){
				   data.forEach(e=>{
					   $("#"+type).append('<option value="'+e.maHuyen+'">'+e.tenHuyen+' </option>');
				   });
			    });
		}
		function changeTrip(t)
		{
			var jsonTrip = JSON.parse(document.getElementById("listTripJson").value);
			for(var i=0;i<jsonTrip.length;i++){
				console.log(t.value);
				if(jsonTrip[i].maChang==t.value)
				{
					document.getElementById("bienSo1").value=jsonTrip[i].bienSo;
					document.getElementById("tenXe1").value=jsonTrip[i].tenXe;
					
				}
			}
		}
		function processRepeatData()
		{
			var arr=[];
			var c = document.getElementsByName("lapLai");
			var ts="{";
			c.forEach(e=>{
				 ts+= '"'+e.value.toString()+'":"'+e.checked+'",';
				//var tjson = JSON.parse(ts);
				//arr.push(tjson);
			})
			ts=ts.substring(0,ts.length-1);
			ts+="}"
			document.getElementById("listRepeatJson").value = ts;//JSON.stringify(arr);
		}
		function processRepeatData1()
		{
			var arr=[];
			var c = document.getElementsByName("lapLai1");
			var ts="{";
			c.forEach(e=>{
				 ts+= '"'+e.value.toString()+'":"'+e.checked+'",';
				//var tjson = JSON.parse(ts);
				//arr.push(tjson);
			})
			ts=ts.substring(0,ts.length-1);
			ts+="}"
			document.getElementById("listRepeatJson1").value = ts;//JSON.stringify(arr);
		}
		function checkHours(hours){
			return (/\d{1,2}:\d{2}$/.test(hours)) &&parseInt(hours.split(':')[0])>=0 && parseInt(hours.split(':')[0])<24 && parseInt(hours.split(':')[1]) >=0 && parseInt(hours.split(':')[1]) < 60;
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