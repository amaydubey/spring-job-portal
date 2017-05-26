<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="author" content="">
<title>FindJobs.com</title>
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
				
				</ul>
			</div>
		</nav>

		<div class="jumbotron">
			<div class="container text-center">

				<h2>
					<img src="http://qspear.com/admin/images/news_events_images/partner_news.png" height="80" width="auto">FindJobs.com
				</h2>
				<p>Message</p>

				<h1>${message}</h1>
			</div>
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