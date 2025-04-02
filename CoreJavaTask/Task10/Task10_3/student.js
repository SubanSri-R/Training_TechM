let student = {
    name: prompt("Enter student name:"),
    age: parseInt(prompt("Enter student age:")),
    grade: prompt("Enter student grade:"),
    displayDetails: function () {
        return `Student Name: ${this.name} <br> Age: ${this.age} <br> Grade: ${this.grade}`;
    },

    address: {
        city: prompt("Enter city name:"),
        country: "India",
        displayAddress: function () {
            return `City: ${this.city} <br> Country: ${this.country}`;
        },
        updateCity: function (newCity) {
            this.city = newCity;
            return `City updated to: ${this.city}`;
        }
    }
};

let output = "Initial Student Details:<br>";
output += student.displayDetails() + "<br>";
output += student.address.displayAddress() + "<br><br>";

let newCity = prompt("Enter a new city name to update:");
output += student.address.updateCity(newCity) + "<br><br>";

delete student.grade;
delete student.displayDetails;

output += "Updated Student Details after removal:<br>";
output += `Name: ${student.name} <br> Age: ${student.age} <br> <br>`;
output += `Address: ${student.address.displayAddress()}<br><br>`;

output += student.displayDetails ? student.displayDetails() : "displayDetails function has been removed.<br>";
output += `Grade after removal: ${student.grade ? student.grade : "Removed"}<br>`;

document.getElementById('output').innerHTML = output;
