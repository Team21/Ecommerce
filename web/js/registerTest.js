$(document).ready(function(){
    
    var flag =false;
    $("#register").submit(function(){
        
       // window.alert('asdasdas');
       
      var fname = $("#inputFname1").val();
      $("#inputFname1").blur(function(){
          
           if(fname==null || fname=="" ||fname==""){
           
           $("#fnameError").html("Please Enter your First name");
           $("#inputFname1").focus();
           
       }
      });
       if(fname==null || fname=="" ||fname==""){
           
           $("#fnameError").html("Please Enter your First name");
           $("#inputFname1").focus();
           
       }
       
        
        
        
    });
    
    
    
    
    
});

