/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 28/3/2016.
 */
public class CompareVersionNumber {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int index1 = 0;
        int index2 = 0;

        while (index1 < v1.length || index2 < v2.length) {
            int a = index1 < v1.length ? Integer.valueOf(v1[index1]) : 0;
            int b = index2 < v2.length ? Integer.valueOf(v2[index2]) : 0;

            if (a < b) return -1;
            else if (a > b) return 1;

            index1++;
            index2++;
        }

        return 0;
    }
}
