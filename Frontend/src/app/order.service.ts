import { Injectable } from '@angular/core';
import {Pizza} from "./Pizza";

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  ordine: Pizza[] = [];
  costo: number = 0;

  constructor() { }

  add(pizza: Pizza){
    this.ordine.push(pizza);
    console.log("Pizza inserita nel carrello. Pizza: "+pizza);
    this.updateCost();
  }

  get(): Pizza[]{
    return this.ordine;
  }

  updateCost(){
    this.costo=0;
    this.ordine.forEach((pizza)=> this.costo+=pizza.price)

  }
}
