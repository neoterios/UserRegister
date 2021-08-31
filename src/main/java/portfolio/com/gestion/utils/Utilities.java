package portfolio.com.gestion.utils;

public class Utilities {
    private static final String PATRON_EMAIL = "[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[.][cl]{2,5}";
    private static final String PATRON_PASSWORD = "^((.*?[A-Z]){1,}.*)((.*?[0-9]){2,}.*)$";

    public static boolean validadorCorreo(String email){
        return email.matches(PATRON_EMAIL);
    }

    public static boolean validadorPassword(String password){
        return password.matches(PATRON_PASSWORD);
    }

}
