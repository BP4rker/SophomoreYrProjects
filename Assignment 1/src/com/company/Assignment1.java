package com.company;
public class Assignment1 {
    //Creates a method that is called by the Assignment1Test java file to check
    public static boolean stackPermutation(int[] n) {
        //Uses constructor to make 2 queues
        ArrayQueue<Integer> inputQueue = new ArrayQueue<>();
        ArrayQueue<Integer> outputQueue = new ArrayQueue<>();
        //For each loop that fills the outputQueue with n (the numbers imported by AssignmentTest1
        for (int i : n) {
            outputQueue.enqueue(i);
        }
        //For loop that fills inputQueue with n in ascending order
        for (int i = 1; i < n.length +1; i++) {
            inputQueue.enqueue(i);
            }
        //Uses constructor to create middleStack
        ArrayStack<Integer> middleStack = new ArrayStack<>();
        //While loop that ensures that every element in inputQueue is iterated through
        while (!inputQueue.isEmpty())
        {
            //Sets a variable to the dequeued element of the inputQueue
            Integer num = inputQueue.dequeue();
            //Checks to see if the first number is the same as the dequeued number and dequeues if it is
            if (num == outputQueue.first())
            {
                outputQueue.dequeue();
                //Checks to see if the middleStack is empty and compares the middle stack to the outputQueue
                while (!middleStack.isEmpty())
                {
                    if (middleStack.top() == outputQueue.first())
                    {
                        //If the elements are equal, both elements are removed
                        middleStack.pop();
                        outputQueue.dequeue();
                    }
                    else{
                        break;
                    }
                }
            }
            //If the queues aren't the same, pushes num to the middleStack
            else{
                middleStack.push(num);
            }
        }
        //If both queues are empty by the end, then there was a permutation
        return inputQueue.isEmpty()&&outputQueue.isEmpty();
    }
}
