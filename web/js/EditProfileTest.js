$(document).ready(function () {

    var fname, lname, email, username, password, date, paypal, phone, address;





    $("#EditButton").click(function () {

        $("#editFname").css("visibility", "visible");
        $("#editLname").css("visibility", "visible");
        $("#editEmail").css("visibility", "visible");
        $("#editUserName").css("visibility", "visible");
        $("#editPassword").css("visibility", "visible");
        $("#editDate").css("visibility", "visible");
        $("#editPayPal").css("visibility", "visible");
        $("#editPhone").css("visibility", "visible");
        $("#editAddress").css("visibility", "visible");

        fname = $("#editFname").val();
        lname = $("#editLname").val();
        email = $("#editEmail").val();
        username = $("#editUserName").val();
        password = $("#editPassword").val();
        date = $("#editDate").val();
        paypal = $("#editPayPal").val();
        phone = $("#editPhone").val();
        address = $("#editAddress").val();
        // window.alert("address value  : "+address);



    });


    $("#SaveEdit").click(function () {

        //*henna hagahez el Ajax request we ab3atoh*//
        $.post("EditProfileServlet",
                {//el json object
                    "fanme": $("#editFname").val(),
                    "lname": $("#editLname").val(),
                    "email": $("#editEmail").val(),
                    "userName": $("#editUserName").val(),
                    "password": $("#editPassword").val(),
                    "Birthdate": $("#editDate").val(),
                    "paypal": $("#editPayPal").val(),
                    "phone": $("#editPhone").val(),
                    "address": $("#editAddress").val()
                }, function (responseTxt, statusTxt, xhr) {
            if (statusTxt == "success") {
                var jobj = jQuery.parseJSON(responseTxt);
                $("#fnameValue").html(" ");
                $("#fnameValue").html(jobj["fName"]);

                $("#lnameValue").html(" ");
                $("#lnameValue").html(jobj["lName"]);

                $("#emailValue").html(" ");
                $("#emailValue").html(jobj["email"]);

                $("#passwordValue").html(" ");
                $("#passwordValue").html(jobj["password"]);

                $("#usernameValue").html(" ");
                $("#usernameValue").html(jobj["userName"]);

                $("#birthDateValue").html(" ");
                $("#birthDateValue").html(jobj["birthdate"]);

                $("#payPalValue").html(" ");
                $("#payPalValue").html(jobj["paypal"]);

                $("#addressValue").html(" ");
                $("#addressValue").html(jobj["address"]);

                $("#PhoneValue").html(" ");
                $("#PhoneValue").html(jobj["phone"]);
                //window.alert(jobj["email"]);
                // window.alert(responseTxt["email"]+","+responseTxt["fName"]);

                /*
                 * el object elly rage3
                 * 
                 * {
                 "id":0,
                 "email":"test@test.com",
                 "fName":"ay7aga",
                 "lName":"kamal",
                 "userName":"eslam",
                 "password":"123456",
                 "birthdate":"Aug 7, 0011 12:00:00 AM",
                 "paypal":80000,
                 "address":"54-sadasd-sadijo st.",
                 "phone":"21356423151",
                 "permissionId":0,
                 "activated":0
                 }
                 * 
                 * 
                 */



//                var jsonObj = JSON.parse(responseTxt);
//                window.alert(jsonObj[0].length);

//                if (responseTxt[0] == 1) {
//
//                window.alert("el server rad 3alia be 1");
//                }
//                if (responseTxt[0] == 2) {
//
//
//                }

            }

            if (statusTxt == "error") {
                window.alert('fail');
            }

        }
        );



    });





});
