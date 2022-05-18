import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
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



}
