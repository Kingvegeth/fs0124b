import { Component} from '@angular/core';
import { UsersService } from '../../users.service';
import { iUser } from '../../models/iuser';
import { TodoService } from '../../todo.service';
import { iTodo } from '../../models/itodo';

@Component({
  selector: 'app-completed',
  templateUrl: './completed.component.html',
  styleUrls: ['./completed.component.scss']
})
export class CompletedComponent{

  completedTodos: iTodo[] = [];
  users: iUser[] = [];

  constructor(private todoService: TodoService, private usersService: UsersService) { }

  ngOnInit(): void {
    this.completedTodos = this.todoService.getCompletedTodos();
    this.users = this.usersService.getAllUsers();
  }

  getUserById(userId: number): iUser | undefined {
    return this.users.find(user => user.id === userId);
  }

  updateTodoStatus(todo: iTodo): void {
    this.todoService.updateTodoStatus(todo.id, todo.completed);
  }
}
