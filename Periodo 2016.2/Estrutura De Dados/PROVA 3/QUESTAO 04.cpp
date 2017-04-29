#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <math.h>
#include <iostream>
using namespace std;
class No
{
public:
	char nome;
	No *left;
	No *right;
	No(char n)
	{
		nome = n;
		left = NULL;
		right = NULL;
	}
};

class Arvore
{
public:
	No *raiz;
	int h, quantNos;

	Arvore(){
		raiz = NULL;
		h = -1;
		quantNos = 0;
	}

	int isEmpty(){
		return (raiz == NULL);
	}


	void criaNo(char n) {
		No *novo = new No(n);
		insere2(raiz, novo);
	}


	No *insere2(No *arv, No *n) {
		if (isEmpty() == 1) //raiz nula, arvore vazia
			raiz = n;
		else{
			if (arv != NULL){
				if (arv->nome < n->nome){
					if (arv->right == NULL){
						arv->right = n;
					}
					else
						return insere2(arv->right, n);
				}
				if (arv->nome > n->nome){

					if (arv->left == NULL){
						arv->left = n;
					}
					else
						return insere2(arv->left, n);
				}

			}
		}
	}


	No *procura(No *arv, char busca){
		if(arv == NULL){
			return NULL;
		} else {
			if (arv->nome == busca){
				return arv;
			} else {
				if(arv->nome > busca){
					return procura(arv->left, busca);
				} 
				if(arv->nome < busca){
					return procura(arv->right, busca);
				}	
			}
			
		}
		
	}

	void consultarExistenciaDeNo(No *arv, char busca) {	
		if(procura(arv, busca) != NULL) {
			cout << "\nVoce pesquisou pelo NO: " << procura(arv, busca)->nome;
		} 
		if (procura(arv, busca) == NULL){
			cout <<"\nO NO: "<< busca<<" procurado nao existe na arvore\n";
		}
	}

	void imprime(No *n) {

		if (raiz == NULL){
			cout << "\n <VAZIO>";
		} else {
			if (n != NULL) {
				cout << "<" << n->nome;
				imprime(n->left);
				imprime(n->right);
				cout << ">";
			}
			else
				cout << "<>";
		}
	}

};
main() {
	Arvore *arvore = new Arvore();
	arvore->criaNo('B');
	arvore->criaNo('A');
	arvore->criaNo('D');
	arvore->criaNo('C');
	arvore->criaNo('F');
	arvore->criaNo('M');
	arvore->imprime(arvore->raiz);

// 	PROCURAR NO EXISTENTE
	arvore->consultarExistenciaDeNo(arvore->raiz, 'M');


// 	PROCURAR NO QUE NAO EXISTENTE
	arvore->consultarExistenciaDeNo(arvore->raiz, 'Z');	



}

