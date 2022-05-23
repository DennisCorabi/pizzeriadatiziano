import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {Order, Pizza} from "./Templates";
import {catchError, retry, throwError} from "rxjs";
import {NotificationService} from "./notification.service";

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  order = new Order();
  tracked_order: any

  url: string = "http://pizzeriadatiziano.it:8080/api/v1/pizzeria/";

  constructor(private http:HttpClient, private notification: NotificationService) { }

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
      this.http.post(this.url, this.order, {responseType: "text", observe:"response"})
        .pipe(
          catchError(this.handleError)
        )
        .subscribe((result) => this.notification.open("Ordine effettuato. Codice: "+result.body, 3));
    this.order = new Order()
  }

  track(id: string) {
    if (id=="") return;
    this.http.get<Order>(this.url+id, {observe: "response"})
      .pipe(
        retry(3),
      )
      .subscribe((result) => {
        console.log(result.body);
        this.tracked_order=result.body
      })
  }

  getAddress(){
    return this.order.location.address + " "+this.order.location.nOfAddress + ", "+this.order.location.city;
  }

  private handleError(error: HttpErrorResponse){
    if (error.status === 0) {
      this.notification.open("Errore client-side (Errore: "+error.status+"), riprovare." , 5);
    } else {
      this.notification.open("Errore server-side (Errore: "+error.status+"), riprovare." , 5);
    }
    return throwError(() => new Error("Errore"));
  }

}
