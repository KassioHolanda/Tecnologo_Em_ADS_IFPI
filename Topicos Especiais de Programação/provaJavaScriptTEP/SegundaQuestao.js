//Segunda Questão

function quantidadeIntegrantes(quantidade) {
    if (quantidade == 1) {
        console.log('Solo');
    } else if (quantidade == 2) {
        console.log('Duet')
    } else if (quantidade == 3) {
        console.log('Trio')
    } else if (quantidade == 4) {
        console.log('Quartet')
    } else if (quantidade == 0) {
        console.log('Not a Group')
    } else if (quantidade > 4) {
        console.log('This is a Large Group')
    }
}

quantidadeIntegrantes(2);