package patterns.behavioral_patterns.command_withlambda_speaker;

public class Main {
    public static void main(String[] args) {
        Speaker speaker = new SpeakerImpl();

        App app = new App();

//        app.add(() -> speaker.play());
//        app.add(() -> speaker.volumeUp());
//        app.add(() -> speaker.volumeUp());
//        app.add(() -> speaker.volumeDown());
//        app.add(() -> speaker.volumeDown());
//        app.add(() -> speaker.pause());

        app.add(speaker::play);
        app.add(speaker::volumeUp);
        app.add(speaker::volumeUp);
        app.add(speaker::volumeDown);
        app.add(speaker::volumeDown);
        app.add(speaker::pause);

        app.run();
    }
}
