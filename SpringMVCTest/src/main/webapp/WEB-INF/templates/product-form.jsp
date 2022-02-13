<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>

<html>
<body>
    <form:form action="addProduct" modelAttribute="product">
        Product id: <form:input path="id" />
        <br>
        Product title: <form:input path="title" />
        <br>
        Product price: <form:input path="cost"/>
        <br>
    <input type="submit" value="Submit" />
</form:form>
</body>
</html>
