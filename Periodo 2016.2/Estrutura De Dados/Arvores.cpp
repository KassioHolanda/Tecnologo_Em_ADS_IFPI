#include <stdio.h>
#include <iostream>
#include <stdlib.h>

using namespace std;

class No {
	public:
		char info;
		No *esq;
		No *dir;
		
		No(char info, No *esq, No *dir){
			this->info = info;
			this->esq = esq;
			this->dir = dir;
		}
};

class Arvore{
	
	public:
	
		No *raiz;
		
		Arvore(){
			raiz = NULL;
		}
		
		No *cria_vazia(){
			return NULL;
		}
		
		No *cria_No(char n, No *esq, No *dir){
			No *novo = new No(n, esq, dir);
			return novo;
		}
		
		No *cria_Raiz(char n, No *esq, No *dir){
			No *novo = new No(n, esq, dir);
			raiz = novo;
			return novo;
		}
		
		
		void insere(No *arv, No *novo, int lado, char pai){
			
			if(arv!=NULL){
				
				if(arv->info == pai){
					
					if(lado == 1){
						if(arv->esq == NULL){
							arv->esq = novo;
						} else {
							cout<<"\nERRO - ja existe um No nessa posição";
						}
					
					} if (lado == 2){
						if(arv->dir == NULL){
							arv->dir = novo;
						} else {
							cout<<"\nERRO - ja existe um No nessa posição";
						}
					}
						
				} else {
					insere(arv->esq, novo, lado, pai);
					insere(arv->dir, novo, lado, pai);
				}
			}
		}
		
		void imprime(No *n){
			if(raiz == NULL){
				cout<<"\n <VAZIO>";
			} else {
				if(n != NULL ){
					cout<<"<"<<n->info;
					imprime(n->esq);
					imprime(n->dir);
					cout<<">";
				} else {
					cout<<"<>";
				}
			}
		}
		
		int altura(No *arv){
			if(arv == NULL){
				return -1;
			} else {
				int altura_esquerda = altura(arv->esq);
				int altura_direita = altura(arv->dir);
				if(altura_esquerda < altura_direita){
					return altura_direita + 1;
				} else {
					return altura_esquerda + 1;
				}
			}
		}
		
};


int main(){
	
	Arvore *arv = new Arvore();	
	arv->cria_vazia();
	No *raiz = arv->cria_Raiz('r', NULL, NULL);
	
	No *no_a = arv->cria_No('a', NULL, NULL);
	No *no_b = arv->cria_No('b', NULL, NULL);

	No *no_c = arv->cria_No('c', NULL, NULL);
	No *no_d = arv->cria_No('d', NULL, NULL);
	No *no_e = arv->cria_No('e', NULL, NULL);
	No *no_f = arv->cria_No('f', NULL, NULL);	
	
	cout<<"Imprimindo a arvore\n";
	arv->imprime(raiz);
	
	cout<<"\n\nImprimindo a arvore apos criar novo elemento e inseri-lo\n";
	
	//adicionando na raiz
	arv->insere(raiz, no_a, 1, raiz->info);
	arv->insere(raiz, no_b, 2, raiz->info);
	
	//adicionando no no A
	arv->insere(no_a, no_c, 1, no_a->info);
	arv->insere(no_a, no_d, 2, no_a->info);
	
	//adicionando no no B
	arv->insere(no_b, no_e, 1, no_b->info);
	arv->insere(no_b, no_f, 2, no_b->info);
	
	arv->imprime(raiz);
	
	//tamanho da arvore
	cout<<"\nTamanho da arvore: ";
	arv->altura(raiz);
	cout<<"\n";
	
		
}