<jsp:include page="header.jsp"/>




<div class="jumbotron jumbotron-fluid">
    <div class="container">
        <h1 class="display-4">${app.appUrl} </h1>
    </div>
</div>

<p>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/addrole" role="button">set new role</a>
</p>

<jsp:include page="footer.jsp"/>