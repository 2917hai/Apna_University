<%--
    Document   : AdminProfile
    Created on : 19 Sep, 2025, 1:55:49 AM
    Author     : Umesh Yadav
--%>

<%@page import="com.sis.bean.FacultyBean"%>
<%@page import="com.sis.dao.FacultyRegisterDao"%>
<%@page import="com.sis.controller.FacultyRegister"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sis.bean.StudentsBean"%>
<%@page import="com.sis.dao.StudentsRegisterDAO"%>
<%@page import="com.sis.bean.AdminBean"%>
<%@page import="com.sis.dao.Admin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>University_Management_System</title>
        <link rel="stylesheet" href="style.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

    </head>
    <%
        int id = Integer.parseInt(request.getParameter("id"));
        Admin a = new Admin();
        AdminBean ab = a.GetAdmin(id);

        StudentsRegisterDAO sd = new StudentsRegisterDAO();
        ArrayList<StudentsBean> all = sd.FindAll();

        FacultyRegister f = new FacultyRegister();

        FacultyRegisterDao fbb = new FacultyRegisterDao();
        ArrayList<FacultyBean> al = fbb.getAllFaculty();

    %>
    <body style="background-color: antiquewhite">
        <nav>
            <div  class="logo">
                <a href="index.html">
                    <img  src="images/logo.png" alt=""></a>
            </div>
            <span class="item">
                <a  href="index.html">Home</a>
                <span style="color: red">
                    <a href="#">Hello</a>
                    <a href="#"><%=ab.getId()%></a>
                    <a href="#"><%=ab.getName()%></a>
                </span>

                <a href="index.html">Logout</a>

            </span>
        </nav>
        <div class="mar">
            <marquee behavior="alternate" direction="left" scrollamount="8">
                <span class="welcome-text">✨ Welcome to Apana University – Let's Connect Together ✨</span>
            </marquee>
        </div>






        <section id="inquiry-section">
            <i onclick="closeenq()" style="font-size: 30px;  position: absolute; left: 600px; top: 20px; float: right; cursor: pointer;" class="fa-solid fa-xmark"></i>
            <h2>Have Any Questions? We're Here to Help!</h2>
            <p>Fill out the form below, and our team will get back to you shortly.</p>
            <form class="inquiry-form">
                <input type="text" placeholder="Your Name" required  />
                <input type="email" placeholder="Your Email" required />
                <input type="tel" placeholder="Your Phone Number" required />
                <textarea placeholder="Your Message" required></textarea>
                <button type="submit">Submit</button>
            </form>

        </section>



        <div style="height: 700px;" class="main">
            <div class="main5">
                <div class="upper">
                    <p onclick="Profile()" style="background-color: orange;">Your Profile</p>
                    <p onclick="StudentProfile()" style="background-color: blue;"> Students Data</p>
                    <p onclick="FacultyProfile()" style="background-color: green;">Faculty Data</p>
                </div>
                <div class="maindata">
                    <img src="images/logo.png" alt="">
                    <h1>APANA UNIVERSITY BHOPAL (M.P.) 462022  </h1>
                    <h5>Contact No: 7803869841 /9584392185</h5>
                    <h5 >Email: yadavumeshkumar815@gmail.com</h5>
                    <table border="1" cellpadding="10" cellspacing="0">
                        <tr>
                            <th>ID</th>
                            <td>APANA01</td>
                        </tr>
                        <tr>
                            <th>Name</th>
                            <td>Umesh Yadav</td>
                        </tr>
                        <tr>
                            <th>Mobile No</th>
                            <td>Umesh Yadav</td>
                        </tr>
                        <tr>
                            <th>DOB</th>
                            <td>Umesh Yadav</td>
                        </tr>

                    </table>
                </div>




                <div class="studentsdata">
                    <h2>Students Data</h2>
                    <table border="1" cellpadding="10" cellspacing="0">
                        <thead>
                            <tr>
                                <th>Enrollment No</th>
                                <th>Name</th>
                                <th>Course</th>
                                <th>Branch</th>
                                <th>Email</th>
                                <th>Phone</th>
                                <th>City</th>
                                <th>State</th>
                                <th>Photo</th>
                                <th>Update</th>
                                <th>Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                for (StudentsBean data : all) {
                            %>
                            <tr>
                                <td><%= data.getEnrollment()%></td>
                                <td><%= data.getName()%></td>
                                <td><%= data.getCourse()%></td>
                                <td><%= data.getBranch()%></td>
                                <td><%= data.getEmail()%></td>
                                <td><%= data.getMobile()%></td>
                                <td><%= data.getCity()%></td>
                                <td><%= data.getState()%></td>
                                <td>
                                    <img style="height:50px;width:50px;border-radius:50%"
                                         src="getImage?enroll=<%=data.getEnrollment()%>&type=photo" alt="">
                                </td>
                                <td>Update</td>
                                <td>
                                    <a href="DataDelete.jsp?enrollment=<%= data.getEnrollment()%>">Delete</a>
                                </td>
                            </tr>
                            <% }%>
                        </tbody>
                    </table>

                    <a href="StudentsRegister.html" style="margin-left: 600px; margin-top: 100px; font-weight: bold;">Add new Students ....!</a>

                </div>




                <div class="facultydata">
                    <h2>Faculty Data</h2>
                    <table border="1" cellpadding="10" cellspacing="0">
                        <thead>
                            <tr>
                                <th>Employee ID</th>
                                <th>Name</th>
                                <th>Course</th>
                                <th>Faculty ID</th>
                                <th>Email</th>
                                <th>Phone</th>
                                <th>City</th>
                                <th>State</th>
                                <th>Photo</th>
                                <th>Update</th>
                                <th>Delelte</th>
                        </thead>
                        <tbody>
                            <%
                                for (FacultyBean um : al) {
                            %>
                            <tr>
                                <td><%=um.getEmpId()%></td>
                                <td><%=um.getName()%></td>
                                <td><%=um.getSpecialization()%></td>
                                <td><%=um.getFacultyId()%></td>
                                <td><%=um.getEmail()%></td>
                                <td><%=um.getPhone()%></td>
                                <td><%=um.getCity()%></td>
                                <td><%=um.getState()%></td>
                                <td><img style="height: 50px; width: 50px; border-radius: 50%" src="FacultyImage?empId=<%=um.getEmpId()%>&type=photo"alt=""></td>
                                <td>Update</td>
                                <td>
                                    <a href="FDataDelete.jsp?empId=<%= um.getEmpId()%>">Delete</a>
                                </td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                    <a href="facultyRegister.html" style="margin-left: 600px; margin-top: 100px; font-weight: bold;">Add new Faculty Member....!</a>
                </div>


            </div>
        </div>



        <div class="top-box">
            <button class="btn-orange"><i class="fa-solid fa-graduation-cap"></i> Apply for Degree</button>
            <button class="btn-blue"><i class="fa-solid fa-university"></i> NAAC Portal</button>
            <button class="btn-darkblue"><i class="fa-solid fa-briefcase"></i> Career Portal</button>
            <button class="btn-red"><i class="fa-solid fa-book"></i> Central Library</button>
            <br>
            <button class="btn-dark"><i class="fa-solid fa-user-pen"></i> Process for Name Correction</button>
            <button class="btn-red"><i class="fa-solid fa-file-circle-exclamation"></i> Process for Duplicate Marksheet</button>
            <button class="btn-orange"><i class="fa-solid fa-file-signature"></i> Process for Transcript</button>
            <button class="btn-darkblue2"><i class="fa-solid fa-certificate"></i> Process for Degree</button>
            <br><br>
            <button class="btn-pink"><i class="fa-solid fa-magnifying-glass"></i> Surprise Inspection</button>
        </div>

        <!-- Three Columns -->
        <div class="container">
            <!-- Important Notice -->
            <div class="box">
                <h3 class="notice"><i class="fa-solid fa-circle-info"></i> IMPORTANT NOTICE</h3>
                <div class="content">
                    <ul>
                        <li><i class="fa-solid fa-file-lines"></i> School of Nanotechnology announces Certificate Courses <span class="new-tag">new</span></li>
                        <li><i class="fa-solid fa-file-lines"></i> Permitted MOOCS Course List Faculty of B.Tech EX,EC,EE etc. Students July-Dec 2025 <span class="new-tag">new</span></li>
                        <li><i class="fa-solid fa-file-lines"></i> Regarding Certificate for degree of B.Tech course Session June_2024 <span class="new-tag">new</span></li>
                        <li><i class="fa-solid fa-file-lines"></i> Instructions to download degree certificate from Digi Locker NAD <span class="new-tag">new</span></li>
                    </ul>
                </div>
                <div class="view-more"><i class="fa-solid fa-chevron-down"></i> View More</div>
            </div>

            <!-- University Distinctiveness -->
            <div class="box">
                <h3 class="distinct"><i class="fa-solid fa-building-columns"></i> UNIVERSITY DISTINCTIVENESS</h3>
                <div class="content">
                    <p><b>Coming Soon !!</b></p>
                </div>
            </div>

            <!-- Important Links -->
            <div class="box">
                <h3 class="links"><i class="fa-solid fa-link"></i> IMPORTANT LINKS</h3>
                <div class="content">
                    <ul>
                        <li><i class="fa-solid fa-file"></i> I.C.C. COMMITTEE</li>
                        <li><i class="fa-solid fa-file"></i> NIRF- APANA ENGG(2025)</li>
                        <li><i class="fa-solid fa-file"></i> NIRF- APANA OVERALL(2025)</li>
                        <li><i class="fa-solid fa-file"></i> NIRF- APANA ENGG(2024)</li>
                        <li><i class="fa-solid fa-file"></i> NIRF- APANA OVERALL(2024)</li>
                        <li style="color:red;font-weight:bold;"><i class="fa-solid fa-flask"></i> Research Portal</li>
                        <li><i class="fa-solid fa-network-wired"></i> APANA-CISCO ACADEMY</li>
                        <li><i class="fa-solid fa-user-tie"></i> Employer Login</li>
                        <li><i class="fa-solid fa-file"></i> NIRF- APANA ENGG(2022)</li>
                        <li><i class="fa-solid fa-file"></i> NIRF- APANA OVERALL(2022)</li>
                        <li><i class="fa-solid fa-file"></i> SSR(NAAC)-2017</li>
                        <li><i class="fa-solid fa-file"></i> TEQIP</li>
                    </ul>
                </div>
            </div>
        </div>

        <section id="about-section">
            <!-- Left Image -->
            <div class="about-left">
                <img src="images/first.jpg" alt="University Campus">
            </div>

            <!-- Right Content -->
            <div class="about-right">
                <h2>Best Private University in Bhopal, MP, India</h2>
                <p>
                    APANA University Bhopal, proudly recognized as the best private university in Bhopal, Madhya Pradesh, India, is the symbol of academic brilliance, innovation, and holistic development. Established in 2020, the university builds on more than 40 years of expertise in education. Under the visionary leadership of Er. Sanjeev Agrawal, the university reflects the ethos of APANA—Academic Progress And National Advancement. With the proven track record of 2500+ placements, 200+ industry visits, 100+ MOUs, 1500+ research papers, and 525+ company visits, APANA University is committed to redefining education through student-oriented learning, state-of-the-art infrastructure, and a vibrant campus environment.
                </p>
                <p>
                    Spread across 75 acres, the campus boasts advanced laboratories, design studios, an Olympic-sized swimming pool, a sports club, audio studios, a photography studio, agricultural land for practice, and much more. These facilities provide an ideal setting for students to excel both academically and personally. As the top private university in Bhopal, Madhya Pradesh, India, APANA University offers a diverse range of programs, including <a href="#">engineering & technology</a>, <a href="#">management</a>, agricultural planning and design, pharmaceutical sciences, arts and humanities and social science, journalism and mass communication, <a href="#">law and legal studies</a>, performing arts, and more.
                </p>
                <p>
                    The university’s industry-aligned curriculum emphasizes project-based and experiential learning, preparing students for real-world challenges, supported by a dedicated Corporate Relations Cell. Students benefit from 100% placement opportunities with top companies like Wipro, TCS, Deloitte, Dmart, Vivo, HDFC Bank, Amul, and the list is extensive.
                </p>

                <a href="#" class="about-btn">Know More about University</a>
            </div>
        </section>


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

