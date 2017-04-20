#include <stdio.h>
#include <iostream>
#include <stdlib.h>
#include <math.h>

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
		
		void insere_ordenado(No *arv, No *novo){
			if(arv!=NULL){
				arv = (No *)malloc(sizeof(No));
				arv->esq = NULL;
				arv->dir = NULL;
				arv->info = novo->info; 
			} else {
				if(novo->info < arv->info){
					insere_ordenado(arv->esq, novo);
				}
				if(novo->info > arv->info){
					insere_ordenado(arv->dir, novo);
				}
			}
		}
		
		void imprime_pre_ordem(No *n){
			if(raiz == NULL){
				cout<<"\n <VAZIO>";
			} else {
				if(n != NULL ){
					cout<<"<"<<n->info;
					imprime_pre_ordem(n->esq);
					imprime_pre_ordem(n->dir);
					cout<<">";
				} else {
					cout<<"<>";
				}
			}
		}
		
		void imprime_simetrica(No *n){
			if(raiz == NULL){
				cout<<"\n <VAZIO>";
			} else {
				if(n != NULL ){
					cout<<"<";
					imprime_simetrica(n->esq);
					cout<<n->info;
					imprime_simetrica(n->dir);
					cout<<">";
				} else {
					cout<<"<>";
				}
			}
		}
		
		void imprime_pos_ordem(No *n){
			if(raiz == NULL){
				cout<<"\n <VAZIO>";
			} else {
				if(n != NULL ){
					cout<<"<";
					imprime_pos_ordem(n->esq);
					imprime_pos_ordem(n->dir);
					cout<<n->info;
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
		
		int quantidade_de_No(No *arv){
			if(arv == NULL){
				return 0;
			} else {
				int quantidade = 1;
				quantidade += quantidade_de_No(arv->esq);
				quantidade += quantidade_de_No(arv->dir);
				return quantidade;
			}
		}
		
		int altura_Minima(No *arv){
			int quantidade = quantidade_de_No(arv);
			
			return log2(quantidade) + 1;
		}
		
		void consultar_Completa(No *arv){
			if(altura_Minima(arv) == altura(arv) + 1){
				cout<<"\n\nArvore Completa\n";

			} else {
				cout<<"\n\nArvore Incompleta\n";
			}
		}
		
		int arv_vazia(No* a){
			return a == NULL;
		}
		
		No* arv_libera (No* a){
			if(!arv_vazia(a)){
				arv_libera(a->esq);
				arv_libera(a->dir);
				free(a);
			}
			return NULL;
		}
		
		void liberaFilho(char procurado, No *n){
			No *tmp = NULL;
			if(raiz->info == procurado){
				tmp = raiz;
				libera(tmp);
				raiz = NULL;
			} else {
				if(n->dir != NULL){
					if(n->dir->info == procurado){
						No *prox = n->dir;
						n->dir = NULL;
						libera(prox);
					} else {
						liberaFilho(procurado, n->dir);
					}
				}
				if(n->esq != NULL){
					if(n->esq->info == procurado){
						No *prox = n->esq;
						n->esq = NULL;
						libera(prox);
					} else {
						liberaFilho(procurado, n->esq);
					}
				}
			}
		}
		
		
		void libera(No *pai){
			No *tmp;
			if(pai!= NULL){
				if(pai->esq != NULL){
					libera(pai->esq);
				}
				if(pai->dir != NULL){
					libera(pai->dir);
				}
				
				free(pai);
			}
		}


		int arv_pertence(No* a, char c){
			
			if (arv_vazia(a)){
				   return 0; /* arvore vazia: nao encontrou */	
			} else {
				return a->info == c || 
				arv_pertence(a->esq, c) || 
				arv_pertence(a->dir, c);
			}	
		}
		
		void buscar(No* ele, char n){
			if(ele->info == n){
				cout<<"\nElemento "<<ele->info<<" encontrado!!!";
			} else {
				if (ele->dir != NULL){
					buscar(ele->dir, n);
				}
				if (ele->esq != NULL){
					buscar(ele->esq, n);
				}
			}
		}
		
		No *buscarOrd(No *ele, char n){
			if(ele->info == n){
				return ele;
			} else {
				if(ele->info < n){
					if(ele->dir != NULL){
						return buscarOrd(ele->dir, n);
					} else {
						return NULL;
					}
				}
				if (ele->info > n){
					if(ele->esq != NULL){
						return buscarOrd(ele->esq, n); 
					} else {
						return NULL;
					}
				}
			}
		}
		
				
};


main(){
	
// 	1 - adicionar a esquerda
//	2 - adicionar a direitra 
	
	Arvore *arv = new Arvore();	
	arv->cria_vazia();
	No *raiz = arv->cria_Raiz(10, NULL, NULL);
	
	No *no_a = arv->cria_No('a', NULL, NULL);
	No *no_b = arv->cria_No('b', NULL, NULL);

	No *no_c = arv->cria_No('c', NULL, NULL);
	No *no_d = arv->cria_No('d', NULL, NULL);
	No *no_e = arv->cria_No('e', NULL, NULL);
	No *no_f = arv->cria_No('f', NULL, NULL);
	No *no_g = arv->cria_No('g', NULL, NULL);
	No *no_h = arv->cria_No('h', NULL, NULL);
		
	//adicionando na raiz
	// arv->insere(raiz, no_a, 1, raiz->info);
	// arv->insere(raiz, no_b, 2, raiz->info);
	// 
	//adicionando no no A
	// arv->insere(no_a, no_c, 1, no_a->info);
	// arv->insere(no_a, no_d, 2, no_a->info);
	// 
	//adicionando no no B
	// arv->insere(no_b, no_e, 1, no_b->info);
	// arv->insere(no_b, no_f, 2, no_b->info);
	// 
	// 
	// cout<<"\nPre Ordem:\n";
	// arv->imprime_pre_ordem(raiz);
	// 
	// cout<<"\nOrdem Simetrica:\n";
	// arv->imprime_simetrica(raiz);
	// 
	// cout<<"\nPos Ordem:\n";
	// arv->imprime_pos_ordem(raiz);
	// 
	//tamanho da arvore
	// arv->consultar_Completa(arv->raiz);
	// cout<<"\n";
	// 
	// arv->buscar(raiz, 'c');
	
	
// 	inserindo ordenado

	No *um = arv->cria_No(2, NULL, NULL);
	No *dois = arv->cria_No(12, NULL, NULL);
	
	arv->insere_ordenado(raiz, um);
	arv->imprime_pre_ordem(raiz);
	
		
}
