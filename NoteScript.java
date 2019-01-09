public class NoteScript {

    private String[] input = {"E", "A", "D", "G", "B", "E"}; //selected value of Strings
    private String input2 = "C/Am";
    private String input3 = "Natural Major";
    //private String[] keySignature = {"C/Am", "G/Em", "D/Bm", "A/F#m", "E/C#m", "B/G#m", "F#/D#m", "C#/A#m", "F/Dm", "Bb/Gm", "Eb/Cm", "Ab/Fm", "Db/Bbm", "Gb/Ebm", "Cb/Abm"}; //All possible key signature settings 
    private String[][] array = new String[12][6]; //empty final array
    private int[][] list = new int[12][6]; //empty int array pre-abstraction
    private ArrayList check = new ArrayList();
    //find user inputted setting, change note fonts accordingly 
    HashMap<String, ArrayList> map = new HashMap<>();

    public NoteScript() {
        input(list, input);
        fill(list);
        convert(list, array);
        boldKey();
    }

    public static void main(String[] args) {
        NoteScript c = new NoteScript();
    }

    public String[][] getArray() {
        return array;
    }

    public ArrayList getCheck() {
        return check;
    }

    public static void input(int[][] list, String[] input) { //first letter input to int
        for (int i = 0; i < list[i].length; i++) { //translates user letters to numbers for better handling 
            String ans = input[i];
            switch (ans) {
                case "C":
                    list[0][i] = 1;
                    break;

                case "C#":
                case "Db":
                    list[0][i] = 2;
                    break;

                case "D":
                    list[0][i] = 3;
                    break;

                case "D#":
                case "Eb":
                    list[0][i] = 4;
                    break;

                case "E":
                    list[0][i] = 5;
                    break;

                case "F":
                    list[0][i] = 6;
                    break;

                case "F#":
                case "Gb":
                    list[0][i] = 7;
                    break;

                case "G":
                    list[0][i] = 8;
                    break;

                case "G#":
                case "Ab":
                    list[0][i] = 9;
                    break;

                case "A":
                    list[0][i] = 10;
                    break;

                case "A#":
                case "Bb":
                    list[0][i] = 11;
                    break;

                case "B":
                    list[0][i] = 12;
                    break;

                default:
                    list[0][i] = 0;
                    break;
            }
        }
    }

    public static void fill(int[][] list) { //fills the array with specific integers
        for (int i = 1; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) { //stops at 12 frets
                list[i][j] = list[i - 1][j] + 1;
                if (list[i][j] > 12) {
                    list[i][j] -= 12;
                }
            }
        }
        //    System.out.println(Arrays.deepToString(list)); // check, delet this
    }

    public static void convert(int[][] list, String[][] array) { //converts ints to notes 
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) { //stops at 12 frets
                int ans = list[i][j];
                //changes ints into note strings
                switch (ans) {
                    case 1:
                        array[i][j] = "C";
                        break;

                    case 2:
                        array[i][j] = "C#/Db";
                        break;

                    case 3:
                        array[i][j] = "D";
                        break;

                    case 4:
                        array[i][j] = "D#/Eb";
                        break;

                    case 5:
                        array[i][j] = "E";
                        break;

                    case 6:
                        array[i][j] = "F";
                        break;

                    case 7:
                        array[i][j] = "F#/Gb";
                        break;

                    case 8:
                        array[i][j] = "G";
                        break;

                    case 9:
                        array[i][j] = "G#/Ab";
                        break;

                    case 10:
                        array[i][j] = "A";
                        break;

                    case 11:
                        array[i][j] = "A#/Bb";
                        break;

                    case 12:
                        array[i][j] = "B";
                        break;

                    default:
                        array[i][j] = "-";
                        break;
                }
            }
        }
    }

    private void boldKey() { //bolds letters in key
        //No sharps/flats
        //C/Am
        map.put("C/Am + Natural Major", new ArrayList<>(Arrays.asList("C", "D", "E", "F", "G", "A", "B")));
        map.put("C/Am + Natural Minor", new ArrayList<>(Arrays.asList("C", "D", "E", "F", "G", "A", "B")));
        map.put("C/Am + Pentatonic Major", new ArrayList<>(Arrays.asList("C", "D", "E", "G", "A")));
        map.put("C/Am + Pentatonic Minor", new ArrayList<>(Arrays.asList("A", "C", "D", "E", "G")));
        map.put("C/Am + Blues Scale", new ArrayList<>(Arrays.asList("A", "C", "D", "D#/Eb", "E", "G")));
        map.put("C/Am + Harmonic Minor", new ArrayList<>(Arrays.asList("C", "D", "E", "F", "G#/Ab", "A", "B")));
        map.put("C/Am + Melodic Minor", new ArrayList<>(Arrays.asList("C", "D", "E", "F#/Gb", "G#/Ab", "A", "B")));

        //Sharps
        //G/Em
        map.put("G/Em + Natural Major", new ArrayList<>(Arrays.asList("G", "A", "B", "C", "D", "E", "F#/Gb")));
        map.put("G/Em + Natural Minor", new ArrayList<>(Arrays.asList("G", "A", "B", "C", "D", "E", "F#/Gb")));
        map.put("G/Em + Pentatonic Major", new ArrayList<>(Arrays.asList("G", "A", "B", "D", "E")));
        map.put("G/Em + Pentatonic Minor", new ArrayList<>(Arrays.asList("E", "G", "A", "B", "D")));
        map.put("G/Em + Blues Scale", new ArrayList<>(Arrays.asList("E", "G", "A", "A#/Bb", "B", "D")));
        map.put("G/Em + Harmonic Minor", new ArrayList<>(Arrays.asList("G", "A", "B", "C", "D#/Eb", "E", "F#/Gb")));
        map.put("G/Em + Melodic Minor", new ArrayList<>(Arrays.asList("G", "A", "B", "C#/Db", "D#/Eb", "E", "F#/Gb")));
        //D/Bm
        map.put("D/Bm + Natural Major", new ArrayList<>(Arrays.asList("D", "E", "F#/Gb", "G", "A", "B", "C#/Db")));
        map.put("D/Bm + Natural Minor", new ArrayList<>(Arrays.asList("D", "E", "F#/Gb", "G", "A", "B", "C#/Db")));
        map.put("D/Bm + Pentatonic Major", new ArrayList<>(Arrays.asList("D", "E", "F#/Gb", "A", "B")));
        map.put("D/Bm + Pentatonic Minor", new ArrayList<>(Arrays.asList("B", "D", "E", "F#/Gb", "A")));
        map.put("D/Bm + Blues Scale", new ArrayList<>(Arrays.asList("B", "D", "E", "F", "F#/Gb", "A")));
        map.put("D/Bm + Harmonic Minor", new ArrayList<>(Arrays.asList("D", "E", "F#/Gb", "G", "A#/Bb", "B", "C#/Db")));
        map.put("D/Bm + Melodic Minor", new ArrayList<>(Arrays.asList("D", "E", "F#/Gb", "G#/Ab", "A#/Bb", "B", "C#/Db")));
        //A/F#m
        map.put("A/F#m + Natural Major", new ArrayList<>(Arrays.asList("A", "B", "C#/Db", "D", "E", "F#/Gb", "G#/Ab")));
        map.put("A/F#m + Natural Minor", new ArrayList<>(Arrays.asList("A", "B", "C#/Db", "D", "E", "F#/Gb", "G#/Ab")));
        map.put("A/F#m + Pentatonic Major", new ArrayList<>(Arrays.asList("A", "B", "C#/Db", "E", "F#/Gb")));
        map.put("A/F#m + Pentatonic Minor", new ArrayList<>(Arrays.asList("F#/Gb", "A", "B", "C", "C#/Db", "E")));
        map.put("A/F#m + Blues Scale", new ArrayList<>(Arrays.asList("F#/Gb", "A", "B", "C#/Db", "E")));
        map.put("A/F#m + Harmonic Minor", new ArrayList<>(Arrays.asList("D", "E", "F#/Gb", "G", "A#/Bb", "B", "C#/Db")));
        map.put("A/F#m + Melodic Minor", new ArrayList<>(Arrays.asList("D", "E", "F#/Gb", "G#/Ab", "A#/Bb", "B", "C#/Db")));
        //E/C#m
        map.put("E/C#m + Natural Major", new ArrayList<>(Arrays.asList("E", "F#/Gb", "G#/Ab", "A", "B", "C#/Db", "D#/Eb")));
        map.put("E/C#m + Natural Minor", new ArrayList<>(Arrays.asList("E", "F#/Gb", "G#/Ab", "A", "B", "C#/Db", "D#/Eb")));
        map.put("E/C#m + Pentatonic Major", new ArrayList<>(Arrays.asList("E", "F#/Gb", "G#/Ab", "B", "C#/Db")));
        map.put("E/C#m + Pentatonic Minor", new ArrayList<>(Arrays.asList("C#/Db", "E", "F#/Gb", "G#/Ab", "B")));
        map.put("E/C#m + Blues Scale", new ArrayList<>(Arrays.asList("C#/Db", "E", "F#/Gb", "G", "G#/Ab", "B")));
        map.put("E/C#m + Harmonic Minor", new ArrayList<>(Arrays.asList("E", "F#/Gb", "G#/Ab", "A", "C", "C#/Db", "D#/Eb")));
        map.put("E/C#m + Melodic Minor", new ArrayList<>(Arrays.asList("E", "F#/Gb", "G#/Ab", "A#/Bb", "C", "C#/Db", "D#/Eb")));
        //B/G#m
        map.put("B/G#m + Natural Major", new ArrayList<>(Arrays.asList("B", "C#/Db", "D#/Eb", "E", "F#/Gb", "G#/Ab", "A#/Bb")));
        map.put("B/G#m + Natural Minor", new ArrayList<>(Arrays.asList("B", "C#/Db", "D#/Eb", "E", "F#/Gb", "G#/Ab", "A#/Bb")));
        map.put("B/G#m + Pentatonic Major", new ArrayList<>(Arrays.asList("E", "F#/Gb", "G#/Ab", "B", "C#/Db")));
        map.put("B/G#m + Pentatonic Minor", new ArrayList<>(Arrays.asList("G#/Ab", "B", "C#/Db", "D#/Eb", "F#/Gb")));
        map.put("B/G#m + Blues Scale", new ArrayList<>(Arrays.asList("G#/Ab", "B", "C#/Db", "D", "D#/Eb", "F#/Gb")));
        map.put("B/G#m + Harmonic Minor", new ArrayList<>(Arrays.asList("B", "C#/Db", "D#/Eb", "E", "G", "G#/Ab", "A#/Bb")));
        map.put("B/G#m + Melodic Minor", new ArrayList<>(Arrays.asList("B", "C#/Db", "D#/Eb", "F", "G", "G#/Ab", "A#/Bb")));
        //F#/D#m
        map.put("F#/D#m + Natural Major", new ArrayList<>(Arrays.asList("F#/Gb", "G#/Ab", "A#/Bb", "B", "C#/Db", "D#/Eb", "F")));
        map.put("F#/D#m + Natural Minor", new ArrayList<>(Arrays.asList("F#/Gb", "G#/Ab", "A#/Bb", "B", "C#/Db", "D#/Eb", "F")));
        map.put("F#/D#m + Pentatonic Major", new ArrayList<>(Arrays.asList("F#/Gb", "G#/Ab", "A#/Bb", "C#/Db", "D#/Eb")));
        map.put("F#/D#m + Pentatonic Minor", new ArrayList<>(Arrays.asList("D#/Eb", "F#/Gb", "G#/Ab", "A#/Bb", "C#/Db")));
        map.put("F#/D#m + Blues Scale", new ArrayList<>(Arrays.asList("D#/Eb", "F#/Gb", "G#/Ab", "A", "A#/Bb", "C#/Db")));
        map.put("F#/D#m + Harmonic Minor", new ArrayList<>(Arrays.asList("F#/Gb", "G#/Ab", "A#/Bb", "B", "D", "D#/Eb", "F")));
        map.put("F#/D#m + Melodic Minor", new ArrayList<>(Arrays.asList("F#/Gb", "G#/Ab", "A#/Bb", "C", "D", "D#/Eb", "F")));
        //C#/A#m
        map.put("C#/A#m + Natural Major", new ArrayList<>(Arrays.asList("C#/Db", "D#/Eb", "F", "F#/Gb", "G#/Ab", "A#/Bb", "C")));
        map.put("C#/A#m + Natural Minor", new ArrayList<>(Arrays.asList("C#/Db", "D#/Eb", "F", "F#/Gb", "G#/Ab", "A#/Bb", "C")));
        map.put("C#/A#m + Pentatonic Major", new ArrayList<>(Arrays.asList("C#/Db", "D#/Eb", "F", "G#/Ab", "A#/Bb")));
        map.put("C#/A#m + Pentatonic Minor", new ArrayList<>(Arrays.asList("A#/Bb", "C#/Db", "D#/Eb", "F", "G#/Ab")));
        map.put("C#/A#m + Blues Scale", new ArrayList<>(Arrays.asList("A#/Bb", "C#/Db", "D#/Eb", "E", "F", "G#/Ab")));
        map.put("C#/A#m + Harmonic Minor", new ArrayList<>(Arrays.asList("C#/Db", "D#/Eb", "F", "F#/Gb", "A", "A#/Bb", "C")));
        map.put("C#/A#m + Melodic Minor", new ArrayList<>(Arrays.asList("C#/Db", "D#/Eb", "F", "G", "A", "A#/Bb", "C")));

        //Flats
        //F/Dm
        map.put("F/Dm + Natural Major", new ArrayList<>(Arrays.asList("F", "G", "A", "A#/Bb", "C", "D", "E")));
        map.put("F/Dm + Natural Minor", new ArrayList<>(Arrays.asList("F", "G", "A", "A#/Bb", "C", "D", "E")));
        map.put("F/Dm + Pentatonic Major", new ArrayList<>(Arrays.asList("F", "G", "A", "C", "D")));
        map.put("F/Dm + Pentatonic Minor", new ArrayList<>(Arrays.asList("D", "F", "G", "A", "C")));
        map.put("F/Dm + Blues Scale", new ArrayList<>(Arrays.asList("D", "F", "G", "G#/Ab", "A", "C")));
        map.put("F/Dm + Harmonic Minor", new ArrayList<>(Arrays.asList("F", "G", "A", "A#/Bb", "C#/Db", "D", "E")));
        map.put("F/Dm + Melodic Minor", new ArrayList<>(Arrays.asList("F", "G", "A", "B", "C#/Db", "D", "E")));
        //Bb/Gm
        map.put("Bb/Gm + Natural Major", new ArrayList<>(Arrays.asList("A#/Bb", "C", "D", "D#/Eb", "F", "G", "A")));
        map.put("Bb/Gm + Natural Minor", new ArrayList<>(Arrays.asList("A#/Bb", "C", "D", "D#/Eb", "F", "G", "A")));
        map.put("Bb/Gm + Pentatonic Major", new ArrayList<>(Arrays.asList("A#/Bb", "C", "D", "F", "G")));
        map.put("Bb/Gm + Pentatonic Minor", new ArrayList<>(Arrays.asList("G", "A#/Bb", "C", "D", "F")));
        map.put("Bb/Gm + Blues Scale", new ArrayList<>(Arrays.asList("G", "A#/Bb", "C", "C#/Db", "D", "F")));
        map.put("Bb/Gm + Harmonic Minor", new ArrayList<>(Arrays.asList("A#/Bb", "C", "D", "D#/Eb", "F#/Gb", "G", "A")));
        map.put("Bb/Gm + Melodic Minor", new ArrayList<>(Arrays.asList("A#/Bb", "C", "D", "E", "F#/Gb", "G", "A")));
        //Eb/Cm
        map.put("Eb/Cm + Natural Major", new ArrayList<>(Arrays.asList("D#/Eb", "F", "G", "G#/Ab", "A#/Bb", "C", "D")));
        map.put("Eb/Cm + Natural Minor", new ArrayList<>(Arrays.asList("D#/Eb", "F", "G", "G#/Ab", "A#/Bb", "C", "D")));
        map.put("Eb/Cm + Pentatonic Major", new ArrayList<>(Arrays.asList("D#/Eb", "F", "G", "A#/Bb", "C")));
        map.put("Eb/Cm + Pentatonic Minor", new ArrayList<>(Arrays.asList("C", "D#/Eb", "F", "G", "Bb")));
        map.put("Eb/Cm + Blues Scale", new ArrayList<>(Arrays.asList("C", "D#/Eb", "F", "F#/Gb", "G", "Bb")));
        map.put("Eb/Cm + Harmonic Minor", new ArrayList<>(Arrays.asList("D#/Eb", "F", "G", "G#/Ab", "B", "C", "D")));
        map.put("Eb/Cm + Melodic Minor", new ArrayList<>(Arrays.asList("D#/Eb", "F", "G", "A", "B", "C", "D")));
        //Ab/Fm
        map.put("Ab/Fm + Natural Major", new ArrayList<>(Arrays.asList("G#/Ab", "A#/Bb", "C", "C#/Db", "D#/Eb", "F", "G")));
        map.put("Ab/Fm + Natural Minor", new ArrayList<>(Arrays.asList("G#/Ab", "A#/Bb", "C", "C#/Db", "D#/Eb", "F", "G")));
        map.put("Ab/Fm + Pentatonic Major", new ArrayList<>(Arrays.asList("G#/Ab", "A#/Bb", "C", "D#/Eb", "F")));
        map.put("Ab/Fm + Pentatonic Minor", new ArrayList<>(Arrays.asList("F", "G#/Ab", "A#/Bb", "C", "D#/Eb")));
        map.put("Ab/Fm + Blues Scale", new ArrayList<>(Arrays.asList("F", "G#/Ab", "A#/Bb", "C", "D#/Eb")));
        map.put("Ab/Fm + Harmonic Minor", new ArrayList<>(Arrays.asList("G#/Ab", "A#/Bb", "C", "C#/Db", "E", "F", "G")));
        map.put("Ab/Fm + Melodic Minor", new ArrayList<>(Arrays.asList("G#/Ab", "A#/Bb", "C", "D", "E", "F", "G")));
        //Db/Bbm
        map.put("Db/Bbm + Natural Major", new ArrayList<>(Arrays.asList("C#/Db", "D#/Eb", "F", "F#/Gb", "G#/Ab", "A#/Bb", "C")));
        map.put("Db/Bbm + Natural Minor", new ArrayList<>(Arrays.asList("C#/Db", "D#/Eb", "F", "F#/Gb", "G#/Ab", "A#/Bb", "C")));
        map.put("Db/Bbm + Pentatonic Major", new ArrayList<>(Arrays.asList("C#/Db", "D#/Eb", "F", "G#/Ab", "A#/Bb")));
        map.put("Db/Bbm + Pentatonic Minor", new ArrayList<>(Arrays.asList("A#/Bb", "C#/Db", "D#/Eb", "F", "G#/Ab")));
        map.put("Db/Bbm + Blues Scale", new ArrayList<>(Arrays.asList("A#/Bb", "C#/Db", "D#/Eb", "E", "F", "G#/Ab")));
        map.put("Db/Bbm + Harmonic Minor", new ArrayList<>(Arrays.asList("C#/Db", "D#/Eb", "F", "F#/Gb", "A", "A#/Bb", "C")));
        map.put("Db/Bbm + Melodic Minor", new ArrayList<>(Arrays.asList("C#/Db", "D#/Eb", "F", "G", "A", "A#/Bb", "C")));
        //Gb/Ebm
        map.put("Gb/Ebm + Natural Major", new ArrayList<>(Arrays.asList("F#/Gb", "G#/Ab", "A#/Bb", "B", "C#/Db", "D#/Eb", "F")));
        map.put("Gb/Ebm + Natural Minor", new ArrayList<>(Arrays.asList("F#/Gb", "G#/Ab", "A#/Bb", "B", "C#/Db", "D#/Eb", "F")));
        map.put("Gb/Ebm + Pentatonic Major", new ArrayList<>(Arrays.asList("F#/Gb", "G#/Ab", "A#/Bb", "C#/Db", "D#/Eb")));
        map.put("Gb/Ebm + Pentatonic Minor", new ArrayList<>(Arrays.asList("D#/Eb", "F#/Gb", "G#/Ab", "A#/Bb", "C#/Db")));
        map.put("Gb/Ebm + Blues Scale", new ArrayList<>(Arrays.asList("D#/Eb", "F#/Gb", "G#/Ab", "A", "A#/Bb", "C#/Db")));
        map.put("Gb/Ebm + Harmonic Minor", new ArrayList<>(Arrays.asList("F#/Gb", "G#/Ab", "A#/Bb", "B", "D", "D#/Eb", "F")));
        map.put("Gb/Ebm + Melodic Minor", new ArrayList<>(Arrays.asList("F#/Gb", "G#/Ab", "A#/Bb", "C", "D", "D#/Eb", "F")));
        //B/Abm
        map.put("B/Abm + Natural Major", new ArrayList<>(Arrays.asList("B", "C#/Db", "D#/Eb", "E", "F#/Gb", "G#/Ab", "A#/Bb")));
        map.put("B/Abm + Natural Minor", new ArrayList<>(Arrays.asList("B", "C#/Db", "D#/Eb", "E", "F#/Gb", "G#/Ab", "A#/Bb")));
        map.put("B/Abm + Pentatonic Major", new ArrayList<>(Arrays.asList("B", "C#/Db", "D#/Eb", "F#/Gb", "G#/Ab")));
        map.put("B/Abm + Pentatonic Minor", new ArrayList<>(Arrays.asList("G#/Ab", "B", "C#/Db", "D#/Eb", "F#/Gb")));
        map.put("B/Abm + Blues Scale", new ArrayList<>(Arrays.asList("G#/Ab", "B", "C#/Db", "D", "D#/Eb", "F#/Gb")));
        map.put("B/Abm + Harmonic Minor", new ArrayList<>(Arrays.asList("B", "C#/Db", "D#/Eb", "E", "G", "G#/Ab", "A#/Bb")));
        map.put("B/Abm + Melodic Minor", new ArrayList<>(Arrays.asList("B", "C#/Db", "D#/Eb", "F", "G", "G#/Ab", "A#/Bb")));

        check = map.get(input2 + " + " + input3);
        System.out.println(check.size());
    }

    public static void print(String[][] array) { // prints array
        for (int i = 0; i < array[i].length; i++) {
            for (int j = 0; j < array.length; j++) { //stops at 12 frets
                System.out.print(array[j][i] + " ");
            }
            System.out.println("");
        }
    }
}

