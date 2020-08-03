<%@include file="/include/header.jsp"%>

<%

	String userId = null;
	userId = request.getSession().getAttribute("userId").toString();
	
%>

<div class="main">
	<section class="signup">
		<!-- <img src="images/signup-bg.jpg" alt=""> -->
		<div class="container">
			<div class="signup-content">
				<form action="${pageContext.request.contextPath}/Operation" method="post">
                
				 <h1 class="form-title">You can start writing...!</h1>
				<div class="form-group">
                    <a href="${pageContext.request.contextPath}/Operation?page=history&userId=<%= userId%>">Written History</a>
                </div>
                
				<div class="form-group">
                    <a href="${pageContext.request.contextPath}/Operation?page=deleteContent&userId=<%= userId%>" onClick ="if(!confirm('Are you sure to delete all the previous entries?')) return false">Delete your past savings!</a>
                </div>
				
				<div class="form-group">
                    <a href="${pageContext.request.contextPath}/Operation?page=logout">Logout</a>
                </div>
                
				
					<div class="form-group">
						<textarea id="content" name="content" placeholder="Write about your day.." cols="58" rows="20"></textarea>
					</div>

					<div class="form-group">
						<input type="hidden" name="diaryForm" value="saveDiary"
							class="agree-term" />
					</div>
					
					<div class="form-group">
						<input type="hidden" name="userId" value="<%= userId %>"
							class="agree-term" />
					</div>
				
					<div class="form-group">
                        <input type="submit" name="submit" id="submit" class="form-submit" value="Save today"/>
                    </div>
				</form>
			</div>
		</div>
	</section>
</div>

<%@include file="/include/footer.jsp"%>