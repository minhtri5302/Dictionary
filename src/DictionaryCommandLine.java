public class DictionaryCommandLine {
  DictionaryManagement x = new DictionaryManagement();
  public void showAllWords(){
    System.out.println("No   | English     | Vietnamese\n");
    for (int i = 1; i <= x.s.so_tu; i++) {
      System.out.println(i + "    | " + x.s.a[i].getWord_target() + "     | " + x.s.a[i].getWord_explain() + "\n");
    }
  }
  public void dictionaryBasic() {
    DictionaryCommandLine p = new DictionaryCommandLine();
    p.x.insertFromCommandline();
    p.showAllWords();
  }
  public static void main(String[] args) {
    DictionaryCommandLine p = new DictionaryCommandLine();
    p.dictionaryBasic();
  }
}
/*
3
con
ga
con
bo
con
cho
 */