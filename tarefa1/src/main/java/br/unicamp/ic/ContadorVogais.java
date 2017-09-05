package br.unicamp.ic;

import java.util.Arrays;
import java.util.List;

/**
 * Dada uma seqüência de Strings, implemente os métodos total's para contar o
 * número de vogais existente nessa seqüência. É necessário saber quantas vezes
 * cada vogal se repete (o número de “a”’s, o número de “e”’s, etc.). A
 * seqüência (array) de String padrão já é fornecida pela operação main() da
 * classe. O acesso a um elemento de um array é feito como em diversas outras
 * linguagens, colocando - se colchetes e o número da posição que se quer
 * acessar depois do nome da variável correspondente ao array. Por exemplo:
 * seq[0] acessa o primeiro elemento de um array chamado seq. Para saber o
 * tamanho de uma seqüência, usa - se o atributo length (seq.length) definido em
 * todos os objetos do tipo array.
 *
 * @author INF323
 */
public class ContadorVogais {

    private final String[] sequencia;


    public ContadorVogais(String[] sequencia) {
        this.sequencia = sequencia;
    }

    public static void main(String args[]) {
        ContadorVogais contadorVogais = new ContadorVogais(new String[]{"A", "p", "e", "s", "aaa", "r", "d", "e",
            "v", "o", "c", "e", "a", "m", "a", "n", "h", "a", "h", "a",
            "d", "e", "s", "e", "r", "o", "u", "t", "r", "o", "d", "i", "a"});
        System.out.println("Total de 'a' : " + contadorVogais.totalA());
        System.out.println("Total de 'e' : " + contadorVogais.totalE());
        System.out.println("Total de 'i' : " + contadorVogais.totalI());
        System.out.println("Total de 'o' : " + contadorVogais.totalO());
        System.out.println("Total de 'u' : " + contadorVogais.totalU());
        System.out.println("Total de vogais : " + contadorVogais.total());
    }

    /**
     * retorna o número de vezes que a vogal 'a' aparece em sequencia
     *
     * @return
     */
    public int totalA() {
    	
    	//foreach com regex
//    	int total = 0;
//    	for (String string : sequencia) {
//    		total += string.replaceAll("[^aA]", "").length();
//		}
    	
    	//stream
//    	total = 0;
    	List<String> palavras = Arrays.asList(sequencia);
    	int total = palavras.stream().mapToInt(s -> s.replaceAll("[^aA]", "").length()).sum();
        return total;
        
    }

    /**
     * retorna o número de vezes que a vogal 'e' aparece em sequencia
     *
     * @return
     */
    public int totalE() {
//    	int total = 0;
//    	for (String string : sequencia) {
//    		for(int i=0;i<string.length();i++)
//    			if(string.charAt(i)=='e' || string.charAt(i)=='E')
//    				total++;
//		}
    	List<String> palavras = Arrays.asList(sequencia);
    	int total = palavras.stream().mapToInt(s -> s.replaceAll("[^eE]", "").length()).sum();
        return total;
    }

    /**
     * retorna o número de vezes que a vogal 'i' aparece em sequencia
     *
     * @return
     */
    public int totalI() {
//    	int total = 0;
//    	for (String string : sequencia) {
//    		for(int i=0;i<string.length();i++)
//    			if(string.charAt(i)=='i' || string.charAt(i)=='I')
//    				total++;
//		}
    	List<String> palavras = Arrays.asList(sequencia);
    	int total = palavras.stream().mapToInt(s -> s.replaceAll("[^iI]", "").length()).sum();
        return total;
    }

    /**
     * retorna o número de vezes que a vogal 'o' aparece em sequencia
     *
     * @return
     */
    public int totalO() {
//    	int total = 0;
//    	for (String string : sequencia) {
//    		for(int i=0;i<string.length();i++)
//    			if(string.charAt(i)=='o' || string.charAt(i)=='O')
//    				total++;
//		}
    	List<String> palavras = Arrays.asList(sequencia);
    	int total = palavras.stream().mapToInt(s -> s.replaceAll("[^oO]", "").length()).sum();
        return total;
    }

    /**
     * retorna o número de vezes que a vogal 'u' aparece em sequencia
     *
     * @return
     */
    public int totalU() {
//    	int total = 0;
//    	for (String string : sequencia) {
//    		for(int i=0;i<string.length();i++)
//    			if(string.charAt(i)=='u' || string.charAt(i)=='U')
//    				total++;
//		}
    	List<String> palavras = Arrays.asList(sequencia);
    	int total = palavras.stream().mapToInt(s -> s.replaceAll("[^uU]", "").length()).sum();
        return total;
    }

    /**
     * retorna o número de vezes que as vogais aparecem em sequencia
     *
     * @return
     */
    public int total() {
    
        return totalA()+totalE()+totalI()+totalO()+totalU();
    }

}
