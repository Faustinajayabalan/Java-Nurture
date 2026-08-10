import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'creditFormat',
  standalone: true
})
export class CreditFormat implements PipeTransform {

  transform(value: number): string {

    if (value === 1) {
      return value + ' Credit';
    }

    if (value === 0) {
      return 'No Credits';
    }

    return value + ' Credits';
  }

}