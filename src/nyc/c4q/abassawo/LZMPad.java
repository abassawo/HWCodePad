package nyc.c4q.abassawo;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by c4q-Abass on 11/4/15.
 */
public class LZMPad {

    private String decompressData(List<Integer> compressed){
        return " ";
    }

    private byte[] getCharsAsBytes(String decompressed) {
        int length = decompressed.length();
        ByteBuffer buffer = ByteBuffer.allocate(length);
        for (int i = 0; i < length; i++) {
            buffer.put((byte) decompressed.codePointAt(i));
        }
        return buffer.array();
    }

    public String decompress(String data) {
        return "";
    }
}
