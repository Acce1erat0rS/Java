public class EvenSingleSide {
    int from;
    int to;
    int step = 1;
    int current;

    public EvenSingleSide(int from,int to){
        this.from = from;
        this.to = to;
        current = from;
    }

    public EvenSingleSide(int from,int to,int step){
        this(from,to);
        this.step = step;
    }
}
