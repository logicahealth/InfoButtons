<?xml version="1.0" encoding="UTF-8"?><!-- DWXMLSource="responseSample.xml" -->
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions">
	<xsl:output method="html" encoding="UTF-8" indent="yes"/>
	<xsl:variable name="htmlType" select="'html'"/>

	<xsl:template match="/">
		<html>
			<head>
				<meta charset="utf-8"/>
				<title>.: OpenInfobutton :.</title>
				<script src="css/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
				<!-- Bootstrap core CSS -->
				<link href="css/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet"/>
				<!-- Custom styles for this template -->
				<link href="css/bootstrap/features.css" rel="stylesheet"/>
				<style>
					a {
					color: #000000;
					text-decoration: none;
					}

					a:hover {
					color:#00A0C6;
					text-decoration:none;
					cursor:pointer;
					}

					main > .container {
					padding: 60px 15px 0;
					}

				</style>
			</head>
			<body>
				<header>
					<!-- Fixed navbar -->
					<nav class="navbar navbar-expand-md navbar-dark fixed-top" style="background-color: RGB(224,221,232)">
						<div class="container-fluid">
							<img src="images/logos/UW.png" width="600"/>
							<img src="images/project_logo_no_background.png" style="float: right" height="94" width="363"/>

						</div>
					</nav>
				</header>

				<main class="flex-shrink-0" style="padding-top: 80px">
					<div class="container px-4 py-5" id="featured-3">
						Resources for:
						<strong>
							<xsl:value-of select="//feed[1]/subtitle" />
						</strong>

						<xsl:for-each select="//feed">

							<h2 class="pb-2 pt-5 border-bottom">
								<xsl:choose>
									<xsl:when test="title=' UpToDate'">
										<img src="https://raw.githubusercontent.com/logicahealth/InfoButtons/development/profilestore/UpToDate.png" style="max-height: 80px; max-width: 200px;"/>
									</xsl:when>
									<xsl:when test="title='MedlinePlus'">
										<img src="https://raw.githubusercontent.com/logicahealth/InfoButtons/development/profilestore/MedlinePlus.png" style="max-height: 80px; max-width: 200px;"/>
									</xsl:when>
									<xsl:when test="title='ClinicalTrials.gov'">
										<img src="https://raw.githubusercontent.com/logicahealth/InfoButtons/development/profilestore/ClinicalTrials.gov.png" style="max-height: 80px; max-width: 200px;"/>
									</xsl:when>
									<xsl:when test="title='PubMed'">
										<img src="https://raw.githubusercontent.com/logicahealth/InfoButtons/development/profilestore/PubMed.png" style="max-height: 80px; max-width: 200px;"/>
									</xsl:when>
									<xsl:when test="title='Krames Staywell'">
										<img src="https://raw.githubusercontent.com/logicahealth/InfoButtons/development/profilestore/Krames Staywell.png" style="max-height: 80px; max-width: 200px;"/>
									</xsl:when>
									<xsl:when test="title='Medical Home Portal'">
										<img src="https://raw.githubusercontent.com/logicahealth/InfoButtons/development/profilestore/Medical Home Portal.png" style="max-height: 80px; max-width: 200px;"/>
									</xsl:when>
									<xsl:when test="title='Sanford Guide'">
										<xsl:value-of select="title"/>
										<img src="https://raw.githubusercontent.com/logicahealth/InfoButtons/development/profilestore/Sanford Guide.png" style="max-height: 80px; max-width: 200px;"/>
									</xsl:when>
									<xsl:when test="contains(., 'Mosby')">
										<img src="https://raw.githubusercontent.com/logicahealth/InfoButtons/development/profilestore/Elsevier Mosbys Skills.gif" style="max-height: 80px; max-width: 200px;"/>
									</xsl:when>
									<xsl:otherwise>
										<xsl:value-of select="title"/>
									</xsl:otherwise>
								</xsl:choose>
							</h2>

							<div class="row g-4 px-4 py-1 row-cols-1 row-cols-lg-3">
								<xsl:for-each select="entry">
									<xsl:variable name="flushHeading" select="concat('flush-heading', generate-id())"/>
									<xsl:variable name="flushCollapse" select="concat('flush-collapse', generate-id())"/>
									<xsl:variable name="accordionFlush" select="concat('accordionFlush', generate-id())"/>
									<div class="feature col">
										<h3 style="display:inline">

											<a class="icon-link">
												<xsl:attribute name="href">
													<xsl:value-of select="link/@href"/>
												</xsl:attribute>
												<xsl:value-of select="title"/>
											</a>

										</h3>


										<xsl:if test="summary/@type = $htmlType">
											<div class="accordion accordion-flush">
												<xsl:attribute name="id"><xsl:value-of select="$accordionFlush"/></xsl:attribute>
												<div class="accordion-item">
													<h2 class="accordion-header">
														<xsl:attribute name="id"><xsl:value-of select="$flushHeading"/></xsl:attribute>
														<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
																aria-expanded="false">
															<xsl:attribute name="data-bs-target"><xsl:value-of select="concat('#', $flushCollapse)"/></xsl:attribute>
															<xsl:attribute name="aria-controls"><xsl:value-of select="$flushCollapse"/></xsl:attribute>
															Details...
														</button>
													</h2>
													<div class="accordion-collapse collapse">
														<xsl:attribute name="id"><xsl:value-of select="$flushCollapse"/></xsl:attribute>
														<xsl:attribute name="aria-labelledby"><xsl:value-of select="$flushHeading"/></xsl:attribute>
														<xsl:attribute name="data-bs-parent"><xsl:value-of select="concat('#', $accordionFlush)"/></xsl:attribute>
														<div class="accordion-body">
															<xsl:value-of select="summary"/>
														</div>
													</div>
												</div>
											</div>
										</xsl:if>

									</div>
								</xsl:for-each>
							</div>

							<!--							<div class="b-example-divider"></div>-->



						</xsl:for-each>

					</div>
				</main>

				<footer class="footer mt-auto py-3 bg-light">
					<div class="container">
						<span class="text-muted">Powered by <a href="https://www.openinfobutton.org/" target="_blank"><img src="images/project_logo.svg" width="170" height="37"/></a></span>
					</div>
				</footer>

			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>