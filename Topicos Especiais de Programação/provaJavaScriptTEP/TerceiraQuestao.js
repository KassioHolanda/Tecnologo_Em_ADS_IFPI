var assentos = 100;
var fileiras = 25;


function assentosFileiras(assentos, fileiras){
    count = assentos/fileiras;
    for(i=0;i<fileiras;i++){
        count = 0;
        while(count< assentos/fileiras){
            console.log(i+"-"+count);
            count++;
        }
    }
}