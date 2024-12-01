document.querySelectorAll('.collapsible-header').forEach((header) => {
    header.addEventListener('click', () => {
      const body = header.nextElementSibling;
      const isVisible = body.style.display === 'flex';
      body.style.display = isVisible ? 'none' : 'flex';
    });
  });




  document.getElementById('fullName').addEventListener('keypress', function (event) {
   
    if (event.key === 'Enter') {
      
        event.preventDefault();
        const name = this.value;    
        console.log("entered name section");
        console.log(name);
        if (name) {
           alert(`Hi ${name}! Can I know your gender?`);
           document.querySelector("#genderContainer").classList.remove('hidden')
           document.querySelector(".nameContainer").classList.add('hidden')
           getGender();
        }
    }
});

function getGender(){
  
  document.querySelectorAll('input[name="gender"]').forEach(radio => {
    radio.addEventListener('change', function () {  
      alert("gender submitted");       
      document.querySelector(".emailContainer").classList.remove('hidden')  
      document.querySelector("#genderContainer").classList.add('hidden')
      document.addEventListener('DOMContentLoaded', function() {

        getEmail();
      });
    });
})
}

function getEmail(){
  
  document.querySelector('#email').addEventListener('keypress',function(event){
      console.log("entered email section!!");
    if (event.key === 'Enter') {
      event.preventDefault();
      const email = this.value;     
      console.log(email);
      if (email) {
         alert(`your email is : ${email}!!`);
         document.querySelector(".passwordContainer").classList.remove('hidden');
         document.querySelector(".emailContainer").classList.add('hidden')  ;
      }else{
        alert('enter email');
      }
  }
});    
}

function getPasswordAndCNFPassword(){
  document.querySelector('#password').addEventListener('keypress',function(){
    console.log("password : "+this.value );
  })
  
  document.querySelector('#cnfpassword').addEventListener('keypress',function(){
    console.log("confirm password : "+this.value );
  })
}