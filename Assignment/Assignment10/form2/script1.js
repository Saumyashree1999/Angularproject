document.getElementById('signupForm').addEventListener('submit', function(event) {
  event.preventDefault(); // Prevent form submission
  
  // Get the form input values
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

  
  
  // Create an object with the user data
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

        window.location.href = "landing1.html?name=" + encodeURIComponent(name);
      } else {
        // Signup failed
        document.getElementById('message').textContent = 'Signup failed!';
      }
    })
    .catch(function(error) {
      // Handle any errors that occurred during the request
      document.getElementById('message').textContent = 'Error: ' + error;
    });
});
