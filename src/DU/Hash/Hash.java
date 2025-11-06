package DU.Hash;

public class Hash {

    public static void main(String[] args) {
        int target = mujHash("ProgramovaT");
        findHash(target);
    }

    private static void findHash(int target) {
        int index=0;
        //for zacina na 32 (mezera), aby nasel i retezce mensi nez 3 znaky (3 for cykly)
        // musi preskocit '[' az '`' , aby se dostal ze 'Z' na 'a'
        //pouziti vic nez 4 for cyklu je zybtecne protoze 3-znakovych retezcu se stejnym hashem je vic nez 5
        for(char a=(char)32; a<'z'; a++){
            if(a==(char)33){
                a='A';
            }
            if(a=='['){
                a='`';
                continue;
            }
            for(char b=(char)32; b<'z'; b++) {
                if(b==(char)33){
                    b='A';
                }
                if(b=='['){
                    b='`';
                    continue;
                }
                for (char c=(char)32; c < 'z'; c++) {
                    if(c==(char)33){
                        c='A';
                    }
                    if(c=='['){
                        c='`';
                        continue;
                    }

                    String str = String.valueOf((char) a) + String.valueOf((char) b) + String.valueOf((char) c);
                    if (mujHash(str) == target) {
                        System.out.println(str);
                        index++;
                        if(index >=5){
                            return;
                        }
                    }
                }
            }
        }
    }

    static int mujHash(String str) {
        int out = 1;
        for (char ch: str.toCharArray()) {
            out = (out * (int)ch) % 9973;
        }
        return out;
    }
}
