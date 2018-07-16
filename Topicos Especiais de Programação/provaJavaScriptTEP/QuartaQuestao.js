function JuliaJames() {
    for (var i = 0; i < 1000; i++) {
        if ((i % 3) == 0 && (i % 5) != 0) {
            console.log('Julia')
        }
        if ((i % 5) == 0 && (i % 3) != 0) {
            console.log('James')
        }
        if ((i % 5) == 0 && (i % 3) == 0) {
            console.log('JuliaJames')
        }
        if ((i % 5) != 0 && (i % 3) != 0) {
            console.log(i)
        }
    }
}

JuliaJames();