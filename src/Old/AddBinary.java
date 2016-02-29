package Old;

/**
 * Created by GongLi on 20/5/15.
 */
public class AddBinary {

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        String result = addBinary.addBinary("11", "1");
        System.out.println(result);
    }

    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1;

        StringBuffer result = new StringBuffer();

        int adder = 0;
        int m, n;
        while (i > -1 && j > -1) {
            m = Integer.valueOf(a.charAt(i) - 48);
            n = Integer.valueOf(b.charAt(j) - 48);

            int temp = m + n + adder;
            adder = temp / 2;
            result.append(temp % 2);

            i--;
            j--;
        }


        if (i == -1) {
            while (j > -1) {

                int temp = adder + Integer.valueOf(b.charAt(j) - 48);
                adder = temp / 2;
                result.append(temp % 2);
                j--;
            }

        } else {

            while (i > -1) {

                int temp = adder + Integer.valueOf(a.charAt(i) - 48);
                adder = temp / 2;
                result.append(temp % 2);

                i--;
            }

        }

        if (adder != 0) {
            result.append(adder);
        }


        return result.reverse().toString();
    }
}
