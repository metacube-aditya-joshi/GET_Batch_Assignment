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
        if(name.length<=2){
          var ele=document.getElementById("fullName");
        const custom_style={
            color: "red"
        }
        Object.assign(ele.style,custom_style);
        return;
      }
        
       
        
        console.log(name);
        if (name) {
           alert(`Hi ${name}! Can I know your gender?`);
           document.querySelector("#genderContainer").classList.remove('hidden')
           getGender();
        }
    }
});

function getGender(){
  
  document.querySelectorAll('input[name="gender"]').forEach(radio => {
    radio.addEventListener('change', function () {           
             getEmail();
    });
})
}

function getEmail(){
  
  document.querySelector('#email')

    alert('email fetched');
}
