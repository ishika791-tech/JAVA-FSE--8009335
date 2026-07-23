import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';

import { Enrollment } from '../../services/enrollment';

@Component({
  selector: 'app-student-profile',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './student-profile.html',
  styleUrl: './student-profile.css'
})
export class StudentProfile implements OnInit {

  studentName = 'Ishika Chatterjee';
  studentEmail = 'ishika.papa.2003@gmail.com';

  enrolledCourses: any[] = [];

  constructor(private enrollmentService: Enrollment) {}

  ngOnInit(): void {
    this.enrolledCourses =
      this.enrollmentService.getEnrolledCourses();
  }

}