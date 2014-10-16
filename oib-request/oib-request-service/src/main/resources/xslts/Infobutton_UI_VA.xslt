<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions">
	<xsl:output method="html" version="1.0" encoding="UTF-8" indent="yes"/>
	<xsl:template match="/">
		<html>
			<head>
			<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<!-- EDIT BELOW FOR FORMATTING / CSS CHANGES -->
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
						
						.linkDiv a:visited, a:link
						{
							color: yellow;
							border: none;
							outline: none;
							display: block;
							margin-top:0px;
							font-weight: bold;
						}
						
						.linkDiv ul li a:link 
						{
							color: white;
							border: none;
							outline: none;
							font-weight: normal;
							display: inline;
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

				<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"/> 
				<script type="text/javascript">
					function start() {
						window.resizeTo(1250, 1000);
						setContent('<xsl:value-of select="//feed[1]/entry[1]/link/@href"/>', '<xsl:value-of select="//feed[1]/entry[1]/id"/>');
					}
				</script>  
			</head>

		<body onload="start();">
				<script type="text/javascript">
				<![CDATA[
					function setContent(url, linkId) {
						var selectedLinks = document.getElementsByClassName('selected'), i;
						for (var i = 0; i < selectedLinks.length; i ++) {
						    selectedLinks[i].style.display = 'none';
						}
						document.getElementById(linkId).style.display = 'inline';
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
										<xsl:attribute name="onclick">setContent('<xsl:value-of select="link/@href"/>','<xsl:value-of select="id"/>');</xsl:attribute>
										<xsl:value-of select="title"/>
									</a>
									<div class="selected" style="display:none">
										<xsl:attribute name="id"><xsl:value-of select="id"/></xsl:attribute>
										<img src="images/tick_white.png"></img>							
									</div>
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