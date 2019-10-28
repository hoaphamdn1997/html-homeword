<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%if(request.getSession().getAttribute("role")==null||(Integer)request.getSession().getAttribute("role")!=0) response.sendRedirect(request.getContextPath()+"/pages/404.jsp");%>
<div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="${pageContext.request.contextPath}/admin/listUser.do" class="site_title"><i class="fa fa-bus"></i> <span>HireABus.com</span></a>
            </div>

            <div class="clearfix"></div>

          
            <br />

            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <h3>Menu</h3>
                <ul class="nav side-menu">
                  <li><a href="${pageContext.request.contextPath}/admin/listUser.do"><i class="fa fa-user"></i>Danh Sách Người Dùng<span ></span></a>
                    
                  </li>
                  <li><a href="${pageContext.request.contextPath}/admin/listPenddingUser.do"><i class="fa fa-users"></i> Danh Sách Phê duyệt <span ></span></a>
                    
                  </li>
                  <li><a href="${pageContext.request.contextPath}/admin/listBusType.do"><i class="fa fa-bus"></i> Danh Sách Loại Xe <span ></span></a>
                    
                  </li>
                 
                 
                </ul>
              </div>
             

            </div>
          
          </div>
        </div>