import { EditService } from "./../../_services/edit-service/edit.service";
import { DataServiceService } from "./../../_services/data-service.service";
import { FormGeneratorService } from "./../../_services/form_generator/form-generator.service";
import { EmailValidator } from "./../../_validators/email.validators";
import { DateTimeValidator } from "./../../_validators/date-time.validators";
import { IdNumberValidator } from "./../../_validators/id-number.validators";
import { PhoneNumberValidator } from "./../../_validators/phone-number.validators";
import { ClientIdValidator } from "./../../_validators/client-id.validators";
import { Component, OnInit, Input } from "@angular/core";
import { FormGroup } from "@angular/forms";
import * as $ from "jquery";
import { Router, ActivatedRoute } from "@angular/router";
import { concat } from "rxjs";
import { map } from "rxjs/operators";

@Component({
  selector: "app-new-client-form",
  templateUrl: "./new-client-form.component.html",
  styleUrls: ["./new-client-form.component.css"],
})
export class NewClientFormComponent implements OnInit {
  clientForm: FormGroup;
  @Input("formState") formState: any[];
  constructor(
    private formGeneratorService: FormGeneratorService,
    private dataService: DataServiceService,
    private router: Router,
    private route: ActivatedRoute,
    private editService: EditService
  ) {}

  ngOnInit(): void {
    this.initiateClientForm();
    this.route.params.subscribe((params) => {
      this.editService.state$.subscribe((clients) => {
        const client = clients.find((c) => c["id"] === params.id);
        this.formState = [];
        for (let p in client) {
          this.formState.push(client[p]);
        }
        console.log(this.formState);
      });
    });

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
        state: this.formState ? this.formState[0] : "",
      },
      {
        formControlName: "fullName",
        state: this.formState ? this.formState[1] : "",
      },
      {
        formControlName: "birth",
        state: this.formState ? this.formState[2] : "",
      },
      {
        formControlName: "gender",
        state: this.formState ? this.formState[3] : "",
      },
      {
        formControlName: "email",
        validators: [EmailValidator.checkFormat],
        state: this.formState ? this.formState[4] : "",
      },
      {
        formControlName: "phoneNumber",
        validators: [PhoneNumberValidator.checkFormat],
        state: this.formState ? this.formState[5] : "",
      },
      {
        formControlName: "idNumber",
        validators: [IdNumberValidator.checkFormat],
        state: this.formState ? this.formState[6] : "",
      },
      {
        formControlName: "address",
        state: this.formState ? this.formState[7] : "",
      }
    );
    // console.log("eyyyy", this.clientForm);
  }

  onSubmit() {
    if (this.clientForm.status === "INVALID") {
      this.clientForm.setErrors({ invalidForm: true });
      return;
    }
    this.dataService
      .postData("clients", this.clientForm.value)
      .subscribe((result) => {
        console.log(result);
        this.router.navigate(["clients"], { replaceUrl: true });
      });
  }
}
