<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%if(request.getSession().getAttribute("role")==null||(Integer)request.getSession().getAttribute("role")!=1) response.sendRedirect(request.getContextPath()+"/pages/404.jsp");%>

<div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="${pageContext.request.contextPath}/user/listBus.do" class="site_title"><i class="fa fa-bus"></i> <span>HireABus.com</span></a>
            </div>

            <div class="clearfix"></div>

          
            <br />

            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <h3>Menu</h3>
                <ul class="nav side-menu">
                  <li><a>
                  <i class="fa fa-bus"></i>Quản Lý Xe<span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="${pageContext.request.contextPath}/user/listBus.do">Danh Sách Xe</a></li>
                      <li><a href="${pageContext.request.contextPath}/user/addNewBus.do">Thêm Mới Xe</a></li>
                      <li><a href="${pageContext.request.contextPath}/user/setLayout.do">Quản lý layout ghế xe</a></li>
                    </ul>
                  </li>
                  <li><a><i class="fa fa-road"></i> Quản Lý Chuyến Xe <span class="fa fa-chevron-down" ></span></a>
                    <ul class="nav child_menu">
                      <li><a href="${pageContext.request.contextPath}/user/listBuses.do">Danh Sách Chuyến Xe</a></li>
                      <li><a href="${pageContext.request.contextPath}/user/addNewBuses.do">Thêm Mới Chuyến Xe</a></li>
                    </ul>
                  </li>
                  <li><a href="${pageContext.request.contextPath}/user/listTicket.do">
                  <i class="fa fa-ticket"></i> Quản Lý Vé Xe <span ></span></a>
                    
                  </li>
                 
                 
                </ul>
              </div>
             

            </div>
          
          </div>
        </div>