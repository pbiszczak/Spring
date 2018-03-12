<%--
  Created by IntelliJ IDEA.
  User: Pawel
  Date: 28.02.2018
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <title>CRM - List Customers</title>
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
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Action</th>
                    </tr>
                </thead>

            <%--loop over, print our customers--%>
                <tbody class="table-hover">
            <c:forEach var="tempCustomer" items="${customers}">

                <c:url var="updateLink" value="/customer/showFormForUpdate">
                    <c:param name="customerId" value="${tempCustomer.id}"/>
                </c:url>

                <c:url var="deleteLink" value="/customer/delete">
                    <c:param name="customerId" value="${tempCustomer.id}"/>
                </c:url>


                <tr>
                    <td>${tempCustomer.firstName}</td>
                    <td>${tempCustomer.lastName}</td>
                    <td>${tempCustomer.email}</td>
                    <td style="white-space: nowrap">
                        <a href="${updateLink}" style="color: lightseagreen">Update</a>
                         |
                        <a href="${deleteLink}" style="color: darkred" onclick="if (!(confirm('Are your sure you want to delete this customer?'))) return false">Delete</a>
                    </td>
                </tr>
            </c:forEach>
                </tbody>
        </table>
            <div style="text-align:center;">
                <button type="button"
                        onclick="window.location.href='showFormForAdd'; return false;"
                        class="btn btn-primary button"
                >
                    Add Customer
                </button>
            </div>

    </div>

</div>

</body>
</html>
