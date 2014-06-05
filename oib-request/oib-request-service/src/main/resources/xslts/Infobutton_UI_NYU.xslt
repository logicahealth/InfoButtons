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
				<title>CPRS OpenInfobutton</title>
				<style type="text/css"><![CDATA[
						@charset "UTF-8";
							
						html, body
							{margin-top:0px;margin-left:0px;
							font-family:Verdana, Geneva, sans-serif;
							border: none; 
							height: 100%; 
							width: 100%;}

						.linkDiv
						{
							position:absolute;
							padding: 0px 0px 0px 0px;
							margin:0px 0px 0px 0px;
							left:5px;
							height: 684px;
							width:219px;
							border: solid 1px black;
							border-top:0px;
							border-left:0px;
							background-color: white;
							font-family:Verdana, Geneva, sans-serif;
							font-size:10pt;
						}
						
						.linkDiv h3
						{
							color: black;	
							font-size:10pt;
							line-height:20px;
						}
						
						.linkDiv a:visited, a:link, a:active
						{
							border: none;
							outline: none;
							text-decoration:none;
							margin-top:0px;
						}
						
						.linkDiv a:visited, a:active, a:hover
						{				
							color: #a882c2;
						}
						
						.linkDiv a:link
						{				
							color: #580f8b;
						}
						
						.linkDiv ul li a:link, .linkDiv ul li a:visited, .linkDiv ul li a:active
						{
							border: none;
							outline: none;
							font-weight: normal;
						}
						
						.linkDiv li
						{
							color:  #580f8b;
							line-height:15px;
							list-style:none;
							margin-left: -10px;
						}
						
						.linkDiv ul li a:visited, .linkDiv ul li a:active, .linkDiv ul li a:hover
						{
							color: #a882c2;
						} 
						
						.linkDiv ul li a:link
						{
							color: #580f8b;
						} 
						
						.linkDiv ul
						{
							margin-top: -15px;
						}
						
						.infoDiv
						{
							position: absolute;
							top:0px;
							left:225px;
							padding: 0px 0px 0px 0px;
							margin:0px 0px 0px 0px;
							width: 1000px;
							height: 748px;
							border: 0px;
						}
						
						#contentPanel
						{
							border:1px solid #000000;
							border-left:0px;
							padding: 0px 0px 0px 0px;
							margin:0px 0px 0px 0px;
							width: 1000px;
							height: 748px;
							frameborder:0;
						}
						
						.header
						{
							position:relative;
							left:10px;
							height:65px;
							width:214px;
							border: solid 1px black;
							border-top:0px;
							border-bottom:0px;
							border-left:0px;
							background-image: url('http://archives.med.nyu.edu/tools/infobuttons/images/NYU_Library_purp_three_line.jpg');
							background-repeat:no-repeat;
							background-position:left;
						}
												
						.logo
						{
							/*background-image: url('http://hsl.med.nyu.edu/sites/all/themes/boing/images/nyulmc-logo.png');
							width:200px;
							height:50px;
							position:absolute;
							background-repeat:no-repeat;
							background-position:left;*/
							width:0px;
							height:0px;
						}
						
						.search_term
						{
						padding-top:20px;
						font-family:Verdana, Geneva, sans-serif;
						font-size:11px;
						color:#666;
						font-style:italic;
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
				<!--</head> -->
				<!--<body class="u_style"> -->
				<script type="text/javascript"
					src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.3/jquery.min.js"></script>

				<script type="text/javascript"><![CDATA[
					 $(document).ready(function() {  $(".header").click(function () {  window.location = 'http://hsl.med.nyu.edu';  });  });
				]]></script>

				<script src="http://code.jquery.com/jquery-latest.min.js"
					type="text/javascript"></script>

				<script type="text/javascript">
					function start() {
					window.resizeTo(1250, 1000);
					setContent('
					<xsl:value-of select="//feed[1]/entry[1]/link/@href" />
					');
					}
				</script>
			</head>


			<body onLoad="start();">
				<script type="text/javascript"><![CDATA[
				function setContent(url) {
	if (url.search("medlineplus") == -1) {
		var contentPanel = document.getElementById("contentPanel");
		contentPanel.src = url;
	}
	else {
		window.open(url);
	}
};


function gup( name )
{
	name = name.replace(/[\[]/,"\\\[").replace(/[\]]/,"\\\]");
	var regexS = "[\\?&]"+name+"=([^&#]*)";
	var regex = new RegExp( regexS );
	var results = regex.exec( window.location.href );
	if( results == null )
		return "";
	else
		return results[1];
}
					
				]]></script>


				<div class="header">
					<div class="logo"></div>
				</div>
				<div class="linkDiv">

					<p class="search_term">
						Resources for:
						<strong>
							<xsl:value-of select="//feed[1]/subtitle" />
						</strong>
					</p>

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
											<!-- <xsl:value-of select="category/subTopic/value/@displayName"/> -->
											<xsl:value-of select="title" />
										</a>
									</li>
								</xsl:for-each>
							</ul>
						</div>
					</xsl:for-each>

				</div>
				<div class="infoDiv">
					<iframe id="contentPanel" frameborder="0"></iframe>
				</div>

			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>
