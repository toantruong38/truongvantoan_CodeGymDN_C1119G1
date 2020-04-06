import { ValidationErrors } from "@angular/forms";
import { AbstractControl } from "@angular/forms";

export class EmployeeIdValidator {
  // private static pattern = "^NV-[d]{4}$";

  static checkFormat(control: AbstractControl): ValidationErrors | null {
    if ((<string>control.value).match(/^NV-[\d]{4}$/)) return null;

    return { isNotMatchPattern: true };
  }
}
