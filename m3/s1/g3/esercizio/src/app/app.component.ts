import { Component, OnInit } from '@angular/core';

import { iArticle } from './models/iarticle';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'esercizio';

  articleArr: iArticle[] = [];
  randomIndex: number[] = [];

  ngOnInit(){

    fetch('../assets/db.json')
    .then(article => article.json())
    .then(article => {
      this.articleArr = article.posts
      this.randomIndex = this.randomIndexGenerator(4, this.articleArr.length)
    })
  }

  randomIndexGenerator(indexSize:number, arrayLength:number):number[]{
    let indici: number[] = []
    while(indici.length < indexSize){
      let indexRnd = Math.floor(Math.random() * arrayLength)
      if(!indici.includes(indexRnd)) indici.push(indexRnd)
    }
    return indici
  }
}
