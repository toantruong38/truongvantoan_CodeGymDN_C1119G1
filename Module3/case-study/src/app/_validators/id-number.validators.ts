import { AbstractControl } from "@angular/forms";
import { ValidationErrors } from "@angular/forms";

export class IdNumberValidator {
  // private static pattern = "^[d]{9}$";
  static checkFormat(control: AbstractControl): ValidationErrors | null {
    if ((<string>control.value).match(/^[\d]{9}$/)) {
      return null;
    }
    return { isNotMatchPattern: true };
  }
}
