package Java2.TT.PI1;

import java.security.InvalidParameterException;

public class Exercicio1 {
    public static void main(String[] args) {
        PasswordFraca fraca = new PasswordFraca();
        fraca.setValue("testeteste1");
        PasswordMedia media = new PasswordMedia();
        media.setValue("testeteste1#");
        PasswordForte forte = new PasswordForte();
        forte.setValue("Testeteste1*");
    }
}

abstract class Senha {
    private String regex;

    public Senha(String regex) {
        this.regex = regex;
    }

    public void setValue(String pwd) {
        if (!pwd.matches(this.regex)) {
            throw new InvalidParameterException("A senha não se encaixa nos parâmetros de segurança.");
        }
    }
}

class PasswordForte extends Senha{
    public PasswordForte(){
        super("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
    }
}

class PasswordMedia extends Senha {
    public PasswordMedia() {
        super("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$");
    }
}

class PasswordFraca extends Senha {
    public PasswordFraca() {
        super("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
    }
}
