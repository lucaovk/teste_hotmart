package br.com.hotmart.teste.hotel.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import br.com.hotmart.teste.hotel.model.ConsultaCliente;

public class ArquivoReservaUtil {
	
	private Scanner in;
	
	public ArquivoReservaUtil(String caminho) throws FileNotFoundException{
		lerArquivo(caminho);
	}
	
	
	private void lerArquivo(String caminho) throws FileNotFoundException{
		
		in = new Scanner(new FileReader(caminho));	
	}
	
	
	public ArrayList<ConsultaCliente> buscarCliente(){
		ArrayList<ConsultaCliente> list = new ArrayList<ConsultaCliente>();
		
		while(in.hasNextLine()){
			ConsultaCliente cliente = new ConsultaCliente();
			String auxDias = "";
			Integer index;
			
			StringBuffer line = new StringBuffer(in.nextLine());
			
			cliente.setTipoCliente(line.substring(0, line.indexOf(":")).toLowerCase());
			
			
			index = line.indexOf("(") + 1;
			auxDias += line.substring(index , index + 3);
			line.deleteCharAt(line.indexOf("("));
			
			while(line.indexOf("(") != -1){
				index = line.indexOf("(") + 1;
				auxDias += ";" + line.substring(index, index + 3);
				line.deleteCharAt(line.indexOf("("));
			}
			
			cliente.setDias(auxDias.split(";"));			
			
			list.add(cliente);
			
		}
		
		return list;	
	}
	

}
