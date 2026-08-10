import { Routes } from '@angular/router';

import { Home } from './pages/home/home';
import { CourseList } from './pages/course-list/course-list';
import { StudentProfile } from './pages/student-profile/student-profile';
import { EnrollmentForm } from './pages/enrollment-form/enrollment-form';
import { ReactiveEnrollment } from './pages/reactive-enrollment/reactive-enrollment';
import { authGuard } from './guards/auth-guard';
import { CourseDetails } from './pages/course-details/course-details';

export const routes: Routes = [

  {
    path: '',
    component: Home
  },

  {
    path: 'courses',
      component: CourseList,
    canActivate: [authGuard]
  },

  {
    path: 'profile',
    component: StudentProfile
  },

  {
    path: 'enrollment',
    component: EnrollmentForm
  },

  {
    path: 'reactive',
      component: ReactiveEnrollment,
    canActivate: [authGuard]
    },
  {
  path: 'courses/:id',
  component: CourseDetails
}

];