import { Component, OnInit } from "@angular/core";
import { FormGroup, FormControl, FormArray } from "@angular/forms";

@Component({
  selector: "app-todo",
  templateUrl: "./todo.component.html",
  styleUrls: ["./todo.component.css"],
})
export class TodoComponent implements OnInit {
  todoForm: FormGroup;
  constructor() {}

  ngOnInit(): void {
    this.todoForm = new FormGroup({
      todos: new FormArray([]),
    });
  }

  get todos() {
    return this.todoForm.get("todos") as FormArray;
  }

  onAddNew(todo: HTMLInputElement) {
    this.todos.controls.push(
      new FormControl({ work: todo.value, isDone: false })
    );
  }
}
