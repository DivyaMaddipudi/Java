<%@include file="/include/header.jsp"%>

<div class="main">
	<section class="signup">
		<!-- <img src="images/signup-bg.jpg" alt=""> -->
		<div class="container">
			<div class="signup-content">
				<form action="${pageContext.request.contextPath}/Operation" method="post">
				 <h1 class="form-title">You can start writing...!</h1>
					<div class="form-group">
						<label for="start">Current date</label> <br /> <input type="date"
							id="start" name="start" value="2020-07-14" min="2020-01-01"
							max="2030-12-31"> 
					</div>


					<div class="form-group">
						<label for="textArea">Write about your day</label> <br />
						<textarea id="content" name="content"
							placeholder="Write something.." cols="50" rows="25">
						</textarea>
					</div>


					<div class="form-group">
						<input type="hidden" name="diaryForm" value="saveDiary"
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