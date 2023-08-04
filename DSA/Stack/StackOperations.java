class StackOperations{
  public static String toPostfix(String infix){
        infix="("+infix+")";
        Stack<Character> s=new Stack<>();
        String postfix="";
        
        for(int i=0;i<infix.length();i++){
            char ch=infix.charAt(i);
            if(isOperand(ch)){
                postfix+=ch;
            }
            else if(ch == '('){
                s.push(ch);
            }
            else if(isOperator(ch)){
                while(!s.isEmpty() && precedence(ch) <= precedence(s.peek())){
                    postfix+=s.pop();
                }
                s.push(ch);
            }
            else if(ch == ')'){
                while(!s.isEmpty() && s.peek() != '('){
                    postfix+=s.pop();
                }
                if(!s.isEmpty())
                s.pop();
            }
            
        }
        return postfix;
    }
  public static String toPrefix(String infix){
        infix=new StringBuilder(infix).reverse().toString();
        Stack<Character> s=new Stack<>();
        String prefix="";
        for(int i=0;i<infix.length();i++){
            char ch=infix.charAt(i);
            if(isOperand(ch)){
                prefix+=ch;
            }
            else if(ch == ')'){
                s.push(ch);
            }
            else if(isOperator(ch)){
                while(!s.isEmpty() && precedence(ch) < precedence(s.peek())){
                    prefix+=s.pop();
                }
                s.push(ch);
            }
            else if(ch == '('){
                while(!s.isEmpty() && s.peek() != ')'){
                    prefix+=s.pop();
                }
                if (!s.isEmpty() && s.peek() == ')') {
                    s.pop();
                }   
            }
        }
        while (!s.isEmpty()) {
            prefix+=s.pop();
        }
        return new StringBuilder(prefix).reverse().toString();
    }

   public static boolean isOperand(char o){
        return (o >= 'a' && o <= 'z') 
            || (o >= 'A' && o<= 'Z') 
            || (o >= '0' && o <= '9');
    }
    public static boolean isOperator(char o){
        switch(o){
            case '^':
            case '*':
            case '/':
            case '+':
            case '-':
                return true;
            default:
                return false;
        }
    }
    public static int precedence(char o){
        switch(o){
            case '^':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }
    
   static int evaluate(String postfix){
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<postfix.length();i++){
            char ch=postfix.charAt(i);
            if(Character.isDigit(ch)){
                s.push(ch - '0');
            }
            else if(isOperator(ch)){
                s.push(calc(s.pop(), s.pop(), ch));
            }
        }
        return s.pop();
    }
    static int calc(int a,int b,char op){
        switch(op){
            case '+':
                return b+a;
            case '-':
                return b-a;
            case '*':
                return b*a;
            case '/':
                return b/a;
            case '^':
                return (int)Math.pow(b, a);
            default:
                return 0;
        }
    }
    
    
}
