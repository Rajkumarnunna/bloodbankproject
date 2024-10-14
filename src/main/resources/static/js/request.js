// File: src/main/resources/static/js/request.js

document.getElementById("requestForm").addEventListener("submit", function(event) {
    event.preventDefault();

    const formData = {
        patientName: document.getElementById("patientName").value,
        requiredBloodGroup: document.getElementById("requiredBloodGroup").value,
        city: document.getElementById("city").value,
        doctorName: document.getElementById("doctorName").value,
        hospitalAddress: document.getElementById("hospitalAddress").value,
        whenRequired: document.getElementById("whenRequired").value,
        contactName: document.getElementById("contactName").value,
        contactNumber: document.getElementById("contactNumber").value,
        contactEmail: document.getElementById("contactEmail").value,
        message: document.getElementById("message").value,
    };

    fetch("/api/request-blood", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(formData)
    })
    .then(response => response.json())
    .then(data => {
        alert("Blood request submitted successfully! Request ID: " + data.requestId);
    })
    .catch(error => {
        console.error("Error during blood request:", error);
        alert("Failed to submit blood request. Please try again.");
    });
});
