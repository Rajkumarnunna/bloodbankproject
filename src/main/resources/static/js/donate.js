// File: src/main/resources/static/js/donate.js

document.getElementById("donateForm").addEventListener("submit", function(event) {
    event.preventDefault();

    const formData = {
        donorName: document.getElementById("donorName").value,
        bloodGroup: document.getElementById("bloodGroup").value,
        city: document.getElementById("city").value,
    };

    fetch("/api/donate-blood", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(formData)
    })
    .then(response => response.json())
    .then(data => {
        alert("Thank you for your donation! Donation ID: " + data.donationId);
    })
    .catch(error => {
        console.error("Error during blood donation:", error);
        alert("Failed to submit blood donation. Please try again.");
    });
});
