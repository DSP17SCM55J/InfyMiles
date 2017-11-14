<%@ include file ='header.jsp' %>


				<div class="container" align="center" style="padding:50px">
					<form method='post' action='ValidRegistration'>
					<table><b>
						<br/><br/>
						<tr>
							<td>
								<input class="login" type="name"required name="name" placeholder="Name"> 
							</td>
						</tr>
						<tr>
							<td>
								<input class="login" type="text"required name="emailId" onkeypress="return AlphaNumeric()" placeholder="EmailId" >
							</td>
							<div id="status"></div>
 								<script type="text/javascript" src="js/chk_user.js"></script> 
						</tr>
						<tr>
							<td>
								<input class="login" type="password"required name="password" placeholder="Password" maxlength="32"> 
							</td>
						</tr>

						<tr>
							<td>
								<input class="login" type="phoneNumber"required name="phoneNumber" placeholder="Phone Number"> 
							</td>
						</tr>
						<tr>
							<td>
								<input class="login" type="address"required name="address" placeholder="Address"> 
							</td>
						</tr>
						<tr>
							<td>
								<input class="login" type="city"required name="city" placeholder="City"> 
							</td>
						</tr>
						<tr>
							<td>
								<input class="login" type="state"required name="state" placeholder="State"> 
							</td>
						</tr>
						<tr>
							<td>
								<input class="login" type="zipcode"required name="zipcode" placeholder="Zipcode"> 
							</td>
						</tr>
						
						<tr>
							<td>Role</td>
							<td><select id='role' name='role'>
								<option value='customer'>Customer</option>
								<option value='storeManager'>Store Manager</option>
							
							</select></td>
						</tr>

						
						<tr>
							<td><input type="submit" style="padding:10px" value="SignUp" class="btn btn-gold">
								
							</td>
						</tr>
						
					</form> 
				</table> 
				
			</div>
<%@include file ='footer.jsp' %>
