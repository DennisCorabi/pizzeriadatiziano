import { Injectable } from '@angular/core';
import {Pizza, pizze} from "./Pizza";
import { Order } from "./Order";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class OrderService {



  order: Order = {
    name: "",
    surname:"",
    phone:"",
    address:"",
    pizze: [],
    price: 0,
  }

  constructor(private http:HttpClient) { }

  add(pizza: Pizza){
    this.order.pizze.push(pizza);
    this.updateCost();
  }

  get(): Pizza[]{
    return this.order.pizze;
  }

  updateCost(){
    this.order.price=0;
    this.order.pizze.forEach((pizza)=> this.order.price+=pizza.price)
  }

  submit(){
    console.log(this.order);
    this.http.post('http://139.162.139.29:8080/api/v1/pizzeria', this.order)
      .subscribe((result) => {
        console.warn("result", result);
      })
  }


}
