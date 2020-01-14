
<#include "header.ftl">



<#import "/spring.ftl" as spring/>

<h1></h1>
<section class="h-100">
    <header class="container h-100">
        <div class="d-flex align-items-center justify-content-center h-100">
            <div id="signupbox" style=" margin-top:50px"
                 class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <div class="panel-title">Sign Up</div>
                        <div style="float:right; font-size: 85%; position: relative; top:-10px">
                        </div>
                        <div class="panel-body">
                            <form id="signupform" name="user" action="registration" method="post" class="form-horizontal" role="form">
                                <input type="hidden" name="url" value="${user.urlBeforeRedirect}">

                                <div id="signupalert" style="display:none" class="alert alert-danger">
                                    <p>Error:</p>
                                    <span></span>
                                </div>
                                <div class="form-group">
                                    <label for="email" class="col-md-3 control-label">Email</label>
                                    <div class="col-md-9">
                                        <input type="text" class="form-control" name="email"
                                               placeholder="Email Address">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="firstname" class="col-md-3 control-label">Name</label>
                                    <div class="col-md-9">
                                        <input type="text" class="form-control" name="name" placeholder="Name">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="lastname" class="col-md-3 control-label">User-name</label>
                                    <div class="col-md-9">
                                        <input type="text" class="form-control" name="userName" placeholder="User-name">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="password" class="col-md-3 control-label">Password</label>
                                    <div class="col-md-9">
                                        <input type="password" class="form-control" name="passwd"
                                               placeholder="Password">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <!-- Button -->
                                    <div class="col-md-offset-3 col-md-9">
                                        <button id="btn-signup" type="submit"  class="btn btn-info"><i
                                                    class="icon-hand-right"></i>
                                            &nbsp Sign Up
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>
</section>






<#include "footer.ftl">