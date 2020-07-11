public class Rocket {
    public static void main(String[] args) {
        System.out.println(rocketActionFunc(100));
    }

    public static double rocketActionFunc(long[] position){
        final long fuel = position[0];
        final long speed = position[1];

        if (fuel < 0 && speed < 0){
            return -(fuel * speed);
        }
        else if (fuel < 0){
            return fuel;
        }
        else if (speed < 0){
            return speed;
        }

        final double val = fuel * 0.7 + (speed * 7.5);

        if (fuel > 100){
            return 100 - speed;
        } else{
            long action = fuel * (100 + speed) / 100;
            return action;
        }
    }
}
