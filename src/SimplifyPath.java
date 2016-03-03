import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 1/3/2016.
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        int prev = -1;

        List<String> components = new ArrayList<>();
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                if (prev >= 0) {
                    components.add(path.substring(prev + 1, i));
                }

                prev = i;
            }
        }

        if (prev >= 0) {
            components.add(path.substring(prev+1));
        }

        List<String> filter = new ArrayList<>();
        for (String item : components) {
            if (item.equals(".")) {
                continue;
            }

            if (item.equals("..")) {
                if (!filter.isEmpty()) {
                    filter.remove(filter.size() - 1);
                }
            } else if (item.length() > 0){
                filter.add(item);
            }
        }

        StringBuffer sb = new StringBuffer();
        for(String item:filter) {
            sb.append("/");
            sb.append(item);
        }

        if (sb.length() == 0) {
            return "/";
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        SimplifyPath simplifyPath = new SimplifyPath();
        System.out.println(simplifyPath.simplifyPath("/..."));
    }
}
