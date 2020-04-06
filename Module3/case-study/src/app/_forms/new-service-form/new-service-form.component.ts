import { FormGroup, Validators } from "@angular/forms";
import { FormGeneratorService } from "./../../_services/form_generator/form-generator.service";
import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-new-service-form",
  templateUrl: "./new-service-form.component.html",
  styleUrls: ["./new-service-form.component.css"],
})
export class NewServiceFormComponent implements OnInit {
  newServiceForm: FormGroup;
  constructor(private formGeneratorService: FormGeneratorService) {}

  ngOnInit(): void {
    this.newServiceForm = this.formGeneratorService.generateForm(
      { formControlName: "area", validators: [Validators.min(0)] },
      { formControlName: "floorAmount", validators: [Validators.min(0)] },
      { formControlName: "freeAccompanyService" },
      { formControlName: "maximumPeople", validators: [Validators.min(0)] },
      { formControlName: "description" },
      { formControlName: "rentFee", validators: [Validators.min(0)] },
      { formControlName: "roomStandard" },
      { formControlName: "status" }
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
}
