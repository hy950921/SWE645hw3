
import { StudentService } from '../student.service';
import { Student } from '../student';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-create-student',
  templateUrl: './create-student.component.html',
  styleUrls: ['./create-student.component.css']
})
export class CreateStudentComponent implements OnInit {

  student: Student = new Student();
  submitted = false;
  thingsLiked = [];
  

  constructor(private studentService: StudentService,
    private router: Router) { }

  ngOnInit() {
  }

  newStudent(): void {
    this.submitted = false;
    this.student = new Student();
  }

  save() {
    this.studentService.createStudent(this.student)
      .subscribe(data => console.log(data), error => console.log(error));
    this.student = new Student();
    
  }
  onSubmit() {
    this.student.like_about_college = this.thingsLiked.join();
    this.submitted = true;
    this.save();    
  }

  gotoList() {
        this.router.navigate(['/students']);
  }

  onCheckboxChange(event, value) {
    if (event.target.checked) {

      this.thingsLiked.push(value);
    } 
    if (!event.target.checked) {

      let index = this.thingsLiked.indexOf(value);

      if (index > -1) {

        this.thingsLiked.splice(index, 1);
      }
    }
  }
}
