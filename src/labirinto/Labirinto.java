package labirinto;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Labirinto {

	String[] linhaEColuna;
	private int[][] labirinto;
	private Scanner lerArquivo;
	private int caminho, linha, coluna;
	Boolean existeSaida = false;

	public int[][] carregaLabirinto(String arquivo) throws IOException {
		lerArquivo = new Scanner(new File(arquivo));

		linha = Integer.parseInt(lerArquivo.nextLine());
		coluna = Integer.parseInt(lerArquivo.nextLine());
		labirinto = new int[linha][coluna];
		System.out.println("Labirinto de Linhas: " + linha + " e de colunas: " + coluna);

		int linha = 0;

		while (lerArquivo.hasNextLine()) {
			String symbol = lerArquivo.nextLine();

			if (linha == 0) {
				caminho = symbol.charAt(0);
			}

			for (int j = 0; j < coluna; j++) {
				labirinto[linha][j] = symbol.charAt(j);
				if (labirinto[linha][j] == caminho) {
					labirinto[linha][j] = 1;
				} else if (labirinto[linha][j] == 68) {
					labirinto[linha][j] = 2;
				} else {
					labirinto[linha][j] = 0;

				}
			}

			linha++;

		}
		lerArquivo.close();
		return labirinto;
	}

	public Boolean labirinto(String arquivo) throws IOException {

		this.carregaLabirinto(arquivo);
		return this.labirindoRecusrsivo(0, 0);

	}

	public Boolean labirindoRecusrsivo(int coluna, int linha) throws IOException {

		if (2 == labirinto[coluna][linha]) {
			System.out.println("Achou a saída na Coluna: " + coluna + " e Linha: " + linha);
			existeSaida = true;
		} else if (1 == labirinto[coluna][linha]) {
			System.out.println("Estamos no caminho");
			labirinto[coluna][linha] = 9;
			if (coluna < labirinto.length - 1) {
				this.labirindoRecusrsivo(coluna + 1, linha);
			}
			if (linha < labirinto[coluna].length - 1) {
				this.labirindoRecusrsivo(coluna, linha + 1);
			}
			if (coluna > 0) {
				this.labirindoRecusrsivo(coluna - 1, linha);
			}
			if (linha > 0) {
				this.labirindoRecusrsivo(coluna, linha - 1);

			}
		}
		return existeSaida;

	}

}
