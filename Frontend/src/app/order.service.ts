import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {Order, Pizza} from "./Templates";
import {catchError, retry, throwError} from "rxjs";
import {MatSnackBar} from "@angular/material/snack-bar";

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  order = new Order();

  url: string = "http://pizzeriadatiano.it:8080/api/v1/pizzeria/";

  constructor(private http:HttpClient, private _snackBar: MatSnackBar) { }

  add(pizza: Pizza){
    this.order.order.push(pizza);
    this.updateCost();
  }

  get(): Pizza[]{
    return this.order.order;
  }

  updateCost(){
    this.order.price=0;
    this.order.order.forEach((pizza)=> this.order.price+=pizza.price)
  }

  submit(){
    console.log(this.order);
      this.http.post(this.url, this.order, {responseType: "json", observe:"response"})
        .subscribe((result) => {
          console.log(result);
        })

    this.order = new Order()
  }

  track(id: string) {
    if (id=="") return;
    this.http.get<Order>(this.url+id, {observe: "response"})
      .pipe(
        retry(3),
      )
      .subscribe((result) => {
        console.log(result);
      })
  }

  getAddress(){
    return this.order.location.address + " "+this.order.location.nOfAddress + ", "+this.order.location.city;
  }

}
