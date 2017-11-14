<%@include file ='header.jsp' %>

				<div class="container" align="center" style="padding:50px">
				<h2>Booking Details</h2>
					<form method='post' action='LoginServlet'>
						<table><b>
							
							<tr>
								<td style="vertical-align: middle;padding:10px">Car:</td>
								<td><input class="login" type = "text" name="carName"></td>
							</tr>
							
							<tr>
								<td style="vertical-align: middle;padding:10px">Type:</td>
								<td><input class="login" type = "text" name="carType"></td>
							</tr>

							<tr>
								<td style="vertical-align: middle;padding:10px">Price:</td>
								<td><input class="login" type = "text" name="price"></td>
							</tr>
							<tr>
								<td style="vertical-align: middle;padding:10px">From:</td>
								<td><input class="login" type = "text" name="From"></td>
							</tr>
							<tr>
								<td style="vertical-align: middle;padding:10px">To:</td>
								<td><input class="login" type = "text" name="To"></td>
							</tr>
							<tr>
								<td style="vertical-align: middle;padding:10px">Location:</td>
								<td><input class="login" type = "text" name="Location"></td>
							</tr>
							<tr>
								<td style="vertical-align: middle;padding:10px">Full Address</td>
								<td><input class="login" type = "text" name="Address"></td>
							</tr>
							<tr> 
								<td> <h4>Payment Details:</h4></td> 
							</tr>
							<tr>
								<td style="vertical-align: middle;padding:10px">Card Holder's Name</td>
								<td><input class="login" type = "text" name="cardholderName"></td>
							</tr>
							<tr>
								<td style="vertical-align: middle;padding:10px">Card Number</td>
								<td><input class="login" type = "text" name="cardHumber"></td>
							</tr>

							<tr>
								<td style="vertical-align: middle;padding:10px">Full Address</td>
								<td><input class="login" type = "text" name="Address"></td>
							</tr>
							<tr>
								<td style="vertical-align: middle;padding:10px">CVV</td>
								<td><input class="login" type = "password"  maxlength="3" name="CVV"></td>
							</tr>
							<tr>
                            	<td><center><input type="submit" style="padding:10px" value="submit" class="btn btn-gold"></center></td>
                        	</tr>
							
						</table>		
					</form> 
				 
				
			</div>
			<!--==============================footer=================================-->
<%@ include file = 'footer.jsp' %>