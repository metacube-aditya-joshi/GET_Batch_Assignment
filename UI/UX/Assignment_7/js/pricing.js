import { vehicle } from "./vehicle.js";
const pricing = {
    Cycle: {
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
  const subscriptionPlan = {};
  const displayPricing = () => {
    document.querySelector("#vehicle").classList.add("hidden");
    document.querySelector('.pricing-card').classList.remove('hidden');
    const vehicle_type = vehicle.type;
    document.querySelector(".title").innerHTML = vehicle_type;
    setImage(vehicle_type);
    let pricingMenuHTML = `<select id='type'  class="dropdown" required>
    <option value='' class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false" disabled>--Select Subscription Duration--</option>`;
  
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
  
    console.log(document.querySelector("#type").value);
  
    const selectedPlan = document.querySelector("#type");
    selectedPlan.addEventListener("change", function () {
      const selectedValue = selectedPlan.value;
      const selectedOption = selectedPlan.options[selectedPlan.selectedIndex];
      console.log(selectedOption);
      if (selectedValue) {
        const price = selectedOption.getAttribute("data-price");
        subscriptionPlan.vehicleType = vehicle_type;
        subscriptionPlan.planType = selectedValue;
        subscriptionPlan.price = price;
      } else {
        alert("Please select a subscription duration!");
      }
    });
  };
  const onButtonClick = () => {
  
    console.log(subscriptionPlan);
    alert(
      `Subscription Plan Saved:\nVehicle Type: ${subscriptionPlan.vehicleType}\nPlan Type: ${subscriptionPlan.planType}\nPrice: ${subscriptionPlan.price}`
    );
  };

  window.onButtonClick = onButtonClick;
  export {subscriptionPlan,displayPricing,onButtonClick};