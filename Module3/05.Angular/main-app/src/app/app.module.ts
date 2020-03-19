import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { FontSizeEditorComponent } from "./font-size-editor/font-size-editor.component";
import { PetComponent } from "./pet/pet.component";
import { ColorPickerComponent } from "./color-picker/color-picker.component";
import { FormsModule } from "@angular/forms";
import { CalculatorComponent } from './calculator/calculator.component';

@NgModule({
  declarations: [
    AppComponent,
    FontSizeEditorComponent,
    PetComponent,
    ColorPickerComponent,
    CalculatorComponent
  ],
  imports: [BrowserModule, AppRoutingModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
