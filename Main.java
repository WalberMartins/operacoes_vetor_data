import java.util.Arrays;

class Main {

	public static void main(String[] args) {
		Vetor<Data> vetor = new Vetor<>();
		Data data = null;

		System.out.println();
		System.out.println("\tADICIONANDO DATAS NO VETOR");
		for(int i = 0; i < 5; i++) {
			data = new Data(25, 10, 2019);
			data.incrementarDia(i * 2);
			vetor.adicionar(data);
		}
		
		System.out.println("\nDatas adicionadas no vetor:");
		System.out.println(vetor+"\n");

		System.out.println("\tBUSCANDO DATA NO VETOR:\n");
		System.out.println("Buscando a data 31/10/2019:");
		data = new Data(31, 10, 2019);
		System.out.println("Está na "+vetor.buscar(data)+"ª posição do vetor.\n");

		System.out.println("\tBUSCANDO VÁRIAS DATAS NO VETOR:\n");
		System.out.println("Buscando as datas 25/10/2019, 29/10/2019, 02/11/2019:");
		Data[] datas = {new Data(25, 10, 2019), new Data(29, 10, 2019), new Data(02, 11, 2019)};
		System.out.println("Estão nas posições "+Arrays.toString(vetor.buscar(datas))+" do vetor.\n");

		System.out.println("\tREMOVENDO DATA DO VETOR:\n");
		System.out.println("Removendo a data 29/10/2019:");
		data = new Data(29, 10, 2019);
		vetor.remover(data);
		System.out.println("Vetor atualizado: \n"+vetor+"\n");

		System.out.println("\tREMOVENDO VÁRIAS DATAS DO VETOR:\n");
		System.out.println("Removendo as datas 25/10/2019, 29/10/2019, 02/11/2019:");
		datas[0] = new Data(25, 10, 2019); datas[1] = new Data(29, 10, 2019); datas[2] = new Data(2, 11, 2019);
		vetor.remover(datas);
		System.out.println("Vetor atualizado: \n"+vetor);
		
	}

}