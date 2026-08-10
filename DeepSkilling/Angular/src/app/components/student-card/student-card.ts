import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-student-card',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './student-card.html',
  styleUrl: './student-card.css'
})
export class StudentCard {

  @Input()
  student!: {
    name: string;
    department: string;
    year: number;
    cgpa: number;
  };

  @Output()
viewProfile = new EventEmitter<string>();

showProfile() {

  this.viewProfile.emit(this.student.name);

}

}