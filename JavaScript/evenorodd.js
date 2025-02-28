// function sumofdigit(num){
//     var it=0
//     while(num>0)
// {
//     it+=num%10
//     num=Math.floor(num/10)

// }return it

// }
// var num1=sumofdigit(299)
// if (num1%2==0){
//     console.log("even")
// }
// else{
//     console.log("odd")
// }

function sumofval(num3){
    if (num3<1)
        return 0;

    var ite=0
    ite=num3%10
    num3=Math.floor(num3/10)
    return ite+sumofval(num3)
}
var x=sumofval(122)

if (x%2==0){
    console.log("even")
}
else{
    console.log("odd")
}