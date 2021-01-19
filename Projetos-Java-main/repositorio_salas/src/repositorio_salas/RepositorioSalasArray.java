
package repositorio_salas;

import java.util.Scanner;


public class RepositorioSalasArray {
      //atributos
    private Salas[] sala;
    private int indice;

//CONSTRUTOR
public RepositorioSalasArray(int tamanho)  { 
    this.sala = new Salas[tamanho];
    this.indice = 0;
}    

private int procurarIndice(String numero) {
    
    int i = 0;
    boolean achou;                
    for (achou = false; !achou && i < indice;) {
        if (sala[i].getNumero().equals(numero)) { 
            achou = true;
        } else {
            i++;
        }    
    }
    if (!achou) 
          i = -1;
    return i;
    }


public Salas consultar(String numero) {
    
    Salas s = null; 
    int i = procurarIndice(numero);
    if (i == -1) {
            return null; // não encontrou
    } else {
        s = sala[i];
        return s;
    }
}

public void inserir(Salas s) {
    
        
    if (indice < sala.length)  {     // verifica se ainda tem espaço no repositório
            if (s != null) {             // verifica se inseriu uma sala válida
                    if ( consultar(s.getNumero()) == null)  {        // verifica se o numero inserido da sala ja existe no repositório
                            sala[indice] = s;                            
                            indice = indice + 1;                        
                            System.out.println("<Sala ("+s.getNumero()+") inserida com sucesso!!>"); // RECEBE O VALOR DO NUMERO DA SALA INSERIDA E INFORMAR QUE FOI INSERIDA COM SUCESSO
                            System.out.println("");
                            if (indice == 1)   // PRINT FORMATADO PARA QUANDO FOR INSERIDO A PRIMEIRA SALA
                                System.out.println(+indice+" sala cadastrada até o momento..."); 
                            else  //PRINT FORMATADO PARA QUANDO FOR INSERIDO AS DEMAIS SALAS
                                System.out.println(+indice+" salas cadastradas até o momento..."); 
                            System.out.println("");
                            if (indice == sala.length)
                                System.out.println("\tRepositório cheio");      // PRINT PARA INFORMAR QUANDO VETOR ESTIVER CHEIO
                            
                            }
                    else
                            System.out.println("Sala já cadastrada.");
            } 
            else  {
                    System.out.println("Sala inválida");   
            }
    } 
    else
            System.out.println("Repositório cheio, favor remover alguma sala para poder incluir");  
}



public void exibirrepositorio()   {
    int cont = 0; 
    
    if (indice == 0)          // CONDIÇÃO PARA VERIFICAR SE O REPOSITORIO ESTA VAZIO
        System.out.println("\tRepositório vazio");
    
    else{  // O REPOSITORIO TERÁ CONTEUDO DENTRO E IMPRIMIRÁ
        System.out.println("\t<<<<< REPOSITÓRIO DE SALAS >>>>> ");
    System.out.println(""); 
    
    for (int i = 0; i < indice; i++ )  { // MOSTRAR O REPOSITORIO
        System.out.println("\tSala: " + sala[i].getNumero()+" / PROFESSOR: "+sala[i].getNome_professor()+" / Andar: "+sala[i].getAndar()+"°");
        cont += 1;
    }
    System.out.println(""); 
    System.out.println("\tNumero de salas cadastradas: "+cont); // INFORMAR NUMERO DE SALAS CADASTRADAS
    System.out.println(""); 
    System.out.println("\t<<<<< FIM DO REPOSITÓRIO >>>>>");
    
    if (indice == sala.length) // INFORMAR MENSAGEM DE REPOSITORIO CHEIO
            System.out.println("\t\tRepositório cheio!!");
    }
    

    
}

public void remover(){
    
    exibirrepositorio();
    
    if (indice > 0){ //É PERMITIDO REMOVER POIS EXISTE SALA CADASTRADA
        Scanner input = new Scanner(System.in);
        
        System.out.println("Digite o numero da sala que deseja REMOVER:");
        String numero = input.next(); //ARMAZENA O NUMERO DA CONTA INSERIDO

        int e = procurarIndice(numero); //VARIAVEL "e" ARMAZENA O ÍNDICE QUE O NÚMERO ESTÁ

        if (e == -1)  //CASO O INDICE SEJA NEGATIVO, NÃO EXISTE CONTA ARMAZENADA AINDA
            System.out.println("Não existe esta sala para remover");
        else{   // REMOVER A CONTA DESEJADA
           
           for (int i = e; i<indice-1; i++) { 
                            sala[i] = sala[i+1]; // LAÇO DE REPETIÇÃO ONDE CADA INDICE RECEBE O VALOR DO INDICE SUBSEQUENTE
               }
           System.out.println("< Excluído com sucesso > ");
           
           // O INDICE REGRIDE 1 POSIÇÃO
           indice = indice -1; 
           sala[indice] = null; //A POSIÇÃO NO INDICE VIRA NULO      
           }
    }   
    else
        System.out.println("Não existe salas para remover!");
    
    
    }

public void atualizar(){
    exibirrepositorio();
    
    if (indice > 0){ //É PERMITIDO ATUALIZAR POIS EXISTE SALA CADASTRADA
        
        int opcao;
        Scanner input = new Scanner(System.in);
        
        System.out.print("Digite o numero da sala que deseja atualizar:");
        String numero = input.next();
    
        int e = procurarIndice(numero); // procura se a sala digitada esta no repositório

        if (e != -1){ // Se estiver, entra no loop do menu de atualização

            do{
                System.out.println("\t=========== menu de atualização ==========");
            System.out.print("\t1 - Número da sala\n"
                    + "\t2 - Nome do professor\n"
                    + "\t3 - Andar\n"
                    + "\t0 - Sair\n"
                    + "\tDeseja atualizar o que? Selecione uma opção: ");
            opcao = input.nextInt();
            System.out.println("\t==========================================");

            if (opcao == 1){
                System.out.println("Atualize o número da sala: ");
                String num = input.next();
                sala[e].setNumero(num);
                System.out.println("<Número da sala atualizado>");
            }

            if (opcao == 2){
                System.out.println("Atualize o nome do professor: ");
                String num = input.next();
                sala[e].setNome_professor(num);
                System.out.println("<Nome atualizado atualizado>");
            }

            if (opcao == 3){
                System.out.println("Atualize o número do andar: ");
                int num = input.nextInt();
                sala[e].setAndar(num);
                System.out.println("<Número do andar atualizado>");
            }


        }while (opcao != 0);

            System.out.println("Atualização realizada com sucesso");    



        }
        else{
            System.out.println("Essa sala não existe, favor escolher outra...");
        }
    }
    else
        System.out.println("Não existe salas para atualizar!");
          
    
        
    
}

}
