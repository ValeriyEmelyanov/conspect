package patterns.behavioral_patterns.strategy_withlambda_encoder;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Base64;

public class Main {
    public static void main(String[] args) {
        byte[] text = "Some data :)".getBytes();

        Encoder base64Encoder = new Encoder(d -> Base64.getEncoder().encodeToString(d));
        Encoder hexEncoder = new Encoder(d -> new BigInteger(1, d).toString(16));
        Encoder utfEncoder = new Encoder(d -> Arrays.toString(d));

        base64Encoder.printEncoded(text);
        hexEncoder.printEncoded(text);
        utfEncoder.printEncoded(text);
    }
}
