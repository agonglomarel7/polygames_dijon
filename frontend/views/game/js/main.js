import { ApplicationMemory} from "./application/application-memory.js"

window.addEventListener("load", () => {
    const app = new ApplicationMemory();
})

document.addEventListener('DOMContentLoaded', () => {
    const rulesButton = document.querySelector('.rules-button');
    const popup = document.getElementById('rules-popup');
    const closeButton = document.querySelector('.close-button');

    // Show the popup when the "Rules" button is clicked
    rulesButton.addEventListener('click', () => {
        popup.style.display = 'block';
    });

    // Hide the popup when the "close" button is clicked
    closeButton.addEventListener('click', () => {
        popup.style.display = 'none';
    });

    // Hide the popup when clicking outside of the popup content
    window.addEventListener('click', (event) => {
        if (event.target == popup) {
            popup.style.display = 'none';
        }
    });
});