import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";

//To define a class as a service in Angular, use the @Injectable() decorator to provide the metadata that allows Angular
// to inject it into a component as a dependency
@Injectable({
    providedIn: "root"
})

export class CartService {

    items = [];

    constructor(
        private http : HttpClient
    ){}

    addToCard(product) {
        this.items.push(product);
    }

    getItems() {
        return this.items;
    }

    clearCart() {
        this.items = [];
        return this.items;
    }

    getShippingPrices() {
        return this.http.get ('/assets/shipping.json');
    }

    displayOtherProducts() {
        return this.http.get('http://164.132.226.137:1441/feed');
    }

}