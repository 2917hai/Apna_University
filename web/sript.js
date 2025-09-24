


















function  logout()
{

    Swal.fire({
        title: 'Are you sure?',
        text: 'Do you really want to logout?',
        icon: 'warning',
        showCancelButton: true, // Cancel button dikhane ke liye
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, Logout',
        cancelButtonText: 'No, Stay Logged In'
    }).then((result) => {
        if (result.isConfirmed) {
            // ✅ User ne confirm kiya → redirect karo
            window.location.reload(true);             // apna home ya logout servlet page
        }
    });


}






let enq = () =>
{
    let en = document.querySelector('.enquire-form');
    en.style.display = "block";
}
let check = () =>
        {
            let en = document.querySelector("#inquiry-section");
            en.style.display = "block";

        }
let closeenq = () =>
        {
            let en = document.querySelector("#inquiry-section");
            en.style.display = "none";
        }


let StudentProfile = () =>
        {

            let sp = document.querySelector(".profile-container");
            let academic = document.querySelector("#academicdetails");
            let attendance = document.querySelector("#Attendance");
            let Examination = document.querySelector("#Examination");
            let result = document.querySelector("#Result");
            let marksheet = document.querySelector("#Marksheet");
            let documents = document.querySelector("#document");
            let update = document.querySelector("#update");
            let password = document.querySelector("#Password");

            academic.style.display = "none";
            attendance.style.display = "none";
            Examination.style.display = "none";
            result.style.display = "none";
            marksheet.style.display = "none";
            documents.style.display = "none";
            update.style.display = "none";
            password.style.display = "none";
            sp.style.display = "block";

        }
let Academic = () =>
{

    let sp = document.querySelector(".profile-container");
    let academic = document.querySelector("#academicdetails");
    let attendance = document.querySelector("#Attendance");
    let Examination = document.querySelector("#Examination");
    let result = document.querySelector("#Result");
    let marksheet = document.querySelector("#Marksheet");
    let documents = document.querySelector("#document");
    let update = document.querySelector("#update");
    let password = document.querySelector("#Password");
    sp.style.display = "none";
    attendance.style.display = "none";
    Examination.style.display = "none";
    result.style.display = "none";
    marksheet.style.display = "none";
    documents.style.display = "none";
    update.style.display = "none";
    password.style.display = "none";
    academic.style.display = "block";




}

let Attendance = () =>
        {

            let sp = document.querySelector(".profile-container");
            let academic = document.querySelector("#academicdetails");
            let attendance = document.querySelector("#Attendance");
            let Examination = document.querySelector("#Examination");
            let result = document.querySelector("#Result");
            let marksheet = document.querySelector("#Marksheet");
            let documents = document.querySelector("#document");
            let update = document.querySelector("#update");
            let password = document.querySelector("#Password");
            sp.style.display = "none";
            academic.style.display = "none";
            Examination.style.display = "none";
            result.style.display = "none";
            marksheet.style.display = "none";
            documents.style.display = "none";
            update.style.display = "none";
            password.style.display = "none";
            attendance.style.display = "block";
        }
let Examination = () =>
        {

            let sp = document.querySelector(".profile-container");
            let academic = document.querySelector("#academicdetails");
            let attendance = document.querySelector("#Attendance");
            let Exam = document.querySelector("#Examination");
            let result = document.querySelector("#Result");
            let marksheet = document.querySelector("#Marksheet");
            let documents = document.querySelector("#document");
            let update = document.querySelector("#update");
            let password = document.querySelector("#Password");
            sp.style.display = "none";
            academic.style.display = "none";
            attendance.style.display = "none";
            result.style.display = "none";
            marksheet.style.display = "none";
            documents.style.display = "none";
            update.style.display = "none";
            password.style.display = "none";
            Exam.style.display = "block";
        }

let Result = () =>
        {

            let sp = document.querySelector(".profile-container");
            let academic = document.querySelector("#academicdetails");
            let attendance = document.querySelector("#Attendance");
            let Examination = document.querySelector("#Examination");
            let result = document.querySelector("#Result");
            let marksheet = document.querySelector("#Marksheet");
            let documents = document.querySelector("#document");
            let update = document.querySelector("#update");
            let password = document.querySelector("#Password");
            sp.style.display = "none";
            academic.style.display = "none";
            attendance.style.display = "none";
            Examination.style.display = "none";
            marksheet.style.display = "none";
            documents.style.display = "none";
            update.style.display = "none";
            password.style.display = "none";
            result.style.display = "block";
        }

let Marksheet = () =>
        {

            let sp = document.querySelector(".profile-container");
            let academic = document.querySelector("#academicdetails");
            let attendance = document.querySelector("#Attendance");
            let Examination = document.querySelector("#Examination");
            let result = document.querySelector("#Result");
            let marksheet = document.querySelector("#Marksheet");
            let documents = document.querySelector("#document");
            let update = document.querySelector("#update");
            let password = document.querySelector("#Password");
            sp.style.display = "none";
            academic.style.display = "none";
            attendance.style.display = "none";
            Examination.style.display = "none";
            result.style.display = "none";
            documents.style.display = "none";
            update.style.display = "none";
            password.style.display = "none";
            marksheet.style.display = "block";
        }


let Documents = () =>
        {

            let sp = document.querySelector(".profile-container");
            let academic = document.querySelector("#academicdetails");
            let attendance = document.querySelector("#Attendance");
            let examination = document.querySelector("#Examination");
            let result = document.querySelector("#Result");
            let marksheet = document.querySelector("#Marksheet");
            let documents = document.querySelector("#document");
            let update = document.querySelector("#update");
            let password = document.querySelector("#Password");
            sp.style.display = "none";
            academic.style.display = "none";
            attendance.style.display = "none";
            examination.style.display = "none";
            result.style.display = "none";
            marksheet.style.display = "none";
            update.style.display = "none";
            password.style.display = "none";
            documents.style.display = "block";
        }

let Update = () =>
        {

            let sp = document.querySelector(".profile-container");
            let academic = document.querySelector("#academicdetails");
            let attendance = document.querySelector("#Attendance");
            let Examination = document.querySelector("#Examination");
            let result = document.querySelector("#Result");
            let marksheet = document.querySelector("#Marksheet");
            let documents = document.querySelector("#document");
            let update = document.querySelector("#update");
            let password = document.querySelector("#Password");
            sp.style.display = "none";
            academic.style.display = "none";
            attendance.style.display = "none";
            Examination.style.display = "none";
            result.style.display = "none";
            marksheet.style.display = "none";
            documents.style.display = "none";
            password.style.display = "none";
            update.style.display = "block";
        }

let Password = () =>
        {

            let sp = document.querySelector(".profile-container");
            let academic = document.querySelector("#academicdetails");
            let attendance = document.querySelector("#Attendance");
            let Examination = document.querySelector("#Examination");
            let result = document.querySelector("#Result");
            let marksheet = document.querySelector("#Marksheet");
            let documents = document.querySelector("#document");
            let update = document.querySelector("#update");
            let password = document.querySelector("#Password");

            let rs = confirm("Are Sure! want to change your password");
            if (rs)
            {
                sp.style.display = "none";
                academic.style.display = "none";
                attendance.style.display = "none";
                Examination.style.display = "none";
                result.style.display = "none";
                marksheet.style.display = "none";
                documents.style.display = "none";
                update.style.display = "none";
                password.style.display = "block";
            } else
            {
                sp.style.display = "block";
            }
        }

let viewResult = () =>
        {

            let res = document.querySelector("#Result .finalExam");
            let form = document.querySelector("#Result .resultform");
            form.style.display = "none";
            res.style.display = "block";


        }
















