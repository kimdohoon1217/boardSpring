<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp-basicLib</title>

<%@ include file="/WEB-INF/views/commonJsp/basicLib.jsp"%>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<script>
	$(function(){
		if("${res }"){
			alert("${res }");
		}
	});
</script>
</head>

<body>

	<!-- header -->
	<%@ include file="/WEB-INF/views/commonJsp/header.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">

				<%@ include file="/WEB-INF/views/commonJsp/left.jsp"%>

			</div>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<form class="form-horizontal" role="form" action="${cp }/addBoard" method="post">
					<div class="form-group">
						<label for="board" class="col-sm-2 control-label">게시판 이름</label>
						<div class="col-sm-2">
							<input type="text" name="boardNm" class="form-control"/>
						</div>
						<div class="col-sm-1">
							<select name="useStatus" class="form-control">
								<option>사용</option>
								<option>미사용</option>
							</select>
						</div>
						<div class="col-sm-2">
							<input type="submit" name="btnValue" class="btn btn-default" value="생성">
						</div>
					</div>
				</form>

				<c:forEach items="${boardList }" var="list">
					<form class="form-horizontal" role="form" action="${cp }/addBoard" method="post">
						<div class="form-group">
							<input type="hidden" name=boardNum value="${list.boardNum}"/>
							<label for="board" class="col-sm-2 control-label">게시판 이름</label>
							<div class="col-sm-2">
								<input type="text" name="boardNm" class="form-control" value="${list.boardNm }"/>
							</div>
							<div class="col-sm-1">
								<select name="useStatus" class="form-control">
									<c:choose>
										<c:when test="${list.useStatus == 'Y' }">
											<option selected>사용</option>
											<option>미사용</option>
										</c:when>
										<c:when test="${list.useStatus == 'N' }">
											<option>사용</option>
											<option selected>미사용</option>
										</c:when>
									</c:choose>
								</select>
							</div>
							<div class="col-sm-2">
								<input type="submit" name="btnValue" class="btn btn-default" value="수정">
							</div>
						</div>
					</form>
				</c:forEach>

			</div>
		</div>
	</div>
</body>
</html>