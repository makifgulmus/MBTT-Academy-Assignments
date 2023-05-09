public class IstanbulRunfest {
    public static class Runner {
        public String runnerName;
        public int runnerTime;

        public Runner(String name, int time) {
            this.runnerName = name;
            this.runnerTime = time;
        }
    }

    public static Runner calculateFastestRunner(Runner[] runners) {
        if (runners.length == 0) {
            System.out.println("Runners array is empty!");
            return null;
        }
        Runner fastestRunner = runners[0];
        for (int i = 1; i < runners.length; i++) {
            if (runners[i].runnerTime < fastestRunner.runnerTime) {
                fastestRunner = runners[i];
            }
        }
        return fastestRunner;
    }

    public static Runner calculateSecondFastest(Runner[] runners) {
        if (runners.length == 0) {
            System.out.println("Runners array is empty!");
            return null;
        } else if (runners.length == 1) {
            System.out.println("There is only one runner!");
            return null;
        }

        Runner fastest = runners[0];
        Runner secondFastest = runners[1];
        
        for (int i = 1; i < runners.length; i++) {
            if (runners[i].runnerTime < fastest.runnerTime) {
                secondFastest = fastest;
                fastest = runners[i];
            } else if (runners[i].runnerTime < secondFastest.runnerTime) {
                secondFastest = runners[i];
            }
        }
        return secondFastest;
    }

    public static void main(String[] args) {
        Runner[] runners = {
            new Runner("Ibrahim", 272),
            new Runner("Berke", 479),
            new Runner("Metin", 278),
            new Runner("Irem", 329),
            new Runner("Yigit", 445),
            new Runner("Melis", 402),
            new Runner("Mehmet", 388),
            new Runner("Akif", 275),
            new Runner("Furkan", 243),
            new Runner("Fırat", 334),
            new Runner("Tolga", 412),
            new Runner("Ozkan", 393),
            new Runner("Umut", 299),
            new Runner("Seda", 343),
            new Runner("Selcan", 317),
            new Runner("Hatice", 265),
        };
        Runner fastestRunner = calculateFastestRunner(runners);
        System.out.println("The fastest runner is " + fastestRunner.runnerName + 
        " with a time of " + fastestRunner.runnerTime + " seconds.");

        Runner secondFastest = calculateSecondFastest(runners);
        System.out.println("The second fastest runner is " + secondFastest.runnerName + 
        " with a time of " + secondFastest.runnerTime + " seconds.");
    }

    

   
}