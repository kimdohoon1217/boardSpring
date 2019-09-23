<%@page import="kr.or.ddit.board.model.BoardVo"%>
<%@page import="kr.or.ddit.board.service.BoardServiceImpl"%>
<%@page import="kr.or.ddit.board.service.IBoardService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

   <ul class="nav nav-sidebar">
   		<li class="active"><a href="${cp }/addBoard">게시판 생성 <span class="sr-only">(current)</span></a></li>
   		<br>
        <c:forEach items="${boardList }" var="list">
        	<c:if test="${list.useStatus == 'Y' }">
 		       	<li class="active"><a href="${cp }/post?boardNum=${list.boardNum}&boardNm=${list.boardNm}">${list.boardNm} <span class="sr-only">(current)</span></a></li>
        	</c:if>
        </c:forEach>
   </ul>