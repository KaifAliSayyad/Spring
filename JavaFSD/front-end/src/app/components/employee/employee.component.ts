import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms'
import { EmployeeService } from '../../services/employee.service';
import { Employee } from '../../interfaces/employee';

@Component({
  selector: 'app-employee',
  standalone: false,
  templateUrl: './employee.component.html',
  styleUrl: './employee.component.css',
  providers: [EmployeeService]
})
export class EmployeeComponent implements OnInit{

  private update: boolean = false;

  constructor(public es: EmployeeService){

  }

  ngOnInit(): void {
    this.resetForm();
    
  }

  onSubmit(form: NgForm){

    if(!this.update){
      this.es.postEmployee(form.value).subscribe((res) =>{
        this.resetForm(form);
        console.log("Employee record inserted successfully...")
      });
    }else{
      this.es.putEmployee(form.value).subscribe((res) =>{
        this.resetForm(form);
        this.update = false;
        console.log("Employee record updated successfully..")
      })
    }

  } 

  resetForm(form?: NgForm){
    if(form){
      form.reset();
    }
    this.es.selectedEmployee = {
      eid: null,
      name: "",
      age: null,
      salary: null,
      designation: ""
    }
    this.refreshEmployees();
  }

  refreshEmployees(){
    console.log("Fetching employees....")
    this.es.getAllEmployees().subscribe((res) =>{
      this.es.employees = (res as Employee[]).sort((a, b) => {
        return a.eid - b.eid;
      });
    });
  }

  updateEmp(emp: Employee){
    this.es.selectedEmployee = emp;
    this.update = true;
  }

  deleteEmployee(id: number){
    console.log("Deleting empoyee...", id);
    if(confirm("Do you really want to delete ?")){
      this.es.deleteEmployee(id).subscribe((res) => {
        this.resetForm();
      })
    }
  }
}
