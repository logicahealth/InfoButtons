<%--
  #%L
  searchResultsHtml.jsp - oib-rest-responder - University of Utah - 2,010
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
<?xml version="1.0"?>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="www.w3.org/1999/xhtml">
    <body>
        <h2>${atomFeedMetadata['title']}</h2>
        <table border="1">
            <tr>
                <td>Content URN</td>
                <td>Title</td>
            </tr>
            <c:forEach items="${assets}" var="asset">
            <tr>
                <td>${atomFeedMetadata['entry.id.urnPrefix']}${asset.assetId}</td>
                <td><a href="${asset.assetUrl}">${asset.displayName}</a></td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
