package main;

import java.util.ArrayList;
import model.Map;
import java.util.Scanner;

import model.Set;

public class Main {
	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<Integer> dominio = new ArrayList<>();
	public static ArrayList<String> rango = new ArrayList<>();

	public static void main(String args[]) {
		Boolean flag = true;
		Boolean function = true;

		Set<Integer, String> map = new Set<>();

		boolean flag1 = true;
		
		while (flag1) {
			System.out.println("Ingrese un elemento del dominio");
			int dominioElement = verifyNumber();
			if (!dominio.contains(dominioElement)) {
				dominio.add(dominioElement);
			}

			System.out.println("¿Desea ingresar más elementos al dominio? (Si/No)");
			flag1 = yesOrNo();
		}
		flag1 = true;

		
		while (flag1) {
			System.out.println("Ingrese un elemento del rango");
			String rangoElenment = sc.next().toUpperCase();
			if (!rango.contains(rangoElenment)) {
				rango.add(rangoElenment);
			}

			
			System.out.println("¿Desea ingresar más elementos al rango? (Si/No)");
			flag1 = yesOrNo();
		}

	
		while (flag) {
			System.out.println("Ingresa el índice del par");
			int index = 0;
			do {
				index = verifyNumber();
				if (!dominio.contains(index)) {
					System.out.println("El indice " + index + " no pertenece al dominio");
					showDominio();
				}
			} while (!dominio.contains(index));
			System.out.println("Ingresa el valor correspondiente al par ");
			String par2 = "";
			do {
				par2 = sc.next().toUpperCase();
				if (!rango.contains(par2)) {
					System.out.println("El valor " + par2 + " no pertenece al rango");
					showRango();
				}
			} while (!rango.contains(par2));
			for (Map<Integer, String> m : map.entrySet()) {
				int coco = (int) m.getKey();
				if (index == coco) {
					function = false;
				}
			}
			map.put(index, par2);
			System.out.println("¿Desea agregar otro par? \\\"Si\\\" o \\\"No\\\"");
			flag = yesOrNo();
		}

		if (dominio.size() != map.size() && function) {
			System.out.println("No es una funcion");
			function = false;
		}

		for (Map<Integer, String> m : map.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}

		if (function) {
			System.out.println("Es funcion");
			if (sobreyectiva(map) && inyectiva(map)) {
				System.out.println("BIYECTIVA");
			} else if (sobreyectiva(map)) {
				System.out.println("SOBREYECTIVA");
			} else if (inyectiva(map)) {
				System.out.println("INYECTIVA");
			}
		} else {
			System.out.println("No es funcion");
		}

	}

	public static int verifyNumber() {
		String number = "";
		String badNumber = "";
		boolean flag;
		boolean repeat = true;

		while (repeat) {
			flag = true;
			number = sc.next();
			for (int i = 0; i < number.length() && flag; i++) {
				if (number.charAt(i) != '1' && number.charAt(i) != '2' && number.charAt(i) != '3'
						&& number.charAt(i) != '4' && number.charAt(i) != '5' && number.charAt(i) != '6'
						&& number.charAt(i) != '7' && number.charAt(i) != '8' && number.charAt(i) != '9'
						&& number.charAt(i) != '0' && number.charAt(i) != '-') {
					flag = false;
					badNumber = "" + number.charAt(i);
				}
			}

			if (!flag) {
				System.out.println("(El indice debe ser entero) El siguiente caracter no hace parte de los números enteros: "+ badNumber);
				repeat = true;
			} else {
				repeat = false;
			}
		}

		int intNumber = (int) Integer.parseInt(number);

		return intNumber;
	}

	public static Boolean yesOrNo() {
		Boolean out = true;
		String yesOrNo = "";
		Boolean flag = false;
		while (!flag) {
			yesOrNo = sc.next().toUpperCase();
			switch (yesOrNo) {
			case "SI":
				out = true;
				flag = true;
				break;
			case "NO":
				out = false;
				flag = true;
				break;
			default:
				System.out.println("Debes responder \"Si\" o \"No\" ");
				flag = false;
				break;
			}
		}
		return out;
	}

	public static void showDominio() {
		System.out.println("El dominio es:\n");
		for (int x : dominio) {
			System.out.println(x);
		}
	}

	public static void showRango() {
		System.out.println("El rango es:\n");
		System.out.println(rango.size());
		for (String x : rango) {
			System.out.println(x);
		}
	}

	public static boolean sobreyectiva(Set<Integer, String> map) {
		boolean out = true;
		for (int i : getImgs(map)) {
			if (i == 0) {
				out = false;
				break;
			} else {
				out = true;
			}
		}

		return out;
	}

	public static boolean inyectiva(Set<Integer, String> map) {
		boolean out = true;
		for (int i : getImgs(map)) {
			if (i > 1) {
				out = false;
				break;
			} else {
				out = true;
			}
		}
		return out;
	}

	public static ArrayList<Integer> getImgs(Set<Integer, String> map) {
		int counter;
		String a = "";
		ArrayList<Integer> imgs = new ArrayList<>();
		for (String i : rango) {
			counter = 0;
			for (Map<Integer, String> m : map.entrySet()) {
				a = (String) m.getValue();
				if (a.equals(i)) {
					counter++;
				}
			}
			imgs.add(counter);
		}
		return imgs;
	}
}
