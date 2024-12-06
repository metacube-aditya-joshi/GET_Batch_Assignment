"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.EmployeeForm = void 0;
class EmployeeForm {
    constructor() {
        this.employee = new Employee("", "", "", "", "", 0);
        this.currentStep = 0;
        this.displayNextField();
    }
    displayNextField() {
        switch (this.currentStep) {
            case 0:
                this.createInputField("name", "Enter Full Name:");
                break;
            case 1:
                this.createInputField("gender", "Enter Gender (Male/Female):");
                break;
            case 2:
                this.createInputField("emailId", "Enter Email ID:");
                break;
            case 3:
                this.createInputField("password", "Enter Password:");
                break;
            case 4:
                this.createInputField("employeeId", "Enter Employee ID:");
                break;
            case 5:
                this.createInputField("contact", "Enter Contact Number:");
                break;
            default:
                this.submitEmployee();
                break;
        }
    }
    createInputField(field, label) {
        const formContainer = document.querySelector("#form-container");
        if (!formContainer)
            return;
        formContainer.innerHTML = ''; // Clear previous input
        const inputLabel = document.createElement("label");
        inputLabel.textContent = label;
        formContainer.appendChild(inputLabel);
        const inputField = document.createElement("input");
        inputField.type = field === "contact" ? "number" : "text"; // Set type based on field
        inputField.id = field;
        inputField.placeholder = label;
        formContainer.appendChild(inputField);
        const submitButton = document.createElement("button");
        submitButton.textContent = "Next";
        submitButton.onclick = () => this.handleInput(field, inputField.value);
        formContainer.appendChild(submitButton);
    }
    handleInput(field, value) {
        switch (field) {
            case "name":
                this.employee.name = value;
                break;
            case "gender":
                this.employee.gender = value;
                break;
            case "emailId":
                this.employee.emailId = value;
                break;
            case "password":
                this.employee.password = value;
                break;
            case "employeeId":
                this.employee.employeeId = value;
                break;
            case "contact":
                this.employee.contact = Number(value);
                break;
        }
        this.currentStep++;
        this.displayNextField();
    }
    submitEmployee() {
        console.log("Employee Information:", this.employee);
        alert("Employee information collected successfully!");
        // Here you can return the employee object or perform further actions
    }
}
exports.EmployeeForm = EmployeeForm;
