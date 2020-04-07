import { ImageGalleryComponent } from "./image-gallery.component";
import { ImageCardComponent } from "./../image-card/image-card.component";
import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";

@NgModule({
  declarations: [ImageCardComponent, ImageGalleryComponent],
  imports: [CommonModule],
  exports: [ImageGalleryComponent],
})
export class ImageGalleryModule {}
