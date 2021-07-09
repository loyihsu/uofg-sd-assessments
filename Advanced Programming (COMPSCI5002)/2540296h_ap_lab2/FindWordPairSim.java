public class FindWordPairSim {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("FindWordPairSim: usage java FindWordPairSim <word_1> <word_2>");
            return;
        }

        Word2Vec wvec = Word2Vec.load("dumped.txt");
        System.out.println(wvec.getSim(args[0], args[1]) + "                       ");
    }
}
