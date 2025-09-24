<%--
    Document   : FacultyProfile
    Created on : 22 Sep, 2025, 11:46:23 PM
    Author     : Umesh Yadav
--%>

<%@page import="com.sis.bean.FacultyBean"%>
<%@page import="com.sis.dao.FacultyRegisterDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String enroll = request.getParameter("empId");
            FacultyRegisterDao sd = new FacultyRegisterDao();
            FacultyBean sb = sd.GetById(enroll);
        %>
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
                            <%= sb.getEmpId()%>
                        </Span>
                    </p>
                    <p></p>
                    <div class="img">
                        <img
                            style="height: 30px; width: 30px; border-radius: 50%"
                            src="FacultyImage?empId=<%=sb.getEmpId()%>&type=photo"
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
                            src="FacultyImage?empId=<%=sb.getEmpId()%>&type=photo"
                            alt="Profile Picture"
                            />
                    </div>
                    <div class="profile-info">
                        <p><strong>Name:</strong> <%= sb.getName()%></p>
                        <p><strong>Employee ID::</strong> <%= sb.getEmpId()%></p>
                        <hr />
                        <div class="list">
                            <p onclick="StudentProfile1()">Your Profile</p>
                            <p onclick="Academic1()">Emp ID Card:</p>
                            <p onclick="Update1()">Update Profile</p>
                            <p onclick="Password1()">Change Password</p>
                            <p onclick="logout()">Logout<i style="margin-left: 20px" class="fa-solid fa-right-from-bracket"></i> </p>
                        </div>
                    </div>
                </div>


                <div class="maindata">


                    <div class="profile-container">
                        <div class="profile-header"> Faculty Profile</div>

                        <div class="tabs">
                            <button class="active">Personal Info</button>
                        </div>

                        <div class="tab-content">
                            <table class="info-table">
                                <tr>
                                    <td class="label">Employee ID</td>
                                    <td class="value"><%= sb.getEmpId()%></td>
                                </tr>
                                <tr>
                                    <td class="label">Name</td>
                                    <td class="value"><%= sb.getName()%></td>
                                </tr>
                                <tr>
                                    <td class="label">Father's Name</td>
                                    <td class="value"><%= sb.getFather()%></td>
                                </tr>
                                <tr>
                                    <td class="label">Mother's Name</td>
                                    <td class="value"><%= sb.getMother()%></td>
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
                                    <td class="value"><%= sb.getPhone()%></td>
                                </tr>
                                <tr>
                                    <td class="label">Email</td>
                                    <td class="value"><%= sb.getEmail()%></td>
                                </tr>


                                <tr>
                                    <td class="label">Current Address</td>
                                    <td class="value"><%= sb.getCaddress()%></td>
                                </tr>
                                <tr>
                                    <td class="label">Permanent Address</td>
                                    <td class="value"><%= sb.getAddress()%></td>
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
                    </div>-



                    <section id="academicdetails">
                        <h1 style="margin-left: 350px">Students ID Card</h1>
                        <div class="id-card" id="IdCard">
                            <div style="background-color: rgb(7, 7, 76);" class="header">

                                <img  src="images/logo.png" alt="University Logo" class="logo">
                                <h2 style="color: whitesmoke; font-weight: bold; margin-top: -60px;">Apana University Bhopal M.P.</h2>
                            </div>

                            <div class="photo">
                                <img src="FacultyImage?empId=<%=sb.getEmpId()%>&type=photo" alt="Student Photo">
                            </div>

                            <div class="info">
                                <p><strong>Name:</strong> <%=sb.getName()%></p>
                                <p><strong>Enployee ID:</strong><%=sb.getEmpId()%> </p>
                                <p><strong>Course:</strong> <%=sb.getSpecialization()%>.[<%=sb.getDepartment()%>]</p>
                                <p><strong>Contact:</strong> <%=sb.getPhone()%></p>
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





                    <section id="update">
                        <h1 style="text-align: center">Here You can update your profile</h1>
                        <div class="form-box" >
                            <form action="UpdateFaculty" method="post" enctype="multipart/form-data">
                                <div class="personal-info">
                                    <h2>Personal Information:</h2>
                                    <label for="name">Enter Your EmpId:</label>
                                    <input type="text" id="empId" name="empId" placeholder="Enter Your EmpId" value="<%=sb.getEmpId()%>" readonly required> <br>
                                    <label for="name">Enter Your Name:</label>
                                    <input type="text" id="name" name="name" placeholder="Enter Your Name"  value="<%=sb.getName()%>"  required> <br>
                                    <label for="father">Enter Father Name:</label>
                                    <input type="text" id="father" name="father" placeholder="Enter Father Name"  value="<%=sb.getFather()%>"  required><br>
                                    <label for="mother">Enter Mother Name:</label>
                                    <input type="text" id="mother" name="mother" placeholder="Enter Mother Name"  value="<%=sb.getMother()%>"  required><br>
                                    <label for="dob">Enter Your Date of Birth:</label>
                                    <input type="date" id="dob" name="dob" placeholder="Enter Your DOB"  value="<%=sb.getDob()%>"  required> <br>
                                    <label for="gender">Choose Your gender:</label>
                                    <input type="radio" id="gender" name="gender" value="Male"  >Male
                                    <input type="radio" id="gender" name="gender" value="Female" >Female <br>
                                    <label for="photo">Upload photo</label>
                                    <input type="file" id="photo" name="photo" required> <br>
                                    <label for="sign">Upload Signature</label>
                                    <input type="file" id="sign" name="sign" required>
                                </div>
                                <h2>Contact Information:</h2>
                                <label for="email">Enter Your Email:  </label>
                                <input type="email" id="email" name="email" placeholder="Enter Your Email" value="<%=sb.getEmail()%>"  required> <br>
                                <label for="phone">Enter Phone Number:</label>
                                <input type="tel" id="phone" name="phone" placeholder="Enter Your Phone Number"  value="<%=sb.getPhone()%>" required><br>
                                <label for="aphone">Enter alternate Number:</label>
                                <input type="tel" id="phone" name="aphone" placeholder="Enter Your Phone Number"  value="<%=sb.getAphone()%>" ><br>
                                <label for="address">Permanent Address:</label>
                                <input type="text" id="address" name="address" placeholder="Enter Your Address"  value="<%=sb.getCaddress()%>"  required> <br>
                                <label for="caddress">Current Address:</label>
                                <input type="text" id="caddress" name="caddress" placeholder="Enter Current Address"  value="<%=sb.getAddress()%>" required> <br>
                                <label for="city">Enter City:</label>
                                <input type="text" id="city" name="city" placeholder="Enter Your City"  value="<%=sb.getCity()%>"  required> <br>
                                <label for="state">Enter State:</label>
                                <input type="text" id="state" name="state" placeholder="Enter Your State"  value="<%=sb.getState()%>"  required> <br>
                                <label for="pincode">Enter Pincode:</label>
                                <input type="text" id="pincode" name="pincode" placeholder="Enter Your Pincode"   value="<%=sb.getPincode()%>"  required> <br>

                                <div class="professionalDetails" style="position: absolute; top: 50px; left: 450px;">
                                    <h2>Professional details</h2>
                                    <label for="idProof">ID Proof (Aadhaar / Passport / Driving License):</label>
                                    <input type="text" id="idProof" name="idProof" placeholder="Enter ID Number (e.g., Aadhaar No.)"  value="<%=sb.getIdProof()%>"  required />
                                    <br>

                                    <label for="facultyId">Faculty ID:</label>
                                    <input type="text" id="facultyId" name="facultyId" placeholder="Enter Faculty ID (if manual)"  value="<%=sb.getFacultyId()%>"  />
                                    <br>

                                    <!-- Department -->
                                    <label for="department">Department:</label>
                                    <select id="department" name="department" required>
                                        <option value="" disabled selected>Select Department</option>
                                        <option value="cs">Computer Science</option>
                                        <option value="physics">Physics</option>
                                        <option value="chemistry">Chemistry</option>
                                        <option value="maths">Mathematics</option>
                                        <option value="commerce">Commerce</option>
                                        <option value="arts">Arts</option>
                                        <option value="management">Management</option>
                                        <option value="other">Other</option>
                                    </select>
                                    <br>

                                    <!-- Designation -->
                                    <label for="designation">Designation:</label>
                                    <select id="designation" name="designation"  required>
                                        <option value="" disabled selected>Select Designation</option>
                                        <option value="lecturer">Lecturer</option>
                                        <option value="asst_prof">Assistant Professor</option>
                                        <option value="assoc_prof">Associate Professor</option>
                                        <option value="professor">Professor</option>
                                        <option value="hod">Head of Department (HOD)</option>
                                    </select>
                                    <br>

                                    <!-- Highest Qualification -->
                                    <label for="qualification">Highest Qualification:</label>
                                    <select id="qualification" name="qualification"       required  >
                                        <option value="" disabled selected>Select Qualification</option>
                                        <option value="msc">M.Sc</option>
                                        <option value="ma">M.A</option>
                                        <option value="mcom">M.Com</option>
                                        <option value="mtech">M.Tech</option>
                                        <option value="mphil">M.Phil</option>
                                        <option value="phd">Ph.D</option>
                                        <option value="other">Other</option>
                                    </select>
                                    <br>

                                    <!-- Specialization -->
                                    <label for="specialization">Specialization:</label>
                                    <input type="text" id="specialization" name="specialization"  value="<%=sb.getSpecialization()%>" placeholder="Enter subject expertise (e.g., Data Science, Organic Chemistry)"  value="<%=sb.getSpecialization()%>"  required />
                                    <br>

                                    <!-- Years of Experience -->
                                    <label for="experience">Years of Experience:</label>
                                    <input type="number" id="experience" name="experience"  value="<%=sb.getExperience()%>" placeholder="Enter years of teaching/research experience" min="0"  value="<%=sb.getExperience()%>"  required />
                                    <br>

                                    <!-- Previous Institution -->
                                    <label for="prevInstitution">Previous Institution (if any):</label>
                                    <input type="text" id="prevInstitution" name="prevInstitution" placeholder="Enter previous institution name"  value="<%=sb.getPrevInstitution()%>"  />

                                </div>
                                <button style="margin-top: 50px; cursor: pointer" type="submit" >Update</button>
                            </form>
                        </div>
                    </section>












                    <section id="Password">
                        <div class="container">
                            <h2>Forgot Password</h2>
                            <form action="FacultyPasswordForget">
                                <label for="Enrollment">Enter Enrollment:</label>
                                <input type="text" id="Enrollment" name="Enrollment" value="<%=sb.getEmpId()%>" readonly>
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
                Copyright © 2025 <a href="#">APANA University Bhopal</a>, The APANA Group Development Team
            </div>
        </footer>

        <!-- Floating Enquire Button -->
        <div onclick="check()" class="enquire-btn">Enquire Now 2025-26</div>

        <!-- Floating WhatsApp Button -->
        <a href="https://wa.me/917803869841" target="_blank" class="whatsapp-btn">
            <i class="fab fa-whatsapp"></i>
        </a>

        <script src="script.js"></script>
        <script src="admin.js"></script>
    </body>
</html>
