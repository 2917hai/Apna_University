<%--
    Document   : failedExamForm
    Created on : 13 Sep, 2025, 1:43:27 PM
    Author     : Umesh Yadav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    </head>
    <body>

    <center>
        <script>
            Swal.fire({
                title: 'Failed!',
                text: 'Your exam submission failed. You have allready done',
                icon: 'error',
                confirmButtonText: 'Retry'
            }).then((result) => {
                if (result.isConfirmed) {
                    window.location.href = "index.html";
                }
            });
        </script>

    </center>
    <script src="sript.js"></script>
</body>
</html>
