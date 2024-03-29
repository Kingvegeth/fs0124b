import { Component } from '@angular/core';
import { iTodo } from '../../models/itodo';
import { TodoService } from '../../todo.service';
import { iUser } from '../../models/iuser';
import { UsersService } from '../../users.service';

@Component({
  selector: 'app-incomplete',
  templateUrl: './incomplete.component.html',
  styleUrl: './incomplete.component.scss'
})
export class IncompleteComponent {

  incompleteTodos: iTodo[] = [];
  users: iUser[] = [];

  constructor(private todoService: TodoService, private usersService: UsersService) { }

  ngOnInit(): void {
    this.incompleteTodos = this.todoService.getIncompleteTodos();
    this.users = this.usersService.getAllUsers();
  }

  getUserById(userId: number): iUser | undefined {
    return this.users.find(user => user.id === userId);
  }

  updateTodoStatus(todo: iTodo): void {
    this.todoService.updateTodoStatus(todo.id, todo.completed);
  }

}
