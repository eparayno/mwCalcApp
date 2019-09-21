package sample;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Calculator {
    static String molecule;
    static Stack<String> groups = new Stack<>();
    static Map<String, Integer> elementCounter = new HashMap<>();
    static Map<String, Double> massData = new HashMap<>();
    public static double totalMass = 0.00000;

    public Calculator(String userInput) throws FileNotFoundException {
        initializePeriodicTable();

        molecule = userInput;
        calculateMass(molecule);
    }

    static void calculateMass(String molecule) {
        String prevElement = "";
        for (int i = 0; i < molecule.length(); i++) {
            String currentChar = String.valueOf(molecule.charAt(i));
            char nextChar = '$';

            if (i < molecule.length() - 1) {
                nextChar = molecule.charAt(i + 1);
            }

            if (currentChar.equals("(")) {
                updateMass();
                elementCounter.clear();
                groups.push(currentChar);
            } else if (currentChar.equals(")")) {
                groups.pop();
            } else if (currentChar.chars().allMatch(Character::isDigit)) {
                if (String.valueOf(nextChar).chars().allMatch(Character::isDigit)) {
                    currentChar = currentChar + nextChar;
                    i += 1;
                }
                int multiplier = Integer.valueOf(currentChar);
                String prevChar = String.valueOf(molecule.charAt(i - 1));
                if (prevChar.equals(")")) {
                    for (String element : elementCounter.keySet()) {
                        elementCounter.put(element, elementCounter.get(element) * multiplier);
                    }
                } else {
                    elementCounter.put(prevElement, elementCounter.get(prevElement) * multiplier);
                }
            } else {
                if (Character.isLetter(nextChar) && Character.isLowerCase(nextChar)) {
                    currentChar = currentChar + nextChar;
                    i += 1;
                }
                addElement(currentChar);
                prevElement = currentChar;
            }
        }
        updateMass();
    }

    static void addElement(String currentChar){
        if (elementCounter.containsKey(currentChar)) {
            elementCounter.put(currentChar, elementCounter.get(currentChar) + 1);
        } else {
            elementCounter.put(currentChar, 1);
        }
    }

    static void updateMass(){
        Double mass = 0.00000;
        for (String element : elementCounter.keySet()) {
            mass += elementCounter.get(element) * massData.get(element);
        }
        if(!elementCounter.isEmpty()) {
            System.out.println(elementCounter);
        }
        totalMass += mass;
    }


    static void initializePeriodicTable() {
        massData.put("Ac", 227.00	);
        massData.put("Al",26.9815	);
        massData.put("Am",243.00	);
        massData.put("Sb",121.75	);
        massData.put("Ar",39.948	);
        massData.put("As",74.9216	);
        massData.put("At",210.00	);
        massData.put("Ba",137.00	);
        massData.put("Bk",247.00	);
        massData.put("Be",9.0122	);
        massData.put("Bi",208.98	);
        massData.put("B",10.81	);
        massData.put("Br",79.904	);
        massData.put("Ca",40.08	);
        massData.put("Cd",112.4	);
        massData.put("Cf",251.00	);
        massData.put("C",12.011	);
        massData.put("Ce",140.12	);
        massData.put("Cs",132.9054	);
        massData.put("Cl",35.453	);
        massData.put("Cr",51.996	);
        massData.put("Co",58.9332	);
        massData.put("Cu",63.546	);
        massData.put("Cm",247.00	);
        massData.put("Dy",162.5	);
        massData.put("Es",254.00	);
        massData.put("Er",167.26	);
        massData.put("Eu",151.96	);
        massData.put("Fm",257.00	);
        massData.put("F",18.9984	);
        massData.put("Fr",223.00	);
        massData.put("Gd",157.25	);
        massData.put("Ga",69.72	);
        massData.put("Ge",72.59	);
        massData.put("Au",196.966	);
        massData.put("Hf",178.49	);
        massData.put("He",4.0026	);
        massData.put("Ho",164.93	);
        massData.put("H",1.0079	);
        massData.put("In",114.82	);
        massData.put("I",126.904	);
        massData.put("Ir",192.22	);
        massData.put("Fe",55.847	);
        massData.put("Kr",83.8	);
        massData.put("La",138.905	);
        massData.put("Lr",256.00	);
        massData.put("Pb",207.2	);
        massData.put("Li",6.941	);
        massData.put("Lu",174.97	);
        massData.put("Mg",24.305	);
        massData.put("Mn",54.938	);
        massData.put("Md",258.00	);
        massData.put("Hg",200.59	);
        massData.put("Mo",95.94	);
        massData.put("Nd",144.24	);
        massData.put("Ne",20.179	);
        massData.put("Np",237.048	);
        massData.put("Ni",58.7	);
        massData.put("Nb",92.9064	);
        massData.put("N",14.0067	);
        massData.put("No",255.00	);
        massData.put("Os",190.2	);
        massData.put("O",15.9994	);
        massData.put("Pd",106.4	);
        massData.put("P",30.9738	);
        massData.put("Pt",195.09	);
        massData.put("Pu",244.00	);
        massData.put("Po",210.00	);
        massData.put("K",39.098	);
        massData.put("Pr",140.908	);
        massData.put("Pm",147.00	);
        massData.put("Pa",231.036	);
        massData.put("Ra",226.025	);
        massData.put("Rn",222.00	);
        massData.put("Re",186.207	);
        massData.put("Rh",102.906	);
        massData.put("Rb",85.4678	);
        massData.put("Ru",101.07	);
        massData.put("Rf",261.00	);
        massData.put("Sm",150.4	);
        massData.put("Sc",44.9559	);
        massData.put("Se",78.96	);
        massData.put("Si",28.086	);
        massData.put("Ag",107.868	);
        massData.put("Na",22.9898	);
        massData.put("Sr",87.62	);
        massData.put("S",32.06	);
        massData.put("Ta",180.948	);
        massData.put("Tc",98.9062	);
        massData.put("Te",127.6	);
        massData.put("Tb",158.925	);
        massData.put("Tl",204.37	);
        massData.put("Th",232.038	);
        massData.put("Tm",168.934	);
        massData.put("Sn",118.69	);
        massData.put("Ti",47.9	);
        massData.put("W",183.85	);
        massData.put("U",238.029	);
        massData.put("V",50.9414	);
        massData.put("Xe",131.3	);
        massData.put("Yb",173.04	);
        massData.put("Y",88.9059	);
        massData.put("Zn",65.38	);
        massData.put("Zr",91.22	);
    }

}
