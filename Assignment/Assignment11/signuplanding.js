var urlParams = new URLSearchParams(window.location.search);
var fullname = urlParams.get("fullname");

// Display the username on the page
document.write(fullname);