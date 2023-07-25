// function login() {
//     var email = document.getElementById("email").value;
//     var password = document.getElementById("password").value;
//     var userdata = {
//         email: email,
//         password: password
        
//       };
//     // Make an XML HTTP request
//     var xhttp = new XMLHttpRequest();
  
//     xhttp.onreadystatechange = function() {
//       if (this.readyState == 4) {
//         if (this.status == 200) {
//           // Successful login
//         //   redirectToNextPage();
//          // window.location.href = "loginlanding.html";
//         //  window.location.href = "signuplanding.html?email=" + encodeURIComponent(email);
//         document.getElementById('message').textContent = 'Signin Successful!';
//         } else {
//           // Failed login
//          // showErrorMessage();
//           document.getElementById('message').textContent = 'Signin failed!';
//         }
//       }
//     };
  
//     // Replace "api/login" with the actual API endpoint for login
//     xhttp.open("POST", "http://localhost:8080/designer/Login", true);
//     xhttp.setRequestHeader("Content-type", "application/json");
//     xhttp.send(JSON.stringify(userdata));
//   }
  
// //   function showErrorMessage() {
// //     var errorMessage = document.getElementById("error-message");
// //     errorMessage.classList.remove("hidden");
// //   }
  
// //   function redirectToNextPage() {
// //     // Replace "dashboard.html" with the URL or path of the next page after successful login
// //     window.location.href = "dashboard.html";
// //   }
//   ----------------------------------------------------------------------


// Helper function to send XMLHttpRequest
function sendRequest(method, url, data, callback) {
    var xhr = new XMLHttpRequest();
    xhr.open(method, url, true);
    xhr.setRequestHeader('Content-Type', 'application/json');
  xhr.onreadystatechange = function() {
    if (xhr.readyState == 4) {
      if (xhr.status == 200) {
        let data=JSON.parse(xhr.responseText)
        callback(null,data );
      } else {
        callback(xhr.status);
      }
    }
  };
  xhr.send(JSON.stringify(data));
 
  
}

// Signup form submission handler
document.getElementById('loginForm').addEventListener('submit', function(event) {
  event.preventDefault();
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;
   
  var signinData = {
   
      email: email,
      password: password
  };
  const apiData=null;
  sendRequest('POST', 'http://localhost:8080/designer/Login', signinData,async function(error, response) {
    this.apiData=await response;
  if (error !=null) {
      document.getElementById('message').textContent = 'Signin failed!';
      
    } else {
      
    //    document.getElementById('message').textContent = 'Signin successful!';
      window.location.href = "loginlanding.html?name=" + encodeURIComponent(this.apiData.name);
    }
  });
});