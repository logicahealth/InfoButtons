<?xml version="1.0" encoding="UTF-8"?><!-- DWXMLSource="responseSample.xml" -->
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema"
	xmlns:fn="http://www.w3.org/2005/xpath-functions" xmlns:ns2="urn:hl7-org:v3"
	xmlns:ns3="http://www.w3.org/2005/Atom:atom">
	<xsl:output method="html" version="1.0" encoding="UTF-8"
		indent="yes" />
	<xsl:template match="/">
		<html>
			<head>
				<title> OpenInfobutton</title>
				<style type="text/css"><![CDATA[
						@charset "UTF-8";
							html, body, div, ul, ol, li p, h1, h2, h3, h4, h5, h6, form, fieldset {
								margin: 0;
								padding: 0; 
								border: 0;
							}
							body  {
								font: 100.01% Arial, Helvetica, "Trebuchet MS",Verdana, sans-serif;
								background: #666 url(/images/background/page-bg.gif) repeat;
								color: #000;
								text-align: center;
							}
							h1 { padding: 0.85em 0 0.5em 0; }
							h2, h3 { padding: 0.5em 0 0.2em 0; }
							h4, h5, h6 { padding: 0.5em 0 0 0; }
							h1 { font-size: 130%; color: #666; letter-spacing: .02em; }
							h2 { font-size: 110%; color: #900; }
							h3 {
								font-size: 85%;
								color: #333;
								text-transform: uppercase;
								letter-spacing: .02em;
								margin-bottom: 10px;
								border-bottom: 2px #ccc solid;
							}
							h4 { font-size: 90%; color: #666; line-height: 1.0em; }
							h5 { font-size: 85%; color: #c00; }
							h6 { font-size: 85%; color: #333; font-family: Georgia, "Times New Roman", Times, serif; }
							p { 
								font-size: 90%; 
								color: #000; 
								margin: 0.2em 0 0.8em 0; 
								font-family: Georgia, "Times New Roman", Times, serif;
							}
							strong { font-weight: bold; color: #333; }
							em { font-style: italic; }
							a { font-weight: normal; }
							a:link { color: #8f5917; text-decoration: underline; }
							a:visited { color: #666; text-decoration: underline; }
							a:focus, a:hover, a:active { color: #600; text-decoration: none; }
							hr {
								border: 0;
								color: #777;
								background-color: #777;
								height: 2px;
								width: 100%;
								margin: 5px 0;
								text-align: left;
							}
							
							/* --- page layout styles --- */
							
							.u_style #wrapper { 
								position: relative;
								z-index: 5;
								width: 100%;
								max-width: 75em;
								min-width: 58em;
								margin: 0 auto;
								background: #fff;
								text-align: left; /* this overrides the text-align: center on the body element. */
							}  
							.u_style #header { 
								position: relative;
								z-index: 5;
								width: 100%;
								border-top: #333 10px solid;
							}
							.u_style #headerLeft {
								float: left;
								width: auto; 
							}
							.u_style #header {
								background: #900 url(/images/header/redBck.gif) top left no-repeat;}	/* Header color */
							.u_style #headerNavBar {
								clear: both;
								width: 100%;
								height: 1em;
								text-align: center;
								padding: 0.2em 0 0 0;
								border-top: 5px solid;
								background-color:#8f5917;		/* Header Nav background */
								border-top-color:#bb8d49;		/* Header Nav top border */
							}
							.u_style #innerWrapper{
								position:inherit;
								z-index:4;
								width: 100%;
								max-width: 75em;
								min-width: 58em;
								background: #fff;
								clear:both;
							}
							.u_style #sideColumn1 {
								background: #900;
								border-bottom-color:#7e0000;
								position: relative;
								z-index: 5;
								float: left; 
								width: 11.5em; /* since this element is floated, a width must be given */
								padding: 15px 0; /* top and bottom padding create visual space within this div */
							}
							
							.u_style #sideColumn1 div {
								margin: 0 0 0 15px; /* this creates the left and right margin for the side columns */
							}
							
							
							.u_style #content {
								position:relative;
								z-index: 1;
								margin: 0 0 0px 12.5em;
							} 
							.u_style #content div {
								margin: 0 10px 0 20px; /* padding here creates white space "inside the box." */
								width: 88%;
							}
							.col{
								position: absolute;
								z-index: 0;
								left: 0;
								bottom: 0;
							}
							.side1 { 
								position: absolute;
								z-index: 0;
								bottom: 0;
								width: 12em; 
								background: #900;
								border-right: #bb8d49 7px solid;
							}
							.mid { 
								position:absolute;
								z-index: 0;
								left: 44%;
								bottom : 30%;
								width: 50%; 
								background: #fff url(/images/background/uofu_medallion_lt.gif) bottom left no-repeat;
							
							}
							
							.u_style #footer {
								clear: both;
								position: relative;
								z-index: 5;
								min-height: 30px;
								background-color: #333;
								margin: -0.1em 0 0 0;
								padding: 8px 0 8px 0;
							} 
							.u_style #footer p, .u_style #footer ul {
								text-align: center;
								margin: 0; 
							}
							html>body .col { top: 0 } /* hide from ie6 and under  */
							.clearer {
								height: 1px;
								overflow: hidden;
								margin-top: -1px;
								clear: both;
							}
							/* --- sideColumn1 styles --- */
							#sideColumn1 ul {
								height: inherit;					/* test */
								list-style: none;
								padding: 0;
								margin: 10px 0 15px 0;
								/*margin: 0;
								padding: 0;*/
								
							}
							* html #sideColumn1 ul {
								height: 1%;					/* IE6 fix to give list "hasLayout" */
							}
							#sideColumn1 ul li{
								padding: 0;
								display: block; /* Fix for IE excessive space between list items */
								padding: 3;
								border-bottom: none;
								/*border-bottom: 2px solid #7e0000;*/
							}
							#sideColumn1 a {
								/*display: block;*/
								font-weight: normal;
								font-size: .8em;
								text-decoration: none;
								padding: 5px;
							}
							#sideColumn1 a:link, #sideColumn1 a:visited { 
								color:#fff; 
								background-color: #900; 
							}
							#sideColumn1 a:focus, #sideColumn1 a:hover, #sideColumn1 a:active { 
								color: #fff; 
								background-color: #600; 
							}
							
							#sideColumn1 h3 {
								font-family: Georgia, "Times New Roman", Times, serif;
								font-size: 70%;
								font-weight: normal; 
								text-transform: uppercase;
								margin-bottom: 0;
								padding: 0.5em 0 0 10px;
								color: #dac092;
								border-bottom: 2px solid #7e0000;
							}
							
							/* --- footer styles --- */
							.u_style #footer ul {
								width: 100%;
								list-style: none;
								margin: 0;
								padding: 2px 0 0 0;
							}
							.u_style #footer ul li{
								display: inline;
								font-family: Arial, Helvetica, "Trebuchet MS",Verdana, sans-serif;
								font-size: .6em;
								font-weight: bold;
								letter-spacing: 0.05em;
								text-transform: uppercase;
								color: #fff;
								padding: 0 .2em 0 .5em;
							}
							.u_style #footer li + li {
								border-left: #fff 1px solid;
							}
							.u_style #footer a:link, .u_style #footer a:visited { 
								color: #fff; 
								text-decoration: none; 	
							}
							.u_style #footer a:focus, .u_style #footer a:hover, .u_style #footer a:active { 
								color: #dac092; 
								text-decoration: none; 	
							}

					]]></style>
				<xsl:text disable-output-escaping="yes"><![CDATA[
						<!--[if lt IE 7]>
						<style type="text/css">
						.col{height:1000em;}
						.u_style #wrapper {width: 58em;}
						/*ie5 needs this */
						#footer,#header {height:1px}
						</style>
						<![endif]-->
						
						<!-- The code block below is a conditional comment for IE7 and newer. -->
						<!--[if gte IE 7]>
						<style type="text/css">
						.u_style #headerRight div a {zoom: 1;}
						</style>
						<![endif]-->
				]]></xsl:text>
				<script type="text/javascript">

					function start() {
					window.resizeTo(1250, 1000);
					setContent('
					<xsl:value-of select="//feed[1]/entry[1]/link/@href" />
					');
					}
				</script>
			</head>
			<body class="u_style" onload="start();">
				<script type="text/javascript"><![CDATA[
					function setContent(url) {
						if (url.search("medlineplus") == -1) {
							var contentPanel = document.getElementById("contentPanel");
							contentPanel.src = url;
						}
						else {
							window.open(url);
						}
					}
				]]></script>
				<div id="wrapper">
					<!--begin #header -->
					<div id="header">
						<div id="headerWrapper">
							<div id="headerLeft">
								<!--<a href="http://www.utah.edu"> <img src="images/header/HSC_logo.gif" 
									alt="U of U Campus Organization" width="270" height="65" border="0"/> </a> -->

							</div>
						</div>
						<div id="headerNavBar">

						</div>
					</div>
					<!-- begin innerWrapper -->
					<div id="innerWrapper">
						<!-- begin #sideColumn1 -->
						<div id="sideColumn1">

							<xsl:for-each select="//feed">

								<h3>
									<xsl:value-of select="title" />
								</h3>
								<div>
									<ul>
										<xsl:for-each select="entry">
											<li>
												<a href="javascript:void(0);">
													<xsl:attribute name="onclick">setContent('<xsl:value-of
														select="link/@href" />');</xsl:attribute>
													<!-- <xsl:value-of select="ns3:category/ns2:subTopic/ns2:value/@displayName"/> -->
													<xsl:value-of select="title" />
												</a>
											</li>
										</xsl:for-each>
									</ul>
								</div>
							</xsl:for-each>

						</div>
						<div id="content">
							<iframe id="contentPanel" width="995" height="750"
								scrolling="auto" />
							<!-- end #content -->
						</div>
						<div class="clearer" />
						<div class="col side1" />
						<div class="col mid" />
					</div>
					<div id="footer">
						<!--<ul> <li>The University of Utah</li> <li>Department of Biomedical 
							Informatics</li> <li>801.Phone.Number</li> </ul> <ul> <li> <a href="http://www.utah.edu/" 
							target="_blank">The University of Utah</a> </li> <li> <a href="mailto:contact-email@utah.edu">Webmaster</a> 
							</li> <li> <a href="http://www.utah.edu/disclaimer/index.html" target="_blank">Disclaimer</a> 
							</li> <li> <a href="http://www.utah.edu/privacy/" target="_blank">Privacy</a> 
							</li> </ul> -->
					</div>
				</div>

			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>
