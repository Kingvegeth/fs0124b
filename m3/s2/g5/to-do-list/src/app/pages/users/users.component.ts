import { Component } from '@angular/core';
import { UsersService } from '../../users.service';
import { iUser } from '../../models/iuser';
import { iTodo } from '../../models/itodo';
import { TodoService } from '../../todo.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrl: './users.component.scss'
})
export class UsersComponent {

  todos: iTodo[] = [];
  users: iUser[] = [];

  constructor(private todoService: TodoService, private usersService: UsersService) { }

  ngOnInit(): void {
    this.todos = this.todoService.getAllTodo();
    this.users = this.usersService.getAllUsers();
  }

  getUserById(userId: number): iUser | undefined {
    return this.users.find(user => user.id === userId);
  }

  updateTodoStatus(todo: iTodo): void {
    this.todoService.updateTodoStatus(todo.id, todo.completed);
  }

  getTodosForUser(userId: number): iTodo[] {
    return this.todoService.getAllTodo().filter(todo => todo.userId === userId);
  }

}
