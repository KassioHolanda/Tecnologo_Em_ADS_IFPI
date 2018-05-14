#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <iostream>
using namespace std;

class No{
	public:
		int mat;
		char nome[23];
		No *prox; 
		No(int m,char n[23]){
			mat=m;
			strcpy(nome,n);
			prox=NULL;
		}
};

class Lista{
	public:
		No *inicio;
		No *fim;
	
	    Lista(){
	    	inicio = NULL;
	    	fim = NULL;
		}	
		
		
		void addToFinal(int m, char n[23]){
			No *novo = new No(m, n);
			
			novo->mat = m;
			strcpy(novo->nome, n);
			novo->prox = NULL;
			
			if (inicio == NULL){
				inicio = novo;
				fim = novo;
			}else{ 
				fim->prox = novo;
				fim = novo;
			}
		
		}
		
		void addToInicio(int m,char n[23]){
			No *novo = new No(m, n);
			
			novo->mat = m;
			strcpy(novo->nome, n);
			novo->prox = NULL;
			
			if (inicio == NULL){
				inicio=novo;
				fim=novo;
			} else { 
				novo->prox=inicio;
				inicio=novo;
			}	
		}
		

		void mostra(){
			No *Atual = inicio;
			while (Atual != NULL){
				cout<<"\n\n Nome: "<< Atual->nome;
				cout<<"\n Matricula: "<< Atual->mat;
				
				Atual = Atual->prox;	
			}
		}

		
};

main(){
   Lista *l=new Lista();
   
   cout<<"Adicionando no inicio";
   l->addToInicio(1, "KASSIO LUCAS");
   l->addToInicio(2, "KAIO LUCAS");
   l->addToInicio(3, "KARLOS JORDANO");
   
   l->mostra();
   cout<<"\n\n\nAdicionando no final";
   
   
   l->addToFinal(4, "KATIA SOLANGE");
   l->addToFinal(5, "JOSIAS LUCAS");
   l->addToFinal(6, "HOLANDA LEODIDO");
   
   l->mostra();
   cout<<"\n\n";
   
}

