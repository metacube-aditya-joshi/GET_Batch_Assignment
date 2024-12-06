export class Vehicle {
    constructor(name, type, vehicleNumber, employeeId, identification, selectedPlan = "", // Added selectedPlan property
    passPrice = 0 // Added passPrice property
    ) {
        this.name = name;
        this.type = type;
        this.vehicleNumber = vehicleNumber;
        this.employeeId = employeeId;
        this.identification = identification;
        this.selectedPlan = selectedPlan;
        this.passPrice = passPrice;
    }
}
