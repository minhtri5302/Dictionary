package UX;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
public class DictionaryPronunciation {

    public void textToSpeech(String text){
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        Voice voice = VoiceManager.getInstance().getVoice("kevin16");
        voice.allocate();
        try {
            //voice.setRate(190); wpm. word per minute
            //voice.setPitch(150);
            //voice.setVolume(10);
            voice.speak(text);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        voice.deallocate();
    }
    public static void main(String[] args) {
        DictionaryPronunciation DP = new DictionaryPronunciation();
        DP.textToSpeech("Fuck");
    }
}
