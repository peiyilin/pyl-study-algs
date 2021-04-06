package algs;

/**
 * @author: peiyilin
 * @description: 验证回文串
 * @date: 2021/4/6 14:57
 */
public class IsPalindrome {

    public boolean isPalindrome(String s) {
        if(s.length() == 0){
            return true;
        }
        int left=0,right=s.length()-1;
        while(left < right){
            //过滤非数字和字母的字符
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        boolean palindrome = isPalindrome.isPalindrome("A man, a plan, a canal: Panama");
        System.err.println(palindrome);
    }
}
