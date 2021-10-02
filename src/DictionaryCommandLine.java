public class DictionaryCommandLine {
    DictionaryManagement dictionaryManagement = new DictionaryManagement();

    public void showAllWords() {
        System.out.println("No   | English     | Vietnamese\n");
        for (int i = 1; i <= dictionaryManagement.dictionary.numWord; i++) {
            System.out.println(i + "    | "
                    +
                    dictionaryManagement.dictionary.wordList[i].getWord_target()
                    +
                    "     | "
                    +
                    dictionaryManagement.dictionary.wordList[i].getWord_explain() + "\n");
        }
    }

    public void dictionaryBasic() {
        dictionaryManagement.insertFromCommandline();
        showAllWords();
    }

    public static void main(String[] args) {
        DictionaryCommandLine p = new DictionaryCommandLine();
        p.dictionaryBasic();
        //Triii
    }
}
