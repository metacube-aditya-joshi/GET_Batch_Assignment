export class Pricing {
    constructor() {
        this.prices = {
            "Cycle": [10, 50, 150], // Daily, Monthly, Yearly
            "Two Wheeler": [20, 100, 300],
            "Four Wheeler": [30, 150, 450]
        };
    }
    getPrices(vehicleType) {
        return this.prices[vehicleType] || null; // Return prices or null for invalid vehicle type
    }
}
