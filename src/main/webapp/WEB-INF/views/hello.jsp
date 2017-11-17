<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

<c:set var="context" scope="request" value="<%= request.getContextPath()%>" />
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

        
            <div class="navbar-header">
                <a class="navbar-brand" href="#"><img src="http://companies.naukri.com/samcomm-careers/wp-content/uploads/sites/1322/2014/11/SAMCOMM-OG-TAG-LOGO.jpg"/></a>
          <li> <a href="${context}/login" style = "font-size: 18px;padding-top: 8px;float: right;color: #FF5333;font-weight: 600;">USER</a></li>
          <li> <a href="${context}/admin" style = "font-size: 18px;padding-top: 8px;float: right;color: #FF5333;font-weight: 600;">ADMIN</a></li>
            </div>
         </div>
  
   <sec:authorize access="hasRole('ROLE_USER')">
		
		<!-- For login user -->
		<c:url value="/j_spring_security_logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
		<script>
			function formSubmit() {
				document.getElementById("logoutForm").submit();
			}
		</script>

		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<h2>
				User : ${pageContext.request.userPrincipal.name} | <a
					href="javascript:formSubmit()"> Logout</a>
			</h2>
		</c:if>

	</sec:authorize>
<div>
	<h1> Jobs for you</h1>  
   <c:forEach var="prod" items="${list}">
   		<div class="product-preview-container">
		   <ul>   
			   <li>:${prod.nameSKU}</li>
			   <li>Name :${prod.description}</li>   
			   <li>Price :$ ${prod.price}</li>
			   <li><a href="#">Apply</a></li> 
		   </ul> 
		  </div>   
   </c:forEach>
</div>	
</body>
</html>