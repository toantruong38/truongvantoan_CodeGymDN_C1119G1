import { AbstractControl, ValidationErrors } from "@angular/forms";

export class ClientIdValidator {
  // static pattern = "^KH-[d]{4}$";
  static checkFormat(control: AbstractControl): ValidationErrors | null {
    if ((<string>control.value).match(/^KH-[\d]{4}$/)) {
      return null;
    }
    return { isNotMatchPattern: true };
  }
}
