import { Component } from '@angular/core';
import { ArticleService } from './article.service';
import { iArticle } from './models/iarticle';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  constructor(private articleService: ArticleService) {}


}
