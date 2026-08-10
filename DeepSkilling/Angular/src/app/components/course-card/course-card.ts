import {
  Component,
  Input,
  Output,
  EventEmitter,
  OnChanges,
  SimpleChanges
} from '@angular/core';

import { CommonModule } from '@angular/common';
import { Highlight } from '../../directives/highlight';
import { CreditFormat } from '../../pipes/credit-format-pipe';

@Component({
  selector: 'app-course-card',
  standalone: true,
  imports: [CommonModule, Highlight, CreditFormat],
  templateUrl: './course-card.html',
  styleUrl: './course-card.css'
})
export class CourseCard implements OnChanges {

  @Input()
  course!: {
    id: number;
    name: string;
    code: string;
    credits: number;
    gradeStatus: string;
  };

  @Output()
  enrollRequested = new EventEmitter<number>();

  enrolled = false;

  isExpanded = false;

  ngOnChanges(changes: SimpleChanges): void {
    console.log(changes);
  }

  enroll(): void {
    this.enrolled = true;
    this.enrollRequested.emit(this.course.id);
  }

  toggleDetails(): void {
    this.isExpanded = !this.isExpanded;
  }

  get cardClasses() {
    return {
      'card--enrolled': this.enrolled,
      'card--full': this.course.credits >= 4,
      'expanded': this.isExpanded
    };
  }

}