import { Vehicle } from "./vehicle.js"; // Assuming Vehicle class is defined in vehicle.ts
import { PricingForm } from "./PricingForm.js"; // Assuming PricingForm is defined in pricingForm.ts
export class VehicleForm {
    constructor(vehicles) {
        this.vehicle = new Vehicle("", "", "", "", "");
        this.currentStep = 0;
        this.displayNextField();
        this.vehicles = vehicles;
    }
    displayNextField() {
        switch (this.currentStep) {
            case 0:
                this.createInputField("name", "Enter Vehicle Name:");
                break;
            case 1:
                this.createVehicleTypeField();
                break;
            case 2:
                this.createInputField("vehicleNumber", "Enter Vehicle Number:");
                break;
            case 3:
                this.createInputField("employeeId", "Enter Employee ID:");
                break;
            case 4:
                this.createTextareaField("identification", "Enter Identification:");
                break;
            default:
                this.submitVehicle();
                break;
        }
    }
    createVehicleTypeField() {
        const formContainer = document.querySelector("#form-container");
        if (!formContainer)
            return;
        formContainer.innerHTML = ''; // Clear previous input
        const inputLabel = document.createElement("label");
        inputLabel.textContent = "Select Vehicle Type:";
        formContainer.appendChild(inputLabel);
        const vehicleTypeSelect = document.createElement("select");
        vehicleTypeSelect.id = "vehicleType";
        vehicleTypeSelect.innerHTML = `
            <option value="">--Select Vehicle Type--</option>
            <option value="Cycle">Cycle</option>
            <option value="Two Wheeler">Two Wheeler</option>
            <option value="Four Wheeler">Four Wheeler</option>
        `;
        vehicleTypeSelect.onchange = () => this.handleVehicleTypeChange(vehicleTypeSelect.value);
        formContainer.appendChild(vehicleTypeSelect);
        const submitButton = document.createElement("button");
        submitButton.textContent = "Next";
        submitButton.onclick = () => this.handleInput("type", vehicleTypeSelect.value);
        formContainer.appendChild(submitButton);
    }
    handleVehicleTypeChange(value) {
        this.vehicle.type = value; // Set the vehicle type
        this.currentStep++; // Move to the next step
        this.displayNextField(); // Display the next field
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
        inputField.type = "text"; // All fields are text for simplicity
        inputField.id = field;
        inputField.placeholder = label;
        formContainer.appendChild(inputField);
        const submitButton = document.createElement("button");
        submitButton.textContent = "Next";
        submitButton.onclick = () => this.handleInput(field, inputField.value);
        formContainer.appendChild(submitButton);
    }
    createTextareaField(field, label) {
        const formContainer = document.querySelector("#form-container");
        if (!formContainer)
            return;
        formContainer.innerHTML = ''; // Clear previous input
        const inputLabel = document.createElement("label");
        inputLabel.textContent = label;
        formContainer.appendChild(inputLabel);
        const textareaField = document.createElement("textarea");
        textareaField.id = field;
        textareaField.placeholder = label;
        formContainer.appendChild(textareaField);
        const submitButton = document.createElement("button");
        submitButton.textContent = "Submit";
        submitButton.onclick = () => this.handleInput(field, textareaField.value);
        formContainer.appendChild(submitButton);
    }
    handleInput(field, value) {
        switch (field) {
            case "name":
                this.vehicle.name = value;
                break;
            case "vehicleNumber":
                this.vehicle.vehicleNumber = value;
                break;
            case "employeeId":
                this.vehicle.employeeId = value;
                break;
            case "identification":
                this.vehicle.identification = value;
                break;
        }
        this.currentStep++;
        this.displayNextField();
    }
    submitVehicle() {
        console.log("Vehicle Information:", this.vehicle);
        alertify.success("Vehicle information collected successfully!");
        // Now we will show the pricing options based on the vehicle type
        new PricingForm(this.vehicle); // Pass the vehicle object to the PricingForm
    }
}
