let firstNumber = 7 
let secondNumber = 20 
let thirdNumber = secondNumber + 40 

let num = secondNumber
while (num <= thirdNumber) {
  if (num % firstNumber === 0) {
    console.log(num)
  }
  num++
}