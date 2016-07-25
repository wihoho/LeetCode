/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 9/5/2016.
 */
public class NimGame {

    public boolean canWinNim(int n) {
        if (n <= 3) return true;
        if (n == 4) return false;

        return canWinNim(n - 1) || canWinNim(n - 2) || canWinNim(n - 3);
    }

    public static void main(String[] args) {
        NimGame nimGame = new NimGame();

        for(int i = 1; i <=10; i++) {
            System.out.println(nimGame.canWinNim(i));
        }
    }

}
