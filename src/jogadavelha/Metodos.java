
package jogadavelha;

import java.util.Random;

public class Metodos {
    private String[][] m = {{"1","2","3"},{"4","5","6"},{"7","8","9"}}; //cria uma string privada onde os valores são apresentados em forma de matriz
    
    public String Mostrar(){ //metodo que mostra na tela as jogadas efetuadas
        for (int linha=0; linha<3; linha++){ // realiza a leitura das linhas da matriz
            for (int coluna = 0; coluna < 3; coluna++) { // realiza a leitura das colunas da matriz
                System.out.printf(" "+ m[linha][coluna]); //apresenta as linhas e as colunas
                
            }
            System.out.println("\n");//deixa um espaço determinado entre as linhas e colunas
        }
        return null; //retorna o valor null para não alterar o "tabuleiro"
    }
    public boolean Valido(String posicao){ //verifica a validade e retorna valor booleano entre true e false
        for (int linha = 0; linha < 3; linha++) { //verifica linha
            for (int coluna = 0; coluna < 3; coluna++) { //verifica coluna
                if(m[linha][coluna].equals(posicao)) // se a matriz linha coluna for equivalente a posição, entao retorna verdadeiro
                    return true;
                
            }
            
        }
        return false; //caso contrário retorna falso
    }
    public void Jogada(String posicao, String jogador){ //Metodo publico para realizar a jogada
        if(posicao.equals("1")) //irá verificar a posição da jogada em relação a matriz, como trata-se de uma matriz 3 por 3, há 9 campos
            m[0][0] = jogador;
        else if(posicao.equals("2"))
            m[0][1] = jogador;
        else if(posicao.equals("3"))
            m[0][2] = jogador;
        else if(posicao.equals("4"))
            m[1][0] = jogador;
        else if(posicao.equals("5"))
            m[1][1] = jogador;
        else if(posicao.equals("6"))
            m[1][2] = jogador;
        else if(posicao.equals("7"))
            m[2][0] = jogador;
        else if(posicao.equals("8"))
            m[2][1] = jogador;
        else if(posicao.equals("9"))
            m[2][2] = jogador;
    }
    public String Ganhou(int jogadas){ //verifica o ganhador
        String[] VetorT = new String[8]; //diante de um vetor com 8 opção de jogadas que possibilitam a vitória
        String vencedor = "null"; 
        if(jogadas == 9){ //caso ocorra as jogadas e não feche com as opções do vetor da matriz
            vencedor = "EMPATE"; //determina que o vencedor foi EMPATE
        }
        VetorT[0] = m[0][0] + m[0][1] + m[0][2]; //verifica por linha
        VetorT[1] = m[1][0] + m[1][1] + m[1][2];
        VetorT[2] = m[2][0] + m[2][1] + m[2][2];
        
        VetorT[3] = m[0][0] + m[1][0] + m[2][0]; //verifica por coluna
        VetorT[4] = m[0][1] + m[1][1] + m[2][1];
        VetorT[5] = m[0][2] + m[1][2] + m[2][2];
        
        VetorT[6] = m[0][0] + m[1][1] + m[2][2]; //verifica na diagonal 
        VetorT[7] = m[0][2] + m[1][1] + m[2][0];
        
        for (int i = 0; i < VetorT.length; i++) {
            if(VetorT[i].equals("XXX")){ //caso conste uma sequencia XXX
                vencedor = "Jogador 1"; //determina que o vencedor é o jogador 1
            }else if(VetorT[i].equals("000")){ //caso retorne uma sequencia 000
                vencedor = "Jogador 2 - CPU"; //vencedor será CPU ou jogador 2
            }
            
        } return vencedor; //retorna o valor do vencedor, entre EMPATE, Jogador 1 e Jogador 2
    }
    
    public String GerarNumero(){ // construção da CPU dificuldade 1
        Random random = new Random(); //valor randonico
        int numero = random.nextInt(9); // determina que os valores serao randonicos até 9
        String str_x = Integer.toString(numero); //transforma uma valor inteiro em string
        System.out.println(str_x); //apresenta o valor da string convertida
        String posicao = str_x; // determina que a string posicao é o mesmo valor sorteado randonicamente até 9
        System.out.println(posicao); //mostra a posição 
        return posicao; //retorna o valor da posição para ser usado durante o jogo
    }
    public String GerarNumero1(){ //construção da CPU dificuldade 2
        Random random = new Random(); //valor randomico
        int numero1 = random.nextInt(9); //determina um valor ate 9
        int numero2 = random.nextInt(9); //determina um valor ate 9
        int coringa = numero1 + numero2 /2; //realiza uma soma e posterior uma media dos numero1 e numero2
        String str_y = Integer.toString(coringa); //transforma um valor inteiro em string
        String posicao = str_y; //seta a posicao atraves do str_y
        return posicao; //retorna a posicao
    }
    public String GerarNumero2(){ //construção da CPU dificuldade 3
        Random random = new Random(); //valor randomico
        int numero1 = random.nextInt(9); // determina um valor ate 9
        int numero2 = random.nextInt(9); //determina um valor ate 9
        int numero3 = random.nextInt(9); //determina um valor ate 9
        int coringa = numero1 + numero2 + numero3 /3; //soma os valores dos numero1 + numero2 + numero3 divide por 3 para realizar a média
        String str_z = Integer.toString(coringa); //transforma o valor coringa inteiro para string
        String posicao = str_z; //determina que a posicao atraves do str_z
        return posicao; //retorna posicao
    }
    
                
            
    }
    

