function validateEmail(email) {
    var regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    
    // Check if the email matches the regular expression
    if (regex.test(email)) {
      return true; // Valid email address
    } else {
      return false; // Invalid email address
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
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;
    var confirmPassword = document.getElementById('password2').value;
    
    //email validation
    if(email===""){
        document.getElementById("emailError").textContent ='Email cant be null';
        return;
      }
      if(!validateEmail(email)){
        document.getElementById("emailError").textContent ='Enter valid email';
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
    
    // Create an object with the user credentials
    var userdata = {
      email: email,
      password: password
      
    };
    const allData=null;
    // Make an HTTP POST request to the login API endpoint
    fetch('http://localhost:8080/customer/login', {
      method: 'POST',
      headers: {  
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(userdata)
    })
      .then(async function(response) {
        // this.allData=await response.json();
        // Handle the response from the API
        // console.log(response)
        if (response.status ==200) {
          // Login successful
          // document.getElementById('message').textContent = "Signin successful";
          // var mobilenumber= sessionStorage.setItem("mobilenumber",this.allData.mobilenumber);
          // window.location.href = "loginlanding.html?fullname=" + encodeURIComponent(this.allData.fullname);
           alert('Login Successful');
        } else if(response.status ==400) {
          // Login failed
          // document.getElementById('message').textContent = "Signin failed";
          alert('Login Failed')
        }
      })
      .catch(function(error) {
        // Handle any errors that occurred during the request
        document.getElementById('message').textContent = 'Error: ' + error;
      });
  });
  