package FindingWords;

import edu.duke.*;

public class saveComparedWord {
    public String save(String palavraCorrigida, int count, StorageResource sr) {

        if (sr.contains(palavraCorrigida)){
            return "";
        }
        if (!sr.contains(palavraCorrigida) && count == 0) {
            return palavraCorrigida;
        }
        if (!sr.contains(palavraCorrigida) && count >= 1) {
            sr.add(palavraCorrigida);
            return palavraCorrigida;
        }
        return "";
    }
}