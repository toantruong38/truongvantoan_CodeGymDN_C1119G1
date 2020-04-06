import { Validators } from "@angular/forms";
import { DateTimeValidator } from "./../../_validators/date-time.validators";
import { FormGeneratorService } from "./../../_services/form_generator/form-generator.service";
import { FormGroup } from "@angular/forms";
import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-new-contract-form",
  templateUrl: "./new-contract-form.component.html",
  styleUrls: ["./new-contract-form.component.css"],
})
export class NewContractFormComponent implements OnInit {
  newContractForm: FormGroup;

  constructor(private formGeneratorService: FormGeneratorService) {}

  ngOnInit(): void {
    this.newContractForm = this.initiateFormGroup();
  }

  private initiateFormGroup(): FormGroup {
    return this.formGeneratorService.generateForm(
      {
        formControlName: "beginDate",
        validators: [DateTimeValidator.checkFormat],
      },
      {
        formControlName: "endDate",
        validators: [DateTimeValidator.checkFormat],
      },
      { formControlName: "contractNumber" },
      { formControlName: "deposit", validators: [Validators.min(0)] },
      { formControlName: "totalPay", validators: [Validators.min(0)] }
    );
  }
}
