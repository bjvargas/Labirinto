package labirinto;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.util.Scanner;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Main {

	public static void main(String[] args) throws MalformedURLException, IOException, InterruptedException, LineUnavailableException, UnsupportedAudioFileException {	 
	    Scanner ler = new Scanner(System.in);

	    System.out.println("Digite o caminho com nome do arquivo: ");
		Labirinto classeLabirinto = new Labirinto();
		
				
	    FileWriter arquivoSaida = new FileWriter("C:\\saidaLabirinto.txt");
	    PrintWriter gravarArq = new PrintWriter(arquivoSaida);


			if(classeLabirinto.labirinto(ler.next())) {
				gravarArq.printf("Existe um caminho para o labirinto");
			} else {
				gravarArq.printf("Não existe um caminho para o labirinto");
			}
			arquivoSaida.close();

	}
	
}