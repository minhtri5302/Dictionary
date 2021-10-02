public class DictionaryCommandLine {
    private DictionaryManagement dictionaryManagement = new DictionaryManagement();

    public void showAllWords() {
        Dictionary dictionary = dictionaryManagement.getDictionary();
        System.out.format("%-5s%-20s%-20s\n", "No", "|English", "|Vietnamese");
        for (int i = 0; i < dictionary.getNumWord(); i++) {
            System.out.format("%-5s%-20s%-20s\n", i + 1, dictionary.wordList[i].getWord_target(), dictionary.wordList[i].getWord_explain());
        }
    }

    public void dictionaryBasic() {
        dictionaryManagement.insertFromCommandline();
        showAllWords();
    }

    public void dictionaryAdvanced() {
        dictionaryManagement.insertFromFile();
        showAllWords();
        dictionaryManagement.dictionaryLookup();
    }

    public static void main(String[] args) {
        DictionaryCommandLine p = new DictionaryCommandLine();
        p.dictionaryAdvanced();
    }
    //
    //Trii
    //Dan
}
