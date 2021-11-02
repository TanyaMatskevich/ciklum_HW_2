<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add new product</title>
</head>
<body>

<form method="POST" action='ProductServlet' name="frmAddProduct">
    Name : <input type="text" name="name"/> <br/>
    Price : <input type="text" name="price" required pattern="^[0-9]+$"/> <br/>
    Status : <input type="text" name="status" required pattern="^[-a-zA-Z]+$"/> <br/>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>