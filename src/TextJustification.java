import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 20/1/2016.
 */
public class TextJustification {
    public static void main(String[] args) {
        TextJustification textJustification = new TextJustification();
//        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        String[] words = {"What", "must", "be", "shall", "be."};

        List<String> result = textJustification.fullJustify(words, 12);

        System.out.println();
    }


    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();
        if (Objects.isNull(words) || words.length == 0 || maxWidth < 0) {
            return result;
        }
        int currentSize = 0;

        List<String> line = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (currentSize + line.size() + words[i].length() <= maxWidth) {
                currentSize += words[i].length();
                line.add(words[i]);
            } else {
                // one word in the current line
                StringBuffer sb = null;
                if (line.size() == 1) {
                    sb = new StringBuffer(line.get(0));
                    for (int m = line.get(0).length(); m < maxWidth; m++) sb.append(" ");
                } else {
                    // more than one word
                    int divisor = (maxWidth - currentSize) / (line.size() - 1);
                    int remainder = (maxWidth - currentSize) % (line.size() - 1);
                    sb = new StringBuffer();
                    for (int j = 0; j < line.size(); j++) {
                        sb.append(line.get(j));

                        if (j != line.size() - 1) {
                            for (int m = 1; m <= divisor; m++) {
                                sb.append(" ");
                            }
                        }
                        if (remainder > 0) {
                            sb.append(" ");
                            remainder--;
                        }
                    }
                }

                result.add(sb.toString());
                line = new ArrayList<>();
                line.add(words[i]);
                currentSize = words[i].length();
            }
        }

        if (!line.isEmpty()) {
            StringBuffer sb = null;
            if (line.size() == 1) {
                sb = new StringBuffer(line.get(0));
                for (int m = line.get(0).length(); m < maxWidth; m++) sb.append(" ");
            } else {
                // more than one word
                sb = new StringBuffer();
                for (int j = 0; j < line.size(); j++) {
                    sb.append(line.get(j));
                    sb.append(" ");
                }

                for (int m = sb.length(); m < maxWidth; m++) sb.append(" ");

            }

            result.add(sb.toString());
        }

        return result;
    }
}
