import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {pizze, Order, Pizza} from "./Templates";

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
    this.http.post('http://85.234.131.162:8080/api/v1/pizzeria', this.order)
      .subscribe((result) => {
        console.warn("result", result);
      })
  }


}
