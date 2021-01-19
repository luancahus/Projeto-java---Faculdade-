
package repositorio_salas;

import java.util.Scanner;


public class Repositorio_salas {

    public static void main(String[] args) throws InterruptedException {
        String numero, nome; 
            
        int opcao, qnt, andar,rep;
            
            Scanner input = new Scanner(System.in);
            
            System.out.print("Digite o tamanho do repositório: ");
            rep = input.nextInt();
            
             //objeto criado da classe repositorio salas
            RepositorioSalasArray r = new RepositorioSalasArray(rep);
            
            do{ 
                Thread.sleep(1000);
                System.out.println("---------- Menu de opções ----------");
                System.out.print("1 - Inserir\n"
                        + "2 - Consultar\n"
                        + "3 - Remover\n"
                        + "4 - Atualizar\n"
                        + "5 - Listar tudo cadastrado\n"
                        + "0 - Sair do repositório\n"
                        + "Selecione uma opção:");
                opcao = input.nextInt();          
                System.out.println("------------------------------------");
                
                if (opcao == 1){
                    System.out.println(" ");
                    //inserir a quantidade de salas 
                    System.out.print("Quer INSERIR quantas salas? ");
                    qnt = input.nextInt();
                    //laço de repetição para inserir numero, nome do professor e andar das salas
                    for(int i=0; i<qnt; i++){
                    System.out.print("Digite o numero da "+(i+1)+"° sala: ");
                    numero = input.next();

                    System.out.print("Digite o nome do professor da "+(i + 1)+"° sala: ");
                    nome = input.next();

                    System.out.print("Digite o andar da "+(i + 1)+"° sala: ");
                    andar = input.nextInt();
                    
                    System.out.println(" ");
                    // inserir os parametros no objeto criado
                    Salas s = new Salas(numero, nome, andar);
                    // chamada ao método inserir
                    r.inserir(s);
                    
                    }
                    
                }
         
                else if(opcao == 2){
                    // inserir o numero da sala a ser consultado
                    System.out.print("Digite o numero da sala que deseja CONSULTAR: ");
                    numero = input.next();
                    // chamada ao método consultar
                    Salas p = (Salas) r.consultar(numero);
                    System.out.println(" ");
                    if (p == null){
                        System.out.println("A sala "+numero+" NÃO está cadastrada!");                    
                        
                    }else
                        System.out.println("A sala "+p.getNumero()+" ja está cadastrada!");
                }
                
                else if(opcao == 3){
                    r.remover();
                    
                }
                
                else if (opcao == 4){
                    r.atualizar();
                }
                
                
                else if(opcao == 5){
                    
                    r.exibirrepositorio();
                }
                
                else if(opcao > 5 )
                        System.out.println("Opção inválida...");
                else if(opcao < 0 )
                        System.out.println("Opção inválida...");
                
                System.out.println(" ");
                
                
                    
                
            } while (opcao != 0);
           

            

            
    }

    
}
