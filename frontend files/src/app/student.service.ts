import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Student } from './student';


@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private baseUrl1 = 'http://35.245.219.149/homework3/webapi/students/all';
  private baseUrl2 = 'http://35.245.219.149/homework3/webapi/students/create';

  constructor(private http: HttpClient) { }

  createStudent(student: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl2}`, student);
  }
    getStudentsList(): Observable<Student[]> {
    return this.http.get<Student[]>(`${this.baseUrl1}`);
  }
}