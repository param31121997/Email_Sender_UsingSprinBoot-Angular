import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {
constructor(private snack :MatSnackBar){

}

ngOnInit():void{

}

btnClick(){
  localStorage.setItem('token', JSON.stringify({'abc':'abc'}))
  console.log("btn Click");
  this.snack.open("hello welcome to this app", "Cancel")
  let token = localStorage.getItem('token');
  console.log(token)
}
}
