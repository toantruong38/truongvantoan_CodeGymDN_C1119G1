import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { FontSizeEditorComponent } from "./font-size-editor/font-size-editor.component";
import { PetComponent } from "./pet/pet.component";
import { ColorPickerComponent } from "./color-picker/color-picker.component";
import { FormsModule } from "@angular/forms";
import { CalculatorComponent } from './calculator/calculator.component';
import { NameCardComponent } from './name-card/name-card.component';
import { ProgressBarComponent } from './progress-bar/progress-bar.component';
import { RatingBarComponent } from './rating-bar/rating-bar.component';
import { CountDownComponent } from './count-down/count-down.component';

@NgModule({
  declarations: [
    AppComponent,
    FontSizeEditorComponent,
    PetComponent,
    ColorPickerComponent,
    CalculatorComponent,
    NameCardComponent,
    ProgressBarComponent,
    RatingBarComponent,
    CountDownComponent
  ],
  imports: [BrowserModule, AppRoutingModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
