import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-enrollment-form',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule
  ],
  templateUrl: './enrollment-form.html',
  styleUrl: './enrollment-form.css'
})
export class EnrollmentForm {

  student = {
    name: '',
    email: '',
    course: '',
    semester: '',
    agree: false
  };

  onSubmit(form: any) {

  console.log(this.student);

  alert("Enrollment Successful!");

  this.student = {
    name: '',
    email: '',
    course: '',
    semester: '',
    agree: false
  };

  form.resetForm();

}

}