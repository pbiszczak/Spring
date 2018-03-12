<%--
  Created by IntelliJ IDEA.
  User: Pawel
  Date: 28.02.2018
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <title>CRM - Add Customer</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>


<div id="container">

    <div id="content">

        <%--New Button--%>


        <%--add table here--%>
        <div class="table-title">
            <h3>CRM - Customer Relationship Manager</h3>
        </div>

        <table class="table-fill">
            <thead>
            <tr>
                <th colspan="2">Add new customer</th>

            </tr>
            </thead>

            <tbody class="table-hover">

                <form:form action="saveCustomer" modelAttribute="customer" method="POST">

                    <%--Track customer by id--%>
                    <form:hidden path="id"/>

                    <tr>
                        <td><label>First Name</label></td>
                        <td><form:input path="firstName"/></td>
                    </tr>
                    <tr>
                        <td><label>Last Name</label></td>
                        <td><form:input path="lastName"/></td>
                    </tr>
                    <tr>
                        <<td><label>Email</label></td>
                        <td><form:input path="email"/></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" value="Save Customer" class="btn btn-info"/>
                        </td>
                    </tr>

                </form:form>
            </tbody>

        </table>

        </div>

    </div>

</body>
</html>