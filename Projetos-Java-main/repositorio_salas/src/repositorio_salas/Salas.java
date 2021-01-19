
package repositorio_salas;

    //classe
    public class Salas {
        private String numero;
        private String nome_professor;
        private int andar;
    
    // construtor
    public Salas(String numero, String nome, int andar) {
        this.numero = numero; 
        this.nome_professor = nome;
        this.andar = andar; 
    }
    
    //get e set do numero
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    //get e set do nome do professor
    public String getNome_professor() {
        return nome_professor;
    }

    public void setNome_professor(String nome) {
        this.nome_professor = nome;
    }
    
    //get e set do Andar
    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }
    
    
}
