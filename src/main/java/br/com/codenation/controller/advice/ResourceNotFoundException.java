package br.com.codenation.controller.advice;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resourceName) {
        super("Recurso: " + resourceName + " não encontrado");
    }
}
