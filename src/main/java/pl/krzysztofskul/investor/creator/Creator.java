package pl.krzysztofskul.investor.creator;

import java.util.HashSet;
import java.util.Random;

public class Creator {

    private static Creator creator;

    private Random random = new Random();

    private HashSet<String> investorNames = new HashSet<>();
    private HashSet<String> companyNames = new HashSet<>();
    private HashSet<String> hospitalNames = new HashSet<>();
    private HashSet<String> companyTypes = new HashSet<>();
    private HashSet<String> companyCities = new HashSet<>();
    private HashSet<String> companyStreets = new HashSet<>();

    private Creator() {
        investorNames.add("MED-INVEST");
        investorNames.add("MEDIC-INVESTMENT");
        investorNames.add("INVEST-MED");
        investorNames.add("HOSPITAL INVESTMENTS");
        investorNames.add("MEDICARE INVEST.");
        investorNames.add("MED & TECH INVEST.");
        investorNames.add("TECH-MED INVESTMENT");
        investorNames.add("MED-TECHNOLOGY INVEST.");
        investorNames.add("MEDTECH-INVESTMENT");

        companyNames.add("Flex-tech");
        companyNames.add("Med-tech");
        companyNames.add("Med. & Tech.");

        hospitalNames.add("Szpital centralny");
        hospitalNames.add("Szpital powiatowy");
        hospitalNames.add("Szpital kliniczny");
        hospitalNames.add("Szpital gminny");
        hospitalNames.add("Szpital wojskowy");

        companyTypes.add("GmbH & Co.");
        companyTypes.add("S.C.");
        companyTypes.add("S.A.");
        
        companyCities.add("Warszawa");
        companyCities.add("Łódź");
        companyCities.add("Kraków");
        companyCities.add("Berlin");
        companyCities.add("Helsinki");
        companyCities.add("Wilno");

        companyStreets.add("Testowa");
        companyStreets.add("Przykładowa");
        companyStreets.add("Próbna");
        companyStreets.add("Kontrolna");
        companyStreets.add("Eksperymentalna");
        companyStreets.add("Doświadczalna");

    }

    public static Creator getCreator() {
        if (creator != null) {
            return creator;
        } else {
            return new Creator();
        }
    }

    public String getRandomCity() {
        String[] arr = companyCities.toArray(new String[companyCities.size()]);
        return arr[random.nextInt(arr.length)];
    }
    
    public String getRandomStreet() {
        String[] arr = companyStreets.toArray(new String[companyStreets.size()]);
        return arr[random.nextInt(arr.length)];
    }

    public String getRandomPostalCode() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j <= 5; j++) {
            if (j != 2) {
                stringBuilder.append(new Random().nextInt(9));
            } else {
                stringBuilder.append("-");
            }
        }
        return stringBuilder.toString();
    }

}