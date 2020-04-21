
import { Observable, from } from "rxjs";
import {StudentService} from '../student.service'
import {Student} from '../student'
import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';


@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.component.html',
  styleUrls: ['./student-details.component.css']
})

export class StudentDetailsComponent implements OnInit {

  students: Observable<Student[]>;
  constructor(private studentService: StudentService,
    private router: Router) {}

    ngOnInit() {
      this.reloadData();
    }

    reloadData() {
      this.students = this.studentService.getStudentsList();
    }
}