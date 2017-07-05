<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Book manager</title>
    <style type="text/css">
        .window{
            width: 75%;
            height: 75%;
            margin: 50px auto;
            display: none;
            background: #d7d7d7;
            z-index: 200;
            position: fixed;
            left: 0;
            right: 0;
            top: 0;
            bottom: 0;
            padding: 16px;
        }

        .close{
            margin-right: 2px;
            margin-top: 2px;
            cursor: pointer;
        }

    </style>
</head>
<body>

<h1>Book catalog</h1>

<script type="text/javascript">
    //Функция показа
    function show(state,id){
        document.getElementById(id).style.display = state;
    }
</script>

<table border="1">
    <tr>
        <td><b>Author</b></td>
        <td><b>Title</b></td>
        <td><b>Genre</b></td>
        <td><b>Price</b></td>
    </tr>
    <c:forEach items="${requestScope.books}" var="book">
        <tr>
            <td>${book.author}</td>
            <td>${book.title}</td>
            <td>${book.genre}</td>
            <td>${book.price}$</td>
            <td>
                <button class="myButton" onclick="show('block','${book.id}')">Order</button>
            </td>
        </tr>
        <div class ="window" id='${book.id}'>
            <!--Картинка крестика-->
            <img class="close" onclick="show('none','${book.id}')" src="delete.png" align="right">
            <p><b>Book ID:</b>${book.id}</p>
            <p><b>Author:</b>${book.author}</p>
            <p><b>Title:</b>${book.title}</p>
            <p><b>Genre:</b>${book.genre}</p>
            <p><b>Price:</b>${book.price}$</p>
            <p><b>Description:</b>${book.description}</p>

            <h2>Book order</h2>
            <form method="post" action="/order">
                <label>Enter your first name:</label>
                <input type="text" name="firstName"/><br>

                <label>Enter your last name:</label>
                <input type="text" name="lastName"/><br>

                <label>Enter your address:</label>
                <input type="text" name="address"/><br>

                <label>Enter quantity of books you want ot order:</label>
                <input type="number" name="quantity"/><br>

                <button type="submit" name ="bookID" value="${book.id}">Order</button>
            </form>
        </div>
    </c:forEach>

</table>

</body>
</html>
