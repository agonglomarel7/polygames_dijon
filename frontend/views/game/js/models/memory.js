import { Card } from './card.js';

export class Memory{
    #cards;


    constructor(){
        this.#cards = [];

    }

    get cards(){
        return this.#cards;
    }

    newGame(pairsNumber){
        this.#cards = [];
        for( let i = 0; i < pairsNumber; i++){
            this.cards.splice(Math.floor(Math.random() * this.getCardsNumber()), 0, new Card());
        }
    }

    getCardsNumber(){
        return this.cards.length;
    }

    getCard(index){
        return this.cards[index];
    }

    toData(){
        return { cards: this.cards.map(card => card.toData()) };
    }

    fromData(data){
        this.#cards = data.cards.map(cardData => new Card(cardData.value, cardData.faceHidden));
    }

    showCard(index){
        let card = this.cards[index];
        if(card.faceHidden){
            card.show();
            return card;
        }
        return null;
    }
}