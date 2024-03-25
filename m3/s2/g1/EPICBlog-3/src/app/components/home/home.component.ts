import { Component } from '@angular/core';
import { iArticle } from '../../models/iarticle';
import { ArticleService } from '../../article.service'

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {

  articleArr: iArticle[] = [];
  randomIndex: number[] = [];

  constructor(private articleSvc: ArticleService) {}

  ngOnInit() {
    this.articleArr = this.articleSvc.getAllArticle();
    this.randomIndex = this.articleSvc.randomIndexGenerator(4, this.articleArr.length);
  }
}
