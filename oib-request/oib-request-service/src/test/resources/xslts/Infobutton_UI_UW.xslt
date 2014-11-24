<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions" xmlns:ns2="urn:hl7-org:v3" xmlns:ns3="http://www.w3.org/2005/Atom:atom">
	<xsl:output method="html" version="1.0" encoding="UTF-8" indent="yes"/>
	<xsl:template match="/">
		<html>
			<head>
				<link rel="stylesheet" href="http://depts.washington.edu/uweb/inc/css/header.css" type="text/css" media="screen"/>
				<link rel="stylesheet" href="http://depts.washington.edu/uweb/inc/css/print.css" type="text/css" media="print"/>
				<script type="text/javascript">
					function make_blank() {if(document.uwglobalsearch.q.value=="Search the UW") {document.uwglobalsearch.q.value = "";}}
				</script>
				<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
				<title>UW OpenInfobutton</title>
				<style type="text/css">
						.linkDiv
						{
							position:absolute;
							padding: 10px;
							top:25px;
							left:0px;
							width:200px;
							height: 730px;
							border: solid 1px black;
							background-color: #DFDDE8;
							font-family:Frutiger, Arial;
							font-size:10pt;
						}
						
						.linkDiv h3
						{
							color: #8e632a;	
							font-size:10pt
						}
						
						.linkDiv a:visited, a:link, a:active
						{
							color: grey;
							border: none;
							outline: none;
							display: block;
							margin-top:0px;
							font-weight: bold;
						}
						
						.linkDiv ul li a:link, .linkDiv ul li a:visited, .linkDiv ul li a:active 
						{
							color: black;
							border: none;
							outline: none;
							font-weight: normal;
						}
						.linkDiv li
						{
							color: grey;
							margin-left: -10px;
						}
						
						
						.linkDiv ul
						{
							margin-top: -10px;
						}
						
						.infoDiv
						{
							position: absolute;
							top:25px;
							left:221px;
							width: 1000px;
							height: 800px;
						}
						
						#contentPanel
						{
							height: 750px;
							width: 1000px;
						}
				</style>

				<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"/>
				<script type="text/javascript">
					function start() {
						window.resizeTo(1250, 1000);
						setContent('<xsl:value-of select="//feed[1]/entry[1]/link/@href"/>');
					}
				</script>
			</head>
			<body onload="start();">
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
					$(document).ready(function() {
						$(".linkDiv ul li a").hover(function() {
							$(this).css("color", "white");
						}, function() {
							$(this).css("color", "black");
						});
				
						$(".linkDiv ul li").hover(function() {
						$(this).css("background-color", "#39275B");
						}, function() {
							$(this).css("background-color", "transparent");
						});
					});
				]]></script>
				<div id="wheader" class="colorPurple wYes patchNo">
					<div id="autoMargin">
						<div class="wlogoSmall">
							<div class="logoAbsolute"><a id="wlogoLink" href="http://www.washington.edu/">W</a></div>
							<div><a href="http://www.washington.edu/">University of Washington</a></div>
						</div>
					</div>
				</div>

				<div class="linkDiv">
					<xsl:for-each select="//feed">
						<h3>
							<xsl:value-of select="title"/>
						</h3>
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
