<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:output indent="yes" method="xml" encoding="utf-8"
		omit-xml-declaration="no" />

	<xsl:template match="@*|node()">
		<xsl:copy>
			<xsl:apply-templates select="@*|node()" />
		</xsl:copy>
	</xsl:template>

	<xsl:variable name="category" select="/feed/category" />
	<xsl:variable name="feedMSC" select="$category/mainSearchCriteria/value" />


	<xsl:template match="/feed/category">

		<category>
			<xsl:copy-of select="/feed/category/@*" />
		</category>

		<xsl:if test="mainSearchCriteria">
			<category scheme="mainSearchCriteria.v.c">
				<xsl:attribute name="term">
	              <xsl:value-of select="$feedMSC/@code" />
	            </xsl:attribute>
			</category>
			<category scheme="mainSearchCriteria.v.cs">
				<xsl:attribute name="term">
                  <xsl:value-of select="$feedMSC/@codeSystem" />
                </xsl:attribute>
			</category>
			<category scheme="mainSearchCriteria.v.dn">
				 <xsl:attribute name="term">
             		<xsl:value-of select="$feedMSC/@displayName" />
         		 </xsl:attribute>
			</category>
		</xsl:if>
		<xsl:if test="mainSearchCriteria/severityObservation">
			<category scheme="severityObservation.interpretationCode.c">
				<xsl:attribute name="term">
	              <xsl:value-of select="$category/mainSearchCriteria/severityObservation/@code" />
	            </xsl:attribute>
			</category>
			<category scheme="severityObservation.interpretationCode.cs">
				<xsl:attribute name="term">
                  <xsl:value-of select="$category/mainSearchCriteria/severityObservation/@codeSystem" />
                </xsl:attribute>
			</category>
			<category scheme="severityObservation.interpretationCode.dn">
				 <xsl:attribute name="term">
             		<xsl:value-of select="$category/mainSearchCriteria/severityObservation/@displayName" />
         		 </xsl:attribute>
			</category>
		</xsl:if>
		<xsl:if test="informationRecipient">
			<category scheme="informationRecipient">
				<xsl:attribute name="term">
	              <xsl:value-of select="$category/informationRecipient/*/@classCode" />
                </xsl:attribute>
			</category>
		</xsl:if>
	</xsl:template>
</xsl:stylesheet>