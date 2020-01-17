<#include "header.ftl">



<#import "/spring.ftl" as spring/>




<section class="h-100">
    <header class="container h-100">
        <div class="d-flex align-items-center justify-content-center h-100">

            <div id="loginbox" style="margin-top:50px;"
                 class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <div class="panel-title">Sign In</div>
                    </div>

                    <div style="padding-top:30px" class="panel-body">


                        <form action="login" method="post" id="loginform" class="form-horizontal" role="form">
                            <#if success ??>
                                <div  id="login-alert" class="alert alert-info col-sm-12">
                                    <p>Success!</p>
                                    <span>${success}</span>
                                </div>
                            </#if>
                            <#if message ??>
                                <div  id="login-alert" class="alert alert-danger col-sm-12">
                                    <p>Error:</p>
                                    <span>${message}</span>
                                </div>
                            </#if>
                            <div style="margin-bottom: 25px" class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <input id="login-username" type="text" class="form-control" name="login"
                                       placeholder="username">
                            </div>

                            <div style="margin-bottom: 25px" class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                <input id="login-password" type="password" class="form-control" name="password"
                                       placeholder="password">
                            </div>
                            <input type="hidden" name="urlBeforeRedirect" value="${urlBeforeRedirect}">


                            <div style="margin-top:10px" class="form-group">
                                <!-- Button -->

                                <div class="col-sm-12 controls">

                                    <button id="btn-login"  type="submit" class="btn btn-success">Login </button>

                                </div>
                            </div>
                        </form>

                    </div>
                </div>
            </div>

        </div>
    </header>
</section>
<#include "footer.ftl">