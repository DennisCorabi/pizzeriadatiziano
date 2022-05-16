import { Component, OnInit } from '@angular/core';
import {OrderService} from "../order.service";

@Component({
  selector: 'app-sidenavcart',
  templateUrl: './sidenavcart.component.html',
  styleUrls: ['./sidenavcart.component.css']
})
export class SidenavcartComponent implements OnInit {

  constructor(public cart: OrderService) { }
  order = this.cart.get();
  costo = this.cart.costo;

  ngOnInit(): void {
  }

  events: string[] = [];
  opened: boolean = false;

}
