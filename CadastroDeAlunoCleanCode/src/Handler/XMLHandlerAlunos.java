package Handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import Modelos.Aluno;
import Modelos.Endereco;
import Util.ListaDeAlunos;

public class XMLHandlerAlunos extends DefaultHandler {
	
	private StringBuilder texto;
	Aluno aluno;
	Endereco enderecoAluno;
	
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("Início do Documento");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("Fim do Documento");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException { //Quando começa uma tag
	
		if(qName.equals("Aluno")) { //Com String para comparar é necessário usar equals e não ==
			aluno = new Aluno();
			enderecoAluno = new Endereco();
		} else {
			texto = new StringBuilder();
		}
	}
	

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException { //Quando termina uma tag

		if(qName.equals("Nome")) {
			aluno.setNome(texto.toString());
		} else if(qName.equals("CPF")) {
			aluno.setCpf(Integer.parseInt(texto.toString()));
		} else if(qName.equals("Curso")) {
			aluno.setCurso(texto.toString());
		} else if(qName.equals("Rua")) {
			enderecoAluno.setRua(texto.toString());
		} else if(qName.equals("Numero")) {
			enderecoAluno.setNum(Integer.parseInt(texto.toString()));
		} else if(qName.equals("Bairro")) {
			enderecoAluno.setBairro(texto.toString());
		} else if(qName.equals("Cidade")) {
			enderecoAluno.setCidade(texto.toString());
		} else if(qName.equals("Estado")) {
			enderecoAluno.setEstado(texto.toString());
		} else if(qName.equals("CEP")) {
			enderecoAluno.setCep(Integer.parseInt(texto.toString()));
			aluno.setEndereco(enderecoAluno);
			ListaDeAlunos.getInstance().add(aluno);
		}
	}



	@Override
	public void characters(char[] ch, int start, int length) throws SAXException { //Quando tem conteudo dentro de uma tag, ele lê caractere por caractere
		
		texto.append(ch, start, length); //Quando receber um caractere vai junta-los e construir a String formando as palavras
	}
	

	@Override
	public void error(SAXParseException e) throws SAXException {
	
	}
	
	

}
