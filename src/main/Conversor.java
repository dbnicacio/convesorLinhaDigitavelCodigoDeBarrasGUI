package main;
public class Conversor {

		public static String converter(String linha){
			linha = linha.replaceAll("[^0-9]", "");
			if (linha.length() == 44) {
				return calculaLinha(linha);
			}else if (linha.length() == 47) {
				return calculaCodBarra(linha);
			}else {
				return "Valor incorreto !";
		    }
		}

		public static String calculaCodBarra(String linha) {
			String cdBar = linha.substring(0,4)+linha.substring(32,33)+linha.substring(33,47)
		    +linha.substring(4,9)+linha.substring(10,20)+linha.substring(21,31);

	    	return  cdBar;
		}
		public static String calculaLinha(String linha) {

			    String campo1 = linha.substring(0,4)+linha.substring(19,20)+'.'+linha.substring(20,24);
			    String campo2 = linha.substring(24,29)+'.'+linha.substring(29,34);
			    String campo3 = linha.substring(34,39)+'.'+linha.substring(39,44);
			    String campo4 = linha.substring(4,5);
			    String campo5 = linha.substring(5,19);

			    if (  modulo11Banco(  linha.substring(0,4)+linha.substring(5,44)  ) != Integer.valueOf(campo4) ) {
			        return null;
			    }
			    return  campo1 + modulo10(campo1)
			            +' '
			            +campo2 + modulo10(campo2)
			            +' '
			            +campo3 + modulo10(campo3)
			            +' '
			            +campo4
			            +' '
			            +campo5
			            ;

		}

		public static int modulo10(String numero) {
		    numero = numero.replaceAll("[^0-9]","");
		    int soma  = 0;
		    int peso  = 2;
		    int contador = numero.length()-1;
		    while (contador >= 0) {
		        int multiplicacao = Integer.valueOf( numero.substring(contador,contador+1) ) * peso;
		        if (multiplicacao >= 10) {multiplicacao = 1 + (multiplicacao-10);}
		        soma = soma + multiplicacao;
		        if (peso == 2) {
		            peso = 1;
		        } else {
		            peso = 2;
		        }
		        contador = contador - 1;
		    }
		    int digito = 10 - (soma % 10);
		    if (digito == 10) digito = 0;

		    return digito;
		}

		public static int modulo11Banco(String numero) {
		    numero = numero.replaceAll("[^0-9]","");

		    int soma  = 0;
		    int peso  = 2;
		    int base  = 9;
		    int contador = numero.length() - 1;
		    for (int i=contador; i >= 0; i--) {
		        soma = soma + ( Integer.valueOf(numero.substring(i,i+1)) * peso);
		        if (peso < base) {
		            peso++;
		        } else {
		            peso = 2;
		        }
		    }
		    int digito = 11 - (soma % 11);
		    if (digito >  9) digito = 0;
		    if (digito == 0) digito = 1;
		    return digito;
		}

	}


