// document.addEventListener("DOMContentLoaded", function() {
//     // Retrieve the form data from localStorage
//     var storedData = localStorage.getItem("formData");
//     var formData = JSON.parse(storedData);
  
//     // Display the form data on the target page
//     var outputElement = document.getElementById("output");
//     outputElement.textContent = JSON.stringify(formData);
//   });

var urlParams = new URLSearchParams(window.location.search);
var name = urlParams.get("name");

// Display the username on the page
document.write(name);