package com.cgi.koodauskoe2.Teht2;

import java.util.Arrays;
import java.util.Scanner;

public class Teht2Application {

	public static int pieninVali(int[] taulukko) {
		Arrays.sort(taulukko);
		int pieninVali = Integer.MAX_VALUE;

		// Taulukon läpikäynti
		for (int i = 0; i < taulukko.length -1; i++) {
			if (taulukko[i] != taulukko[i + 1]) {
				int vali = taulukko[i + 1] - taulukko[i] - 1;
				pieninVali = Math.min(pieninVali, vali);
			}
		}

		return pieninVali;
	}

	// Konsoli kysyy käytettävät numerot ja tulostaa tuloksen
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Syötä kolme lukua:");

		int[] taulukko = new int[3];

		for (int i = 0; i <  3; i++) {
			System.out.print("Syöte " + (i + 1) + ": ");
			taulukko[i] = scanner.nextInt();
		}

		int tulos = pieninVali(taulukko);
		System.out.println("Pienin määrä numeroita välille: " + tulos);

		scanner.close();
	}
}
