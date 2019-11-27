<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>




<div class="jumbotron jumbotron-fluid">
    <div class="container">
        <h1 class="display-4">${app.appUrl} </h1>
    </div>
</div>

<p>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/addrole/${app.appUrl}" role="button" >set new role</a>
</p>


<table class="table">
    <thead class="thead-light">
    <tr><th scope="col">S/N</th>
        <th scope="col">Role</th>
        <th scope="col">Description</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="role" items="${roles}">
        <tr>
            <th scope="row">${role.id}</th>
            <td>${role.roleNmae}</td>
            <td>${role.roleDescription}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<jsp:include page="footer.jsp"/>