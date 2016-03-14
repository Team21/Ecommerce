$(document).ready(function () {
//validation for email and password
    $("#inputEmail").focus();
    var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/; //email regex
    var emailflag = false;
    var passflag = false;

    $("#btnLogin").click(function () {
        var email = $("#inputEmail").val();
        var password = $("#inputPassword").val();



        if (email == null || email == "" || email == " " || (!regex.test(email))) {

            $("#emailError").html("<image src='./HomeImages/erroricon.png' width='30px' height='30px' /> Please Enter valid E-mail");
            $("#inputEmail").focus();
            // window.alert('enter email');
        }
        else if (email != null || regex.test(email)) {
            //$("#emailError").css('color: #24bf51;');
            $("#emailError").html("<image src='./HomeImages/validicon.png' width='30px' height='30px' /> ");
            $("#inputPassword").focus();
            emailflag = true;

        }


        if (password == null || password == "" || password == " ") {

            $("#passwordError").html("<image src='./HomeImages/erroricon.png' width='30px' height='30px' /> Please Enter Password");
            $("#inputPassword").focus();

        }
        else if (email != null) {
            if ((password.length > 5)) {
                $("#passwordError").html("<image src='./HomeImages/validicon.png' width='30px' height='30px' /> ");
                passflag = true;
            }
            else {
                $("#passwordError").html("<image src='./HomeImages/erroricon.png' width='30px' height='30px' /> Password length is less than 5");
                $("#inputPassword").focus();

            }

        }

        if (passflag == true && emailflag == true) {
            //valid email and password

            $("#loginError").html("Thanks for Logging in Successfully...");

            $.ajax({
                url: "SignInServletController",
                method: "post",
                data: {
                    "email": $("#inputEmail").val(),
                    "password": $("#inputPassword").val()
                },
                success: function (data, textStatus, jqXHR) {
                   
                    window.location.href = "index.html";

                }
            });

        }








    });


});

