<%@ include file ='header.jsp' %>


				<div class="container" align="center" style="padding:50px">
					<form method='post' action='ValidateCredential.jsp'>
					<table><b>
						<tr>
							<td>
								<select id='role' name='role'>
									<option value='customer'>Customer</option>
									<option value='storeManager'>Store Manager</option>
								</select>
							</td>
						</tr>
						<br/><br/>
						<tr>
							<td>
								<input class="login" type="name"required name="name" placeholder="Name" maxlength="32"> 
							</td>
						</tr>
						<tr>
							<td>
								<input class="login" type="text"required name="emailId" onkeypress="return AlphaNumeric()" placeholder="EmailId" maxlength="10">
							</td>
						</tr>
						<tr>
							<td>
								<input class="login" type="password"required name="password" placeholder="Password" maxlength="32"> 
							</td>
						</tr>

						<tr>
							<td><input type="submit" style="padding:10px" value="SignUp" class="btn btn-gold">
								
							</td>
						</tr>
						
					</form> 
				</table> 

				<div style="padding:20px;text-decoration:none" ><a href='login.jsp'>Already a user? Login.</a></div>
				
			</div>
<%@include file ='footer.jsp' %>
