package java1.lesson6;

import java1.lesson6.obstacles.Obstacles;
import java1.lesson6.obstacles.Pool;
import java1.lesson6.obstacles.Road;
import java1.lesson6.obstacles.Wall;

public class ObstacleCourse {

    Obstacles[] obstacles;

    public ObstacleCourse(Obstacles[] obstacles) {
        this.obstacles = obstacles;
    }

    public boolean completeObstacles(Animal animal){
        for (Obstacles obstacle: obstacles){
            if(obstacle instanceof Road) {
                if(!animal.run(obstacle.getLength())) return false;
            }
            else if(obstacle instanceof Wall) {
                if(!animal.jump(obstacle.getLength())) return false;
            }
            else if(obstacle instanceof Pool) {
                if(!animal.swim(obstacle.getLength())) return false;
            }
        }
        return true;
    }


}
