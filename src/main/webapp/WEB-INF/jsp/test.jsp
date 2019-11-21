<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<h1>test</h1>
<html lang="en">

<body>
<c:forEach var="user" items="${users}">
    <p>
        <c:out value="${user.name}" />
    </p>
</c:forEach>
</body>
</html>