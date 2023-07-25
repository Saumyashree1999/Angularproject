function validateName(fullname) {
    var regex = /^[a-zA-Z]{3,20}$/;
    return regex.test(fullname);
  }

  function validateEmail(email) {
    var regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    
    // Check if the email matches the regular expression
    if (regex.test(email)) {
      return true; // Valid email address
    } else {
      return false; // Invalid email address
    }
}

function validateMobileNumber(mobileno) {
    var regex = /^\d{10}$/;
    if (regex.test(mobileno)) {
      return true; 
    } else {
      return false; 
    }
}

function validatePassword(password) {
    // Regular expressions for password validation
    var regex = /^(?=.*\d)(?=.*[!@#$%^&*])(?=.*[A-Z])(?=.*[a-z])(?!.*\s).{6,9}$/;
    return regex.test(password);
  
}

document.getElementById('form').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent form submission
    
    // Get the form input values
    var fullname = document.getElementById('fullname').value;
    var email = document.getElementById('email').value;
    var mobileno = document.getElementById('mobileno').value;
    var password = document.getElementById('password').value;
    var confirmPassword = document.getElementById('password2').value;
    

    //name validation
    // if(validateName(fullname)){
    //   document.getElementById('nameError').textContent='username consist of 3 to 20 characters long.';
    //   return;
    // }

    //email validation
    if(email===""){
      document.getElementById("emailError").textContent ='Email cant be null';
      return;
    }
    if(!validateEmail(email)){
      document.getElementById("emailError").textContent ='Enter valid email';
      return;
    }

     //validate mobile number
     if(!validateMobileNumber(mobileno)){
        document.getElementById("mobileError").textContent ='Mobile no contains 10 digit.';
        return;
    }
    
    // Check if password and confirm password match
    if(!validatePassword(password)){
      document.getElementById("passwordError1").textContent ='Password length between 6 and 9 characters,At least one digit,At least one special character,At least one uppercase letter,At least one lowercase letter,No spaces';
      return;
    }
      if (password != confirmPassword) {
      document.getElementById("passwordError2").textContent ='Passwords do not match';
      return;
    }
    
   

    var userData = {
      fullname: fullname,
      email: email,
      mobileno: mobileno,
      password: password
      
    };

    // Make an HTTP POST request to the signup API endpoint
    fetch('http://localhost:8080/customer/signup', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(userData)
    })
      
    .then(function(response) {
        if (response.status ==200) {
          // Signup successful
          //document.getElementById('message').textContent = 'Signup successful!';
  
          window.location.href = "signuplanding.html?fullname=" + encodeURIComponent(fullname);
        } else {
          // Signup failed
          document.getElementById('message').textContent = 'Signup failed!';
        }
      })
      .catch(function(error) {
        // Handle any errors that occurred during the request
        document.getElementById('message').textContent = 'Error: ' + error;
      }
    );
  }
);  

