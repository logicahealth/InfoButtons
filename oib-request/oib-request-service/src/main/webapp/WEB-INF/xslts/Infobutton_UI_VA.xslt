<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions" xmlns:ns2="urn:hl7-org:v3" xmlns:ns3="http://www.w3.org/2005/Atom:atom">
	<xsl:output method="html" version="1.0" encoding="UTF-8" indent="yes"/>
	<xsl:template match="/">
		<html>
			<head>
				<title>CPRS OpenInfobutton</title>
				<style type="text/css"><![CDATA[
						.linkDiv
						{
							position:absolute;
							padding: 10px;
							top:100px;
							left:0px;
							width:200px;
							height: 730px;
							border: solid 1px black;
							background-color: #000063;
							font-family:Arial;
							font-size:11pt;
						}
						
						.linkDiv h3
						{
							color: yellow;	
							font-size:11pt
						}
						
						.linkDiv a:visited, a:link, a:active
						{
							color: yellow;
							border: none;
							outline: none;
							display: block;
							margin-top:0px;
							font-weight: bold;
						}
						
						.linkDiv ul li a:link, .linkDiv ul li a:visited, .linkDiv ul li a:active 
						{
							color: white;
							border: none;
							outline: none;
							font-weight: normal;
						}
						.linkDiv li
						{
							color: White;
							margin-left: -10px;
						}
						
						
						.linkDiv ul
						{
							margin-top: -10px;
						}
						
						.infoDiv
						{
							position: absolute;
							top:100px;
							left:221px;
							width: 1000px;
							height: 750px;
						}
						
						#contentPanel
						{
							height: 750px;
							width: 1000px;
						}
						
						.header
						{
							position:absolute;
							width:1225px;
							top: 0px;
							left: 0px;
							height:100;
							background-image: url('images/behind-banner.gif');
							background-repeat: repeat-x;
						}
						
						.logo
						{
							width:996px;
							position:absolute;
							top: 0px;
							left: 0px;
							height:100;
							background-image: url('images/inter-header-banner-print.gif');
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
						color: yellow;
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
							$(this).css("color", "yellow");
						}, function() {
							$(this).css("color", "white");
						});
				
						$(".linkDiv ul li").hover(function() {
						$(this).css("background-color", "#33335C");
						}, function() {
							$(this).css("background-color", "transparent");
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
										<!-- <xsl:value-of select="category/subTopic/value/@displayName"/> -->
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