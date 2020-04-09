import { TodoOnlineService } from "./../_services/todo-online-service/todo-online.service";
import { Component, OnInit } from "@angular/core";
import { ITodo } from "../_models/todo";
import { FormControl } from "@angular/forms";

@Component({
  selector: "app-todo-online",
  templateUrl: "./todo-online.component.html",
  styleUrls: ["./todo-online.component.css"],
})
export class TodoOnlineComponent implements OnInit {
  todoList: ITodo[] = [];
  inputControl = new FormControl();
  constructor(private todoService: TodoOnlineService) {}

  ngOnInit() {
    this.todoService.getTodos().subscribe(
      (next) => {
        this.todoList = next;
      },
      (error) => {
        console.log(error);
      },
      () => {
        console.log("complete");
      }
    );
  }

  toggleTodo(i) {
    const todo = this.todoList[i];
    const todoData = {
      ...todo,
      completed: !todo.completed,
    };
    this.todoService.updateTodo(todoData).subscribe((next) => {
      this.todoList[i].completed = next.completed;
    });
  }

  addTodo() {
    const todo: Partial<ITodo> = {
      title: this.inputControl.value,
      completed: false,
    };

    this.todoService.createTodo(todo).subscribe((next) => {
      this.todoList.unshift(next);
      this.inputControl.setValue("");
    });
  }

  deleteTodo(i) {
    const todo = this.todoList[i];
    this.todoService.deleteTodo(todo.id).subscribe(() => {
      this.todoList = this.todoList.filter((t) => t.id !== todo.id);
    });
  }
}
