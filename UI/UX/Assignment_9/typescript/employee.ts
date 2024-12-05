export class Employee {
    name: string;
    gender: string;
    emailId: string;
    password: string;
    employeeId: string;
    contact: number;

    constructor(name: string, gender: string, emailId: string, password: string, employeeId: string, contact: number) {
        this.name = name;
        this.gender = gender;
        this.emailId = emailId;
        this.password = password;
        this.employeeId = employeeId;
        this.contact = contact;
    }
}

