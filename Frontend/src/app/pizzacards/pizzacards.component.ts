import { Component, OnInit } from '@angular/core';
import {pizze, Pizza} from "../Templates";
import {OrderService} from "../order.service";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-pizzacards',
  templateUrl: './pizzacards.component.html',
  styleUrls: ['./pizzacards.component.css']
})
export class PizzacardsComponent implements OnInit {
  pizze: Pizza[] = pizze;

  constructor(private cart: OrderService, private _snackbar: MatSnackBar) { }


  add(pizza: Pizza){
    this._snackbar.open("La pizza "+pizza.name+" è stata aggiunta", "Chiudi", {
      duration: 2000,
    });
    this.cart.add(pizza);
  }

  ngOnInit(): void {
  }

}
