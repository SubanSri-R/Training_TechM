let student={
    id:1,
    name: 'AAA',
    email:'AAA@example.com',
    department: 'cse',
    college:'PIT'
}

let display=function(){
console.log(`student name = ${student.name}`)
console.log(`student email = ${student.email}`)
console.log(`student department = ${student.department}`)
console.log(`student college = ${student.college}`)
}
display()

student.address ={
    doorno:33,
    street:"jpr",
    area:"poonamalle",
    pincode:600123
}
function display1(){
    console.log(`\nupdate student address`)
    console.log(`student id = ${student.id}`)
    console.log(`student name = ${student.name}`)
    console.log(`student email = ${student.email}`)
    console.log(`student department = ${student.department}`)
    console.log(`student college = ${student.college}`)
    console.log(`student address = ${student.address.doorno},${student.address.street},${student.address.area},${student.address.pincode}`)

    }
    display1()

    delete student.email
    delete display
    console.log(student)
    