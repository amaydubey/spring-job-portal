<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org"
	xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
	layout:decorator="layout/template">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<head>

<meta charset="utf-8">
<meta name="author" content="">
<title>Search jobs | FindJobs.com</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style type="text/css">
#requirements {
	margin-top: 10px;
	padding-top: 50px;
	padding-bottom: 50px;
	color: #fff;
	background-color: #3F729B;
}

#team {
	margin-top: 10px;
	padding-top: 50px;
	padding-bottom: 50px;
	color: #fff;
	background-color: #2E2E2E;
}

.jumbotron {
	margin-bottom: 10px;
}

.a1{
	font-size: 24px;
}
/* Full-width input fields */
input[type=text], input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

.results {
	margin: 0px 100px 0px 100px;
	padding: 50px 100px 10px 100px;
	border-right: 1px solid #bdbdbd;
	border-left: 1px solid #bdbdbd;
}
/* Set a style for all buttons */
button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}

button:hover {
	opacity: 0.8;
}

/* Extra styles for the cancel button */
.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #f44336;
}

/* Center the image and position the close button */
.imgcontainer {
	text-align: center;
	margin: 24px 0 12px 0;
	position: relative;
}

.groups{
	line-height: 90%;
}

img.avatar {
	width: 10%;
	border-radius: 50%;
}

.container {
	padding: 16px;
}

span.psw {
	float: right;
	padding-top: 16px;
}

/* The Modal (background) */
.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
	padding-top: 60px;
}

/* Modal Content/Box */
.modal-content {
	background-color: #fefefe;
	margin: 5% auto 15% auto;
	/* 5% from the top, 15% from the bottom and centered */
	border: 1px solid #888;
	width: 40%; /* Could be more or less, depending on screen size */
}

/* The Close Button (x) */
.close {
	position: absolute;
	right: 25px;
	top: 0;
	color: #000;
	font-size: 35px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: red;
	cursor: pointer;
}

/* Add Zoom Animation */
.animate {
	-webkit-animation: animatezoom 0.6s;
	animation: animatezoom 0.6s
}

@
-webkit-keyframes animatezoom {
	from {-webkit-transform: scale(0)
}

to {
	-webkit-transform: scale(1)
}

}
@
keyframes animatezoom {
	from {transform: scale(0)
}

to {
	transform: scale(1)
}

}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 100%;
	}
}

.row.vertical-divider {
	overflow: hidden;
}

.row.vertical-divider>div[class^="col-"] {
	text-align: center;
	padding-top: 5%;
	/*padding-bottom: 100px;*/
	margin-top: 30px;
	/*margin-bottom: -100px;*/
	border-left: 3px solid #689f38;
	border-right: 3px solid #689f38;
}

.row1 {
	overflow: hidden;
}

.row2 {
	margin-bottom: -99999px;
	padding-bottom: 99999px;
}

body {
	padding-top: 20px;
	padding-bottom: 20px;
}
</style>




</head>

<body id="pagetop">

	<div class="container-fluid">

		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="/findjobs">FindJobs.com</a>
				</div>
				<ul class="nav navbar-nav navbar-right">
					<li class="active"><a href="#team">Team</a></li>

					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">logged in as
							${seeker.firstName} <span class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<li><a href="/userprofile/${seeker.jobseekerId}">Profile</a></li>
							<li><a href="/findjobs">Logout</a></li>
						</ul></li>
				</ul>
			</div>
		</nav>

		<div class="jumbotron">
			<div class="container text-center">


				<h2>Search jobs</h2>

			</div>
		</div>

		<div class="well">
			<form class="form-inline row well" style="margin: 5px"
				action="/searchjobs" method="get">
				<div class="col-sm-12">
					<label  for="cname">Search</label> <input
						type="text" class="form-control" name="searchString"
						placeholder="Enter Search Keywords" >
				</div>
				<input type="hidden" name="userId" value="${seeker.jobseekerId}"></input>
				<div class="form-group col-sm-4">
					<label class="col-sm-12" for="cname">Company name</label> <input
						type="text" class="form-control" name="companies"
						placeholder="comma separated">
				</div>
				<div class="form-group col-sm-4">
					<label class="col-sm-12" for="location">Job locations</label> <input
						type="text" class="form-control" name="locations"
						placeholder="comma separated">
				</div>
				<div class="form-group col-sm-4">
					<label class="col-sm-12">Salary $ p.a.:</label>
					<div class="form-group col-sm-4">
						<label for="min">Min</label> <input class="col-sm-2" type="text"
							class="form-control" id="min" value="0" name="min" width="10px">
					</div>
					<div class="form-group col-sm-4">
						<label for="max">Max</label> <input class="col-sm-2" type="text"
							class="form-control" id="max" value="1000000" name="max">
					</div>
				</div>

				<button type="submit" class="btn btn-primary">Search</button>
			</form>
		</div>
		<div class="results">
			<h2>Search Results:</h2>
			<p>${fn:length(jobs)} search results</p>

			

			<c:forEach items="${jobs}" var="job">
				<a class="a1" href="/showjob?userId=${seeker.jobseekerId}&jobId=${job[0]}">${job[1]}</a>
				<div class="row">
					<div class="col-sm-4 groups">
						<p>
							<b>jobId:</b> ${job[0]}
						</p>
						<p>
							<b>location:</b> ${job[4]}
						</p>
						<p>
							<b>Salary:</b> $ ${job[5]}
						</p>
						
						<p>
							<b>Posted by:</b> ${job[8]}
						</p>
					</div>
					<div class="col-sm-8">
						<p>
							<b>Status:</b>
							<c:if test="${job[7] == 0}">
								<c:out value="Open" />
							</c:if>
							<c:if test="${job[7] == 1}">
								<c:out value="Filled" />
							</c:if>
							<c:if test="${job[7] == 2}">
								<c:out value="Cancelled" />
							</c:if>
						</p>
						<p>
							<b>Responsibilities :</b> ${job[3]}
						</p>
						<p>
							<b>Description:</b> ${job[2]}
						</p>
					</div>
				</div>
				<hr />
			</c:forEach>
			<!-- <p>Posted by: <c:out value="${job.company}"></c:out></p>
    <p>Status: <c:out value="${job.location}"></c:out></p>
    <p>Status: <c:out value="${job.salary}"></c:out></p>
    <p>${job.description}</p>
     -->

		</div>


		<div id="team" class="container-fluid text-center">
			<h1>Team:</h1>
			<p>Amay</p>
			<p>Ashay</p>
			<p>Avdeep</p>
			<p>Surendra</p>
			<p>Surendra</p>
		</div>

	</div>
	</div>

	<script>
		// Get the modal
		var modal = document.getElementById('id01');

		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}
	</script>

</body>

</html>