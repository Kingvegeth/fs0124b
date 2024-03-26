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
  articlesByTag: iArticle[] = [];
  uniqueTags: string[] = [];
  showFilteredPosts: boolean = false;
  selectedTag: string = '';

  constructor(private articleSvc: ArticleService) {}

  ngOnInit() {
    this.articleArr = this.articleSvc.getAllArticle();
    this.randomIndex = this.articleSvc.randomIndexGenerator(4, this.articleArr.length);
    this.uniqueTags = this.articleSvc.getUniqueTags();
  }
  filterByTag(tag: string) {
    this.articlesByTag = this.articleSvc.getArticlesByTag(tag);
    this.showFilteredPosts = true;
    this.selectedTag = tag;
  }
}
