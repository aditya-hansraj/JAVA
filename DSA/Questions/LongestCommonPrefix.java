class QC {
    public static void main(String[] args) {
        String[] ar = {"asflower","aflow","adflo"+"aqflos"};
        System.out.println(LongestCommonPrefix(ar));
    }

    static String LongestCommonPrefix(String[] ar){
        int s = 0;
        do{
            boolean x = true;
            char ch = ar[0].charAt(s);
            for(int i = 1; i < ar.length; i++){
                if(s==ar[i].length() || ch != ar[i].charAt(s)){
                    x = false;
                    break;
                }
            }
            if(x==true){
                s++;
            }
            else
                break;
            
        }while(true);
        if(s==0){
            System.out.println("No common prefix !");
            return "";
        }else
                return ar[0].substring(0,s);
    }
}
