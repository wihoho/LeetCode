/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 28/3/2016.
 */
public class ExcelColumnTitle {

    public String convertToTitle(int n) {
        StringBuffer sb = new StringBuffer();

        while (n > 0) {
            int temp = n % 26;
            if (temp == 0) {
                temp = 26;
            }
            sb.insert(0, (char) (temp + 'A' - 1));

            n /= 26;
            if (temp == 26) {
                n = n - 1;
            }

        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ExcelColumnTitle excelColumnTitle = new ExcelColumnTitle();
        String result = excelColumnTitle.convertToTitle(53);

        System.out.println();

    }

}
