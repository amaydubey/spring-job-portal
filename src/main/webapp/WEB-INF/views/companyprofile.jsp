<!DOCTYPE html>
<html lang="en">
<head>
<!-- Basic -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="keywords"
	content="HTML5, template, bootstrap, css, jQuery, responsive, html">
<meta name="application-name" content="Resume html5 template">
<meta name="description"
	content="Resume - Responsive HTML5 Template design & developed by www.sharojit.com from the house of www.themesplugin.com">
<meta name="author" content="www.themesplugin.com">


<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<!-- Google Web Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:400,600|Work+Sans:300"
	rel="stylesheet">

<!-- BOOTSTRAP+FONTAWESOME -->
<link rel="stylesheet" href="css/font-awesome.min.css">

<!-- Theme Stylesheet -->
<style>
html {
	font-size: 100%;
	background: #d9d9d9;
}

.bod {
	font-family: 'Open Sans', sans-serif;
	overflow-x: hidden;
	font-weight: 400;
	line-height: 1.45;
	font-size: 0.875em;
	margin: 60px;
	padding: 0;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	background-color: #ffffff;
	color: #828282;
	border-width: 3px 0;
	border-style: solid;
	border-color: transparent;
	-moz-border-image: -moz-linear-gradient(top left, #3acfd5 0%, #3a4ed5 100%);
	-webkit-border-image: -webkit-linear-gradient(top left, #3acfd5 0%, #3a4ed5 100%);
	border-image: linear-gradient(to bottom right, #3acfd5 0%, #3a4ed5 100%);
	border-image-slice: 1;
}

body, caption, th, td, input, textarea, select, option, legend, fieldset,
	h1, h2, h3, h4, h5, h6 {
	font-size-adjust: 0.5;
}

blockquote {
	font-size: 1.25em;
	line-height: 1.25;
}

*, *:before, *:after {
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	-ms-box-sizing: border-box;
	-o-box-sizing: border-box;
	box-sizing: border-box;
}

input, textarea, button, a {
	-webkit-transition: all 300ms ease-in-out;
	-moz-transition: all 300ms ease-in-out;
	-ms-transition: all 300ms ease-in-out;
	-o-transition: all 300ms ease-in-out;
	transition: all 300ms ease-in-out;
}

img {
	max-width: 100%;
}
/*-------------------
  [1.2 Anchor Text]
--------------------*/
a {
	display: inline-block;
	-webkit-font-smoothing: antialiased;
	cursor: pointer;
	font-size: inherit;
	font-family: 'Open Sans', sans-serif;
}

a:hover {
	text-decoration: none;
}

a:focus {
	outline: inherit;
	color: inherit;
	text-decoration: none;
}
/*-------------------
  [1.3 Thypography]
--------------------*/
/*--- Other ---*/
p {
	margin: 0 0 1.3em;
	font-family: 'Open Sans', sans-serif;
}

.strong, strong {
	font-weight: 500;
}

ul, ol {
	padding-left: 0;
	font-family: 'Open Sans', sans-serif;
}
/*--- Headings ---*/
h1, h2, h3, h4 {
	font-weight: lighter;
	text-transform: none;
	line-height: 1.2;
	font-family: 'Work Sans', sans-serif;
	margin: 1.3em 0;
}

h1, h1 a, h2, h2 a, h3, h3 a, h4, h4 a, h5, h5 a, h6, h6 a {
	letter-spacing: 0.1rem;
}

h1 {
	font-size: 2em;
}

h2 {
	font-size: 1.625em;
}

h3 {
	font-size: 1.375em;
}

h4 {
	font-size: 1.125em;
}

h5 {
	font-size: 1em;
}

h4 {
	font-size: 0.825em;
}
/*-------------------
 [1.4 Theme Element]
--------------------*/
.none {
	display: none;
}
/*-- blockquote --*/
blockquote {
	border-left: 5px solid #f3f3f3;
}

blockquote footer, blockquote small, blockquote .small {
	color: inherit;
}
/*-- Gap --*/
.stp-gap {
	margin: 50px 0;
	height: 1px;
	width: 100%;
	display: block;
	border-width: 1px 0 0;
	border-color: #e8e8e8;
	border-style: solid;
}
/*-- Button --*/
.stp-btn {
	padding: 8px 15px;
	-webkit-border-radius: 3px;
	-moz-border-radius: 3px;
	border-radius: 3px;
	border: 1px solid #3498db;
	color: #3498db;
	background: transparent;
}

.stp-btn:hover, .stp-btn:focus, .stp-btn:active {
	background: #3498db;
	color: #fff;
}
/*-- Social --*/
.stp-social {
	margin: 0;
	padding: 0;
}

.stp-social .social {
	margin: 0;
	padding: 0;
	margin-right: 5px;
}

.stp-social .social a {
	height: 30px;
	width: 30px;
	border: 1px solid #3498db;
	-webkit-border-radius: 50%;
	-moz-border-radius: 50%;
	border-radius: 50%;
	text-align: center;
	line-height: 30px;
	font-size: 13px;
}

.stp-social .social:last-child {
	margin-right: 0px;
}

.stp-social .social:hover a, .stp-social .social:focus a, .stp-social .social:active a
	{
	background: #3498db;
	color: #fff;
}

.stp-social .social.social-facebook:hover a {
	background: #3b5998;
	border-color: #3b5998;
}

.stp-social .social.social-twitter:hover a {
	background: #00aced;
	border-color: #00aced;
}

.stp-social .social.social-googleplus:hover a {
	background: #dd4b39;
	border-color: #dd4b39;
}

.stp-social .social.social-youtube:hover a {
	background: #bb0000;
	border-color: #bb0000;
}

.stp-social .social.social-linkedin:hover a {
	background: #007bb6;
	border-color: #007bb6;
}

.stp-social .social.social-pinterest:hover a {
	background: #cb2027;
	border-color: #cb2027;
}

.stp-social .social.social-dribbble:hover a {
	background: #ea4c89;
	border-color: #ea4c89;
}

.stp-social .social.social-github:hover a {
	background: #333;
	border-color: #333;
}

/*-------------------
  [2. Header Area]
-------------------*/
#stp-header {
	padding: 100px 0;
	border-width: 0 0 1px;
	border-color: #e8e8e8;
	border-style: solid;
}

#stp-header .stp-social {
	display: none;
}

#stp-header-social {
	margin: 0 5px;
}

#stp-header .stp-social .social a {
	-webkit-border-radius: 3px;
	-moz-border-radius: 3px;
	border-radius: 3px;
	font-size: 13px;
}

.stp-user-img img {
	border: 1px solid #3498db;
	padding: 5px;
}

.stp-user-bio {
	padding-top: 15px;
	padding-bottom: 10px;
}

.stp-user-bio h1 {
	margin: 0;
	color: #3498db;
	font-size: 38px;
	text-transform: capitalize;
}

.stp-user-bio p {
	margin: 0 0 10px;
	text-transform: capitalize;
	color: #8c8c7f;
}

.stp-user-info {
	padding-top: 15px;
	padding-bottom: 10px;
}

.stp-user-info p {
	margin-bottom: 10px;
}

/*-------------------
  [3. Content Area]
-------------------*/
#stp-content-area {
	padding: 100px 0;
}

#stp-content-area .row {
	padding-top: 25px;
	padding-bottom: 25px;
}

#stp-content-area .row:last-child {
	padding-bottom: 0;
}

#stp-content-area .stp-content .row {
	padding-top: 0px;
	padding-bottom: 0px;
}

.stp-heading {
	padding-bottom: 50px;
}

.stp-heading .stp-title {
	margin-top: 0;
	text-transform: capitalize;
	font-size: 2.5em;
	color: #3498db;
	margin-bottom: 0.5em;
	line-height: 1;
}

.stp-heading .stp-sub-title {
	color: #8c8c7f;
	margin: 0;
}
/*-- Feature --*/
.stp-feature {
	margin-bottom: 50px;
}

.stp-feature i {
	color: #3498db;
	font-size: 40px;
	line-height: 40px;
}

.stp-feature .stp-feature-title {
	text-transform: capitalize;
	font-size: 1.5em;
	color: #000;
}
/*-- Project --*/
ul.stp-filtered {
	padding: 0;
	margin: 0;
	margin-bottom: 20px;
}

ul.stp-filtered li.stp-filter {
	cursor: pointer;
	font-size: 15px;
	text-transform: capitalize;
	-webkit-transition: all 300ms ease-in-out;
	-moz-transition: all 300ms ease-in-out;
	-ms-transition: all 300ms ease-in-out;
	-o-transition: all 300ms ease-in-out;
	transition: all 300ms ease-in-out;
}

ul.stp-filtered li.stp-filter:active, ul.stp-filtered li.stp-filter:hover,
	ul.stp-filtered li.stp-filter:focus {
	color: #3498db;
}

ul.stp-filtered li.stp-filter.active {
	color: #3498db;
	text-decoration: line-through;
}

#stp-projects .stp-project {
	opacity: 0;
	display: none;
	margin-bottom: 30px;
}

.stp-project-detals {
	overflow: hidden;
	position: relative;
}

.stp-project-detals img {
	max-width: 100%;
	-webkit-transition: all 0.5s linear;
	-moz-transition: all 0.5s linear;
	transition: all 0.5s linear;
	-webkit-transform: scale3d(1, 1, 1);
	-moz-transform: scale3d(1, 1, 1);
	transform: scale3d(1, 1, 1);
	width: 100%;
}

.stp-project-detals .stp-project-overlay {
	position: absolute;
	bottom: -30px;
	right: 0;
	width: 30px;
	height: 30px;
	background: #3498db;
	text-align: center;
	line-height: 30px;
	-webkit-transition: all 300ms ease-in-out;
	-moz-transition: all 300ms ease-in-out;
	-ms-transition: all 300ms ease-in-out;
	-o-transition: all 300ms ease-in-out;
	transition: all 300ms ease-in-out;
}

.stp-project-detals a {
	color: #fff;
}

#stp-projects .stp-project:hover .stp-project-detals .stp-project-overlay,
	#stp-projects .stp-project:focus .stp-project-detals .stp-project-overlay,
	#stp-projects .stp-project:active .stp-project-detals .stp-project-overlay
	{
	bottom: 0;
}

#stp-projects .stp-project:hover .stp-project-detals img, #stp-projects .stp-project:focus .stp-project-detals img,
	#stp-projects .stp-project:active .stp-project-detals img {
	-webkit-transform: scale3d(1.2, 1.2, 1);
	-moz-transform: scale3d(1.2, 1.2, 1);
	transform: scale3d(1.2, 1.2, 1);
	opacity: 0.7;
	filter: alpha(opacity = 70); /* IE8 and lower */
}
/*-- Jobs --*/
.stp-jobs {
	margin-bottom: 25px;
	padding-bottom: 25px;
	position: relative;
}

.stp-jobs::after {
	content: "";
	position: absolute;
	bottom: 0;
	left: 0;
	height: 1px;
	width: 15%;
	background: #3498db;
}

.stp-content .row:last-of-type .stp-jobs {
	margin-bottom: 0;
	padding-bottom: 0;
}

.stp-content .row:last-of-type .stp-jobs::after {
	display: none;
}

.stp-jobs .stp-job-time {
	margin-bottom: 5px;
	letter-spacing: 1px;
}

.stp-jobs .stp-job-title {
	margin-top: 0;
	margin-bottom: 20px;
	letter-spacing: 1px;
	text-transform: capitalize;
	font-size: 34px;
}

.stp-jobs .stp-job-list {
	margin: 0;
	padding: 0;
	list-style-position: inside;
}
/*-- skill bar --*/
.stp-skill {
	height: 30px;
	margin-bottom: 30px;
}

.stp-skill:last-child {
	margin-bottom: 0px;
}

.stp-skill .progress-bar {
	text-align: left;
	position: relative;
}

.stp-skill .progress-bar .stp-skill-title {
	position: absolute;
	height: 100%;
	padding: 5px 10px;
	font-size: 13px;
	background: rgba(60, 53, 53, 0.5);
	text-transform: capitalize;
}
/*-- Degree --*/
.stp-degree {
	margin-bottom: 30px;
	padding-bottom: 30px;
	position: relative;
}

.stp-degree::after {
	content: "";
	position: absolute;
	bottom: 0;
	left: 0;
	height: 1px;
	width: 10%;
	background: #3498db;
}

.stp-degree .stp-degree-year {
	margin-bottom: 5px;
	letter-spacing: 1px;
}

.stp-degree .stp-degree-title {
	margin-top: 0;
	margin-bottom: 20px;
	letter-spacing: 1px;
	text-transform: capitalize;
	font-size: 34px;
}

.stp-content .row:last-of-type .stp-degree {
	margin-bottom: 0;
	padding-bottom: 0;
}

.stp-content .row:last-of-type .stp-degree::after {
	display: none;
}
/*-- workking --*/
.stp-working {
	-webkit-border-radius: 3px;
	-moz-border-radius: 3px;
	border-radius: 3px;
	padding: 15px;
	border: 1px solid #dedede;
}

.stp-working img {
	max-width: 100%;
	width: 100%;
}

.stp-working .stp-working-title {
	margin: 15px 0 0;
	text-transform: capitalize;
	font-size: 15px;
}

.stp-working .stp-working-title::after {
	content: "\f061";
	font-family: FontAwesome;
	-webkit-transition: all 300ms ease-in-out;
	-moz-transition: all 300ms ease-in-out;
	-ms-transition: all 300ms ease-in-out;
	-o-transition: all 300ms ease-in-out;
	transition: all 300ms ease-in-out;
	opacity: 0;
	filter: alpha(opacity = 0); /* IE8 and lower */
}

.stp-working:hover .stp-working-title::after, .stp-working:focus .stp-working-title::after,
	.stp-working:active .stp-working-title::after {
	opacity: 0.6;
	filter: alpha(opacity = 60); /* IE8 and lower */
	padding-left: 5px;
}
/*-- Post --*/
.stp-post {
	position: relative;
	overflow: hidden;
	margin-bottom: 30px;
	text-align: center;
	border: 1px solid #dedede;
}

.stp-post img {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	max-width: 100%;
	opacity: 0;
	filter: alpha(opacity = 0); /* IE8 and lower */
	-webkit-transition: opacity 300ms ease-in-out;
	-moz-transition: opacity 300ms ease-in-out;
	-ms-transition: opacity 300ms ease-in-out;
	-o-transition: opacity 300ms ease-in-out;
	transition: opacity 300ms ease-in-out;
}

.stp-post:active img, .stp-post:focus img, .stp-post:hover img {
	opacity: 1;
	filter: alpha(opacity = 100); /* IE8 and lower */
}

.stp-post .spt-overlay {
	padding: 50px 10px;
	position: relative;
	-webkit-transition: all 400ms ease-in-out;
	-moz-transition: all 400ms ease-in-out;
	-ms-transition: all 400ms ease-in-out;
	-o-transition: all 400ms ease-in-out;
	transition: all 400ms ease-in-out;
}

.stp-post .stp-post-title {
	margin: 0 0 10px;
	text-transform: capitalize;
	-webkit-transition: all 500ms ease-in-out;
	-moz-transition: all 500ms ease-in-out;
	-ms-transition: all 500ms ease-in-out;
	-o-transition: all 500ms ease-in-out;
	transition: all 500ms ease-in-out;
}

.stp-post .stp-post-details {
	margin: 0;
}

.stp-post .stp-post-details span {
	margin: 0 5px;
}

.stp-post:active .spt-overlay, .stp-post:focus .spt-overlay, .stp-post:hover .spt-overlay
	{
	background: rgba(45, 45, 45, 0.5);
	color: #fff;
}

.stp-post:hover .spt-overlay .stp-post-title a {
	color: #fff;
}
/*-- Contact Form --*/
#stp-contact-form {
	
}

#stp-contact-form .stp-field {
	position: relative;
	margin-bottom: 20px;
}

#stp-contact-form .stp-field label {
	position: absolute;
	left: 0;
	bottom: 0;
	top: 12px;
	display: inline-block;
	width: 100%;
	opacity: 0.5;
	filter: alpha(opacity = 50); /* IE8 and lower */
	font-size: 15px;
	pointer-events: none;
	-webkkit-transition: 400ms ease all;
	-moz-transition: 400ms ease all;
	transition: 400ms ease all;
}

#stp-contact-form .stp-field input:focus ~ label, #stp-contact-form .stp-field textarea:focus 
	 ~ label {
	top: 0px;
	font-size: 12px;
	color: #3498db;
	opacity: 1;
	filter: alpha(opacity = 100); /* IE8 and lower */
}

#stp-contact-form .stp-field input, #stp-contact-form .stp-field textarea
	{
	display: block;
	width: 100%;
	border: 0;
	border-bottom: 1px solid #868484;
	background: transparent;
	-webkkit-transition: border-color ease-in-out 300ms;
	-moz-transition: border-color ease-in-out 300ms;
	transition: border-color ease-in-out 300ms;
	outline: 0;
}

#stp-contact-form .stp-field input:focus, #stp-contact-form .stp-field textarea:focus
	{
	border-color: #3498db;
}

#stp-contact-form .stp-field input {
	height: 45px;
	padding-top: 3px;
}

#stp-contact-form .stp-field textarea {
	height: 150px;
	resize: none;
	padding-top: 15px;
}

#stp-contact-form .stp-field .stp-btn {
	padding: 10px 35px;
}

/*-------------------
    [4. Map]
--------------------*/
#map {
	height: 400px;
	width: 100%;
}

.gm-style-iw * {
	display: block;
	min-width: 200px;
}

.gm-style-iw h4 {
	color: #000;
	font-size: 15px;
	font-weight: 500;
}

.gm-style-iw h4, .gm-style-iw p {
	margin: 0 0 3px;
	padding: 0;
}

/*-------------------
    [5. Footer]
--------------------*/
#stp-footer {
	padding: 10px 0;
}

#stp-footer .stp-top {
	text-align: center;
}

#stp-footer .stp-footer1 {
	padding-top: 5px;
}

#stp-footer .stp-footer2 {
	text-align: right;
}

a.stp-back-totop {
	font-size: 20px;
}

/*==============================================
--------  RESPONSIVE SETTING -------------------
===============================================*/
@media only screen and (max-width: 768px) {
	#stp-projects .stp-project {
		min-height: 200px;
	}
	/*-- working --*/
	.stp-working {
		margin-bottom: 30px;
	}
	/*-- Footer --*/
	#stp-footer .stp-footer1, #stp-footer .stp-footer2, #stp-footer .stp-top
		{
		text-align: center;
		margin-bottom: 10px;
	}
}

@media only screen and (max-width: 500px) {
	body {
		margin: 30px;
	}
}

@media only screen and (max-width: 350px) {
	body {
		margin: 10px;
	}
	.stp-post .stp-post-title {
		margin: 0;
		font-size: 1em;
	}
	.stp-post .stp-post-details {
		display: none;
	}
	.stp-social .social {
		margin-bottom: 5px;
	}
}
</style>




</head>

<body id="pagetop" class="container-fluid well">
	<div class="bod well">

		<div class="container-fluid">

			<nav class="navbar navbar-inverse navbar-fixed-top">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand" href="#pagetop">FindJobs.com</a>
					</div>
					<ul class="nav navbar-nav navbar-right">
						<li class="active"><a href="#team">Team</a></li>

						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">logged in as
								${company.companyName} <span class="caret"></span>
						</a>
							<ul class="dropdown-menu">
								<li><a href="#">Profile</a></li>
								<li><a href="jobsearch.jsp">Search Jobs</a></li>
								<li><a href="index.jsp">Logout</a></li>
							</ul></li>
					</ul>
				</div>
			</nav>
		</div>



		<script>
			UPLOADCARE_PUBLIC_KEY = 'f78da83ce6beb3f386b7';
			UPLOADCARE_LIVE = false;
			UPLOADCARE_LOCALE = 'en';
		</script>
		<script
			src="https://ucarecdn.com/libs/widget/2.10.3/uploadcare.full.min.js"
			charset="utf-8"></script>

		<header id="stp-header">
			<div class="container">
				<div class="row">
					<!-- user image -->
					<div class="col-lg-2 col-md-2 col-sm-4 col-xs-12 stp-user-img">

					</div>
					<!-- user image -->
					<!-- user bio -->
					<div class="col-lg-7 col-md-7 col-sm-8 col-xs-12 stp-user-bio">
						<h1>${company.companyName}</h1>
						<p>HEADQUATERS: ${company.headquarters}</p>






					</div>

					<div
						class="col-lg-3 col-lg-offset-0 col-md-3 col-md-offset-0 col-sm-8 col-sm-offset-4 col-xs-12 stp-user-info">

						<form action="/register/verify" method="get">
							<input type="hidden" name="userId" value="${company.companyId}"></input>

							<input type="hidden" name="pin"
								value="${company.verificationCode}"></input> <input
								type="hidden" name="type" value="recruiter"></input>
								
							<button type="submit" class="btn btn-block btn-default">Update
								Profile</button>
						</form>
						<br>
						<form action="/JobPosting" method="get">
						<input type="hidden" name="cid" value="${company.companyId}"></input>
						
							<button type="submit" class="btn btn-block btn-primary">Post
								a Job</button>
						</form>

					</div>
					<!-- user info -->
				</div>
			</div>
		</header>
		<!-- Header Area End-->

		<!-- Content Area Start -->
		<section id="stp-content-area">
			<div class="container">






				<div class="row">
					<!-- Heading -->
					<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12 stp-heading">
						<h2 class="stp-title">COMPANY DESCRIPTION</h2>
					</div>
					<!-- Heading -->
					<!-- Content -->
					<div class="col-lg-9 col-md-9 col-sm-12 col-xs-12 stp-content">
						<!-- job widget -->
						<div class="row">
							<div class="col-lg-12 col-xs-12">
								<div class="stp-jobs">
									<p class="stp-job-time">${company.description}</p>


								</div>
							</div>
						</div>

					</div>
					<!-- Content -->
				</div>
				<!-- Recent Jobs -->











			</div>
		</section>
	</div>

	<div id="team" class="container-fluid text-center">
		<h1>Team:</h1>
		<p>Amay</p>
		<p>Ashay</p>
		<p>Avdeep</p>
		<p>Surendra</p>
		<p>Surendra</p>
	</div>


</body>
</html>
