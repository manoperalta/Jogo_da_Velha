/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jogadavelha;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Jonathas Martinelli Peralta
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       Scanner ler = new Scanner(System.in); // chamo o scanner para ler posteriormente o teclado, entrada de dados
       Metodos jogo = new Metodos(); // implemento o Metodo o jogo
       String posicao; // determino que a varialvel posicao será uma String textual
       int valida = 0, Jogadas = 0; //seta as variaveis valida e Jogadas para que possa percorrer entre as 8 jogadas possiveis na matriz
        System.out.println("Escolha uma Opcao de Dificuldade 1, 2 ou 3"); //Mensagem para Opcoes de dificuldade
       int cpu = ler.nextInt(); // seta a variavel cpu responsavel pelas dificuldades com inteiro
        
        if(cpu==1){ //realiza uma verificacao simples das opcoes de CPU dificuldade
            System.out.println("Dificuldade:  " + cpu); //mostra a diculdade selecionada e verifica se foi a opcao 1 
        }else if(cpu==2){ //se for a opcao 2 de CPU
            System.out.println("Dificuldade:  " + cpu); //mostra a diculdade selecionada e verifica se foi a opcao 1 
        }else if(cpu==3){ //se for a opcoa 3 de CPU
            System.out.println("Dificuldade:  " + cpu); //mostra a diculdade selecionada e verifica se foi a opcao 1 
        }else{ //se for digitado uma opcao fora das opcoes, solicita que informe dentro das opcoes validas
            System.out.println("Digite uma opcao válida: 1 , 2 ou 3"); //mostra que a opcao nao foi valida e solicita entre 1, 2 e 3
            cpu = ler.nextInt(); //entrada da opcao da CPU dificuldade
        }
       
       
      
            
            
      //Laço de repeticao habilitado
       while(true){
           System.out.println("Jogo da Velha!"); //mensagem na tela que trata-se de jogo da velha
           jogo.Mostrar(); //puxo o método Mostrar para exibir o "tabuleiro na tela"
           do{ //Jogador 1
               System.out.print("Jogador 1, informe a Jogada"); //Opcao de jogada
               posicao = ler.next(); //obtem o número relacionado a posicao da jogada
               while(!jogo.Valido(posicao)){ //verifica se o número/posicao já não está sendo ocupada
                   System.out.println("Jogada Inválida"); //caso for constatado que já foi utilizado em jogada anterior ou está fora da contagem retorna mensagem de inválido
                   System.out.print("Jogador 1, informe a Jogada"); // solicita que determine um novo numero para jogada
               posicao = ler.next(); //le o numero digitado e aloca na variavel 
               valida = 0; //determina a validade para alternancia de jogador
               }
               jogo.Jogada(posicao, "X"); //se for validado, tera o numero da posicao substituico por X
               valida = 1;
           }while(valida == 0); //fim jogador 1
           
           Jogadas++; //adiciona uma contagem ao numero de jogadas
           valida = 0; //reponsavel pela alternacia de jogador
           jogo.Mostrar(); //mostra a jogada na tela
           if(!jogo.Ganhou(Jogadas).equals("null")){ //realiza a verifcação se o jogo há vencedor ou ainda não
               break; //se houver vencedor, interrompe o laço de repetição usando break
           }
           do{ //Jogador 2
               System.out.println("Jogador 2, CPU"); //determina que o 2º jogador é a CPU e irá jogar
               //Random random = new Random();
               //int numero = random.nextInt(9);
               //String str_x = Integer.toString(numero);
               //System.out.println(str_x);
               //posicao = str_x;
               if(cpu==1){ // dificuldade 1 selecionada
                   posicao = jogo.GerarNumero(); //utiliza o metodo Gerar Numero para determinar a opcao de jogada
                   System.out.println(posicao); // informa a jogada
               
               }else if(cpu==2){ // dificuldade 2 selecionada
                   posicao = jogo.GerarNumero1(); // utiliza do metodo Gerar Numero 1 para determinar a opcao de jogada
                   System.out.println(posicao); // informa a jogada
                          
               }else if(cpu==3){ //dificuldade 3 selcionada
                   posicao = jogo.GerarNumero2(); // utiliza do metodo Gerar Numero 2 para determinar a opcao de jogada
                   System.out.println(posicao); //informa a jogada
               }else{ //se nenhuma das opcoes forem relacionada entre 1 e 3
                   System.out.println("CPU nao reconhecida");  //mostra um erro 
               }
               
               
               
               while(!jogo.Valido(posicao)){ //realiza novamente a verificação para ver se o valor é valido ou está dentro das opção de cpu
                   System.out.println("Jogada Inválida");
                   System.out.print("Jogador 2, informe a Jogada");
                   if(cpu==1){
                   posicao = jogo.GerarNumero();
                   System.out.println(posicao);
               
               }else if(cpu==2){
                   posicao = jogo.GerarNumero1();
                   System.out.println(posicao);
                          
               }else if(cpu==3){
                   posicao = jogo.GerarNumero2();
                   System.out.println(posicao);
               }else{
                   System.out.println("CPU nao reconhecida");
               }
               
               valida = 0;
               }
               jogo.Jogada(posicao, "0");
               valida = 1;
           }while(valida == 0); //fim jogador 2
           
           Jogadas++;
           valida = 0;
           jogo.Mostrar();
           if(!jogo.Ganhou(Jogadas).equals("null")){ // caso tenha acabado as 8 opcoes de jogadas na matriz apresenta o vencedor  ou empate
               break; //finaliza o laço de repetição
           }
       } //------------
        System.out.println("0 "+jogo.Ganhou(Jogadas)+" Venceu!"); //apresenta na tela o resultado do Jogo
       
    }
    
    
    
}
