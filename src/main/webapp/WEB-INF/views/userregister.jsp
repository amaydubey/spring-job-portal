<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="author" content="">
<title>Register | FindJobs.com</title>
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

<script src="js/myscript.js"></script>


</head>

<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="index.jsp">FindJobs.com</a>
			</div>
		</div>
	</nav>
	<div class="container-fluid">
		<div class="container">
			<div class="well">
				<h1>
					<img src="img/logo.png" height="80" width="auto">Complete
					Registration
				</h1>

			</div>
			<div class="col-lg-12 well" style="box-shadow: 0 0 20px black">
				<h4 class="text-center">Job seeker registration</h4>
				<br>
				<div class="row">
					<form>




						<div class="col-sm-12">
							<div class="row">
								<div class="col-sm-6 form-group">
									<label>First Name</label>
									<%
										String fname = "john";
										String lname = "doe";
										String email = "email@mail.com";
										out.print("<input type='text' value='" + fname + "' readonly class='form-control'>");
									%>
								</div>
								<div class="col-sm-6 form-group">
									<label>Last Name</label>
									<%
										out.print("<input type='text' value='" + lname + "' readonly class='form-control'>");
									%>
								</div>
							</div>
							<div class="form-group">
								<label>Email Address</label>
								<%
									out.print("<input type='text' value='" + email + "' readonly class='form-control'>");
								%>
							</div>
							<div class="form-group">
								<label>Self-introduction</label>
								<textarea placeholder="Enter Self-introduction Here.." rows="3"
									class="form-control"></textarea>
							</div>
							<div class="row">
								<div class="col-sm-6 form-group">
									<label>Work experience (in years)</label> <input type="text"
										placeholder="Enter number of years Here.."
										class="form-control">
								</div>
								<div class="col-sm-6 dropdown form-group">
									<label>Highest education</label>
									<button class="btn btn-default dropdown-toggle" type="button"
										data-toggle="dropdown">
										Select one <span class="caret"></span>
									</button>
									<ul class="dropdown-menu">
										<li><a href="#">Master's degree</a></li>
										<li><a href="#">Bachelor's degree</a></li>
										<li><a href="#">Ph.D.</a></li>
									</ul>

								</div>

							</div>
							<div class="form-group">
								<label>Skills (comma separated)</label>
								<textarea placeholder="Enter comma separated skills here.."
									rows="3" class="form-control"></textarea>
							</div>


							<button type="button" class="btn btn-lg btn-primary">Submit</button>
						</div>
					</form>
				</div>
			</div>
		</div>






		<div id="team" class="container-fluid text-center">
			<h1>Team:</h1>
			<p>Amay Dubey ()</p>
			<p>Ashay Argal (010822513)</p>
			<p>Avdeep ()</p>
			<p>Surendra ()</p>
		</div>

	</div>



</body>

</html>