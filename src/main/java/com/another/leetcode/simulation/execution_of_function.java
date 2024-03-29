package com.another.leetcode.simulation;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class execution_of_function {
    class Program{
        int id;
        int start;
        int runTimes;
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        int[]data = new int[n];
        String[] first = logs.get(0).split(":");

        Program head = new Program();

        head.id=Integer.parseInt(first[0]);
        head.start=Integer.parseInt(first[2]);
        head.runTimes=0;

        Stack<Program>cpu = new Stack<>();
        cpu.push(head);

        for(int i=1;i<logs.size();i++){
            String[] tmp = logs.get(i).split(":");

            if(cpu.isEmpty()==true){
                Program head1 = new Program();

                head1.id=Integer.parseInt(tmp[0]);
                head1.start=Integer.parseInt(tmp[2]);
                cpu.add(head1);
            }else{

                int now = Integer.parseInt(tmp[2]);


                if("end".equals(tmp[1])){
                    Program p = cpu.pop();
                    p.runTimes+=(now-p.start+1);
                    data[p.id]+=p.runTimes;

                    //启动最新的程序，即更新时间
                    if(cpu.isEmpty()==false){
                        Program newP = cpu.peek();
                        newP.start=now+1;
                    }
                }else{
                    Program c = new Program();
                    c.id=Integer.parseInt(tmp[0]);
                    c.start=Integer.parseInt(tmp[2]);
                    c.runTimes=0;

                    if(cpu.isEmpty()==false){
                        Program top = cpu.peek();
                        top.runTimes+= (now-1-top.start+1);
                    }
                    cpu.push(c);
                }


            }
        }
        new StringBuilder().charAt(0);

        return data;
    }


    public String solveEquation(String equation) {
        String[]exp =equation.split("=");

        int number_of_x=0;
        int number_of_const=0;

        StringBuilder sb =new StringBuilder();
        for(int i=0;i<exp[0].length();i++){
            char c = exp[0].charAt(i);
            if(c=='+'||c=='-'){
                //既要处理已有值，下一个·值还要处理符号
                String tmp = sb.toString();
                if(tmp.indexOf('x')!=-1){
                    tmp=tmp.substring(0,tmp.length()-1);
                    int number=0;
                    if(tmp.length()==0)number=1;
                    if(tmp.length()==1){
                        if(tmp.charAt(0)=='+')number=1;
                        else if(tmp.charAt(0)=='-')number=-1;
                        else number=Integer.parseInt(tmp);

                    }
                    if(tmp.length()>1)number=Integer.parseInt(tmp);
                    number_of_x+=number;
                }else{
                    int number;
                    if(tmp.length()==0){number=0;}
                    else number=Integer.parseInt(tmp);
                    number_of_const+=number;
                }
                sb.delete(0,sb.length());
                sb.append(c);

            }else{
                sb.append(c);
            }
        }

        if(sb.length()!=0){
            String tmp = sb.toString();
            if(tmp.indexOf('x')!=-1){
                tmp=tmp.substring(0,tmp.length()-1);
                int number=0;
                if(tmp.length()==0)number=1;
                if(tmp.length()==1){
                    if(tmp.charAt(0)=='+')number=1;
                    else if(tmp.charAt(0)=='-')number=-1;
                    else number=Integer.parseInt(tmp);
                }
                if(tmp.length()>1)number=Integer.parseInt(tmp);
                number_of_x+=number;
            }else{
                int number;
                if(tmp.length()==0){number=0;}
                else number=Integer.parseInt(tmp);
                number_of_const+=number;
            }
        }
        sb.delete(0,sb.length());



        for(int i=0;i<exp[1].length();i++){
            char c = exp[1].charAt(i);
            if(c=='+'||c=='-'){
                //既要处理已有值，下一个·值还要处理符号
                String tmp = sb.toString();
                if(tmp.indexOf('x')!=-1){
                    tmp=tmp.substring(0,tmp.length()-1);
                    int number=0;
                    if(tmp.length()==0)number=1;
                    if(tmp.length()==1){
                        if(tmp.charAt(0)=='+')number=1;
                        else if(tmp.charAt(0)=='-')number=-1;
                        else number=Integer.parseInt(tmp);
                    }
                    if(tmp.length()>1)number=Integer.parseInt(tmp);
                    number_of_x-=number;
                }else{
                    int number;
                    if(tmp.length()==0){number=0;}
                    else number=Integer.parseInt(tmp);
                    number_of_const-=number;
                }
                sb.delete(0,sb.length());
                sb.append(c);

            }else{
                sb.append(c);
            }
        }

        if(sb.length()!=0){
            String tmp = sb.toString();
            if(tmp.indexOf('x')!=-1){
                tmp=tmp.substring(0,tmp.length()-1);
                int number=0;
                if(tmp.length()==0)number=1;
                if(tmp.length()==1){
                    if(tmp.charAt(0)=='+')number=1;
                    else if(tmp.charAt(0)=='-')number=-1;
                    else number=Integer.parseInt(tmp);
                }
                if(tmp.length()>1)number=Integer.parseInt(tmp);
                number_of_x-=number;
            }else{
                int number=Integer.parseInt(tmp);
                number_of_const-=number;
            }
        }


        if(number_of_x==0){
            if(number_of_const==0)return "Infinite solutions";
            return "No solution";
        }
        Integer result = (-number_of_const)/number_of_x;
        return "x="+result;




    }

    public static void main(String[] args) {

        System.out.println(new execution_of_function().solveEquation("2-x+x+3x=2x-x+x+3"));
        System.out.println(Integer.parseInt("+23"));

        System.out.println(Arrays.toString(new execution_of_function().exclusiveTime(1, Arrays.asList("0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7"))));
    }
}

