import { Component, OnInit } from '@angular/core';
import { iArticle } from '../../models/iarticle';
import { ArticleService } from '../../article.service';

@Component({
  selector: 'app-active-posts',
  templateUrl: './active-posts.component.html',
  styleUrls: ['./active-posts.component.scss']
})
export class ActivePostsComponent implements OnInit {

  articleArr: iArticle[] = [];

  constructor(private articleSvc: ArticleService) { }

  ngOnInit() {
    this.articleArr = this.articleSvc.getActiveArticle();
  }

}
