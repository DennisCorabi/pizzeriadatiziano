import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Order } from "../Order";
import {OrderService} from "../order.service";

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {


  ngOnInit(): void {
  }


  constructor(private http:HttpClient, public cart: OrderService) {}

  /*
  onSubmit() {



    console.log(this.order);
    this.http.post('http://139.162.139.29:8080/api/v1/pizzeria', this.order)
    .subscribe((result) => {
      console.warn("result", result);
    })
  }

   */

}
