<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Sửa thông tin loại xe</title>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/public/src/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="${pageContext.request.contextPath}/public/src/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="${pageContext.request.contextPath}/public/src/build/css/custom.min.css" rel="stylesheet">

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style-customize.css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.11.2.min.js"></script>
  </head>

  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <!--Side bar-->
		<%@ include file="/pages/partion/NewSideBar.jsp"%>
        <!-- Headers-->
        <%@ include file="/pages/partion/NewHeaderAdmin.jsp"%>
        <!-- /End Headers -->

        <!-- page content -->
        <div class="right_col" role="main">
        <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>Sửa thông tin loại xe</h3>
              </div>
				
              <div class="title_right">
                <div class="col-md-5 col-md-5 col-xs-12 form-group pull-right top_search">
                  <div class="input-group">
                    <input type="text" class="form-control" placeholder="Từ Khóa">
                    <span class="input-group-btn">
                      <button class="btn btn-default" type="button">Tìm Kiếm</button>
                    </span>
                  </div>
                </div>
              </div>
            </div>
             <div class="clearfix"></div>
              <div class="row">
              <div class="container">
		<html:form action="/admin/editBusType.do" method="post" styleClass="form-horizontal">
			<div class="row">
			<div class="col-md-10 col-md-offset-2">
				<div class="row">
					<div class="col-md-5 col-md-offset-2">
					<h4>Loại Xe: 
					<bean:write name="busTypeForm" property="tenLoaiXe"/>
					</h4></div>
				</div>
				
				<div class="row">
					<div class="form-group">
						<label class="control-label col-md-2" >Mã Loại Xe:</label>
						<div class="col-md-5">
							<html:text property="maLoaiXe" readonly="true" styleClass="form-control"></html:text>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group">
						<label class="control-label col-md-2" >Tên Loại Xe:</label>
						<div class="col-md-5">
							<html:text property="tenLoaiXe"  styleClass="form-control"></html:text>
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="form-group">
						<label class="control-label col-md-2" >Số Ghế:</label>
						<div class="col-md-5">
							<html:text property="soGhe"  styleClass="form-control"></html:text>
						</div>
					</div>
				</div>

				
				<div class="row">
					<div class="form-group">
						<label class="control-label col-md-2" >Số Tầng:</label>
						<div class="col-md-5">
							<html:text property="soTang"  styleClass="form-control"></html:text>
						</div>
					</div>
				</div>

				
				<div class="row">
					<div class="form-group">
						<label class="control-label col-md-2" >Mô tả:</label>
						<div class="col-md-5">
							<html:text property="moTa"  styleClass="form-control"></html:text>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group">
						
						<div class="col-md-3 col-md-offset-2">
							<input class="btn btn-success" type="submit" value="Sửa thông tin" name="submit">
						</div>
					</div>
				</div>

			</div>
			</div>

			

		</html:form>
	</div>

              
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
    <script src="${pageContext.request.contextPath}/public/src/vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="${pageContext.request.contextPath}/public/src/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- morris.js -->
    <script src="${pageContext.request.contextPath}/public/src/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
    
    <!-- Custom Theme Scripts -->
    <script src="${pageContext.request.contextPath}/public/src/build/js/custom.min.js"></script>

  </body>
</html>