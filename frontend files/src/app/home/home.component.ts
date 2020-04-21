import {StudentDetailsComponent} from '../student-details/student-details.component';
import { Observable, from } from "rxjs";
import {StudentService} from '../student.service'
import {Student} from '../student'
import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
    
      constructor() { 
        
      }

    ngOnInit() {
      
    }
    
  }
