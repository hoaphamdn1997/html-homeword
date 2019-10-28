<%@page import="common.StringProcess"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trang chủ</title>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/public/css/styles.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<body>
	<%@ include file="/pages/partion/HeaderCustomer.jsp"%>

	<div class="home-page" id="main">
		<div class="container home-search-ticket-panel">
			<div class="row">
				<div class="col-md-8">
					<div>
						<h1>hireabus.com Hệ thống bán lẻ vé xe khách đường dài Tại TP Đà Nẵng</h1>
						<div class="g-plusone"
							data-href="https://plus.google.com/b/114193555551619053500/+VexereVN/posts?gmbpt=true&amp;hl=en"></div>

						<form id="searchForm" method="post"
							action="${pageContext.request.contextPath}/searchTicket.do">
							<fieldset class="row">
								<input id="search-busoperator-id" type="hidden" value="">
								<input id="search-busoperator-name" type="hidden" value="">
								<div
									class="location-select-row form-inline col-xs-12 col-sm-12 col-md-12">
									<div class="form-group searchLeft col-md-6">
										<span class="ui-helper-hidden-accessible" role="status"
											aria-live="polite"></span> <span
											class="ui-helper-hidden-accessible" role="status"
											aria-live="polite"></span> <span
											class="ui-helper-hidden-accessible" role="status"
											aria-live="polite"></span>
										<div class="autocomplete" style="width: 300px;">
											<input placeholder="Gõ vào nơi đi"
												class="input-txt place ui-autocomplete-input"
												id="departPlace" type="text" name="noiDi" required />
										</div>

										<div class="autocomplete" style="visibility: hidden;">
											<input name="departPlace" tabindex="1"
												class="input-txt place ui-autocomplete-input"
												id="departPlace" accesskey="1" onmouseup="return false;"
												type="text" placeholder="Gõ vào nơi đi" autocomplete="off">
										</div>
										<!-- If need to validate when error then add class "error"-->
										<input id="start-point-type" type="hidden"> <input
											id="start-point-id" type="hidden">
									</div>
									<div class="form-group searchRight col-md-6">
										<span class="ui-helper-hidden-accessible" role="status"
											aria-live="polite"></span> <span
											class="ui-helper-hidden-accessible" role="status"
											aria-live="polite"></span> <span
											class="ui-helper-hidden-accessible" role="status"
											aria-live="polite"></span><input name="noiDen" tabindex="2"
											class="input-txt place ui-autocomplete-input"
											id="destination" accesskey="2" onmouseup="return false;"
											type="text" placeholder="Gõ vào nơi đến" autocomplete="off"
											required />
										<!-- On focus show block below, temporarily used js to show/hide, need to implement this as current site-->
										<!-- Hidden -->
										<input id="stop-point-type" type="hidden"> <input
											id="stop-point-id" type="hidden">
									</div>
									<div
										class="form-group switchButton-container hidden-xs hidden-sm">

										<a class="switchButton bold" href="#"> <img
											class="switch-icon"
											src="${pageContext.request.contextPath}/public/images/Home/icon-arrow-2-way.svg">
										</a>
									</div>
									<a
										class="btn-switch-route btn-switch-route2 visible-xs visible-sm"
										href="#"> <img
										src="${pageContext.request.contextPath}/public/images/Home/switch mobile-01.svg@v=1">
									</a>
								</div>
								<div class="date-select-row col-md-12 col-xs-12 form-inline">
									<div class="form-group col-md-6 pl0 select-date-container">
										<div class="panel-input-date">
											<input name="ngayDi" tabindex="3"
												class="input-txt date hasDatepicker" id="departDate"
												accesskey="3" type="date" placeholder="Chọn ngày đi"
												autocomplete="off"
												style="border: 1px solid #9a9a9a; border-radius: 4px !important; height: 50px; background: transparent; width: 300px; margin: 0; background-color: #fff;"
												required />
										</div>
									</div>
									<div
										class="form-group quick-date-select fr visible-sm visible-xs">
										<button class="fl btn btn-gray btn-today"
											onclick="$('#departDate').val(moment().format('DD-MM-YYYY')); $('#searchSubmit').trigger('click');"
											type="button">Hôm nay</button>
										<button class="fl btn btn-gray btn-tomorrow"
											onclick="$('#departDate').val(moment(moment().add('days', 1)).format('DD-MM-YYYY')); $('#searchSubmit').trigger('click');"
											type="button">Ngày mai</button>
									</div>
								</div>
								<div
									class="form-inline col-md-6 col-md-offset-6 col-xs-12 clearfix search-submit-container">
									<button name="searchSubmit" tabindex="6"
										class="submit-btn search-btn fr uppercase" id="searchSubmit"
										type="submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tìm Vé
										Xe Rẻ</button>
								</div>
								<div class="input-set mg-l-20 fl" style="display: none;">
									<input tabindex="4" class="input-txt date" id="returnDate123"
										accesskey="4" style="opacity: 0;" type="text"
										placeholder="Chọn ngày về">
								</div>
							</fieldset>

							<div class="container mt-3">
								<h2>Thông Tin Giá Vé</h2>
								<br>
								<!-- Nav tabs -->
								<ul class="nav nav-tabs">
									<li class="nav-item" style="color: black"><a
										class="nav-link active" data-toggle="tab" href="#home">Đà
											nẵng</a></li>

								</ul>

								<!-- Tab panes -->
								<div class="tab-content">
									<div id="home" class="container tab-pane active">
										<br>
										<h3>Lưu Ý Giảm giá</h3>
										<p>Giảm gía 10% với 5 vé đã mua xuất trình thông tin với
											nơi giao để được giảm giá.</p>
									</div>

								</div>
						</form>

					</div>
				</div>
				<div class="col-md-4" id="home_right_banner">
					<div class="flexslider slider-304-title visible-md visible-lg">
						<ul class="slides">
						</ul>
					</div>
					<div class="flexslider slider-304-title visible-xs visible-sm">
						<ul class="slides">
						</ul>
					</div>
				</div>
			</div>

		</div>
	</div>



	<br>
	<br>
	<br>
	<div class="skyline hidden-xs hidden-sm">

		<div class="skyline-city"></div>
		<div class="bus-img">
			<img style="opacity: 0.3;"
				src="${pageContext.request.contextPath}/public/images/newlayout/banh-xe.gif">
		</div>
	</div>

	<br>

	<div class="back-links odd-row clearfix hidden-xs hidden-sm"
		id="backLinkDiv">

		<div id="footer">
			<div class="container">
				<div class="row hidden-sm hidden-xs contentfooter">
					<div class="footerHeader"></div>
					<div class="container">
						<div class="col-md-4">
							<h3>Giới thiệu</h3>
							<p>Hệ thống đặt vé trực truyến và cổng thông tin vé xe khách
								lớn nhất Việt Nam với trên 1000 hãng xe. Bạn có thể dễ dàng so
								sánh bảng giá vé, lịch trình, số điện thoại, địa chỉ cũng như
								đánh giá về các hãng xe.</p>
						</div>

						<div class="col-md-4">
							<h3>Địa điểm</h3>
							<iframe
								src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3834.1031399691506!2d108.20760301416976!3d16.06013674394911!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x314219b4239d8e51%3A0x96e408c6b0419760!2zVHLGsOG7nW5nIMSQ4bqhaSBo4buNYyBEdXkgVMOibg!5e0!3m2!1svi!2s!4v1555237614431!5m2!1svi!2s"
								width="350px" height="350px" frameborder="0" style="border: 0"
								allowfullscreen></iframe>
						</div>
						<div class="col-md-4">
							<h3>Liên hệ nhóm đồ án</h3>
							<ul>
								<li style="padding-bottom: 10px">Phạm Phú Hòa</li>
								<li style="padding-bottom: 10px">Tôn Quốc Việt</li>
								<li style="padding-bottom: 10px">Nguyễn hoàng Anh Dũng</li>
								<li style="padding-bottom: 10px">Nguyễn Công Thành</li>
								<li style="padding-bottom: 10px">Hồ Mạnh Cường</li>
								<li style="padding-bottom: 10px">Địa chỉ: 254 Nguyễn Văn
									Linh - Tp Đà Nẵng, Việt Nam
									</p>
							</ul>
							<ul>
								<li>Phone : 123 - 456 - 789</li>
								<li>E-mail : info@comapyn.com</li>
								<li>Fax : 123 - 456 - 789</li>
							</ul>
							<h3>Kết nối với chúng tôi</h3>
							<ul class="sm">
								<li><a href="#"><img
										src="https://www.facebook.com/images/fb_icon_325x325.png"
										class="img-responsive"></a></li>
								<li><a href="#"><img
										src="https://lh3.googleusercontent.com/00APBMVQh3yraN704gKCeM63KzeQ-zHUi5wK6E9TjRQ26McyqYBt-zy__4i8GXDAfeys=w300"
										class="img-responsive"></a></li>
								<li><a href="#"><img
										src="http://playbookathlete.com/wp-content/uploads/2016/10/twitter-logo-4.png"
										class="img-responsive"></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script>
 $(document).ready(function() {
	 var countries=['VietNam'];
	 $.get("${pageContext.request.contextPath}/api/getCountries.do", function(data, status){
		    data.forEach(e=>{
		    	console.log(e.name);
		    	countries.push(e.name);
		    });	
	 });
	 $.get("${pageContext.request.contextPath}/api/getDiadiem.do", function(data, status){
		    data.forEach(e=>{
		    	console.log(e.tenDiaDiem);
		    	countries.push(e.tenDiaDiem);
		    });	
	 });
	 $.get("${pageContext.request.contextPath}/api/getProvince.do", function(data, status){
		    data.forEach(e=>{
		    	console.log(e.name);
		    	countries.push(e.name);
		    });	
	 });
		autocomplete(document.getElementById("departPlace"), countries);
		autocomplete(document.getElementById("destination"), countries);
   });
	 $("form").submit(function(e){
		 
			
			var today = new Date();
			var departDate = new Date(document.getElementById("departDate").value);
			today.setHours(0,0,0,0);
			departDate.setHours(0,0,0,0);
			if(departDate<today)
			{
				e.preventDefault();
				alert("Vui lòng chọn ngày đi lớn hơn ngày hiện tại");	
			}
		 		
		 		
	 });
	 
 </script>
		<script
			src="${pageContext.request.contextPath}/public/js/autoComplete.js"></script>
</body>
</html>