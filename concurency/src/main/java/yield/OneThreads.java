package yield;


public class OneThreads extends Thread {


        String name;

        public OneThreads(String name){
            this.name = name;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Приостановка текущего потока:" + name );
        }

}
