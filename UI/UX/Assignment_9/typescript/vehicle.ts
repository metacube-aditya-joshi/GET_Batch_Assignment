export class Vehicle {
    constructor(
        public name: string,
        public type: string,
        public vehicleNumber: string,
        public employeeId: string,
        public identification: string,
        public selectedPlan: string = "", // Added selectedPlan property
        public passPrice: number = 0      // Added passPrice property
    ) {}
}
