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

<link rel="stylesheet" href="css/style.css">
<!--
<script src="js/script.js"></script>-->


</head>

<body id="pagetop">
	<%
		String name = "John"; 
	%>
	<div class="container-fluid">

		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#pagetop">FindJobs.com</a>
				</div>
				<ul class="nav navbar-nav navbar-right">
					<li class="active"><a href="#team">Team</a></li>

					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">logged in as <% out.print(name);%>
							<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Profile</a></li>
							<li><a href="jobsearch.jsp">Search Jobs</a></li>
							<li><a href="index.jsp">Logout</a></li>
						</ul></li>
				</ul>
			</div>
		</nav>

		<div class="jumbotron">
			<div class="container text-center">


				<h2>Search jobs</h2>

			</div>
		</div>

		
		<form class="form-inline row well" style="margin:5px" action="/action_page.php">
			<div class="form-group col-sm-4">
				<label class="col-sm-12" for="cname">Company name</label> <input
					type="text" class="form-control" id="email"
					placeholder="comma separated" name="cname">
			</div>
			<div class="form-group col-sm-4">
				<label class="col-sm-12" for="location">Job locations</label> <input
					type="text" class="form-control" id="pwd"
					placeholder="comma separated" name="location">
			</div>
			<div class="form-group col-sm-4">
				<label class="col-sm-12">Salary $ p.a.:</label>
				<div class="form-group col-sm-4">
					<label for="min">Min</label> <input class="col-sm-2" type="text"
						class="form-control" id="min" placeholder="$" name="min"
						width="10px">
				</div>
				<div class="form-group col-sm-4">
					<label for="max">Max</label> <input class="col-sm-2" type="text"
						class="form-control" id="max" placeholder="$" name="max">
				</div>
			</div>

			<button type="submit" class="btn btn-primary">Search</button>
		</form>
		<div>
		<p th:text="'Hello, ' + ${name} + '!'" />
		</div>

		<div id="team" class="container-fluid text-center">
			<h1>Team:</h1>
			<p>Amay Dubey ()</p>
			<p>Ashay Argal (010822513)</p>
			<p>Avdeep ()</p>
			<p>Surendra ()</p>
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