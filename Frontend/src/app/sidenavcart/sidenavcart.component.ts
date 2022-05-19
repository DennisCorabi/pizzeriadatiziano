import {Component, Inject, OnInit} from '@angular/core';
import {OrderService} from "../order.service";
import {HttpClient} from "@angular/common/http";
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from "@angular/material/dialog";
import {OrderDialogComponent} from "../order-dialog/order-dialog.component";
import {Order} from "../Templates";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-sidenavcart',
  templateUrl: './sidenavcart.component.html',
  styleUrls: ['./sidenavcart.component.css']
})
export class SidenavcartComponent implements OnInit {

  constructor(public cart: OrderService, private http:HttpClient, private dialog: MatDialog, private _snackBar: MatSnackBar) { }
  order = this.cart.get();
  tracking_order = "";

  ngOnInit(): void {
  }

  openDialog(): void{
    const dialogRef = this.dialog.open(OrderDialogComponent)
  }


}
