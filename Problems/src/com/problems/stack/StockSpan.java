package com.problems.stack;

public class StockSpan {

    public static void main(String[] args) throws Exception{
            int[] stocks = {100,80,60,70,60,75,85};
            calculateStockSpan(stocks);
    }

    private static void calculateStockSpan(int[] stocks) throws StackUnderFlowException {
        StackWithLinkedList stackWithLinkedList = new StackWithLinkedList();

        for (int i = 0; i < stocks.length; i++) {

            while(!stackWithLinkedList.isEmpty() && stocks[stackWithLinkedList.peek()]< stocks[i]){
                stackWithLinkedList.pop();
            }

            if(stackWithLinkedList.isEmpty()){
                System.out.println(i+1);
            }else{
                System.out.println(i-stackWithLinkedList.peek());
            }
            stackWithLinkedList.push(i);
        }
    }
}
