import { DataServiceService } from "./../../_services/data-service.service";
import { PhoneNumberValidator } from "./../../_validators/phone-number.validators";
import { IdNumberValidator } from "./../../_validators/id-number.validators";
import { EmailValidator } from "./../../_validators/email.validators";
import { DateTimeValidator } from "./../../_validators/date-time.validators";
import { EmployeeIdValidator } from "../../_validators/employee-id.validators";
import { FormGroup, Validators } from "@angular/forms";
import { FormGeneratorService } from "./../../_services/form_generator/form-generator.service";
import { Component, OnInit, Input } from "@angular/core";

@Component({
  selector: "app-new-employee-form",
  templateUrl: "./new-employee-form.component.html",
  styleUrls: ["./new-employee-form.component.css"],
})
export class NewEmployeeFormComponent implements OnInit {
  newEmployeeForm: FormGroup;
  @Input("formState") formState: any[];
  constructor(
    private formGeneratorService: FormGeneratorService,
    private dataService: DataServiceService
  ) {}

  ngOnInit(): void {
    this.newEmployeeForm = this.formGeneratorService.generateForm(
      {
        formControlName: "fullName",
        state: this.formState ? this.formState[0] : "",
      },
      {
        formControlName: "employeeId",
        validators: [EmployeeIdValidator.checkFormat],
        state: this.formState ? this.formState[1] : "",
      },
      {
        formControlName: "address",
        state: this.formState ? this.formState[2] : "",
      },
      {
        formControlName: "birth",
        validators: [DateTimeValidator.checkFormat],
        state: this.formState ? this.formState[3] : "",
      },
      {
        formControlName: "email",
        validators: [EmailValidator.checkFormat],
        state: this.formState ? this.formState[4] : "",
      },
      {
        formControlName: "idNumber",
        validators: [IdNumberValidator.checkFormat],
        state: this.formState ? this.formState[5] : "",
      },
      {
        formControlName: "phoneNumber",
        validators: [PhoneNumberValidator.checkFormat],
        state: this.formState ? this.formState[6] : "",
      },
      {
        formControlName: "salary",
        validators: [Validators.min(0)],
        state: this.formState ? this.formState[7] : "",
      }
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

  onSubmit() {
    this.dataService
      .postData("employees", this.newEmployeeForm.value)
      .subscribe((result) => console.log(result));
  }
}
