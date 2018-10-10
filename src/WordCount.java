class WordCount {
  int count;
  String word;
  public WordCount(int count, String word) {
    this.count=count;
    this.word=word;
  }
  public String toString() {
    return "word "+ word+ " has been found "+count+ " times";
  }
}
