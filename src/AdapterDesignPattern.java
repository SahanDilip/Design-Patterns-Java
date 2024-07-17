class AdvancedMediaPlayer{
    public void playMp4() {
        System.out.println("Playing Mp4");
    }
}
interface MediaPlayer{
    public void play();
}
class MediaAdapter implements MediaPlayer{
    AdvancedMediaPlayer advancedMediaPlayer = new AdvancedMediaPlayer();
    @Override
    public void play() {
        advancedMediaPlayer.playMp4();

    }
}
public class AdapterDesignPattern {
    public static void main(String[] args) {
        MediaPlayer m1 = new MediaAdapter();
        m1.play();
    }
}
