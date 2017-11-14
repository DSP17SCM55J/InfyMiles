<%@include file ='header.jsp' %>

				<div class="container" align="center" style="padding:50px">
                <h2>Write Review</h2>
                <form method = "post" action="WriteReviewsServlet">
                    <table><b>
                        <tr>
							<td style="vertical-align: middle;padding:10px">Car Type</td>
                            <td>
                                <select class="login" id='cartype' name='cartype'>
								    <option value='Hatchback'>Hatchback</option>
								    <option value='Sedan'>Sedan</option>
                                    <option value='Van'>Van</option>
								    <option value='Crossover'>Crossover</option>
                                    <option value='Coupe'>Coupe</option>
                                    <option value='Convertible'>Convertible</option>
                                </select>
                            </td>
                        </tr> 
						<tr>
							<td style="vertical-align: middle;padding:10px">Car Name</td>
                            <td><input class="login" type = "text" name="carName"></td>
                        </tr> 
                        
                        <tr>
							<td style="vertical-align: middle;padding:10px">Price</td>
                            <td><input class="login" type = "text" name="price"></td>
                        </tr> 
                        
                        <tr>
							<td style="vertical-align: middle;padding:10px">User ID</td>
                            <td><input class="login" type = "text" name="userID"></td>
                        </tr> 
                        
                        <tr>
							<td style="vertical-align: middle;padding:10px">User Age</td>
                            <td><input class="login" type = "text" name="userAge"></td>
                        </tr> 
                        
                        <tr>
							<td style="vertical-align: middle;padding:10px">User Gender</td>
                            <td><select class="login"  id='userGender' name='userGender'>
								    <option value='Male'>Male</option>
								    <option value='Female'>Female</option>
							    </select>
                            </td>
                        </tr> 

                        <tr>
							<td style="vertical-align: middle;padding:10px">User Occupation</td>
                            <td><input class="login" type = "text" name="userOccupation"></td>
                        </tr> 

                        <tr>
							<td style="vertical-align: middle;padding:10px">Manufacturer</td>
                            <td><input class="login" type = "text" name="manufacturer"></td>
                        </tr> 
                        
                        <tr>
                            <br/>
							<td style="vertical-align: middle;padding:10px">Rating</td>
                            <td><select class="login" id='rating' name='rating'>
								    <option value='5'>5</option>
								    <option value='4'>4</option>
                                    <option value='3'>3</option>
								    <option value='2'>2</option>
                                    <option value='1'>1</option>
                                </select>
                            </td>
                        </tr> 
                        
                        <tr>
							<td style="vertical-align: middle;padding:10px">Review Date</td>
                            <td><input class="login" type = "date" name="reviewDate"></td>
                        </tr> 
                        
                        <tr>
							<td style="vertical-align: middle;padding:10px">Comments</td>
                            <td><input class="login" type = "textarea" name="comments"></td>
                        </tr> 
                        
                        <tr>
                            <td><center><input type="submit" style="padding:10px" value="submit" class="btn btn-gold"></center></td>
                        </tr>

                    </table>
                </form>
                    
                </div>
                <!--==============================footer=================================-->
    <%@ include file = 'footer.jsp' %>
