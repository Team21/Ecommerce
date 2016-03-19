/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {

    $("#inputEmail").val(null);
    $("#inputPassword").val(null);

    $("#inputEmail").focus();

    var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/; //email regex
    var emailflag = false;
    var passflag = false;

    $("#formlogin").submit(function (event) {

      
        var email = $("#inputEmail").val();
        var password = $("#inputPassword").val();
        if (email == null || email == "" || email == " " || (!regex.test(email))) {

            $("#emailError").html("<image src='./HomeImages/erroricon.png' width='30px' height='30px' /> Please Enter valid E-mail");
            $("#inputEmail").focus();
            emailflag = false;
            // window.alert('enter email');
        }
        else if (email != null && regex.test(email)) {
            //$("#emailError").css('color: #24bf51;');
            $("#emailError").html("<image src='./HomeImages/validicon.png' width='30px' height='30px' /> ");
            $("#inputPassword").focus();
            emailflag = true;

        }


        if (password == null || password == "" || password == " ") {

            $("#passwordError").html("<image src='./HomeImages/erroricon.png' width='30px' height='30px' /> Please Enter Password");
            $("#inputPassword").focus();
            passflag = false;

        }
        else if (email != null) {
            if ((password.length > 5)) {
                $("#passwordError").html("<image src='./HomeImages/validicon.png' width='30px' height='30px' /> ");
                passflag = true;
            }
            else {
                $("#passwordError").html("<image src='./HomeImages/erroricon.png' width='30px' height='30px' /> Password length is less than 5");
                $("#inputPassword").focus();
                passflag = false;

            }

        }

        if (passflag == true && emailflag == true) {
            //valid email and password

            $("#loginError").html("Logging in..");


           //  $("#loadimg").html("<img src='HomeImages/loadingWait.gif' alt='Loading Please Wait..' width='100px' height='100px' >");


            return true;

        }
        else if (passflag == false || emailflag == false) {
            $("#loginError").html("Please Enter Valid Data.");
            event.preventDefault();
            return false;

        }


    });




});
