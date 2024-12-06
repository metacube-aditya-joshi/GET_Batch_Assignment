import { Employee } from "./employee";
// import { VehicleForm } from "./VechileForm";
import { generateOptionMenu } from "./optionMenu";
import { Vehicle } from "./vehicle";

export class EmployeeForm {
    private employee: Employee;
    private currentStep: number;
    private employees: Employee[];
    private vehicles: Vehicle[];
    constructor(employees: Employee[], vehicles: Vehicle[]) {
        this.employee = new Employee("", "", "", "", "", 0);
        this.currentStep = 0;
        this.displayNextField();
        this.employees = employees;
        this.vehicles = vehicles;
    }

    private displayNextField(): void {
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

    private createInputField(field: string, label: string): void {
        const formContainer = document.querySelector("#form-container") as HTMLElement;
        if (!formContainer) return;

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

    private createGenderField(): void {
        const formContainer = document.querySelector("#form-container") as HTMLElement;
        if (!formContainer) return;

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

    private handleGenderInput(): void {
        const selectedGender = document.querySelector('input[name="gender"]:checked') as HTMLInputElement;
        if (selectedGender) {
            this.employee.gender = selectedGender.value;
        }

        this.currentStep++;
        this.displayNextField();
    }

    private handleInput(field: string, value: string): void {
        let isValid = false;
        switch (field) {
            case "name":
                isValid = this.validateName(value);
                if (isValid) this.employee.name = value;
                break;
            case "emailId":
                isValid = this.validateEmail(value);
                if (isValid) this.employee.emailId = value;
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
                if (isValid) this.employee.employeeId = value;
                break;
            case "contact":
                isValid = this.validateContact(value);
                if (isValid) this.employee.contact = Number(value);
                break;
        }

        if (isValid) {
            this.currentStep++;
            this.displayNextField();
        } else {
            swal(`Invalid input for ${field}. Please try again.`);
        }
    }
    private validateName(name: string): boolean {
        // Check if the name is at least 2 characters long and does not contain numbers
        const isValid = name.length >= 2 && !/\d/.test(name);
        return isValid;
    }

    private validateEmail(email: string): boolean {
        // Basic email validation regex
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return emailRegex.test(email);
    }

    private validatePassword(password: string): string {
        const weakRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[A-Za-z\d]{1,7}$/; // Weak: less than 8 characters
        const normalRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[A-Za-z\d]{8,}$/; // Normal: at least 8 characters
        const strongRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,}$/; // Strong: at least 8 characters with special char

        if (strongRegex.test(password)) {
            return "Strong";
        } else if (normalRegex.test(password)) {
            return "Normal";
        } else if (weakRegex.test(password)) {
            return "Weak";
        }
        return "Invalid"; // If it doesn't match any criteria
    }

    private updatePasswordFieldStyle(strength: string): void {
        const passwordField = document.getElementById("password") as HTMLInputElement;
        if (!passwordField) return;

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
    } validateEmployeeId(employeeId: string): boolean {
        // Check if the employee ID is not empty and is a valid format (e.g., alphanumeric)
        const isValid = employeeId.trim() !== "" && /^[a-zA-Z0-9]+$/.test(employeeId);
        return isValid;
    }

    private validateContact(contact: string): boolean {
        // Check if the contact number is numeric and has more than 8 digits
        const isValid = /^\d+$/.test(contact) && contact.length > 8;
        return isValid;
    }

    private submitEmployee(): void {
        this.employees.push(this.employee);
        console.log("Employee Information:", this.employee);
        console.log("Employee's List:", this.employees);
        swal("Employee information collected successfully!");

        // Hide the Employee Form
        const formContainer = document.querySelector("#form-container") as HTMLElement;
        if (formContainer) {
            formContainer.innerHTML = ''; // Clear the form
        }
 formContainer.innerHTML='';
        // Show the Vehicle Form
        //new VehicleForm(this.vehicles); // Instantiate VehicleForm
        generateOptionMenu();
    }
}

