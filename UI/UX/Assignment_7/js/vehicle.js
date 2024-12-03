import { displayPricing } from "./pricing.js";
const vehicle = {};

const displayVehicle=()=>{
  document.querySelector("#employee").classList.add("hidden");
  const form_input = document.querySelector("#vehicle .form-input");
  const label = document.querySelector("#vehicle .form-label");

  // Set up the manufacturer name input
  form_input.innerHTML =
    "<input type='text' id='name' placeholder='Manufacturer Name' required />";
  label.innerHTML = '<label for="name">Enter Manufacturer Name:</label>';

  const inputField = document.querySelector("#name");
  inputField.addEventListener("keypress", function (event) {
    if (event.key === "Enter") {
      event.preventDefault();

      const name = inputField.value; 
      console.log(name);
      if (name) {
        vehicle.fullName = name; 
        getType(form_input, label); 
        return;
      }

      alert("Enter name !!");
    }
  });
}

const getType=(form_input, label)=>{
  label.innerHTML = `Select the Type of Vehicle:`;

  // Set up the vehicle type selection
  form_input.innerHTML = `
    <select id='type' required>
      <option value=''>--Select Vehicle Type--</option>
      <option value='Two Wheeler'>Two Wheeler</option>
      <option value='Four Wheeler'>Four Wheeler</option>
      <option value='Cycle'>Cycle</option>
    </select>`;

  const selectElement = document.getElementById("type");

  // Add an event listener for the 'change' event
  selectElement.addEventListener("change", function () {
    const selectedValue = selectElement.value; // Get the selected value
    if (selectedValue) {
      vehicle.type = selectedValue; // Save vehicle type to vehicle object
      alert("Type of vehicle selected: " + selectedValue);
      getVehicleNumber(form_input, label); // Proceed to getVehicleNumber
    } else {
      alert("Please select the type of vehicle."); // Prompt if no selection
    }
  });
}

const getVehicleNumber=(form_input, label)=> {
  label.innerHTML = `Enter Vehicle Number:`;

  // Set up the vehicle number input
  form_input.innerHTML = `
    <input
      type="text"
      id="vehicleNumber"
      placeholder="Vehicle Number"
      required
      maxlength="8"
    />
  `;

  const inputField = document.getElementById("vehicleNumber");
  inputField.addEventListener("keypress", function (event) {
    if (event.key === "Enter") {
      event.preventDefault();

      const vehicleNumber = inputField.value; // Get the value of the vehicle number input
      if (vehicleNumber) {
        vehicle.vehicleNumber = vehicleNumber; // Save vehicle number to vehicle object
        alert("Vehicle number entered: " + vehicleNumber);
        getEmpId(form_input, label);
        // You can proceed with further actions here
      } else {
        alert("Please enter the vehicle number.");
      }
    }
  });
}
const getEmpId=(form_input, label)=>{
  label.innerHTML = `Enter Employee ID:`;

  // Set up the employee ID input and submit button
  form_input.innerHTML = `
      <input
          type="text"
          id="empId"
          placeholder="Employee ID"
          required
      />
      <button id="submitEmpIdBtn">Submit</button>
  `;

  const inputField = document.getElementById("empId");
  const submitBtn = document.getElementById("submitEmpIdBtn");

  // Add event listener for the submit button
  submitBtn.addEventListener("click", function () {
    const empId = inputField.value; // Get the value of the employee ID input
    if (empId) {
      vehicle.empId = empId; // Save employee ID to vehicle object
      displayPricing();
      alert(
        `Vehicle Manufacterer Name : ${vehicle.name}` +
          `Vechile type : ${vehicle.type}` +
          `Vehicle number : ${vehicle.vehicleNumber}` +
          "Employee ID entered: " +
          vehicle.empId
      );
      // You can proceed with further actions here
    } else {
      alert("Please enter the Employee ID.");
    }
  });

  // Add event listener for the input field to handle Enter key
  inputField.addEventListener("keypress", function (event) {
    if (event.key === "Enter") {
      event.preventDefault();
      submitBtn.click(); // Trigger the click event of the submit button
    }
  });
}

export {displayVehicle,vehicle} ;