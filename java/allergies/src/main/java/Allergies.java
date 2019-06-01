import java.util.ArrayList;
import java.util.List;

public class Allergies {

    private final List<Allergen> allergens = new ArrayList<>();

    public Allergies(int i) {
        convertToAllergens(i);
    }

    private void convertToAllergens(int number) {
        for (int i = 0; i < 8; i++) {
            for (Allergen allergen : Allergen.values()) {
                if ((number & (1 << i)) == allergen.getScore()) {
                    allergens.add(allergen);
                    break;
                }
            }
        }
    }

    public boolean isAllergicTo(Allergen peanuts) {
        return allergens.contains(peanuts);
    }

    public List<Allergen> getList() {
        return allergens;
    }
}
