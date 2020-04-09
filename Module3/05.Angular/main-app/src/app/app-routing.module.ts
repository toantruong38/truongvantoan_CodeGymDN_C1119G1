import { BlogComponent } from "./blog/blog.component";
import { BlogDetailComponent } from "./blog-detail/blog-detail.component";
import { BlogEditComponent } from "./blog-edit/blog-edit.component";
import { YoutubePlayerComponent } from "./youtube-player/youtube-player.component";
import { YoutubePlaylistComponent } from "./youtube-playlist/youtube-playlist.component";
import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { DictionaryPageComponent } from "./dictionary-page/dictionary-page.component";
import { DictionaryDetailComponent } from "./dictionary-detail/dictionary-detail.component";

const routes: Routes = [
  {
    path: "blog/:id/edit",
    component: BlogEditComponent,
  },
  {
    path: "blog/:id",
    component: BlogDetailComponent,
  },
  {
    path: "blog",
    component: BlogComponent,
  },
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
