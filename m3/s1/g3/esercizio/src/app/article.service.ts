import { Injectable } from '@angular/core';
import { iArticle } from '../app/models/iarticle';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  articleArr: iArticle[] = [];

  getAllArticle(): Promise<iArticle[]> {
    return fetch('../assets/db.json')
      .then(res => res.json())
      .then((res: { posts: iArticle[] }) => {
        this.articleArr = res.posts;
        return this.articleArr;
      });
  }

  randomIndexGenerator(indexSize: number, arrayLength: number): number[] {
    let indici: number[] = []
    while (indici.length < indexSize) {
      let indexRnd = Math.floor(Math.random() * arrayLength)
      if (!indici.includes(indexRnd)) indici.push(indexRnd)
    }
    return indici
  }

  getActiveArticle(): Promise<iArticle[]> {
    return this.getAllArticle().then(res => res.filter(a => a.active));
  }

  getInactiveArticle(): Promise<iArticle[]> {
    return this.getAllArticle().then(res => res.filter(a => !a.active));
  }
}
