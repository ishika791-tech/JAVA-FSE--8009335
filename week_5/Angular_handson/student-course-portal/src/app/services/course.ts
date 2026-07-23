import { Injectable } from '@angular/core';
import { Course } from '../models/course.model';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  private courses: Course[] = [

    {
      id:1,
      name:'Angular',
      code:'ANG101',
      credits:4,
      gradeStatus:'passed'
    },

    {
      id:2,
      name:'Java',
      code:'JAVA102',
      credits:3,
      gradeStatus:'pending'
    },

    {
      id:3,
      name:'Spring Boot',
      code:'SPR103',
      credits:4,
      gradeStatus:'passed'
    },

    {
      id:4,
      name:'Python',
      code:'PY104',
      credits:3,
      gradeStatus:'failed'
    },

    {
      id:5,
      name:'React',
      code:'RE105',
      credits:4,
      gradeStatus:'pending'
    }

  ];

  getCourses(){
    return this.courses;
  }

  getCourseById(id:number){
    return this.courses.find(c=>c.id===id);
  }

  addCourse(course:Course){
    this.courses.push(course);
  }

}