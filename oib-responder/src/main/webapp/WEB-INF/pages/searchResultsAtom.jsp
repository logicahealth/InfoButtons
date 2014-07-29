<?xml version="1.0" encoding="UTF-8"?><%@page import="java.text.SimpleDateFormat"%><%@page contentType="text/xml; charset=UTF-8"%><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%--
  #%L
  searchResultsAtom.jsp - oib-rest-responder - University of Utah - 2,010
  org.codehaus.mojo-license-maven-plugin-1.7
  $Id: update-file-header-config.apt.vm 18717 2013-09-15 10:12:58Z dennisl $
  $HeadURL: https://svn.codehaus.org/mojo/tags/license-maven-plugin-1.7/src/site/apt/examples/update-file-header-config.apt.vm $
  %%
  Copyright (C) 2010 - 2014 University of Utah
  %%
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
  
       http://www.apache.org/licenses/LICENSE-2.0
  
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
  #L%
  --%>
<feed xmlns="http://www.w3.org/2005/Atom" 
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
      xml:lang="en" 
      xml:base="${atomFeedMetadata['xml.base']}"       
      xsi:schemaLocation="KnowledgeResponse.xsd">
	<title type="text">${atomFeedMetadata['title']}</title><c:if test="${not empty atomFeedMetadata['author.name'] or not empty atomFeedMetadata['author.uri']}">
	<author><c:if test="${not empty atomFeedMetadata['author.name']}">
		<name>${atomFeedMetadata['author.name']}</name></c:if><c:if test="${not empty atomFeedMetadata['author.uri']}">
		<uri>${atomFeedMetadata['author.uri']}</uri></c:if>
	</author></c:if><% SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); String updateString = sdf.format(new java.util.Date()); %>
	<updated><%=updateString %></updated><c:forEach items="${requestParameters}" var="parameter">
	<category scheme="${parameter.key}" term="${parameter.value}"/></c:forEach>
	<id>${atomFeedMetadata['id.urn']}</id><c:forEach items="${assets}" var="asset">
	<entry xml:lang="en">
		<title type="text">${asset.displayName}</title>
		<link href="${asset.assetUrl}" hreflang="en" rel="via" type="${asset.assetMimeType}" title="${asset.displayName}"/>
		<id>${atomFeedMetadata['entry.id.urnPrefix']}${asset.assetId}</id>
		<updated><fmt:formatDate value="${asset.lastUpdateDate}" pattern="yyyy-MM-dd'T'HH:mm:ss"/></updated><c:forEach items="${asset.assetProperties}" var="indexProperty"><c:set var="typeMap" value="${indexPropertyInterpretationMap[indexProperty.propertyName]}"/><c:if test="${not empty typeMap['CODE'] and not empty indexProperty.code}">
		<category scheme="${typeMap['CODE']}" term="${indexProperty.code}"/></c:if><c:if test="${not empty typeMap['CODE_SYSTEM'] and not empty indexProperty.codeSystem}">
		<category scheme="${typeMap['CODE_SYSTEM']}" term="${indexProperty.codeSystem}"/></c:if><c:if test="${not empty typeMap['DISPLAY_NAME'] and not empty indexProperty.displayName}">
		<category scheme="${typeMap['DISPLAY_NAME']}" term="${indexProperty.displayName}"/></c:if></c:forEach>
	</entry></c:forEach>
</feed>