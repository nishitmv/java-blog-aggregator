<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="../layouts/taglib.jsp"%>

<h1>${user.name}</h1>

<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal"
	data-target="#myModal">New Blog</button>
<sf:form commandName="blog" method="post" class="form-horizontal">
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">New Blog</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Name:</label>
						<div class="col-sm-10">
							<sf:input path="name" cssClass="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label for="url" class="col-sm-2 control-label">URL:</label>
						<div class="col-sm-10">
							<sf:input path="url" cssClass="form-control" />
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					

						<input type="submit" value="save" class="btn btn-primary btn-lg"/>
							
					</div>
				</div>
			</div>
		</div>
		</div>
</sf:form>
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
				<tr>
					<td>${item.description}</td>
				<tr>
					<td>${item.link}</td>
				</tr>
			</tbody>
		</table>
	</c:forEach>

</c:forEach>
