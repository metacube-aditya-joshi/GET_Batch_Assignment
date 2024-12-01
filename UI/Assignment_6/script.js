const employee={};

(function displayEmp() {
  const form_input = document.querySelector("#employee .form-input");
  const label = document.querySelector("#employee .form-label");
  form_input.innerHTML =
    "<input type='text' id='fullName' placeholder='Full Name' required />";
  label.innerHTML = '<label for="fullName">Enter Full Name:</label>';

  const inputField = document.querySelector("#fullName");
  inputField.addEventListener("keypress", function (event) {
    if (event.key === "Enter") {
      event.preventDefault();

      const name = inputField.value; // Get value from the input field
      console.log(name);
      if (name) {
        employee.fullName=name;
        getGender(form_input, label, name); // Pass the name to getGender
        return;
      }

      alert("Enter name !!");
      displayEmp();
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
      employee.gender=selectedGender; // Get the value of the selected radio button
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
        alert(`Your email is: ${email}`);
        employee.email=email;
        getPassword(form_input, label, name);
        return;
      }

      alert("Enter your email!!");
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
  inputField.addEventListener("keypress", function (event) {
    if (event.key === "Enter") {
      event.preventDefault();

      const password = inputField.value;

      console.log(password); // Get the value of the email input
      if (password) {
       employee.password=password;
        getCNFPassword(form_input, label, name);
        return;
      }
      alert("Enter Passowrd!!");
      getPassword(form_input,label,name);
    }
  });
}
function getCNFPassword(form_input, label, name) {
    label.innerHTML = `Hello ${name}, please enter your confirm password :`;
    form_input.innerHTML = `
    <label for="cnfpassword">Confirm Password:</label>
    <input type="password" id="cnfpassword" required>
    `;
    
    const inputField = document.querySelector("#cnfpassword");
    inputField.addEventListener("keypress", function (event) {
      if (event.key === "Enter") {
        event.preventDefault();
    
        const cnfPassword = inputField.value; // Get the value of the email input
        if (cnfPassword) {
          alert(`password entered successfully!!`);
          employee.cnfPassword=cnfPassword;
          getMobile(form_input, label, name);
          return;
        }
    
        alert("Enter your password!!");
        getCNFPassword(form_input, label, name);
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


  const vehicle = {}; // Object to store vehicle details

function displayVehicle() {
  document.querySelector('#employee').classList.add('hidden');
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
      <option value='None'>None</option>
    </select>`;

  const selectElement = document.getElementById("type");
  
  // Add an event listener for the 'change' event
  selectElement.addEventListener("change", function () {
    const selectedValue = selectElement.value; // Get the selected value
    if (selectedValue) {
      vehicle.type = selectedValue; // Save vehicle type to vehicle object
      alert('Type of vehicle selected: ' + selectedValue);
      getVehicleNumber(form_input, label); // Proceed to getVehicleNumber
    } else {
      alert('Please select the type of vehicle.'); // Prompt if no selection
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
        alert('Vehicle number entered: ' + vehicleNumber);
        getEmpId(form_input,label);
        // You can proceed with further actions here
      } else {
        alert('Please enter the vehicle number.');
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
          alert(`Vehicle Manufacterer Name : ${vehicle.name}`+
            `Vechile type : ${vehicle.type}`+
            `Vehicle number : ${vehicle.vehicleNumber}`+
            'Employee ID entered: ' + vehicle.empId);
          // You can proceed with further actions here
      } else {
          alert('Please enter the Employee ID.');
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




// Call the displayVehicle function to start the process
