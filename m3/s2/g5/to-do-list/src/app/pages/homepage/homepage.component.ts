import { Component } from '@angular/core';
import { UsersService } from '../../users.service';
import { iUser } from '../../models/iuser';
import { TodoService } from '../../todo.service';
import { iTodo } from '../../models/itodo';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrl: './homepage.component.scss'
})
export class HomepageComponent {

  todos: iTodo[] = [];
  users: iUser[] = [];

  searchTerm: string = '';

  constructor(private todoService: TodoService, private usersService: UsersService) { }

  ngOnInit(): void {
    this.todos = this.todoService.getAllTodo();
    this.users = this.usersService.getAllUsers();
  }

  getUserById(userId: number): iUser | undefined {
    if (this.searchTerm.trim() === '') {
      return this.users.find(user => user.id === userId);
    } else {
      return this.users.find(user => 
        user.id === userId && 
        (user.firstName.toLowerCase() + ' ' + user.lastName.toLowerCase()).includes(this.searchTerm.toLowerCase())
      );
    }
  }

  updateTodoStatus(todo: iTodo): void {
    this.todoService.updateTodoStatus(todo.id, todo.completed);
  }

  filterTodos(): void {
    if (this.searchTerm.trim() !== '') {
      this.todos = this.todoService.getAllTodo().filter(todo => {
        const user = this.getUserById(todo.userId);
        return user !== undefined;
      });
    } else this.todos = this.todoService.getAllTodo();
  }

  updateSearchTerm(event: any): void {
    this.searchTerm = event.target.value.trim();
    this.filterTodos();
  }

}
