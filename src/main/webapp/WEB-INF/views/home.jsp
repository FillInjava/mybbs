<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
 <link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
 <link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css" rel="stylesheet"> 
</head>
<body>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<h2 class="text-center">
				<em>Welcome!</em>
			</h2>
		</div>
	</div>
	<div class="row-fluid">
		<div class="span12">
			<ul class="nav nav-tabs">
				<li class="active">
					<a href="#">首页</a>
				</li>
				<li>
					<a href="#">资料</a>
				</li>
				<li class="disabled">
					<a href="#">信息</a>
				</li>
				<li class="dropdown pull-right">
					 <a href="#" data-toggle="dropdown" class="dropdown-toggle">下拉<strong class="caret"></strong></a>
					<ul class="dropdown-menu">
						<li>
							<a href="#">操作</a>
						</li>
						<li>
							<a href="#">设置栏目</a>
						</li>
						<li>
							<a href="#">更多设置</a>
						</li>
						<li class="divider">
						</li>
						<li>
							<a href="#">分割线</a>
						</li>
					</ul>
				</li>
			</ul>
			<div class="row-fluid">
				<div class="col-lg-2">
					<section>
					 	<div class="page-header">
					 		<h1>所有用户</h1>
					 	</div>
					 	<ol class="userList">
					 		<c:forEach items="${users}" var="user">
					 			<s:url value="/users/${user.username}" var="user_url">
					 				<s:param name="username" value="${user.name}"/>
					 			</s:url>
					 			<li>
					 				<a href="${user_url}">${user.name}</a>
					 			</li>
					 		</c:forEach>
					 	</ol>
					</section>
				</div>
				<div class="col-lg-10">
					<div class="page-header">
						<h1>
							用户登录
						</h1>
					</div>
					<form class="form-horizontal">
						<div class="control-group">
							 <label class="control-label" for="inputEmail">用户名：</label>
							<div class="controls">
								<input id="inputEmail" type="text" />
							</div>
						</div>
						<div class="control-group">
							 <label class="control-label" for="inputPassword">密码：</label>
							<div class="controls">
								<input id="inputPassword" type="password" />
							</div>
						</div>
						<div class="control-group">
							<div class="controls">
								 <label class="checkbox"><input type="checkbox" /> Remember me</label> 
								 <button type="submit" class="btn btn-primary">登陆</button>
								 <button type="submit" class="btn btn-default">重置</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
 <script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</body>
</html>