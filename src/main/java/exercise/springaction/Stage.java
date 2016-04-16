package exercise.springaction;

/**
 * Created by tingfang.liu on 2016/4/1.
 */
public class Stage {
    private Stage() {
        System.out.println("Singelton init!");
    }

    private static class StageHolder {
        static Stage stage = new Stage();
    }

    public static Stage getInstance() {
        return StageHolder.stage;
    }
}
