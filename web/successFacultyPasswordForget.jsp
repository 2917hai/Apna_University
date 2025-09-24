<%--
    Document   : successPasswordForget
    Created on : 16 Sep, 2025, 4:01:49 AM
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
        <h1>Success...!</h1>
        <script>
            Swal.fire({
                title: 'Success!',
                text: 'You have  successfully forgotted Your Password.',
                icon: 'success',
                confirmButtonText: 'OK'
            }).then((result) => {
                if (result.isConfirmed) {
                    window.location.href = "facultyLogin.html";

                }
            });

        </script>

    </center>

    <script src="sript.js"></script>
</body>
</html>
