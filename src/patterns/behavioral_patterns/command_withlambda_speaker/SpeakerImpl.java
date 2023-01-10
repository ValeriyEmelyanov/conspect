package patterns.behavioral_patterns.command_withlambda_speaker;

public class SpeakerImpl implements Speaker {
    @Override
    public void volumeUp() {
        System.out.println("Volume up");
    }

    @Override
    public void volumeDown() {
        System.out.println("Volume down");
    }

    @Override
    public void play() {
        System.out.println("Play");
    }

    @Override
    public void pause() {
        System.out.println("Pause");
    }
}
