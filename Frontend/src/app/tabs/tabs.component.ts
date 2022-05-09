import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-tabs',
  templateUrl: './tabs.component.html',
  styleUrls: ['./tabs.component.css']
})
export class TabsComponent implements OnInit {

  typesOfPizzaClassic: string[] = ['Diavola', 'Margherita', 'Marinara', 'Napoletana', 'Americana'];

  typesOfPizzaSpecial: string[] = ['Ananas', 'Clogs', 'Loafers', 'Moccasins', 'Sneakers'];

  typesOfSandwiches: string[] = ['Kebab', 'Clogs', 'Loafers', 'Moccasins', 'Sneakers'];

  constructor() { }

  ngOnInit(): void {
  }


}
