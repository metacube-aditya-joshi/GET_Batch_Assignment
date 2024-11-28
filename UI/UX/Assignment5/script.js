const myElement = document.querySelector('.leftbar');
const addClassButton = document.querySelector('.collpase-bt');
let ifnull = false;
addClassButton.addEventListener('click', function() {
    // console.log(myElement);
    // Append the class name
    if (!ifnull) {
        myElement.classList.add('just-append');
        document.getElementById('navigation').style.display = 'none';
        document.getElementById('apps').style.display = 'none';
        document.getElementById('custom').style.display = 'none';
        document.getElementById('custom_left_side').style.width = '3.5vw';
        document.getElementById('logodiv').style.display = 'none';
        document.getElementById('closedbar').style.display = 'block';
        ifnull = !ifnull;
    }else{
        myElement.classList.remove('just-append');
        document.getElementById('navigation').style.display = 'block';
        document.getElementById('apps').style.display = 'block';
        document.getElementById('custom').style.display = 'block';
        document.getElementById('custom_left_side').style.width = '20vw';
        document.getElementById('logodiv').style.display = 'block';
        document.getElementById('closedbar').style.display = 'none';
        
        ifnull = !ifnull;
    }
});