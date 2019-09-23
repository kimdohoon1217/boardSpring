<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<title>Jsp</title>

<%@ include file="/WEB-INF/views/commonJsp/basicLib.jsp" %>

</head>

<body>

<%@ include file="/WEB-INF/views/commonJsp/header.jsp" %>

<div class="container-fluid">
      <div class="row">
         
<div class="col-sm-3 col-md-2 sidebar">
   
   <%@ include file="/WEB-INF/views/commonJsp/left.jsp" %>
   
</div>

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            

<div class="blog-header">
   <h1 class="blog-title">Main<br>
   </h1>
   <p class="lead blog-description">Jsp / Spring.</p>
</div>

<div class="row">

   <div class="col-sm-8 blog-main">

      <div class="blog-post">
         <h2 class="blog-post-title">jsp</h2>
         <p class="blog-post-meta">
            2019.09.03, room 202
         </p>

         <p>jsp를 통한 게시판만들기</p>
         <hr>
         
         <h3>상세내역</h3>
         <ul>
            <li>로그인</li>
            <li>게시판 생성/수정</li>
            <li>게시글 출력/조회/작성/답글/수정/삭제</li>
            <li>댓글 작성/삭제</li>
            <li>첨부파일 등록/삭제</li>
            <li>pagination, 삭제된 게시글,댓글 처리 등등..</li>
         </ul>
      </div>
   </div>
   <!-- /.blog-main -->
</div>   </div>
      </div>
   </div>
</body>
</html>