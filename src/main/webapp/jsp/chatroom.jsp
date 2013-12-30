<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp" />
<div class="container">
	<div>
		<h2>NationBuilder Chatroom</h2>
		<div class="row">
			<div class="col-lg-3">
				<div class="panel panel-default">
					<div class="panel-heading">Chatroom Members (${userCount})</div>
					<div class="panel-body">
						<ul class="media-list">
							<c:forEach var="username" items="${users}">
								<li class="media">
									<div class="media-body">
										<span class="glyphicon glyphicon-user pull-left"></span>&nbsp;
										<c:out value="${username}" />
										<span class="glyphicon glyphicon-hand-up pull-right"></span>
									</div>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<button class="btn btn-danger" style="width: 100%; margin-bottom: 20px">Leave
					Chatroom</button>
			</div>
			<div class="col-lg-9">
				<div class="row">
					<div class="col-lg-6 col-sm-6">
						<div class="btn-group">
							<a href='<c:url value="/join/nb"/>'
								class="btn btn-primary btn-sm ${history}">History</a> <a
								href='<c:url value="/join/nb?sort=s&range=hour"/>'
								class="btn btn-primary btn-sm ${summary}">Event Summary</a>
						</div>
					</div>
					<c:if test="${summary != null}">
						<div class="col-lg-6 col-sm-6" style="text-align: right">
							Range:
							<div class="btn-group">
								<a href='<c:url value="/join/nb?sort=s&range=minute"/>'
									class="btn btn-sm ${minute}">Minute</a> <a
									href='<c:url value="/join/nb?sort=s&range=hour"/>'
									class="btn btn-sm ${hour}">Hour</a> <a
									href='<c:url value="/join/nb?sort=s&range=day"/>'
									class="btn btn-sm ${day}">Day</a>
							</div>
						</div>
					</c:if>
				</div>
				<div class="row-fluid" style="margin-top: 10px">
					<div class="panel panel-default">
						<div class="panel-body"
							style="height: 400px !important; overflow: scroll;">
							<ul class="media-list">
								<c:forEach var="event" items="${events}">
									<li class="media">
										<div class="media-body">${event}</div>
									</li>
								</c:forEach>
							</ul>
						</div>
						<div class="input-group">
							<input type="text" class="form-control"
								placeholder="Send a message..." /> <span
								class="input-group-btn">
								<button class="btn btn-primary">Comment</button>
							</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="footer.jsp" />