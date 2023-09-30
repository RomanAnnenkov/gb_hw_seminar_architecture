package seminarThree;

import seminarThree.model.excersize.ExcersizeFactory;
import seminarThree.model.excersize.IExcersizeFactory;
import seminarThree.model.workout.Workout;
import seminarThree.view.ConsoleView;
import seminarThree.view.IView;

public class Main {
    public static void main(String[] args) {
        // Разработать одну или несколько программ на выбранном языке программирования
        // (например, Java или Python), демонстрирующих применение принципов SOLID.
        // Сопроводить разработку созданием UML-диаграммы,
        // которая будет отображать ключевые компоненты системы и их взаимосвязи.
        Workout workout = new Workout();
        IExcersizeFactory iExcersizeFactory = new ExcersizeFactory();
        IView iView = new ConsoleView(workout, iExcersizeFactory);
        iView.run();

    }
}
