package com.problems.stack;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Stack;

public class InfixPostfixPrefixProblem {

    public static void main(String[] args) {

            String s = "a+b*(c-d)/e";
        System.out.println(LocalDateTime.now().toString());
            System.out.println(generatePostFix(s)+ " "+LocalDateTime.now().toString());

    }

    private static String generatePostFix(String s) {
        StringBuffer resultBuffer = new StringBuffer();
        Stack<Character> myStack = new Stack<Character>();
        HashMap<Character,Integer> precedenceMap = getPrecedenceMap();
        for (int i = 0; i < s.length(); i++) {
            if(Character.isLetter(s.charAt(i))){
                resultBuffer.append(s.charAt(i));
            }
            else if((s.charAt(i) == '(') ||
                    (s.charAt(i) == ')')){
                if((s.charAt(i) == '(')){
                    myStack.push(s.charAt(i));
                }
                else{
                    while(!myStack.isEmpty() && myStack.peek()!='('){
                        resultBuffer.append(myStack.pop());
                    }
                    if(myStack.peek()=='('){
                        myStack.pop();
                    }
                }
            }else{
                while(!myStack.isEmpty() && precedenceMap.containsKey(myStack.peek()) && precedenceMap.get(s.charAt(i))>precedenceMap.get(myStack.peek())){
                    resultBuffer.append(myStack.pop());
                }
                myStack.push(s.charAt(i));
            }
        }
        while(!myStack.isEmpty()){
            resultBuffer.append(myStack.pop());
        }
        return resultBuffer.toString();
    }

    static HashMap<Character,Integer> getPrecedenceMap(){
        HashMap<Character, Integer> integerCharacterPrecedenceHashMap = new HashMap<>();
        integerCharacterPrecedenceHashMap.put('^',1);
        integerCharacterPrecedenceHashMap.put('*',2);
        integerCharacterPrecedenceHashMap.put('/',3);
        integerCharacterPrecedenceHashMap.put('+',4);
        integerCharacterPrecedenceHashMap.put('-',5);
        return integerCharacterPrecedenceHashMap;
    }
}
