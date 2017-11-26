<%@include file ='header.jsp' %>


	<li>
        <h4>Producty Catalog</h4>
        <ul>
<!-- 
            <li><a href="SmartPhoneServlet?type=phone&brandName=Samsung">Samsung</a></li>
            <li><a href="SmartPhoneServlet?type=phone&brandName=Apple">Apple</a></li>
            <li><a href="SmartPhoneServlet?type=phone&brandName=LG">LG</a></li>
            <li><a href="SmartPhoneServlet?type=phone&brandName=Sony">Sony</a></li>
            <li><a href="SmartPhoneServlet?type=phone&br">Accessories</a></li>   -->
        <li> <a href="AddProducts.jsp" class="list-group-item">Add Cars</a></li>
        <li><a href="ChangeCarServlet" class="list-group-item">Update/Delete Cars</a></li>        
        <li><a href="/csj/SmartServlet?type=phone" class="list-group-item">Data Analytics </a></li>
        <li><a href="ChartGeneration" class="list-group-item">Graphs </a></li>
        	<!-- 	<ol>
        			<li><a href="ChartGeneration" class="list-group-item">Sales Chart</li>
        			<li><a href="ChartGeneration" class="list-group-item">Inventory Charts</li>
        		</ol>
        </li> -->
        </ul>
    </li>


<%@ include file = 'footer.jsp' %>