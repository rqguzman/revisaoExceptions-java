package exercicios.section9.resolvido.model.exceptions;

//public class DomainException extends Exception { // OBRIGA A TRATAR AS EXCEÇÕES NO CÓDIGO 
	public class DomainException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DomainException(String msg) {
		super(msg);
	}

}
