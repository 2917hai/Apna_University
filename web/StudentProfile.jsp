<%@page import="com.sis.bean.ExamForm"%>
<%@page import="com.sis.dao.ExamFormDao"%>
<%@page import="com.sis.dao.AttendanceDAO"%>
<%@page import="com.sis.bean.StudentsAttendanseBean"%>
<%@page import="java.io.OutputStream"%>
<%@page  import="com.sis.bean.StudentsBean"%>
<%@page    import="com.sis.dao.StudentsRegisterDAO"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>University_Management_System</title>
        <link rel="stylesheet" href="style.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

    </head>


    <body style="background-color: antiquewhite">
        <% String enroll = request.getParameter("enroll");
            StudentsRegisterDAO sd
                    = new StudentsRegisterDAO();
            StudentsBean sb = sd.StudentProfile(enroll);%>
        <nav>
            <div class="logo">
                <a href="index.html"> <img src="images/logo.png" alt="" /></a>
            </div>
            <span class="item">
                <a href="index.html">Home</a>

                <a href="Help.html">Help</a>
                <span style="display: flex; gap: 20px; margin-top: -5px">
                    <p style="font-weight: bold; margin-top: 5px">
                        Wellcome To: <%=sb.getName()%>,
                        <Span style="color: red; text-decoration: underline">
                            <%= sb.getEnrollment()%>
                        </Span>
                    </p>
                    <p></p>
                    <div class="img">
                        <img
                            style="height: 30px; width: 30px; border-radius: 50%"
                            src="getImage?enroll=<%=sb.getEnrollment()%>&type=photo"
                            alt=""
                            />
                    </div>
                </span>

                <a href="index.html" style="cursor: pointer" >
                    <i  class="fa-solid fa-right-from-bracket"></i
                    ></a>
            </span>
        </nav>

        <div class="mar">
            <marquee behavior="alternate" direction="left" scrollamount="8">
                <span class="welcome-text"
                      >? Welcome to:
                    <span style="text-decoration: underline"><%= sb.getName()%></span> in
                    our Apana University ? Let's Connect Together ?</span
                >
            </marquee>
        </div>






        <section id="inquiry-section">
            <i onclick="closeenq()" style="font-size: 30px;  position: absolute; left: 600px; top: 20px; float: right; cursor: pointer;" class="fa-solid fa-xmark"></i>
            <h2>Have Any Questions? We're Here to Help!</h2>
            <p>Fill out the form below, and our team will get back to you shortly.</p>
            <form class="inquiry-form">
                <input type="text" placeholder="Your Name" required />
                <input type="email" placeholder="Your Email" required />
                <input type="tel" placeholder="Your Phone Number" required />
                <textarea placeholder="Your Message" required></textarea>
                <button type="submit">Submit</button>
            </form>

        </section>



        <div class="mainProfile">
            <div class="mainbox">
                <div class="left">
                    <div class="profile-pic">
                        <img
                            src="getImage?enroll=<%=sb.getEnrollment()%>&type=photo"
                            alt="Profile Picture"
                            />
                    </div>
                    <div class="profile-info">
                        <p><strong>Name:</strong> <%= sb.getName()%></p>
                        <p><strong>Enrollment Number:</strong> <%= sb.getEnrollment()%></p>
                        <hr />
                        <div class="list">
                            <p onclick="StudentProfile()">Student Profile</p>
                            <p onclick="Academic()">Academic Details</p>
                            <p onclick="Attendance()">Attendance</p>
                            <p onclick="Examination()">Examination</p>
                            <p onclick="Result()">result</p>
                            <p onclick="Marksheet()">Marksheet</p>
                            <p onclick="Documents()">Student document</p>
                            <p onclick="Update()">Update Profile</p>
                            <p onclick="Password()">Change Password</p>
                            <p onclick="logout()">Logout<i style="margin-left: 20px" class="fa-solid fa-right-from-bracket"></i> </p>
                        </div>
                    </div>
                </div>
                <div class="maindata">
                    <div class="profile-container">
                        <div class="profile-header">Student Profile</div>

                        <div class="tabs">
                            <button class="active">Personal Info</button>
                        </div>

                        <div class="tab-content">
                            <table class="info-table">
                                <tr>
                                    <td class="label">Enrollment</td>
                                    <td class="value"><%= sb.getEnrollment()%></td>
                                </tr>
                                <tr>
                                    <td class="label">Name</td>
                                    <td class="value"><%= sb.getName()%></td>
                                </tr>
                                <tr>
                                    <td class="label">Father's Name</td>
                                    <td class="value"><%= sb.getFatherName()%></td>
                                </tr>
                                <tr>
                                    <td class="label">Mother's Name</td>
                                    <td class="value"><%= sb.getMotherName()%></td>
                                </tr>
                                <tr>
                                    <td class="label">DOB</td>
                                    <td class="value"><%= sb.getDob()%></td>
                                </tr>
                                <tr>
                                    <td class="label">Gender</td>
                                    <td class="value"><%= sb.getGender()%></td>
                                </tr>
                                <tr>
                                    <td class="label">Mobile No</td>
                                    <td class="value"><%= sb.getMobile()%></td>
                                </tr>
                                <tr>
                                    <td class="label">Email</td>
                                    <td class="value"><%= sb.getEmail()%></td>
                                </tr>
                                <tr>
                                    <td class="label">Course/Branch</td>
                                    <td class="value">
                                        <%= sb.getCourse()%>/<%= sb.getBranch()%>
                                    </td>
                                </tr>

                                <tr>
                                    <td class="label">Current Address</td>
                                    <td class="value"><%= sb.getCurrentAddress()%></td>
                                </tr>
                                <tr>
                                    <td class="label">Permanent Address</td>
                                    <td class="value"><%= sb.getPermanentAddress()%></td>
                                </tr>
                                <tr>
                                    <td class="label">City</td>
                                    <td class="value"><%= sb.getCity()%></td>
                                </tr>
                                <tr>
                                    <td class="label">State</td>
                                    <td class="value"><%= sb.getState()%></td>
                                </tr>
                                <tr>
                                    <td class="label">Pincode</td>
                                    <td class="value"><%=sb.getPincode()%></td>
                                </tr>
                            </table>
                        </div>
                    </div>

                    <section id="academicdetails">
                        <h1 style="margin-left: 350px">Students ID Card</h1>
                        <div class="id-card" id="IdCard">
                            <div style="background-color: rgb(7, 7, 76);" class="header">

                                <img  src="images/logo.png" alt="University Logo" class="logo">
                                <h2 style="color: whitesmoke; font-weight: bold; margin-top: -60px;">Apana University Bhopal M.P.</h2>
                            </div>

                            <div class="photo">
                                <img src="getImage?enroll=<%=sb.getEnrollment()%>&type=photo" alt="Student Photo">
                            </div>

                            <div class="info">
                                <p><strong>Name:</strong> <%=sb.getName()%></p>
                                <p><strong>Enrollment:</strong><%=sb.getEnrollment()%> </p>
                                <p><strong>Course:</strong> <%=sb.getCourse()%>.[<%=sb.getBranch()%>]</p>
                                <p><strong>Contact:</strong> <%=sb.getMobile()%></p>
                            </div>

                            <div class="footer">
                                <p>Valid: 2025 - 2029</p>
                                <p>Apana University, Bhopal M.P. 462022</p>
                            </div>
                        </div>
                        <a style="margin-bottom: 50px"  href="#IdCard" download="Apana_ID_Card.png">Download</a>
                        <div style="height: 50px" >

                        </div>
                    </section>

                    <section style="height: 1000px;" id="Attendance">
                        <%
                            AttendanceDAO s = new AttendanceDAO();
                            StudentsAttendanseBean sbb = s.addAttendanse(sb.getEnrollment());
                        %>

                        <div  class="info">
                            <p><strong>Name:</strong><%=sb.getName()%> </p>
                            <p> <strong>Enrollment:</strong><%=sb.getEnrollment()%></p>
                        </div>



                        <table border="1" cellpadding="10" cellspacing="0">
                            <thead>
                                <tr>

                                    <th>ID</th>
                                    <th>Month</th>
                                    <th>Status</th>
                                    <th>Percentage</th>
                                </tr>
                            </thead>

                            <tbody>
                                <tr>
                                    <td>01</td>
                                    <td><%=sbb.getJan()%></td>
                                    <td><%=sbb.getStatus()%></td>
                                    <td><%=sbb.getJanper()%></td>
                                </tr>
                                <tr>
                                    <td>01</td>
                                    <td><%=sbb.getFeb()%></td>
                                    <td><%=sbb.getStatus()%></td>
                                    <td><%=sbb.getJanper()%></td>
                                </tr>
                                <tr>
                                    <td>01</td>
                                    <td><%=sbb.getMar()%></td>
                                    <td><%=sbb.getStatus()%></td>
                                    <td><%=sbb.getJanper()%></td>
                                </tr>
                                <tr>
                                    <td>01</td>
                                    <td><%=sbb.getApr()%></td>
                                    <td><%=sbb.getStatus()%></td>
                                    <td><%=sbb.getJanper()%></td>
                                </tr>
                                <tr>
                                    <td>01</td>
                                    <td><%=sbb.getMay()%></td>
                                    <td><%=sbb.getStatus()%></td>
                                    <td><%=sbb.getJanper()%></td>
                                </tr>
                                <tr>
                                    <td>01</td>
                                    <td><%=sbb.getJun()%></td>
                                    <td><%=sbb.getStatus()%></td>
                                    <td><%=sbb.getJanper()%></td>
                                </tr>
                                <tr>
                                    <td>01</td>
                                    <td><%=sbb.getJul()%></td>
                                    <td><%=sbb.getStatus()%></td>
                                    <td><%=sbb.getJanper()%></td>
                                </tr>
                                <tr>
                                    <td>01</td>
                                    <td><%=sbb.getAug()%></td>
                                    <td><%=sbb.getStatus()%></td>
                                    <td><%=sbb.getJanper()%></td>
                                </tr>
                                <tr>
                                    <td>01</td>
                                    <td><%=sbb.getSep()%></td>
                                    <td><%=sbb.getStatus()%></td>
                                    <td><%=sbb.getJanper()%></td>
                                </tr>
                                <tr>
                                    <td>01</td>
                                    <td><%=sbb.getOct()%></td>
                                    <td><%=sbb.getStatus()%></td>
                                    <td><%=sbb.getJanper()%></td>
                                </tr>
                                <tr>
                                    <td>01</td>
                                    <td><%=sbb.getNov()%></td>
                                    <td><%=sbb.getStatus()%></td>
                                    <td><%=sbb.getJanper()%></td>
                                </tr>
                                <tr>
                                    <td>01</td>
                                    <td><%=sbb.getDes()%></td>
                                    <td><%=sbb.getStatus()%></td>
                                    <td><%=sbb.getJanper()%></td>
                                </tr>

                            </tbody>
                        </table>
                    </section>











                    <section id="Examination">
                        <center>
                            <h2>Examinations Details</h2>
                            <table>
                                <tr>
                                    <th>Exam Name</th>
                                    <th>Date</th>
                                    <th>Status</th>
                                    <th>Action</th>
                                </tr>
                                <tr>
                                    <td>Midterm Exam</td>
                                    <td>2024-05-15</td>
                                    <td><span class="status scheduled">Scheduled</span></td>
                                    <td><span class="status apply">Apply</span></td>
                                </tr>
                                <tr>
                                    <td>Final Exam</td>
                                    <td>2024-06-20</td>
                                    <td><span class="status completed">Completed</span></td>
                                    <td><span class="status apply">Apply</span></td>
                                </tr>
                                <tr>
                                    <td>Quiz 1</td>
                                    <td>2024-04-10</td>
                                    <td><span class="status scheduled">Scheduled</span></td>
                                    <td><span class="status apply">Apply</span></td>
                                </tr>
                                <tr>
                                    <td>Quiz 2</td>
                                    <td>2024-04-20</td>
                                    <td><span class="status completed">Completed</span></td>
                                    <td><span class="status apply">Apply</span></td>
                                </tr>
                            </table>


                            <div class="fillform">
                                <h1>Final Exam form/ Start Exam</h1>
                                <form action="FillExamForm" method="post">
                                    <label for="name">Enter Your Name:</label>
                                    <input
                                        type="text"
                                        id="name"
                                        name="name"
                                        placeholder="Enter Your Name"
                                        required
                                        value=<%=sb.getName()%>
                                        readonly
                                        />
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                    <label for="Enrollment">Enter Your Enrollment:</label>
                                    <input
                                        type="text"
                                        id="Enrollment"
                                        name="Enrollment"
                                        placeholder="Enter Your Enrollment"
                                        value=<%=sb.getEnrollment()%>
                                        readonly
                                        required
                                        />
                                    <br /><br />
                                    <label for="exam">Select Semester:</label>
                                    <select id="semester" name="exam">
                                        <option value="sem1">Semester 1</option>
                                        <option value="sem2">Semester 2</option>
                                        <option value="sem3">Semester 3</option>
                                        <option value="sem4">Semester 4</option>
                                        <option value="sem5">Semester 5</option>
                                        <option value="sem6">Semester 6</option>
                                        <option value="sem7">Semester 7</option>
                                        <option value="sem8">Semester 8</option>
                                    </select>
                                    &nbsp;&nbsp;&nbsp;&nbsp;

                                    <label for="examType">Select Exam Type:</label>
                                    <select id="examType" name="examType">
                                        <option value="midterm">Midterm</option>
                                        <option value="final">Final</option>
                                        <option value="quiz1">Quiz 1</option>
                                        <option value="quiz2">Quiz 2</option>
                                    </select>
                                    <br /><br />
                                    <table border="1">
                                        <tr>
                                            <th>Subject Name</th>
                                            <th>Subject code</th>
                                            <th>Test link</th>
                                            <th>Your marks</th>
                                            <th>Total marks</th>
                                        </tr>
                                        <tr>
                                            <td><input type="text" value="Mathematics" readonly name="math"></td>
                                            <td><input type="text" value="MAT101" readonly name="mathcode"></td>
                                            <td><a href="Physics.html">Start Test</a></td>
                                            <td><input type="number" name="marks1" required placeholder="Enter Your marks"></td>
                                            <td><input type="number" name="total" value="100" readonly></td>
                                        </tr>
                                        <tr>
                                            <td><input type="text" value="Chemistry" readonly name="chemistry"></td>
                                            <td><input type="text" value="CAM101" readonly name="chamistrycode"></td>
                                            <td><a href="Physics.html">Start Test</a></td>
                                            <td><input type="number" name="marks2" required  placeholder="Enter Your marks"></td>
                                            <td><input type="number" name="total" value="100" readonly></td>
                                        </tr>
                                        <tr>
                                            <td><input type="text" value="Physics" readonly name="physics"></td>
                                            <td><input type="text" value="PHY101" readonly name="physicscode"></td>
                                            <td><a href="Physics.html">Start Test</a></td>
                                            <td><input type="number" name="marks3" required  placeholder="Enter Your marks"></td>
                                            <td><input type="number" name="total" value="100" readonly></td>
                                        </tr>
                                        <tr>
                                            <td><input type="text" value="Hindi" readonly name="hindi"></td>
                                            <td><input type="text" value="HIN101" readonly name="hindicode"></td>
                                            <td><a href="Physics.html">Start Test</a></td>
                                            <td><input type="number" name="marks4" required  placeholder="Enter Your marks"></td>
                                            <td><input type="number" name="total" value="100" readonly></td>
                                        </tr>
                                        <tr>
                                            <td><input type="text" value="English" readonly name="english"></td>
                                            <td><input type="text" value="ENG101" readonly name="englishcode"></td>
                                            <td><a href="Physics.html">Start Test</a></td>
                                            <td><input type="number" name="marks5" required  placeholder="Enter Your marks"></td>
                                            <td><input type="number" name="total" value="100" readonly></td>
                                        </tr>
                                        <tr>
                                            <td><input type="text" value="Biology" readonly name="bio"></td>
                                            <td><input type="text" value="BIO101" readonly name="biocode"></td>
                                            <td><a href="Physics.html">Start Test</a></td>
                                            <td><input type="number" name="marks6" required  placeholder="Enter Your marks"></td>
                                            <td><input type="number" name="total" value="100" readonly></td>
                                        </tr>



                                    </table>


                                    <button type="submit">Submit</button>
                                    <br><br><br>
                                </form>
                            </div>
                        </center>
                    </section>











                    <section id="Result">
                        <center>
                            <h2>Result</h2>
                            <p><strong>Name:</strong>Umesh Yadav</p>
                            <p><strong>Enrollment:</strong>Apana01</p>

                            <div class="resultform">
                                <form action="#"method="post"onsubmit="viewResult(); return false;">
                                    <label for="name">Enter Your Name:</label>
                                    <input type="text" id="name" name="name" placeholder="Enter Your Name" value="<%=sb.getName()%>" required>
                                    <br><br>
                                    <label for="Enrollment">Enter Your Enrollment:</label>
                                    <input type="text" id="Enrollment" name="Enrollment" placeholder="Enter Your Enrollment" value="<%=sb.getEnrollment()%>"  required>
                                    <br><br>
                                    <label for="semester">Select Semester:</label>
                                    <select id="semester" name="semester">
                                        <option value="sem1">Semester 1</option>
                                        <option value="sem2">Semester 2</option>
                                        <option value="sem3">Semester 3</option>
                                        <option value="sem4">Semester 4</option>
                                        <option value="sem5">Semester 5</option>
                                        <option value="sem6">Semester 6</option>
                                        <option value="sem7">Semester 7</option>
                                        <option value="sem8">Semester 8</option>
                                    </select>
                                    <br><br>

                                    <label for="examType">Select Exam Type:</label>
                                    <select id="examType" name="examType">
                                        <option value="midterm">Midterm</option>
                                        <option value="final">Final</option>
                                        <option value="quiz1">Quiz 1</option>
                                        <option value="quiz2">Quiz 2</option>
                                    </select>
                                    <br><br>

                                    <button  type="submit">View Result</button>
                                </form>

                            </div>
                            <%
                                ExamFormDao efd = new ExamFormDao();
                                ExamForm ef = efd.viewFormData(sb.getEnrollment());

                            %>
                            <span class="finalExam">
                                <table>
                                    <tr>
                                        <th>Subject</th>
                                        <th>Marks</th>
                                        <th>Grade</th>
                                        <th>Status</th>
                                    </tr>
                                    <tr>
                                        <td><%=ef.getPhysics()%></td>
                                        <td><%=ef.getPhysicsMarks()%></td>
                                        <td><%
                                            int no1 = ef.getPhysicsMarks();
                                            String s1;
                                            if (no1 > 35) {
                                                s1 = "pass";
                                            } else {
                                                s1 = "fail";
                                            }
                                            char grade1;

                                            switch (no1 / 10) {
                                                case 10:
                                                case 9:
                                                    grade1 = 'A';
                                                    break;
                                                case 8:
                                                    grade1 = 'B';
                                                    break;
                                                case 7:
                                                    grade1 = 'C';
                                                    break;
                                                case 6:
                                                    grade1 = 'D';
                                                    break;
                                                default:
                                                    grade1 = 'F';
                                            }
                                            %><%=grade1%></td>
                                        <td><span class="status <%=s1%>"><%=s1%></span></td>
                                    </tr>
                                    <tr>
                                        <td><%=ef.getChemistry()%></td>
                                        <td><%=ef.getChemistryMarks()%></td>
                                        <td><%
                                            int no2 = ef.getPhysicsMarks();
                                            String s2;
                                            if (no2 > 35) {
                                                s2 = "pass";
                                            } else {
                                                s2 = "fail";
                                            }
                                            char grade2;

                                            switch (no2 / 10) {
                                                case 10:
                                                case 9:
                                                    grade2 = 'A';
                                                    break;
                                                case 8:
                                                    grade2 = 'B';
                                                    break;
                                                case 7:
                                                    grade2 = 'C';
                                                    break;
                                                case 6:
                                                    grade2 = 'D';
                                                    break;
                                                default:
                                                    grade2 = 'F';
                                            }
                                            %><%=grade2%></td>
                                        <td><span class="status <%=s2%>"><%=s2%></span></td>
                                    </tr>

                                    <tr>
                                        <td><%=ef.getMath()%></td>
                                        <td><%=ef.getMathMarks()%></td>
                                        <td><%
                                            int no3 = ef.getMathMarks();
                                            String s3;
                                            if (no3 > 35) {
                                                s3 = "pass";
                                            } else {
                                                s3 = "fail";
                                            }
                                            char grade3;

                                            switch (no3 / 10) {
                                                case 10:
                                                case 9:
                                                    grade3 = 'A';
                                                    break;
                                                case 8:
                                                    grade3 = 'B';
                                                    break;
                                                case 7:
                                                    grade3 = 'C';
                                                    break;
                                                case 6:
                                                    grade3 = 'D';
                                                    break;
                                                default:
                                                    grade3 = 'F';
                                            }
                                            %><%=grade3%></td>
                                        <td><span class="status <%=s3%>"><%=s3%></span></td>
                                    </tr>
                                    <tr>
                                        <td><%=ef.getBio()%></td>
                                        <td><%=ef.getBioMarks()%></td>
                                        <td><%
                                            int no4 = ef.getBioMarks();
                                            String s4;
                                            if (no4 > 35) {
                                                s4 = "pass";
                                            } else {
                                                s4 = "fail";
                                            }
                                            char grade4;

                                            switch (no4 / 10) {
                                                case 10:
                                                case 9:
                                                    grade4 = 'A';
                                                    break;
                                                case 8:
                                                    grade4 = 'B';
                                                    break;
                                                case 7:
                                                    grade4 = 'C';
                                                    break;
                                                case 6:
                                                    grade4 = 'D';
                                                    break;
                                                default:
                                                    grade4 = 'F';
                                            }
                                            %><%=grade4%></td>
                                        <td><span class="status <%=s4%>"><%=s4%></span></td>
                                    </tr>
                                    <tr>
                                        <td><%=ef.getHindi()%></td>
                                        <td><%=ef.getHindiMarks()%></td>
                                        <td><%
                                            int no5 = ef.getHindiMarks();
                                            String s5;
                                            if (no5 > 35) {
                                                s5 = "pass";
                                            } else {
                                                s5 = "fail";
                                            }
                                            char grade5;

                                            switch (no5 / 10) {
                                                case 10:
                                                case 9:
                                                    grade5 = 'A';
                                                    break;
                                                case 8:
                                                    grade5 = 'B';
                                                    break;
                                                case 7:
                                                    grade5 = 'C';
                                                    break;
                                                case 6:
                                                    grade5 = 'D';
                                                    break;
                                                default:
                                                    grade5 = 'F';
                                            }
                                            %><%=grade5%></td>
                                        <td><span class="status <%=s5%>"><%=s5%></span></td>
                                    </tr>
                                    <tr>
                                        <td><%=ef.getEnglish()%></td>
                                        <td><%=ef.getEnglishMarks()%></td>
                                        <td><%
                                            int no6 = ef.getEnglishMarks();
                                            String s6;
                                            if (no6 > 35) {
                                                s6 = "pass";
                                            } else {
                                                s6 = "fail";
                                            }
                                            char grade6;

                                            switch (no6 / 10) {
                                                case 10:
                                                case 9:
                                                    grade6 = 'A';
                                                    break;
                                                case 8:
                                                    grade6 = 'B';
                                                    break;
                                                case 7:
                                                    grade6 = 'C';
                                                    break;
                                                case 6:
                                                    grade6 = 'D';
                                                    break;
                                                default:
                                                    grade6 = 'F';
                                            }
                                            %><%=grade3%></td>
                                        <td><span class="status <%=s6%>"><%=s6%></span></td>
                                    </tr>
                                </table>

                            </span>

                        </center>
                    </section>












                    <section id="Marksheet">
                        <div class="marksheet">
                            <div class="header">
                                <div class="img">
                                    <img
                                        style=""
                                        src="images/logo.png"
                                        alt="University Photo"
                                        />
                                </div>

                                <div class="img1">
                                    <img
                                        style=""
                                        src="getImage?enroll=<%=sb.getEnrollment()%>&type=photo"
                                        alt="Student Photo"
                                        />
                                </div>

                                <h1>Apana University Bhopal Madhya Pradesh 462022</h1>
                                <p><strong>Contact:</strong>+91-7803869841/ +91-9584392185 <span style="color: blue; text-decoration: underline;"> yadavumeshkumar815@gmail.com</span></p>
                                <p><strong>Certificate Number:</strong><span style="color: red; text-decoration: underline;">0191<%=sb.getEnrollment()%></span></p>
                                <hr />
                            </div>

                            <div class="student-info" style="display: flex; gap: 100px;">
                                <div class="one">
                                    <p><strong>Name:</strong> <%=sb.getName()%></p>
                                    <p><strong>Roll No:</strong> <%=sb.getEnrollment()%></p>
                                    <p><strong>Course:</strong> <%=sb.getCourse()%> <%=sb.getBranch()%></p>
                                </div>
                                <div class="two">
                                    <p><strong>Session:</strong> 2024-2025</p>
                                    <p><strong>Exam-Name:</strong> <%=ef.getExam()%></p>
                                </div>

                            </div>

                            <table>
                                <tr>
                                    <th>Subject</th>
                                    <th>Max Marks</th>
                                    <th>Marks Obtained</th>
                                    <th>Grade</th>
                                    <th>Status</th>
                                </tr>
                                <tr>
                                    <td>Physics</td>
                                    <td>100</td>
                                    <td><%=no1%></td>
                                    <td><%=grade1%></td>
                                    <td><span class="status <%=s1%>"><%=s1%></span></td>
                                </tr>
                                <tr>
                                    <td>Chemistry</td>
                                    <td>100</td>
                                    <td><%=no2%></td>
                                    <td><%=grade2%></td>
                                    <td><span class="status <%=s2%>"><%=s2%></span></td>
                                </tr>
                                <tr>
                                    <td>Mathematics</td>
                                    <td>100</td>
                                    <td><%=no3%></td>
                                    <td><%=grade3%></td>
                                    <td><span class="status <%=s3%>"><%=s3%></span></td>
                                </tr>
                                <tr>
                                    <td>Biology</td>
                                    <td>100</td>
                                    <td><%=no4%></td>
                                    <td><%=grade4%></td>
                                    <td><span class="status <%=s4%>"><%=s4%></span></td>
                                </tr>
                                <tr>
                                    <td>Hindi</td>
                                    <td>100</td>
                                    <td><%=no5%></td>
                                    <td><%=grade5%></td>
                                    <td><span class="status <%=s5%>"><%=s5%></span></td>
                                </tr>
                                <tr>
                                    <td>English</td>
                                    <td>100</td>
                                    <td><%=no6%></td>
                                    <td><%=grade6%></td>
                                    <td><span class="status <%=s6%>"><%=s6%></span></td>
                                </tr>
                                <tr>
                                    <th>Total</th>
                                    <th>600</th>
                                    <th>
                                        <%
                                            int total = (no1 + no2 + no3 + no4 + no5 + no6);
                                            float per = total / 6;
                                            String status;
                                            if (per > 35) {
                                                status = "pass";
                                            } else {
                                                status = "fail";
                                            }
                                        %>
                                        <%=total%>
                                    </th>
                                    <th colspan="2">Percentage:   <%=per%>%</th>
                                </tr>
                            </table>

                            <div class="footer">
                                <p>
                                    <strong>Result:</strong> <span class="status <%=status%>"><%=status%></span>
                                </p>
                                <p>
                                    Signature of Head
                                    <br>
                                <h2 >Umesh Yadav</h2>
                                </p>

                            </div>
                        </div>
                    </section>












                    <section id="document">
                        <center>
                            <h1>Here You can view your document</h1>
                        </center>
                        <div class="box">
                            <div
                                style="
                                width: 370px;
                                height: 390px;
                                border: 1px solid black;
                                border-radius: 20px;
                                margin-left: 20px;
                                "
                                class="first"
                                >
                                <img style="height: 388px; width: 350px; border-radius: 20px;padding: 2px 10px;" src="getImage?enroll=<%=sb.getEnrollment()%>&type=sign" alt="">
                            </div>
                            <div
                                style="
                                width: 370px;
                                height: 390px;
                                border: 1px solid black;
                                border-radius: 20px;
                                margin-left: 20px;
                                "
                                class="second"
                                >
                                <img style="height: 388px; width: 350px; border-radius: 20px;padding: 2px 10px;"  src="getImage?enroll=<%=sb.getEnrollment()%>&type=aadhar" alt="">
                            </div>
                            <div
                                style="
                                width: 370px;
                                height: 390px;
                                border: 1px solid black;
                                border-radius: 20px;
                                margin-left: 20px;
                                "
                                class="third"
                                >
                                <img style="height: 388px; width: 350px; border-radius: 20px;padding: 2px 10px;"  src="getImage?enroll=<%=sb.getEnrollment()%>&type=cast" alt="">
                            </div>
                            <div
                                style="
                                width: 370px;
                                height: 390px;
                                border: 1px solid black;
                                border-radius: 20px;
                                margin-left: 20px;
                                "
                                class="fourth"
                                >
                                <img style="height: 388px; width: 350px; border-radius: 20px;padding: 2px 10px;"  src="getImage?enroll=<%=sb.getEnrollment()%>&type=income" alt="">
                            </div>
                            <div
                                style="
                                width: 370px;
                                height: 390px;
                                border: 1px solid black;
                                border-radius: 20px;
                                margin-left: 20px;
                                "
                                class="fifth"
                                >
                                <img style="height: 388px; width: 350px; border-radius: 20px;padding: 2px 10px;" src="getImage?enroll=<%=sb.getEnrollment()%>&type=domicile" alt="">
                            </div>
                            <div
                                style="
                                width: 370px;
                                height: 390px;
                                border: 1px solid black;
                                border-radius: 20px;
                                margin-left: 20px;

                                "
                                class="sixth"
                                >
                                <img style="height: 388px; width: 350px; border-radius: 20px;padding: 2px 10px;"  src="getImage?enroll=<%=sb.getEnrollment()%>&type=latestQualification" alt="">
                            </div>
                        </div>
                    </section>



















                    <section id="update">
                        <h1 style="text-align: center">Here You can update your profile</h1>
                        <div class="form-box" >
                            <form action="UpdateStudentData" method="post" enctype="multipart/form-data">
                                <div class="personal-info">
                                    <h2>Personal Information:</h2>
                                    <label for="enroll">Enter Your Enrollment:</label>
                                    <input type="text" id="enroll" name="enroll" value="<%=sb.getEnrollment()%>" readonly placeholder="Enter Your Enrollment"  required > <br>
                                    <label for="name">Enter Your Name:</label>
                                    <input type="text" id="name" name="name" value=<%=sb.getName()%> placeholder="Enter Your Name"  required> <br>
                                    <label for="father">Enter Father Name:</label>
                                    <input type="text" id="father" name="father"value="<%=sb.getFatherName()%>" placeholder="Enter Father Name"  required><br>
                                    <label for="mother">Enter Mother Name:</label>
                                    <input type="text" id="mother" name="mother"value="<%=sb.getMotherName()%>" placeholder="Enter Mother Name"  required><br>
                                    <label for="dob">Enter Your Date of Birth:</label>
                                    <input type="date" id="dob" name="dob"value="<%=sb.getDob()%>" placeholder="Enter Your DOB"  required> <br>
                                    <label for="gender">Choose Your gender:</label>
                                    <input type="radio" id="gender" name="gender" value="Male"  required >Male
                                    <input type="radio" id="gender" name="gender" value="Female"  required >Female <br>
                                    <label for="photo">Upload photo</label>
                                    <input type="file" id="photo" name="photo"   required> <br>
                                    <label for="sign">Upload Signature</label>
                                    <input type="file" id="sign" name="sign"  required>
                                </div>
                                <span style="position: absolute;">
                                    <h2>Contact Information:</h2>
                                    <label for="email">Enter Your Email:  </label>
                                    <input type="email" id="email" name="email"value="<%=sb.getEmail()%>" placeholder="Enter Your Email"  required> <br>
                                    <label for="phone">Enter Phone Number:</label>
                                    <input type="tel" id="phone" name="phone"value="<%=sb.getMobile()%>" placeholder="Enter Your Phone Number"  required><br>
                                    <label for="aphone">Enter alternate Number:</label>
                                    <input type="tel" id="aphone" name="aphone"value="<%=sb.getAlterMobile()%>" placeholder="Enter Your Phone Number"  required ><br>
                                    <label for="address">Permanent Address:</label>
                                    <input type="text" id="address" name="address"value="<%=sb.getPermanentAddress()%>" placeholder="Enter Your Address"  required> <br>
                                    <label for="caddress">Current Address:</label>
                                    <input type="text" id="caddress" name="caddress"value="<%=sb.getCurrentAddress()%>" placeholder="Enter Current Address"  required> <br>
                                    <label for="city">Enter City:</label>
                                    <input type="text" id="city" name="city"value="<%=sb.getCity()%>" placeholder="Enter Your City"  required> <br>
                                    <label for="state">Enter State:</label>
                                    <input type="text" id="state" name="state"value="<%=sb.getState()%>" placeholder="Enter Your State"  required> <br>
                                    <label for="pincode">Enter Pincode:</label>
                                    <input type="number" id="pincode" name="pincode"value="<%=sb.getPincode()%> "placeholder="Enter Your Pincode"  required> <br>
                                </span>



                                <div class="document">
                                    <h2>document Upload Section</h2>
                                    <label for="idProof">ID Proof (Aadhaar / Passport / Driving License):</label>
                                    <input type="text" id="idProof" name="idProof"value="<%=sb.getAadharNo()%>" placeholder="Enter ID Number (e.g., Aadhaar No.)"   required/>
                                    <br>
                                    <input type="file" id="idProofFile" name="idProofFile" accept=".pdf,.jpg,.jpeg,.png"  required />
                                    <br>


                                    <label for="marksheets">Mark Sheets (10th, 12th, Graduation etc.):</label>
                                    <input type="file" id="marksheets" name="marksheets" multiple accept=".pdf,.jpg,.jpeg,.png"  required />
                                    <br>


                                    <label for="casteCert">Caste Certificate (if applicable):</label>
                                    <input type="file" id="casteCert" name="casteCert" accept=".pdf,.jpg,.jpeg,.png" />
                                    <br>


                                    <label for="incomeCert">Income Certificate (if applicable for scholarship):</label>
                                    <input type="file" id="incomeCert" name="incomeCert" accept=".pdf,.jpg,.jpeg,.png" />
                                    <br>


                                    <label for="domicileCert">Domicile Certificate:</label>
                                    <input type="file" id="domicileCert" name="domicileCert" accept=".pdf,.jpg,.jpeg,.png" />
                                </div>

                                <button  type="submit">Update</button>
                            </form>

                        </div>


                    </section>









                    <section id="Password">
                        <div class="container">
                            <h2>Forgot Password</h2>
                            <form action="PasswordForget">
                                <label for="Enrollment">Enter Enrollment:</label>
                                <input type="text" id="Enrollment" name="Enrollment" value="<%=sb.getEnrollment()%>" readonly>
                                <label for="current">Current Password</label>
                                <label for="current">Current Password</label>
                                <input type="password" id="current" name="current" required>

                                <label for="new">New Password</label>
                                <input type="password" id="new" name="new" required>

                                <label for="confirm">Confirm New Password</label>
                                <input type="password" id="confirm" name="confirm" required>

                                <label for="dob">Date of Birth</label>
                                <input type="date" id="dob" name="dob" required>

                                <button type="submit">Reset Password</button>
                            </form>
                        </div>
                    </section>


                    <a  href="#">Update Profile</a>


                </div>
            </div>
        </div>



        <footer>
            <div class="footer-top">
                <h2>360<sup>o</sup> View</h2>
                <p>Visit Campus Virtual Tour</p>
                <div class="social-icons">
                    <a href="#"><i class="fab fa-facebook-f"></i></a>
                    <a href="#"><i class="fab fa-twitter"></i></a>
                    <a href="#"><i class="fab fa-instagram"></i></a>
                    <a href="#"><i class="fab fa-linkedin-in"></i></a>
                    <a href="#"><i class="fab fa-youtube"></i></a>
                </div>
            </div>

            <div class="footer-links">
                <div>
                    <h3>Apana Concerns</h3>
                    <ul>
                        <li><a href="#">The APANA Group</a></li>
                        <li><a href="#">Apana Realty</a></li>
                        <li><a href="#">ApolloSage Hospitals</a></li>
                        <li><a href="#">APANA Group of Institutions (SGI)</a></li>
                        <li><a href="#">APANA International School</a></li>
                        <li><a href="#">True Apana Foundation</a></li>
                        <li><a href="#">Agrawal Power Pvt. Ltd.</a></li>
                    </ul>
                </div>

                <div>
                    <h3>Admissions</h3>
                    <ul>
                        <li><a href="#">Mandatory Disclosure</a></li>
                        <li><a href="#">Anti-Ragging Affidavit</a></li>
                        <li><a href="#">Fee Structure</a></li>
                        <li><a href="#">Scholarship</a></li>
                        <li><a href="#">Privacy Policy</a></li>
                        <li><a href="#">Value Added Course</a></li>
                        <li><a href="#">UGC Performa</a></li>
                    </ul>
                </div>

                <div>
                    <h3>Quick Links</h3>
                    <ul>
                        <li><a href="#">Virtual Tour</a></li>
                        <li><a href="#">Contact Us</a></li>
                        <li><a href="#">Blog</a></li>
                        <li><a href="#">FAQs</a></li>
                        <li><a href="#">APANA Talk</a></li>
                        <li><a href="#">Career</a></li>
                        <li><a href="#">Directory</a></li>
                    </ul>
                </div>

                <div>
                    <h3>Campuses</h3>
                    <ul>
                        <li><a href="#">APANA University - Bhopal</a></li>
                        <li><a href="#">Academic Calendar</a></li>
                    </ul>
                    <div class="last-modified">last modified: August 28 2025 12:42:23</div>
                    <div class="map-box">
                        <iframe
                            src="https://share.google/zCNXbEAH6PBARmtYh"
                            allowfullscreen="" loading="lazy">
                        </iframe>
                    </div>
                </div>
            </div>

            <div class="footer-bottom">
                Copyright � 2025 <a href="#">APANA University Bhopal</a>, The APANA Group Development Team
            </div>
        </footer>

        <!-- Floating Enquire Button -->
        <div onclick="check()" class="enquire-btn">Enquire Now 2025-26</div>

        <!-- Floating WhatsApp Button -->
        <a href="https://wa.me/917803869841" target="_blank" class="whatsapp-btn">
            <i class="fab fa-whatsapp"></i>
        </a>


        <script src="sript.js"></script>

    </body>
</html>
