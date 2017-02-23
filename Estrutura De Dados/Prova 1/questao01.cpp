#include  <stdio.h>
#include <iostream>
#include <string>
using namespace std;
 struct livro {
     int cod;
     string nome;
       };
typedef struct livro Tlivro;
Tlivro livros[5];
int ultimo = 0;

void inserir2(Tlivro novo){
	if(ultimo<5){
		int p;
		p=-1;  // comentario01:
		if(ultimo==0){ //comentario02:
			livros[0]=novo;
			ultimo++;
		}
		else{  // comentario03:
			for(int i=0;i<ultimo;i++){
				if(novo.cod<livros[i].cod){ // comentario04:
		 			p=i;
					break;
				}
			}
			//testando o valor de p encontrado
		           if (p==-1) {// comentario05:
		               livros[ultimo]=novo;
			   ultimo++;
		          } 
		         else{  // comentario06:
			   for(int i=ultimo;i>p;i--){
			    livros[i]=livros[i-1];
			 }
			 livros[p]=novo;
			 ultimo++;
		        }
	         }
	}
	else{
		printf("\nBiblioteca lotada");
	}
}




void inserir(Tlivro novo){
	if (ultimo<5){
		livros[ultimo].cod = novo.cod;
		livros[ultimo].nome= novo.nome;
		ultimo++;
	}
	else {
	  printf("\nBiblioteca lotada!!!");	
	}
      	
       }

int buscar(int codigo){
	int p=-1;
	for(int i=0;i<ultimo;i++){
		if(livros[i].cod==codigo){
			p=i;
			break;
		}
	}
	return p;
}
void mostra(){
	for(int i=0;i<ultimo;i++){
		printf("\nCodigo do livro: %d",livros[i].cod);
		cout<<"\nNome do livro:"<<livros[i].nome;
	}
}

void furafila(Tlivro novo, int posicao){
	if(ultimo>=5){
		printf("Biblioteca lotada");
	}
	else{
		for(int i=ultimo;i>posicao;i--){
			livros[i].cod=livros[i-1].cod;
			livros[i].nome=livros[i-1].nome;
		}
		livros[posicao]=novo;
		ultimo++;
	}
}

void remover(int posicao){
	int i;
	if(posicao > ultimo){
		cout<<"\nNao tem elemento nesse indice\nNao foi retirado nenhum item\n";
	} else {
		for(i = posicao; i < ultimo; i++){
	   		livros[i] = livros[i+1];	
		}
		ultimo--;
	}

}

main(){

	Tlivro novo;
	novo.cod=8;
	novo.nome="Aprendendo a programar em C";
	inserir2(novo);
	novo.cod=6;
	novo.nome="Fundamentos em Estrutura de Dados";
	inserir2(novo);
	novo.cod=10;
    novo.nome="Aprendendo a Programar em Python\n";
	inserir2(novo);
    mostra();
    
    
    //RESPOSTA
    cout<<"\n";
    remover(4);
    mostra();
    
}





