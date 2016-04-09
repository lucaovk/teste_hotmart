package br.com.hotmart.teste.hotel.enums;

public enum DiasSemana {
	SEGUNDA(0,"seg"),
	TERCA(1,"ter"),
	QUARTA(2,"qua"),
	QUINTA(3,"qui"),
	SEXTA(4,"sex"),
	SABADO(5,"sab"),
	DOMINGO(6,"dom");
	
	Integer codigo;
	String desc;
	
	private DiasSemana(Integer codigo, String desc) {
		this.codigo = codigo;
		this.desc = desc;			
	}
	
	public static String getDesc(Integer codigo){
		for(DiasSemana enumerate:DiasSemana.values()){
			if(enumerate.codigo == codigo){
				return enumerate.desc;
			}
		}
		
		return null;
	}
	
	

}
