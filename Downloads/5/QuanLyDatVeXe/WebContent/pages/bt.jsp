<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.bean.Ghe"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "" "">
<html>
<head lang="vi"
	prefix="og: http://ogp.me/ns# fb: http://ogp.me/ns/fb# product: http://ogp.me/ns/product#">
<meta name="viewport"
	content="width=device-width, height=device-height, initial-scale=1, maximum-scale=1, user-scalable=0">
<title>Đặt vé xe từ Đà Nẵng đi Sài Gòn | VeXeRe.com</title>

<meta charset="utf-8">

<link
	href="${pageContext.request.contextPath}/public/chooseSeat/Content/vxr/images/vexere-ico.ico@v=00340"
	rel="shortcut icon" type="image/x-icon">
<link
	href="${pageContext.request.contextPath}/public/chooseSeat/bundles/route-styles.css@v=00340.css"
	rel="stylesheet">
</head>
<body>
	<% ArrayList<ArrayList<Ghe>> listGhe = (ArrayList<ArrayList<Ghe>>)request.getAttribute("listGheMatrix");%>
	<%int floorNum = (Integer)request.getAttribute("soTang"); %>
	<%
			int i=0;
			int maxI=listGhe.size();
			if(floorNum==2) maxI/=2;
		%>
	<nav class="header-blue" style="min-height: 90px;">
		<div class="container">
			<div class="row">
				<div class="col-md-3">
					<a class="logo-image" href="default.htm"><img height="50"
						src="${pageContext.request.contextPath}/public/images/logo.svg"></a>
					<ul class="header-action-bar visible-sm visible-xs">
						<li><a class="menu-action" href="#"><i class="fa fa-bars"></i></a></li>
					</ul>
				</div>
				<div id="overlay-layout"
					style="width: 100%; height: 100%; margin-top: 7px; display: none; position: fixed; z-index: 99; opacity: 0.7; background-color: rgb(166, 166, 166);">
				</div>
				<div class="col-md-9 header-blue-right-menu pl0">
					<ul class="header-blue-menu-list">

						<li><a href="vi-VN/tuyen-dung">Tuyển dụng</a></li>
						<li><a
							href="vi-vn/phan-mem-quan-ly-ban-ve-xe-khach-vexere.html">Phần
								mềm hãng xe</a></li>
						<li><a href="../https@blog.vexere.com/default.htm">Blog</a></li>
						<li><a href="vi-VN/booking/cancelticket">Hủy vé</a></li>
						<li><a href="vi-VN/booking/ticketinfo">Kiểm tra vé</a></li>
						<li><a href="default.htm">Trang chủ</a></li>
					</ul>
					<ul class="header-blue-menu-list">
						<li><a href="${pageContext.request.contextPath}/login.do">Đăng
								nhập</a></li>
					</ul>
					<div>
						<a style="text-decoration: none; cursor: pointer;" href="vexetet"><b
							style="color: rgb(255, 241, 0); font-size: 14px;"> <img
								style="height: 24px;"
								src="${pageContext.request.contextPath}/public/images/landingpagetet2018/tet-hoa-mai-2019.png@v=206">Vé
								Xe Tết 2019
						</b></a>
					</div>	
				</div>

				<div
					class="col-md-9 header-blue-right-menu header-blue-right-menu-mobile hidden-lg hidden-md"
					style="display: block;">
					<ul class="header-blue-menu-list">
						<li><a class="header-blue-language en-change"
							href="javascript:"
							data-href="/vi-VN/Language/ChangeLanguage?changelang=en&amp;url=/"><div>
									<img class="right-icon" style="width: 20px;"
										src="${pageContext.request.contextPath}/public/images/icon-english.svg">
								</div>English</a></li>
						<li><a class="header-blue-language vi-change"
							href="javascript:"
							data-href="/vi-VN/Language/ChangeLanguage?changelang=vn&amp;url=/"><div>
									<img class="right-icon" style="width: 20px;"
										src="${pageContext.request.contextPath}/public/images/icon-tieng-viet.svg">
								</div>Tiếng Việt</a></li>
						<li><div
								style="width: 100%; height: 1px; background-color: rgb(166, 166, 166);"></div></li>

						<li><a href="default.htm"><div>
									<img class="right-icon" style="width: 20px;"
										src="${pageContext.request.contextPath}/public/images/icon-home.svg">
								</div>Trang chủ</a></li>

						<li><a href="vi-VN/booking/ticketinfo"><div>
									<img class="right-icon" style="width: 20px;"
										src="${pageContext.request.contextPath}/public/images/icon-scope.svg">
								</div>Kiểm tra vé</a></li>
						<li><a href="vi-VN/booking/cancelticket"><div>
									<img class="right-icon" style="width: 20px;"
										src="${pageContext.request.contextPath}/public/images/icon-scope.svg">
								</div>Hủy vé</a></li>

						<li><a
							href="vi-vn/phan-mem-quan-ly-ban-ve-xe-khach-vexere.html"><div>
									<img width="20" class="right-icon"
										src="${pageContext.request.contextPath}/public/images/icon-bms.svg">
								</div>Phần mềm hãng xe</a></li>
						<li><a href="vi-VN/tuyen-dung"><div>
									<img width="20" class="right-icon"
										src="${pageContext.request.contextPath}/public/images/icon-candidate.png">
								</div>Tuyển dụng</a></li>
						<li><a href="../https@blog.vexere.com/default.htm"><div>
									<img width="20" class="right-icon"
										src="${pageContext.request.contextPath}/public/images/blog.svg">
								</div>Blog</a></li>
						<li><a href="vexetet"><img style="height: 24px;"
								src="${pageContext.request.contextPath}/public/images/landingpagetet2018/tet-hoa-mai-2019.png@v=206">Vé
								Xe Tết 2019</a></li>
					</ul>
				</div>

			</div>
		</div>
	</nav>
	<li
		class="ticket-booking-details ticket-booking-detail-seat-selection col-12 col-md-12 col-xs-12"
		style="margin-top: 85px; padding: 0px;">
		<div class="container">
			<div class="booking-expand  clearfix">
					<span class="pickup-list-count" style="display: none;"> 1 </span>
					<div class="seat-template-table table-noborder mb0">
						<div class="title-seat">
							<div class="col-md-4 col-lg-4" style="position: relative;">
								1 - CHỌN CHỖ <span
									class="btn btn-close-road hidden-lg hidden-md"><img
									alt=""
									src="${pageContext.request.contextPath}/public/chooseSeat/Content/vxr/images/closed-white.svg"></span>
							</div>
							<div class="col-md-4 col-lg-4">2 - THÔNG TIN ĐIỂM ĐI,ĐIỂM ĐẾN</div>
							<div class="col-md-4 col-lg-4">
								3 - THÔNG TIN KHÁCH HÀNG <span
									class="btn btn-close-road btn-close-road-phone"><img
									alt=""
									src="${pageContext.request.contextPath}/public/chooseSeat/Content/vxr/images/closed.svg"></span>
							</div>
						</div>

						<div class="detail-booking"
							style="height: 358px; min-height: 370px;">

							<div class="col-md-4 col-lg-4  seat-template-col"
								style="margin-bottom: 0px; min-height: 370px;">
								<table class="color-seat table table-noborder mb0"
									style="background: rgb(232, 232, 232);">
									<tbody>
										<tr class="seat-guid-row"
											style="border-bottom-color: rgb(221, 221, 221); border-bottom-width: 1px; border-bottom-style: solid;">
											<td>
												<p class="mb0">
												<div class="ml5"
													style="border: 1px solid rgb(145, 145, 145); width: 15px; height: 15px; margin-right: 5px; float: left; display: inline-block; background-color: rgb(255, 255, 255);"></div>
												<span style="float: left;">Ghế trống</span>
												<p></p>
											</td>
											<td>
												<p class="mb0">
												<div class="ml5"
													style="border: 1px solid rgb(207, 207, 207); width: 15px; height: 15px; margin-right: 5px; float: left; display: inline-block; background-color: rgb(207, 207, 207);"></div>
												<span style="float: left;">Ghế không bán</span>
												<p></p>
											</td>
											<td>
												<p class="mb0">
												<div class="ml5"
													style="border: 1px solid rgb(186, 223, 65); width: 15px; height: 15px; margin-right: 5px; float: left; display: inline-block; background-color: rgb(186, 223, 65);"></div>
												<span style="float: left;">Đang chọn</span>
												<p></p>
											</td>
										</tr>

									</tbody>
								</table>



								<%for(int f=1;f<=floorNum;f++){ %>
								<div class="cd-sodoghe mt10" style="margin-top: 10px;">
									<table width="100%" class="table-layout-sodoghe table mb0"
										border="0" cellspacing="0" cellpadding="0">
										<tbody">
											<% for(;i<maxI;i++){ 
													%><tr>
												<td width="40"></td>
												<% 
													
													for(int j=0;j<listGhe.get(0).size();j++)
													{
														if(listGhe.get(i).get(j).getTrangThai()==1)
														{
															if(listGhe.get(i).get(j).getTrangThaiDatVe()==1){
															%>
												<td>
													<div title="" class="cd-ghe   seat-available" id="seatId1"
														data-toggle="tooltip" data-placement="top"
														data-groupindex="1" data-groupname="Ghế mặc định"
														data-seatfare="1200000" floor-num="1" row-num="1"
														col-num="5" data-seatdiscount="0"
														data-originalfare="1200000" seat-code="4" seat-number="0"
														valueSp = "<%=listGhe.get(i).get(j).getVtHang() %>,<%=listGhe.get(i).get(j).getVtCot() %>,<%=listGhe.get(i).get(j).getTang() %>,<%=listGhe.get(i).get(j).getMaGhe() %>,<%=listGhe.get(i).get(j).getGiaGhe() %>"
														name="1" >
														<a href="javascript:;" 
																class="success"
																onclick="changeState(this,<%=i %>,<%=j %>,<%=listGhe.get(i).get(j).getTang()%>)"><span class="cd-so-ghe"><img
																class="img-responsive seat-img "
																style="max-height: 22px;"
																src="${pageContext.request.contextPath}/public/chooseSeat/Content/vxr/images/Route/seat-white-1.svg@v=11.svg"></span></a>
													</div>
												</td>

												<%}else{%>
												<td>
													<div title="" class="cd-ghe   seat-available" id="seatId1"
														data-toggle="tooltip" data-placement="top"
														data-groupindex="1" data-groupname="Ghế mặc định"
														data-seatfare="1200000" floor-num="1" row-num="1"
														col-num="5" data-seatdiscount="0"
														data-originalfare="1200000" seat-code="4" seat-number="0">
														<a href="javascript:;"
															name="0" disabled="true"
															value = "<%=listGhe.get(i).get(j).getVtHang() %>,<%=listGhe.get(i).get(j).getVtCot() %>,<%=listGhe.get(i).get(j).getTang() %>,<%=listGhe.get(i).get(j).getMaGhe() %>,<%=listGhe.get(i).get(j).getGiaGhe() %>"
														>
																<span class="cd-so-ghe">
																<img
																class="img-responsive seat-img"
																style="max-height: 22px;"
																src="${pageContext.request.contextPath}/public/chooseSeat/Content/vxr/images/Route/seat-gray-1.svg@v=11.svg"></span></a>
													</div>
												</td>
												<%}
														}else{
														%>
												<td></td>
												<%
														}
														
													}%>
											</tr>
											<%
												}
												maxI=listGhe.size();
												
												%>
										</tbody>
									</table>
								</div>
								<%} %>
								<div
									class="hidden-lg hidden-md hidden-sm body-buttom-mobi fix-review-price-mobi">
									<div class="fare-holder" data-reactid="52">
										 <span class="fr-holder">Tổng tiền <span
											class="seat-template-total-fare amount" >0</span></span>
									</div>
									<div class="btn-vxr-continue bt-step-1">Tiếp tục</div>
								</div>
								
								<!-- mobile -->
							</div>

							<div class="col-md-4 col-lg-4 td-info-detail hidden-xs"
								style="padding-top: 10px; border-right-color: rgb(238, 238, 238) !important; border-right-width: 1px !important; border-right-style: solid !important; min-height: 370px;">
								<div
									class="container-fluid customer-info-title hidden-lg hidden-md hidden-sm">
									<h4>2. THÔNG TIN ĐIỂM ĐI,ĐIỂM ĐẾN</h4>
								</div>
								<div class="detail-customer-info">

									<div class="detail-address detail-address-pc"
										style="height: 258px;">
										<div class="radio">
											<p class="list-title pickup-title">Điểm đón:</p>
											<ul class="pickup-transfer-list pickup-list">
												<li class="item-info pickup-item"> 
													<div class="address-row">
													<p><strong>11:31 - Đà Nẵng:</strong></p>
														<div class="col-md-12">
															
															<i class="fa fa-map-marker"></i>&nbsp;<span
																class="pickup-address"> Ngã tư túy loan QL14B Hòa
																Nhơn - Hoà Vang - Đà Nẵng</span>
														</div>
													</div>
													<div class="address-row">
													<p><strong>18:20 - Đà Nẵng:</strong></p>
														<div class="col-md-12">
															<i class="fa fa-map-marker"></i>&nbsp;<span
																class="pickup-address">Phú Yên</span>
														</div>
													</div>
													

													<div class="div-note"
														style="overflow: auto; padding-top: 6px; padding-left: 13px; display: none;">
														<div class="col-md-8 col-sm-8 pl0 pr0">
															<label class="info-note text-red"
																style="font-weight: normal;"></label>
														</div>
													</div>
													<div class="form-group div-address-unfixed"
														style="display: none;">
														<div class="col-md-12 col-sm-12"
															style="padding-right: 20px; padding-left: 36px !important;">
															<label
																class="col-md-12 pl0 pr0 col-sm-3 control-label text-left hidden-xs">Nhập
																địa chỉ điểm đón <span id="pickupNameSelected"></span>
															</label>
															<div class="col-md-9 col-sm-9 pr0 pl0">
																<input
																	class="address-unfixed-input form-control input-vxr"
																	type="text" placeholder="Nhập tối đa 240 kí tự"
																	value=""> <label
																	class="address-unfixed-input-validate-message text-red"
																	style="display: none;">Địa chỉ nhập vượt quá
																	240 kí tự. </label>
															</div>
															<div class="col-md-3 col-sm-3 pr0 pl0">
																<a class="btn btn-primary btn-address-done disabled"
																	id="btnDeparture"
																	style="height: 40px; padding-top: 9px;">Xong</a>
															</div>
														</div>
													</div></li>
											</ul>
										</div>
									</div>
								</div>

							</div>

							<div class="col-md-4 col-lg-4 customer-info-col">

								<div
									class="container-fluid customer-info-title hidden-lg hidden-md hidden-sm">
									<h4>THÔNG TIN KHÁCH HÀNG</h4>
									<span class="btn btn-close-road hidden-lg hidden-md"><img
										alt=""
										src="${pageContext.request.contextPath}/public/chooseSeat/Content/vxr/images/closed-white.svg"></span>
								</div>
								<div class="detail-customer-info">
									<div class="form-group CustomerFullName">
										<div class="col-md-12 col-sm-12 pl0 pr0">
											<label
												class="col-md-12 pl0 pr0 col-sm-3 control-label text-left multiple-info-note"
												style="display: none;">Thông tin hành khách 1:</label> <label
												class="col-md-12 pl0 pr0 col-sm-3 control-label text-left hidden-xs">Họ
												tên <span style="color: red;">*</span>:
											</label> <input name="CustomerFullName" tabindex="1"
												class="form-control input-vxr" id="cfn" type="text"
												placeholder="Họ tên" value="" data-toggle="popover"
												data-placement="top" data-content="Họ tên không hợp lệ">
											<p class="error-ms" id="name-error">Họ tên không hợp lệ</p>
										</div>
									</div>
									<div class="form-group">

										<div class="col-md-12 col-sm-12 pl0 pr0">
											<label
												class="col-md-8 pl0 pr0 control-label text-left hidden-xs">Số
												điện thoại người đi <span style="color: red;">*</span>:
											</label> <input name="CustomerPhone" tabindex="2"
												class="form-control input-vxr" id="cp"
												onkeypress="return isNumberByEventCode(event)" type="tel"
												placeholder="Số điện thoại Việt Nam của người đi: 0912345678"
												value="" data-toggle="popover" data-placement="left"
												data-content="Vui lòng nhập đúng định dạng (VD: 0912345678)">
											<p class="error-ms" id="phone-error">Vui lòng nhập đúng
												định dạng (VD: 0912345678)</p>
										</div>
									</div>
									<div class="form-group">
										<div class="col-md-12 col-sm-12 pl0 pr0">
											<label
												class="col-md-12 pl0 pr0 col-sm-3 control-label text-left hidden-xs"
												for="inputEmail3">Email <span style="color: red;">*</span>:
											</label> <input name="CustomerEmail" tabindex="3"
												class="form-control input-vxr" id="ce" type="text"
												placeholder="Email" value="" data-toggle="popover"
												data-placement="left" data-content="Email không hợp lệ">
											<p class="error-ms" id="email-error">Email không hợp lệ</p>
										</div>
									</div>
									<div class="form-group">
										<div class="col-md-12 col-sm-12 pl0 pr0">
											<label
												class="col-md-12 pl0 pr0 col-sm-3 control-label text-left hidden-xs"
												for="inputnote3">Ghi Chú:</label>

											<textarea name="note" tabindex="4"
												class="form-control input-vxr" id="note"
												placeholder="Các yêu cầu đặc biệt không thể được đảm bảo - nhưng nhà xe sẽ cố gắng hết sức để đáp ứng nhu cầu của bạn."
												type="text" value="">Các yêu cầu đặc biệt không thể được đảm bảo - nhưng nhà xe sẽ cố gắng hết sức để đáp ứng nhu cầu của bạn.</textarea>
										</div>
									</div>




									<div class="clearfix"></div>
								</div>
							</div>

						</div>
						<div class="detail-review" style="min-height: 105px;">
							<div class="col-md-4 col-lg-4 col-xs-12 col-sm-4  detail-total">
								<div class="col-md-12 col-xs-12"
									style="padding: 0px; min-height: 25px;">
									
								</div>

								<div class="col-md-12 col-xs-12" style="padding: 0px;">
									<span style="float: left;">Tổng tiền:</span>
									<div style="float: right;">
										<span class="seat-template-old-total-fare"
											style="font-size: 14px; text-decoration: line-through; margin-right: 10px;"></span>
										<h4 class="seat-template-total-fare amount"
											style="color: red; font-size: 20px;" id="totalMoney">0</h4>
										<small class="unit-price-small"
											style="color: red !important; text-decoration: underline; vertical-align: top;">đ</small>
									</div>
								</div>
							</div>
							<div class="col-md-4 col-lg-4 detail-review-route"></div>
							<div class="column-butom col-md-4 col-lg-4 col-xs-12">
								<div class="form-group mb0">
									
									<div class="col-md-12 col-sm-12 cont-container text-center hidden-xs">
									<html:form action="/bookTicket" method="post" onsubmit="submitForm();">
										<input type="hidden" name="chairLayoutJson" id="json">
										<button class="cont-btn btn btn-vxr-lg btn-vxr-lg-action"
											type="submit" name="submit" value="submit">
											Tiếp tục <i class="glyphicon glyphicon-chevron-right f14"></i>
										</button>
									</html:form>
									</div>
								</div>

							</div>
						</div>
					</div>

				<div class="foot-vxr-panel" style="height: 30px;"></div>
			</div>
		</div>
	</li>
	<script>
	function changeState(t,row,col,f)
	{
		var valueSp = t.parentElement.getAttribute("valueSp");
		var totalMoney = parseInt(document.getElementById("totalMoney").innerText);
		
		if (! t.classList.contains('success') ){
			
			t.classList.add('success');
			t.name=1;
			t.classList.remove('mark-ticket');
			t.childNodes[0].childNodes[0].src=t.childNodes[0].childNodes[0].src.replace("green","white");sô
			totalMoney-=parseInt((valueSp.split(','))[4]);
			
		}
		else{
			t.childNodes[0].childNodes[0].src=t.childNodes[0].childNodes[0].src.replace("white","green");
			t.classList.remove('success');
			t.name=0;
			t.classList.add('mark-ticket');
			totalMoney+=parseInt((valueSp.split(','))[4]);
		}
		document.getElementById("totalMoney").innerText = totalMoney;
	}
	function submitForm()
	{
		var json = new Object();
		var chairsArr=[];
		//var jsonString= JSON.stringify(obj);
		var chairs = document.getElementsByClassName("mark-ticket");
		
		console.log(chairs);
		for(var i=0;i<chairs.length;i++)
		{
			var valueSp = chairs[i].parentElement.getAttribute("valueSp");
			 var chair  =valueSp.split(',');
			 var obj = new Object();
			   obj.vtHang = chair[0];
			   obj.vtCot  = chair[1];
			   obj.trangThai = chairs[i].parentElement.getAttribute("name");
			   obj.tang = chair[2];
			   obj.maGhe = chair[3];
			   obj.giaGhe = chair[4];
			 chairsArr.push(obj);
		}
		json.listGhe= chairsArr;
		console.log(JSON.stringify(json));
		document.getElementById("json").value= JSON.stringify(json);
		console.log(document.getElementById("json").value);
	}
	</script>
</body>
</html>