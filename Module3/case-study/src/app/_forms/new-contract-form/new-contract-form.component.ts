import { DataServiceService } from "./../../_services/data-service.service";
import { Validators } from "@angular/forms";
import { DateTimeValidator } from "./../../_validators/date-time.validators";
import { FormGeneratorService } from "./../../_services/form_generator/form-generator.service";
import { FormGroup } from "@angular/forms";
import { Component, OnInit, Input } from "@angular/core";

@Component({
  selector: "app-new-contract-form",
  templateUrl: "./new-contract-form.component.html",
  styleUrls: ["./new-contract-form.component.css"],
})
export class NewContractFormComponent implements OnInit {
  newContractForm: FormGroup;
  @Input("formState") formState: any[];

  constructor(
    private formGeneratorService: FormGeneratorService,
    private dataService: DataServiceService
  ) {}

  ngOnInit(): void {
    this.newContractForm = this.initiateFormGroup();
  }

  private initiateFormGroup(): FormGroup {
    return this.formGeneratorService.generateForm(
      {
        formControlName: "beginDate",
        validators: [DateTimeValidator.checkFormat],
        state: this.formState ? this.formState[0] : "",
      },
      {
        formControlName: "endDate",
        validators: [DateTimeValidator.checkFormat],
        state: this.formState ? this.formState[1] : "",
      },
      {
        formControlName: "contractNumber",
        state: this.formState ? this.formState[2] : "",
      },
      {
        formControlName: "deposit",
        validators: [Validators.min(0)],
        state: this.formState ? this.formState[3] : "",
      },
      {
        formControlName: "totalPay",
        validators: [Validators.min(0)],
        state: this.formState ? this.formState[4] : "",
      }
    );
  }
  get beginDate() {
    return this.newContractForm.get("beginDate");
  }
  get endDate() {
    return this.newContractForm.get("endDate");
  }
  get contractNumber() {
    return this.newContractForm.get("contractNumber");
  }
  get deposit() {
    return this.newContractForm.get("deposit");
  }
  get totalPay() {
    return this.newContractForm.get("totalPay");
  }

  onSubmit() {
    this.dataService
      .postData("contracts", this.newContractForm.value)
      .subscribe((result) => console.log(result));
  }
}
