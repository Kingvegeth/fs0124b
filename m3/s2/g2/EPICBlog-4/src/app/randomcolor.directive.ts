import { Directive, OnInit, ElementRef} from '@angular/core';

@Directive({
  selector: '[appRandomcolor]'
})
export class RandomcolorDirective implements OnInit {

  constructor(private el: ElementRef) { }

  ngOnInit() {
    const randomColor = '#' + Math.floor(Math.random() * 16777215).toString(16);
    this.el.nativeElement.style.backgroundColor = randomColor;

  }

}
