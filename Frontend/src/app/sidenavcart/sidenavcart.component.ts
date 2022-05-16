import { Component, OnInit } from '@angular/core';
import {OrderService} from "../order.service";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-sidenavcart',
  templateUrl: './sidenavcart.component.html',
  styleUrls: ['./sidenavcart.component.css']
})
export class SidenavcartComponent implements OnInit {

  constructor(public cart: OrderService, private http:HttpClient) { }
  order = this.cart.get();
  tracking_order = "";

  submit(){
    this.cart.submit();
  }

  ngOnInit(): void {
  }

  track(){
    console.log();
    this.http.get('http://139.162.139.29:8080/api/v1/pizzeria/'+this.tracking_order)
      .subscribe((result) => {
        console.warn("result", result);
        console.log(result);
      })
  }

  events: string[] = [];
  opened: boolean = false;

}
