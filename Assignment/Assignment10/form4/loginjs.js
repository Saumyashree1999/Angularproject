document.getElementById('form').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent form submission
  
    // Get the form input values
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;
  
    // Create an object with the user credentials
    var userdata = {
      email: email,
      password: password
      
    };
  const allData=null;
    // Make an HTTP POST request to the login API endpoint
    fetch('http://localhost:8080/designer/Login', {
      method: 'POST',
      headers: {  
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(userdata)
    })
      .then(async function(response) {
        this.allData= await response.json();
        // Handle the response from the API
        console.log(response)
        if (response.status ==200) {
          // Login successful
          // document.getElementById('message').textContent = "Signin successful";
          // var mobilenumber= sessionStorage.setItem("mobilenumber",this.allData.mobilenumber);
          window.location.href = "loginlanding.html?name=" + encodeURIComponent(this.allData.name);
        } else if(response.status ==400) {
          // Login failed
          document.getElementById('message').textContent = "Signin failed";
        }
      })
      .catch(function(error) {
        // Handle any errors that occurred during the request
        document.getElementById('message').textContent = 'Error: ' + error;
      });
  });
  