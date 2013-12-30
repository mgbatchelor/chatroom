<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="header.jsp" />
<div class="container">
	<!-- Main component for a primary marketing message or call to action -->
	<div class="jumbotron">
		<h1>NationBuilder Programming Challenge</h1>
		<p>This is my implementation of the chatroom interface. The user
			has the ability to view the events that occurred in the chatroom
			ordered by timestamp. The user also has the ability to view the event
			summary that groups the events by 'Minute of Hour', 'Hour of Day', or
			'Full Day Summary'</p>
		<p>
			<a href='<c:url value="/join/nb"/>' class="btn btn-lg btn-primary">Enter
				chatroom</a>
		</p>
	</div>
	<div class="row">
		<div class="col-lg-4 col-sm-4">
			<div class="panel panel-default">
				<div class="panel-body">
					<h4>H2 In-memory Database</h4>
					<p>Persists the data in a database that can be access through a
						basic JDBC connection.</p>
					<P>
						<a target="_blank" href='<c:url value="/console"/>'
							class="btn btn-primary btn-sm">Open the database console</a>
					</P>
				</div>
			</div>
		</div>
		<div class="col-lg-4 col-sm-4">
			<div class="panel panel-default">
				<div class="panel-body">
					<h4>Spring MVC</h4>
					<p>Spring MVC provides the model-view-controller architecture
						to the web application.</p>
				</div>
			</div>
		</div>
		<div class="col-lg-4 col-sm-4">
			<div class="panel panel-default">
				<div class="panel-body">
					<h4>Twitter Bootstrap</h4>
					<p>Provides the user interface styling and 'responsive' design.</p>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-4 col-sm-4">
			<div class="panel panel-default">
				<div class="panel-body">
					<h4>Amazon Elasic Beanstalk</h4>
					<p>Provides the environment to deploy the web application to
						the Tomcat container in the cloud.</p>
				</div>
			</div>
		</div>

	</div>
</div>
<jsp:include page="footer.jsp" />

