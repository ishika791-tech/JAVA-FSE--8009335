import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-course-detail',
  standalone: true,
  imports: [],
  templateUrl: './course-detail.html',
  styleUrl: './course-detail.css'
})
export class CourseDetail implements OnInit {

  courseId: string | null = '';
  semester: string | null = '';

  constructor(private route: ActivatedRoute) {}

  ngOnInit(): void {

    this.courseId = this.route.snapshot.paramMap.get('id');

    this.route.queryParamMap.subscribe(params => {
      this.semester = params.get('semester');
    });

  }

}