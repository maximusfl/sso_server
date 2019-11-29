<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp"/>




<div class="jumbotron jumbotron-fluid">
    <div class="container">
        <h1 class="display-4">Alter ${role.roleNmae} role </h1>
    </div>
</div>


<form action="${pageContext.request.contextPath}/roles/update/${role.id}" method="POST">




    <div class="form-group">
        <input textarea class="form-control" value="${role.roleNmae}" name="rolename" id="exampleFormControlTextarea1" rows="1" required></textarea>
    </div>
    <div class="form-group">

        <input textarea class="form-control" name="roledescription" value="${role.roleDescription}" id="exampleFormControlTextarea2" rows="3" required></textarea>
    </div>

    <button type="submit" class="btn btn-primary">save</button>


</form>
<p>
<form action="${pageContext.request.contextPath}/roles/delete/${role.id}" method="POST">
     <button type="submit" class="btn btn-danger">remove</button>
</form>
</p>


<jsp:include page="footer.jsp"/>
