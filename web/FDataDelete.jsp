<%--
    Document   : DataDelete
    Created on : 20 Sep, 2025, 11:08:14 AM
    Author     : Umesh Yadav
--%>

<%@page import="com.sis.dao.FacultyRegisterDao"%>
<%@page import="com.sis.dao.StudentsRegisterDAO"%>
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

        <%
            String EmpId = request.getParameter("empId");
            FacultyRegisterDao sd = new FacultyRegisterDao();
            int r = sd.deleteFaculty(EmpId);
            if (r > 0) {
        %>
        <script>
            Swal.fire({
                title: 'Success!',
                text: 'Students Data Deleted Successfully.....!.',
                icon: 'success',
                confirmButtonText: 'OK'
            }).then((result) => {
                if (result.isConfirmed) {
                    window.location.href = "AdminProfile.jsp";
                }
            });

        </script>
        <%} else {
        %>
        <script>
            Swal.fire({
                title: 'Failed!',
                text: 'Sorry...! Data not deleted.......!',
                icon: 'error',
                confirmButtonText: 'Retry'
            }).then((result) => {
                if (result.isConfirmed) {
                    window.location.href = "AdminProfile.jsp";
                }
            });
        </script>
        <%}%>

    </body>
</html>
