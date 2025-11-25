const BASE_URL = "http://localhost:8080/api/apod";

// Load Today's APOD
window.loadTodayApod = function () {
    axios.get(`${BASE_URL}/today`)
        .then(res => showApod(res.data))
        .catch(err => showError(err));
};

// Search by Date
window.searchByDate = function () {
    const date = document.getElementById("dateInput").value;

    if (!date) {
        alert("Please select a date!");
        return;
    }

    axios.get(`${BASE_URL}/date/${date}`)
        .then(res => showApod(res.data))
        .catch(err => showError(err));
};

// Render APOD
function showApod(data) {
    const container = document.getElementById("apod-container");

    container.innerHTML = `
        <h2>${data.title}</h2>
        <p class="apod-date">${data.date}</p>

        ${data.mediaType === "IMAGE"
            ? `<img src="${data.mediaUrl}" alt="${data.title}" />`
            : `<iframe src="${data.mediaUrl}" frameborder="0" allowfullscreen></iframe>`
        }

        <p class="explanation">${data.explanation}</p>
    `;
}

// Error handler
function showError(err) {
    document.getElementById("apod-container").innerHTML =
        `<p class="error">Error: ${err.message}</p>`;
}
