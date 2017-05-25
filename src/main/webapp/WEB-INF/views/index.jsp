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

<!-- <link rel="stylesheet" href="css/style.css">
   
<script src="js/script.js"></script>-->
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
/* Full-width input fields */
input[type=text], input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
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
					<a class="navbar-brand" href="#pagetop">FindJobs.com</a>
				</div>
				<ul class="nav navbar-nav navbar-right">
					<li class="active"><a href="#requirements">Project
							Requirements</a></li>
					<li class="active"><a href="#team">Team</a></li>
					<!--<li><a href="#">Page 1</a></li>
      <li><a href="#">Page 2</a></li>
      <li><a href="#">Page 3</a></li>-->
				</ul>
			</div>
		</nav>

		<div class="jumbotron">
			<div class="container text-center">

				<h2>
					<img src="http://qspear.com/admin/images/news_events_images/partner_news.png" height="80" width="auto">FindJobs.com
				</h2>
				<h1>Post or Search jobs</h1>

				<p>Website for recruiters and job seekers</p>
			</div>
		</div>
		<div class="row picture row1">
			<img src=http://s3.amazonaws.com/fjwp/blog/wp-content/uploads/2016/03/04034507/Job-Searching-Online-8-Best-Practices-You-Need-to-Know.jpg class="img-responsive col-sm-6 cols"
				alt="Cinque Terre">
			<div
				class=" row vertical-divider col-sm-6 text-center cols row1 row2 well"
				style="background-color: #8bc34a;">
				<h1>Start now</h1>
				<div class="col-xs-6">
					<h4>Returning users</h4>
					<button class="btn btn-primary btn-block"
						onclick="document.getElementById('id01').style.display='block'">Login</button>
				</div>
				<div class="col-xs-6">
					<h4>New users</h4>
					<form action="/register" method="get">
					<button type="submit" class="btn btn-danger btn-block"
						>Register</button>
						</form>
				</div>


				<div id="id01" class="modal">

					<form class="modal-content animate" action="/login" method="post">
						<div class="imgcontainer">
							<span
								onclick="document.getElementById('id01').style.display='none'"
								class="close" title="Close Modal">&times;</span> <img
								src="https://cdn2.iconfinder.com/data/icons/website-icons/512/User_Avatar-512.png" alt="Avatar" class="avatar">
						</div>
						<div class="btn-group btn-group-justified" data-toggle="buttons">
								<label class="btn btn-default active"> <input
									type="radio" name="type" id="seeker" value="seeker"
									autocomplete="off" checked> Job Seeker
								</label> <label class="btn btn-default"> <input type="radio"
									name="type" id="recruiter" value="recruiter"
									autocomplete="off"> Recruiter
								</label>

							</div>

						<div class="container-fluid">
							<label><b>Email</b></label> <input type="text"
								placeholder="Enter Email" name="emailId" required> <label><b>Password</b></label>
							<input type="password" placeholder="Enter Password" name="password"
								required>

							<button type="submit">Login</button>
						</div>

					</form>
				</div>

			</div>
		</div>


		<div id="requirements" class="container-fluid">

			<h1>Requirements</h1>
			<h3>
				<strong>Users and Authentication</strong>
			</h3>
			<p>
				<span style="font-weight: 400;">There are two types of users,
					company and job seeker.</span>
			</p>
			<ol>
				<li style="font-weight: 400;"><strong>Company can post
						jobs. </strong></li>
				<li style="font-weight: 400;"><strong>Job seeker can
						search for jobs and submit applications.</strong></li>
				<li style="font-weight: 400;"><strong>Both job seekers
						and companies must use a valid email to sign up. </strong></li>
			</ol>
			<ol>
				<ol style="list-style-type: lower-alpha;">
					<li style="font-weight: 400;"><span style="font-weight: 400;">The
							system does not allow the same email address to be used to
							register for a job seeker account if it is already registered as
							a company account -- and vice versa. &nbsp;</span></li>
					<li style="font-weight: 400;"><span style="font-weight: 400;">Your
							app must send an email to users [for both job seeker and company]
							with a verification code. The user needs to use that verification
							code to complete his account registration. A registered user
							cannot really use features in the system until his account is
							verified. A confirmation email must be sent to the user after
							completion of account verification.</span></li>
				</ol>
			</ol>
			<p>&nbsp;</p>
			<h3>
				<strong>Job Seekers</strong>
			</h3>
			<p>
				<span style="font-weight: 400;">Job seekers must fill in
					their profile information before applying for a position. </span>
			</p>
			<ol start="4">
				<li><strong> &nbsp;The profile contains at least the
						following information</strong></li>
			</ol>
			<ol style="list-style-type: lower-alpha;">
				<li style="font-weight: 400;"><span style="font-weight: 400;">First
						name</span></li>
				<li style="font-weight: 400;"><span style="font-weight: 400;">Last
						name</span></li>
				<li style="font-weight: 400;"><span style="font-weight: 400;">Picture
				</span><strong>[optional]</strong></li>
				<li style="font-weight: 400;"><span style="font-weight: 400;">Self-introduction
						[optional]</span></li>
				<li style="font-weight: 400;"><span style="font-weight: 400;">Work
						experience</span></li>
				<li style="font-weight: 400;"><span style="font-weight: 400;">Education</span></li>
				<li style="font-weight: 400;"><span style="font-weight: 400;">Skills</span></li>
			</ol>
			<p>
				<span style="font-weight: 400;">User can edit and update his
					profile at any time he likes.</span>
			</p>
			<p>&nbsp;</p>
			<ol start="5">
				<li><strong> Job seekers can search for open job
						positions</strong></li>
			</ol>
			<ol style="list-style-type: lower-alpha;">
				<li style="font-weight: 400;"><span style="font-weight: 400;">Search
						by text the user types in, which can be a job title, a company
						name, a skill, a mix of them, or basically, any arbitrary piece of
						text. A word in the text can be matched against any part of a job
						posting.</span></li>
				<li style="font-weight: 400;"><span style="font-weight: 400;">Search
						by filters</span></li>
				<ol>
					<li style="font-weight: 400;"><span style="font-weight: 400;">Company
							name (allow multiple)</span></li>
					<li style="font-weight: 400;"><span style="font-weight: 400;">Location
							(city names, allow multiple)</span></li>
					<li style="font-weight: 400;"><span style="font-weight: 400;">Salary
							range (can be a single value, an open range, or a close range)</span></li>
				</ol>
			</ol>
			<p style="padding-left: 60px;">
				<span style="font-weight: 400;">You can add more filters if
					you prefer. </span>
			</p>
			<ol style="list-style-type: lower-alpha;">
				<li style="font-weight: 400;"><span style="font-weight: 400;">Within
						each filter type, the relationship between the multiple values is
						OR; e.g., if you specify both Cisco and IBM as the company filter,
						the it matches a job from Cisco </span><em><span
						style="font-weight: 400;">or</span></em> <span
					style="font-weight: 400;"> IBM . The different filters and
						free text work together with AND; i.e., all need to be matched.
						For example, If you specify both the company fitler and the
						location filter, a matching job must match both the two filters.</span></li>
				<li style="font-weight: 400;"><span style="font-weight: 400;">The
						layout of search result is up to you, but you need to support
						paging in case the number of matching jobs goes beyond one page,
						which contains up to 10 jobs. </span></li>
			</ol>
			<ol start="6">
				<li><span style="font-weight: 400;"><strong>
							Job seeker can mark/unmark any open position as interested in the
							search result page.</strong> </span></li>
			</ol>
			<ol style="list-style-type: lower-alpha;">
				<li style="font-weight: 400;"><span style="font-weight: 400;">If
						a position gets filled or cancelled by the company, it would be
						removed from applicant&rsquo;s interesting list automatically. The
						app must send an email notification to applicant too.</span></li>
				<li style="font-weight: 400;"><span style="font-weight: 400;">A
						user can also taggle an interested job as not interested in the
						search result page.</span></li>
				<li style="font-weight: 400;"><span style="font-weight: 400;">There
						is no limit to the number of positions applicant can add to his
						interested list.</span></li>
				<li style="font-weight: 400;"><span style="font-weight: 400;">Your
						app needs to show a user&rsquo;s </span><span style="font-weight: 400;">interested</span>
					<span style="font-weight: 400;"> list, which should be
						presented similar to the search result page, except that there is
						no need to support paging in the view for interested jobs. A user
						needs to be able unmark/mark jobs in the interested job view too.</span>
				</li>
			</ol>
			<p>&nbsp;</p>
			<ol start="7">
				<li><strong> Apply for a position</strong></li>
			</ol>
			<ol style="list-style-type: lower-alpha;">
				<li style="font-weight: 400;"><span style="font-weight: 400;">A
						user can apply for a selected position in search result page or
						the interested jobs page.</span></li>
				<li style="font-weight: 400;"><span style="font-weight: 400;">A
						user can choose to apply with his profile, or attach a resume. In
						both cases, the user name and email from the user&rsquo;s profile
						becomes part of the application.</span></li>
				<li style="font-weight: 400;"><span style="font-weight: 400;">For
						any apply operation, the user would receive an email notification
						with the information of position(s).</span></li>
				<li style="font-weight: 400;"><span style="font-weight: 400;">You
						need to provide a view for a user to browse or cancel his
						applications.</span></li>
				<ol>
					<li style="font-weight: 400;"><span style="font-weight: 400;">Each
							application has a status, Pending, Offered, Rejected,
							OfferAccepted, OfferRejcted, or Cancelled. The latter four states
							are also called terminal state. </span></li>
					<li style="font-weight: 400;"><span style="font-weight: 400;">A
							user can cancel a pending application and reject an offered
							application.</span></li>
					<li style="font-weight: 400;"><span style="font-weight: 400;">The
							user can cancel (or reject) one or more applications (or offers)
							in one transaction.</span></li>
					<li style="font-weight: 400;"><span style="font-weight: 400;">The
							company can cancel any application that is not in a terminal
							state. </span></li>
					<li style="font-weight: 400;"><span style="font-weight: 400;">Jobs
							of all states need to show up in the application view.</span></li>
				</ol>
				<li style="font-weight: 400;"><span style="font-weight: 400;">A
						user cannot have more than 5 pending applications. </span></li>
				<li style="font-weight: 400;"><span style="font-weight: 400;">A
						user cannot apply for the same position again if the previous
						application is not in a terminal state.</span></li>
				<li style="font-weight: 400;"><span style="font-weight: 400;">For
						any status change of an application, the job seeker receives an
						email update as well.</span></li>
			</ol>
			<ol start="8">
				<li><strong> Interview scheduling [Bonus Feature].</strong></li>
			</ol>
			<ol style="list-style-type: lower-alpha;">
				<li style="font-weight: 400;"><span style="font-weight: 400;">If
						the company has set up the interview time for a position with an
						applicant, the applicant will receive an email, ideally with a
						calendar invitation. </span></li>
				<li style="font-weight: 400;"><span style="font-weight: 400;">The
						app also provides an interview list page for the job seeker, which
						shows all the interviews scheduled. </span></li>
				<li style="font-weight: 400;"><span style="font-weight: 400;">A
						job seeker can decide to accept or refuse any interview
						invitation. He should be able to do this through his interview
						list page, or possibly by accepting or rejecting the calendar
						invitation as well. The company will also receive an email
						notification with user&rsquo;s decision. </span></li>
			</ol>
			<h3>
				<span style="font-weight: 400;">Companies</span>
			</h3>
			<ol start="10">
				<li><strong> A company needs to provide basic
						information upon registration</strong></li>
			</ol>
			<ol style="list-style-type: lower-alpha;">
				<li style="font-weight: 400;"><span style="font-weight: 400;">Name</span></li>
				<li style="font-weight: 400;"><span style="font-weight: 400;">Website</span></li>
				<li style="font-weight: 400;"><span style="font-weight: 400;">Logo
						image URL</span></li>
				<li style="font-weight: 400;"><span style="font-weight: 400;">Address
						of headquarters</span></li>
				<li style="font-weight: 400;"><span style="font-weight: 400;">Description</span></li>
			</ol>
			<p>
				<span style="font-weight: 400;">Company can edit and update
					its own information at any time.</span>
			</p>
			<p>&nbsp;</p>
			<ol start="11">
				<li><strong> Company can post new positions into the
						system. A position contains at least the following information</strong></li>
			</ol>

			<ol style="list-style-type: lower-alpha;">
				<li style="font-weight: 400;"><span style="font-weight: 400;">Title</span></li>
				<li style="font-weight: 400;"><span style="font-weight: 400;">Description</span></li>
				<li style="font-weight: 400;"><span style="font-weight: 400;">Responsibilities</span></li>
				<li style="font-weight: 400;"><span style="font-weight: 400;">Office
						location</span></li>
				<li style="font-weight: 400;"><span style="font-weight: 400;">Salary</span></li>
			</ol>

			<p>
				<span style="font-weight: 400;">A company can edit and update
					its information mentioned above. When a job is updated, all the
					current applicants (applications in terminal states are not
					considered) are notified about the change.</span>
			</p>

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