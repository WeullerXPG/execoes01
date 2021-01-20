package model.exceptions;

public class DomainException extends Exception{
									/* EXCEPTION: COMPILADOR OBRIGA A TRATAR OU PROPAGAR
									 * RUNTIMEEXCEPTION: COMPILADOR NÃO OBRIGA
									 */
	private static final long serialVersionUID = 1L;
	
	public DomainException(String msg) {
		super(msg);
	}

}
