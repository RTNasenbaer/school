public class Abonnent {

    private String eMail;

    public Abonnent(String mail) {
        eMail = mail;
    }

    public boolean istKleinerAls(String text) {
        if (text.compareToIgnoreCase(eMail) < 0) return true;
        return false;
    }

    public boolean istGroeßerAls(String text) {
        if (text.compareToIgnoreCase(eMail) > 0) return true;
        return false;
    }

    public String ausgeben() {
        return eMail;
    }

}
