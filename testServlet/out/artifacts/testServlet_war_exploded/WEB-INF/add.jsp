<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Book</title>
</head>
<body>
    <form method="post" action="/add">
    <label>Author:</label>
    <input type="text" name="author"/><br>

    <label>Title:</label>
    <input type="text" name="title"/><br>

    <label>Genre:</label>
    <input type="text" name="genre"/><br>

    <label>Price:</label>
    <input type="number" name="price"/><br>

    <label>Description:</label>
    <input type="text" name="description"/><br>
        <button type="submit">Add</button>
    </form>
</body>
</html>
