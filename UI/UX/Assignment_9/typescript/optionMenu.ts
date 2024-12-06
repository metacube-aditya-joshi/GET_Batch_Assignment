import { Employee } from "./employee";
import { Vehicle } from "./vehicle";
import { EmployeeForm } from "./EmployeeForm";
import { VehicleForm } from "./VechileForm";
import swal from "../js/sweetalert/typings/core";

const employees: Employee[] = [];
const vehicles: Vehicle[] = [];

export function generateOptionMenu():void{
    const formContainer = document.querySelector("#form-container") as HTMLElement;
    if (!formContainer) return;

    const inputLabel=document.createElement("h4");
    inputLabel.textContent="Choose the option you want to perform :"
    formContainer.appendChild(inputLabel);
    const optionToAdd = ["Add Employee", "Add Vehicle"];
    optionToAdd.forEach(option => {
            const radioContainer = document.createElement("div");

            const inputField = document.createElement("input");
            inputField.type = "radio";
            inputField.id = option;
            inputField.name = "work"; // Grouping radio buttons
            inputField.value = option;

            const label = document.createElement("label");
            label.htmlFor = option;
            label.textContent = option;

            radioContainer.appendChild(inputField);
            radioContainer.appendChild(label);
            formContainer.appendChild(radioContainer);
        });

        const submitButton = document.createElement("button");
        submitButton.textContent = "Next";
        
        submitButton.addEventListener("click", (event) => {
            event.preventDefault(); // Prevent form submission
            handleOptionInput();
        });
        formContainer.appendChild(submitButton);
}
function handleOptionInput(): void {
    const selectedOption = document.querySelector('input[name="work"]:checked') as HTMLInputElement;
    if (selectedOption) {
       const optionSelected = selectedOption.value;
       console.log(optionSelected);
        switch (optionSelected) {
            case "Add Employee":{
                new EmployeeForm(employees,vehicles);
                break;
            }
            case "Add Vehicle":{
                checkForEmployee();
                break;
            }
            default:{
                swal("Choose correct option!!");
                generateOptionMenu();
            }
                
        }
        
    }

   function checkForEmployee():void{

    const formContainer = document.querySelector("#form-container") as HTMLElement;
   
    if (!formContainer) return;
    formContainer.innerHTML='';
    const inputLabel=document.createElement("h4");
    inputLabel.textContent="Enter the employee id :"
    formContainer.appendChild(inputLabel);
    const inputField = document.createElement("input");
    inputField.type = "text"; 
    inputField.id = "empId";
    inputField.placeholder = "1234";
    formContainer.appendChild(inputField);


        const submitButton = document.createElement("button");
        submitButton.textContent = "Next";
        
        submitButton.addEventListener("click", (event) => {
            event.preventDefault(); // Prevent form submission
        
            const empId = inputField.value; 
            const employeeExists = employees.some(employee => employee.employeeId === empId);
        
            if (employeeExists) {
                // If employee ID exists, proceed to VehicleForm
                swal(`Employee ID: ${empId} exists. Proceeding to Vehicle Form.`);
                new VehicleForm(vehicles);
            } else {
                // If employee ID does not exist, swal the user and show EmployeeForm
                swal(`Employee ID: ${empId} doesn't exist. Please fill out the employee form.`);
                new EmployeeForm(employees, vehicles);
            }
        });
        
        formContainer.appendChild(submitButton);
   }
}