import { Component, OnInit } from '@angular/core';
import {pizze, Pizza} from "../Templates";
import {OrderService} from "../order.service";

@Component({
  selector: 'app-pizzacards',
  templateUrl: './pizzacards.component.html',
  styleUrls: ['./pizzacards.component.css']
})
export class PizzacardsComponent implements OnInit {
  pizze: Pizza[] = pizze;

  constructor(private cart: OrderService) { }


  add(pizza: Pizza){
    this.cart.add(pizza);
  }

  ngOnInit(): void {
  }

}
