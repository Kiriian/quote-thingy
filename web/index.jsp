<%-- 
    Document   : index
    Created on : 28-09-2015, 11:03:30
    Author     : Jeanette
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src ="http://code.jquery.com/jquery-1.11.3.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Quote of the Day!</h1>
        <button id="getbtn">Get Quote</button>
        <br>
        <br>
        <input id="thequote" style=" width:60em; margin-top:1em;">
        <button>Create Quote</button>
        <br>
        <br>
        <button >Edit Quote</button>
        <br>
        <br>
        <button>Delete Quote</button>
        <br>
        <br>
        <script>
            $(document).ready(function () {
                $.ajax({
                    url: "api/quote/random",
                    type: "GET",
                    dataType: "json"
                }).done(function (dataFromServer) { //called when ready
                    $("#thequote").val(dataFromServer.quote);
                }).fail(function () {                 //called when wrong
                    alert("UUUUPPPPSSSS!");
                });
            });

        </script>

        <script>
            $(document).ready(function () {
                $("#getbtn").click(function () {

                    $.ajax({
                        url: "api/quote/random",
                        type: "GET",
                        dataType: "json"
                    }).done(function (dataFromServer) { //called when ready
                        $("#thequote").val(dataFromServer.quote);
                    }).fail(function () {                 //called when wrong
                        alert("UUUUPPPPSSSS!");
                    });
                });
            });
        </script>
        
        <script>
            
        </script>
    </body>
</html>
