import { PhoneNumberValidator } from "./../../_validators/phone-number.validators";
import { IdNumberValidator } from "./../../_validators/id-number.validators";
import { EmailValidator } from "./../../_validators/email.validators";
import { DateTimeValidator } from "./../../_validators/date-time.validators";
import { EmployeeIdValidator } from "../../_validators/employee-id.validators";
import { FormGroup, Validators } from "@angular/forms";
import { FormGeneratorService } from "./../../_services/form_generator/form-generator.service";
import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-new-employee-form",
  templateUrl: "./new-employee-form.component.html",
  styleUrls: ["./new-employee-form.component.css"],
})
export class NewEmployeeFormComponent implements OnInit {
  newEmployeeForm: FormGroup;
  constructor(private formGeneratorService: FormGeneratorService) {}

  ngOnInit(): void {
    this.newEmployeeForm = this.formGeneratorService.generateForm(
      { formControlName: "fullName" },
      {
        formControlName: "employeeId",
        validators: [EmployeeIdValidator.checkFormat],
      },
      { formControlName: "address" },
      { formControlName: "birth", validators: [DateTimeValidator.checkFormat] },
      { formControlName: "email", validators: [EmailValidator.checkFormat] },
      {
        formControlName: "idNumber",
        validators: [IdNumberValidator.checkFormat],
      },
      {
        formControlName: "phoneNumber",
        validators: [PhoneNumberValidator.checkFormat],
      },
      { formControlName: "salary", validators: [Validators.min(0)] }
    );
  }

  get employeeId() {
    return this.newEmployeeForm.get("employeeId");
  }
  get fullName() {
    return this.newEmployeeForm.get("fullName");
  }
  get idNumber() {
    return this.newEmployeeForm.get("idNumber");
  }
  get phoneNumber() {
    return this.newEmployeeForm.get("phoneNumber");
  }
  get address() {
    return this.newEmployeeForm.get("address");
  }
  get birth() {
    return this.newEmployeeForm.get("birth");
  }
  get email() {
    return this.newEmployeeForm.get("email");
  }
  get salary() {
    return this.newEmployeeForm.get("salary");
  }
}
