import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  ReactiveFormsModule,
  FormBuilder,
  FormGroup,
  FormArray,
  Validators,
  AbstractControl,
  ValidationErrors,
  AsyncValidatorFn
} from '@angular/forms';

@Component({
  selector: 'app-reactive-enrollment-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './reactive-enrollment-form.html',
  styleUrl: './reactive-enrollment-form.css'
})
export class ReactiveEnrollmentForm {

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

      studentEmail: this.fb.control(
        '',
        [Validators.required, Validators.email],
        [this.simulateEmailCheck()]
      ),

      courseId: [
        '',
        [
          Validators.required,
          this.noCourseCode
        ]
      ],

      preferredSemester: ['Odd'],

      agreeToTerms: [false, Validators.requiredTrue],

      additionalCourses: this.fb.array([])

    });

  }

  noCourseCode(control: AbstractControl): ValidationErrors | null {

    if (control.value === '' || control.value === 'Select Course') {
      return { noCourseCode: true };
    }

    return null;

  }

  simulateEmailCheck(): AsyncValidatorFn {

    return (control: AbstractControl) => {

      return new Promise<ValidationErrors | null>(resolve => {

        setTimeout(() => {

          if (control.value === 'taken@email.com') {
            resolve({ emailTaken: true });
          } else {
            resolve(null);
          }

        }, 800);

      });

    };

  }

  get additionalCourses(): FormArray<any> {
    return this.enrollForm.get('additionalCourses') as FormArray<any>;
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

    if (this.enrollForm.valid) {

      alert('Reactive Enrollment Successful!');

      console.log(this.enrollForm.value);

    } else {

      this.enrollForm.markAllAsTouched();

    }

  }

}