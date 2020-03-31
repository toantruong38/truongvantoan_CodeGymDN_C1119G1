import { Component, OnInit} from "@angular/core";
import { CartService } from "../cart.service";
import { FormBuilder } from "@angular/forms";

@Component({
    selector : 'app-cart',
    templateUrl : './cart.component.html',
    styleUrls : ['./cart.component.css']
})

export class CartComponent {

    items;
    checkoutFrom;

    constructor(
        private cartService: CartService,
        private formBuilder: FormBuilder
    ) {
        this.items = this.cartService.getItems();
        this.checkoutFrom = this.formBuilder.group({
            name : '',
            address : ''
        });

    }

    onSubmit(customerData) {

        console.warn('your order has been submitted', customerData);
        this.items = this.cartService.clearCart();
        this.checkoutFrom.reset();

    }


}