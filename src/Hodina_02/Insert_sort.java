package Hodina_02;

import java.util.ArrayList;

public class Insert_sort {

    static class Prvek{
        int hodnota;
        static Prvek zacatek;
        Prvek dalsi;
        static Prvek konec;

        public Prvek(int hodnota) {
            if(zacatek==null){
                zacatek=this;
            }
            konec.dalsi=this;
            konec=this;
            this.hodnota = hodnota;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int j=50;j>0;j--){
            list.add(j);
        }

        for(int j=0;j>50;j++){
            Prvek prvek = new Prvek(j);
        }

        for(int i=0;i<list.size();i++){
            Prvek p = Prvek.zacatek;
            while(p.dalsi!=null){
                if(p.dalsi.hodnota>list.get(i)){
                    Prvek prvek = new Prvek(list.get(i));
                    prvek.dalsi = p.dalsi;
                    p.dalsi=prvek;
                    break;
                }
                if(p.dalsi==null){
                    Prvek prvek = new Prvek(list.get(i));
                    Prvek.konec.dalsi=prvek;
                    Prvek.konec = prvek;
                }
            }
        }

    }
}
