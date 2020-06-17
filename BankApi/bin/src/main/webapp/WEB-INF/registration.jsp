<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Create an account</title>
  </head>

  <body>

    <div>

        <form:form action="/signup" method="POST" modelAttribute="accountForm">
            <h2>Create your account</h2>
            
            <spring:bind path="username">
                    <form:input type="text" path="username" placeholder="Username"
                                autofocus="true"></form:input>
                    <form:errors path="username"></form:errors>
            </spring:bind>
            
            <spring:bind path="name">
                    <form:input type="text" path="name" placeholder="name"
                                autofocus="true"></form:input>
                    <form:errors path="name"></form:errors>
            </spring:bind>

            <spring:bind path="password">
                    <form:input type="password" path="password" placeholder="Password"></form:input>
                    <form:errors path="password"></form:errors>
            </spring:bind>
			
			 <spring:bind path="accountNo">
                    <form:input type="text" path="accountNo" placeholder="account number"
                                autofocus="true"></form:input>
                    <form:errors path="accountNo"></form:errors>
            </spring:bind>
            
             <spring:bind path="balance">
                    <form:input type="number" path="balance" placeholder="balance"
                                autofocus="true"></form:input>
                    <form:errors path="balance"></form:errors>
            </spring:bind>
           
           	<form:input type="submit" value="Register"></form:input>

        </form:form>

    </div>
  </body>
</html>