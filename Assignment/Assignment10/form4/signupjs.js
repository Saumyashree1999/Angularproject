//name validation
// function validateName(name) {
//   // Regular expression to validate username
//   var regex = /^[a-zA-Z0-9]{3,20}$/;
//   return regex.test(name);
// }
// $-symbols ensure that the entered input matches the pattern
function validateName(name) {
  var regex = /^(?=(?:\S*\s?){0,2}\S*$).{3,20}$/;
  return regex.test(name);
}

//email validation

// ^[^\s@]+ matches one or more characters that are not whitespace or '@' at the beginning of the string.
// @[^\s@]+ matches the '@' symbol followed by one or more characters that are not whitespace or '@'.
// \.[^\s@]+$ matches a dot '.' followed by one or more characters that are not whitespace or '@' at the end of the string.


function validateEmail(email) {
    var regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    
    // Check if the email matches the regular expression
    if (regex.test(email)) {
      return true; // Valid email address
    } else {
      return false; // Invalid email address
    }
}

//mobile number validation

function validateMobileNumber(mobilenumber) {
    var regex = /^[789]\d{9}$/;
    if (regex.test(mobilenumber)) {
      return true; 
    } else {
      return false; 
    }
}

function validatePinCode(pincode) {
    // Regular expression to validate a 6-digit PIN code consisting of numbers only
    var regex = /^\d{6,9}$/;
    
    if (regex.test(pincode)) {
      return true; // Valid PIN code
    } else {
      return false; // Invalid PIN code
    }
}

//password validation

// (?=.*\d) requires at least one digit.
// (?=.*[!@#$%^&*]) requires at least one special character.
// (?=.*[a-z]) requires at least one lowercase letter.
// (?=.*[A-Z]) requires at least one uppercase letter.
// .{6,9} ensures the length is between 6 and 9 characters.
//  (?!.*\s) no space

function validatePassword(password) {
  // Regular expressions for password validation
  var regex = /^(?=.*\d)(?=.*[!@#$%^&*])(?=.*[A-Z])(?=.*[a-z])(?!.*\s).{6,9}$/;
  return regex.test(password);

}

document.getElementById('form').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent form submission
    
    // Get the form input values
    var name = document.getElementById('name').value;
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;
    var confirmPassword = document.getElementById('password2').value;
    var mobilenumber = document.getElementById('mobilenumber').value;
    var addressline1 = document.getElementById('addressline1').value;
    var addressline2 = document.getElementById('addressline2').value;
    var landmark = document.getElementById('landmark').value;
    var city = document.getElementById('city').value;
    var state = document.getElementById('state').value;
    var country = document.getElementById('country').value;
    var pincode = document.getElementById('pincode').value;

    //name validation
    if(validateName(name)){
      document.getElementById('nameError').textContent='username to consist of alphanumeric characters (a-z, A-Z, 0-9), and requires the username to be between 3 and 20 characters long.';
      return;
    }

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
      if (password !== confirmPassword) {
      document.getElementById("passwordError2").textContent ='Passwords do not match';
      return;
    }
    
    //validate mobile number
    if(!validateMobileNumber(mobilenumber)){
      document.getElementById("mobileError").textContent ='Enter valid mobile number';
      return;
    }

    if(addressline1===""){
      document.getElementById("addressline1Error").textContent ='Enter valid Address';
      return;
    }

    if(addressline2===""){
      document.getElementById("addressline2Error").textContent ='Enter valid Address';
      return;
    }

    if(city===""){
      document.getElementById("cityError").textContent ='Enter valid City';
      return;
    }

    if(state===""){
      document.getElementById("stateError").textContent ='Enter valid State';
      return;
    }

    
    if(country===""){
      document.getElementById("countryError").textContent ='Enter valid Country';
      return;
    }

    if(!validatePinCode(pincode)){
      document.getElementById("pincodeError").textContent ='Enter valid Pincode';
      return;
    }

    var userData = {
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

    // Make an HTTP POST request to the signup API endpoint
    fetch('http://localhost:8080/designer/signup', {
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
  
          window.location.href = "signuplanding.html?name=" + encodeURIComponent(name);
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