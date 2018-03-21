/**
 * 
 */

 $(document).ready(function() {
	 function cleanAllData(){
		 //alert("cleanData");
		$("#first_name").val("");
	      $("#className").val("");
	      $("#stud_id").val("");
	      $("#stud_password").val("");
		  //   $("#email").val("");
	      $("#pracOne option").remove();
	      //$("#errorMsg").text("");
	}
	 function getPracticalNames(temp) {
		 alert(temp+" Temp");
   	  $.ajax({
       	  url:"spring-mvc/getPracticalName",
       	  type:"get",
       	  data:{
       		  className : temp 
       	  },
       	  datatype:"json",
       	  success: function(responseText){
       		  var data1=JSON.parse(responseText);
       		  var temp1=data1[0];
       		  $("#pracOne option").remove();
       		  var str=" <option selected='selected' value='0' >Select Practical Name</option>";
        $.each(data1,function(key,value){
                	 str+="<option value='1'>"+value.pracOne+"</option>"+
                	 "<option value='2'>"+value.pracTwo+"</option>"+
         			"<option value='3'>"+value.pracThree+"</option>"+
         			"<option value='4'>"+value.pracFour+"</option>"+
         			"<option value='5'>"+value.pracFive+"</option>";
                 });
                $("#pracOne").append(str);   
       	  }
         }); //ajax call
	}
	 $("#studentLogout").click(function(event){
		 $("#errorMsg").text(" ");
		 var stud=$("#email").val();
	        $.ajax({
	        	url:"spring-mvc/studentLogout",
	        	type:"get",
	        	datatype:"json",
		        data:{
		        	email:stud
		        },
		        success:function(response){
		        	
		 		   $("#errorMsg").text(response);
		 		},
		 	   error:function(errorResponse){
		 		   alert("errorResponse "+errorResponse);
		 	   }
	        }); 
	        return false;
	 });
	 
	 $("#studentLogin").click(function(event){
		var first_name= $("#first_name").val();
        var className= $("#className").val();
         var practical_name=$("#pracOne option:selected").text();
         var stud_password=$("#stud_password").val();
         var stud=$("#email").val();
         var stud_id=$("#stud_id").val();
         if($("#pracOne").val()=="0" ){
        	 $("#errorMsg").text("you did not selected Practical name..plz select it and proceed..");
        	 return false;
         }
         if(stud_password==""){
			 $("#errorMsg").text("Your password is missing..!!");
		   	 return false;
		 }
	    
         if(className==""){
        	 
        	 return false;
         }
		if(stud==""){
			 $("#errorMsg").text("Enter Your email..!!");
		   return false;
		 }
		if(first_name==""){
       	 $("#errorMsg").text("Not a valid email");
       		 return false;
         }
         alert(first_name+" "+className+" "+practical_name+" "+stud_password+" "+stud);
   $.ajax({
	   url:"spring-mvc/studentLogin",
	   type:"post",
	   datatype:"json",
	   data:{
		   first_name:first_name,
		   className:className,
		   practical_name:practical_name,
		   stud_password:stud_password,
		   email:stud,
		   stud_id:stud_id
	   },
	   success:function(response){
		   $("#errorMsg").text(response);
		   setTimeout(function(){
			   cleanAllData();
		}, 3000);
	   },
	   error:function(errorResponse){
		   alert("errorResponse "+errorResponse.data);
	   }
   });      
    return false;
}); 
     $('#email').blur(function(event) {
    		$("#errorMsg").text(" ");
    	 var emailRegex=/^[a-zA-z0-9._]{1,25}[@][a-z]{2,6}[.][a-z0-9]{2,5}$/;
    	 var name = $('#email').val();
    	 cleanAllData();
    	 if(name==""){
       	  $("#errorMsg").text("Please enter email");
       	  return false;
         }
    	 if(!emailRegex.test(name)){
        	  $("#errorMsg").text("Not a valid email");
        	  return false;
          }
          $.ajax({
        	  url:"spring-mvc/isUserExists",
        	  type:"get",
        	  data:{
        		  userName : name 
        	  },
        	  datatype:"json",
        	  success: function(responseText){
        		//  alert(responseText);
        		  if(responseText=="" || responseText=="Student data is not exists"){
        		$("#errorMsg").text("Your data is not present...");
        		  return false; 
        		  }
        		  var temp=responseText[0];
        		  $("#first_name").val(temp.first_name+" "+temp.last_name);
        		  $("#className").val(temp.className);
        		  $("#stud_id").val(temp.stud_id);
        		  if(temp.className==""){
        			  alert("class is null");
        			  return false;
        		  }
        		  getPracticalNames(temp.className);
              }
          });   
     });
});
//Get the modal
 
 
 
 
 
 
 
 
 /*

 $(document).ready(function() {
	 function cleanAllData(){
		 //alert("cleanData");
		$("#first_name").val("");
	      $("#className").val("");
	      $("#stud_id").val("");
	      $("#stud_password").val("");
		  //   $("#email").val("");
	      $("#pracOne option").remove();
	      //$("#errorMsg").text("");
	}
	 function getPracticalNames(temp) {
alert(temp+" Temp");
   	  $.ajax({
       	  url:"<%=application.getContextPath()%>/spring-mvc/getPracticalName",
       	  type:"get",
       	  data:{
       		  className : temp 
       	  },
       	  datatype:"json",
       	  success: function(responseText){
       		  var data1=JSON.parse(responseText);
       		  var temp1=data1[0];
       		  $("#pracOne option").remove();
       		  var str=" <option selected='selected' value='0' >Select Practical Name</option>";
        $.each(data1,function(key,value){
                	 str+="<option value='1'>"+value.pracOne+"</option>"+
                	 "<option value='2'>"+value.pracTwo+"</option>"+
         			"<option value='3'>"+value.pracThree+"</option>"+
         			"<option value='4'>"+value.pracFour+"</option>"+
         			"<option value='5'>"+value.pracFive+"</option>";
                 });
                $("#pracOne").append(str);   
       	  }
         }); //ajax call
	}
	 $("#studentLogout").click(function(event){
		 $("#errorMsg").text(" ");
		 var stud=$("#email").val();
	        $.ajax({
	        	url:"<%=application.getContextPath() %>/spring-mvc/studentLogout",
	        	type:"get",
	        	datatype:"json",
		        data:{
		        	email:stud
		        },
		        success:function(response){
		        	
		 		   $("#errorMsg").text(response);
		 		},
		 	   error:function(errorResponse){
		 		   alert("errorResponse "+errorResponse);
		 	   }
	        }); 
	        return false;
	 });
	 
	 $("#studentLogin").click(function(event){
		var first_name= $("#first_name").val();
        var className= $("#className").val();
         var practical_name=$("#pracOne option:selected").text();
         var stud_password=$("#stud_password").val();
         var stud=$("#email").val();
         var stud_id=$("#stud_id").val();
         if($("#pracOne").val()=="0" ){
        	 alert("you did not selected Practical name..plz select it and proceed..");
        	 return false;
         }
         if(stud_password==""){
			 $("#errorMsg").text("Your password is missing..!!");
		   	 return false;
		 }
	    
         if(className==""){
        	 
        	 return false;
         }
		if(stud==""){
			 $("#errorMsg").text("Enter Your email..!!");
		   return false;
		 }
		if(first_name==""){
       	 $("#errorMsg").text("Not a valid email");
       		 return false;
         }
         alert(first_name+" "+className+" "+practical_name+" "+stud_password+" "+stud);
   $.ajax({
	   url:"<%=application.getContextPath()%>/spring-mvc/studentLogin",
	   type:"post",
	   datatype:"json",
	   data:{
		   first_name:first_name,
		   className:className,
		   practical_name:practical_name,
		   stud_password:stud_password,
		   email:stud,
		   stud_id:stud_id
	   },
	   success:function(response){
		   $("#errorMsg").text(response);
		   setTimeout(function(){
			   cleanAllData();
		}, 3000);
	   },
	   error:function(errorResponse){
		   alert("errorResponse "+errorResponse.data);
	   }
   });      
    return false;
}); 
     $('#email').blur(function(event) {
    		$("#errorMsg").text(" ");
    	 var emailRegex=/^[a-zA-z0-9._]{1,25}[@][a-z]{2,6}[.][a-z0-9]{2,5}$/;
    	 var name = $('#email').val();
    	 cleanAllData();
          if(!emailRegex.test(name)){
        	  $("#errorMsg").text("Not a valid email");
        	  return false;
          }
          $.ajax({
        	  url:"<%=application.getContextPath()%>/spring-mvc/isUserExists",
        	  type:"get",
        	  data:{
        		  userName : name 
        	  },
        	  datatype:"json",
        	  success: function(responseText){
        		//  alert(responseText);
        		  if(responseText=="" || responseText=="Student data is not exists"){
        		$("#errorMsg").text("Your data is not present...");
        		  return false; 
        		  }
        		  var temp=responseText[0];
        		  alert(temp.first_name);
        		   var data=JSON.parse(responseText);
        		  var temp=data[0]; 
        		  $("#first_name").val(temp.first_name+" "+temp.last_name);
        		  $("#className").val(temp.className);
        		  $("#stud_id").val(temp.stud_id);
        		  if(temp.className==""){
        			  alert("class is null");
        			  return false;
        		  }
        		  getPracticalNames(temp.className);
              }
          });   
     });
});
//Get the modal

*/