package sample;


    public class History {
        public static String[] history = new String[5];
         private static int hindex=0;

        public static int getHindex()
        {
            return hindex;
        }

        public static void setHindex() {
            History.hindex ++;
        }			//for use in other class
        public static void newHindex(){History.hindex+=1;}
        public void shift() {
            for(int i=0;i<4;i++) {
                history[i]=history[i+1];
            }
        }
        public String historyNext() {
            hindex = hindex + 1 ;
            if(hindex > 4) {
                hindex = 4 ;
                return "No access";
            }
            else
                return history[hindex];

        }
        public String historyPrevious() {

             hindex = hindex - 1;

            if(hindex < 0) {
                hindex = 0 ;
                return "No access";
            }
            else if(hindex>4){

                hindex = 4;
                return history[hindex];
            }
            else
                return history[hindex];
        }
        public static void show(){
            for(int j=0;j<5;j++)
                System.out.println(history[j]);
        }
    }


