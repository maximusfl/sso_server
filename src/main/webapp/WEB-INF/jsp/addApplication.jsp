<jsp:include page="header.jsp"></jsp:include>




<form action="${pageContext.request.contextPath}/add/app" method="POST">



    <label for="basic-url">Enter url for tegistration a new application</label>
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text" id="basic-addon3">http://</span>
        </div>
        <input type="text" name="appurl" class="form-control" id="basic-url" aria-describedby="basic-addon3">
    </div>
    <button type="submit" class="btn btn-primary">Registration</button>
</form>


<jsp:include page="footer.jsp"></jsp:include>