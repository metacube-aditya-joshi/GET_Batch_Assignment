import { subscriptionPlan } from "./pricing.js"
const displaySubscriptionPlan=()=>{
    document.querySelector('#pricing').classList.add('hidden');
    const subscribedDiv = document.querySelector('.subscribed');
    subscribedDiv.innerHTML=`
    <h3> Subscription Plan</h3>
    <p>Vehicle Type : ${subscriptionPlan.vehicleType}</p>
    <p>Plan Type: ${subscriptionPlan.planType}</p>
    <p>Price: ${subscriptionPlan.price}</p>
    `
}
export {displaySubscriptionPlan};
