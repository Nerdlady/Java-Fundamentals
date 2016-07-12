import moods.*;

public class MoodFactory {

    public static Mood createMood(int points){
        if (points < -5){
            return new AngryMood();
        } else if(points <=0){
            return new SadMood();
        } else if(points <= 15){
            return new Happy();
        } else {
            return new JavaScriptMood();
        }
    }
}
