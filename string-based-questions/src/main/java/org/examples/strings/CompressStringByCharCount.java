package org.examples.strings;

public class CompressStringByCharCount {
    public static void main(String args[]) {
        String input = "weeeeeeeeeeeeeeeeeeeeeeeeeeeeelcome to programming";
        //ArrayList<Character> array = new ArrayList<>();
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < input.length(); ) {
            int count = 0;
            for (int j = i; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    count++;
                } else {
                    break;
                }
            }
            newString.append(input.charAt(i));
            newString.append(count);
            //List<Character> charsList = (new StringBuilder().append(count).toString()).chars().mapToObj(x -> (char) x).collect(Collectors.toList());
            //array.addAll(charsList);
            i = i + count;
        }
        System.out.println(newString.toString());
    }
}
