import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ProteinTranslator {

    List<String> translate(String rnaSequence) {
        List<String> proteins = new ArrayList<>();
        for (int i = 0; i < rnaSequence.length(); i += 3) {
            String prot = CODON_PROTEIN.get(rnaSequence.substring(i, i + 3));
            if (prot.equals("STOP")){
                break;
            }
            proteins.add(prot);
        }
        return proteins;
    }

    private static final Map<String, String> CODON_PROTEIN = new HashMap<String, String>() {
        {
            put("AUG", "Methionine");
            put("UUU", "Phenylalanine");
            put("UUC", "Phenylalanine");
            put("UUA", "Leucine");
            put("UUG", "Leucine");
            put("UCU", "Serine");
            put("UCC", "Serine");
            put("UCA", "Serine");
            put("UCG", "Serine");
            put("UAU", "Tyrosine");
            put("UAC", "Tyrosine");
            put("UGU", "Cysteine");
            put("UGC", "Cysteine");
            put("UGG", "Tryptophan");
            put("UAA", "STOP");
            put("UAG", "STOP");
            put("UGA", "STOP");
        }
    };
}