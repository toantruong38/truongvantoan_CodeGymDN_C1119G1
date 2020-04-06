import { ValidationErrors } from "@angular/forms";
import { AbstractControl } from "@angular/forms";

export class DateTimeValidator {
  // private static pattern =
  //   "^(((0[1-9])|(1[0-9])|(2[0-9]))/(0[1-9]|1[0-2]))|3((1/(0[13578]|1[02]))|(0/(0[469]|11)))$";

  static checkFormat(control: AbstractControl): ValidationErrors | null {
    if (
      (<string>control.value).match(
        /^(((0[1-9])|(1[0-9])|(2[0-9]))\/(0[1-9]|1[0-2]))|3((1\/(0[13578]|1[02]))|(0\/(0[469]|11)))$/
      )
    )
      return null;

    return { isNotMatchPattern: true };
  }
}
