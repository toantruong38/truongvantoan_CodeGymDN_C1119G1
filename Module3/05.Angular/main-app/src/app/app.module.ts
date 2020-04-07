import { ImageSliderModule } from "./image-slider/image-slider.module";
import { ImageGalleryModule } from "./image-gallery/image-gallery.module";
import { DictionaryPageComponent } from "./dictionary-page/dictionary-page.component";
import { DictionaryDetailComponent } from "./dictionary-detail/dictionary-detail.component";
import { DictionaryComponent } from "./dictionary/dictionary.component";
import { YoutubePlaylistComponent } from "./youtube-playlist/youtube-playlist.component";
import { YoutubePlayerComponent } from "./youtube-player/youtube-player.component";
import { LoginComponent } from "./login/login.component";
import { RegisterFinalComponent } from "./register-final/register-final.component";
import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { FontSizeEditorComponent } from "./font-size-editor/font-size-editor.component";
import { PetComponent } from "./pet/pet.component";
import { ColorPickerComponent } from "./color-picker/color-picker.component";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { CalculatorComponent } from "./calculator/calculator.component";
import { NameCardComponent } from "./name-card/name-card.component";
import { ProgressBarComponent } from "./progress-bar/progress-bar.component";
import { RatingBarComponent } from "./rating-bar/rating-bar.component";
import { CountDownComponent } from "./count-down/count-down.component";
import { TodoComponent } from "./todo/todo.component";
import { TimeLivingComponent } from "./time-living/time-living.component";
import { ImageGalleryComponent } from "./image-gallery/image-gallery.component";
import { ImageCardComponent } from "./image-card/image-card.component";

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
    CountDownComponent,
    TodoComponent,
    RegisterFinalComponent,
    LoginComponent,
    TimeLivingComponent,
    YoutubePlayerComponent,
    YoutubePlaylistComponent,
    DictionaryComponent,
    DictionaryDetailComponent,
    DictionaryPageComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    ImageGalleryModule,
    ImageSliderModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
