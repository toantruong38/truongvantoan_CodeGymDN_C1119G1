import { ValidationErrors } from "@angular/forms";
import { AbstractControl } from "@angular/forms";

export class EmailValidator {
  // private static pattern = "^[a-z]{1,}[w]{5,13}@[w]{3,7}.[a-z]{3,5}$";
  static checkFormat(control: AbstractControl): ValidationErrors | null {
    if (
      (<string>control.value).match(
        /^[a-z]{1,}[\w]{5,13}@[\w]{3,7}.[a-z]{3,5}$/
      )
    ) {
      return null;
    }
    return { isNotMatchPattern: true };
  }
}
