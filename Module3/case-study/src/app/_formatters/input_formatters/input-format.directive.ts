import { ElementRef, Input, HostListener } from "@angular/core";
import { Directive } from "@angular/core";

@Directive({
  selector: "[appInputFormat]",
})
export class InputFormatDirective {
  @Input("inputType") inputType;
  constructor(private el: ElementRef) {}

  @HostListener("blur") onBlur() {
    let value = this.el.nativeElement.value as string;
    if (!value) return;
    switch (this.inputType) {
      case "full-name":
        return (this.el.nativeElement.value = this.fullNameFormat(value));
      case "phone-number":
        return (this.el.nativeElement.value = this.phoneNumberFormat(value));
      // case "birth":
      //   return (this.el.nativeElement.value = this.birthFormat(value));
    }
  }

  fullNameFormat(fullName: string): string {
    let formattedFullName = "";
    fullName
      .split(" ")
      .map((peace) => {
        let firstChar = peace[0];
        return peace.replace(firstChar, firstChar.toUpperCase());
      })
      .map((peace) => {
        formattedFullName += peace + " ";
      });
    return formattedFullName.trim();
  }
  phoneNumberFormat(phoneNumber: string): string {
    let _phoneNumber = phoneNumber;
    if (phoneNumber.includes("(84)+")) {
      _phoneNumber =
        "0" +
        phoneNumber.slice(phoneNumber.indexOf("+") + 1, phoneNumber.length);
    }
    return `(84)+${_phoneNumber.slice(1, _phoneNumber.length)}`;
  }
  birthFormat(birth: string): string {
    let oldBirth = birth.split("-");
    return oldBirth.reverse().join("-");

    // birthInput.blur(() => {
    //   let oldBirth = (<string>birthInput.value).split("-");
    //   birthInput.value = oldBirth.reverse().join("-");
    // });
  }
}
