import { Employee } from "./employee";
import { VehicleForm } from "./VechileForm";

export class EmployeeForm {
    private employee: Employee;
    private currentStep: number;

    constructor() {
        this.employee = new Employee("", "", "", "", "", 0);
        this.currentStep = 0;
        this.displayNextField();
    }

    private displayNextField(): void {
        switch (this.currentStep) {
            case 0:
                this.createInputField("name", "Enter Full Name:");
                break;
            case 1:
                this.createGenderField(); // Change to use radio buttons for gender
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
        switch (field) {
            case "name":
                this.employee.name = value;
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
    
        private submitEmployee(): void {
            console.log("Employee Information:", this.employee);
            alert("Employee information collected successfully!");
    
            // Hide the Employee Form
            const formContainer = document.querySelector("#form-container") as HTMLElement;
            if (formContainer) {
                formContainer.innerHTML = ''; // Clear the form
            }
    
            // Show the Vehicle Form
            new VehicleForm(); // Instantiate VehicleForm
        }
    }
    
