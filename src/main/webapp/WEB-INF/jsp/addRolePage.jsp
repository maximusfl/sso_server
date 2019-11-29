<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>


<div class="jumbotron jumbotron-fluid">
    <div class="container">
        <h1 class="display-4">${appUrl} </h1>
    </div>
</div>

<form action="${pageContext.request.contextPath}/addrole/${appUrl}" method="POST">



    <div class="form-group">
        <label for="exampleFormControlTextarea1">Enter new role for ${appUrl}</label>
        <textarea class="form-control" name="rolename" id="exampleFormControlTextarea1" rows="1" required></textarea>
    </div>
    <div class="form-group">
        <label for="exampleFormControlTextarea2">Add description</label>
        <textarea class="form-control" name="roledescription" id="exampleFormControlTextarea2" rows="3" required></textarea>
    </div>
    <button type="submit" class="btn btn-primary">save</button>
</form>


<jsp:include page="footer.jsp"></jsp:include>
