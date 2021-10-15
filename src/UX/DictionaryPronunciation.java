package UX;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
public class DictionaryPronunciation {

    public void textToSpeech(String text){
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        Voice voice = VoiceManager.getInstance().getVoice("kevin16");
        voice.allocate();
        voice.speak(text);
        voice.deallocate();
    }
}
