import {
  Component,
  Input,
  Output,
  EventEmitter,
  OnChanges,
  SimpleChanges
} from '@angular/core';

import { Course } from '../../models/course.model';

@Component({
  selector: 'app-course-card',
  standalone: true,
  imports: [],
  templateUrl: './course-card.html',
  styleUrl: './course-card.css'
})
export class CourseCard implements OnChanges {

  @Input() course!: Course;

  @Output() enrollCourse = new EventEmitter<Course>();

  ngOnChanges(changes: SimpleChanges): void {

    console.log(
      'Previous Value :',
      changes['course']?.previousValue
    );

    console.log(
      'Current Value :',
      changes['course']?.currentValue
    );

  }

  enroll(): void {
    this.enrollCourse.emit(this.course);
  }

}