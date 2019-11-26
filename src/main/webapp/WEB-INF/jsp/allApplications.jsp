<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>

<p>Registred applications </p>

<table class="table">
    <thead class="thead-light">
    <tr>
        <th scope="col">S/N</th>
        <th scope="col">url</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="app" items="${apps}">
        <tr>
            <th scope="row">${app.id}</th>
            <td><a href="${pageContext.request.contextPath}/apps/${app.id}">${app.appUrl}</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<jsp:include page="footer.jsp"/>