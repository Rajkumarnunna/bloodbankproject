// File: src/main/resources/static/js/register.js

document.getElementById("registrationForm").addEventListener("submit", function(event) {
    event.preventDefault();

    const formData = {
        firstName: document.getElementById("firstName").value,
        lastName: document.getElementById("lastName").value,
        bloodGroup: document.getElementById("bloodGroup").value,
        city: document.getElementById("city").value,
    };

    fetch("/api/register", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(formData)
    })
    .then(response => response.json())
    .then(data => {
        alert("Registration successful! Your user ID is: " + data.userId);
    })
    .catch(error => {
        console.error("Error during registration:", error);
        alert("Registration failed. Please try again.");
    });
});
