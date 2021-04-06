package algs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: peiyilin
 * @description: 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * @date: 2021/3/29 19:16
 */
public class ParenthesisCode {

    public List<String> generateParenthesis(int n){
        List<String> res = new ArrayList<>();
        generate(0,0,n,"",res);
        return res;
    }

    /**
     * 生成括号
     * @param left 左括号个数
     * @param right 右括号个数
     * @param n 总括号个数
     * @param s 括号字符串
     * @param res
     */
    private void generate(int left, int right, int n, String s, List<String> res) {
        //终止条件
        if (left ==n && right==n){
            res.add(s);
            return;
        }
        //处理过程,生成括号
        String s1= s+"(";
        String s2= s+")";
        //向下递归，自调用
        //先生成左括号，才能保证有效性
        if (left<n){
            generate(left+1,right,n,s1,res);
        }
        if (right < left){
            generate(left,right+1,n,s2,res);
        }
    }

    public static void main(String[] args) {
        ParenthesisCode test = new ParenthesisCode();
        List<String> list = test.generateParenthesis(3);
        System.err.println(list);
    }
}
