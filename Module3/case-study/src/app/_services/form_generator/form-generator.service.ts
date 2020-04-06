import { Injectable } from "@angular/core";
import {
  FormBuilder,
  FormGroup,
  Validators,
  FormControl
} from "@angular/forms";

@Injectable({
  providedIn: "root"
})
export class FormGeneratorService {
  constructor(private formBuilder: FormBuilder) {}

  generateForm(...formElements: FormElement[]): FormGroup {
    let formGroup = this.formBuilder.group(
      {},
      { validators: Validators.required }
    );
    formElements.map(fe => {
      if (fe.validators) {
        fe.validators.push(Validators.required);
      } else {
        fe.validators = new Array(Validators.required);
      }
      formGroup.addControl(
        fe.formControlName,
        new FormControl("", fe.validators)
      );
    });
    return formGroup;
  }
}

interface FormElement {
  formControlName: string;
  validators?: any[];
}
