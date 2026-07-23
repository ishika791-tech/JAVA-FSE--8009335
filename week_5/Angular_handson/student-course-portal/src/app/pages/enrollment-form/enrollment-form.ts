import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { Notification } from '../../components/notification/notification';

@Component({
  selector: 'app-enrollment-form',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    Notification
  ],
  templateUrl: './enrollment-form.html',
  styleUrl: './enrollment-form.css'
})
export class EnrollmentFormComponent {

  notificationMessage = '';

  student = {
    name: '',
    email: '',
    course: ''
  };

  onSubmit(form: any) {

    if (form.valid) {

      this.notificationMessage = 'Enrollment Successful!';

      console.log(this.student);

      form.reset();

    }

  }

}