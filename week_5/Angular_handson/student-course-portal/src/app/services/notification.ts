import { Injectable } from '@angular/core';

@Injectable()

export class NotificationService {

message="";

show(msg:string){

this.message=msg;

console.log(msg);

}

}