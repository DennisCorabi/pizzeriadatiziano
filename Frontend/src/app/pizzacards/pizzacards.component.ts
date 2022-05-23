import { Component, OnInit } from '@angular/core';
import {pizze, Pizza} from "../Templates";
import {OrderService} from "../order.service";
import {MatSnackBar} from "@angular/material/snack-bar";
import {NotificationService} from "../notification.service";

@Component({
  selector: 'app-pizzacards',
  templateUrl: './pizzacards.component.html',
  styleUrls: ['./pizzacards.component.css']
})
export class PizzacardsComponent implements OnInit {
  pizze: Pizza[] = pizze;

  constructor(private cart: OrderService, private notification: NotificationService) { }


  add(pizza: Pizza){
    this.notification.open("La pizza "+pizza.name+" è stata aggiunta al carrello.", 2);
    this.cart.add(pizza);
  }

  ngOnInit(): void {
  }

}
