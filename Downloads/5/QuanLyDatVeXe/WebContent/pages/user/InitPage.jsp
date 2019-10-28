<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<meta charset="UTF-8">
<title>Khởi tạo</title>

</head>
<body>
	<%@ include file="/pages/partion/HeaderUser.jsp"%>
	<div class="container">
		<div class="col-md-4"></div>
		<div class="col-md-4">
			<ul class="nav nav-tabs">
				<li class="active"><a data-toggle="tab" href="#home">Chọn
						Nhà Xe</a></li>
				<li><a data-toggle="tab" href="#menu1">Tạo Mới Nhà Xe</a></li>
			</ul>
			<div class="tab-content">
				<div id="home" class="tab-pane fade in active">
					<h3>Chọn nhà xe bạn đang quản lý</h3>
					<select class="form-control" >
					    <option>Nhà Xe Hải Vân</option>
					    <option>Nhà Xe Mai Vy</option>
					  </select>
				</div>
				<div id="menu1" class="tab-pane fade">
					<h3>Tạo mới nhà xe</h3>
					<div class="form-group">
					<input type="text" class="form-control" placeholder="Nhập tên nhà xe của bạn"/>
					<br>
					<button class="btn btn-success" align="center">Tạo Nhà Xe</button>
					</div>
				</div>
				
			</div>
		</div>
	</div>
	</div>
</body>
</html>