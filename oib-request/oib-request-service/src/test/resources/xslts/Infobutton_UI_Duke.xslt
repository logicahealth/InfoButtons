<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions" xmlns:ns2="urn:hl7-org:v3" xmlns:ns3="http://www.w3.org/2005/Atom:atom" xmlns:metal="http://xml.zope.org/namespaces/metal">
	<xsl:output method="html" version="1.0" encoding="UTF-8" indent="yes"/>
	<xsl:template match="/">
	   <xsl:text disable-output-escaping="yes">&lt;!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"></xsl:text>
		<html>
			<head metal:define-macro="dumcl_head">
				<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
				<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8"/>
				<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
				<title>QuickSearch Results</title>
				<style type="text/css">
				
				<![CDATA[
  body {
    width: 1200px;
    padding-top:2px;
    background-color: #FFFFFF;
    color: black;
    text-align:center;
    margin: 0 auto;
    font-family: Calibri, Arial, Verdana, sans-serif;
    font-size: 14px; 
  }

  img {
    border: none;
  }

  #banner.secondary {
    height:105px;
    background-color: white;
    margin: 0;
    padding: 0;
  }

  #banner.secondary a {
    display: block;
    padding-top:30px;
  }

  #banner.secondary #dukemedicine {
    float:left;
    height:100%;
    width:210px;
    background-color:#7f93c4;
    margin: 0;
    padding: 0;
  }

  #banner.secondary #banner_block1 {
    float:left;
    height:100%;
    width:30px;
    background-color:#bfc9e2;
    margin: 0;
    padding: 0;
  }

  #banner.secondary #banner_block3 {
    float:right;
    height:100%;
    width:120px;
    background-color:#003698;
    text-align:center;
    margin: 0;
    padding: 0;
  }

  #banner.secondary #banner_block3 img {
    width:42px;
    height:52px;
    margin-top:25%;
    padding: 0;
  }

  #rotating_image {
    float: right;
    height: 100%;
    width: 487px;
    border:0px;
    margin: 0;
    padding: 0;
    background-image: url(http://www.mclibrary.duke.edu/images/rotating_banner_images_3/banner-mixed.jpg);
  }

  .top_middle_nav {
    clear:both;
    height:30px;
    width: 100%;
    margin:0;
    padding:0;
    font-family: Verdana, Arial, Helvetica, sans-serif;
    font-size: 11px;
    font-weight: normal;
    color: #FFFFFF;
    border-top-width: 1px;
    border-top-style: solid;
    border-top-color: white;
    background-image: url(http://www.mclibrary.duke.edu/images/TopMiddleNavBarBkgdGradient.gif);
    background-repeat: repeat-x;
  }

  .top_middle_nav ul {
    list-style-type:none;
    margin: 0;
    padding: 0;
    margin-left:10%;
    margin-top: 5px;
  }

  .top_middle_nav ul li {
    display:inline;
    margin: 0;
    padding: 0 10px;
    border-right: white solid 1px;
    background-image: none;
  }

  .top_middle_nav #last_item {
    border-right:0
  }

  .top_middle_nav a {
    color: white;
  }

  .top_middle_nav a:visited {
    color: white;
  }

  .top_middle_nav a:hover {
    color: #BFC9E2;
    text-decoration: none;
  }

  /*end banner*/

  .linkDiv {
    position:absolute;
    top:138px;
    margin:0;
    padding:0;
    width:210px;
    height: 730px;
    background-color: #bfc9e2;
    text-align: left;
    font-family:calibri,Arial,verdana,sans-serif;
    font-size:12pt;
  }
					
  .linkDiv h3 {
    color: black;	
    font-size:100%;
    padding-left: 4px;
  }
						
  .linkDiv a:visited, .linkDiv a:link, .linkDiv a:active {
    color: #002688;
    border: 0px;
    outline: none;
    display: block;
    margin-top:0px;
    font-weight: bold;
  }

  .linkDiv ul li a:link, .linkDiv ul li a:visited, .linkDiv ul li a:active {
    color: #002688;
    border: 0px;
    outline: none;
    font-weight: normal;
  }

  .linkDiv li {
    color: black;
    margin-left: -10px;
  }
						
  .linkDiv ul {
    margin-top: -10px;
  }
						
  .infoDiv {
    float:right;
    width: 1000px;
    height: 730px;
    border: 0px;
    outline: none;
    padding:0;
    margin:0;
  }

#contentPanel {
    height: 100%;
    width: 100%;
    border: 0px;
    outline: none;
    padding:0;
    padding-left:8px;
    margin:0;
  }


					]]></style>
				<xsl:text disable-output-escaping="yes"><![CDATA[
				<!--[if IE 7 ]> 
  <style type="text/css">
  .linkDiv a:visited, .linkDiv a:link, .linkDiv a:active {
    color: #002688;
    border: none;
    outline: none;
    font-weight: bold;
    display: block;
    margin-top: -10px;
  }
					
  .linkDiv ul li a:link, .linkDiv ul li a:visited, .linkDiv ul li a:active {
    padding: 0px;
    margin-bottom:0px;
    display: inline;
  }
					
  #contentPanel {
    height:730px;
  }
  </style>
				<![endif]-->
				]]></xsl:text>
				<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"/>
				<script type="text/javascript">
					function start() {
						window.resizeTo(1250, 1000);
						setContent('<xsl:value-of select="//feed[1]/entry[1]/link/@href"/>');
					}
					
					function closeWindow() {
						  var searchWin =  window.opener;
						  if (searchWin != null) {
							searchWin.focus();
						  }
						  self.close();      
					}

				</script>
			</head>
			<body onload="start();">
				<script type="text/javascript"><![CDATA[
					function setContent(url) {
						if (url.search("acponline") == -1 && url.search("uptodate.com") == -1) {
							window.open(url);
						}
						else {
							var contentPanel = document.getElementById("contentPanel");
							contentPanel.src = url;
						}
					}
					$(document).ready(function() {
						$(".linkDiv ul li a").hover(function() {
							$(this).css("color", "white");
						}, function() {
							$(this).css("color", "#002688");
						});
				
						$(".linkDiv ul li").hover(function() {
						$(this).css("background-color", "#003698");
						}, function() {
							$(this).css("background-color", "transparent");
						});
					});
				]]></script>
				<div id="banner" class="secondary">
					<div id="dukemedicine">
						<div id="banner_block1"/>
						<div id="banner_block3">
							<img src="http://www.mclibrary.duke.edu/images/Duke-Shield-W.gif" alt="Duke Medicine Shield"/>
						</div>
					</div>
					<div id="rotating_image"/>
					<a href="/" style="display: block;padding-top:15px;">
						<img src="http://www.mclibrary.duke.edu/images/DUMC-Library-Logo.gif" alt="Duke University Medical Center Library"/>
					</a>
				</div>
				<div class="top_middle_nav">
					<ul>
						<li>
							<a href="http://library.duke.edu/catalog">
								<strong>Catalog</strong>
							</a>
						</li>
						<li>
							<a href="http://catalog.library.duke.edu/F?func=find-b-0&amp;local_base=journals">
								<strong>All Journals</strong>
							</a>
						</li>
						<li>
							<a href="http://atoz.ebsco.com/search.asp?id=10348">
								<strong>E-Journals</strong>
							</a>
						</li>
						<li>
							<a href="http://www.mclibrary.duke.edu/databases/medline/">
								<strong>MEDLINE</strong>
							</a>
						</li>
						<li>
							<a href="http://www.mclibrary.duke.edu/tools/clinical/">
								<strong>Clinical Tools</strong>
							</a>
						</li>
						<li id="last_item">
							<a href="http://www.mclibrary.duke.edu/services/refform.html">
								<strong>Ask a Librarian</strong>
							</a>
						</li>
					</ul>
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
				    <h3 id="feedback" ><strong><a style="color: red" href="http://www.mclibrary.duke.edu/subject/feedback">Did OuickSearch HELP?</a></strong></h3>
				    <h3 id="closewindow"><a href="http://www.mclibrary.duke.edu/tools/clinical/ClinSearch">Return to Search Screen</a></h3>
				</div>
				<div class="infoDiv">
					<iframe id="contentPanel"/>
				</div>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>