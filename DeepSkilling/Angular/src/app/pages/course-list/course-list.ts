import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseCard } from '../../components/course-card/course-card';
import { CourseService } from '../../services/course-service';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [
    CommonModule,
    CourseCard
  ],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css'
})
export class CourseList implements OnInit {

  isLoading = false;

  selectedCourseId = 0;

  courses: any[] = [];

  constructor(private courseService: CourseService) { }
  
  ngOnInit(): void {

    this.courses = this.courseService.getCourses();
    console.log(this.courseService.getCourseById(3));

  setTimeout(() => {
    this.isLoading = false;
  }, 1500);

}

  onEnroll(id: number): void {
    console.log('Enrolling in Course:', id);
    this.selectedCourseId = id;
  }

  trackByCourseId(index: number, course: any): number {
    return course.id;
  }

}