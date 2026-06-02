console.log("Welcome to Community Portal");

window.onload = function(){
    alert("Page Loaded");
};

const events = [
    {name:"Music Fest", category:"Music"},
    {name:"Baking Workshop", category:"Workshop"},
    {name:"Sports Day", category:"Sports"}
];

const container =
document.querySelector("#eventContainer");

events.forEach(event => {

    const card =
    document.createElement("div");

    card.className = "eventCard";

    card.innerHTML =
    `
    <h3>${event.name}</h3>
    <button onclick="registerUser()">
    Register
    </button>
    `;

    container.appendChild(card);
});

function registerUser(){
    alert("Registration Successful");
}

document
.getElementById("registerForm")
.addEventListener("submit", function(e){

    e.preventDefault();

    document.getElementById("result")
    .innerHTML =
    "Registration Completed Successfully";

    const eventType =
    document.getElementById("eventType").value;

    localStorage.setItem(
    "event",
    eventType
    );
});

function validatePhone(){

    let phone =
    document.getElementById("phone").value;

    if(phone.length != 10){
        alert("Enter Valid Phone Number");
    }
}

function countChars(){

    let len =
    document.getElementById("feedback")
    .value.length;

    document.getElementById("count")
    .innerHTML = len;
}

function videoReady(){

    document.getElementById("videoMsg")
    .innerHTML =
    "Video Ready To Play";
}

window.onbeforeunload =
function(){
    return "Form not completed";
};

function findLocation(){

    if(navigator.geolocation){

        navigator.geolocation
        .getCurrentPosition(

        function(position){

            document
            .getElementById("location")
            .innerHTML =

            "Latitude : "
            + position.coords.latitude +

            "<br>Longitude : "
            + position.coords.longitude;
        },

        function(error){

            alert(
            "Location Access Denied"
            );
        },

        {
            enableHighAccuracy:true
        });
    }
}

function clearData(){

    localStorage.clear();
    sessionStorage.clear();

    alert("Preferences Cleared");
}