import { Component } from '@angular/core';
import { iArticle } from '../../models/iarticle';
import { ArticleService } from '../../article.service'

@Component({
  selector: 'app-inactive-posts',
  templateUrl: './inactive-posts.component.html',
  styleUrl: './inactive-posts.component.scss'
})
export class InactivePostsComponent {

  articleArr: iArticle[] = [];
  randomIndex: number[] = [];

  constructor(private articleSvc:ArticleService){}

  ngOnInit(){

    this.articleSvc.getInactiveArticle().then(res => {
      this.articleArr = res;
    });
  }
}
