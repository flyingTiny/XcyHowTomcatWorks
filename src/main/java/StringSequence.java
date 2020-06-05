public class StringSequence {
    public static void main(String[] args) {
        System.out.println(f("z zz zzz"));
    }

    private static String f(String original) {
        char[] chars = original.toCharArray();
        recursiveHandle(chars, chars.length - 1);
        return new String(chars);
    }

    private static void recursiveHandle(char[] chars, int indexToInc) {
        if (indexToInc < 0) {
            return;
        }
        if (chars[indexToInc] < 'z') {
            chars[indexToInc] = (char) (chars[indexToInc] + 1);
        } else {
            chars[indexToInc] = 'a';
            recursiveHandle(chars, indexToInc - 1);
        }
    }
}
