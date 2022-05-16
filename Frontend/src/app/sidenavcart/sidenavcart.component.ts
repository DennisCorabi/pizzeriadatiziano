import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sidenavcart',
  templateUrl: './sidenavcart.component.html',
  styleUrls: ['./sidenavcart.component.css']
})
export class SidenavcartComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  events: string[] = [];
  opened: boolean = false;

}
