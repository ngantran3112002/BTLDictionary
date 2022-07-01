package CommandLine;

public class Dictionary {
    private int size = 0;
    public Word[] word = new Word[100];
    Dictionary(){
        for(int i = 0 ; i < 100; i++) {
            word[i] = new Word();
        }
    }

    //getter, setter
    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}

