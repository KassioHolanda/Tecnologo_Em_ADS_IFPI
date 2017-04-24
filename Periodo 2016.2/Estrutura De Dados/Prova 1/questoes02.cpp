#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <math.h>
#include <iostream>

using namespace std;

class TProduto{
	private:
		int codigo;
		string descricao;
		float unidade;
		int quant;
		
	public:
		TProduto(int cod, string desc, float unid, int q){
			codigo = cod;
			descricao = desc;
			unidade = unid;
			quant = q;
		}
		
		string getDesc(){
			return descricao;
		}
		
		float getUnid(){
			return unidade;
		}
		
		int getQuant(){
			return quant;
		}
		
		int getCodigo(){
			return codigo;
		}
		
		void mostrar(){
			cout<<"Codigo: "<<getCodigo() <<" Descricao: "<<getDesc() <<" Unidade: "<<getUnid() <<" Quantidade: " <<getQuant() <<"\n";
		}
		
};

class TLista{
	private:
		TProduto *l[30];
		int quantidade;
	public:
		TLista(){
			quantidade = 0;
		}
		
		void inserir(int cod, string desc, float unid, int quant){
			TProduto *novo = new TProduto(cod, desc, unid, quant);
			l[quantidade] = novo;
			quantidade++;
		}
		
		void consultar(int produto){
			int i;
			bool encontrou = false;
			for(i = 0; i <= quantidade-1; i++){
				if(l[i]->getCodigo() == produto){
					encontrou = true;
					l[i]->mostrar();
				}
			}
			if(!encontrou){
				cout<<"Esse codigo nao pertence a nenhum produto";
			}
		}
		
		void mostrar(){
			int i;
			for(i = 0; i <= quantidade-1; i++){
				l[i]->mostrar();
			}
		}
};

main(){
	TLista *lista = new TLista();
	
	lista->inserir(1, "abacaxi", 3.50, 20);
	lista->inserir(2, "banana", 2.50, 5);
	lista->inserir(3, "limao", 1.00, 3);
	
	lista->mostrar();
	cout<<"\n";
	cout<<"Item Buscado: ";
	lista->consultar(2);

	
}