import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {CartService} from "../cart.service";
import { HttpClient } from "@angular/common/http";

@Component({
  selector: 'app-others-product',
  templateUrl: './others-product.component.html',
  styleUrls: ['./others-product.component.css']
})
export class OthersProductComponent implements OnInit {

  feeds;
  constructor(
      private route: ActivatedRoute,
      private cartService : CartService,
      private http : HttpClient
  ) { }


  ngOnInit() {
  }

  displayOtherProduct() {

    this.cartService.displayOtherProducts().subscribe(
        data => {
            //  console.log(data),
              this.feeds = data,
              err => console.error(err),
              () => console.log("done")
        }
    );

  }

}
