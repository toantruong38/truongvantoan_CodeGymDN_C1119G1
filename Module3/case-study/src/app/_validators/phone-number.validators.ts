import { ValidationErrors } from "@angular/forms";
import { AbstractControl } from "@angular/forms";

export class PhoneNumberValidator {
  // private static pattern = "^(090|091|(84)+9[01])([d]{7})$";
  static checkFormat(control: AbstractControl): ValidationErrors | null {
    if ((<string>control.value).match(/^(090|091|\(84\)\+9[01])([\d]{7})$/)) {
      return null;
    }
    return { isNotMatchPattern: true };
  }
}
