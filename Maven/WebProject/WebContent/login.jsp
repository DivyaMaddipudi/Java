<%@include file="/include/header.jsp" %>

	<div class="main">
        <section class="signup">
            <!-- <img src="images/signup-bg.jpg" alt=""> -->
            <div class="container">
                <div class="signup-content">
                
                    <form action="${pageContext.request.contextPath}/home" method="POST" id="signup-form" class="signup-form">
                        <h2 class="form-title">Login account</h2>
                		 <p><font color="red">${successMessage}</font></p>        
                        <div class="form-group">
                            <input type="email" class="form-input" name="email" id="email" placeholder="Your Email"/>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-input" name="password" id="password" placeholder="Password"/>
                            <span toggle="#password" class="zmdi zmdi-eye field-icon toggle-password"></span>
                        </div>
                        
                        <div class="form-group">
                            <input type="hidden" name="action" value="loginSubmit" class="agree-term" />
                        </div>
                        <div class="form-group">
                            <input type="submit" name="submit" id="submit" class="form-submit" value="Login"/>
                        </div>
                    </form>
                    
                    <p class="loginhere">
                        New user ? <a href="index.jsp" class="loginhere-link">Signup here</a>
                    </p>
                </div>
            </div>
        </section>
    </div>
    
<%@include file="/include/footer.jsp" %>