public class Data {
	
	private short ano;
	private byte mes;
	private byte dia;
	
	public Data() {
		ano = 1;
		mes = 1;
		dia = 1;
	}

	public Data(int dia, int mes, int ano) {
		setAno((short) ano);
		setMes((byte) mes);
		setDia((byte) dia);
	}

	public short getAno() {
		return ano;
	}

	public void setAno(short ano) {
		if(!(ano > 0 && ano <= 9999))
			throw new IllegalArgumentException("Ano inválido!");
		this.ano = ano;
	}

	public byte getMes() {
		return mes;
	}

	public void setMes(byte mes) {
		if(!(mes > 0 && mes <= 12))
			throw new IllegalArgumentException("Mês inválido!");
		this.mes = mes;
	}

	public byte getDia() {
		return dia;
	}

	public void setDia(byte dia) {
		if(!(dia > 0 && dia <= 31))
			throw new IllegalArgumentException("Dia inválido!");
		byte ultimoDiaMes = getUltimoDiaMes(mes, ano);
		if(dia > ultimoDiaMes)
			throw new IllegalArgumentException("Dia inválido! Esse mês tem "+ultimoDiaMes+" dias.");
		this.dia = dia;
	}

	private byte getUltimoDiaMes(byte mes, short ano) {
		byte ultimoDiaMes = 0;
		switch(mes) {
		case 2:
			if(verificarBissexto(ano))
				ultimoDiaMes = 29;
			else
				ultimoDiaMes = 28;
			break;
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			ultimoDiaMes = 31;
			break;
		case 4: case 6: case 9: case 11:
			ultimoDiaMes = 30;
			break;
		}
		return ultimoDiaMes;
	}
	
	private boolean verificarBissexto(short ano) {
		if(ano % 4 == 0) {
			if(ano % 100 == 0) {
				return false;
			}
		}
		else {
			if(ano % 400 != 0)
				return false;
		}
		return true;	
	}
	
	public void incrementarAno() {
		byte dia = this.dia;
		short ano = this.ano;
		
		if(ano == 9999)
			ano = 1;
		else
			ano++;
		byte ultimoDiaMes = getUltimoDiaMes(mes, ano);
		if(mes == 2) {
			if(dia > ultimoDiaMes)
				dia = ultimoDiaMes;
		}
		
		this.ano = ano;
		this.dia = dia;
	}
	
	public void incrementarAno(int quantidadeAnos) {
		byte dia = this.dia;
		short ano = this.ano;

		for(int i = 0; i < quantidadeAnos; i++) {
			if(ano == 9999)
				ano = 1;
			else
				ano++;
		}

		byte ultimoDiaMes = getUltimoDiaMes(mes, ano);
		if(mes == 2) {
			if(dia > ultimoDiaMes)
	        	dia = (byte) (dia % ultimoDiaMes);
		}

		this.dia = dia;
		this.ano = ano;
	}

	public void incrementarMes() {
		byte dia = this.dia;
		byte mes = this.mes;
		
		if(mes == 12) {
			mes = 1;
			incrementarAno();
		}
		else
			mes++;
		byte ultimoDiaMes = getUltimoDiaMes(mes, ano);
		if(dia > ultimoDiaMes) {
			dia = ultimoDiaMes;
		}
		
		this.mes = mes;
		this.dia = dia;
	}
	
	public void incrementarMes(int quantidadeMeses) {
		byte dia = this.dia;
		byte mes = this.mes;

		for(int i = 0; i < quantidadeMeses; i++) {
			if(mes == 12) {
				mes = 1;
				incrementarAno();
			}
			else
				mes++;
		}

		byte ultimoDiaMes = getUltimoDiaMes(mes, ano);
		if(dia > ultimoDiaMes)      
        	dia = ultimoDiaMes;

		this.dia = dia;
		this.mes = mes;
	}

	public void incrementarDia() {
		byte dia = this.dia;
		
		if(dia == getUltimoDiaMes(mes, ano)) {
			dia = 1;
			incrementarMes();
		}
		else
			dia++;
		
		this.dia = dia;
	}
	
	public void incrementarDia(int quantidadeDias) {
		byte dia = this.dia;
		byte ultimoDiaMes = getUltimoDiaMes(mes, ano);

		for(int i = 0; i < quantidadeDias; i++) {
			if(dia == ultimoDiaMes) {
				dia = 1;
				incrementarMes();
				ultimoDiaMes = getUltimoDiaMes(mes, ano);
			}
			else
				dia++;
		}

		this.dia = dia;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ano;
		result = prime * result + dia;
		result = prime * result + mes;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) { 
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Data outro = (Data) obj;
		if(ano != outro.ano)
			return false;
		if(mes != outro.mes)
			return false;
		if(dia != outro.dia)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("%02d/%02d/%04d", dia, mes, ano);
	}
	
}