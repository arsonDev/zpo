import java.util.*;

public class CyclistList {
    List<Cyclist> cyclists = new ArrayList<>();

    public CyclistList(HashSet surnameList, int cyclistOnRace){
        int size = surnameList.size();
        for (int i = 0; i < cyclistOnRace; i++) {
            int item = new Random().nextInt(size);
            int j = 0;
            for (Object obj : surnameList) {
                if (j == item) {
                    Cyclist newKolarz = new Cyclist(obj.toString());
                    this.cyclists.add(newKolarz);
                }
                j++;
            }
        }
    }
}
