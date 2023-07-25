// Helper function to send XMLHttpRequest
function sendRequest(method, url, data, callback) {
    var xhr = new XMLHttpRequest();
    xhr.open(method, url, true);
    xhr.setRequestHeader('Content-Type', 'application/json');
  xhr.onreadystatechange = function() {
    if (xhr.readyState == 4) {
      if (xhr.status == 200) {
        callback(null, JSON.parse(xhr.responseText));
      } else {
        callback(xhr.status);
      }
    }
  };
  xhr.send(JSON.stringify(data));
 
  
}

// Signup form submission handler
document.getElementById('signupForm').addEventListener('submit', function(event) {
  event.preventDefault();
    var name = document.getElementById('name').value;
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;
    var mobilenumber = document.getElementById('mobilenumber').value;
    var addressline1 = document.getElementById('addressline1').value;
    var addressline2 = document.getElementById('addressline2').value;
    var landmark = document.getElementById('landmark').value;
    var city = document.getElementById('city').value;
    var state = document.getElementById('state').value;
    var country = document.getElementById('country').value;
    var pincode = document.getElementById('pincode').value;
  
  var signupData = {
   
    name: name,
      email: email,
      password: password,
      mobilenumber: mobilenumber,
      addressline1 : addressline1,
      addressline2 : addressline2,
      landmark : landmark,
      city : city,
      state : state,
      country : country,
      pincode : pincode
  };
  
  sendRequest('POST', 'http://localhost:8080/designer/signup', signupData, function(error, response) {
    if (error) {
      document.getElementById('message').textContent = 'Signup failed!';
      
    } else {
      // document.getElementById('message').textContent = 'Signup successful!';
      window.location.href = "signuplanding.html?name=" + encodeURIComponent(name);
    }
  });
});


// ------------------------------------------------
  
// function signup() {
//   var name = document.getElementById('name').value;
//   var email = document.getElementById('email').value;
//   var password = document.getElementById('password').value;
//   var mobilenumber = document.getElementById('mobilenumber').value;
//   var addressline1 = document.getElementById('addressline1').value;
//   var addressline2 = document.getElementById('addressline2').value;
//   var landmark = document.getElementById('landmark').value;
//   var city = document.getElementById('city').value;
//   var state = document.getElementById('state').value;
//   var country = document.getElementById('country').value;
//   var pincode = document.getElementById('pincode').value;

//   var signupData = {
   
//           name: name,
//           email: email,
//           password: password,
//           mobilenumber: mobilenumber,
//           addressline1 : addressline1,
//           addressline2 : addressline2,
//           landmark : landmark,
//           city : city,
//           state : state,
//           country : country,
//           pincode : pincode
//       };
//   // Make an XML HTTP request
//   var xhttp = new XMLHttpRequest();

//   xhttp.onreadystatechange = function() {
//     if (this.readyState == 4) {
//       if (this.status == 200) {
//         showSuccessMessage(name);
//         redirectToNextPage();
//       } else {
//         // Handle error condition
//         console.log("Signup request failed with status: " + this.status);
//       }
//     }
//   };

//   // Replace "api/signup" with the actual API endpoint for signup
//   xhttp.open("POST", "http://localhost:8080/designer/signup", true);
//   xhttp.setRequestHeader("Content-type", "application/json");
//   xhttp.send(JSON.stringify(signupData));
// }

// function showSuccessMessage(name) {
//   var successMessage = document.getElementById("success-message");
//   var nameDisplay = document.getElementById("name-display");
//   nameDisplay.innerHTML = name;

//   successMessage.classList.remove("container");
// }

// function redirectToNextPage() {
//   // Replace "next-page.html" with the URL or path of the next page
//   window.location.href = "landing.html";
// }


// ---------------------------------------------------------------
// document.addEventListener("DOMContentLoaded", function() {
//   var signupForm = document.getElementById("signupForm");
//   // var signinForm = document.getElementById("signinForm");

//   signupForm.addEventListener("submit", function(event) {
//     event.preventDefault(); // Prevent form submission

//     // Get signup form input values
//     var name = document.getElementById("name").value;
//     var email = document.getElementById('email').value;
//     var password = document.getElementById('password').value;
//     var mobilenumber = document.getElementById('mobilenumber').value;
//     var addressline1 = document.getElementById('addressline1').value;
//     var addressline2 = document.getElementById('addressline2').value;
//     var landmark = document.getElementById('landmark').value;
//     var city = document.getElementById('city').value;
//     var state = document.getElementById('state').value;
//     var country = document.getElementById('country').value;
//     var pincode = document.getElementById('pincode').value;

//      // Create a new XHR object
//      var xhr = new XMLHttpRequest();

//     // Create an object with the user data
//      xhr = {
//       name: name,
//       email: email,
//       password: password,
//       mobilenumber: mobilenumber,
//       addressline1 : addressline1,
//       addressline2 : addressline2,
//       landmark : landmark,
//       city : city,
//       state : state,
//       country : country,
//       pincode : pincode
//     };
   

//     // Configure the request
//     xhr.open("POST", "http://localhost:8080/designer/signup");
//     xhr.setRequestHeader("Content-Type", "application/json");

//     // Handle response
//     xhr.onload = function() {
//       if (xhr.status === 200) {
//         // Signup successful
//         // console.log(xhr.responseText);
//         document.getElementById("signupError").textContent = "Signup successful"; // Clear any previous error messages
//       } else {
//         // Signup failed
//         document.getElementById("signupError").textContent = "Signup failed. Please try again.";
//       }
//     };
//   });
// });
