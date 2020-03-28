public class Vetor<E> {
	
	private Object[] vetor;
	private int tamanho;
	
	public Vetor() {
		vetor = new Object[10];
		tamanho = 0;
	}
	
	public Vetor(int tamanho) {
		vetor = new Object[tamanho];
		this.tamanho = 0;
	}
	
	public void adicionar(E dado) {
		if(!(tamanho < vetor.length))
			aumentarTamanho(1);
		
		vetor[tamanho] = dado;
		tamanho++;
	} 
	
	public void adicionar(E[] dados) {
		int livre = vetor.length - tamanho;
		if(!(dados.length <= livre))
			aumentarTamanho(dados.length - livre);
		
		int aux = tamanho;
		for(int i = 0; i < dados.length; i++) {
			vetor[aux] = dados[i];
			aux++;
		}
		tamanho += dados.length;
		
	}
		
	private void aumentarTamanho(int quantidade) {
		Object[] novoVetor = new Object[vetor.length+quantidade];
		for(int i = 0; i < tamanho; i++)
			novoVetor[i] = vetor[i];
		vetor = novoVetor;
	}
	
	public int buscar(E dado) {
		for(int i = 0; i < tamanho; i++) {
			if(dado.equals(vetor[i]))
				return i;
		}
		return -1;
	} 
	
	public int[] buscar(E[] dados) {
		int[] vetorIndex = new int[dados.length];
		for(int i = 0; i < dados.length; i++) {
			for(int j = 0; j < tamanho; j++) {
				if(dados[i].equals(vetor[j])) {
					vetorIndex[i] = j;
					break;
				}
				vetorIndex[i] = -1;
			}
		}
		
		return vetorIndex;
 	}
	
	public boolean remover(E dado) {
		int pos = buscar(dado);
		if(pos == -1)
			return false; 

		for(int i = pos; i < tamanho-1; i++)
			vetor[i] = vetor[i+1];
		tamanho--;
		diminuirTamanho(1);
		return true;
	} 
		
	public boolean remover(E[] dados) {
		int[] pos = buscar(dados);
		int contador = 0;
		for(int i = 0; i < pos.length; i++) {
			if(pos[i] != -1) {
				contador++;
				for(int j = pos[i]; j < tamanho -1; j++) {
					vetor[j] = vetor[j+1];
				}
			}
			pos = buscar(dados);
		}
		if(contador == 0)
			return false;
		
		tamanho -= contador;
		diminuirTamanho(contador);
		return true;
	}
	
	private void diminuirTamanho(int quantidade) {
		Object[] novoVetor = new Object[vetor.length-quantidade];
		for(int i = 0; i < novoVetor.length; i++)
			novoVetor[i] = vetor[i];
		vetor = novoVetor;
	}
	
	@Override
	public String toString() {
		if(tamanho == 0)
			return "";
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < tamanho-1; i++) {
			sb.append(vetor[i]);
			sb.append(", ");
		}
		sb.append(vetor[tamanho-1]);
		return sb.toString();
	}
	
}