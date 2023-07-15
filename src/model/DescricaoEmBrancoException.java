package model;

public class DescricaoEmBrancoException extends Exception {
    
    public DescricaoEmBrancoException(String causa) {
        super("Preencha todos os campos!\nCausa: "+ causa);
    }
}
