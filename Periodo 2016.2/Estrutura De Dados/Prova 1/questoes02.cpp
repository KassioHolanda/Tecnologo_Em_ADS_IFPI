#include <string>
#include <iostream>
#include <stdio.h>
using namespace std;

class TProduto{
	private:
		int codigo;
		string descricao;
		float unidade;
		int quant;
	public:
		TProduto(int cod, string desc, float unid, int q){
			this->codigo = cod;
			this->descricao = desc;
			this->unidade = unid;
			this->quant = q;
		}
		string getDesc(){
			return this->descricao;
		}
		float getUnid(){
			return this->unidade;
		}
		int getQuant(){
			return this->quant;
		}
		
		int getCodigo(){
			return this->codigo;
		}
		
		void mostrar(){
			cout<<"Codigo: "<<this->codigo <<" Descricao: "<<this->descricao <<" Unidade: "<< this->unidade <<" Quantidade: " << this->quant <<endl;
		}
		
};

class TLista{
	private:
		TProduto *l[30];
		int quant;
	public:
		TLista(){
			quant = 0;
		}
		
		void inserir(int cod, string desc, float unid, int quant){
			TProduto *novo = new TProduto(cod, desc, unid, quant);
			l[quant] = novo;
			quant++;
		}
		
		void consultar(int produto){
			int i;
			bool encontrou = false;
			for(i = 0; i <= quant; i++){
				if(l[i]->getCodigo() == produto){
					encontrou = true;
					cout<<"Codigo: "<<l[i]->getCodigo()<<" Descricao: "<<l[i]->getDesc() <<" Unidade: "<< l[i]->getUnid() <<" Quantidade: " << l[i]->getQuant()<<endl;
				}
			}
			if(!encontrou){
				cout<<"Esse codigo nao pertence a nenhum produto";
			}
		}
		
		void mostrar(){
			int i;
			for(i = 0; i <= quant; i++){
				cout<<"Codigo: "<<l[i]->getCodigo()<<" Descricao: "<<l[i]->getDesc() <<" Unidade: "<< l[i]->getUnid() <<" Quantidade: " << l[i]->getQuant()<<endl;
			}
		}
};

main(){
	TLista *lista = new TLista();
	lista->inserir(2, "abacaxi", 2.50, 20);
	
	lista->mostrar();
	cout<<"\n";
	lista->consultar(1);

	
}