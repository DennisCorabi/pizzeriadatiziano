import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators} from '@angular/forms';
import {STEPPER_GLOBAL_OPTIONS} from '@angular/cdk/stepper';
import {OrderService} from "../order.service";
import {cities} from "../Templates"
import codes from "../../assets/CountryCodes.json";
import UScities from "../../assets/US_States_and_Cities.json";
import {OrderDialogComponent} from "../order-dialog/order-dialog.component";
import {SidenavcartComponent} from "../sidenavcart/sidenavcart.component";


@Component({
  selector: 'app-stepper',
  templateUrl: './stepper.component.html',
  styleUrls: ['./stepper.component.css'],
  providers: [
    {
      provide: STEPPER_GLOBAL_OPTIONS,
      useValue: {showError: true},
    },
  ],
})
export class StepperComponent implements OnInit {

  firstFormGroup: any;
  secondFormGroup: any;
  thirdFormGroup: any;
  fourthFormGroup: any;


  cities: String[] =  cities;
  codes = codes;
  isLinear = true;

  constructor(private _formBuilder: FormBuilder, public cart: OrderService, public dialog: OrderDialogComponent) {
  }

  ngOnInit() {

    this.firstFormGroup = this._formBuilder.group({
      firstCtrl: ['', Validators.required],
    });
    this.secondFormGroup = this._formBuilder.group({
      secondCtrl: ['', Validators.required],
    });
    this.thirdFormGroup = this._formBuilder.group({
      thirdCtrl: ['', Validators.required],
    });

    this.fourthFormGroup = this._formBuilder.group({
    })
  }

  submit(){
    this.cart.submit();
    this.dialog.onNoClick();
  }

}
