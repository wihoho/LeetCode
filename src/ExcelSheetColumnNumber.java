/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 31/3/2016.
 */
public class ExcelSheetColumnNumber {

    public int titleToNumber(String s) {
        int result = 0;
        for(Character c: s.toCharArray()) {
            int cur = c - 'A' + 1;
            result = result * 26 + cur;
        }

        return result;
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber excelColumnTitle = new ExcelSheetColumnNumber();
        int result = excelColumnTitle.titleToNumber("AZ");
        System.out.println();
    }
}
