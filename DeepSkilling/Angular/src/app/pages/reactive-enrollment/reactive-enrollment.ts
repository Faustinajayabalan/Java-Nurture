import { Component } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  Validators,
  ReactiveFormsModule,
  FormArray
} from '@angular/forms';

import { CommonModule } from '@angular/common';

import { noCourseCode } from '../../validators/course-code-validator';
import { simulateEmailCheck } from '../../validators/email.validator';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-reactive-enrollment',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule
  ],
  templateUrl: './reactive-enrollment.html',
  styleUrl: './reactive-enrollment.css'
})
export class ReactiveEnrollment {

  enrollForm: FormGroup;

  constructor(private fb: FormBuilder) {

    this.enrollForm = this.fb.group({

      studentName: [
        '',
        [
          Validators.required,
          Validators.minLength(3)
        ]
      ],

      studentEmail: [
        '',
        [
          Validators.required,
          Validators.email
        ],
        [
          simulateEmailCheck
        ]
      ],

      courseId: [
        '',
        [
          Validators.required,
          noCourseCode
        ]
      ],

      preferredSemester: [
        'Odd',
        Validators.required
      ],

      agreeToTerms: [
        false,
        Validators.requiredTrue
      ],

      additionalCourses: this.fb.array([])

    });

  }

  get additionalCourses(): FormArray<FormControl<string | null>> {

  return this.enrollForm.get('additionalCourses') as FormArray<FormControl<string | null>>;

}

  addCourse(): void {

    this.additionalCourses.push(
      this.fb.control('', Validators.required)
    );

  }

  removeCourse(index: number): void {

    this.additionalCourses.removeAt(index);

  }

  onSubmit(): void {

    console.log("Form Value");
    console.log(this.enrollForm.value);

    // value excludes disabled controls
    // getRawValue includes disabled controls

    console.log("Raw Value");
    console.log(this.enrollForm.getRawValue());

    alert("Reactive Form Submitted!");

  }

}