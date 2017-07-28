package co.com.emidata.security.jwt;

/**
 *
 * @author janez
 */
public class TokenValidation {

    public enum ValidationErrorType {
        UNAUTHORIZED_USER,
        EXPIRED_TOKEN,;
    }

    private boolean valid;
    private String username;
    private ValidationErrorType validationErrorType;

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ValidationErrorType getValidationErrorType() {
        return validationErrorType;
    }

    public void setValidationErrorType(ValidationErrorType validationErrorType) {
        this.validationErrorType = validationErrorType;
    }
}
