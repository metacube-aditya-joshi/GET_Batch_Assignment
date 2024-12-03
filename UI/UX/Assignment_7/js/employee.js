import { displayVehicle } from "./vehicle.js";
const employee={};
document.querySelectorAll(".collapsible-header").forEach((header) => {
  header.addEventListener("click", () => {
    const body = header.nextElementSibling;
    const isVisible = body.style.display === "flex";
    body.style.display = isVisible ? "none" : "flex";
  });
});

const displayEmployee = ()=> {
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
};

const getGender=(form_input, label, name) =>{
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

const getEmail=(form_input, label, name) =>{
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

const getPassword=(form_input, label, name) =>{
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
const getCNFPassword=(form_input, label, name, password)=> {
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
const getMobile=(form_input, label, name)=>{
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
const validatePassword=(password, cnfPassword)=>{
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
const checkPasswordStrength=(password) =>{
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

export  {employee,displayEmployee} ;
