import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseService } from '../../services/course-service';

@Component({
  selector: 'app-posts',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './posts.html',
  styleUrl: './posts.css'
})
export class Posts implements OnInit {

  posts: any[] = [];

  constructor(private courseService: CourseService) {}

  ngOnInit(): void {

    this.courseService.getPosts().subscribe(data => {
      this.posts = data.slice(0, 5);
    });

  }

}