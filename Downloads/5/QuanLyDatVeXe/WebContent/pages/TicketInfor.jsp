<%@page import="model.bean.VeXe"%>
<%@page import="model.bean.ResultChuyenSearch"%>
<%@page import="model.bean.Chuyen"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Xem thông tin vé xe</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/public/css/styleSearchTicket.css">
<script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="/pages/partion/HeaderCustomer.jsp"%>

	<!--  Header Section  -->
	<header id="header">
	<div class="container">
		<div class="col-md-12 col-sm-12 col-xs-12 mt10 date-container ">
			<div class="row header-row">
				<div class="col-md-6 hidden-sm hidden-xs">
					<%if(request.getAttribute("err") == null) {%>
					<h1 class="title-text-route">
						<%-- <bean:define id="noiDi" name="searchTicketForm" property="noiDi"></bean:define>
						<bean:define id="noiDen" name="searchTicketForm" property="noiDen"></bean:define>
						<bean:define id="ngayDi" name="searchTicketForm" property="ngayDi"></bean:define> --%>
						<span class="hidden-xs hidden-sm">Vé xe đã mua của ${userName}</span>
					</h1>
					<%}%>
				</div>
				<%-- <div class="col-md-6 hidden-sm hidden-xs">
					<h6
						class="mt0 route-title hidden-sm hidden-xs route-title-bus-ticket"
						style="margin-top: 5px !important;">
						<span class="mt0 mb0 text-gray"><a href="../default.htm">Vé
								xe khách</a> &gt;<a
							href="ve-xe-khach-tu-da-nang-di-sai-gon-115t1291.html@date=13-02-2019">xe
								đi ${noiDen} từ ${noiDi} </a></span>

					</h6>
					<input id="routeName" type="hidden" value="Đà Nẵng - Sài Gòn">
				</div> --%>

				<%-- <div class="date-picker-nav hidden-md hidden-lg"
					style="text-align: center;">
					<h1 class="title-text-route">Đà Nẵng - Sài Gòn</h1>
					<div class="btn-group btn-group-xs" role="group">
						<button class="btn btn-default" id="btPrevDate" type="button">
							<img class="img-change-date"
								src="${pageContext.request.contextPath}/public/images/Route/icon-previous.png@v=3">
						</button>
						<input tabindex="1" class="btn btn-vxr current-date hasDatepicker"
							id="span-current-date" type="button" value="13-02-2019">
						<button class="btn btn-default" id="btNextDate" type="button">
							<img class="img-change-date"
								src="${pageContext.request.contextPath}/public/images/Route/icon-next.png@v=2">
						</button>
					</div>
				</div> --%>
				<div class="pull-left ml10 modify-container hidden-lg hidden-md">
					<a class="text-blue" id="btModify" href="#">Sửa</a>
				</div>
			</div>
		</div>
	</div>
	</header>


	<%-- <div class="ticket-search-filter " id="dvSearchTicket">
		<div class="container desktop-route-search hidden-xs hidden-sm">
			<form class="form-inline" id="searchForm" method="post" action="${pageContext.request.contextPath}/searchTicket.do">
				<input id="search-busoperator-id" type="hidden" value="0"> <input
					id="search-busoperator-name" type="hidden">
				<div class="form-group">
					<span class="ui-helper-hidden-accessible" role="status"
						aria-live="polite"></span><input name="noiDi" tabindex="1"
						class="ui-autocomplete-input location-search" id="departPlace"
						accesskey="1" onmouseup="return false;" onfocus="this.select();"
						type="text" placeholder="Gõ vào nơi đi" value="${noiDi}"
						autocomplete="off"> <input id="start-point-type"
						type="hidden" value="1"> <input id="start-point-id"
						type="hidden" value="15">
				</div>
				<div class="form-group hidden-xs">
					<a class="switchButton" href="#">⇌</a>
				</div>
				<div class="form-group">
					<span class="ui-helper-hidden-accessible" role="status"
						aria-live="polite"></span><input name="noiDen" tabindex="2"
						class="ui-autocomplete-input location-search" id="destination"
						accesskey="2" onmouseup="return false;" onfocus="this.select();"
						type="text" placeholder="Gõ vào nơi đến" value="${noiDen}"
						autocomplete="off"> <input id="stop-point-type"
						type="hidden" value="1"> <input id="stop-point-id"
						type="hidden" value="29">
				</div>
				<div class="form-group departDate-fg">

					<input
						name="ngayDi" tabindex="3"
						class="date calendar-search hasDatepicker" id="departDate"
						accesskey="1" type="date" placeholder="Chọn ngày đi"
						value="${ngayDi}">
					<div style="display: none;" class="form-group quick-date-select fr hidden-xs hidden-sm">
						<button class="fl btn btn-gray btn-today" id="btToday"
							type="button">Hôm nay</button>
						<button class="fl btn btn-gray btn-tomorrow" id="btTomorrow"
							type="button">Ngày mai</button>
					</div>
				</div>
				<div class="form-group pull-right">
					<button name="searchSubmit" tabindex="4"
						class="submit-btn btn  search-btn" id="searchSubmit" type="submit">
						Tìm Vé Xe Rẻ</button>
				</div>
			</form>
		</div>

	</div> --%>


	<!-- search results filter-->
	

	<input id="listBusOperatorsVxrBoughtTicket" type="hidden"
		value="28590,985,11108">
	<!-- Modal -->
	<div class="modal fade modal-mobi" id="modal-filter-mobi" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button class="close" type="button" data-dismiss="modal">
						<img style="width: 15px;"
							src="${pageContext.request.contextPath}/public/images/closed-white.svg">
					</button>
					<h4 class="modal-title">Lọc theo</h4>
				</div>
				<div class="modal-body">
					<ul>
						<li class="item-filter">
							<div class="body-filter-section">
								<ul class="list-property list-discount list-discount-mobi"
									style="margin: 0px; padding: 0px 0px 0px 10px;">
									<li><input id="1-mobi" style="display: none;"
										type="checkbox" data-id="1"><label for="1-mobi">Giảm
											giá</label></li>
								</ul>
							</div>
						</li>
						<li class="item-filter">
							<div
								class="header-filter-section dg-SearchFilterPanel-category-title">
								<span class="title-filter">Hãng xe</span>
							</div>
							<div class="body-filter-section">
								<ul class="list-property trasporter-list trasporter-list-mobi">
									<li><input id="1752-mobi" style="display: none;"
										type="checkbox" data-id="1752"><label for="1752-mobi">A
											Tỷ</label></li>
									<li><input id="11108-mobi" style="display: none;"
										type="checkbox" data-id="11108"><label
										for="11108-mobi">Cẩm Vân</label></li>
									<li><input id="11192-mobi" style="display: none;"
										type="checkbox" data-id="11192"><label
										for="11192-mobi">Đình Nhân</label></li>
									<li class="hidden-xs dynamic-item"><input id="20273-mobi"
										style="display: none;" type="checkbox" data-id="20273"><label
										for="20273-mobi">Hương Ty</label></li>
									<li class="hidden-xs dynamic-item"><input id="28590-mobi"
										style="display: none;" type="checkbox" data-id="28590"><label
										for="28590-mobi">Khánh Nhân</label></li>
									<li class="hidden-xs dynamic-item"><input id="12528-mobi"
										style="display: none;" type="checkbox" data-id="12528"><label
										for="12528-mobi">Minh Phương</label></li>
									<li class="hidden-xs dynamic-item"><input id="11112-mobi"
										style="display: none;" type="checkbox" data-id="11112"><label
										for="11112-mobi">Phi Hiệp</label></li>
									<li class="hidden-xs dynamic-item"><input id="985-mobi"
										style="display: none;" type="checkbox" data-id="985"><label
										for="985-mobi">Phúc Thuận Thảo</label></li>
									<li class="hidden-xs dynamic-item"><input id="11071-mobi"
										style="display: none;" type="checkbox" data-id="11071"><label
										for="11071-mobi">Phương Trang</label></li>
									<li class="hidden-xs dynamic-item"><input id="12726-mobi"
										style="display: none;" type="checkbox" data-id="12726"><label
										for="12726-mobi">Quốc Tín</label></li>
									<li class="hidden-xs dynamic-item"><input id="11763-mobi"
										style="display: none;" type="checkbox" data-id="11763"><label
										for="11763-mobi">Thảo Quyên</label></li>
									<li class="seemore-filter">Xem thêm...</li>
									<li class="collapsed-filter hidden-xs">Thu gọn</li>
								</ul>
							</div>
						</li>
						<li class="item-filter">
							<div
								class="header-filter-section dg-SearchFilterPanel-category-title">
								<span class="title-filter">Giờ đi</span>
							</div>
							<div class="body-filter-section">
								<ul class="list-property from-time-list from-time-list-mobi">
									<li><input id="fromtimegroup-2-mobi" type="checkbox"
										data-id="timegroup-2"><label
										for="fromtimegroup-2-mobi">06:00 - 11:59</label></li>
									<li><input id="fromtimegroup-3-mobi" type="checkbox"
										data-id="timegroup-3"><label
										for="fromtimegroup-3-mobi">12:00 - 17:59</label></li>
								</ul>
							</div>
						</li>
						<li class="item-filter">
							<div
								class="header-filter-section dg-SearchFilterPanel-category-title">
								<span class="title-filter">Nơi đi</span>
							</div>
							<div class="body-filter-section">
								<ul class="list-property start-point-list start-point-list-mobi">

									<li><input id="Đà Nẵng-mobi" type="checkbox"
										data-id="Đà Nẵng"><label for="Đà Nẵng-mobi">Đà
											Nẵng</label></li>
									<li><input id="Liên Chiểu-mobi" type="checkbox"
										data-id="Liên Chiểu"><label for="Liên Chiểu-mobi">Liên
											Chiểu</label></li>
									<li><input id="Thanh Khê-mobi" type="checkbox"
										data-id="Thanh Khê"><label for="Thanh Khê-mobi">Thanh
											Khê</label></li>

								</ul>
							</div>
						</li>
						<li class="item-filter">
							<div
								class="header-filter-section dg-SearchFilterPanel-category-title">
								<span class="title-filter">Nơi đến</span>
							</div>
							<div class="body-filter-section">
								<ul class="list-property end-point-list end-point-list-mobi">

									<li><input id="Bình Thạnh-mobi" type="checkbox"
										data-id="Bình Thạnh"><label for="Bình Thạnh-mobi">Bình
											Thạnh</label></li>
									<li><input id="Tân Bình-mobi" type="checkbox"
										data-id="Tân Bình"><label for="Tân Bình-mobi">Tân
											Bình</label></li>
									<li><input id="Tân Phú-mobi" type="checkbox"
										data-id="Tân Phú"><label for="Tân Phú-mobi">Tân
											Phú</label></li>

								</ul>
							</div>
						</li>
						<li class="item-filter">
							<div
								class="header-filter-section dg-SearchFilterPanel-category-title">
								<span class="title-filter">Loại xe</span>
							</div>
							<div class="body-filter-section">
								<ul
									class="list-property vehicle-type-list vehicle-type-list-mobi">
									<li><input id="normal-seat-mobi" type="checkbox"
										data-id="normal-seat"><label for="normal-seat-mobi">Xe
											thường</label></li>
									<p>
										<a
											href="ve-xe-limousine-tu-da-nang-di-sai-gon-115t1291.html@date=13-02-2019"
											target="_blank">Xe limousine đi Hồ Chí Minh từ Đà Nẵng</a>
									</p>
								</ul>
							</div>
						</li>
						<li class="item-filter">
							<div
								class="header-filter-section dg-SearchFilterPanel-category-title">
								<span class="title-filter">Loại ghế</span>
							</div>
							<div class="body-filter-section">
								<ul class="list-property seat-type-list seat-type-list-mobi">
									<li><input id="ac-seater-mobi" type="checkbox"
										data-id="ac-seater"><label for="ac-seater-mobi">Ghế
											ngồi</label></li>
									<li><input id="ac-sleeper-mobi" type="checkbox"
										data-id="ac-sleeper"><label for="ac-sleeper-mobi">Giường
											nằm</label></li>
								</ul>
							</div>
						</li>

					</ul>












				</div>
				<div class="modal-footer">

					<button class="xoachon xoachon-mobi" type="button"
						data-dismiss="modal">Xóa đã chọn</button>
					<button class="hoantat hoantat-mobi" type="button"
						data-dismiss="modal">Hoàn tất</button>
				</div>
			</div>

		</div>
	</div>




	<div class="icon-filter-fixed visible-xs">
		<img
			src="${pageContext.request.contextPath}/public/images/Route/icon-filter-white.svg">
	</div>

	<div class="from-search-detail hidden-xs" style="display: none;">
		<div class="col-md-1 col-xs-1 promotiont-search">
			<ul class="list-property list-discount list-discount-pc"
				style="margin: 18px 0px 0px; padding: 0px;">
				<li><input id="discount-1" type="checkbox" data-id="discount-1"><label
					for="discount-1">Giảm giá</label></li>
			</ul>

		</div>
		<div class="col-md-2 col-xs-2 property">
			<input class="tex-search search-hx" type="text" placeholder="Hãng xe">
			<ul class="list-property trasporter-list trasporter-list-pc"
				style="margin: 0px; padding: 0px;">
				<li data-name="A Tỷ"><input id="1752" type="checkbox"
					data-id="1752"><label for="1752">A Tỷ</label></li>
				<li data-name="Cẩm Vân"><input id="11108" type="checkbox"
					data-id="11108"><label for="11108">Cẩm Vân</label></li>
				<li data-name="Đình Nhân"><input id="11192" type="checkbox"
					data-id="11192"><label for="11192">Đình Nhân</label></li>
				<li data-name="Hương Ty"><input id="20273" type="checkbox"
					data-id="20273"><label for="20273">Hương Ty</label></li>
				<li data-name="Khánh Nhân"><input id="28590" type="checkbox"
					data-id="28590"><label for="28590">Khánh Nhân</label></li>
				<li data-name="Minh Phương"><input id="12528" type="checkbox"
					data-id="12528"><label for="12528">Minh Phương</label></li>
				<li data-name="Phi Hiệp"><input id="11112" type="checkbox"
					data-id="11112"><label for="11112">Phi Hiệp</label></li>
				<li data-name="Phúc Thuận Thảo"><input id="985" type="checkbox"
					data-id="985"><label for="985">Phúc Thuận Thảo</label></li>
				<li data-name="Phương Trang"><input id="11071" type="checkbox"
					data-id="11071"><label for="11071">Phương Trang</label></li>
				<li data-name="Quốc Tín"><input id="12726" type="checkbox"
					data-id="12726"><label for="12726">Quốc Tín</label></li>
				<li data-name="Thảo Quyên"><input id="11763" type="checkbox"
					data-id="11763"><label for="11763">Thảo Quyên</label></li>

			</ul>
		</div>
		<div class="col-md-1 col-xs-1">
			<span>Giờ đi</span>
			<ul class="list-property from-time-list from-time-list-pc"
				style="margin: 0px; padding: 0px;">
				<li><input id="fromtimegroup-2" type="checkbox"
					data-id="timegroup-2"><label for="fromtimegroup-2">06:00
						- 11:59</label></li>
				<li><input id="fromtimegroup-3" type="checkbox"
					data-id="timegroup-3"><label for="fromtimegroup-3">12:00
						- 17:59</label></li>

			</ul>
		</div>
		<div class="col-md-2 col-xs-2">
			<input class="tex-search search-nd" type="text" placeholder="Nơi đi">
			<ul class="list-property start-point-list start-point-list-pc"
				style="margin: 0px; padding: 0px;">

				<li data-name="Đà Nẵng"><input id="Đà Nẵng" type="checkbox"
					data-id="Đà Nẵng"><label for="Đà Nẵng">Đà Nẵng</label></li>
				<li data-name="Liên Chiểu"><input id="Liên Chiểu"
					type="checkbox" data-id="Liên Chiểu"><label
					for="Liên Chiểu">Liên Chiểu</label></li>
				<li data-name="Thanh Khê"><input id="Thanh Khê" type="checkbox"
					data-id="Thanh Khê"><label for="Thanh Khê">Thanh
						Khê</label></li>
			</ul>
		</div>

		<div class="col-md-2 col-xs-2">
			<input class="tex-search search-from-filter" type="text"
				placeholder="Nơi đến">
			<ul class="list-property end-point-list end-point-list-pc"
				style="margin: 0px; padding: 0px;">

				<li data-name="Bình Thạnh"><input id="Bình Thạnh"
					type="checkbox" data-id="Bình Thạnh"><label
					for="Bình Thạnh">Bình Thạnh</label></li>
				<li data-name="Tân Bình"><input id="Tân Bình" type="checkbox"
					data-id="Tân Bình"><label for="Tân Bình">Tân Bình</label></li>
				<li data-name="Tân Phú"><input id="Tân Phú" type="checkbox"
					data-id="Tân Phú"><label for="Tân Phú">Tân Phú</label></li>

			</ul>
		</div>

		<div class="col-md-2 col-xs-2">
			<span>Loại xe</span>
			<ul class="list-property vehicle-type-list vehicle-type-list-pc"
				style="margin: 0px; padding: 0px;">
				<li><input id="normal-seat" type="checkbox"
					data-id="normal-seat"><label for="normal-seat">Xe
						thường </label></li>
				<p>
					<a
						href="ve-xe-limousine-tu-da-nang-di-sai-gon-115t1291.html@date=13-02-2019"
						target="_blank">Xe limousine đi Hồ Chí Minh từ Đà Nẵng</a>
				</p>
			</ul>
		</div>
		<div class="col-md-2 col-xs-2">
			<span>Loại ghế</span>
			<ul class="list-property seat-type-list seat-type-list-pc"
				style="margin: 0px; padding: 0px;">
				<li><input id="ac-seater" type="checkbox" data-id="ac-seater"><label
					for="ac-seater">Ghế ngồi</label></li>
				<li><input id="ac-sleeper" type="checkbox" data-id="ac-sleeper"><label
					for="ac-sleeper">Giường nằm</label></li>
			</ul>
		</div>
		<div class="col-md-2 col-xs-2"></div>
		<div class="col-md-12 col-xs-12 buttom-search"
			style="width: 100%; text-align: center; margin-top: 30px;">
			<a class="hoantat">Hoàn tất</a> <a class="xoachon">Xóa đã chọn</a>
		</div>
		<img class="close-form-sort"
			src="${pageContext.request.contextPath}/public/images/closed.svg">
	</div>

	<input id="checkExtendLoad" style="display: none;" value="0">
	<input id="redirectmomo" style="display: none;" value="1">
	<input id="appidmomo" style="display: none;"
		value="com.mservice.com.vn.momotransfer">

	<section class="searchResults">
	<div id="main">


		<div id="replaceDiv">
			<div id="searchResults">


				<ul class="result-list" style="margin: 0px;">



							<%
								if(request.getAttribute("err") == null) {
									ArrayList<ResultChuyenSearch> listChuyen = (ArrayList<ResultChuyenSearch>) request.getAttribute("listChuyen");
									if(listChuyen.size() > 0) {
										for(ResultChuyenSearch rsChuyenSearch : listChuyen) {
							%>
					<li class="result-item col-12 col-md-12 col-xs-12"
						style="position: relative;" >
						<div class="container">
							<div id="13022019-011300535" style="display: none;"></div>
							<div class="from-time-value" style="display: none;"
								data-value="690"></div>
							<div class="from-stop-value" style="display: none;"
								data-value="Đà Nẵng"></div>
							<div class="to-stop-value" style="display: none;"
								data-value="VP2 Sài Gòn"></div>
							<div class="company-value" style="display: none;"
								data-value="Khánh Nhân"></div>
							<div class="hidden-xs">
								<div class="col-0 col-md-1 col-sm-0 col-xs-0">
									<div class="row">
											<h6 title="Khánh Nhân"
												class="mt0 mb10 comp-name-title  text-gray3">Số lượng</h6>
										<div class="service-call seats-text text-left mt15">
											<span
												class="v2CPymCRCBpwkaAjA2IgIwMDD22JMBOgoxMy0wMi0yMDE5SA9QHQ"><%=rsChuyenSearch.getSoGheDaDat()%></span>
											vé
										</div>

									</div>
								</div>
								<div class="col-2 col-md-2 col-sm-3 col-xs-2">
									<div class="row">
										<div class="pull-left comp-name-container">
											<h6 title="Khánh Nhân"
												class="mt0 mb10 comp-name-title  text-gray3"><%=rsChuyenSearch.getTenNhaXe()%></h6>
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
										</div>

									</div>
								</div>

								<div
									class="col-6 col-md-7 col-lg-6 col-sm-3 col-xs-4 hidden-xs detail-route">
									<div class="col-12 ml10" style="text-align: center;">
										<div class="col-5 col-md-5 col-sm-12 text-left-from">
											<h6 class="span-from-time mt0 mb5" data-tripid="2419830"
												data-pickupdate="11:30 13-02-2019" data-istetticket="0"
												data-workingtime="False" data-busticketstatus="2">
												<%=rsChuyenSearch.getGioXP()%>
											</h6>
										</div>
										<div class="col-2 col-md-2 col-sm-12 text-left"
											style="padding: 0px;">
											<i class="text-gray3 left-arrow"
												style="text-align: center; line-height: 15px; font-size: 12px; margin-top: -10px; display: inline-block;">
												<%=rsChuyenSearch.getTgdc()%>h <br> <img style="width: 45px; height: 10px;"
												src="${pageContext.request.contextPath}/public/images/from-to2.png">
												<br> (dự kiến)
											</i>
										</div>
										<div class="col-5 col-md-5 col-sm-12 text-left-to">
											<h6 class="span-to-time-mobi mt0 mb5 text-gray3"
												data-istetticket="0" data-workingtime="False"
												data-busticketstatus="2">
												<%=rsChuyenSearch.getGioTN()%>
											</h6>
										</div>
										<div class="clearfix"></div>
										<div class="pull-left hidden-sm" style="width: 100%;">
											<div class="col-5 col-md-5 col-sm-5 text-left">
												<a title=""
													class="depart-station ticket-detail-tab-link text-route-link hover-orange-border hover-blue-text"
													style="color: rgb(51, 51, 51);" onclick="return false;"
													href="ve-xe-khach-tu-da-nang-di-sai-gon-115t1291.html@date=13-02-2019ve-xe-khach-tu-da-nang-di-sai-gon-115t1291.html@date=13-02-2019_"
													data-original-title="Ngã tư túy loan QL14B Hòa Nhơn - Hoà Vang - Đà Nẵng - Đà Nẵng - Đà Nẵng"
													data-toggle="tooltip" data-id="152444" data-value="Đà Nẵng"
													data-text="Đà Nẵng" data-tab="banggia"
													data-tripcode="v2CPymCRCBpwkaAjA2IgIwMDD22JMBOgoxMy0wMi0yMDE5SA9QHQ"
													data-time="11:30" data-trip-id="2419830" data-appended="0">
													<%=rsChuyenSearch.getDiaDiemDi().substring(0,rsChuyenSearch.getDiaDiemDi().indexOf(","))%>
												</a>
											</div>
											<div
												class="col-2 col-md-2 col-sm-2 hidden-xs hidden-sm payoo-mt2 total-time-text"></div>
											<div class="col-5 col-md-5 col-sm-5 payoo-mt2 text-left">
												<a title=""
													class="destination-station ticket-detail-tab-link text-route-link hover-orange-border hover-blue-text"
													style="color: rgb(51, 51, 51);" onclick="return false;"
													href="ve-xe-khach-tu-da-nang-di-sai-gon-115t1291.html@date=13-02-2019ve-xe-khach-tu-da-nang-di-sai-gon-115t1291.html@date=13-02-2019_"
													data-original-title="18D Cộng Hòa - nhà nghỉ bộ quốc phòng - Tân Bình - Hồ Chí Minh"
													data-toggle="tooltip" data-id="152449"
													data-value="VP2 Sài Gòn" data-text="VP2 Sài..."
													data-tab="banggia"
													data-tripcode="v2CPymCRCBpwkaAjA2IgIwMDD22JMBOgoxMy0wMi0yMDE5SA9QHQ"
													data-time="11:30" data-trip-id="2419830" data-appended="0">
													<%=rsChuyenSearch.getDiaDiemDen().substring(0,rsChuyenSearch.getDiaDiemDen().indexOf(","))%>
												</a>
											</div>
										</div>
										
									</div>
								</div>

								<div class="col-2 col-md-1 col-sm-3 col-xs-2">
									<div class="clearfix"></div>
									<div class="service-call seats-text text-left mt15">
										<span
											class="v2CPymCRCBpwkaAjA2IgIwMDD22JMBOgoxMy0wMi0yMDE5SA9QHQ"><%=rsChuyenSearch.getSoGheTrong()%></span>
										Ghế trống
									</div>

								</div>


								<div class="text-right pr0 col-md-3 col-sm-3 col-xs-2 col-lg-2">
									<meta content="1.000.000">
									<h6 class="mt0 price 14" data-value="1000000">
									<%
										DecimalFormat df = new DecimalFormat("#");
								    	df.setMaximumFractionDigits(2);
								    	String tt1 = df.format(rsChuyenSearch.getTongTien());
								    	String tt="";
								    	int dem=1;
								    	for(int i=tt1.length()-1;i>=0;i--)
								    	{
								    		tt=tt1.charAt(i)+tt;
								    		if(dem%3==0&&dem!=tt1.length())tt=","+tt;
								    		dem++;
								    	}
									%>
										<%=tt%>
										<small class="unit-price-small" style="vertical-align: top;">đ</small>
									</h6>


									<p style="margin: 0px;">
									<%
										//SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
										//Date d = sdf.parse(rsChuyenSearch.getNgayXuatPhat());
										//Date today = new Date();
										//d.setTime(0);today.setTime(0);
										//if(d.after(today)){
										if(rsChuyenSearch.getSoGheTrong() >0) {
									%>
										<a title="Nhấp để đặt vé"	style="margin-bottom: 10px"	class="ticket-ac-btn btn-vxr-lg btn pull-right w100 hasSeat closed a-v2CPymCRCBpwkaAjA2IgIwMDD22JMBOgoxMy0wMi0yMDE5SA9QHQ  online-button"
											id="a-13022019-011300535"
											href="${pageContext.request.contextPath}/bookTicket.do?maChuyen=<%=rsChuyenSearch.getMaChuyen() %>"
											data-tripcode="v2CPymCRCBpwkaAjA2IgIwMDD22JMBOgoxMy0wMi0yMDE5SA9QHQ">Mua thêm vé </a>
											<%
										} else {
									%>
									<p style="margin: 0px;">
				                        <button style="margin-bottom: 10px" class="no-ticket btn-sold-out-lg rounded-4 w100 btn-vxr-gray-lg" type="button">Hết vé</button>
				                    </p>
				                    <%}//}else{%>
				                    <!-- <p style="margin: 0px;">
				                        <button style="margin-bottom: 10px" class="no-ticket btn-sold-out-lg rounded-4 w100 btn-vxr-gray-lg" type="button">Hết hạn mua vé</button>
				                    </p> -->
				                    <%//} %>
											
											<!-- Trigger the modal with a button -->
											  <button style="border-radius: 3px !important;" type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal<%=rsChuyenSearch.getMaChuyen()%>">Xem chi tiết</button>
											
											  <!-- Modal -->
											  <div class="modal fade" id="myModal<%=rsChuyenSearch.getMaChuyen()%>" role="dialog">
											    <div class="modal-dialog modal-sm">
											      <div class="modal-content">
											        <div class="modal-header">
											          <button type="button" class="close" data-dismiss="modal">&times;</button>
											          <h4 class="modal-title" style="text-align: center;">Chi tiết vé</h4>
											        </div>
											        <div class="modal-body">
											          <ul>
											          <%
											          	for(VeXe itemVeXe : rsChuyenSearch.getListVe()) {
											          %>
											          	<li style="text-align: left;height: 38px;">
											          	<%
											          		String s1 = "", s2="", s3="";
											          		if(!(itemVeXe.getMaSoGhe().charAt(0) == 0)) {
											          		    s1 = "Dãy " + itemVeXe.getMaSoGhe().charAt(0) + "; ";
											          		}
											          		if(rsChuyenSearch.getXe().getMaLoaiXe() == 2) {
											          		  if(!(itemVeXe.getMaSoGhe().charAt(1) == 0)) {
											          		    	s2 = "Ghế " + itemVeXe.getMaSoGhe().charAt(1);
												          		}
												          		if(!(itemVeXe.getMaSoGhe().charAt(2) == 0)) {
											          		    	s2 = s2 + itemVeXe.getMaSoGhe().charAt(2);
												          		}
											          		} else if (rsChuyenSearch.getXe().getMaLoaiXe() == 1) {
												          		  if(!(itemVeXe.getMaSoGhe().charAt(1) == 0)) {
												          		    	s2 = "Ghế " + itemVeXe.getMaSoGhe().charAt(1) + "; ";
													          		}
												          		  if(!(itemVeXe.getMaSoGhe().charAt(2) == 0)) {
													          		    if(itemVeXe.getMaSoGhe().charAt(2) == 'D') {
													          		      s3 = "Tầng dưới";
													          		    } else {
													          		      if(itemVeXe.getMaSoGhe().charAt(2) == 'T')
													          		      s3 = "Tầng trên";
													          		    }
													          		}
											          		}
											          		out.print(s1 + s2 + s3);
											          	%>
											          	<a href="${pageContext.request.contextPath}/ticket/delete.do?maVe=<%=itemVeXe.getMaVe()%>" style="float: right;border-radius: 3px" onclick="confirm('Bạn có chắc muốn hủy?')" class="w3-button w3-red">Hủy vé</a>
											          	</li>
											          <% } %>
											          </ul>
											        </div>
											        <div class="modal-footer">
											          <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
											        </div>
											      </div>
											    </div>
											  </div>
											
											<!-- <p><a style="border-radius: 3px" class="w3-button w3-light-blue">Xem chi tiết</a></p> -->
											 <a title="Nhấp để đóng lại"
											class="ticket-ac-btn btn btn-lg btn-vxr-gray-lg w100 open online-button"
											style="display: none;" href="javascript:;">Đóng lại</a>



									</p>
									
								</div>

								
							</div>
							<div class="hidden-lg hidden-sm hidden-md">
								<div class="col-xs-12">
									<div class="row"></div>
									<div class="row">
										<div class="col-xs-7">
											<div class="star-mobile">
												<h6 class="span-from-time mt0 mb5" data-tripid="2419830"
													data-pickupdate="11:30 13-02-2019" data-istetticket="0"
													data-workingtime="False" data-busticketstatus="2">
													11:30</h6>
												<i class="pl5 pr5 text-gray3 left-arrow">→</i>
												<h6 class="span-to-time-mobi mt0 mb5 text-gray3"
													data-istetticket="0" data-workingtime="False"
													data-busticketstatus="2">05:35</h6>
												<span class="totalHours">(dự kiến 18h5')</span>
											</div>
										</div>
										<div class="col-xs-5 text-right">
											<meta content="1.000.000">
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
												<span
													class="v2CPymCRCBpwkaAjA2IgIwMDD22JMBOgoxMy0wMi0yMDE5SA9QHQ">7</span>
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
										<div class="col-xs-6 text-right">
											<p style="margin: 0px;">
												<a title="Nhấp để đặt vé"
													class="ticket-ac-btn btn-vxr-lg btn pull-right w100 hasSeat closed a-v2CPymCRCBpwkaAjA2IgIwMDD22JMBOgoxMy0wMi0yMDE5SA9QHQ  online-button"
													id="a-13022019-011300535"
													onclick="ga('send', 'event', 'Đặt vé', 'click','Đặt vé tại Tuyến đường Đà Nẵng đi Sài Gòn nhà xe Khánh Nhân')"
													href="ve-xe-khach-tu-da-nang-di-sai-gon-115t1291.html@date=13-02-2019ve-xe-khach-tu-da-nang-di-sai-gon-115t1291.html@date=13-02-2019_13022019-011300535"
													data-tripcode="v2CPymCRCBpwkaAjA2IgIwMDD22JMBOgoxMy0wMi0yMDE5SA9QHQ">Chọn
													chỗ</a> <a title="Nhấp để đóng lại"
													class="ticket-ac-btn btn btn-lg btn-vxr-gray-lg w100 open online-button"
													style="display: none;" href="javascript:;">Đóng lại</a>



											</p>
										</div>
									</div>
								</div>
							</div>
							<p style="font-weight: bold;">Tên xe: <span style="color:#236ca8;"><%=rsChuyenSearch.getXe().getTenXe()%>
							</span>	-	Biển số: <span style="color: #236ca8;"><%=rsChuyenSearch.getXe().getBienSo()%></span>
							 -	Ngày Xuất Phát: <span style="color: #236ca8;"><%=rsChuyenSearch.getNgayXuatPhat()%></span>
							</p>
						</div>
					</li>
					<% 
									}} else {
					%>
					<p style="color: red;text-align: center;margin: auto;font-size: 20px;margin-top: 10px">Không có vé nào!</p>
					<%}} else {%>
					<p style="color: red;text-align: center;margin: auto;font-size: 20px;margin-top: 10px"><%=request.getAttribute("err")%></p>
					<% } %>
				</ul>

			</div>
		</div>


	</div>


	</section>
	<div style="height: 70px;clear: both;"></div>

	<div class="road-point hidden-xs" style="position:fixed;
    bottom:0;">
		
		<div class="bus-preloader">
			<div class="preloader_horizontal">
				<div class="animate_element">
					<div class="animate_bus"></div>
					<div class="smoke">
						<div class="smoke_item smoke_item1"></div>
						<div class="smoke_item smoke_item2"></div>
						<div class="smoke_item smoke_item3"></div>
						<div class="smoke_item smoke_item4"></div>
					</div>
				</div>
			</div>
			<div class="road">
				<span>Lộ trình...</span>
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
 </script>
 <script src="${pageContext.request.contextPath}/public/js/autoComplete.js"></script>

</body>
</html>