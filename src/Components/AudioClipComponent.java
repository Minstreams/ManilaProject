package Components;

import Systems.ComponentSystem;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 声音组件
 */
public class AudioClipComponent extends ComponentSystem {
    private AudioStream audioStream;//声音数据流
    private boolean playOnStart = false;//是否开始就播放

    public AudioClipComponent(String audioName, boolean playOnStart) {
        this.playOnStart = playOnStart;
        try {
            audioStream = new AudioStream(new FileInputStream(System.getProperty("user.dir") + "\\src\\" + audioName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @Override
    protected void function() {

    }

    @Override
    public void start() {
        if (playOnStart) {
            Play();
        }
    }

    public void Play() {
        AudioPlayer.player.start(audioStream);
    }

    public void Stop() {
        AudioPlayer.player.stop(audioStream);
    }

    @Override
    public void OnDestroy() {
        super.OnDestroy();
        Stop();
        try {
            audioStream.close();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
