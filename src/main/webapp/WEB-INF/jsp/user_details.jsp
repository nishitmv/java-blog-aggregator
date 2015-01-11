<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../layouts/taglib.jsp" %>

<h1>${user.name}</h1>




<c:forEach items="${user.blogs}" var="blog">
<h3>${blog.name}</h3>
<p>${blog.url}</p>
<c:forEach items="${blog.items}" var="item">
<table class="table table-bordered table-hover table-striped">
<thead>
<tr>
<th>${item.title}</th>
</tr>
</thead>
<tbody>
<tr><td>${item.description}</td>
<tr><td>${item.link}</td></tr>
</tbody>
</table>
</c:forEach>

</c:forEach>
