import { FormGeneratorService } from "./../../_services/form_generator/form-generator.service";
import { EmailValidator } from "./../../_validators/email.validators";
import { DateTimeValidator } from "./../../_validators/date-time.validators";
import { IdNumberValidator } from "./../../_validators/id-number.validators";
import { PhoneNumberValidator } from "./../../_validators/phone-number.validators";
import { ClientIdValidator } from "./../../_validators/client-id.validators";
import { Component, OnInit } from "@angular/core";
import { FormGroup } from "@angular/forms";
import * as $ from "jquery";

@Component({
  selector: "app-new-client-form",
  templateUrl: "./new-client-form.component.html",
  styleUrls: ["./new-client-form.component.css"],
})
export class NewClientFormComponent implements OnInit {
  clientForm: FormGroup;
  constructor(private formGeneratorService: FormGeneratorService) {}

  ngOnInit(): void {
    this.initiateClientForm();

    // -> jquery' s space
    $(document).ready(() => {
      const birthInput = $("#birth");
      birthInput.blur(() => {
        let oldBirth = (<string>birthInput.value).split("-");
        birthInput.value = oldBirth.reverse().join("-");
      });
    });
  }
  get clientId() {
    return this.clientForm.get("clientId");
  }

  get fullName() {
    return this.clientForm.get("fullName");
  }

  get email() {
    return this.clientForm.get("email");
  }

  get phoneNumber() {
    return this.clientForm.get("phoneNumber");
  }

  get idNumber() {
    return this.clientForm.get("idNumber");
  }

  get birth() {
    return this.clientForm.get("birth");
  }

  get address() {
    return this.clientForm.get("address");
  }

  get gender() {
    return this.clientForm.get("gender");
  }

  initiateClientForm() {
    this.clientForm = this.formGeneratorService.generateForm(
      {
        formControlName: "clientId",
        validators: [ClientIdValidator.checkFormat],
      },
      { formControlName: "fullName" },
      { formControlName: "birth", validators: [DateTimeValidator.checkFormat] },
      { formControlName: "gender" },
      { formControlName: "email", validators: [EmailValidator.checkFormat] },
      {
        formControlName: "phoneNumber",
        validators: [PhoneNumberValidator.checkFormat],
      },
      {
        formControlName: "idNumber",
        validators: [IdNumberValidator.checkFormat],
      },
      { formControlName: "address" }
    );
    // console.log("eyyyy", this.clientForm);
  }
}
