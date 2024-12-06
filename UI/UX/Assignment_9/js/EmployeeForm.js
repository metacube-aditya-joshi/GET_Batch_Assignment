import { Employee } from "./employee.js";
// import { VehicleForm } from "./VechileForm";
import { generateOptionMenu } from "./optionMenu.js";
export class EmployeeForm {
    constructor(employees, vehicles) {
        this.employee = new Employee("", "", "", "", "", 0);
        this.currentStep = 0;
        this.displayNextField();
        this.employees = employees;
        this.vehicles = vehicles;
    }
    displayNextField() {
        switch (this.currentStep) {
            case 0:
                this.createInputField("name", "Enter Full Name:");
                break;
            case 1:
                this.createGenderField();
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
        submitButton.addEventListener("click", (event) => {
            event.preventDefault(); // Prevent form submission
            this.handleInput(field, inputField.value);
        });
        formContainer.appendChild(submitButton);
    }
    createGenderField() {
        const formContainer = document.querySelector("#form-container");
        if (!formContainer)
            return;
        formContainer.innerHTML = ''; // Clear previous input
        const inputLabel = document.createElement("label");
        inputLabel.textContent = "Enter Gender:";
        formContainer.appendChild(inputLabel);
        // Create radio buttons for gender
        const genders = ["Male", "Female"];
        genders.forEach(gender => {
            const radioContainer = document.createElement("div");
            const inputField = document.createElement("input");
            inputField.type = "radio";
            inputField.id = gender;
            inputField.name = "gender"; // Grouping radio buttons
            inputField.value = gender;
            const label = document.createElement("label");
            label.htmlFor = gender;
            label.textContent = gender;
            radioContainer.appendChild(inputField);
            radioContainer.appendChild(label);
            formContainer.appendChild(radioContainer);
        });
        const submitButton = document.createElement("button");
        submitButton.textContent = "Next";
        submitButton.addEventListener("click", (event) => {
            event.preventDefault(); // Prevent form submission
            this.handleGenderInput();
        });
        formContainer.appendChild(submitButton);
    }
    handleGenderInput() {
        const selectedGender = document.querySelector('input[name="gender"]:checked');
        if (selectedGender) {
            this.employee.gender = selectedGender.value;
        }
        this.currentStep++;
        this.displayNextField();
    }
    handleInput(field, value) {
        let isValid = false;
        switch (field) {
            case "name":
                isValid = this.validateName(value);
                if (isValid)
                    this.employee.name = value;
                break;
            case "emailId":
                isValid = this.validateEmail(value);
                if (isValid)
                    this.employee.emailId = value;
                break;
            case "password":
                const passwordStrength = this.validatePassword(value);
                this.updatePasswordFieldStyle(passwordStrength);
                if (passwordStrength === "Strong") {
                    this.employee.password = value;
                    isValid = true; // Only consider valid if it's strong
                }
                break;
            case "employeeId":
                isValid = this.validateEmployeeId(value); // Add validation for employee ID
                if (isValid)
                    this.employee.employeeId = value;
                break;
            case "contact":
                isValid = this.validateContact(value);
                if (isValid)
                    this.employee.contact = Number(value);
                break;
        }
        if (isValid) {
            this.currentStep++;
            this.displayNextField();
        }
        else {
            alert(`Invalid input for ${field}. Please try again.`);
        }
    }
    validateName(name) {
        // Check if the name is at least 2 characters long and does not contain numbers
        const isValid = name.length >= 2 && !/\d/.test(name);
        return isValid;
    }
    validateEmail(email) {
        // Basic email validation regex
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return emailRegex.test(email);
    }
    validatePassword(password) {
        const weakRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[A-Za-z\d]{1,7}$/; // Weak: less than 8 characters
        const normalRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[A-Za-z\d]{8,}$/; // Normal: at least 8 characters
        const strongRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,}$/; // Strong: at least 8 characters with special char
        if (strongRegex.test(password)) {
            return "Strong";
        }
        else if (normalRegex.test(password)) {
            return "Normal";
        }
        else if (weakRegex.test(password)) {
            return "Weak";
        }
        return "Invalid"; // If it doesn't match any criteria
    }
    updatePasswordFieldStyle(strength) {
        const passwordField = document.getElementById("password");
        if (!passwordField)
            return;
        switch (strength) {
            case "Strong":
                passwordField.style.borderColor = "green";
                break;
            case "Normal":
                passwordField.style.borderColor = "orange";
                break;
            case "Weak":
                passwordField.style.borderColor = "red";
                break;
            default:
                passwordField.style.borderColor = ""; // Reset to default if invalid
                break;
        }
    }
    validateEmployeeId(employeeId) {
        // Check if the employee ID is not empty and is a valid format (e.g., alphanumeric)
        const isValid = employeeId.trim() !== "" && /^[a-zA-Z0-9]+$/.test(employeeId);
        return isValid;
    }
    validateContact(contact) {
        // Check if the contact number is numeric and has more than 8 digits
        const isValid = /^\d+$/.test(contact) && contact.length > 8;
        return isValid;
    }
    submitEmployee() {
        this.employees.push(this.employee);
        console.log("Employee Information:", this.employee);
        console.log("Employee's List:", this.employees);
        alert("Employee information collected successfully!");
        // Hide the Employee Form
        const formContainer = document.querySelector("#form-container");
        if (formContainer) {
            formContainer.innerHTML = ''; // Clear the form
        }
        formContainer.innerHTML='';
        // Show the Vehicle Form
        //new VehicleForm(this.vehicles); // Instantiate VehicleForm
        generateOptionMenu();
    }
}
