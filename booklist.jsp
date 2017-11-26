<%@ include file ='header.jsp' %>
	
	
	<div class="container">
	
		<% request.getRequestDispatcher("CarListServlet").forward(request, response); %>
		
	</div>
		
<%@include file ='footer.jsp' %>