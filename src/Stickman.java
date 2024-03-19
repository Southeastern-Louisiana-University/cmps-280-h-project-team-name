public class Stickman {

    public String stickman (int stage) {
        String message = "\\ \n" + " \\ \n" + "  | \n" + "  |\n";

        if (stage == 0) {
            return message;
        } else if (stage == 1) {
            message += " ( )\n";
            return message;
        } else if (stage == 2) {
            message += " ( )\n";
            message += " \\|";
            return message;
        } else if (stage == 3) {
            message += " ( )\n";
            message += " \\|";
            message += "/\n";
            return message;
        } else if (stage == 4) {
            message += " ( )\n";
            message += " \\|";
            message += "/\n";
            message += "  |\n";
            return message;
        } else if (stage == 5) {
            message += " ( )\n";
            message += " \\|";
            message += "/\n";
            message += "  |\n";
            message += " /";
            return message;
        } else if (stage == 6) {
            message += " ( )\n";
            message += " \\|";
            message += "/\n";
            message += "  |\n";
            message += " /";
            message += " \\";
            return message;
        }
        return message;
    }

}
