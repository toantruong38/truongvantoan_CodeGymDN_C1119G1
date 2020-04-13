import { DataServiceService } from "./../../_services/data-service.service";
import { FormGroup, Validators } from "@angular/forms";
import { FormGeneratorService } from "./../../_services/form_generator/form-generator.service";
import { Component, OnInit, Input } from "@angular/core";

@Component({
  selector: "app-new-service-form",
  templateUrl: "./new-service-form.component.html",
  styleUrls: ["./new-service-form.component.css"],
})
export class NewServiceFormComponent implements OnInit {
  newServiceForm: FormGroup;
  @Input("formState") formState: any[];
  constructor(
    private formGeneratorService: FormGeneratorService,
    private dataService: DataServiceService
  ) {}

  ngOnInit(): void {
    this.newServiceForm = this.formGeneratorService.generateForm(
      {
        formControlName: "area",
        validators: [Validators.min(0)],
        state: this.formState ? this.formState[0] : "",
      },
      {
        formControlName: "floorAmount",
        validators: [Validators.min(0)],
        state: this.formState ? this.formState[1] : "",
      },
      {
        formControlName: "freeAccompanyService",
        state: this.formState ? this.formState[2] : "",
      },
      {
        formControlName: "maximumPeople",
        validators: [Validators.min(0)],
        state: this.formState ? this.formState[3] : "",
      },
      {
        formControlName: "description",
        state: this.formState ? this.formState[4] : "",
      },
      {
        formControlName: "rentFee",
        validators: [Validators.min(0)],
        state: this.formState ? this.formState[5] : "",
      },
      {
        formControlName: "roomStandard",
        state: this.formState ? this.formState[6] : "",
      },
      {
        formControlName: "status",
        state: this.formState ? this.formState[7] : "",
      }
    );
  }

  get area() {
    return this.newServiceForm.get("area");
  }
  get floorAmount() {
    return this.newServiceForm.get("floorAmount");
  }
  get freeAccompanyService() {
    return this.newServiceForm.get("freeAccompanyService");
  }
  get maximumPeople() {
    return this.newServiceForm.get("maximumPeople");
  }
  get description() {
    return this.newServiceForm.get("description");
  }
  get rentFee() {
    return this.newServiceForm.get("rentFee");
  }
  get status() {
    return this.newServiceForm.get("status");
  }
  get roomStandard() {
    return this.newServiceForm.get("roomStandard");
  }

  onSubmit() {
    this.dataService
      .postData("services", this.newServiceForm.value)
      .subscribe((result) => console.log(result));
  }
}
