public class Main {

    public static void main(String[] args) {
        UI ui = new UI();
        ui.buttonMethod();
        ui.displayThread.run();
       // ui.buzzerThread.run();

        //@SuppressWarnings("unused")
       // ClockUpdate clockUpdate = new ClockUpdate(ui);

    }
}
