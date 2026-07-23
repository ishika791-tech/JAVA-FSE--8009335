import { Injectable } from '@angular/core';
import { Course } from '../models/course.model';

@Injectable({
  providedIn: 'root'
})
export class Enrollment {

  private enrolledCourses: Course[] = [];

  enroll(course: Course): void {

    if (!this.isEnrolled(course.id)) {
      this.enrolledCourses.push(course);
      console.log('Enrolled:', course);
    }

  }

  getEnrolledCourses(): Course[] {
    return this.enrolledCourses;
  }

  getEnrollmentCount(): number {
    return this.enrolledCourses.length;
  }

  isEnrolled(courseId: number): boolean {

    return this.enrolledCourses.some(
      course => course.id === courseId
    );

  }

  unenroll(courseId: number): void {

    this.enrolledCourses =
      this.enrolledCourses.filter(
        course => course.id !== courseId
      );

    console.log('Unenrolled:', courseId);

  }

}