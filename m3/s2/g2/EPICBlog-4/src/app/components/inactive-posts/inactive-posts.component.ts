import { Component, OnInit } from '@angular/core';
import { iArticle } from '../../models/iarticle';
import { ArticleService } from '../../article.service';

@Component({
  selector: 'app-inactive-posts',
  templateUrl: './inactive-posts.component.html',
  styleUrls: ['./inactive-posts.component.scss']
})
export class InactivePostsComponent implements OnInit {

  articleArr: iArticle[] = [];
  tempBody: string = ''; // Variabile temporanea per memorizzare le modifiche al campo body

  constructor(private articleSvc: ArticleService) { }

  ngOnInit() {
    this.articleArr = this.articleSvc.getInactiveArticle();
  }

}
