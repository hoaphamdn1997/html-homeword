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

    <title>Sửa thông tin xe</title>

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
		<%@ include file="/pages/partion/NewSideBarUser.jsp"%>
        <!-- Headers-->
        <%@ include file="/pages/partion/NewHeaderAdmin.jsp"%>
        <!-- /End Headers -->

        <!-- page content -->
        <div class="right_col" role="main">
        <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>Sửa thông tin xe</h3>
              </div>

              <div class="title_right">
                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
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
              
             	<div class="container" >
		<div class="row">
			<div class="col-md-3">
			</div>
			<div class="col-md-6">
			<html:form styleClass="form-horizontal" action="user/editBus">
			<div class="form-group">
				<label class="control-label col-sm-2" for="email">Tên Xe:</label>
				<div class="col-sm-10">
					<html:text styleClass="form-control" property="tenXe"></html:text>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Biển Số:</label>
				<div class="col-sm-10">
					<html:text styleClass="form-control"
						property="bienSo"></html:text>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Loại Xe: </label>
				<div class="col-sm-10">
					<select name="maLoaiXe" class=" form-control select-tag" id="selectType">
						<logic:iterate name="busForm" property="listBusType"
							id="type">
							<bean:define id="maLoaiXe" name="type" property="maLoaiXe"></bean:define>
							  <option value="${maLoaiXe}"><bean:write name="type" property="tenLoaiXe"/></option>
						</logic:iterate>
					</select>
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" name="submit" value="submit" class="btn btn-success">Sửa</button>
				</div>
			</div>
			<html:hidden name="busForm" property="maXe"/>
		</html:form>
			</div>
		</div>
	</div>
	<html:hidden name="busForm" property="maLoaiXe" styleId="typeValue"/>
	<script>
		$(document).ready(function(){
			var selectedValue = document.getElementById("typeValue").value;
			document.getElementById("selectType").value = selectedValue;
		});
		
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
    <script src="${pageContext.request.contextPath}/public/src/vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="${pageContext.request.contextPath}/public/src/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- morris.js -->
    <script src="${pageContext.request.contextPath}/public/src/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
    
    <!-- Custom Theme Scripts -->
    <script src="${pageContext.request.contextPath}/public/src/build/js/custom.min.js"></script>

  </body>
</html>