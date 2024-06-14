import { SSEClient } from "./lib/sse-client.js"

window.addEventListener("load", () => {
    run();
    const mySSEClient = new SSEClient("localhost:8080");
    mySSEClient.connect();
})
