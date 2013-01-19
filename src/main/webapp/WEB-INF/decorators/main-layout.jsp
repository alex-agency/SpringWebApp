<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Cook Book</title>

    <!-- Mobile viewport optimized: h5bp.com/viewport -->
	<meta name="viewport" content="width=device-width">
	
	<!-- Styles -->
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" />
    <!-- United Theme from Bootswatch -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" />    
  	<link href="<c:url value="/resources/css/bootstrap-responsive.min.css" />" rel="stylesheet" /> 

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Fav and touch icons -->
    <!-- OR remove these lines and place icons directly
        in the site root folder mathiasbynens.be/notes/touch-icons -->
  	<!--<link rel="shortcut icon" href="img/favicon.ico">
  	<link rel="apple-touch-icon" href="img/apple-touch-icon.png">
  	<link rel="apple-touch-icon" si   zes="72x72" href="img/apple-touch-icon-72x72.png">
  	<link rel="apple-touch-icon" sizes="114x114" href="img/apple-touch-icon-114x114.png">-->
</head>

<body data-spy="scroll" data-offset="300" data-target=".navbar">
	<div class="container">
		
		<header>
			<c:import url="/WEB-INF/views/tags/head.jsp"/>
			
			<nav class="navbar" data-spy="affix" data-offset-top="150">
				<div class="navbar-inner">
					<c:import url="/WEB-INF/views/tags/navbar.jsp"/>
			    </div><!-- /.navbar-inner -->
			</nav>
		</header>

		<decorator:body />
		
		<c:import url="/WEB-INF/views/tags/footer.jsp"/>
		
	</div><!-- /.container -->
	
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<c:url value="/resources/js/jquery.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
	<script src="<c:url value="/resources/js/holder.js" />"></script>
	<script src="<c:url value="/resources/js/script.js" />"></script>
	<!-- Modernizr for browser feature-checking 
			+ HTML5shiv (included in modernizr) see modernizr.com -->
  	<script src="<c:url value="/resources/js/modernizr.js" />"></script>
</body>
</html>