// File: src/main/resources/static/js/availability.js

document.getElementById("availabilityForm").addEventListener("submit", function(event) {
    event.preventDefault();

    const bloodGroup = document.getElementById("bloodGroup").value;
    const city = document.getElementById("city").value;

    fetch(`/api/blood-availability?bloodGroup=${bloodGroup}&city=${city}`)
        .then(response => response.json())
        .then(data => {
            displayAvailabilityResults(data);
        })
        .catch(error => {
            console.error("Error fetching blood availability:", error);
        });
});

function displayAvailabilityResults(data) {
    const resultsDiv = document.getElementById("availabilityResults");
    resultsDiv.innerHTML = "";

    if (data.length === 0) {
        resultsDiv.innerHTML = "<p>No blood available for the specified criteria.</p>";
    } else {
        const list = document.createElement("ul");
        data.forEach(item => {
            const listItem = document.createElement("li");
            listItem.innerHTML = `<strong>Blood Group:</strong> ${item.bloodGroup}, <strong>City:</strong> ${item.city}`;
            list.appendChild(listItem);
        });
        resultsDiv.appendChild(list);
    }
}
