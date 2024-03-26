import { Directive, OnInit, ElementRef, Renderer2 } from '@angular/core';

@Directive({
  selector: '[appRandomcolor]'
})
export class RandomcolorDirective implements OnInit {

  constructor(private el: ElementRef, private renderer: Renderer2) { }

  ngOnInit() {
    const randomColor = '#' + Math.floor(Math.random() * 16777215).toString(16);
    this.renderer.setStyle(this.el.nativeElement, 'background-color', randomColor);
    console.log(randomColor);

  }


}
