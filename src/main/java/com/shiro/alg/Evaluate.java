
package com.shiro.alg;

import com.shiro.alg.util.StdIn;
import com.shiro.alg.util.StdOut;
import java.util.Stack;

/**
 * <b>描述：双栈表达式计算</b> <br/>
 *
 * <b>时间：</b>2018-11-01<br/>
 *
 */
public class Evaluate {

    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();

        System.out.print("input the expression(ctrl+d to evaluate)-->:");
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            switch (s) {
            case "(":
                break;
            case "+":
            case "-":
            case "*":
            case "/":
            case "sqrt":
                ops.push(s);
                break;
            case ")":
                caculate(ops, vals);
                break;
            default:
                vals.push(Double.parseDouble(s));
            }
        }
        System.out.print("result-->:");
        StdOut.print(vals.pop());
    }

    private static void caculate(Stack<String> ops, Stack<Double> vals) {
        Double v = vals.pop();
        String op = ops.pop();
        Double result = 0.0;
        switch (op) {
        case "+":
            result = vals.pop() + v;
            break;
        case "-":
            result = vals.pop() - v;
            break;
        case "*":
            result = vals.pop() * v;
            break;
        case "/":
            result = vals.pop() / v;
            break;
        case "sqrt":
            result = Math.sqrt(v);
            break;
        default:
            throw new UnsupportedOperationException("不支持的运算");
        }
        vals.push(result);
    }

}