import { Observer } from "../patterns/observer.js";

export class ViewMemory extends Observer
{
    #controllerMemory;

    constructor(controllerMemory)
    {
        super();

        this.#controllerMemory = controllerMemory;
        this.#controllerMemory.addObserver(this);
    }

    get controllerMemory(){
        return this.#controllerMemory;
    }

    notify()
    {
        this.displayCards();
    }

    displayCard(card){
        let cardElement = document.createElement("div");
        let cardCoverElement = document.createElement("div");
        cardElement.classList.add("card");

        cardElement.appendChild(cardCoverElement);
        document.querySelector(".cards").appendChild(cardElement);
    }

    displayCards(){
        document.querySelector(".cards").innerHTML = "";
        let cards = this.#controllerMemory.memory.cards;
        for (let card of cards){
            this.displayCard(card);
        }
        
    }
}