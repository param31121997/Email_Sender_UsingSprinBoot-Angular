import { Component } from '@angular/core';
import { error, log } from 'console';
import { EmailService } from '../../service/email.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-email',
  templateUrl: './email.component.html',
  styleUrl: './email.component.css'
})
export class EmailComponent {

  data={
    to:"",
    subject:"",
    message:""
  };
  flag:boolean=false;
 
  constructor(private emailService:EmailService, private snack :MatSnackBar){

  }
  doSubmitForm(){

    if(this.data.to=='' || this.data.subject ==""|| this.data.message==""){
        this.snack.open("fields can not be empty.. ", "OK");
        return;
    }
    this.flag= true;
    console.log("try to submit form")
    this.emailService.sendEmail(this.data).subscribe(
      response=> {
     console.log(response);
     this.flag = false;
     this.snack.open("Send Success..", "OK");
      },error =>{
        console.log(error);
        this.flag = false;
        this.snack.open("Error..", "OK");
      }
    )
  }
}
