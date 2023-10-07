package br.com.ford.theplenos.exception;

public class IntegrationException extends RuntimeException {

    private String serviceName; // Nome do serviço externo que falhou
    private int errorCode;      // Código de erro da API externa

    public IntegrationException(String message) {
        super(message);
    }

    public IntegrationException(String message, String serviceName, int errorCode) {
        super(message);
        this.serviceName = serviceName;
        this.errorCode = errorCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public int getErrorCode() {
        return errorCode;
    }
}