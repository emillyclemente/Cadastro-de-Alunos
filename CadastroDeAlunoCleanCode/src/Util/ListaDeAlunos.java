package Util;

import java.util.ArrayList;
import java.util.List;

import Modelos.Aluno;

public class ListaDeAlunos {
	
	private static List<Aluno> listaDeAluno = new ArrayList<Aluno>();
	
	public static List<Aluno> getInstance(){
		return listaDeAluno;
	}

}
