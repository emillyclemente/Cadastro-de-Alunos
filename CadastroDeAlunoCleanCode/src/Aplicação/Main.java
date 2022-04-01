package Aplicação;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import View.ViewCRUDAluno;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException, SAXException {

		BufferedReader reader = new BufferedReader( new InputStreamReader(System.in)); // Criar espaço de armazenamento, para ler as informações.
		 /* Lista para guardar as informações, banco de dados. 														ArrayList quantos espaços precisar (construtor especial) */
		int menu = 0;
		while (menu != 5) {

			menu = ViewCRUDAluno.ViewMenuPrincipal(reader);

			 /*charAt para ler apenas um caractere, 0 para ler o primeiro caractere. 
												Se alguêm digitar mais de um caractere ele pega apenas o primeiro caractere*/
				//readLine lê a linha toda.

				switch (menu) {

				case 1:
					CRUDAluno.SalvarAluno(reader); //Adicionar na lista de alunos os dados cadastrados.
					break;
					//					for (Aluno a : listaAluno) //Para mostrar todos os dados cadastrados, atribuindo cada um por vez a variavel "a", até que todos sejam mostrados. Objetos que estão na memoria RAM
					//					System.out.println(a);
				case 2:
					CRUDAluno.ListarAlunosSalvos();
					//String line = "Emilly,Clemente";
					//Aluno aluno = new Aluno(line);
					break;

				case 3:
					CRUDAluno.DeletarAluno(reader);
					break;


				case 4:
					CRUDAluno.EditarAluno(reader);
					break;
					
				case 5:
					ViewCRUDAluno.ViewMsgFinal(3);
					break;
				}

		}


	}
}
