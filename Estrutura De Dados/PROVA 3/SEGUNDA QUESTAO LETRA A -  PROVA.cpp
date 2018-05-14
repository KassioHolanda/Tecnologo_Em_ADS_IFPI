#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <math.h>
#include <iostream>

using namespace std;

class No {
public:
	int valor;
	No *left;
	No *right;
	No(int n) {
		valor = n;
		left = NULL;
		right = NULL;
	}
};
class Arvore {
public:
	No *raiz;
	int quantNos;

	Arvore() {
		raiz = NULL;
		quantNos = 0;

	}


	int isEmpty() {
		return (raiz == NULL);
	}


	void criaNo(int n) {
		No *novo = new No(n);
		insere(raiz, novo);
	}

	void insere(No *arv, No *n) {
		if (isEmpty() == 1) //raiz nula, arvore vazia
			raiz = n;
		else {
			if (arv != NULL) {

				if (n->valor > arv->valor) {
					if (arv->right == NULL) {
						arv->right = n;
					} else
						insere(arv->right, n);
				} if (n->valor < arv->valor) {

					if (arv->left == NULL) {
						arv->left = n;
					} else
						insere(arv->left, n);
				}
			}
		}
	}

	int calculaqtdNos(No *arv) {
		if(arv == NULL) {
			return 0;
		} else {
			int quantNos = 1;
			quantNos += calculaqtdNos(arv->left);
			quantNos += calculaqtdNos(arv->right);
			return quantNos;
		}
	}

	No *procuraPai(No *arv, int valor) {
		
		if(arv == NULL) {
			return NULL;
			
		} else {
			if(arv != NULL) {
				if(arv->left->valor == valor) {
					return arv;
				}
				
				if(arv->valor == valor){
					return arv;
				}
					
				if(arv->right->valor == valor) {
					return arv;
				} else {
					if(arv->valor > valor) {
						return procuraPai(arv->left, valor);
					}
					if(arv->valor < valor) {
						return procuraPai(arv->right, valor);
					}
				}
			}
		}
	}	

	void imprime_pre_ordenado(No *n) {
		if(raiz == NULL) {
			cout << "\n <VAZIO>";
		} else {
			if(n != NULL ){
				cout << "<" << n->valor;
				imprime_pre_ordenado(n->left);
				imprime_pre_ordenado(n->right);
				cout << ">";
			} else {
				cout << "<>";
			}
		}
	}

	void imprime_simatrica(No *n) {
		if(raiz == NULL) {
			cout << "\n <VAZIO>";
		} else {
			if(n != NULL ) {
				cout << "<";
				imprime_simatrica(n->left);
				cout << n->valor;
				imprime_simatrica(n->right);
				cout << ">";
			} else {
				cout << "<>";
			}
		}
	}

	void imprime_pos_ordem(No *n) {
		if(raiz == NULL) {
			cout << "\n <VAZIO>";
		} else {
			if(n != NULL ) {
				cout << "<";
				imprime_pos_ordem(n->left);
				imprime_pos_ordem(n->right);
				cout << n->valor;
				cout << ">";
			} else {
				cout << "<>";
			}
		}
	}
};

main()
{
	Arvore *arv = new Arvore();

	arv->criaNo(6);
	arv->criaNo(2);
	arv->criaNo(1);
	arv->criaNo(4);


//	IMPRIMINDO
	cout << "\nImprimindo ordem: Pre-Ordem\n";
	arv->imprime_pre_ordenado(arv->raiz);
	cout << "\n\nImprimindo ordem: Ordem Simetrica\n";
	arv->imprime_simatrica(arv->raiz);
	cout << "\n\nImprimindo ordem: Pos-Ordem\n";
	arv->imprime_pos_ordem(arv->raiz);

//  MOSTRANDO QUANTIDADE DE NOS
	cout << "\n\nQuantidade de Nos: " << arv->calculaqtdNos(arv->raiz) << endl;

// 	PROCURANDO PAI DO NO 4
//	Se o valor pedido fo igual ao no pai ele ira retornar o no pai 
	cout << "\nProcurando o pai do No:  " << arv->procuraPai(arv->raiz, 4)->valor << endl;

//  PROCURANDO PAI DE UM NO QUE NAO EXISTE
// esse metodo fica dando um erro louco kk 
	// cout << "\nProcurando o pai do No:  " << arv->procuraPai(arv->raiz, 5)->valor << endl;

}
