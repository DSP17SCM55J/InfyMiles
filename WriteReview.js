<%@include file ='header.jsp' %>

				<div class="container" align="center" style="padding:50px">
                <form method = "post" action="WriteReviewServlet">
                    <table><b>
						<tr>
							<td>CarID:</td>
                            <td><input type = "text" name="carID"></td>
                        </tr> 
                        <br>
                        <tr>
							<td>Price:</td>
                            <td><input type = "text" name="price"></td>
                        </tr> 
                        <br>
                        <tr>
							<td>UserID:</td>
                            <td><input type = "text" name="userID"></td>
                        </tr> 
                        <br>
                        <tr>
							<td>User Age:</td>
                            <td><input type = "text" name="userAge"></td>
                        </tr> 
                        <br>
                        <tr>
							<td>User Gender:</td>
                            <td><select id='userGender' name='userGender'>
								    <option value='Male'>Male</option>
								    <option value='Female'>Female</option>
							    </select>
                            </td>
                        </tr> 
                        <br>
                        <tr>
							<td>Rating</td>
                            <select id='rating' name='rating'>
								    <option value='5'>5</option>
								    <option value='4'>4</option>
                                    <option value='3'>3</option>
								    <option value='2'>2</option>
                                    <option value='1'>1</option>
							    </select>
                        </tr> 
                        <br>
                        <tr>
							<td>Review Date:</td>
                            <td><input type = "date" name="reviewDate"></td>
                        </tr> 
                        <br>
                        <tr>
							<td>Comments</td>
                            <td><input type = "textarea" name="comments"></td>
                        </tr> 
                    </table>