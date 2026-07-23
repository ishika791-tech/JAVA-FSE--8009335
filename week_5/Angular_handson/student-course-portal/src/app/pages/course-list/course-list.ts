import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';

import { CourseCard } from '../../components/course-card/course-card';
import { CourseService } from '../../services/course';
import { Course } from '../../models/course.model';
import { Enrollment } from '../../services/enrollment';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [CommonModule, RouterLink, CourseCard],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css'
})
export class CourseList implements OnInit {

  isLoading = false;

  courses: Course[] = [];

  constructor(
    private courseService: CourseService,
    private enrollmentService: Enrollment
  ) {}

  ngOnInit(): void {
    this.courses = this.courseService.getCourses();
  }

  onEnroll(course: Course): void {

    if (this.enrollmentService.isEnrolled(course.id)) {

      this.enrollmentService.unenroll(course.id);

    } else {

      this.enrollmentService.enroll(course);

    }

  }

}