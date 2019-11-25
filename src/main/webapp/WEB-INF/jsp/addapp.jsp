<jsp:include page="header.jsp"></jsp:include>


<nav class="navbar navbar-light bg-light">
  <span class="navbar-text">
    Add new application
  </span>
</nav>

<form>



    <label for="basic-url">Application's URL</label>
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text" id="basic-addon3">http://</span>
        </div>
        <input type="text" class="form-control" id="basic-url" aria-describedby="basic-addon3">
    </div>

    <div class="form-group">
        <label for="exampleFormControlTextarea">Enter name for default role</label>
        <textarea class="form-control" id="exampleFormControlTextarea" rows="1"></textarea>
    </div>



    <div class="form-group">
        <label for="exampleFormControlTextarea1">Description of default role</label>
        <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>


<jsp:include page="footer.jsp"></jsp:include>