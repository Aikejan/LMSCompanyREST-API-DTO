package peaksoft.exception;

public class BadCredentialException extends  RuntimeException {
    public BadCredentialException(String wrongPassword) {
        super("wrong exception");
    }

    // TUURA EMES DANNYYLARDY ZAPROS  BERSEK USHUL EXCEPTION YRGYTAT TUURA EMES  PASSWORD JE EMAIL BOLUSHU MUMKUN
}
