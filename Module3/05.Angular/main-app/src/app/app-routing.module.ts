import { YoutubePlayerComponent } from "./youtube-player/youtube-player.component";
import { YoutubePlaylistComponent } from "./youtube-playlist/youtube-playlist.component";
import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { DictionaryPageComponent } from "./dictionary-page/dictionary-page.component";
import { DictionaryDetailComponent } from "./dictionary-detail/dictionary-detail.component";

const routes: Routes = [
  {
    path: "youtube",
    component: YoutubePlaylistComponent,
    children: [
      {
        path: ":id",
        component: YoutubePlayerComponent,
      },
    ],
  },
  {
    path: "dictionary",
    component: DictionaryPageComponent,
    children: [
      {
        path: ":key",
        component: DictionaryDetailComponent,
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
