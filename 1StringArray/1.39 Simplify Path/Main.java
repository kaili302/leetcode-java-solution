import java.util.*;
public class Main {
    public static void main(String[] args){
        System.out.println(simplifyPath("/..//../sa/../ds"));    
    }
    
    public static String simplifyPath(String path) {
        Stack<String> stack =new Stack();
        String[] fs=path.split("/");
        for(int i=0; i<fs.length; i++){
            if(fs[i].equals("")||fs[i].equals(".")) continue;
            if(fs[i].equals("..") &&!stack.isEmpty())  stack.pop();
            else if(!fs[i].equals("..")) stack.push(fs[i]);
        }
        if(stack.isEmpty()) return "/";
        StringBuilder res=new StringBuilder();
        Iterator<String> iter = stack.iterator();
        while (iter.hasNext())
            res.append("/"+iter.next());
        return res.toString();
    }
}