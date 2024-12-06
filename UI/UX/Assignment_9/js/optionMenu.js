import { EmployeeForm } from "./EmployeeForm.js";
import { VehicleForm } from "./VechileForm.js";
const employees = [];
const vehicles = [];
export function generateOptionMenu() {
    const formContainer = document.querySelector("#form-container");
    if (!formContainer)
        return;
    const inputLabel = document.createElement("h4");
    inputLabel.textContent = "Choose the option you want to perform :";
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
function handleOptionInput() {
    const selectedOption = document.querySelector('input[name="work"]:checked');
    if (selectedOption) {
        const optionSelected = selectedOption.value;
        console.log(optionSelected);
        switch (optionSelected) {
            case "Add Employee": {
                new EmployeeForm(employees, vehicles);
                break;
            }
            case "Add Vehicle": {
                checkForEmployee();
                break;
            }
            default: {
                alert("Choose correct option!!");
                generateOptionMenu();
            }
        }
    }
    function checkForEmployee() {
        
        const formContainer = document.querySelector("#form-container");
        if (!formContainer)
            return;
        formContainer.innerHTML='';
        const inputLabel = document.createElement("h4");
        inputLabel.textContent = "Enter the employee id :";
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
                alert(`Employee ID: ${empId} exists. Proceeding to Vehicle Form.`);
                new VehicleForm(vehicles);
            }
            else {
                // If employee ID does not exist, alert the user and show EmployeeForm
                alert(`Employee ID: ${empId} doesn't exist. Please fill out the employee form.`);
                new EmployeeForm(employees, vehicles);
            }
        });
        formContainer.appendChild(submitButton);
    }
}
