<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tìm kiếm</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/public/css/styleSearchTicket.css">
</head>
<body>
	<%@ include file="/pages/partion/HeaderCustomer.jsp"%>

	<!--  Header Section  -->
	<header id="header">
	<div class="container">
		<div class="col-md-12 col-sm-12 col-xs-12 mt10 date-container ">
			<div class="row header-row">
				<div class="col-md-6 hidden-sm hidden-xs">
					<h1 class="title-text-route">
						<span class="hidden-xs hidden-sm">Hủy vé</span>
					</h1>
				</div>
			</div>
		</div>
	</div>
	</header>

	<div class="icon-filter-fixed visible-xs">
		<img
			src="${pageContext.request.contextPath}/public/images/Route/icon-filter-white.svg">
	</div>
	<section class="searchResults">
	<div id="main">
		<div id="replaceDiv">
			<div id="searchResults">
				<ul class="result-list" style="margin: 0px;">
					<li class="result-item col-12 col-md-12 col-xs-12"
						style="position: relative;">
						<div class="container">
							<div class="hidden-xs">
								<div class="col-2 col-md-2 col-sm-3 col-xs-2">
									<div class="row">
										<div class="pull-left comp-name-container">
											<h6 title="Khánh Nhân"
												class="mt0 mb10 comp-name-title  text-gray3">Khánh Nhân</h6>
											<div class="col-lg-12 service-plus-in hidden-xs">
												<img
													src="${pageContext.request.contextPath}/public/images/wifi.svg">
												<img
													src="${pageContext.request.contextPath}/public/images/Water.svg">
												<a
													class="ml5 benefit-icons hidden-xs hidden-sm  text-route-link hover-orange-border hover-blue-text link ticket-detail-tab-link"
													style="visibility: hidden;" clicking="0"
													data-text="Tiện ích" data-tab="tienich"> <img
													src="${pageContext.request.contextPath}/public/images/plus-blue-01.svg">
												</a>
											</div>
											<ul class="busInfo hidden-sm hidden-xs hinh-anh">
												<li style="width: 65px;"><a
													class="ml5 ticket-detail-tab-link text-route-link hover-orange-border hover-blue-text"
													href="#" data-text="Hình ảnh" data-tab="hinhanh"> Hình
														ảnh </a></li>
											</ul>
										</div>

									</div>
								</div>

								<div
									class="col-4 col-md-5 col-lg-4 col-sm-3 col-xs-4 hidden-xs detail-route">
									<div class="col-12 ml10" style="text-align: center;">
										<div class="col-5 col-md-5 col-sm-12 text-left-from">
											<h6 class="span-from-time mt0 mb5">11:30</h6>
										</div>
										<div class="col-2 col-md-2 col-sm-12 text-left"
											style="padding: 0px;">
											<i class="text-gray3 left-arrow"
												style="text-align: center; line-height: 15px; font-size: 12px; margin-top: -10px; display: inline-block;">
												18h5' <br> <img style="width: 45px; height: 10px;"
												src="${pageContext.request.contextPath}/public/images/from-to2.png">
												<br> (dự kiến)
											</i>
										</div>
										<div class="col-5 col-md-5 col-sm-12 text-left-to">
											<h6 class="span-to-time-mobi mt0 mb5 text-gray3">05:35</h6>
										</div>
										<div class="clearfix"></div>
										<div class="pull-left hidden-sm" style="width: 100%;">
											<div class="col-5 col-md-5 col-sm-5 text-left">
												<a title=""
													class="depart-station ticket-detail-tab-link text-route-link hover-orange-border hover-blue-text"
													style="color: rgb(51, 51, 51);"> Đà Nẵng </a>
											</div>
											<div
												class="col-2 col-md-2 col-sm-2 hidden-xs hidden-sm payoo-mt2 total-time-text"></div>
											<div class="col-5 col-md-5 col-sm-5 payoo-mt2 text-left">
												<a title=""
													class="destination-station ticket-detail-tab-link text-route-link hover-orange-border hover-blue-text"
													style="color: rgb(51, 51, 51);"> VP2 Sài Gòn </a>
											</div>
										</div>
										<ul class="busInfo hidden-sm mt15">
											<li class="col-2 col-md-2 col-sm-2"></li>
											<li
												class="col-5 col-md-5 col-sm-5 text-left lichtrinh link-lich-trinh">
												<a
												class="ticket-detail-tab-link text-route-link hover-orange-border hover-blue-text"
												href="#" data-text="Lịch trình" data-tab="banggia"> Lịch
													trình </a>
											</li>
										</ul>
									</div>
								</div>

								<div class="col-2 col-md-2 col-sm-3 col-xs-2">
									<div class="vehicle-type-p mb3 text-left text-gray3"
										style="margin-bottom: 3px !important;" data-value="39">
										Ghế ngồi 45 chỗ</div>
									<div class="clearfix"></div>
									<div class="service-call seats-text text-left mt15">
										<span
											class="v2CPymCRCBpwkaAjA2IgIwMDD22JMBOgoxMy0wMi0yMDE5SA9QHQ">7</span>
										Ghế trống
									</div>

									<ul class="busInfo chinh-sach-huy text-left hidden-sm mt15">
										<li><a
											class="ml5 ticket-detail-tab-link text-route-link hover-orange-border hover-blue-text link-chinh-sach-huy"
											style="margin-top: 0px !important; margin-left: 0px !important;"
											href="#" data-text="Chính sách hủy vé"
											data-tab="chinhsachhuyve"> Chính sách hủy vé </a></li>

									</ul>
								</div>

								<div class="col-md-2 col-xs-2 text-left hidden-md hidden-sm">

								</div>

								<div class="text-right pr0 col-md-3 col-sm-3 col-xs-2 col-lg-2">
									
									<h6 class="mt0 price 14" >
										1.000.000 <small class="unit-price-small"
											style="vertical-align: top;">đ</small>
									</h6>



									<p style="margin: 0px;">
										<a title="Nhấp để đặt vé"
											class="ticket-ac-btn btn-vxr-lg btn pull-right w100 hasSeat closed a-v2CPymCRCBpwkaAjA2IgIwMDD22JMBOgoxMy0wMi0yMDE5SA9QHQ  online-button"
											id="a-13022019-011300535"
											onclick="ga('send', 'event', 'Đặt vé', 'click','Đặt vé tại Tuyến đường Đà Nẵng đi Sài Gòn nhà xe Khánh Nhân')"
											href="ve-xe-khach-tu-da-nang-di-sai-gon-115t1291.html@date=13-02-2019ve-xe-khach-tu-da-nang-di-sai-gon-115t1291.html@date=13-02-2019_13022019-011300535"
											data-tripcode="v2CPymCRCBpwkaAjA2IgIwMDD22JMBOgoxMy0wMi0yMDE5SA9QHQ">Chọn
											chỗ</a>
									</p>
								</div>

								<div class="col-12 col-md-12 col-lg-12 col-sm-12 col-xs-12">
									<i>*Thuộc chuyến 06:00 13-02-2019 Quảng Bình - Sài Gòn</i>

								</div>
							</div>
							<div class="hidden-lg hidden-sm hidden-md">
								<div class="col-xs-12">
									<div class="row"></div>
									<div class="row">
										<div class="col-xs-7">
											<div class="star-mobile">
												<h6 class="span-from-time mt0 mb5" >
													11:30</h6>
												<i class="pl5 pr5 text-gray3 left-arrow">→</i>
												<h6 class="span-to-time-mobi mt0 mb5 text-gray3">05:35</h6>
												<span class="totalHours">(dự kiến 18h5')</span>
											</div>
										</div>
										<div class="col-xs-5 text-right">
											
											<h6 class="mt0 price 24" data-value="1000000">
												1.000.000 <small class="unit-price-small"
													style="vertical-align: top;">đ</small>
											</h6>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-6">
											<h6 class="comp-name-title  text-gray3">Khánh Nhân</h6>
										</div>
										<div class="col-xs-6 text-right">
											<p
												class="visible-xs service-call availableseat-v2CPymCRCBpwkaAjA2IgIwMDD22JMBOgoxMy0wMi0yMDE5SA9QHQ">
												<span>
													7</span>
												Ghế trống
											</p>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-6">
											<div class="text-gray vehicle-type-p mb3 hidden-lg hidden-md"
												data-value="39">Đà Nẵng → VP2 Sài Gòn</div>
										</div>
										<div class="col-xs-6 text-right">
											<div
												class="hidden-lg hidden-md star-mobile Rating-mobile-star">

												<span class="BusQualityRating"
													style="background: rgb(24, 103, 188);">4/5</span> 3 <span></span>
												đánh giá
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-6">
											<div class="text-gray vehicle-type-p mb3 hidden-lg hidden-md"
												data-value="Ghế ngồi 45 chỗ">Ghế ngồi 45 chỗ</div>
										</div>
										
									</div>
								</div>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</div>
	</section>
</body>
</html>