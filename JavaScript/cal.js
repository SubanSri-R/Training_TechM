var x=10
var y=2
var choice =1



calcir=()=>{
    
    switch (choice) {
        case 1:
            {
                ans=(x,y)=>x+y
                console.log(ans(x,y))
            }
            break
        case 2:
            {
                ans=(x,y)=>x-y
                console.log(ans(x,y))
            }break
        case 3:
            {
            ans=(x,y)=>x*y
            console.log(ans(x,y))
            }break
        case 4:
            {
                ans=(x,y)=>x/y
                console.log(ans(x,y))
            }break
        case 5:
            {
                ans=(x,y)=>x%y
                console.log(ans(x,y))
            }break
        default:
            console.error("Invalid choice")
    
        }
};
calcir()