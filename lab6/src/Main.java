public class Main {
    public static void main(String[] args) {
        CustomList<String>customList = new CustomList<String>();
        CustomList<Type>customListT = new CustomList<Type>();
        Type a = new Type();
        Type b = new Type();
        customList.addLast("a");
        customList.addLast("b");
        customListT.addLast(a);
        customListT.addLast(b);
    }
}