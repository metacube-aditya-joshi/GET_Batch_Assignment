const employee = {};
document.querySelectorAll(".collapsible-header").forEach((header) => {
  header.addEventListener("click", () => {
    const body = header.nextElementSibling;
    const isVisible = body.style.display === "flex";
    body.style.display = isVisible ? "none" : "flex";
  });
});

(function displayEmp() {
  const form_input = document.querySelector("#employee .form-input");
  const label = document.querySelector("#employee .form-label");
  if (!form_input || !label) {
    console.error("Form input or label not found");
    return; // Exit the function if elements are not found
  }
  form_input.innerHTML = `<input type='text' id='fullName' placeholder='Full Name' required />`;
  label.innerHTML = '<label for="fullName">Enter Full Name:</label>';

  const inputField = document.querySelector("#fullName");
  inputField.addEventListener("keypress", function (event) {
    if (event.key === "Enter") {
      event.preventDefault();

      const name = inputField.value; // Get value from the input field
      console.log(name);
      if (isValidFullName(name)) {
        employee.fullName = name;
        getGender(form_input, label, name); // Pass the name to getGender
        return;
      }

      alert(
        "Please enter a valid name (at least 2 characters and no numbers)!"
      );
      displayEmp(); // Re-display the input for correction
    }
  });
})();

function getGender(form_input, label, name) {
  label.innerHTML = `Hello ${name}, please select your gender:`;

  form_input.innerHTML = `
        <input type="radio" id="male" name="gender" value="Male">
        <label for="male">Male</label>
        <input type="radio" id="female" name="gender" value="Female">
        <label for="female">Female</label>
    `;
  const genderRadios = document.querySelectorAll('input[name="gender"]');
  genderRadios.forEach((radio) => {
    radio.addEventListener("change", function () {
      const selectedGender = this.value;
      employee.gender = selectedGender; // Get the value of the selected radio button
      getEmail(form_input, label, name); // Redirect to getEmail function
      alert(`Hello ${name}, you selected: ${selectedGender}`);
    });
  });
}

function getEmail(form_input, label, name) {
  label.innerHTML = `Hello ${name}, please enter your email:`;
  form_input.innerHTML = `
        <label for="email">Email:</label>
        <input type="email" id="email" required>
    `;

  const inputField = document.querySelector("#email");
  inputField.addEventListener("keypress", function (event) {
    if (event.key === "Enter") {
      event.preventDefault();

      const email = inputField.value; // Get the value of the email input
      if (email) {
        if (isValidEmail(email)) {
          alert(`Your email is: ${email}`);
          employee.email = email;
          getPassword(form_input, label, name);
          return;
        } else {
          alert("Please enter a valid email address!");
        }
      } else {
        alert("Enter your email!!");
      }
      getEmail(form_input, label, name);
    }
  });
}

function getPassword(form_input, label, name) {
  label.innerHTML = `Hello ${name}, please enter your password :`;
  form_input.innerHTML = `
        <label for="password">Password:</label>
        <input type="password" id="password" required>
    `;

  const inputField = document.querySelector("#password");
  inputField.addEventListener("input", function () {
    const password = inputField.value;
    const strength = checkPasswordStrength(password);

    // Remove previous strength classes
    inputField.classList.remove("input-weak", "input-medium", "input-strong");

    // Add new strength class
    if (strength === "Strong") {
      inputField.classList.add("input-strong");
    } else if (strength === "Medium") {
      inputField.classList.add("input-medium");
    } else {
      inputField.classList.add("input-weak");
    }
  });
  inputField.addEventListener("keypress", function (event) {
    if (event.key === "Enter") {
      event.preventDefault();
      const password = inputField.value;
      console.log(password); // Get the value of the email input
      if (password) {
        employee.password = password;
        getCNFPassword(form_input, label, name, password);
        return;
      }
      alert("Enter Passowrd!!");
      getPassword(form_input, label, name);
    }
  });
}
function getCNFPassword(form_input, label, name, password) {
  label.innerHTML = `Hello ${name}, please enter your confirm password :`;
  form_input.innerHTML = `
    <label for="cnfpassword">Confirm Password:</label>
    <input type="password" id="cnfpassword" required>
    `;

  const inputField = document.querySelector("#cnfpassword");
  inputField.addEventListener("input", function () {
    const cnfpassword = inputField.value;
    const strength = checkPasswordStrength(cnfpassword);

    // Remove previous strength classes
    inputField.classList.remove("input-weak", "input-medium", "input-strong");

    // Add new strength class
    if (strength === "Strong") {
      inputField.classList.add("input-strong");
    } else if (strength === "Medium") {
      inputField.classList.add("input-medium");
    } else {
      inputField.classList.add("input-weak");
    }
  });
  inputField.addEventListener("keypress", function (event) {
    if (event.key === "Enter") {
      event.preventDefault();
      const cnfPassword = inputField.value; // Get the value of the confirm password input
      if (validatePassword(password, cnfPassword)) {
        alert(`Password entered successfully!`);
        employee.cnfPassword = cnfPassword;
        getMobile(form_input, label, name); // Proceed to the next step
        return;
      }

      alert("Enter your password!!");
      getPassword(form_input, label, name);
    }
  });
}
function getMobile(form_input, label, name) {
  label.innerHTML = `Hello ${name}, please enter your mobile number :`;
  form_input.innerHTML = `
    <label for="mobile">Mobile Number:</label>
    <input type="tel" id="mobile" name="mobile" required>
    <button id="submitBtn">Submit</button>
    `;

  const inputField = document.querySelector("#mobile");
  const submitBtn = document.getElementById("submitBtn");

  // Add event listener for the submit button
  submitBtn.addEventListener("click", function () {
    const mNumber = inputField.value; // Get the value of the mobile input
    if (mNumber) {
      employee.mNumber = mNumber;
      alert(`Your mobile number is ${mNumber}`);
      alert(`Employee Details:\n
              Full Name: ${employee.fullName}\n
              Gender: ${employee.gender}\n
              Email: ${employee.email}\n
              Mobile Number: ${employee.mNumber}\n
              Employee ID: ${employee.empId}\n
              Password: ${employee.password}\n
              Confirm Password: ${employee.cnfPassword}
            `);
      displayVehicle(); // Call displayVehicle here
      // You can add further actions here, like sending the data to a server
    } else {
      alert("Enter your mobile number!!");
      getMobile(form_input, label, name);
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
function validatePassword(password, cnfPassword) {
  // Check if passwords match
  if (password !== cnfPassword) {
    alert("Passwords do not match!");
    return false;
  }

  // Check password strength
  const strength = checkPasswordStrength(password);
  if (strength !== "Strong") {
    alert(
      `Password strength is ${strength}. Please choose a stronger password.`
    );
    return false;
  }

  return true;
}
function checkPasswordStrength(password) {
  let strength = "Weak";
  const lengthCriteria = password.length >= 8;
  const numberCriteria = /[0-9]/.test(password);
  const uppercaseCriteria = /[A-Z]/.test(password);
  const specialCharCriteria = /[!@#$%^&*(),.?":{}|<>]/.test(password);

  if (
    lengthCriteria &&
    numberCriteria &&
    uppercaseCriteria &&
    specialCharCriteria
  ) {
    strength = "Strong";
  } else if (
    lengthCriteria &&
    (numberCriteria || uppercaseCriteria || specialCharCriteria)
  ) {
    strength = "Medium";
  }

  return strength;
}
function isValidEmail(email) {
  // Regular expression for validating an Email
  const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  return emailPattern.test(email);
}
function isValidFullName(name) {
  // Check if the name is at least 2 characters long and does not contain numbers
  const namePattern = /^[A-Za-z\s]+$/; // Allows only letters and spaces
  return name.length >= 2 && namePattern.test(name);
}

const vehicle = {};

function displayVehicle() {
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

      const name = inputField.value; // Get value from the input field
      console.log(name);
      if (name) {
        vehicle.fullName = name; // Save manufacturer name to vehicle object
        getType(form_input, label); // Proceed to getType
        return;
      }

      alert("Enter name !!");
    }
  });
}

function getType(form_input, label) {
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

function getVehicleNumber(form_input, label) {
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
function getEmpId(form_input, label) {
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

const pricing = {
  "Cycle": {
    daily: 5,
    monthly: 100,
    yearly: 500,
  },
  "Two Wheeler": {
    daily: 10,
    monthly: 200,
    yearly: 1000,
  },
  "Four Wheeler": {
    daily: 20,
    monthly: 500,
    yearly: 3500,
  },
};

const setImage = (type) => {
  const image = document.getElementById("pricing_vehicle");

  if (type == "Cycle") {
    image.src = "cycle.png";
  } else if (type == "Two Wheeler") {
    image.src = "bike.png";
  } else if ((type = "Four Wheeler")) {
    image.src = "car.png";
  }
};
const subscriptionPlan={};
const displayPricing = () => {
  document.querySelector("#vehicle").classList.add("hidden");
  const vehicle_type = vehicle.type;
  document.querySelector(".title").innerHTML = vehicle_type;
  setImage(vehicle_type);
  let pricingMenuHTML = `<select id='type' required>
  <option value='' disabled>--Select Subscription Duration--</option>`;

if (vehicle_type === "Cycle") {
  pricingMenuHTML += `
      <option value="daily" data-price="${pricing.Cycle.daily}">Daily : ${pricing.Cycle.daily}</option>
      <option value="monthly" data-price="${pricing.Cycle.monthly}">Monthly : ${pricing.Cycle.monthly}</option>
      <option value="yearly" data-price="${pricing.Cycle.yearly}">Yearly : ${pricing.Cycle.yearly}</option>`;
} else if (vehicle_type === "Two Wheeler") {
  pricingMenuHTML += `
      <option value="daily" data-price="${pricing["Two Wheeler"].daily}">Daily : ${pricing["Two Wheeler"].daily}</option>
      <option value="monthly" data-price="${pricing["Two Wheeler"].monthly}">Monthly : ${pricing["Two Wheeler"].monthly}</option>
      <option value="yearly" data-price="${pricing["Two Wheeler"].yearly}">Yearly : ${pricing["Two Wheeler"].yearly}</option>`;
} else if (vehicle_type === "Four Wheeler") {
  pricingMenuHTML += `
      <option value="daily" data-price="${pricing["Four Wheeler"].daily}">Daily : ${pricing["Four Wheeler"].daily}</option>
      <option value="monthly" data-price="${pricing["Four Wheeler"].monthly}">Monthly : ${pricing["Four Wheeler"].monthly}</option>
      <option value="yearly" data-price="${pricing["Four Wheeler"].yearly}">Yearly : ${pricing["Four Wheeler"].yearly}</option>`;
}

pricingMenuHTML += `</select>`;
document.querySelector(".pricing-menu").innerHTML = pricingMenuHTML;


  
  const selectedPlan = document.querySelector('option[value=""]');
  const selectedValue = selectedPlan.value;
  const selectedOption = selectedPlan.options[selectedPlan.selectedIndex];

  if (selectedValue) {
      const price = selectedOption.getAttribute('data-price');
      subscriptionPlan.vehicleType = vehicle_type;
      subscriptionPlan.planType = selectedValue;
      subscriptionPlan.price = price;
      
    } else {
      alert("Please select a subscription duration!");
    }
    
  };
  const  onButtonClick = () => {
    // Log the subscription plan for verification
    console.log(subscriptionPlan);
  alert(`Subscription Plan Saved:\nVehicle Type: ${subscriptionPlan.vehicleType}\nPlan Type: ${subscriptionPlan.planType }\nPrice: ${      subscriptionPlan.price}`);
};
