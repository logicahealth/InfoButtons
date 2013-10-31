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
