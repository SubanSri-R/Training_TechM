let start = 10 
let end = start + 50 

let num = start
while (num <= end) {
if (num % 5 === 0) {
    num++
    continue

  }
  console.log(num)
  num++;
}