<%@page import="javax.servlet.http.HttpSession"%>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<nav class="header-blue" style="min-height: 90px;">
        <div class="container">
            <div class="row">
                <div class="col-md-3">
                        <a class="logo-image" href="${pageContext.request.contextPath}"><img height="70" src="${pageContext.request.contextPath}/public/images/bus_new.jpg"></a>
                    <ul class="header-action-bar visible-sm visible-xs">
                        <li><a class="menu-action" href="#"><i class="fa fa-bars"></i></a></li>
                    </ul>
                </div>
                <div id="overlay-layout" style="width: 100%; height: 100%; margin-top: 7px; display: none; position: fixed; z-index: 99; opacity: 0.7; background-color: rgb(166, 166, 166);">
                </div>
                <div class="col-md-9 header-blue-right-menu pl0">
                    <ul class="header-blue-menu-list">
                         <li><a href="${pageContext.request.contextPath}/transporter/register.do">Đăng ký nhà xe</a></li> 
                        <li><a href="${pageContext.request.contextPath}/ticket/info.do">Kiểm tra vé</a></li>
                            <li><a href="${pageContext.request.contextPath}">Trang chủ</a></li>
                    </ul>
                    <ul class="header-blue-menu-list">
                    		<%String username=(String)request.getSession().getAttribute("username");%>
                    		<%if(username==null||username.equals("")){ %>
                    		<li><a href="${pageContext.request.contextPath}/login.do">Đăng nhập</a></li>
                             <li><a href="${pageContext.request.contextPath}/register.do">Đăng ký</a></li>
                    		<%}else{ %>
                    		<li><a href="${pageContext.request.contextPath}/logout.do">Đăng xuất</a></li>
                    		<li><a href="${pageContext.request.contextPath}/account/changeInfo.do">Quản lý tài khoản</a></li>
                    		<%} %>
                            
                    </ul>
                   
                </div>

                <%-- <div class="col-md-9 header-blue-right-menu header-blue-right-menu-mobile hidden-lg hidden-md" style="display: block;">
                    <ul class="header-blue-menu-list">
                            <li><a class="header-blue-language en-change" href="javascript:" data-href="/vi-VN/Language/ChangeLanguage?changelang=en&amp;url=/"><div><img class="right-icon" style="width: 20px;" src="${pageContext.request.contextPath}/public/images/icon-english.svg"></div>English</a></li>
                            <li><a class="header-blue-language vi-change" href="javascript:" data-href="/vi-VN/Language/ChangeLanguage?changelang=vn&amp;url=/"><div><img class="right-icon" style="width: 20px;" src="${pageContext.request.contextPath}/public/images/icon-tieng-viet.svg"></div>Tiếng Việt</a></li>
                            <li><div style="width: 100%; height: 1px; background-color: rgb(166, 166, 166);"></div></li>
                        
                            <li><a href="default.htm"><div><img class="right-icon" style="width: 20px;" src="${pageContext.request.contextPath}/public/images/icon-home.svg"></div>Trang chủ</a></li>

                        <li><a href="vi-VN/booking/ticketinfo"><div><img class="right-icon" style="width: 20px;" src="${pageContext.request.contextPath}/public/images/icon-scope.svg"></div>Kiểm tra vé</a></li>
                        <li><a href="vi-VN/booking/cancelticket"><div><img class="right-icon" style="width: 20px;" src="${pageContext.request.contextPath}/public/images/icon-scope.svg"></div>Hủy vé</a></li>

                            <li><a href="vi-vn/phan-mem-quan-ly-ban-ve-xe-khach-vexere.html"><div><img width="20" class="right-icon" src="${pageContext.request.contextPath}/public/images/icon-bms.svg"></div>Phần mềm hãng xe</a></li>
                            <li><a href="vi-VN/tuyen-dung"><div><img width="20" class="right-icon" src="${pageContext.request.contextPath}/public/images/icon-candidate.png"></div>Tuyển dụng</a></li>
                            <li><a href="../https@blog.vexere.com/default.htm"><div><img width="20" class="right-icon" src="${pageContext.request.contextPath}/public/images/blog.svg"></div>Blog</a></li>
                            <li>
                                <a href="vexetet"><img style="height: 24px;" src="${pageContext.request.contextPath}/public/images/landingpagetet2018/tet-hoa-mai-2019.png@v=206">Vé Xe Tết 2019</a>
                            </li>
                    </ul>
                </div> --%>

            </div>
        </div>
    </nav>