package yangxinwu.algorithm;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {


    public List<String> generateParentheses(int n){
        List<String> result = new ArrayList<String>();
        generateAll(new char[n * 2],0,result);
        return result;
    }

    public void generateAll(char[] chars, int pos, List<String> result) {

        if (pos == chars.length){

            if (valid(chars)){
                result.add(new String(chars));
            }

        }else {

            chars[pos] = '(';

            String s1 = "" ;
            for (char aChar : chars) {
                s1 = s1 + aChar;
            }
            System.out.println("1-----------   " + s1);
            generateAll(chars,pos+1,result);



            chars[pos] = ')';
            String s2 = "" ;
            for (char aChar : chars) {
                s2 = s2 + aChar;
            }
            System.out.println("2-----------   " + s2);
            generateAll(chars,pos+1,result);



        }
    }

    public boolean valid(char[] chars) {
        int balance = 0;
        for (char aChar : chars) {
            if ('(' == aChar) {
                balance++;
            } else
                balance--;

            if (balance < 0) {
                return false;
            }
        }

        return balance == 0;
    }

    public static void main(String[] args){
        List<String> result = new GenerateParentheses().generateParentheses(3);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).toString());
        }
    }


}
