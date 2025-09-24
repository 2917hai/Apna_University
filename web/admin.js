/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


let  FacultyProfile = () => {

    let yourProfile = document.querySelector(".main5 .maindata");
    let StudentData = document.querySelector(".main5 .studentsdata");
    let FacultyData = document.querySelector(".main5 .facultydata");
    StudentData.style.display = "none";
    FacultyData.style.display = "block";
    yourProfile.style.display = "none";

}

let  StudentProfile = () => {

    let yourProfile = document.querySelector(".main5 .maindata");
    let StudentData = document.querySelector(".main5 .studentsdata");
    let FacultyData = document.querySelector(".main5 .facultydata");
    FacultyData.style.display = "none";
    yourProfile.style.display = "none";
    StudentData.style.display = "block";

}

let Profile = () =>
{
    let yourProfile = document.querySelector(".main5 .maindata");
    let StudentData = document.querySelector(".main5 .studentsdata");
    let FacultyData = document.querySelector(".main5 .facultydata");
    StudentData.style.display = "none";
    yourProfile.style.display = "block";
    FacultyData.style.display = "";

}








let StudentProfile1 = () =>
        {

            let sp = document.querySelector(".profile-container");
            let academic = document.querySelector("#academicdetails");
            let update = document.querySelector("#update");
            let password = document.querySelector("#Password");

            academic.style.display = "none";
            update.style.display = "none";
            password.style.display = "none";
            sp.style.display = "block";

        }
let Academic1 = () =>
{

    let sp = document.querySelector(".profile-container");
    let academic = document.querySelector("#academicdetails");
    let update = document.querySelector("#update");
    let password = document.querySelector("#Password");
    sp.style.display = "none";
    update.style.display = "none";
    password.style.display = "none";
    academic.style.display = "block";




}






let Update1 = () =>
        {

            let sp = document.querySelector(".profile-container");
            let academic = document.querySelector("#academicdetails");
            let update = document.querySelector("#update");
            let password = document.querySelector("#Password");
            sp.style.display = "none";
            academic.style.display = "none";
            password.style.display = "none";
            update.style.display = "block";
        }

let Password1 = () =>
        {

            let sp = document.querySelector(".profile-container");
            let academic = document.querySelector("#academicdetails");
            let update = document.querySelector("#update");
            let password = document.querySelector("#Password");

            sp.style.display = "none";
            academic.style.display = "none";
            update.style.display = "none";
            password.style.display = "block";

        }

