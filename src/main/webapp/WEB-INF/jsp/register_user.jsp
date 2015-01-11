<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="../layouts/taglib.jsp" %>

<c:if test="${param.success eq true}">
<div class="alert alert-success">Registration Successful</div>
</c:if>

<sf:form commandName="user" method="post" class="form-horizontal">
<div class="form-group">
<label for="name" class="col-sm-2 control-label">Name:</label>
<div class="col-sm-10">
<sf:input path="name" cssClass="form-control"/>
</div>
</div>
<div class="form-group">
<label for="email" class="col-sm-2 control-label">EMail:</label>
<div class="col-sm-10">
<sf:input path="email" cssClass="form-control"/>
</div>
</div>
<div class="form-group">
<label for="password" class="col-sm-2 control-label">Password:</label>
<div class="col-sm-10">
<sf:password path="password" cssClass="form-control"/>
</div>
</div>
<div class="form-group">
<div class="col-sm-2">
<input type="submit" value="save" class="btn btn-primary btn-lg"/>
</div>
</div>
</sf:form>