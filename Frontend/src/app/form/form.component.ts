import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  ngOnInit(): void {
  }

  constructor(private http:HttpClient) {}

  onSubmit(data: any) {
    this.http.post('http://139.162.139.29:8080/api/v1/pizzeria', data)
    .subscribe((result) => {
      console.warn("result", result);
    })
    console.warn(data);
  }

}
