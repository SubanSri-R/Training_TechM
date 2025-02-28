// let person={
//     firstName:"John",
//     age:"22",
//     greet:function(){
//         return ("hello "+this.firstName);
// }};
// console.log(person.greet());


// let car={}

// car.name = "bmw";
// car.clr="black";
// car.show =function(){
//     return ("car is of color"+this.clr)

// }
// console.log(car.name)
// console.log(car.show())



// let age = person.age;
// console.log(person.firstName + " is " + person.age + " years //old.");


// let age = person["age"];
// console.log(person["firstName"] + " is " + person["age"] + " years old.");


// let x = "firstName";
// let y = "age";
// console.log(person[x] + " is " + person[y] + " years old.");

// person.nationality = "English";
// console.log(person);

// delete person.age;
// console.log(person);


// Nested Objects
myObj = {
  name:"John",
  age:30,
  myCars: {
    car1:"Ford",
    car2:"BMW",
    car3:"Fiat"
  }
}

// var car = myObj.myCars.car3;
// console.log(car)

// console.log(myObj.myCars["car2"]);

// console.log(myObj["myCars"]["car2"]);

// let p1 = "myCars";
// let p2 = "car2";
// console.log(myObj[p1][p2]);
const person = {


  firstName: "John",
  lastName: "Doe",
  id: 5566,
  fullName: function() {
    return this.firstName + " " + this.lastName;
  }
};

// name = person.fullName();
// console.log("Full name: "+person.fullName())
// console.log("fullName function definition: "+person.fullName());


person.name1 = function () {
  return this.firstName + " " + this.lastName;
};

person.name2 = function () {
  return (this.firstName + " " + this.lastName).toUpperCase();
};
console.log(person.name1())
console.log(person.name2())
console.log("name1 function definition: "+person.name1);
console.log("name2 function definition: "+person.name2);

delete person.name1;

// document.getElementById("demo").innerHTML = person;

// document.getElementById("demo").innerHTML =
// person.name + "," + person.age + "," + person.city;