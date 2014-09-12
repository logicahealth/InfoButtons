<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions" xmlns:ns2="urn:hl7-org:v3" xmlns:ns3="http://www.w3.org/2005/Atom:atom">
	<xsl:output method="html" version="1.0" encoding="UTF-8" indent="yes"/>
	<xsl:template match="/">
		<html>
			<head>
<!-- EDIT BELOW FOR FORMATTING / CSS CHANGES -->
				<title>AXEIUM EHR OpenInfobutton</title>
				<style type="text/css">
<![CDATA[
						/* panel background*/
						.linkDiv 
						{
							position:absolute;
							padding: 10px;
							top:100px;
							left:0px;
							width:200px;
							height: 730px;
							border: none;
							border-bottom: 2px #696969 solid; 	/* dark gray */
							background-color: #F3F1E6;  		/* axeium bg panel */
							font-family:Arial;
							font-size:11pt;
						}
						
						
						/* Service Provider Name */
						.linkDiv h3
						{
							color: #4B4B4B; 	/* dark gray */
							font-size:11pt
						}
						
						
/* N/A as there is no link at this level, css has no affect. */
						.linkDiv a:visited, a:link,  a:hover 
						{
							color: fuchsia; 
							border: none;
							outline: none;
							display: block;
							margin-top:0px;
							font-weight: bold;
						}

						
						/* Link Item */
						.linkDiv ul li a:link   /* REMOVE a:active a:visited  */
						{
							color: blue; 
							border: none;
							outline: none;
							font-weight: normal;
						}

/* ? does not work */						
						.linkDiv ul li a:active
						{
							color: fuchsia;
							border: none;
							outline: none;
							font-weight: normal;
						}
						
/* ? does not work */						
						.linkDiv ul li a:visited
						{
							color: fuchsia;
							border: none;
							outline: none;
							font-weight: normal;
						}
						
						
						/* Link item symbol (bullet) */
						.linkDiv li
						{
							color: purple;
							margin-left: -10px;
						}
						
						
						.linkDiv ul
						{
							margin-top: -10px;
						}
						
						
						/* iFrame panel */
						.infoDiv
						{
							position: absolute;
							top:100px;
							left:221px;
							width: 1000px;
							height: 750px;
							border-top: 2px #696969 solid;
							border-right: none;
							border-bottom: none;
							border-left: 5px #696969 solid; 
						}
						
						
						/* Content panel */
						#contentPanel
						{
							height: 747px; /* was 750 */
							width: 1000px;
							border-top: 2px #FFE6B5 solid; 
							border-left: 2px #D16800 solid;
							border-right: none;
							border-bottom: none;
						}
						
						
						/* background (image) behind banner */
						.header
						{
							position:absolute;
							width:1225px;
							top: 0px;
							left: 0px;
							height:100;
							background-image: url(http://infobutton.axeium.net/images/AXEIUM-Infobutton-behind-banner-39x100.gif);
														background-repeat: repeat-x;
						}
						
						
						/* header banner (image) */
						.logo
						{
							width:1226px; /* was 996, but header is 1225 ... and added +1 to get exact horiz alighnment with iframe */
							position:absolute;
							top: 0px;
							left: 0px;
							height:100;
							background-image: url(http://infobutton.axeium.net/images/AXEIUM-Infobutton-ResultManager-Banner-1226x100v2.png);
							background-repeat: no-repeat;
						}

					]]></style>
					
					<xsl:text disable-output-escaping="yes">
<![CDATA[
<!--[if IE 7 ]> 
					<style type="text/css">
					.infoDiv
					{
						left:201px;
						height:700px;
					}
					
					.header
					{
					 width:1200px;
					}
					.linkDiv a:visited, a:link, a:active
					{
						color: blue;
						border: none;
						outline: none;
						font-weight: bold;
						display: block;
						margin-top: -10px;
					}
					
					.linkDiv ul li a:link, .linkDiv ul li a:visited, .linkDiv ul li a:active 
					{
						padding: 0px;
						margin-bottom:0px;
						display: inline;
					}
					
					#contentPanel
					{
						height:730px;
					}
					</style>
				<![endif]-->
				]]>
				
				</xsl:text>

				<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"/> 
				<script type="text/javascript">
					function start() {
						window.resizeTo(1250, 1000);
						setContent('<xsl:value-of select="//feed[1]/entry[1]/link/@href"/>');
					}
				</script>  
			</head>

		<body onload="start();">
				<script type="text/javascript">
				<![CDATA[
					function setContent(url) {
						if (url.search("medlineplus") == -1) {
							var contentPanel = document.getElementById("contentPanel");
							contentPanel.src = url;
						}
						else {
							window.open(url);
						}
					}
					$(document).ready(function() {
						$(".linkDiv ul li a").hover(function() {
							$(this).css("color", "#D16800"); /* menu item forecolor, DURING hover event*/
						}, function() {
							$(this).css("color", "blue");   /* menu item forecolor, AFTER hover event*/
						});
				
						$(".linkDiv ul li").hover(function() {
							$(this).css("background-color", "transparent");  /* menu item bgcolor, DURING hover event*/
						}, function() {
							$(this).css("background-color", "transparent");  /* menu item bgcolor, AFTER hover event*/
						});
						
					});
				]]>
				</script>
				<div class="header"><div class="logo"/></div>
				<div class="linkDiv">
					<xsl:for-each select="//feed">
						<h3><xsl:value-of select="title"/></h3>
						<ul>
							<xsl:for-each select="entry">
								<li>
									<a href="javascript:void(0);">
										<xsl:attribute name="onclick">setContent('<xsl:value-of select="link/@href"/>');</xsl:attribute>
										<!-- <xsl:value-of select="category/ns2:subTopic/ns2:value/@displayName"/> -->
										<xsl:value-of select="title"/>
									</a>
								</li>
							</xsl:for-each>
						</ul>
					</xsl:for-each>
				</div>
				<div class="infoDiv">
					<iframe id="contentPanel"/>
				</div>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>