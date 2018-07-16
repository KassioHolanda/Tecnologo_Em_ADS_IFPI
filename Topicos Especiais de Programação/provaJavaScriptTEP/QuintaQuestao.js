console.log(laugh(3));

function laugh(risos) {
    r = risos;
    var risada = "";
    while (r > 0) {
        risada += "ha";
        r--;
    }
    return risada;
}