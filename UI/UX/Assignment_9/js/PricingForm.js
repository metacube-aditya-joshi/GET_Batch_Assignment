import { Pricing } from "./Pricing.js"; // Assuming Pricing class is defined in pricing.ts
import { generateOptionMenu } from "./optionMenu.js";
export class PricingForm {
    constructor(vehicle) {
        this.vehicle = vehicle;
        this.pricing = new Pricing();
        this.showPricingOptions();
    }
    showPricingOptions() {
        const formContainer = document.querySelector("#form-container");
        if (!formContainer)
            return;
        formContainer.innerHTML = ''; // Clear previous input
        const vehicleType = this.vehicle.type;
        console.log("Vehicle Type for Pricing:", vehicleType); // Debugging line
        const prices = this.pricing.getPrices(vehicleType);
        console.log("Prices Retrieved:", prices); // Debugging line
        if (!prices) {
            alertify.error("Invalid vehicle type. Please enter a valid type.");
            return;
        }
        console.log("Form is being generated");
        const pricingLabel = document.createElement("h3");
        const vehicleLabel = document.createElement("h4");
        pricingLabel.textContent = "Select a Pass Plan:";
        vehicleLabel.textContent = vehicleType; // Display the vehicle type
        formContainer.appendChild(pricingLabel);
        formContainer.appendChild(vehicleLabel);
        const plans = ["Daily", "Monthly", "Yearly"];
        plans.forEach((plan, index) => {
            const planContainer = document.createElement("div");
            const radioInput = document.createElement("input");
            radioInput.type = "radio";
            radioInput.id = plan;
            radioInput.name = "passPlan"; // Grouping radio buttons
            radioInput.value = plan;
            const label = document.createElement("label");
            label.htmlFor = plan;
            label.textContent = `${plan} Pass: ₹${prices[index]}`;
            planContainer.appendChild(radioInput);
            planContainer.appendChild(label);
            formContainer.appendChild(planContainer);
        });
        const submitButton = document.createElement("button");
        submitButton.textContent = "Get Pass";
        submitButton.onclick = () => this.handlePlanSelection();
        formContainer.appendChild(submitButton);
    }
    handlePlanSelection() {
        const selectedPlan = document.querySelector('input[name="passPlan"]:checked');
        if (selectedPlan) {
            const planIndex = ["Daily", "Monthly", "Yearly"].indexOf(selectedPlan.value);
            const prices = this.pricing.getPrices(this.vehicle.type);
            if (prices) {
                this.vehicle.selectedPlan = selectedPlan.value;
                this.vehicle.passPrice = prices[planIndex];
                this.showPassDetails();
            }
        }
        else {
            alertify.error("Please select a pass plan.");
        }
    }
    showPassDetails() {
        const formContainer = document.querySelector("#form-container");
        if (!formContainer)
            return;
        formContainer.innerHTML = ''; // Clear previous input
        const passDetails = document.createElement("h3");
        passDetails.textContent = `You have selected a ${this.vehicle.selectedPlan} Pass for ₹${this.vehicle.passPrice}.`;
        formContainer.appendChild(passDetails);
        formContainer.innerHTML = '';
        generateOptionMenu();
    }
}
