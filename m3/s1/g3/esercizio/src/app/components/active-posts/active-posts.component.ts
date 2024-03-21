import { Component } from '@angular/core';
import { iArticle } from '../../models/iarticle';
import { ArticleService } from '../../article.service'

@Component({
  selector: 'app-active-posts',
  templateUrl: './active-posts.component.html',
  styleUrl: './active-posts.component.scss'
})
export class ActivePostsComponent {

  articleArr: iArticle[] = [];
  randomIndex: number[] = [];

  constructor(private articleSvc:ArticleService){}

  ngOnInit(){

    this.articleSvc.getActiveArticle().then(res => {
      this.articleArr = res;
    });
  }
}
