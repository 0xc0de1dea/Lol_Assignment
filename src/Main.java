import champions.Annie;
import champions.Garen;
import champions.Lux;
import champions.Teemo;
import champions.mypackage.Champion;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Champion garen = new Garen("가렌", 1, 690 ,69, 0, 98, 0.625, (long)(1000 / 0.625), 5, 0.1, 0, 30, 8000, 30, 1000, 0, 0);
        Champion annie = new Annie("애니", 1, 560, 50, 50, 96, 0.61, (long)(1000 / 0.61), 3, 0.1, 0, 80, 4000, 40, 1000, 0, 0);
        Champion lux = new Lux("럭스", 1, 580, 54, 50, 99, 0.625, (long)(1000 / 0.625), 4, 0.1, 0, 80, 9000, 40, 1000, 0, 0);
        Champion teemo = new Teemo("티모", 1, 615, 54, 50, 104, 0.69, (long)(1000 / 0.69), 3, 0.1, 0, 80, 7000, 45, 1000, 0, 0);

        ArrayList<Champion> champions = new ArrayList<>();
        champions.add(garen);
        champions.add(annie);
        champions.add(lux);
        champions.add(teemo);

        Random rand = new Random();
        int rand1 = rand.nextInt(champions.size());
        int rand2 = rand.nextInt(champions.size());

        while (rand1 == rand2){
            rand2 = rand.nextInt(champions.size());
        }

        ArrayList<Champion> vs = new ArrayList<>();
        vs.add(champions.get(rand1));
        vs.add(champions.get(rand2));

        System.out.println("=================== 시뮬레이션 시작 ==================");
        ScheduledExecutorService loop = Executors.newSingleThreadScheduledExecutor();

        while (true){
            Champion champion1 = vs.get(0);
            Champion champion2 = vs.get(1);

            loop.scheduleAtFixedRate(() -> {
                champion1.attack(champion2);
                champion1.useQ(champion2);

                champion2.attack(champion1);
                champion2.useQ(champion1);

                if (champion1.getHp() <= 0 || champion2.getHp() <= 0) loop.shutdownNow();
            }, 0, 100, TimeUnit.MILLISECONDS);

            if (champion1.getHp() <= 0 || champion2.getHp() <= 0) break;
        }

        System.out.println("=================== 시뮬레이션 종료 ==================");
        System.out.println("승자 : " + (vs.get(0).getHp() <= 0 ? vs.get(1).getName() : vs.get(0).getName()));
        return;
    }
}
