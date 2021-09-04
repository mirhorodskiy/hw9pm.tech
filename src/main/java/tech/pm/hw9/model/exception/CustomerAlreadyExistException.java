package tech.pm.hw9.model.exception;

public class CustomerAlreadyExistException extends Exception {
  public CustomerAlreadyExistException(String message) {
    super(message);
  }
}
