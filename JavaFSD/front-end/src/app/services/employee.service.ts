import { Injectable } from '@angular/core';
import { Employee } from '../interfaces/employee';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  selectedEmployee: any;
  employees: Employee[] = []
  baseurl: string;

  constructor(private httpClient: HttpClient) {
    this.baseurl = "http://localhost:8090/employees";
  }

  postEmployee(emp: Employee){
    return this.httpClient.post(this.baseurl, emp);
  }

  getAllEmployees(){
    return this.httpClient.get(this.baseurl)
  }


  putEmployee(emp: Employee){
    return this.httpClient.put(this.baseurl, emp);
  }

  deleteEmployee(id: number){
    return this.httpClient.delete(`${this.baseurl}/${id}`);
  }
}
