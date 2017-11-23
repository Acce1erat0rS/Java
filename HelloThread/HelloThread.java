public class HelloThread{
    public static void main(String[] args){
        Compute[] c = new Compute[12];
        for(int i = 0;i<12;i++){
            c[i] = new Compute(i);
            c[i].start();
            try{
                Thread.sleep(40);
            }catch(Exception exp){

            }
        }
    }
}

class Compute extends Thread{
	int number;
	public Compute(int number){
	    this.number = number;
    }

    @Override
    public void run(
    ) {
        super.run();
        for(int i=0;i<20;i++){
            System.out.println("------------");

            System.out.println("Thread:"+number);
            System.out.println("Doing:"+i);
            System.out.println("------------");


            try{
                Thread.sleep(400);
            }catch(Exception exp){

            }
        }

    }
}
