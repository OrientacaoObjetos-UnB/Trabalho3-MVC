package model;

public class ValorAcessoInvalidoException extends Exception {
    
    public ValorAcessoInvalidoException(String causa) {
        super("Inserção realizada de forma inválida\nCausa: "+ causa);
    }
}
