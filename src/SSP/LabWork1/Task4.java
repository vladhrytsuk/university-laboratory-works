package SSP.LabWork1;

public class Task4 {
    public static void main(String[] args) {
        String key[] = {"-version", "-verbose", "-help", "-quit", "-support", "-bash", "-wtf"};
        for (int i = 0; i < args.length; i++) {
            for (int j = 0; j < key.length; j++) {
                if(args[i].equals(key[j]) == true){
                    System.out.println(args[i] + " Found!");
                } else if(args[i].equals(key[j]) == false) {
                    System.out.println(args[i] + " Not found!");
                } else continue;
            }
        }
    }
}
