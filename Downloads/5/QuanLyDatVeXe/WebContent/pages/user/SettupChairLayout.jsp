<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@page import="model.bean.Ghe"%>
<%@page import="model.bean.Bus"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Tùy chỉnh ghế xe</title>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/public/src/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="${pageContext.request.contextPath}/public/src/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="${pageContext.request.contextPath}/public/src/build/css/custom.min.css" rel="stylesheet">

<link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/style-customize.css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.11.2.min.js"></script>
<style type="text/css">
	.bus-container {
	border:1px solid black; 
	border-radius:5px; 
	padding:10px;
}
.chair{
	  display: inline-block;
	  margin-bottom: 0;
	  font-weight: normal;
	  text-align: center;
	  white-space: nowrap;
	  vertical-align: middle;
	  -ms-touch-action: manipulation;
	  touch-action: manipulation;
	  cursor: pointer;
	  background-image: none;
	  border: 1px solid transparent;
	  padding: 6px 12px;
	  font-size: 14px;
	  line-height: 1.42857143;
	  border-radius: 4px;
	  -webkit-user-select: none;
	  -moz-user-select: none;
	  -ms-user-select: none;
	  user-select: none;
	  margin-right:3px;
	  margin-bottom:5px;
	  width:60px;
	  height:40px;
	
	}
.non-chair{
	display: inline-block;
	  margin-bottom: 0;
	  font-weight: normal;
	  text-align: center;
	  white-space: nowrap;
	  vertical-align: middle;
	  -ms-touch-action: manipulation;
	  touch-action: manipulation;
	  cursor: pointer;
	  background-image: none;
	  padding: 6px 12px;
	  font-size: 14px;
	  line-height: 1.42857143;
	  border-radius: 4px;
	  -webkit-user-select: none;
	  -moz-user-select: none;
	  -ms-user-select: none;
	  user-select: none;
	  margin-right:3px;
	  margin-bottom:5px;
	  width:60px;
	  height:40px;
}
</style>
  </head>

  <body class="nav-md"  onload = "initMaXe()">
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
                <h3>Tùy chỉnh ghế xe</h3>
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
			<div class="col-md-5 col-md-offset-1">
			 <div class="form-group">
			    <label class="control-label col-md-3" for="email">Chọn Xe:</label>
			    
			    <div class="col-md-9">
			      <select class="form-control" onchange="changeBus(this)"
						id="selectMaXeHienTai">
						<%ArrayList<Bus> listBus =  (ArrayList<Bus>)request.getAttribute("listBus");%>
						<%for(int i=0;i<listBus.size();i++){ %>
						<option value="<%=listBus.get(i).getMaXe()%>"><%=listBus.get(i).getTenXe()%></option>
						<%} %>
					</select>
			    </div>
			  </div>
			</div>
			<div class="col-md-6"></div>
		</div>
		<br>
		<br>
		<% ArrayList<ArrayList<Ghe>> listGhe = (ArrayList<ArrayList<Ghe>>)request.getAttribute("listGheMatrix");%>
		<div class="row">
		<%int floorNum = (Integer)request.getAttribute("soTang"); %>
		<%
			int i=0;
			int maxI=listGhe.size();
			if(floorNum==2) maxI/=2;
		%>
			<div class="col-md-<%=11-floorNum %> col-md-offset-2" id="parent-container" style="margin-bottom:10px;">
			<%for(int f=1;f<=floorNum;f++){ %>
			<div class="bus-container" id="bus-container">
				<% for(;i<maxI;i++){ 
					for(int j=0;j<listGhe.get(0).size();j++)
					{
						if(listGhe.get(i).get(j).getTrangThai()!=-1)
						{
							if(listGhe.get(i).get(j).getTrangThai()==1){
							%>
								<button class="chair btn-success" onclick="changeState(this,<%=i %>,<%=j %>,<%=listGhe.get(i).get(j).getTang()%>)" name="1"
								value = "<%=listGhe.get(i).get(j).getVtHang() %>,<%=listGhe.get(i).get(j).getVtCot() %>,<%=listGhe.get(i).get(j).getTang() %>"
								style="border :none; background: url(${pageContext.request.contextPath}/public/chooseSeat/Content/vxr/images/Route/seat-white-1.svg@v=11.svg) no-repeat;"
								></button>
							
							<%}else{%>
								<button class="chair" onclick="changeState(this,<%=i %>,<%=j %>,<%=listGhe.get(i).get(j).getTang()%>)" name="0"
								value = "<%=listGhe.get(i).get(j).getVtHang() %>,<%=listGhe.get(i).get(j).getVtCot() %>,<%=listGhe.get(i).get(j).getTang() %>"
								style="border :none; background: url(${pageContext.request.contextPath}/public/chooseSeat/Content/vxr/images/Route/seat-gray-1.svg@v=11.svg) no-repeat;"
								></button>
							<%}
						}else{
						%>
							<div class="non-chair" ><button class="chair" style="display:none" class="non-char-btn" name="-1"
							value = "<%=listGhe.get(i).get(j).getVtHang() %>,<%=listGhe.get(i).get(j).getVtCot() %>,<%=listGhe.get(i).get(j).getTang() %>"></button></div>
						<%
						}
					}
					%><br><%
				}
				maxI=listGhe.size();
				
				%>
				
				</div>
				
				<br>
				<%} %>
			</div>
			
		</div>
		<div class="row" align="center">
			<html:form action="/user/setLayout" method="post" onsubmit="submitForm();" styleId="chairLayoutForm">
				<html:hidden property="maXeHienTai" styleId="maXeHienTai"></html:hidden>
				<input type="hidden" name="chairLayoutJson" id="json">
				<button type="submit" name="submit" value="submit" id="submit" class="btn btn-success">Lưu</button>
				<a  class="btn btn-default" onclick="return window.location.replace('${pageContext.request.contextPath}/user/listBus.do')">Hủy</a>
			</html:form>
		</div>
	</div>
	<script>
		
		function changeState(t,row,col,f)
		{
			
			if (! t.classList.contains('btn-success') ){
				t.classList.add('btn-success');
				t.name=1;
				t.style.backgroundImage=t.style.backgroundImage.replace("gray","white");
			}
			else{
				t.classList.remove('btn-success');
				t.name=0;
				t.style.backgroundImage=t.style.backgroundImage.replace("white","gray");
			}
		}
		function submitForm()
		{
			var json = new Object();
			var chairsArr=[];
			//var jsonString= JSON.stringify(obj);
			var chairs = document.getElementsByClassName("chair");
			console.log(chairs.length);
			for(var i=0;i<chairs.length;i++)
			{
				 var chair  =chairs[i].value.split(',');
				 var obj = new Object();
				   obj.vtHang = chair[0];
				   obj.vtCot  = chair[1];
				   obj.trangThai = chairs[i].name;
				   obj.tang = chair[2];
				 chairsArr.push(obj);
			}
			/* var nonchairs = document.getElementsByClassName("non-char-btn");
			for(var i=0;i<nonchairs.length;i++)
			{
				 var chair1  =nonchairs[i].value.split(',');
				 var obj1 = new Object();
				   obj1.vtHang = chair1[0];
				   obj1.vtCot  = chair1[1];
				   obj1.trangThai = nonchairs[i].name;
				   obj1.tang = chair1[2];
				 chairsArr.push(obj1);
			} */
			json.listGhe= chairsArr;
			document.getElementById("json").value= JSON.stringify(json);
			console.log(document.getElementById("json").value);
		}
		function changeBus(t)
		{
			document.getElementById("submit").value="changeBus";
			document.getElementById("maXeHienTai").value= document.getElementById("selectMaXeHienTai").value;
			document.getElementById("submit").click();
		}
		function initMaXe()
		{
			document.getElementById("selectMaXeHienTai").value=document.getElementById("maXeHienTai").value;
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
    <script src="${pageContext.request.contextPath}/public/src/vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="${pageContext.request.contextPath}/public/src/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- morris.js -->
    <script src="${pageContext.request.contextPath}/public/src/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
    
    <!-- Custom Theme Scripts -->
    <script src="${pageContext.request.contextPath}/public/src/build/js/custom.min.js"></script>

  </body>
</html>