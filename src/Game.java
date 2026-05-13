import java.util.Timer;
import java.util.TimerTask;

public class Game {
    int cookies;
    int cookiesPerClick;
    int bonusCookiesPerSecond;
    Building multiplier = new Building("mult",5);
    Timer gameTimer;

    public Game() {
        this.cookies = 0;
        this.cookiesPerClick = 1;
        this.bonusCookiesPerSecond = 0;
        gameTimer = new Timer();
        TimerTask gameUpdates = new TimerTask() {
            @Override
            public void run() {
                cookies+=bonusCookiesPerSecond;
            }
        };
        gameTimer.schedule(gameUpdates,1000,100);
    }

    public void click() {
        cookies+=cookiesPerClick;
    }

    public boolean buyBuilding(String bldgType) {
        if (bldgType.equals("bdlg1")) {
            if (cookies < multiplier.getPrice()) return false;
            cookies-= (int) multiplier.getPrice();
            multiplier.count++;
            cookiesPerClick++;
            return true;
        } else if (bldgType.equals("bdlg2")) {
            if (cookies < multiplier.getPrice()*4) return false;
            cookies-= (int) multiplier.getPrice()*4;
            multiplier.count*=2;
            bonusCookiesPerSecond++;
            return true;
        }
        return false;
    }

    public int cookiesPerSecond(int cps) {


        return cps;
    }


}
