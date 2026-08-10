import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  constructor(private http: HttpClient) { }
  private courses = [

    {
      id: 1,
      name: 'Angular',
      code: 'ANG101',
      credits: 4,
      gradeStatus: 'passed'
    },

    {
      id: 2,
      name: 'Java',
      code: 'JAVA201',
      credits: 3,
      gradeStatus: 'passed'
    },

    {
      id: 3,
      name: 'Spring Boot',
      code: 'SPR301',
      credits: 4,
      gradeStatus: 'passed'
    },

    {
      id: 4,
      name: 'Microservices',
      code: 'MIC401',
      credits: 5,
      gradeStatus: 'failed'
    },

    {
      id: 5,
      name: 'Cyber Security',
      code: 'CYB501',
      credits: 4,
      gradeStatus: 'pending'
    }

  ];

  getCourses() {
    return this.courses;
  }

  getCourseById(id: number) {
    return this.courses.find(course => course.id === id);
  }
    
  getPosts() {
  return this.http.get<any[]>(
    'https://jsonplaceholder.typicode.com/posts'
  );

}

}